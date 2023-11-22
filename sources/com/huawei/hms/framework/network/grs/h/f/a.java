package com.huawei.hms.framework.network.grs.h.f;

import android.content.Context;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.framework.common.Logger;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import o.getCallingPid;

/* loaded from: classes8.dex */
public class a {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = {37275, 37367, 37254, 37253, 37257, 37255, 37252, 37274, 37346};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult = 0;
    private static char getAuthRequestContext = 42070;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if (r9 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        r8 = "sendHttpBody: The Body Data is Null";
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if (r8 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        r2 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r2 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r2 == 15) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r8 = r8.getOutputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r0 = new java.lang.Object[1];
        a(new char[]{6, 1, 5, 7, 13826}, (byte) (95 - android.text.TextUtils.lastIndexOf("", '0')), (android.view.KeyEvent.getMaxKeyCode() >> 16) + 5, r0);
        r8.write(r9.getBytes(((java.lang.String) r0[0]).intern()));
        r8.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        com.huawei.hms.framework.common.IoUtils.closeSecure(r8);
        r8 = com.huawei.hms.framework.network.grs.h.f.a.KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        com.huawei.hms.framework.network.grs.h.f.a.PlaceComponentResult = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        if ((r8 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        com.huawei.hms.framework.common.IoUtils.closeSecure(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
    
        r8 = com.huawei.hms.framework.network.grs.h.f.a.KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        com.huawei.hms.framework.network.grs.h.f.a.PlaceComponentResult = r8 % 128;
        r8 = r8 % 2;
        r8 = "sendHttpBody: HttpsURLConnection is Null";
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r9 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void MyBillsEntityDataFactory(javax.net.ssl.HttpsURLConnection r8, java.lang.String r9) {
        /*
            int r0 = com.huawei.hms.framework.network.grs.h.f.a.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 25
            int r1 = r0 % 128
            com.huawei.hms.framework.network.grs.h.f.a.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 21
            if (r0 == 0) goto L11
            r0 = 21
            goto L13
        L11:
            r0 = 40
        L13:
            r3 = 0
            if (r0 == r2) goto L19
            if (r9 != 0) goto L22
            goto L1e
        L19:
            r3.hashCode()     // Catch: java.lang.Throwable -> L9d
            if (r9 != 0) goto L22
        L1e:
            java.lang.String r8 = "sendHttpBody: The Body Data is Null"
            goto L97
        L22:
            r0 = 15
            if (r8 != 0) goto L29
            r2 = 15
            goto L2b
        L29:
            r2 = 94
        L2b:
            if (r2 == r0) goto L8c
            java.io.OutputStream r8 = r8.getOutputStream()     // Catch: java.lang.Throwable -> L87
            r0 = 5
            char[] r2 = new char[r0]     // Catch: java.lang.Throwable -> L84
            r4 = 6
            r5 = 0
            r2[r5] = r4     // Catch: java.lang.Throwable -> L84
            r4 = 1
            r2[r4] = r4     // Catch: java.lang.Throwable -> L84
            r2[r1] = r0     // Catch: java.lang.Throwable -> L84
            r6 = 3
            r7 = 7
            r2[r6] = r7     // Catch: java.lang.Throwable -> L84
            r6 = 4
            r7 = 13826(0x3602, float:1.9374E-41)
            r2[r6] = r7     // Catch: java.lang.Throwable -> L84
            java.lang.String r6 = ""
            r7 = 48
            int r6 = android.text.TextUtils.lastIndexOf(r6, r7)     // Catch: java.lang.Throwable -> L84
            int r6 = 95 - r6
            byte r6 = (byte) r6     // Catch: java.lang.Throwable -> L84
            int r7 = android.view.KeyEvent.getMaxKeyCode()     // Catch: java.lang.Throwable -> L84
            int r7 = r7 >> 16
            int r7 = r7 + r0
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L84
            a(r2, r6, r7, r0)     // Catch: java.lang.Throwable -> L84
            r0 = r0[r5]     // Catch: java.lang.Throwable -> L84
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L84
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Throwable -> L84
            byte[] r9 = r9.getBytes(r0)     // Catch: java.lang.Throwable -> L84
            r8.write(r9)     // Catch: java.lang.Throwable -> L84
            r8.flush()     // Catch: java.lang.Throwable -> L84
            com.huawei.hms.framework.common.IoUtils.closeSecure(r8)
            int r8 = com.huawei.hms.framework.network.grs.h.f.a.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 31
            int r9 = r8 % 128
            com.huawei.hms.framework.network.grs.h.f.a.PlaceComponentResult = r9
            int r8 = r8 % r1
            if (r8 == 0) goto L83
            r3.hashCode()     // Catch: java.lang.Throwable -> L81
            return
        L81:
            r8 = move-exception
            throw r8
        L83:
            return
        L84:
            r9 = move-exception
            r3 = r8
            goto L88
        L87:
            r9 = move-exception
        L88:
            com.huawei.hms.framework.common.IoUtils.closeSecure(r3)
            throw r9
        L8c:
            int r8 = com.huawei.hms.framework.network.grs.h.f.a.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 61
            int r9 = r8 % 128
            com.huawei.hms.framework.network.grs.h.f.a.PlaceComponentResult = r9
            int r8 = r8 % r1
            java.lang.String r8 = "sendHttpBody: HttpsURLConnection is Null"
        L97:
            java.lang.String r9 = "URLConnectionHelper"
            com.huawei.hms.framework.common.Logger.i(r9, r8)
            return
        L9d:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.h.f.a.MyBillsEntityDataFactory(javax.net.ssl.HttpsURLConnection, java.lang.String):void");
    }

    public static HttpsURLConnection PlaceComponentResult(String str, Context context, String str2) {
        HostnameVerifier hostnameVerifier;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            if (TextUtils.isEmpty(str)) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                try {
                    int i5 = PlaceComponentResult + 35;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    if ((i5 % 2 == 0 ? 'H' : '7') != '7') {
                        int i6 = 64 / 0;
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    throw e;
                }
            }
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection()));
            if (!(uRLConnection instanceof HttpsURLConnection)) {
                Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
                return null;
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            try {
                httpsURLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.h.g.a.KClassImpl$Data$declaredNonStaticMembers$2(context));
                hostnameVerifier = com.huawei.hms.framework.network.grs.h.g.a.MyBillsEntityDataFactory;
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            } catch (IllegalArgumentException unused) {
                Logger.w("URLConnectionHelper", "init https ssl socket failed.");
            }
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            String KClassImpl$Data$declaredNonStaticMembers$22 = com.huawei.hms.framework.network.grs.h.a.KClassImpl$Data$declaredNonStaticMembers$2(context, "NetworkKit-grs", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("request to grs server with a User-Agent header is:");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
            Logger.d("URLConnectionHelper", sb.toString());
            httpsURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, KClassImpl$Data$declaredNonStaticMembers$22);
            return httpsURLConnection;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if ((cArr2 != null ? '1' : '7') == '1') {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (i3 < length) {
                int i4 = $10 + 35;
                $11 = i4 % 128;
                if (i4 % 2 == 0) {
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                    i3 *= 0;
                } else {
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                    i3++;
                }
            }
            cArr2 = cArr3;
        }
        char c = (char) (getAuthRequestContext ^ (-1549216646985767851L));
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (!(getcallingpid.scheduleImpl != getcallingpid.lookAheadTest)) {
                        int i5 = $11 + 93;
                        $10 = i5 % 128;
                        int i6 = i5 % 2;
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i7];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i8];
                        int i9 = $11 + 93;
                        $10 = i9 % 128;
                        int i10 = i9 % 2;
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                    } else {
                        try {
                            int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i15 = 0;
        while (true) {
            if ((i15 < i ? 'K' : (char) 24) != 'K') {
                objArr[0] = new String(cArr4);
                return;
            } else {
                cArr4[i15] = (char) (cArr4[i15] ^ 13722);
                i15++;
            }
        }
    }
}
