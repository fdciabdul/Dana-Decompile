package id.dana.data.foundation.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.security.CookieNullThrowable;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes8.dex */
public class UrlTransport implements AbstractHttpTransport {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    private static final String KClassImpl$Data$declaredNonStaticMembers$2;
    private static char[] PlaceComponentResult = null;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 0;
    private static int lookAheadTest = 1;
    private static boolean scheduleImpl;
    private boolean MyBillsEntityDataFactory;

    static {
        MyBillsEntityDataFactory();
        Object[] objArr = new Object[1];
        a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 126, new byte[]{-122, -114, -120, -111, -112, -123, -124, -114, -113, -118, -114, -115, -125, -116, -120, -117, -118, -120, -120, -122, -125, -123, -120, -127, -122, -124, -126, -123, -119, -120, -121, -125, -124, -122, -124, -126, -125, -124, -123, -124, -126, -125, -126, -127}, null, null, objArr);
        KClassImpl$Data$declaredNonStaticMembers$2 = ((String) objArr[0]).intern();
        int i = lookAheadTest + 65;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(int i) {
        int i2 = lookAheadTest + 39;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
        if (!(i < 200)) {
            try {
                int i4 = lookAheadTest + 111;
                getErrorConfigVersion = i4 % 128;
                int i5 = i4 % 2;
                if (i != 204) {
                    return !(i == 304);
                }
                return false;
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }

    static void MyBillsEntityDataFactory() {
        PlaceComponentResult = new char[]{39497, 39500, 39426, 39505, 39490, 39612, 39498, 39491, 39613, 39492, 39502, 39608, 39517, 39614, 39516, 39615, 39488};
        BuiltInFictitiousFunctionClassFactory = true;
        scheduleImpl = true;
        getAuthRequestContext = 909154864;
    }

    public UrlTransport() {
        this(false);
    }

    public UrlTransport(boolean z) {
        try {
            this.MyBillsEntityDataFactory = false;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void getAuthRequestContext(HttpURLConnection httpURLConnection) {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            Iterator<String> it = headerFields.keySet().iterator();
            while (it.hasNext()) {
                int i = lookAheadTest + 49;
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                String next = it.next();
                if ((next != null ? '[' : JSONLexer.EOI) == '[') {
                    int i3 = getErrorConfigVersion + 65;
                    lookAheadTest = i3 % 128;
                    int i4 = i3 % 2;
                    if ((!next.equalsIgnoreCase(HttpHeaders.SET_COOKIE2) ? 'c' : '!') == 'c') {
                        int i5 = getErrorConfigVersion + 19;
                        lookAheadTest = i5 % 128;
                        int i6 = i5 % 2;
                        if (!next.equalsIgnoreCase("Set-Cookie")) {
                        }
                    }
                    int i7 = getErrorConfigVersion + 75;
                    lookAheadTest = i7 % 128;
                    int i8 = i7 % 2;
                    for (String str : headerFields.get(next)) {
                        String str2 = KClassImpl$Data$declaredNonStaticMembers$2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("setCookie [headerKey:headerValue]= ");
                        sb.append(next);
                        sb.append("\t: ");
                        sb.append(str);
                        DanaLog.MyBillsEntityDataFactory(str2, sb.toString());
                        String obj = httpURLConnection.getURL().toString();
                        if (obj.isEmpty()) {
                            Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                            CookieNullThrowable cookieNullThrowable = new CookieNullThrowable();
                            Intrinsics.checkNotNullParameter(cookieNullThrowable, "");
                            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(cookieNullThrowable);
                        }
                        cookieManager.setCookie(obj, str);
                    }
                }
            }
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, e.getMessage());
        }
    }

    private static void getAuthRequestContext(String str, HttpURLConnection httpURLConnection) {
        try {
            int i = getErrorConfigVersion + 79;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                int i3 = getErrorConfigVersion + 71;
                lookAheadTest = i3 % 128;
                boolean z = i3 % 2 == 0;
                httpURLConnection.addRequestProperty("Cookie", cookie);
                if (z) {
                    int i4 = 56 / 0;
                    return;
                }
                return;
            }
            Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            CookieNullThrowable cookieNullThrowable = new CookieNullThrowable();
            Intrinsics.checkNotNullParameter(cookieNullThrowable, "");
            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(cookieNullThrowable);
            int i5 = lookAheadTest + 81;
            getErrorConfigVersion = i5 % 128;
            if ((i5 % 2 != 0 ? Typography.quote : (char) 7) != '\"') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(HttpURLConnection httpURLConnection) {
        try {
            Object[] objArr = null;
            if ((TextUtils.isEmpty(httpURLConnection.getRequestProperty("Accept-Language")) ? (char) 24 : 'V') != 'V') {
                int i = lookAheadTest + 49;
                try {
                    getErrorConfigVersion = i % 128;
                    if ((i % 2 != 0 ? 'R' : 'T') != 'R') {
                        httpURLConnection.addRequestProperty("Accept-Language", PlaceComponentResult());
                    } else {
                        httpURLConnection.addRequestProperty("Accept-Language", PlaceComponentResult());
                        int length = objArr.length;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = getErrorConfigVersion + 25;
            lookAheadTest = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return;
            }
            objArr.hashCode();
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if ((map != null ? 'X' : 'a') != 'X') {
            return;
        }
        try {
            int i = getErrorConfigVersion + 63;
            try {
                lookAheadTest = i % 128;
                int i2 = i % 2;
                if (map.isEmpty()) {
                    return;
                }
                Iterator<String> it = map.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        return;
                    }
                    String next = it.next();
                    if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(next))) {
                        int i3 = lookAheadTest + 121;
                        getErrorConfigVersion = i3 % 128;
                        int i4 = i3 % 2;
                        httpURLConnection.addRequestProperty(next, map.get(next));
                        int i5 = getErrorConfigVersion + 31;
                        lookAheadTest = i5 % 128;
                        int i6 = i5 % 2;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String PlaceComponentResult() {
        int i = getErrorConfigVersion + 27;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        if ((Locale.getDefault().toString().endsWith("ID") ? (char) 27 : '4') == '4') {
            int i3 = lookAheadTest + 7;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return "en_US";
        }
        try {
            int i5 = lookAheadTest + 85;
            getErrorConfigVersion = i5 % 128;
            int i6 = i5 % 2;
            return "id_ID";
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
    
        if (r1 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
    
        if (BuiltInFictitiousFunctionClassFactory(r1) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        r6.setInputStream(MyBillsEntityDataFactory(r0));
     */
    @Override // id.dana.data.foundation.toolbox.AbstractHttpTransport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.alibaba.griver.api.common.network.HttpResponse KClassImpl$Data$declaredNonStaticMembers$2(com.alibaba.griver.api.common.network.HttpRequest r6) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        /*
            r5 = this;
            java.lang.String r0 = id.dana.data.foundation.toolbox.UrlTransport.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Ldc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "performRequest request="
            r1.append(r2)     // Catch: java.lang.Exception -> Ldc
            r1.append(r6)     // Catch: java.lang.Exception -> Ldc
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Ldc
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r1)     // Catch: java.lang.Exception -> Ldc
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Exception -> Ldc
            java.lang.String r1 = r6.getUrl()     // Catch: java.lang.Exception -> Ldc
            r0.<init>(r1)     // Catch: java.lang.Exception -> Ldc
            java.net.HttpURLConnection r0 = r5.getAuthRequestContext(r0, r6)     // Catch: java.lang.Exception -> Ldc
            java.util.Map r1 = r6.getHeaders()     // Catch: java.lang.Exception -> Ldc
            BuiltInFictitiousFunctionClassFactory(r1, r0)     // Catch: java.lang.Exception -> Ldc
            java.lang.String r1 = r6.getUrl()     // Catch: java.lang.Exception -> Ldc
            getAuthRequestContext(r1, r0)     // Catch: java.lang.Exception -> Ldc
            KClassImpl$Data$declaredNonStaticMembers$2(r0)     // Catch: java.lang.Exception -> Ldc
            java.lang.String r1 = r6.getMethod()     // Catch: java.lang.Exception -> Ldc
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> Ldc
            byte[] r6 = r6.getRequestData()     // Catch: java.lang.Exception -> Ldc
            r2.<init>(r6)     // Catch: java.lang.Exception -> Ldc
            MyBillsEntityDataFactory(r0, r1, r2)     // Catch: java.lang.Exception -> Ldc
            com.alibaba.griver.api.common.network.HttpResponse r6 = new com.alibaba.griver.api.common.network.HttpResponse     // Catch: java.lang.Exception -> Ldc
            r6.<init>()     // Catch: java.lang.Exception -> Ldc
            int r1 = r0.getResponseCode()     // Catch: java.io.IOException -> L4e java.lang.Exception -> Ldc
            goto L5c
        L4e:
            r1 = move-exception
            java.lang.String r2 = id.dana.data.foundation.toolbox.UrlTransport.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r1 = r1.getMessage()
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r2, r1)
            int r1 = r0.getResponseCode()
        L5c:
            r2 = -1
            r3 = 24
            if (r1 == r2) goto L64
            r2 = 24
            goto L65
        L64:
            r2 = 4
        L65:
            if (r2 != r3) goto Ld4
            int r2 = id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest
            int r2 = r2 + 75
            int r3 = r2 % 128
            id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion = r3
            int r2 = r2 % 2
            r3 = 63
            if (r2 == 0) goto L78
            r2 = 17
            goto L7a
        L78:
            r2 = 63
        L7a:
            r4 = 0
            if (r2 == r3) goto L91
            r6.setStatusCode(r1)
            java.util.Map r2 = r0.getHeaderFields()
            r6.setHeaders(r2)
            boolean r1 = BuiltInFictitiousFunctionClassFactory(r1)
            int r2 = r4.length     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto La8
            goto La1
        L8f:
            r6 = move-exception
            throw r6
        L91:
            r6.setStatusCode(r1)
            java.util.Map r2 = r0.getHeaderFields()
            r6.setHeaders(r2)
            boolean r1 = BuiltInFictitiousFunctionClassFactory(r1)
            if (r1 == 0) goto La8
        La1:
            java.io.InputStream r1 = MyBillsEntityDataFactory(r0)
            r6.setInputStream(r1)
        La8:
            getAuthRequestContext(r0)
            java.lang.String r0 = id.dana.data.foundation.toolbox.UrlTransport.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "performRequest response Url transport="
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r1)
            int r0 = id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion = r1
            int r0 = r0 % 2
            if (r0 == 0) goto Ld3
            r4.hashCode()     // Catch: java.lang.Throwable -> Ld1
            return r6
        Ld1:
            r6 = move-exception
            throw r6
        Ld3:
            return r6
        Ld4:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r0 = "Could not retrieve response code from HttpUrlConnection."
            r6.<init>(r0)
            throw r6
        Ldc:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.toolbox.UrlTransport.KClassImpl$Data$declaredNonStaticMembers$2(com.alibaba.griver.api.common.network.HttpRequest):com.alibaba.griver.api.common.network.HttpResponse");
    }

    private static HttpURLConnection KClassImpl$Data$declaredNonStaticMembers$2(URL url) throws IOException {
        int i = lookAheadTest + 93;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection())));
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        try {
            int i3 = getErrorConfigVersion + 101;
            lookAheadTest = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return httpURLConnection;
            }
            int i4 = 51 / 0;
            return httpURLConnection;
        } catch (Exception e) {
            throw e;
        }
    }

    private HttpURLConnection getAuthRequestContext(URL url, HttpRequest httpRequest) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(url);
        if ((httpRequest.getTimeout() < 0 ? 'Q' : '8') != '8') {
            try {
                httpRequest.setTimeout(30000);
            } catch (Exception e) {
                throw e;
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$22.setConnectTimeout(httpRequest.getTimeout() / 2);
        KClassImpl$Data$declaredNonStaticMembers$22.setReadTimeout(httpRequest.getTimeout() / 2);
        KClassImpl$Data$declaredNonStaticMembers$22.setUseCaches(this.MyBillsEntityDataFactory);
        KClassImpl$Data$declaredNonStaticMembers$22.setDefaultUseCaches(this.MyBillsEntityDataFactory);
        KClassImpl$Data$declaredNonStaticMembers$22.setDoInput(true);
        if ("https".equals(url.getProtocol())) {
            int i = getErrorConfigVersion + 33;
            lookAheadTest = i % 128;
            Object obj = null;
            if (i % 2 == 0) {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                ((HttpsURLConnection) KClassImpl$Data$declaredNonStaticMembers$22).setSSLSocketFactory(sSLContext.getSocketFactory());
                obj.hashCode();
            } else {
                SSLContext sSLContext2 = SSLContext.getInstance("TLS");
                sSLContext2.init(null, null, null);
                ((HttpsURLConnection) KClassImpl$Data$declaredNonStaticMembers$22).setSSLSocketFactory(sSLContext2.getSocketFactory());
            }
        }
        int i2 = lookAheadTest + 71;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (android.text.TextUtils.equals(r5, "GET") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if (r0 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r0 = id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest + 71;
        id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if ((r0 % 2) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r5 = android.text.TextUtils.equals(r5, "POST");
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r5 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        r5 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        r5 = '[';
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        if (r5 == 11) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
    
        if (android.text.TextUtils.equals(r5, "POST") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:
    
        if (r1 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0066, code lost:
    
        r4.setRequestMethod("POST");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006d, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006f, code lost:
    
        r5 = id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion + 57;
        id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if ((r5 % 2) != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r4, r6.getBytes(java.nio.charset.StandardCharsets.UTF_8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0086, code lost:
    
        r4 = 51 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008a, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r4, r6.getBytes(java.nio.charset.StandardCharsets.UTF_8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
    
        r4.setRequestMethod("GET");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0098, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void MyBillsEntityDataFactory(java.net.HttpURLConnection r4, java.lang.String r5, java.lang.String r6) throws java.io.IOException {
        /*
            int r0 = id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 74
            if (r0 == 0) goto L11
            r0 = 74
            goto L13
        L11:
            r0 = 54
        L13:
            java.lang.String r2 = "GET"
            r3 = 0
            if (r0 == r1) goto L22
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L1f
            if (r0 != 0) goto L95
            goto L2b
        L1f:
            r4 = move-exception
            goto L94
        L22:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 19
            int r1 = r1 / r3
            if (r0 != 0) goto L95
        L2b:
            boolean r0 = android.text.TextUtils.equals(r5, r2)
            r1 = 1
            if (r0 != 0) goto L34
            r0 = 0
            goto L35
        L34:
            r0 = 1
        L35:
            if (r0 == 0) goto L38
            goto L95
        L38:
            int r0 = id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest
            int r0 = r0 + 71
            int r2 = r0 % 128
            id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion = r2
            int r0 = r0 % 2
            java.lang.String r2 = "POST"
            if (r0 == 0) goto L5c
            boolean r5 = android.text.TextUtils.equals(r5, r2)
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L5a
            r0 = 11
            if (r5 == 0) goto L55
            r5 = 11
            goto L57
        L55:
            r5 = 91
        L57:
            if (r5 == r0) goto L66
            goto L98
        L5a:
            r4 = move-exception
            throw r4
        L5c:
            boolean r5 = android.text.TextUtils.equals(r5, r2)
            if (r5 == 0) goto L63
            r1 = 0
        L63:
            if (r1 == 0) goto L66
            goto L98
        L66:
            r4.setRequestMethod(r2)     // Catch: java.lang.Exception -> L1f
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L1f
            if (r5 != 0) goto L98
            int r5 = id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion
            int r5 = r5 + 57
            int r0 = r5 % 128
            id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L8a
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r5 = r6.getBytes(r5)
            BuiltInFictitiousFunctionClassFactory(r4, r5)
            r4 = 51
            int r4 = r4 / r3
            goto L93
        L88:
            r4 = move-exception
            throw r4
        L8a:
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r5 = r6.getBytes(r5)
            BuiltInFictitiousFunctionClassFactory(r4, r5)
        L93:
            return
        L94:
            throw r4
        L95:
            r4.setRequestMethod(r2)
        L98:
            return
        L99:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.toolbox.UrlTransport.MyBillsEntityDataFactory(java.net.HttpURLConnection, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if ((android.text.TextUtils.isEmpty(r4.getRequestProperty("Content-Type")) ? false : true) != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.getRequestProperty("Content-Type")) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        r4.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        r0 = id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion + 125;
        id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void BuiltInFictitiousFunctionClassFactory(java.net.HttpURLConnection r4, byte[] r5) throws java.io.IOException {
        /*
            int r0 = id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            java.lang.String r3 = "Content-Type"
            if (r0 == 0) goto L2a
            int r0 = r5.length
            r4.setFixedLengthStreamingMode(r0)
            r4.setDoOutput(r1)
            java.lang.String r0 = r4.getRequestProperty(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L26
            goto L27
        L26:
            r2 = 1
        L27:
            if (r2 == r1) goto L4a
            goto L3b
        L2a:
            int r0 = r5.length
            r4.setFixedLengthStreamingMode(r0)
            r4.setDoOutput(r1)
            java.lang.String r0 = r4.getRequestProperty(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L4a
        L3b:
            java.lang.String r0 = "application/x-www-form-urlencoded"
            r4.addRequestProperty(r3, r0)
            int r0 = id.dana.data.foundation.toolbox.UrlTransport.getErrorConfigVersion
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.data.foundation.toolbox.UrlTransport.lookAheadTest = r1
            int r0 = r0 % 2
        L4a:
            java.io.DataOutputStream r0 = new java.io.DataOutputStream
            java.io.OutputStream r4 = r4.getOutputStream()
            r0.<init>(r4)
            r0.write(r5)
            r0.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.toolbox.UrlTransport.BuiltInFictitiousFunctionClassFactory(java.net.HttpURLConnection, byte[]):void");
    }

    private static InputStream MyBillsEntityDataFactory(HttpURLConnection httpURLConnection) throws IOException {
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getInputStream();
            int i = getErrorConfigVersion + 27;
            lookAheadTest = i % 128;
            int i2 = i % 2;
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        int i3 = lookAheadTest + 19;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return errorStream;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        try {
            char[] cArr2 = PlaceComponentResult;
            if ((cArr2 != null ? 'N' : '%') != '%') {
                int i2 = $10 + 33;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = $11 + 91;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = 0;
                while (true) {
                    if ((i6 < length ? (char) 6 : '/') == '/') {
                        break;
                    }
                    int i7 = $11 + 111;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr3[i6] = (char) (cArr2[i6] ^ 4571606982258105150L);
                    i6++;
                }
                int i9 = $10 + 25;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                cArr2 = cArr3;
            }
            int i11 = (int) (getAuthRequestContext ^ 4571606982258105150L);
            if ((scheduleImpl ? '(' : '9') == '(') {
                int i12 = $10 + 1;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i14 = $11 + 79;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i11);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
            } else if (BuiltInFictitiousFunctionClassFactory) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                        objArr[0] = new String(cArr5);
                        return;
                    } else {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i11);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    try {
                        if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                            objArr[0] = new String(cArr6);
                            return;
                        } else {
                            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i11);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
