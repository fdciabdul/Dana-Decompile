package com.alipay.griver.ccdn;

import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.griver.api.common.network.GriverTransportExtension;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.performance.PerformanceAmcsManager;
import com.alibaba.griver.base.performance.PerformanceMonitorFactory;
import com.alibaba.griver.base.performance.network.PerformanceNetworkMonitor;
import com.google.common.net.HttpHeaders;
import id.dana.data.here.HereOauthManager;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class NetWorkerManager {
    private static final String CONTENT_TYPE = "content-type";
    private static final String TAG = "NetWorkerManager";
    private final CookieManager mCookieManager = CookieManager.getInstance();

    public WebResourceResponse loadResource(final String str, final String str2, String str3, Map<String, String> map) {
        WebResourceResponse webResourceResponse;
        try {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            GriverTransportExtension griverTransportExtension = (GriverTransportExtension) RVProxy.get(GriverTransportExtension.class);
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.setUrl(str2);
            httpRequest.setMethod(str3);
            addHeaderCookie(map, str2);
            httpRequest.setHeaders(map);
            final HttpResponse request = griverTransportExtension.request(httpRequest);
            if (request == null) {
                CCDNH5CacheManager.getInstance().monitCCDNFailed(4, str2, null, null, null, null);
                return null;
            }
            final String[] mineAndEncodingForHeaders = getMineAndEncodingForHeaders(request.getHeaders());
            if (!TextUtils.isEmpty(mineAndEncodingForHeaders[0]) && !TextUtils.isEmpty(mineAndEncodingForHeaders[1])) {
                final InputStream inputStream = request.getInputStream();
                if (inputStream == null) {
                    CCDNH5CacheManager.getInstance().monitCCDNFailed(5, str2, null, null, null, null);
                    return null;
                }
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    webResourceResponse = new WebResourceResponse(mineAndEncodingForHeaders[0], mineAndEncodingForHeaders[1], new InputStream() { // from class: com.alipay.griver.ccdn.NetWorkerManager.1
                        {
                            NetWorkerManager.this = this;
                        }

                        @Override // java.io.InputStream
                        public int read() throws IOException {
                            int read = inputStream.read();
                            if (read != -1) {
                                byteArrayOutputStream.write(read);
                            }
                            return read;
                        }

                        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                        public void close() {
                            if (request.getStatusCode() == 200 || request.getStatusCode() == 304) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("url=");
                                sb.append(str2);
                                sb.append(",contentLength=");
                                sb.append(request.getContentLength());
                                sb.append("outputStream size=");
                                sb.append(byteArrayOutputStream.size());
                                GriverLogger.d(NetWorkerManager.TAG, sb.toString());
                                CCDNH5CacheManager.getInstance().addEntry(str, str2, request.getHeaders(), NetWorkerManager.this.parseStatusLine(request.getProtocol(), request.getStatusCode(), request.getReasonPhrase()), byteArrayOutputStream.toByteArray(), byteArrayOutputStream.size());
                            }
                            PerformanceNetworkMonitor performanceNetworkMonitor = (PerformanceNetworkMonitor) PerformanceMonitorFactory.getPerformanceMonitor(str, PerformanceMonitorFactory.PerformanceType.NETWORK);
                            if (performanceNetworkMonitor != null && PerformanceAmcsManager.getInstance().canMonitorNetwork()) {
                                performanceNetworkMonitor.setNetworkResourceModel(str2, mineAndEncodingForHeaders[0], SystemClock.elapsedRealtime() - elapsedRealtime, byteArrayOutputStream.size());
                                performanceNetworkMonitor.setNetworkResourceStatusErrorModel(str2, String.valueOf(request.getStatusCode()));
                            }
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly(byteArrayOutputStream);
                        }
                    });
                    String reasonPhrase = request.getReasonPhrase();
                    if (TextUtils.isEmpty(reasonPhrase)) {
                        reasonPhrase = "OK";
                    }
                    webResourceResponse.setStatusCodeAndReasonPhrase(request.getStatusCode(), reasonPhrase);
                    webResourceResponse.setResponseHeaders(toHeader(request.getHeaders()));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    setCookie(request.getHeaders(), str2);
                    return webResourceResponse;
                } catch (Throwable th2) {
                    th = th2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("loadResource error, e=");
                    sb.append(th);
                    GriverLogger.e(TAG, sb.toString());
                    PerformanceNetworkMonitor performanceNetworkMonitor = (PerformanceNetworkMonitor) PerformanceMonitorFactory.getPerformanceMonitor(str, PerformanceMonitorFactory.PerformanceType.NETWORK);
                    if (performanceNetworkMonitor == null || !PerformanceAmcsManager.getInstance().canMonitorNetwork()) {
                        return null;
                    }
                    performanceNetworkMonitor.setNetworkResourceStatusErrorModel(str2, "400");
                    return null;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public HttpResponse preLoadResource(String str) {
        Uri uri;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            uri = Uri.parse(str);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse error");
            sb.append(th);
            GriverLogger.e(TAG, sb.toString());
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (SemanticAttributes.FaasTriggerValues.HTTP.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            if (uri.getQueryParameterNames() == null || uri.getQueryParameterNames().size() <= 0) {
                try {
                    HashMap hashMap = new HashMap();
                    GriverTransportExtension griverTransportExtension = (GriverTransportExtension) RVProxy.get(GriverTransportExtension.class);
                    HttpRequest httpRequest = new HttpRequest();
                    httpRequest.setUrl(str);
                    httpRequest.setMethod("GET");
                    addHeaderCookie(hashMap, str);
                    httpRequest.setHeaders(hashMap);
                    HttpResponse request = griverTransportExtension.request(httpRequest);
                    if (request != null) {
                        setCookie(request.getHeaders(), str);
                    }
                    return request;
                } catch (Throwable th2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("preLoadResource error, e=");
                    sb2.append(th2);
                    GriverLogger.e(TAG, sb2.toString());
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public static Map<String, String> toHeader(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < entry.getValue().size() - 1; i++) {
                sb.append(entry.getValue().get(i));
                sb.append(",");
            }
            sb.append(entry.getValue().get(entry.getValue().size() - 1));
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    String[] getMineAndEncodingForHeaders(Map<String, List<String>> map) {
        if (map == null) {
            return new String[]{"", ""};
        }
        List<String> list = null;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getKey().equalsIgnoreCase(CONTENT_TYPE)) {
                list = entry.getValue();
            }
        }
        if (list == null) {
            return new String[]{"", ""};
        }
        String str = list.size() > 0 ? list.get(0) : null;
        if (str == null) {
            return new String[]{"", ""};
        }
        boolean contains = str.contains(";");
        String str2 = HereOauthManager.ENC;
        if (contains) {
            String[] split = str.split(";");
            str = split[0];
            String[] split2 = split[1].trim().split("=");
            if (split.length == 2 && split2[0].trim().equalsIgnoreCase("charset")) {
                str2 = split2[1].trim();
            }
        }
        return new String[]{str, str2};
    }

    public String[] getMineAndEncoding(Map<String, String> map) {
        if (map == null) {
            return new String[]{"", ""};
        }
        String str = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getKey().equalsIgnoreCase(CONTENT_TYPE)) {
                str = entry.getValue();
            }
        }
        if (str == null) {
            return new String[]{"", ""};
        }
        boolean contains = str.contains(";");
        String str2 = HereOauthManager.ENC;
        if (contains) {
            String[] split = str.split(";");
            str = split[0];
            String[] split2 = split[1].trim().split("=");
            if (split.length == 2 && split2[0].trim().equalsIgnoreCase("charset")) {
                str2 = split2[1].trim();
            }
        }
        return new String[]{str, str2};
    }

    private void addHeaderCookie(Map<String, String> map, String str) {
        CookieManager cookieManager = this.mCookieManager;
        if (cookieManager == null) {
            return;
        }
        String cookie = cookieManager.getCookie(str);
        if (TextUtils.isEmpty(cookie)) {
            return;
        }
        map.put("Cookie", cookie);
    }

    private void setCookie(Map<String, List<String>> map, String str) {
        if (this.mCookieManager == null || map == null) {
            return;
        }
        List<String> list = map.get("Set-Cookie");
        List<String> list2 = map.get(HttpHeaders.SET_COOKIE2);
        List<String> list3 = map.get("set-cookie");
        List<String> list4 = map.get("set-cookie2");
        HashSet hashSet = new HashSet();
        if (list != null) {
            hashSet.addAll(list);
        }
        if (list2 != null) {
            hashSet.addAll(list2);
        }
        if (list3 != null) {
            hashSet.addAll(list3);
        }
        if (list4 != null) {
            hashSet.addAll(list4);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.mCookieManager.setCookie(str, (String) it.next());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mCookieManager.flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }

    public String parseStatusLine(String str, int i, String str2) {
        if (TextUtils.isEmpty(str) || i != 200 || TextUtils.isEmpty(str2)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        sb.append(i);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }
}
