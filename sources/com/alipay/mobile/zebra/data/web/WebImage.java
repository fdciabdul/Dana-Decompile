package com.alipay.mobile.zebra.data.web;

import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import o.E;

/* loaded from: classes7.dex */
public class WebImage extends WebResourceResponse {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = -956812108;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 4360990799332652212L;
    private static char MyBillsEntityDataFactory = 33708;
    public final Bitmap image;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WebImage(android.graphics.Bitmap r8) {
        /*
            r7 = this;
            r0 = 5
            char[] r1 = new char[r0]
            r1 = {x003e: FILL_ARRAY_DATA , data: [-17866, -23249, -1210, -4561, -30235} // fill-array
            r0 = 4
            char[] r2 = new char[r0]
            r2 = {x0048: FILL_ARRAY_DATA , data: [1178, -5852, -26090, 20011} // fill-array
            java.lang.String r3 = ""
            int r3 = android.view.KeyEvent.keyCodeFromString(r3)
            int r3 = 11162 - r3
            char r3 = (char) r3
            char[] r4 = new char[r0]
            r4 = {x0050: FILL_ARRAY_DATA , data: [0, 0, 0, 0} // fill-array
            r0 = 384377860(0x16e92404, float:3.766591E-25)
            int r5 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r5 = r5 >> 16
            int r5 = r0 - r5
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r6 = r0
            a(r1, r2, r3, r4, r5, r6)
            r1 = 0
            r0 = r0[r1]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r1 = 0
            java.lang.String r2 = "image/*"
            r7.<init>(r2, r0, r1)
            r7.image = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.zebra.data.web.WebImage.<init>(android.graphics.Bitmap):void");
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
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3)) {
                int i2 = $10 + 111;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (MyBillsEntityDataFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i6 = $10 + 55;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
