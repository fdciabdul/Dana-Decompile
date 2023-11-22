package com.alipay.mobile.zebra.data.web;

import android.webkit.WebResourceResponse;
import o.whenAvailable;

/* loaded from: classes7.dex */
public class WebText extends WebResourceResponse {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] PlaceComponentResult = {62235, 65035, 59690, 54352, 50994};
    private static long getAuthRequestContext = -2271186113564443041L;
    public final String text;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WebText(java.lang.String r10) {
        /*
            r9 = this;
            long r0 = android.os.SystemClock.elapsedRealtimeNanos()
            r2 = 0
            java.lang.String r4 = "text/*"
            java.lang.String r5 = ""
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            int r6 = r6 + (-1)
            int r0 = android.os.Process.getGidForName(r5)
            int r0 = r0 + 6
            long r1 = android.os.SystemClock.currentThreadTimeMillis()
            r7 = -1
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            int r3 = r3 + (-1)
            char r1 = (char) r3
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            a(r6, r0, r1, r2)
            r0 = 0
            r0 = r2[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r1 = 0
            r9.<init>(r4, r0, r1)
            r9.text = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.zebra.data.web.WebText.<init>(java.lang.String):void");
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3;
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            int i4 = $10 + 95;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getAuthRequestContext))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            try {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? 'M' : '\f') == '\f') {
                    break;
                }
                int i6 = $11 + 35;
                try {
                    $10 = i6 % 128;
                    if (i6 % 2 != 0) {
                        cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                        i3 = whenavailable.BuiltInFictitiousFunctionClassFactory >>> 0;
                    } else {
                        cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                        i3 = whenavailable.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    whenavailable.BuiltInFictitiousFunctionClassFactory = i3;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        String str = new String(cArr);
        int i7 = $10 + 9;
        $11 = i7 % 128;
        if (i7 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
