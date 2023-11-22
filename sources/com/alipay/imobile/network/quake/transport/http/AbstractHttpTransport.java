package com.alipay.imobile.network.quake.transport.http;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.QuakeConfig;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.cache.Cache;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.exception.ServerException;
import com.alipay.imobile.network.quake.f;
import com.alipay.imobile.network.quake.rpc.RpcRequest;
import com.alipay.imobile.network.quake.transport.HttpDate;
import com.alipay.imobile.network.quake.transport.TrafficFlowMonitor;
import com.alipay.imobile.network.quake.transport.Transporter;
import com.alipay.imobile.network.quake.transport.TransporterCallBack;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.alipay.imobile.network.quake.transport.storage.ByteArrayPool;
import com.alipay.imobile.network.quake.transport.storage.PoolingByteArrayOutputStream;
import com.alipay.imobile.network.quake.transport.strategy.RetryPolicy;
import com.alipay.imobile.network.quake.util.NetworkUtils;
import com.alipay.imobile.network.quake.util.SignUtil;
import com.alipay.imobile.network.quake.util.e;
import com.alipay.mobile.common.rpc.RpcException;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public abstract class AbstractHttpTransport implements Transporter {
    protected static final int DEFAULT_CONNECTION_POOL = 5;
    private static final ExecutorService f = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), e.b("Quake http ConnectionPool"));

    /* renamed from: a  reason: collision with root package name */
    private final CookieJar f7061a;
    private final TrafficFlowMonitor b;
    private String c;
    private String d;
    private ExecutorService e;
    protected final Context mAppContext;
    protected final ByteArrayPool mPool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Request f7062a;
        TransporterCallBack b;
        long c;

        @Override // java.lang.Runnable
        public void run() {
            try {
                NetworkResponse executeRequest = AbstractHttpTransport.this.executeRequest(this.f7062a);
                String str = Quake.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("http:requestLifetime,");
                sb.append(SystemClock.elapsedRealtime() - this.c);
                LoggerWrapper.i(str, sb.toString());
                TransporterCallBack transporterCallBack = this.b;
                if (transporterCallBack != null) {
                    transporterCallBack.onCompeleted(this.f7062a, executeRequest);
                }
            } catch (RpcException e) {
                TransporterCallBack transporterCallBack2 = this.b;
                if (transporterCallBack2 != null) {
                    transporterCallBack2.onException(this.f7062a, e);
                }
            }
            this.f7062a = null;
        }

        private b(Request request, TransporterCallBack transporterCallBack, long j) {
            this.f7062a = request;
            this.b = transporterCallBack;
            this.c = j;
        }
    }

    public AbstractHttpTransport() {
        this(4096);
    }

    private String a(List<Cookie> list) {
        LoggerWrapper.d(Quake.TAG, "obtain cookie header");
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    protected static void attemptRetryOnException(String str, Request request, RpcException rpcException) throws RpcException {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(rpcException);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (RpcException e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private void b(Map<String, String> map, Request request) {
        if (map == null || request == null) {
            return;
        }
        String signRequest = signRequest(request);
        if (TextUtils.isEmpty(signRequest)) {
            return;
        }
        map.put("sign", signRequest);
    }

    public static Map<String, String> convertHeaders(HttpHeaders httpHeaders) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int b2 = httpHeaders.b();
        for (int i = 0; i < b2; i++) {
            treeMap.put(httpHeaders.a(i), httpHeaders.b(i));
        }
        return treeMap;
    }

    public static byte[] getCompressedEntity(byte[] bArr) throws IOException {
        LoggerWrapper.i(Quake.TAG, "gzip...");
        if (bArr.length >= 160) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str = Quake.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("gzip size:");
            sb.append(bArr.length);
            sb.append("->");
            sb.append(byteArray.length);
            LoggerWrapper.i(str, sb.toString());
            return byteArray;
        }
        return bArr;
    }

    protected static InputStream getUngzippedContent(InputStream inputStream, String str) throws IOException {
        if (inputStream == null) {
            return null;
        }
        return (!TextUtils.isEmpty(str) && str.contains(HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP)) ? new GZIPInputStream(inputStream) : inputStream;
    }

    protected void addRequestHeaders(Map<String, String> map, Request request) {
        Map<String, String> externalInfo = request.getProtocol().getExternalInfo(request);
        if (externalInfo != null) {
            map.putAll(externalInfo);
        }
        map.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
        map.put(com.google.common.net.HttpHeaders.CONNECTION, com.google.common.net.HttpHeaders.KEEP_ALIVE);
        a(map, request.getCacheEntry());
        a(map, request);
        String a2 = e.a(this.mAppContext);
        if (!TextUtils.isEmpty(a2)) {
            map.put("Accept-Language", a2);
        }
        b(map, request);
        if (e.b(this.mAppContext)) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                sb.append(", ");
            }
            if (LoggerWrapper.isDebuggable()) {
                String replace = sb.toString().replace("%", "");
                String str = Quake.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Added request headers : ");
                sb2.append(replace);
                LoggerWrapper.i(str, sb2.toString());
            }
        }
    }

    protected CookieJar cookieJar() {
        return this.f7061a;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0287 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.alipay.imobile.network.quake.NetworkResponse executeRequest(com.alipay.imobile.network.quake.Request r35) throws com.alipay.mobile.common.rpc.RpcException {
        /*
            Method dump skipped, instructions count: 729
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.transport.http.AbstractHttpTransport.executeRequest(com.alipay.imobile.network.quake.Request):com.alipay.imobile.network.quake.NetworkResponse");
    }

    protected void extractCookiesFromResponse(HttpResponse httpResponse, Request request) throws MalformedURLException {
        CookieJar cookieJar = this.f7061a;
        if (cookieJar == null || cookieJar == CookieJar.NO_COOKIES) {
            LoggerWrapper.d(Quake.TAG, "cancel saving cookie, have no cookie jar");
        } else if (httpResponse != null && request != null) {
            URL url = new URL(request.getUrl());
            List<Cookie> parseAll = Cookie.parseAll(url, httpResponse.a("Set-Cookie"));
            if (parseAll.isEmpty()) {
                LoggerWrapper.d(Quake.TAG, "cancel saving cookie, cause of cookies is empty");
            } else {
                this.f7061a.saveFromResponse(url, parseAll);
            }
        } else {
            LoggerWrapper.d(Quake.TAG, "cancel saving cookie, cause of httpResponse and request is null");
        }
    }

    protected ExecutorService getExecutorService() {
        return this.e;
    }

    public String getUserAgent() {
        return com.alipay.imobile.network.quake.transport.strategy.a.b();
    }

    protected void isNetworkAvailable() throws RpcException {
        if (!NetworkUtils.isNetworkAvailable(this.mAppContext)) {
            throw new ClientException((Integer) 2, NewSwitchFaceAuthenticationView.NETWORK_EXCEPTION);
        }
    }

    protected boolean isTrafficConsumeAccept(String str) {
        TrafficFlowMonitor trafficFlowMonitor = this.b;
        if (trafficFlowMonitor == null) {
            return true;
        }
        return trafficFlowMonitor.isTrafficConsumeAccept(str);
    }

    protected void logRequests(long j, Request request, byte[] bArr, int i) {
        if (LoggerWrapper.isDebuggable()) {
            String str = Quake.TAG;
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            LoggerWrapper.v(str, LoggerWrapper.buildMessage("HTTP response for request=<%s> [lifetime=%d], [size=%s], [status=%d], [retryCount=%s]", objArr));
        }
    }

    protected String obtainCookie(Request request) {
        CookieJar cookieJar = this.f7061a;
        if (cookieJar != null && cookieJar != CookieJar.NO_COOKIES) {
            try {
                return a(cookieJar.loadForRequest(new URL(request.getUrl())));
            } catch (MalformedURLException e) {
                LoggerWrapper.e(Quake.TAG, "", e);
                throw new ClientException((Integer) 9, "can not load cookie");
            }
        }
        LoggerWrapper.d(Quake.TAG, "cancel load cookie, have no cookie jar");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract HttpResponse performRequest(Request request, Map<String, String> map) throws IOException, RpcException;

    protected void setExecutorService(ExecutorService executorService) {
        if (executorService == null) {
            LoggerWrapper.i(Quake.TAG, "ignoring setting executor service because of new executor is null.");
        } else {
            this.e = executorService;
        }
    }

    public void setUserAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.alipay.imobile.network.quake.transport.strategy.a.c(str);
    }

    protected String signRequest(Request request) {
        if (TextUtils.isEmpty(this.c)) {
            this.c = f.o().b();
            this.d = f.o().c();
        }
        SignUtil.SignInfo signInfo = request instanceof RpcRequest ? ((RpcRequest) request).getSignInfo() : null;
        if (signInfo == null) {
            signInfo = new SignUtil.SignInfo(this.c, this.d);
        }
        LoggerWrapper.v(Quake.TAG, "before sign in AbstractHttpTransport");
        return SignUtil.a(request, this.mAppContext, signInfo);
    }

    @Override // com.alipay.imobile.network.quake.transport.Transporter
    public void submitRequest(Request request, TransporterCallBack transporterCallBack) {
        if (request.isCanceled()) {
            return;
        }
        getExecutorService().submit(new b(request, transporterCallBack, SystemClock.elapsedRealtime()));
    }

    protected long writeData(InputStream inputStream, String str, long j, OutputStream outputStream) throws IOException, RpcException {
        if (outputStream != null) {
            if (inputStream != null) {
                InputStream ungzippedContent = getUngzippedContent(new com.alipay.imobile.network.quake.transport.storage.a(inputStream), str);
                if (ungzippedContent != null) {
                    byte[] bArr = null;
                    try {
                        try {
                            bArr = this.mPool.getBuf(2048);
                            while (true) {
                                int read = ungzippedContent.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                outputStream.write(bArr, 0, read);
                                j += read;
                            }
                            outputStream.flush();
                            return j;
                        } catch (Exception e) {
                            LoggerWrapper.e(Quake.TAG, "", e);
                            IOException iOException = new IOException("http transport get data from entity error!");
                            iOException.initCause(e);
                            throw iOException;
                        }
                    } finally {
                        if (bArr != null) {
                            this.mPool.returnBuf(bArr);
                        }
                        if (ungzippedContent != null) {
                            try {
                                ungzippedContent.close();
                            } catch (IOException e2) {
                                LoggerWrapper.e(Quake.TAG, "", e2);
                            }
                        }
                    }
                }
                throw new ServerException((Integer) 6, "the content of the network response is null.");
            }
            throw new ServerException((Integer) 6, "the content of the network response is null.");
        }
        throw new RpcException("Output stream may not be null");
    }

    public AbstractHttpTransport(int i) {
        this.mPool = new ByteArrayPool(i);
        f o2 = f.o();
        this.mAppContext = o2.e();
        QuakeConfig d = o2.d();
        if (d != null) {
            this.f7061a = d.getCookieJar();
            this.b = d.getTrafficFlowMonitor();
        } else {
            this.f7061a = null;
            this.b = null;
        }
        this.e = f;
    }

    private byte[] a(HttpResponseBody httpResponseBody) throws IOException, RpcException {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpResponseBody.contentLength());
        try {
            writeData(httpResponseBody.byteStream(), httpResponseBody.contentEncoding(), 0L, poolingByteArrayOutputStream);
            return poolingByteArrayOutputStream.toByteArray();
        } finally {
            try {
                httpResponseBody.consumeContent();
            } catch (IOException e) {
                LoggerWrapper.e(Quake.TAG, "Error occured when calling consumingContent", e);
            }
            poolingByteArrayOutputStream.close();
        }
    }

    private void a(Map<String, String> map, Request request) {
        String obtainCookie = obtainCookie(request);
        if (LoggerWrapper.isDebuggable()) {
            String replace = obtainCookie.replace("%", "");
            String str = Quake.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("add cookie=");
            sb.append(replace);
            sb.append(". url=");
            sb.append(request.getUrl());
            LoggerWrapper.i(str, sb.toString());
        }
        if (TextUtils.isEmpty(obtainCookie)) {
            return;
        }
        map.put("Cookie", obtainCookie);
    }

    private void a(Map<String, String> map, Cache.Entry entry) {
        if (entry == null || map == null) {
            return;
        }
        String str = entry.dataVersion;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j = entry.lastModified;
        if (j > 0) {
            map.put("If-Modified-Since", HttpDate.format(new Date(j)));
        }
    }
}
