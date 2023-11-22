package com.alipay.plus.android.transport.a;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.transport.sdk.AbstractHttpTransport;
import com.alipay.plus.android.transport.sdk.HttpError;
import com.alipay.plus.android.transport.sdk.HttpMethod;
import com.alipay.plus.android.transport.sdk.HttpRequest;
import com.alipay.plus.android.transport.sdk.HttpResponse;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes7.dex */
public class a implements AbstractHttpTransport {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int PlaceComponentResult = 1;

    /* renamed from: a  reason: collision with root package name */
    private static final String f7393a;
    private static long getAuthRequestContext;
    private boolean b;
    private CookieManager c = new CookieManager();

    static {
        BuiltInFictitiousFunctionClassFactory();
        f7393a = com.alipay.plus.android.transport.b.a.a("HttpUrlTransport");
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 105;
            PlaceComponentResult = i % 128;
            if (!(i % 2 == 0)) {
                return;
            }
            int i2 = 53 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public a(boolean z) {
        this.b = z;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = -700723504393833468L;
    }

    private HttpURLConnection a(URL url) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 107;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection())));
            httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
            return httpURLConnection;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection())));
            httpURLConnection2.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
            Object[] objArr = null;
            int length = objArr.length;
            return httpURLConnection2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if ((r8.timeoutMilliseconds > 0) != true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if ((r4 <= 0 ? 30 : '*') != 30) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        r8.timeoutMilliseconds = 20000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
    
        throw r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.HttpURLConnection a(java.net.URL r7, com.alipay.plus.android.transport.sdk.HttpRequest r8) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        /*
            r6 = this;
            int r0 = com.alipay.plus.android.transport.a.a.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.alipay.plus.android.transport.a.a.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L22
            java.net.HttpURLConnection r0 = r6.a(r7)
            int r4 = r8.timeoutMilliseconds
            if (r4 > 0) goto L1e
            r4 = 0
            goto L1f
        L1e:
            r4 = 1
        L1f:
            if (r4 == r2) goto L39
            goto L35
        L22:
            java.net.HttpURLConnection r0 = r6.a(r7)
            int r4 = r8.timeoutMilliseconds
            int r5 = r3.length     // Catch: java.lang.Throwable -> L92
            r5 = 30
            if (r4 > 0) goto L30
            r4 = 30
            goto L32
        L30:
            r4 = 42
        L32:
            if (r4 == r5) goto L35
            goto L39
        L35:
            r4 = 20000(0x4e20, float:2.8026E-41)
            r8.timeoutMilliseconds = r4     // Catch: java.lang.Exception -> L90
        L39:
            int r4 = r8.timeoutMilliseconds
            r0.setConnectTimeout(r4)
            int r4 = r8.timeoutMilliseconds
            r0.setReadTimeout(r4)
            boolean r4 = r6.b
            r0.setUseCaches(r4)
            boolean r4 = r6.b
            r0.setDefaultUseCaches(r4)
            r0.setDoInput(r2)
            boolean r8 = r8.notFollowRedirects
            r8 = r8 ^ r2
            r0.setInstanceFollowRedirects(r8)
            java.lang.String r7 = r7.getProtocol()
            java.lang.String r8 = "https"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L63
            goto L64
        L63:
            r1 = 1
        L64:
            if (r1 == r2) goto L8f
            int r7 = com.alipay.plus.android.transport.a.a.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 + 67
            int r8 = r7 % 128
            com.alipay.plus.android.transport.a.a.PlaceComponentResult = r8
            int r7 = r7 % 2
            java.lang.String r7 = com.alipay.plus.android.transport.a.a.f7393a
            java.lang.String r8 = "Https protocol, will set SSLContext."
            com.alipay.iap.android.common.log.LoggerWrapper.i(r7, r8)
            java.lang.String r8 = "TLS"
            javax.net.ssl.SSLContext r8 = javax.net.ssl.SSLContext.getInstance(r8)
            r8.init(r3, r3, r3)
            r1 = r0
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1
            javax.net.ssl.SSLSocketFactory r8 = r8.getSocketFactory()
            r1.setSSLSocketFactory(r8)
            java.lang.String r8 = "Https protocol, set SSLContext & SSLSocketFactory successfully."
            com.alipay.iap.android.common.log.LoggerWrapper.i(r7, r8)
        L8f:
            return r0
        L90:
            r7 = move-exception
            throw r7
        L92:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.plus.android.transport.a.a.a(java.net.URL, com.alipay.plus.android.transport.sdk.HttpRequest):java.net.HttpURLConnection");
    }

    private void a(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) throws IOException {
        int i = PlaceComponentResult + 77;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if ((httpMethod == null ? '.' : '@') == '.') {
            httpMethod = HttpMethod.GET;
        }
        httpURLConnection.setRequestMethod(httpMethod.method);
        if (!(httpMethod == HttpMethod.POST)) {
            int i3 = PlaceComponentResult + 47;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            if (httpMethod != HttpMethod.PUT) {
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i5 = BuiltInFictitiousFunctionClassFactory + 7;
        PlaceComponentResult = i5 % 128;
        int i6 = i5 % 2;
        Object[] objArr = new Object[1];
        d(5407 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{25874, 28684, 20287, 23095, 12547}, objArr);
        a(httpURLConnection, str.getBytes(((String) objArr[0]).intern()));
    }

    private void a(HttpURLConnection httpURLConnection, URL url) {
        int i = PlaceComponentResult + 115;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            List<String> list = this.c.get(url.toURI(), Collections.emptyMap()).get("Set-cookie");
            if ((list != null ? ')' : ']') != ')') {
                return;
            }
            int i3 = PlaceComponentResult + 51;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            Object obj = null;
            if (!(i3 % 2 == 0)) {
                boolean isEmpty = list.isEmpty();
                obj.hashCode();
                if (isEmpty) {
                    return;
                }
            } else if (list.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (true) {
                if ((it.hasNext() ? 'O' : 'V') == 'V') {
                    httpURLConnection.addRequestProperty("Cookie", sb.toString());
                    int i4 = PlaceComponentResult + 75;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    int i5 = i4 % 2;
                    return;
                }
                int i6 = BuiltInFictitiousFunctionClassFactory + 121;
                PlaceComponentResult = i6 % 128;
                if (i6 % 2 == 0) {
                    sb.append(it.next());
                    obj.hashCode();
                } else {
                    sb.append(it.next());
                }
            }
        } catch (IOException | URISyntaxException e) {
            String str = f7393a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Saving cookies failed for ");
            sb2.append(url.toString());
            LoggerWrapper.w(str, sb2.toString(), e);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, ?> map) {
        Map.Entry<String, ?> next;
        String key;
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 23;
            PlaceComponentResult = i % 128;
            Object[] objArr = null;
            if (!(i % 2 != 0)) {
                int length = objArr.length;
                if (map == null) {
                    return;
                }
            } else if (map == null) {
                return;
            }
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            int i2 = PlaceComponentResult + 117;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((it.hasNext() ? 'Z' : 'R') != 'Z') {
                    break;
                }
                int i4 = PlaceComponentResult + 89;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                if (i4 % 2 != 0) {
                    next = it.next();
                    key = next.getKey();
                    boolean isEmpty = TextUtils.isEmpty(httpURLConnection.getRequestProperty(key));
                    int length2 = objArr.length;
                    if (isEmpty) {
                        int i5 = PlaceComponentResult + 107;
                        BuiltInFictitiousFunctionClassFactory = i5 % 128;
                        int i6 = i5 % 2;
                        httpURLConnection.addRequestProperty(key, String.valueOf(next.getValue()));
                    }
                } else {
                    next = it.next();
                    key = next.getKey();
                    if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(key))) {
                        int i52 = PlaceComponentResult + 107;
                        BuiltInFictitiousFunctionClassFactory = i52 % 128;
                        int i62 = i52 % 2;
                        httpURLConnection.addRequestProperty(key, String.valueOf(next.getValue()));
                    }
                }
            }
            int i7 = BuiltInFictitiousFunctionClassFactory + 95;
            PlaceComponentResult = i7 % 128;
            if (i7 % 2 == 0) {
                objArr.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if ((android.text.TextUtils.isEmpty(r6.getRequestProperty("Content-Type")) ? 'Q' : com.alibaba.fastjson.parser.JSONLexer.EOI) != 'Q') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r6.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.getRequestProperty("Content-Type")) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.net.HttpURLConnection r6, byte[] r7) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = com.alipay.plus.android.transport.a.a.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.alipay.plus.android.transport.a.a.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r3 = "Content-Type"
            if (r0 == r1) goto L27
            int r0 = r7.length
            r6.setFixedLengthStreamingMode(r0)
            r6.setDoOutput(r1)
            java.lang.String r0 = r6.getRequestProperty(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L47
            goto L42
        L27:
            int r0 = r7.length
            r6.setFixedLengthStreamingMode(r0)     // Catch: java.lang.Exception -> L6e
            r6.setDoOutput(r2)     // Catch: java.lang.Exception -> L6c
            java.lang.String r0 = r6.getRequestProperty(r3)     // Catch: java.lang.Exception -> L6c
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L6c
            r4 = 81
            if (r0 == 0) goto L3d
            r0 = 81
            goto L3f
        L3d:
            r0 = 26
        L3f:
            if (r0 == r4) goto L42
            goto L47
        L42:
            java.lang.String r0 = "application/x-www-form-urlencoded"
            r6.addRequestProperty(r3, r0)
        L47:
            java.io.DataOutputStream r0 = new java.io.DataOutputStream
            java.io.OutputStream r6 = r6.getOutputStream()
            r0.<init>(r6)
            r0.write(r7)
            r0.close()
            int r6 = com.alipay.plus.android.transport.a.a.PlaceComponentResult
            int r6 = r6 + 83
            int r7 = r6 % 128
            com.alipay.plus.android.transport.a.a.BuiltInFictitiousFunctionClassFactory = r7
            int r6 = r6 % 2
            if (r6 == 0) goto L63
            r1 = 0
        L63:
            if (r1 == 0) goto L66
            return
        L66:
            r6 = 47
            int r6 = r6 / r2
            return
        L6a:
            r6 = move-exception
            throw r6
        L6c:
            r6 = move-exception
            throw r6
        L6e:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.plus.android.transport.a.a.a(java.net.HttpURLConnection, byte[]):void");
    }

    private boolean a(int i) {
        int i2 = PlaceComponentResult + 79;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        try {
            if ((i >= 200 ? (char) 25 : Typography.less) == 25 && i != 204) {
                if ((i != 304 ? '/' : 'R') == '/') {
                    int i4 = BuiltInFictitiousFunctionClassFactory + 113;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                    return true;
                }
            }
            int i6 = BuiltInFictitiousFunctionClassFactory + 125;
            PlaceComponentResult = i6 % 128;
            int i7 = i6 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    private byte[] a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream errorStream;
        try {
            int i = PlaceComponentResult + 23;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            try {
                errorStream = httpURLConnection.getInputStream();
                int i3 = BuiltInFictitiousFunctionClassFactory + 67;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            return com.alipay.plus.android.transport.b.a.a(errorStream);
        } catch (Exception e) {
            throw e;
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        List<String> list = headerFields.get("Set-Cookie");
        List<String> list2 = headerFields.get(HttpHeaders.SET_COOKIE2);
        URL url = httpURLConnection.getURL();
        ArrayList arrayList = new ArrayList();
        if ((list != null ? '\f' : 'F') != 'F') {
            arrayList.addAll(list);
        }
        if ((list2 != null ? '0' : (char) 4) == '0') {
            int i = BuiltInFictitiousFunctionClassFactory + 87;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            arrayList.addAll(list2);
        }
        try {
            this.c.put(url.toURI(), Collections.singletonMap("Set-cookie", arrayList));
            int i3 = PlaceComponentResult + 23;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (IOException | URISyntaxException e) {
            String str = f7393a;
            StringBuilder sb = new StringBuilder();
            sb.append("Saving cookies failed for ");
            sb.append(url.toString());
            LoggerWrapper.w(str, sb.toString(), e);
            int i5 = BuiltInFictitiousFunctionClassFactory + 119;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private static void c(HttpURLConnection httpURLConnection) {
        int i = PlaceComponentResult + 121;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            boolean isEmpty = TextUtils.isEmpty(httpURLConnection.getRequestProperty("Accept-Language"));
            objArr.hashCode();
            if ((isEmpty ? JSONLexer.EOI : 'A') == 'A') {
                return;
            }
        } else {
            try {
                if (!TextUtils.isEmpty(httpURLConnection.getRequestProperty("Accept-Language"))) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = PlaceComponentResult + 25;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if (i2 % 2 == 0) {
                httpURLConnection.addRequestProperty("Accept-Language", com.alipay.plus.android.transport.b.a.a());
                return;
            }
            httpURLConnection.addRequestProperty("Accept-Language", com.alipay.plus.android.transport.b.a.a());
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.alipay.plus.android.transport.sdk.AbstractHttpTransport
    public HttpResponse performRequest(HttpRequest httpRequest) throws Exception {
        int responseCode;
        HttpResponse httpResponse;
        String str = f7393a;
        StringBuilder sb = new StringBuilder();
        sb.append("performRequest request = ");
        sb.append(httpRequest);
        LoggerWrapper.v(str, sb.toString());
        if (TextUtils.isEmpty(httpRequest.url)) {
            throw com.alipay.plus.android.transport.b.a.a(HttpError.UrlIsEmpty, "request.url is empty!");
        }
        URL url = new URL(httpRequest.url);
        HttpURLConnection a2 = a(url, httpRequest);
        a(a2, httpRequest.headers);
        a(a2, url);
        c(a2);
        a(a2, httpRequest.method, httpRequest.data);
        try {
            responseCode = a2.getResponseCode();
        } catch (IOException e) {
            LoggerWrapper.d(f7393a, e.getMessage());
            responseCode = a2.getResponseCode();
        }
        if ((responseCode != -1 ? '6' : (char) 24) == '6') {
            try {
                String responseMessage = a2.getResponseMessage();
                if (a(responseCode)) {
                    httpResponse = new HttpResponse(responseCode, responseMessage, a(a2), a2.getHeaderFields());
                } else {
                    httpResponse = new HttpResponse(responseCode, responseMessage, null, a2.getHeaderFields());
                    try {
                        int i = PlaceComponentResult + 95;
                        BuiltInFictitiousFunctionClassFactory = i % 128;
                        int i2 = i % 2;
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                b(a2);
                String str2 = f7393a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("performRequest response = ");
                sb2.append(httpResponse);
                LoggerWrapper.v(str2, sb2.toString());
                int i3 = PlaceComponentResult + 9;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return httpResponse;
            } catch (Exception e3) {
                throw e3;
            }
        }
        throw com.alipay.plus.android.transport.b.a.a(HttpError.RetrieveStatusCodeError, "Could not retrieve response code from HttpUrlConnection.");
    }

    private static void d(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        try {
            getonboardingscenario.getAuthRequestContext = 0;
            int i2 = $10 + 59;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    String str = new String(cArr2);
                    int i4 = $11 + 27;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    objArr[0] = str;
                    return;
                }
                int i6 = $11 + 125;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext /= 1;
                } else {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext++;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
