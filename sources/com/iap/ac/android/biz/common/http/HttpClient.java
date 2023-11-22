package com.iap.ac.android.biz.common.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alibaba.fastjson.parser.JSONLexer;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iap.ac.android.biz.common.model.http.HttpMethod;
import com.iap.ac.android.biz.common.model.http.HttpRequest;
import com.iap.ac.android.common.log.ACLog;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes8.dex */
public class HttpClient {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 7609651942571346650L;
    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final int DEFAULT_TIMEOUT_MS = 5000;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final String PROTOCOL_HTTPS = "https";
    private static int PlaceComponentResult = 1;
    public static final String TAG = "HttpClient";
    public boolean mEnableCache;
    public List<HttpInterceptor> interceptors = new ArrayList();
    public CookieManager cookieManager = CookieManager.getInstance();

    public HttpClient(boolean z, Context context) {
        this.mEnableCache = z;
        try {
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    CookieSyncManager.createInstance(context).sync();
                    int i = PlaceComponentResult + 57;
                    try {
                        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                        int i2 = i % 2;
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Throwable th) {
                    ACLog.w(TAG, "Take it easy. just try initialize compatible with exception: ", th);
                }
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void addBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        httpURLConnection.setDoOutput(true);
        Object[] objArr = null;
        if ((TextUtils.isEmpty(httpURLConnection.getRequestProperty("Content-Type")) ? 'Z' : (char) 28) != 28) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                objArr.hashCode();
            } else {
                httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
        }
        httpURLConnection.connect();
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
        int i2 = PlaceComponentResult + 65;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 != 0 ? '3' : '9') != '3') {
            return;
        }
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if ((r0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.getRequestProperty("Accept-Language")) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r0 = com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult + 15;
        com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        r6.addRequestProperty("Accept-Language", com.iap.ac.android.biz.common.http.HttpUtils.getLanguage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r6 = com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2 + 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        r6 = com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if ((r6 % 2) != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        if (r1 == true) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        r6 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void addHeaderAcceptLanguage(java.net.HttpURLConnection r6) {
        /*
            int r0 = com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult     // Catch: java.lang.Exception -> L60
            int r0 = r0 + 37
            int r1 = r0 % 128
            com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L5e
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r4 = "Accept-Language"
            if (r0 == 0) goto L24
            java.lang.String r0 = r6.getRequestProperty(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            int r5 = r2.length     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 == 0) goto L49
            goto L2e
        L22:
            r6 = move-exception
            throw r6
        L24:
            java.lang.String r0 = r6.getRequestProperty(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L49
        L2e:
            int r0 = com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult
            int r0 = r0 + 15
            int r5 = r0 % 128
            com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r0 = r0 % 2
            java.lang.String r0 = com.iap.ac.android.biz.common.http.HttpUtils.getLanguage()     // Catch: java.lang.Exception -> L5e
            r6.addRequestProperty(r4, r0)     // Catch: java.lang.Exception -> L5e
            int r6 = com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L5e
            int r6 = r6 + 13
            int r0 = r6 % 128
            com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L5e
            int r6 = r6 % 2
        L49:
            int r6 = com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 79
            int r0 = r6 % 128
            com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult = r0
            int r6 = r6 % 2
            if (r6 != 0) goto L56
            goto L57
        L56:
            r1 = 1
        L57:
            if (r1 == r3) goto L5d
            int r6 = r2.length     // Catch: java.lang.Throwable -> L5b
            return
        L5b:
            r6 = move-exception
            throw r6
        L5d:
            return
        L5e:
            r6 = move-exception
            throw r6
        L60:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.http.HttpClient.addHeaderAcceptLanguage(java.net.HttpURLConnection):void");
    }

    private void addHeaderCookie(HttpURLConnection httpURLConnection, URL url) {
        CookieManager cookieManager = this.cookieManager;
        if (!(cookieManager != null)) {
            ACLog.e(TAG, "cookieManager is null!");
            return;
        }
        String cookie = cookieManager.getCookie(url.toString());
        if (!TextUtils.isEmpty(cookie)) {
            int i = PlaceComponentResult + 107;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? 'X' : Typography.dollar) != 'X') {
                httpURLConnection.addRequestProperty("Cookie", cookie);
            } else {
                try {
                    httpURLConnection.addRequestProperty("Cookie", cookie);
                    int i2 = 83 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    private byte[] getContent(HttpURLConnection httpURLConnection) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        PlaceComponentResult = i % 128;
        try {
            if (i % 2 != 0) {
                httpURLConnection = httpURLConnection.getInputStream();
            } else {
                InputStream inputStream = httpURLConnection.getInputStream();
                ?? r0 = 0;
                int length = r0.length;
                httpURLConnection = inputStream;
            }
        } catch (IOException unused) {
            httpURLConnection = httpURLConnection.getErrorStream();
        }
        byte[] readBytes = HttpUtils.readBytes(httpURLConnection);
        int i2 = PlaceComponentResult + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 7 : Typography.greater) != 7) {
            return readBytes;
        }
        int i3 = 62 / 0;
        return readBytes;
    }

    private boolean hasResponseBody(int i) {
        if ((i >= 200 ? '*' : 'H') == '*') {
            int i2 = PlaceComponentResult + 69;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            if ((i != 204 ? (char) 4 : JSONLexer.EOI) != 26) {
                try {
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
                    try {
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        if (i != 304) {
                            int i6 = PlaceComponentResult + 25;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                            int i7 = i6 % 2;
                            int i8 = PlaceComponentResult + 73;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                            int i9 = i8 % 2;
                            return true;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        return false;
    }

    private HttpURLConnection openConnection(URL url, HttpRequest httpRequest) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection createConnection = createConnection(url);
        try {
            if ((httpRequest.timeoutMilliseconds <= 0 ? 'L' : 'T') == 'L') {
                httpRequest.timeoutMilliseconds = 5000;
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
            }
            try {
                createConnection.setConnectTimeout(httpRequest.timeoutMilliseconds);
                createConnection.setReadTimeout(httpRequest.timeoutMilliseconds);
                createConnection.setUseCaches(this.mEnableCache);
                createConnection.setDefaultUseCaches(this.mEnableCache);
                createConnection.setDoInput(true);
                createConnection.setInstanceFollowRedirects(!httpRequest.notFollowRedirects);
                if (!(!"https".equals(url.getProtocol()))) {
                    int i3 = PlaceComponentResult + 115;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    Object[] objArr = null;
                    if (!(i3 % 2 == 0)) {
                        ACLog.i(TAG, "Https protocol, will set SSLContext.");
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, null);
                        ((HttpsURLConnection) createConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                        ACLog.i(TAG, "Https protocol, set SSLContext & SSLSocketFactory successfully.");
                        int length = objArr.length;
                    } else {
                        ACLog.i(TAG, "Https protocol, will set SSLContext.");
                        SSLContext sSLContext2 = SSLContext.getInstance("TLS");
                        sSLContext2.init(null, null, null);
                        ((HttpsURLConnection) createConnection).setSSLSocketFactory(sSLContext2.getSocketFactory());
                        ACLog.i(TAG, "Https protocol, set SSLContext & SSLSocketFactory successfully.");
                    }
                }
                return createConnection;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void setConnectionRequestType(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) throws IOException {
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
            int i = PlaceComponentResult + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        }
        httpURLConnection.setRequestMethod(httpMethod.method);
        if ((httpMethod == HttpMethod.POST ? '\t' : ')') != '\t') {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 == 0 ? 'c' : '(') == 'c') {
                HttpMethod httpMethod2 = HttpMethod.PUT;
                Object[] objArr = null;
                int length = objArr.length;
                if ((httpMethod == httpMethod2 ? JSONLexer.EOI : '\f') != 26) {
                    return;
                }
            } else if (httpMethod != HttpMethod.PUT) {
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i4 = PlaceComponentResult + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        int i5 = i4 % 2;
        Object[] objArr2 = new Object[1];
        a(44483 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{23500, 62990, 'Y', 21245, 60589}, objArr2);
        addBody(httpURLConnection, str.getBytes(((String) objArr2[0]).intern()));
    }

    public HttpClient addInterceptor(HttpInterceptor httpInterceptor) {
        int i = PlaceComponentResult + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            this.interceptors.add(httpInterceptor);
            int i2 = 55 / 0;
        } else {
            this.interceptors.add(httpInterceptor);
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        if (r3 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
    
        if (hasResponseBody(r7) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        r3 = new com.iap.ac.android.biz.common.model.http.HttpResponse(r7, r1, getContent(r2), r2.getHeaderFields());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0098, code lost:
    
        r3 = new com.iap.ac.android.biz.common.model.http.HttpResponse(r7, r1, null, r2.getHeaderFields());
        r7 = com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult + 11;
        com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2 = r7 % 128;
        r7 = r7 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.iap.ac.android.biz.common.model.http.HttpResponse executed(com.iap.ac.android.biz.common.http.RealCall r7) throws java.lang.Exception {
        /*
            r6 = this;
            java.lang.String r0 = "HttpClient"
            com.iap.ac.android.biz.common.model.http.HttpRequest r7 = r7.request     // Catch: java.lang.Exception -> Ld3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "performRequest request = "
            r1.append(r2)     // Catch: java.lang.Exception -> Ld3
            r1.append(r7)     // Catch: java.lang.Exception -> Ld3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Ld3
            com.iap.ac.android.common.log.ACLog.v(r0, r1)     // Catch: java.lang.Exception -> Ld3
            java.lang.String r1 = r7.url     // Catch: java.lang.Exception -> Ld3
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Ld3
            if (r1 != 0) goto Lcb
            java.net.URL r1 = new java.net.URL
            java.lang.String r2 = r7.url
            r1.<init>(r2)
            java.net.HttpURLConnection r2 = r6.openConnection(r1, r7)
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.headers
            addHeaders(r2, r3)
            r6.addHeaderCookie(r2, r1)
            addHeaderAcceptLanguage(r2)
            com.iap.ac.android.biz.common.model.http.HttpMethod r1 = r7.method
            java.lang.String r7 = r7.data
            r6.setConnectionRequestType(r2, r1, r7)
            int r7 = r2.getResponseCode()     // Catch: java.io.IOException -> L42
            goto L4e
        L42:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.iap.ac.android.common.log.ACLog.d(r0, r7)
            int r7 = r2.getResponseCode()
        L4e:
            r1 = -1
            r3 = 81
            if (r7 == r1) goto L56
            r1 = 70
            goto L58
        L56:
            r1 = 81
        L58:
            if (r1 == r3) goto Lc3
            int r1 = com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 15
            int r3 = r1 % 128
            com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult = r3
            int r1 = r1 % 2
            r3 = 14
            if (r1 != 0) goto L6b
            r1 = 49
            goto L6d
        L6b:
            r1 = 14
        L6d:
            r4 = 0
            if (r1 == r3) goto L80
            java.lang.String r1 = r2.getResponseMessage()
            boolean r3 = r6.hasResponseBody(r7)
            r4.hashCode()     // Catch: java.lang.Throwable -> L7e
            if (r3 == 0) goto L98
            goto L8a
        L7e:
            r7 = move-exception
            throw r7
        L80:
            java.lang.String r1 = r2.getResponseMessage()
            boolean r3 = r6.hasResponseBody(r7)
            if (r3 == 0) goto L98
        L8a:
            com.iap.ac.android.biz.common.model.http.HttpResponse r3 = new com.iap.ac.android.biz.common.model.http.HttpResponse
            byte[] r4 = r6.getContent(r2)
            java.util.Map r5 = r2.getHeaderFields()
            r3.<init>(r7, r1, r4, r5)
            goto Lab
        L98:
            com.iap.ac.android.biz.common.model.http.HttpResponse r3 = new com.iap.ac.android.biz.common.model.http.HttpResponse
            java.util.Map r5 = r2.getHeaderFields()
            r3.<init>(r7, r1, r4, r5)
            int r7 = com.iap.ac.android.biz.common.http.HttpClient.PlaceComponentResult
            int r7 = r7 + 11
            int r1 = r7 % 128
            com.iap.ac.android.biz.common.http.HttpClient.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r7 = r7 % 2
        Lab:
            r6.setCookie(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "performRequest response = "
            r7.append(r1)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            com.iap.ac.android.common.log.ACLog.v(r0, r7)
            return r3
        Lc3:
            com.iap.ac.android.biz.common.http.HttpException r7 = new com.iap.ac.android.biz.common.http.HttpException
            java.lang.String r0 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r0)
            throw r7
        Lcb:
            com.iap.ac.android.biz.common.http.HttpException r7 = new com.iap.ac.android.biz.common.http.HttpException
            java.lang.String r0 = "request.url is empty!"
            r7.<init>(r0)
            throw r7
        Ld3:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.http.HttpClient.executed(com.iap.ac.android.biz.common.http.RealCall):com.iap.ac.android.biz.common.model.http.HttpResponse");
    }

    public Call newCall(HttpRequest httpRequest) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? '5' : (char) 25) != '5') {
            return RealCall.newRealCall(this, httpRequest, this.interceptors);
        }
        try {
            Call newRealCall = RealCall.newRealCall(this, httpRequest, this.interceptors);
            Object obj = null;
            obj.hashCode();
            return newRealCall;
        } catch (Exception e) {
            throw e;
        }
    }

    public HttpClient removeInterceptor(HttpInterceptor httpInterceptor) {
        int i = PlaceComponentResult + 51;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        this.interceptors.remove(httpInterceptor);
        int i3 = PlaceComponentResult + 95;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? 'D' : (char) 22) != 22) {
            Object[] objArr = null;
            int length = objArr.length;
            return this;
        }
        return this;
    }

    private HttpURLConnection createConnection(URL url) throws IOException {
        int i = PlaceComponentResult + 31;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection())));
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i3 = PlaceComponentResult + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return httpURLConnection;
    }

    public static void addHeaders(HttpURLConnection httpURLConnection, Map<String, ?> map) {
        Map.Entry<String, ?> next;
        String key;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            if ((map != null ? '%' : (char) 6) != '%') {
                return;
            }
        } else if (map == null) {
            return;
        }
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!(it.hasNext())) {
                return;
            }
            try {
                int i2 = PlaceComponentResult + 31;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if (i2 % 2 != 0) {
                    next = it.next();
                    key = next.getKey();
                    int i3 = 52 / 0;
                    if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(key))) {
                        httpURLConnection.addRequestProperty(key, String.valueOf(next.getValue()));
                    }
                } else {
                    next = it.next();
                    key = next.getKey();
                    if ((TextUtils.isEmpty(httpURLConnection.getRequestProperty(key)) ? '-' : 'S') != 'S') {
                        httpURLConnection.addRequestProperty(key, String.valueOf(next.getValue()));
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void setCookie(HttpURLConnection httpURLConnection) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (this.cookieManager == null) {
            ACLog.e(TAG, "cookieManager is null!");
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        List<String> list = headerFields.get("Set-Cookie");
        List<String> list2 = headerFields.get(HttpHeaders.SET_COOKIE2);
        String obj = httpURLConnection.getURL().toString();
        ArrayList arrayList = new ArrayList();
        if ((list != null ? '\b' : (char) 16) == '\b') {
            try {
                arrayList.addAll(list);
            } catch (Exception e) {
                throw e;
            }
        }
        if ((list2 != null ? 'b' : (char) 22) == 'b') {
            try {
                int i3 = PlaceComponentResult + 109;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                arrayList.addAll(list2);
            } catch (Exception e2) {
                throw e2;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
            this.cookieManager.setCookie(obj, (String) it.next());
            int i7 = PlaceComponentResult + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
            int i8 = i7 % 2;
        }
        if ((Build.VERSION.SDK_INT >= 21 ? '[' : '(') != '(') {
            this.cookieManager.flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        try {
            int i3 = $10 + 35;
            try {
                $11 = i3 % 128;
                int i4 = i3 % 2;
                while (true) {
                    if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 29 : ':') == ':') {
                        break;
                    }
                    int i5 = $10 + 65;
                    $11 = i5 % 128;
                    if (i5 % 2 == 0) {
                        jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] * (getonboardingscenario.getAuthRequestContext & getonboardingscenario.MyBillsEntityDataFactory)) % (4796183387843776835L | BuiltInFictitiousFunctionClassFactory);
                        i2 = getonboardingscenario.getAuthRequestContext % 0;
                    } else {
                        jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ BuiltInFictitiousFunctionClassFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                        i2 = getonboardingscenario.getAuthRequestContext + 1;
                    }
                    getonboardingscenario.getAuthRequestContext = i2;
                }
                char[] cArr2 = new char[length];
                getonboardingscenario.getAuthRequestContext = 0;
                int i6 = $10 + 85;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                while (true) {
                    if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '\\' : 'Y') != '\\') {
                        objArr[0] = new String(cArr2);
                        return;
                    } else {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        getonboardingscenario.getAuthRequestContext++;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
