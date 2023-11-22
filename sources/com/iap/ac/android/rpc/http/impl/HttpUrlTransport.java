package com.iap.ac.android.rpc.http.impl;

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
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport;
import com.iap.ac.android.common.rpc.interfaces.HttpsTransportEventListener;
import com.iap.ac.android.common.rpc.model.HttpMethod;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.rpc.http.utils.HttpTransportUtils;
import id.dana.cashier.view.InputCardNumberView;
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
import o.E;

/* loaded from: classes3.dex */
public class HttpUrlTransport implements AbstractHttpTransport {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final int DEFAULT_TIMEOUT_MS = 30000;
    public static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    public static final String PROTOCOL_HTTPS = "https";
    private static char PlaceComponentResult;
    public static final String TAG;
    private static int getAuthRequestContext;
    public CookieManager cookieManager;
    public HttpsTransportEventListener httpsTransportEventListener;
    public boolean mEnableCache;

    static {
        getAuthRequestContext();
        TAG = HttpTransportUtils.logTag("HttpUrlTransport");
        int i = MyBillsEntityDataFactory + 109;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
    }

    public HttpUrlTransport(boolean z, Context context) {
        try {
            this.httpsTransportEventListener = new HttpsTransportEventListener() { // from class: com.iap.ac.android.rpc.http.impl.HttpUrlTransport.1
                @Override // com.iap.ac.android.common.rpc.interfaces.HttpsTransportEventListener
                public void onConnect(HttpsURLConnection httpsURLConnection) {
                }
            };
            this.mEnableCache = z;
            this.cookieManager = CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    CookieSyncManager.createInstance(context).sync();
                    int i = BuiltInFictitiousFunctionClassFactory + 115;
                    MyBillsEntityDataFactory = i % 128;
                    if ((i % 2 == 0 ? 'D' : InputCardNumberView.DIVIDER) != 'D') {
                        return;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                } catch (Throwable th) {
                    ACLog.w(TAG, "Take it easy. just try initialize compatible with exception: ", th);
                }
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 53;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void addBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        try {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.setDoOutput(true);
            if (!(!TextUtils.isEmpty(httpURLConnection.getRequestProperty("Content-Type")))) {
                int i = MyBillsEntityDataFactory + 47;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
            httpURLConnection.connect();
            if (!(httpURLConnection instanceof HttpsURLConnection ? false : true)) {
                this.httpsTransportEventListener.onConnect((HttpsURLConnection) httpURLConnection);
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArr);
            dataOutputStream.close();
            int i3 = MyBillsEntityDataFactory + 107;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        PlaceComponentResult = (char) 13492;
        KClassImpl$Data$declaredNonStaticMembers$2 = 3117514156060273066L;
        getAuthRequestContext = -956812108;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private byte[] getContent(HttpURLConnection httpURLConnection) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 115;
        MyBillsEntityDataFactory = i % 128;
        try {
            if (!(i % 2 == 0)) {
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
        byte[] readBytes = HttpTransportUtils.readBytes(httpURLConnection);
        int i2 = MyBillsEntityDataFactory + 99;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return readBytes;
    }

    private boolean hasResponseBody(int i) {
        int i2 = MyBillsEntityDataFactory + 83;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 == 0 ? i >= 200 : i >= 14512) {
            int i3 = MyBillsEntityDataFactory + 69;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            if (!(i == 204) && i != 304) {
                try {
                    int i5 = BuiltInFictitiousFunctionClassFactory + 5;
                    try {
                        MyBillsEntityDataFactory = i5 % 128;
                        return i5 % 2 == 0 ? true : true;
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

    private void setConnectionRequestType(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) throws IOException {
        int i = MyBillsEntityDataFactory + 73;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
            int i3 = MyBillsEntityDataFactory + 53;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        }
        httpURLConnection.setRequestMethod(httpMethod.method);
        if ((httpMethod == HttpMethod.POST) || httpMethod == HttpMethod.PUT) {
            if ((!TextUtils.isEmpty(str) ? '7' : '0') != '7') {
                return;
            }
            Object[] objArr = new Object[1];
            a(new char[]{41681, 10405, 49196, 45339, 40861}, new char[]{39034, 45447, 8480, 37778}, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 37408), new char[]{23838, 18625, 63645, 6086}, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 548505496, objArr);
            addBody(httpURLConnection, str.getBytes(((String) objArr[0]).intern()));
            int i5 = BuiltInFictitiousFunctionClassFactory + 53;
            MyBillsEntityDataFactory = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private void setCookie(HttpURLConnection httpURLConnection) {
        if (this.cookieManager == null) {
            ACLog.e(TAG, "cookieManager is null!");
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        List<String> list = headerFields.get("Set-Cookie");
        List<String> list2 = headerFields.get(HttpHeaders.SET_COOKIE2);
        String obj = httpURLConnection.getURL().toString();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if ((list2 != null ? '6' : Typography.dollar) != '$') {
            arrayList.addAll(list2);
        }
        try {
            Iterator it = arrayList.iterator();
            int i = MyBillsEntityDataFactory + 19;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            while (true) {
                int i2 = i % 2;
                if (!it.hasNext()) {
                    break;
                }
                int i3 = BuiltInFictitiousFunctionClassFactory + 113;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                try {
                    this.cookieManager.setCookie(obj, (String) it.next());
                    i = MyBillsEntityDataFactory + 71;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                int i5 = BuiltInFictitiousFunctionClassFactory + 41;
                MyBillsEntityDataFactory = i5 % 128;
                int i6 = i5 % 2;
                this.cookieManager.flush();
                return;
            }
            CookieSyncManager.getInstance().sync();
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r0 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (com.iap.ac.android.rpc.http.utils.OkHttpUtils.canUseOkhttp(r6) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        return com.iap.ac.android.rpc.http.impl.OkHttpTransport.getInstance().performRequest(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        r0 = new java.net.URL(r6.url);
        r1 = openConnection(r0, r6);
        addHeaders(r1, r6.headers);
        addHeaderCookie(r1, r0);
        addHeaderAcceptLanguage(r1);
        setConnectionRequestType(r1, r6.method, r6.data);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
    
        r6 = r1.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        com.iap.ac.android.common.log.ACLog.d(com.iap.ac.android.rpc.http.impl.HttpUrlTransport.TAG, r6.getMessage());
        r6 = r1.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
    
        if (r3 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b0, code lost:
    
        if (hasResponseBody(r6) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b2, code lost:
    
        r2 = new com.iap.ac.android.common.rpc.model.HttpResponse(r6, r0, getContent(r1), r1.getHeaderFields());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c0, code lost:
    
        r3 = new com.iap.ac.android.common.rpc.model.HttpResponse(r6, r0, null, r1.getHeaderFields());
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c9, code lost:
    
        r6 = com.iap.ac.android.rpc.http.impl.HttpUrlTransport.BuiltInFictitiousFunctionClassFactory + 123;
        com.iap.ac.android.rpc.http.impl.HttpUrlTransport.MyBillsEntityDataFactory = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d3, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d4, code lost:
    
        setCookie(r1);
        r6 = com.iap.ac.android.rpc.http.impl.HttpUrlTransport.TAG;
        r0 = new java.lang.StringBuilder();
        r0.append("performRequest response = ");
        r0.append(r2);
        com.iap.ac.android.common.log.ACLog.v(r6, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ee, code lost:
    
        return r2;
     */
    @Override // com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.iap.ac.android.common.rpc.model.HttpResponse performRequest(com.iap.ac.android.common.rpc.model.HttpRequest r6) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.rpc.http.impl.HttpUrlTransport.performRequest(com.iap.ac.android.common.rpc.model.HttpRequest):com.iap.ac.android.common.rpc.model.HttpResponse");
    }

    public void setEventListener(HttpsTransportEventListener httpsTransportEventListener) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 41;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            this.httpsTransportEventListener = httpsTransportEventListener;
            int i3 = MyBillsEntityDataFactory + 93;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void addHeaderAcceptLanguage(HttpURLConnection httpURLConnection) {
        int i = BuiltInFictitiousFunctionClassFactory + 97;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if ((TextUtils.isEmpty(httpURLConnection.getRequestProperty("Accept-Language")) ? 'A' : 'D') != 'D') {
            try {
                int i3 = BuiltInFictitiousFunctionClassFactory + 63;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 != 0) {
                    httpURLConnection.addRequestProperty("Accept-Language", HttpTransportUtils.getLanguage());
                    return;
                }
                try {
                    httpURLConnection.addRequestProperty("Accept-Language", HttpTransportUtils.getLanguage());
                    Object[] objArr = null;
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private void addHeaderCookie(HttpURLConnection httpURLConnection, URL url) {
        int i = MyBillsEntityDataFactory + 109;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            CookieManager cookieManager = this.cookieManager;
            if (cookieManager == null) {
                try {
                    ACLog.e(TAG, "cookieManager is null!");
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            String cookie = cookieManager.getCookie(url.toString());
            if ((!TextUtils.isEmpty(cookie) ? 'Q' : (char) 6) != 6) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 99;
                MyBillsEntityDataFactory = i3 % 128;
                boolean z = i3 % 2 != 0;
                httpURLConnection.addRequestProperty("Cookie", cookie);
                if (!z) {
                    Object obj = null;
                    obj.hashCode();
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void addHeaders(HttpURLConnection httpURLConnection, Map<String, ?> map) {
        Map.Entry<String, ?> next;
        String key;
        int i = BuiltInFictitiousFunctionClassFactory + 43;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            int i2 = 14 / 0;
            if (map == null) {
                return;
            }
        } else if (map == null) {
            return;
        }
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            try {
                if ((it.hasNext() ? Typography.greater : (char) 15) != '>') {
                    return;
                }
                int i3 = MyBillsEntityDataFactory + 95;
                try {
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    if ((i3 % 2 != 0 ? 'E' : 'b') != 'E') {
                        next = it.next();
                        key = next.getKey();
                        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(key))) {
                            httpURLConnection.addRequestProperty(key, String.valueOf(next.getValue()));
                            int i4 = BuiltInFictitiousFunctionClassFactory + 65;
                            MyBillsEntityDataFactory = i4 % 128;
                            int i5 = i4 % 2;
                        }
                    } else {
                        next = it.next();
                        key = next.getKey();
                        int i6 = 0 / 0;
                        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(key))) {
                            httpURLConnection.addRequestProperty(key, String.valueOf(next.getValue()));
                            int i42 = BuiltInFictitiousFunctionClassFactory + 65;
                            MyBillsEntityDataFactory = i42 % 128;
                            int i52 = i42 % 2;
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

    private HttpURLConnection createConnection(URL url) throws IOException {
        int i = MyBillsEntityDataFactory + 93;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection())));
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 85;
            try {
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return httpURLConnection;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private HttpURLConnection openConnection(URL url, HttpRequest httpRequest) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        try {
            int i = MyBillsEntityDataFactory + 81;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            HttpURLConnection createConnection = createConnection(url);
            if ((httpRequest.timeoutMilliseconds <= 0 ? 'O' : JSONLexer.EOI) == 'O') {
                int i3 = BuiltInFictitiousFunctionClassFactory + 87;
                MyBillsEntityDataFactory = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    httpRequest.timeoutMilliseconds = 30000;
                } else {
                    try {
                        httpRequest.timeoutMilliseconds = 28224;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i4 = MyBillsEntityDataFactory + 81;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                int i5 = i4 % 2;
            }
            createConnection.setConnectTimeout(httpRequest.timeoutMilliseconds);
            createConnection.setReadTimeout(httpRequest.timeoutMilliseconds);
            createConnection.setUseCaches(this.mEnableCache);
            createConnection.setDefaultUseCaches(this.mEnableCache);
            createConnection.setDoInput(true);
            createConnection.setInstanceFollowRedirects(!httpRequest.notFollowRedirects);
            if (("https".equals(url.getProtocol()) ? ',' : (char) 4) != 4) {
                String str = TAG;
                ACLog.i(str, "Https protocol, will set SSLContext.");
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                ((HttpsURLConnection) createConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                ACLog.i(str, "Https protocol, set SSLContext & SSLSocketFactory successfully.");
            }
            return createConnection;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? (char) 4 : (char) 24) == 4) {
                int i2 = $11 + 37;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr[e.KClassImpl$Data$declaredNonStaticMembers$2] ^ cArr4[i5]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (getAuthRequestContext ^ 4360990799332652212L))) ^ ((char) (PlaceComponentResult ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                String str = new String(cArr6);
                int i6 = $10 + 47;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
