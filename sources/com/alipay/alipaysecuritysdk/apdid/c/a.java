package com.alipay.alipaysecuritysdk.apdid.c;

import android.os.SystemClock;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import id.dana.data.here.HereOauthManager;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.net.URL;
import java.net.URLEncoder;
import o.C;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* loaded from: classes3.dex */
public final class a {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 0;

    /* renamed from: a  reason: collision with root package name */
    private static String f6852a = "";
    private static int getAuthRequestContext = 0;
    private static int scheduleImpl = 1;

    static {
        try {
            MyBillsEntityDataFactory();
            int i = getAuthRequestContext + 15;
            scheduleImpl = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = (char) 28372;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 2305;
        PlaceComponentResult = (char) 13239;
        BuiltInFictitiousFunctionClassFactory = (char) 15186;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if (r3 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        r3 = com.alipay.alipaysecuritysdk.apdid.c.a.scheduleImpl + 123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        com.alipay.alipaysecuritysdk.apdid.c.a.getAuthRequestContext = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        if ((r3 % 2) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        r3 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002f, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0030, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0031, code lost:
    
        r0 = com.alipay.alipaysecuritysdk.apdid.g.d.c(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0035, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0038, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0039, code lost:
    
        if (r1 == true) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0041, code lost:
    
        if (r0.equals("") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder("https://");
        r1.append(r0);
        r1.append("/postToken.json");
        com.alipay.alipaysecuritysdk.apdid.c.a.f6852a = r1.toString();
        r3 = r3.getPackageName();
        b(r4, r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        if (com.alipay.alipaysecuritysdk.common.e.e.c(r4) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
    
        r0 = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        r0 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        if (r0 == 24) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
    
        if (com.alipay.alipaysecuritysdk.common.e.e.c(r5) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0076, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0077, code lost:
    
        com.alipay.alipaysecuritysdk.common.e.f.a().b(new com.alipay.alipaysecuritysdk.apdid.c.a.AnonymousClass1());
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0083, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
    
        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r3 == null) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r3, final java.lang.String r4, final java.lang.String r5) {
        /*
            int r0 = com.alipay.alipaysecuritysdk.apdid.c.a.scheduleImpl
            int r0 = r0 + 85
            int r1 = r0 % 128
            com.alipay.alipaysecuritysdk.apdid.c.a.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L1b
            r0 = 81
            int r0 = r0 / r1
            if (r3 != 0) goto L31
            goto L1d
        L19:
            r3 = move-exception
            throw r3
        L1b:
            if (r3 != 0) goto L31
        L1d:
            int r3 = com.alipay.alipaysecuritysdk.apdid.c.a.scheduleImpl     // Catch: java.lang.Exception -> L2f
            int r3 = r3 + 123
            int r4 = r3 % 128
            com.alipay.alipaysecuritysdk.apdid.c.a.getAuthRequestContext = r4     // Catch: java.lang.Exception -> L2f
            int r3 = r3 % 2
            if (r3 == 0) goto L2e
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L2c
            return
        L2c:
            r3 = move-exception
            throw r3
        L2e:
            return
        L2f:
            r3 = move-exception
            throw r3
        L31:
            java.lang.String r0 = com.alipay.alipaysecuritysdk.apdid.g.d.c(r3)     // Catch: java.lang.Exception -> L84
            if (r0 == 0) goto L38
            goto L39
        L38:
            r1 = 1
        L39:
            if (r1 == r2) goto L83
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)     // Catch: java.lang.Exception -> L84
            if (r1 == 0) goto L44
            return
        L44:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = "https://"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L84
            r1.append(r0)     // Catch: java.lang.Exception -> L84
            java.lang.String r0 = "/postToken.json"
            r1.append(r0)     // Catch: java.lang.Exception -> L84
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L84
            com.alipay.alipaysecuritysdk.apdid.c.a.f6852a = r0     // Catch: java.lang.Exception -> L84
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L84
            b(r4, r3, r5)     // Catch: java.lang.Exception -> L84
            boolean r0 = com.alipay.alipaysecuritysdk.common.e.e.c(r4)     // Catch: java.lang.Exception -> L84
            r1 = 24
            if (r0 == 0) goto L6b
            r0 = 24
            goto L6d
        L6b:
            r0 = 70
        L6d:
            if (r0 == r1) goto L70
            goto L77
        L70:
            boolean r0 = com.alipay.alipaysecuritysdk.common.e.e.c(r5)     // Catch: java.lang.Exception -> L84
            if (r0 == 0) goto L77
            return
        L77:
            com.alipay.alipaysecuritysdk.common.e.f r0 = com.alipay.alipaysecuritysdk.common.e.f.a()     // Catch: java.lang.Exception -> L84
            com.alipay.alipaysecuritysdk.apdid.c.a$1 r1 = new com.alipay.alipaysecuritysdk.apdid.c.a$1     // Catch: java.lang.Exception -> L84
            r1.<init>()     // Catch: java.lang.Exception -> L84
            r0.b(r1)     // Catch: java.lang.Exception -> L84
        L83:
            return
        L84:
            r3 = move-exception
            java.lang.String r4 = "SEC_SDK-apdid"
            com.alipay.alipaysecuritysdk.common.c.b.a(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.apdid.c.a.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static String b(String str, String str2, String str3) {
        String str4;
        try {
            str4 = new URL(com.alipay.alipaysecuritysdk.apdid.a.a.a().gateway).getHost();
            try {
                int i = scheduleImpl + 23;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", e2);
            str4 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f6852a);
        sb.append("?tk=");
        sb.append(URLEncoder.encode(str, HereOauthManager.ENC));
        sb.append("&ck=");
        sb.append(URLEncoder.encode(str3, HereOauthManager.ENC));
        sb.append("&app=");
        sb.append(str2);
        sb.append("&t=");
        sb.append(System.currentTimeMillis());
        sb.append("&host=");
        sb.append(str4);
        return sb.toString();
    }

    private static HttpClient a(HttpParams httpParams) {
        try {
            HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
            Object[] objArr = new Object[1];
            c(6 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{43036, 34475, 63281, 50420, 38206, 23326}, objArr);
            HttpProtocolParams.setContentCharset(httpParams, ((String) objArr[0]).intern());
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(SemanticAttributes.FaasTriggerValues.HTTP, PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), WebSocket.DEFAULT_WSS_PORT));
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
            int i = scheduleImpl + 45;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return defaultHttpClient;
        } catch (Exception e) {
            DefaultHttpClient defaultHttpClient2 = new DefaultHttpClient(httpParams);
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", "send agent request, create https socket error.create default socket.", e);
            return defaultHttpClient2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0092: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:40:0x0092 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "SEC_SDK-apdid"
            r1 = 1
            r2 = 0
            org.apache.http.params.BasicHttpParams r3 = new org.apache.http.params.BasicHttpParams     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r3.<init>()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r4 = "http.connection.timeout"
            r5 = 30000(0x7530, float:4.2039E-41)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r3.setParameter(r4, r6)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r4 = "http.socket.timeout"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r3.setParameter(r4, r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            org.apache.http.client.HttpClient r3 = a(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            org.apache.http.client.methods.HttpGet r4 = new org.apache.http.client.methods.HttpGet     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            java.lang.String r7 = b(r7, r8, r9)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            r4.<init>(r7)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            org.apache.http.HttpResponse r7 = com.google.firebase.perf.network.FirebasePerfHttpClient.execute(r3, r4)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            org.apache.http.StatusLine r8 = r7.getStatusLine()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            int r8 = r8.getStatusCode()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 != r9) goto L42
            org.apache.http.HttpEntity r7 = r7.getEntity()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            org.apache.http.util.EntityUtils.toString(r7)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            goto L50
        L42:
            org.apache.http.StatusLine r8 = r7.getStatusLine()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            r8.getStatusCode()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            org.apache.http.StatusLine r7 = r7.getStatusLine()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
            r7.getReasonPhrase()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L91
        L50:
            org.apache.http.conn.ClientConnectionManager r7 = r3.getConnectionManager()     // Catch: java.lang.Exception -> L7a
            if (r7 == 0) goto L57
            r1 = 0
        L57:
            if (r1 == 0) goto L5a
            goto L7e
        L5a:
            r7.shutdown()     // Catch: java.lang.Exception -> L7a
            return
        L5e:
            r7 = move-exception
            goto L64
        L60:
            r7 = move-exception
            goto L93
        L62:
            r7 = move-exception
            r3 = r2
        L64:
            com.alipay.alipaysecuritysdk.common.c.b.a(r0, r7)     // Catch: java.lang.Throwable -> L91
            if (r3 == 0) goto L7e
            org.apache.http.conn.ClientConnectionManager r7 = r3.getConnectionManager()     // Catch: java.lang.Exception -> L7a
            r8 = 20
            if (r7 == 0) goto L73
            r1 = 20
        L73:
            if (r1 == r8) goto L76
            goto L7e
        L76:
            r7.shutdown()     // Catch: java.lang.Exception -> L7a
            return
        L7a:
            r7 = move-exception
            com.alipay.alipaysecuritysdk.common.c.b.a(r0, r7)
        L7e:
            int r7 = com.alipay.alipaysecuritysdk.apdid.c.a.scheduleImpl
            int r7 = r7 + 23
            int r8 = r7 % 128
            com.alipay.alipaysecuritysdk.apdid.c.a.getAuthRequestContext = r8
            int r7 = r7 % 2
            if (r7 == 0) goto L90
            r2.hashCode()     // Catch: java.lang.Throwable -> L8e
            return
        L8e:
            r7 = move-exception
            throw r7
        L90:
            return
        L91:
            r7 = move-exception
            r2 = r3
        L93:
            if (r2 == 0) goto Lb1
            org.apache.http.conn.ClientConnectionManager r8 = r2.getConnectionManager()     // Catch: java.lang.Exception -> Lad
            if (r8 == 0) goto Lb1
            r8.shutdown()     // Catch: java.lang.Exception -> Lad
            int r8 = com.alipay.alipaysecuritysdk.apdid.c.a.scheduleImpl     // Catch: java.lang.Exception -> Lab
            int r8 = r8 + 125
            int r9 = r8 % 128
            com.alipay.alipaysecuritysdk.apdid.c.a.getAuthRequestContext = r9     // Catch: java.lang.Exception -> La9
            int r8 = r8 % 2
            goto Lb1
        La9:
            r7 = move-exception
            throw r7
        Lab:
            r7 = move-exception
            throw r7
        Lad:
            r8 = move-exception
            com.alipay.alipaysecuritysdk.common.c.b.a(r0, r8)
        Lb1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.apdid.c.a.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $10 + 41;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (!(c.BuiltInFictitiousFunctionClassFactory >= cArr.length)) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = 0;
                while (true) {
                    if (!(i5 < 16)) {
                        break;
                    }
                    int i6 = $11 + 117;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i5++;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
