package com.alipay.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes3.dex */
public final class l implements Callable<p> {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {117, -10, 119, -11, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 105;
    private static final HttpRequestRetryHandler e = new z();

    /* renamed from: a  reason: collision with root package name */
    protected h f6837a;
    protected Context b;
    protected j c;
    String d;
    private HttpUriRequest f;
    private CookieManager i;
    private AbstractHttpEntity j;
    private HttpHost k;
    private URL l;
    private String q;
    private HttpContext g = new BasicHttpContext();
    private CookieStore h = new BasicCookieStore();
    private int m = 0;
    private boolean n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6838o = false;
    private String p = null;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void r(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 12
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 * 7
            int r8 = r8 + 99
            byte[] r0 = com.alipay.a.a.a.a.l.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r9 = r9 + r7
            int r6 = r6 + 1
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.a.a.a.a.l.r(short, int, byte, java.lang.Object[]):void");
    }

    public l(h hVar, j jVar) {
        this.f6837a = hVar;
        this.b = hVar.f6831a;
        this.c = jVar;
    }

    private URI b() {
        String str = this.c.f6835a;
        String str2 = this.d;
        if (str2 != null) {
            str = str2;
        }
        if (str == null) {
            throw new RuntimeException("url should not be null");
        }
        return new URI(str);
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] bArr = this.c.b;
            String a2 = this.c.a(HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
            if (bArr != null) {
                if (TextUtils.equals(a2, SummaryActivity.CHECKED)) {
                    this.j = b.a(bArr);
                } else {
                    this.j = new ByteArrayEntity(bArr);
                }
                this.j.setContentType(this.c.c);
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0111 A[Catch: Exception -> 0x025f, NullPointerException -> 0x027a, IOException -> 0x029e, UnknownHostException -> 0x02be, HttpHostConnectException -> 0x02df, NoHttpResponseException -> 0x02fc, SocketTimeoutException -> 0x031c, ConnectTimeoutException -> 0x033c, ConnectionPoolTimeoutException -> 0x035c, SSLException -> 0x037c, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x03bc, URISyntaxException -> 0x03dc, g -> 0x03ea, TryCatch #3 {g -> 0x03ea, NullPointerException -> 0x027a, SocketTimeoutException -> 0x031c, URISyntaxException -> 0x03dc, UnknownHostException -> 0x02be, SSLHandshakeException -> 0x03bc, SSLPeerUnverifiedException -> 0x039c, SSLException -> 0x037c, NoHttpResponseException -> 0x02fc, ConnectionPoolTimeoutException -> 0x035c, ConnectTimeoutException -> 0x033c, HttpHostConnectException -> 0x02df, IOException -> 0x029e, Exception -> 0x025f, blocks: (B:4:0x000b, B:19:0x003a, B:21:0x0040, B:23:0x0046, B:24:0x004a, B:26:0x0050, B:27:0x005e, B:29:0x00d8, B:31:0x00de, B:33:0x00e8, B:36:0x00f1, B:38:0x00fd, B:42:0x0108, B:44:0x0111, B:45:0x0129, B:47:0x0131, B:48:0x013e, B:50:0x0167, B:51:0x016e, B:53:0x0174, B:54:0x0178, B:56:0x017e, B:58:0x018a, B:62:0x01b8, B:63:0x01d2, B:71:0x01ef, B:72:0x0208, B:73:0x0209, B:75:0x0211, B:77:0x0217, B:84:0x0227, B:87:0x023a, B:88:0x023f, B:90:0x0245, B:92:0x024f, B:94:0x0253, B:95:0x025e, B:7:0x001e, B:9:0x0022, B:11:0x0026, B:13:0x002c, B:16:0x0034), top: B:144:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0131 A[Catch: Exception -> 0x025f, NullPointerException -> 0x027a, IOException -> 0x029e, UnknownHostException -> 0x02be, HttpHostConnectException -> 0x02df, NoHttpResponseException -> 0x02fc, SocketTimeoutException -> 0x031c, ConnectTimeoutException -> 0x033c, ConnectionPoolTimeoutException -> 0x035c, SSLException -> 0x037c, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x03bc, URISyntaxException -> 0x03dc, g -> 0x03ea, TryCatch #3 {g -> 0x03ea, NullPointerException -> 0x027a, SocketTimeoutException -> 0x031c, URISyntaxException -> 0x03dc, UnknownHostException -> 0x02be, SSLHandshakeException -> 0x03bc, SSLPeerUnverifiedException -> 0x039c, SSLException -> 0x037c, NoHttpResponseException -> 0x02fc, ConnectionPoolTimeoutException -> 0x035c, ConnectTimeoutException -> 0x033c, HttpHostConnectException -> 0x02df, IOException -> 0x029e, Exception -> 0x025f, blocks: (B:4:0x000b, B:19:0x003a, B:21:0x0040, B:23:0x0046, B:24:0x004a, B:26:0x0050, B:27:0x005e, B:29:0x00d8, B:31:0x00de, B:33:0x00e8, B:36:0x00f1, B:38:0x00fd, B:42:0x0108, B:44:0x0111, B:45:0x0129, B:47:0x0131, B:48:0x013e, B:50:0x0167, B:51:0x016e, B:53:0x0174, B:54:0x0178, B:56:0x017e, B:58:0x018a, B:62:0x01b8, B:63:0x01d2, B:71:0x01ef, B:72:0x0208, B:73:0x0209, B:75:0x0211, B:77:0x0217, B:84:0x0227, B:87:0x023a, B:88:0x023f, B:90:0x0245, B:92:0x024f, B:94:0x0253, B:95:0x025e, B:7:0x001e, B:9:0x0022, B:11:0x0026, B:13:0x002c, B:16:0x0034), top: B:144:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0167 A[Catch: Exception -> 0x025f, NullPointerException -> 0x027a, IOException -> 0x029e, UnknownHostException -> 0x02be, HttpHostConnectException -> 0x02df, NoHttpResponseException -> 0x02fc, SocketTimeoutException -> 0x031c, ConnectTimeoutException -> 0x033c, ConnectionPoolTimeoutException -> 0x035c, SSLException -> 0x037c, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x03bc, URISyntaxException -> 0x03dc, g -> 0x03ea, TryCatch #3 {g -> 0x03ea, NullPointerException -> 0x027a, SocketTimeoutException -> 0x031c, URISyntaxException -> 0x03dc, UnknownHostException -> 0x02be, SSLHandshakeException -> 0x03bc, SSLPeerUnverifiedException -> 0x039c, SSLException -> 0x037c, NoHttpResponseException -> 0x02fc, ConnectionPoolTimeoutException -> 0x035c, ConnectTimeoutException -> 0x033c, HttpHostConnectException -> 0x02df, IOException -> 0x029e, Exception -> 0x025f, blocks: (B:4:0x000b, B:19:0x003a, B:21:0x0040, B:23:0x0046, B:24:0x004a, B:26:0x0050, B:27:0x005e, B:29:0x00d8, B:31:0x00de, B:33:0x00e8, B:36:0x00f1, B:38:0x00fd, B:42:0x0108, B:44:0x0111, B:45:0x0129, B:47:0x0131, B:48:0x013e, B:50:0x0167, B:51:0x016e, B:53:0x0174, B:54:0x0178, B:56:0x017e, B:58:0x018a, B:62:0x01b8, B:63:0x01d2, B:71:0x01ef, B:72:0x0208, B:73:0x0209, B:75:0x0211, B:77:0x0217, B:84:0x0227, B:87:0x023a, B:88:0x023f, B:90:0x0245, B:92:0x024f, B:94:0x0253, B:95:0x025e, B:7:0x001e, B:9:0x0022, B:11:0x0026, B:13:0x002c, B:16:0x0034), top: B:144:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0174 A[Catch: Exception -> 0x025f, NullPointerException -> 0x027a, IOException -> 0x029e, UnknownHostException -> 0x02be, HttpHostConnectException -> 0x02df, NoHttpResponseException -> 0x02fc, SocketTimeoutException -> 0x031c, ConnectTimeoutException -> 0x033c, ConnectionPoolTimeoutException -> 0x035c, SSLException -> 0x037c, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x03bc, URISyntaxException -> 0x03dc, g -> 0x03ea, TryCatch #3 {g -> 0x03ea, NullPointerException -> 0x027a, SocketTimeoutException -> 0x031c, URISyntaxException -> 0x03dc, UnknownHostException -> 0x02be, SSLHandshakeException -> 0x03bc, SSLPeerUnverifiedException -> 0x039c, SSLException -> 0x037c, NoHttpResponseException -> 0x02fc, ConnectionPoolTimeoutException -> 0x035c, ConnectTimeoutException -> 0x033c, HttpHostConnectException -> 0x02df, IOException -> 0x029e, Exception -> 0x025f, blocks: (B:4:0x000b, B:19:0x003a, B:21:0x0040, B:23:0x0046, B:24:0x004a, B:26:0x0050, B:27:0x005e, B:29:0x00d8, B:31:0x00de, B:33:0x00e8, B:36:0x00f1, B:38:0x00fd, B:42:0x0108, B:44:0x0111, B:45:0x0129, B:47:0x0131, B:48:0x013e, B:50:0x0167, B:51:0x016e, B:53:0x0174, B:54:0x0178, B:56:0x017e, B:58:0x018a, B:62:0x01b8, B:63:0x01d2, B:71:0x01ef, B:72:0x0208, B:73:0x0209, B:75:0x0211, B:77:0x0217, B:84:0x0227, B:87:0x023a, B:88:0x023f, B:90:0x0245, B:92:0x024f, B:94:0x0253, B:95:0x025e, B:7:0x001e, B:9:0x0022, B:11:0x0026, B:13:0x002c, B:16:0x0034), top: B:144:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e6  */
    @Override // java.util.concurrent.Callable
    /* renamed from: d  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.a.a.a.a.p call() {
        /*
            Method dump skipped, instructions count: 1017
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.a.a.a.a.l.call():com.alipay.a.a.a.a.p");
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        String a2 = this.c.a("operationType");
        this.q = a2;
        return a2;
    }

    private int g() {
        URL h = h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.c.f6835a);
        this.l = url2;
        return url2;
    }

    private static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(";")) {
            String[] split = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    private p a(HttpResponse httpResponse, int i, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        StringBuilder sb = new StringBuilder("开始handle，handleResponse-1,");
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr = new Object[1];
            r(b, (byte) (b - 1), BuiltInFictitiousFunctionClassFactory[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
            byte b3 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr2 = new Object[1];
            r(b2, b3, (byte) (b3 - 1), objArr2);
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            String str3 = null;
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            InstrumentInjector.log_d("HttpWorker", sb.toString());
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
                if (entity == null) {
                    httpResponse.getStatusLine().getStatusCode();
                    return null;
                }
                return null;
            }
            StringBuilder sb2 = new StringBuilder("200，开始处理，handleResponse-2,threadid = ");
            try {
                byte b4 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr3 = new Object[1];
                r(b4, (byte) (b4 - 1), BuiltInFictitiousFunctionClassFactory[15], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                byte b6 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr4 = new Object[1];
                r(b5, b6, (byte) (b6 - 1), objArr4);
                sb2.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getId());
                InstrumentInjector.log_d("HttpWorker", sb2.toString());
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    a(entity, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    this.f6838o = false;
                    this.f6837a.e += System.currentTimeMillis() - currentTimeMillis;
                    this.f6837a.c += byteArray.length;
                    StringBuilder sb3 = new StringBuilder("res:");
                    sb3.append(byteArray.length);
                    InstrumentInjector.log_i("HttpWorker", sb3.toString());
                    k kVar = new k(a(httpResponse), i, str, byteArray);
                    long b7 = b(httpResponse);
                    Header contentType = httpResponse.getEntity().getContentType();
                    if (contentType != null) {
                        HashMap<String, String> a2 = a(contentType.getValue());
                        String str4 = a2.get("charset");
                        str3 = a2.get("Content-Type");
                        str2 = str4;
                    } else {
                        str2 = null;
                    }
                    kVar.a(str3);
                    kVar.c = str2;
                    kVar.f6836a = System.currentTimeMillis();
                    kVar.b = b7;
                    try {
                        byteArrayOutputStream.close();
                        InstrumentInjector.log_d("HttpWorker", "finally,handleResponse");
                        return kVar;
                    } catch (IOException e2) {
                        throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e3) {
                            throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                        }
                    }
                    InstrumentInjector.log_d("HttpWorker", "finally,handleResponse");
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable cause = th3.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th3;
            }
        } catch (Throwable th4) {
            Throwable cause2 = th4.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th4;
        }
    }

    private static i a(HttpResponse httpResponse) {
        i iVar = new i();
        for (Header header : httpResponse.getAllHeaders()) {
            iVar.f6834a.put(header.getName(), header.getValue());
        }
        return iVar;
    }

    private static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException e2) {
                    InstrumentInjector.log_w("HttpWorker", e2);
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader(HttpHeaders.EXPIRES);
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private static long a(String[] strArr) {
        String str;
        for (int i = 0; i < strArr.length; i++) {
            if ("max-age".equalsIgnoreCase(strArr[i]) && (str = strArr[i + 1]) != null) {
                try {
                    return Long.parseLong(str);
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return 0L;
    }

    public final j a() {
        return this.c;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a2 = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a2.read(bArr);
                    if (read == -1 || this.c.f) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    this.c.a();
                }
                outputStream.flush();
            } catch (Exception e2) {
                InstrumentInjector.log_w("HttpWorker", e2.getCause());
                StringBuilder sb = new StringBuilder("HttpWorker Request Error!");
                sb.append(e2.getLocalizedMessage());
                throw new IOException(sb.toString());
            }
        } finally {
            m.a(a2);
        }
    }

    private CookieManager i() {
        CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.i = cookieManager2;
        return cookieManager2;
    }
}
