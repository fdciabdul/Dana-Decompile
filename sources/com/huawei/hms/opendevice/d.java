package com.huawei.hms.opendevice;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes8.dex */
public abstract class d {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static int scheduleImpl = 1;
    private static char[] getAuthRequestContext = {39877, 39876, 39890, 39917, 39904};
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
    private static int PlaceComponentResult = 909155224;

    /* loaded from: classes8.dex */
    enum a {
        GET("GET"),
        POST("POST");

        public String d;

        a(String str) {
            this.d = str;
        }

        public final String a() {
            return this.d;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (android.text.TextUtils.isEmpty(r12) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if (r2 == true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        r2 = com.huawei.hms.opendevice.d.MyBillsEntityDataFactory + 87;
        com.huawei.hms.opendevice.d.scheduleImpl = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (android.text.TextUtils.isEmpty(r13) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r2 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        r11 = PlaceComponentResult(r11, r12, com.huawei.hms.opendevice.d.a.b.a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r11 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        com.huawei.secure.android.common.util.IOUtil.getAuthRequestContext(null);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(null);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(null);
        com.huawei.hms.opendevice.s.MyBillsEntityDataFactory(r11);
        com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        r12 = new java.io.BufferedOutputStream(r11.getOutputStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        r6 = new java.lang.Object[1];
        a((android.view.ViewConfiguration.getEdgeSlop() >> 16) + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, r6);
        r12.write(r13.getBytes(((java.lang.String) r6[0]).intern()));
        r12.flush();
        r2 = r11.getResponseCode();
        r13 = new java.lang.StringBuilder();
        r13.append("http post response code: ");
        r13.append(r2);
        com.huawei.hms.support.log.HMSLog.d("PushHttpClient", r13.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
    
        if (r2 < 400) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
    
        r13 = com.huawei.hms.opendevice.d.scheduleImpl + 77;
        com.huawei.hms.opendevice.d.MyBillsEntityDataFactory = r13 % 128;
        r13 = r13 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
    
        r13 = r11.getErrorStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bf, code lost:
    
        r13 = r11.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c3, code lost:
    
        r3 = new java.io.BufferedInputStream(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c8, code lost:
    
        r2 = com.huawei.hms.opendevice.s.BuiltInFictitiousFunctionClassFactory(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
    
        com.huawei.secure.android.common.util.IOUtil.getAuthRequestContext(r12);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(r13);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(r3);
        com.huawei.hms.opendevice.s.MyBillsEntityDataFactory(r11);
        com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dc, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
    
        r3 = 0;
        r11 = r11;
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e0, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e2, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e5, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
    
        r2 = r13;
        r13 = null;
        r3 = 0;
        r11 = r11;
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00eb, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ed, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ee, code lost:
    
        r2 = r12;
        r13 = null;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f2, code lost:
    
        r2 = r11;
        r11 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f5, code lost:
    
        r3 = r13;
        r11 = r11;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f8, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f9, code lost:
    
        r12 = null;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fc, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append("http execute encounter unknown exception - http code:");
        r5.append(r2);
        com.huawei.hms.support.log.HMSLog.w("PushHttpClient", r5.toString());
        r11 = r11;
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0111, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0112, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0113, code lost:
    
        r13 = com.huawei.hms.opendevice.d.scheduleImpl + 65;
        com.huawei.hms.opendevice.d.MyBillsEntityDataFactory = r13 % 128;
        r13 = r13 % 2;
        r13 = null;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x011e, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append("http execute encounter RuntimeException - http code:");
        r5.append(r2);
        com.huawei.hms.support.log.HMSLog.w("PushHttpClient", r5.toString());
        r11 = r11;
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0133, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0134, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0135, code lost:
    
        r13 = null;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0137, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append("http execute encounter IOException - http code:");
        r5.append(r2);
        com.huawei.hms.support.log.HMSLog.w("PushHttpClient", r5.toString());
        r11 = r11;
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014b, code lost:
    
        com.huawei.secure.android.common.util.IOUtil.getAuthRequestContext(r12);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(r13);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(r3);
        com.huawei.hms.opendevice.s.MyBillsEntityDataFactory(r11);
        com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r13 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015b, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015c, code lost:
    
        r11 = r11;
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
    
        r4 = r12;
        r3 = r3;
        r11 = r11;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x015f, code lost:
    
        com.huawei.secure.android.common.util.IOUtil.getAuthRequestContext(r4);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(r13);
        com.huawei.secure.android.common.util.IOUtil.PlaceComponentResult(r3);
        com.huawei.hms.opendevice.s.MyBillsEntityDataFactory(r11);
        com.huawei.hms.support.log.HMSLog.i("PushHttpClient", "close connection");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016e, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r13 != null) goto L10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String BuiltInFictitiousFunctionClassFactory(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.d.BuiltInFictitiousFunctionClassFactory(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    private static HttpURLConnection PlaceComponentResult(Context context, String str, String str2) throws Exception {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection())));
                PlaceComponentResult(context, httpURLConnection);
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
                httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
                int i = scheduleImpl + 105;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return httpURLConnection;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: Exception -> 0x0018, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0018, blocks: (B:7:0x000d, B:14:0x0021, B:24:0x0052), top: B:46:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void PlaceComponentResult(android.content.Context r4, java.net.HttpURLConnection r5) throws java.lang.Exception {
        /*
            java.lang.String r0 = "PushHttpClient"
            boolean r1 = r5 instanceof javax.net.ssl.HttpsURLConnection
            r2 = 1
            if (r1 == 0) goto L9
            r1 = 1
            goto Lb
        L9:
            r1 = 68
        Lb:
            if (r1 == r2) goto L1a
            int r4 = com.huawei.hms.opendevice.d.scheduleImpl     // Catch: java.lang.Exception -> L18
            int r4 = r4 + 55
            int r5 = r4 % 128
            com.huawei.hms.opendevice.d.MyBillsEntityDataFactory = r5
            int r4 = r4 % 2
            return
        L18:
            r4 = move-exception
            goto L7c
        L1a:
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5
            r1 = 0
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactory r4 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.PlaceComponentResult(r4)     // Catch: java.lang.IllegalArgumentException -> L2c java.lang.IllegalAccessException -> L32 java.io.IOException -> L38 java.security.GeneralSecurityException -> L3e java.security.KeyStoreException -> L44 java.security.NoSuchAlgorithmException -> L4a
            int r0 = com.huawei.hms.opendevice.d.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L18
            int r0 = r0 + 93
            int r3 = r0 % 128
            com.huawei.hms.opendevice.d.scheduleImpl = r3     // Catch: java.lang.Exception -> L18
            int r0 = r0 % 2
            goto L50
        L2c:
            java.lang.String r4 = "Get SocketFactory Illegal Argument Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r4)
            goto L4f
        L32:
            java.lang.String r4 = "Get SocketFactory Illegal Access Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r4)
            goto L4f
        L38:
            java.lang.String r4 = "Get SocketFactory IO Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r4)
            goto L4f
        L3e:
            java.lang.String r4 = "Get SocketFactory General Security Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r4)
            goto L4f
        L44:
            java.lang.String r4 = "Get SocketFactory Key Store exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r4)
            goto L4f
        L4a:
            java.lang.String r4 = "Get SocketFactory Algorithm Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r4)
        L4f:
            r4 = r1
        L50:
            if (r4 == 0) goto L7d
            int r0 = com.huawei.hms.opendevice.d.scheduleImpl     // Catch: java.lang.Exception -> L18
            int r0 = r0 + 107
            int r3 = r0 % 128
            com.huawei.hms.opendevice.d.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L7a
            int r0 = r0 % 2
            if (r0 == 0) goto L60
            r0 = 1
            goto L61
        L60:
            r0 = 0
        L61:
            if (r0 == r2) goto L6c
            r5.setSSLSocketFactory(r4)
            org.apache.http.conn.ssl.X509HostnameVerifier r4 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.KClassImpl$Data$declaredNonStaticMembers$2
            r5.setHostnameVerifier(r4)
            goto L77
        L6c:
            r5.setSSLSocketFactory(r4)
            org.apache.http.conn.ssl.X509HostnameVerifier r4 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.KClassImpl$Data$declaredNonStaticMembers$2
            r5.setHostnameVerifier(r4)
            r1.hashCode()     // Catch: java.lang.Throwable -> L78
        L77:
            return
        L78:
            r4 = move-exception
            throw r4
        L7a:
            r4 = move-exception
            throw r4
        L7c:
            throw r4
        L7d:
            java.lang.Exception r4 = new java.lang.Exception
            java.lang.String r5 = "No ssl socket factory set."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.d.PlaceComponentResult(android.content.Context, java.net.HttpURLConnection):void");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = getAuthRequestContext;
        if ((cArr3 != null ? (char) 22 : '[') != '[') {
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr4[i3] = (char) (cArr3[i3] ^ 4571606982258105150L);
            }
            int i4 = $10 + 13;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            cArr3 = cArr4;
        }
        int i6 = (int) (PlaceComponentResult ^ 4571606982258105150L);
        if (!KClassImpl$Data$declaredNonStaticMembers$2) {
            if (!BuiltInFictitiousFunctionClassFactory) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i7 = $10 + 113;
                    $11 = i7 % 128;
                    if (i7 % 2 == 0) {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult >> 0) >> bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] >>> i6);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >>> 0;
                    } else {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr5);
                return;
            }
            int i8 = $10 + 33;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 1;
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            }
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i9 = $10 + 69;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                try {
                    cArr2[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            objArr[0] = new String(cArr2);
            return;
        }
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? '4' : '%') == '%') {
                objArr[0] = new String(cArr6);
                return;
            }
            int i11 = $11 + 107;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
        }
    }
}
