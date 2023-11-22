package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.text.Typography;
import o.C;

/* loaded from: classes8.dex */
public class bk {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static RSAPublicKey MyBillsEntityDataFactory = null;
    private static char PlaceComponentResult = 0;
    private static final byte[] getAuthRequestContext;
    private static int getErrorConfigVersion = 1;
    private static char moveToNextValue;
    private static int scheduleImpl;

    static {
        BuiltInFictitiousFunctionClassFactory();
        byte[] bArr = {TarHeader.LF_NORMAL, -127, -97, TarHeader.LF_NORMAL, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, TarHeader.LF_NORMAL, -127, -119, 2, -127, -127, 0, -109, -38, -114, Ascii.SUB, -72, 78, 16, 70, -90, 113, -30, 36, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, 36, 44, -27, 59, -123, 72, -73, -48, TarHeader.LF_LINK, 13, 16, TarHeader.LF_SYMLINK, -27, -82, 18, -28, 84, 0, -41, 16, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, 123, -34, -49, 111, -11, TarHeader.LF_LINK, Ascii.FS, 117, -74, 114, -122, -29, -84, 82, 22, -122, 42, -40, -79, 18, -116, -42, 101, -70, 44, 11, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, Ascii.GS, 47, -24, 110, -66, -7, 87, 16, -125, -91, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};
        getAuthRequestContext = bArr;
        try {
            MyBillsEntityDataFactory = (RSAPublicKey) KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArr));
            int i = getErrorConfigVersion + 5;
            scheduleImpl = i % 128;
            if (i % 2 == 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Throwable unused) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("rsa key pair init failure!!!");
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult = (char) 12435;
        BuiltInFictitiousFunctionClassFactory = (char) 18151;
        moveToNextValue = (char) 40342;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 19162;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        if ((r9.length - r4) > r10) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(javax.crypto.Cipher r8, byte[] r9, int r10) {
        /*
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            r3 = 0
            if (r2 == 0) goto L82
            if (r9 == 0) goto L82
            int r10 = r10 / 8
            int r10 = r10 + (-11)
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L7b
            r2.<init>()     // Catch: java.lang.Exception -> L7b
            r4 = 0
            r5 = 0
        L17:
            int r6 = r9.length     // Catch: java.lang.Exception -> L7b
            if (r6 <= r4) goto L62
            int r6 = com.xiaomi.push.service.bk.scheduleImpl
            int r6 = r6 + 107
            int r7 = r6 % 128
            com.xiaomi.push.service.bk.getErrorConfigVersion = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L2b
            int r6 = r9.length     // Catch: java.lang.Exception -> L7b
            int r6 = r6 % r4
            if (r6 <= r10) goto L4a
            goto L2f
        L2b:
            int r6 = r9.length     // Catch: java.lang.Exception -> L7b
            int r6 = r6 - r4
            if (r6 <= r10) goto L4a
        L2f:
            int r6 = com.xiaomi.push.service.bk.scheduleImpl
            int r6 = r6 + 77
            int r7 = r6 % 128
            com.xiaomi.push.service.bk.getErrorConfigVersion = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L45
            byte[] r4 = r8.doFinal(r9, r4, r10)     // Catch: java.lang.Exception -> L7b
            r3.hashCode()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L7b
            goto L50
        L43:
            r8 = move-exception
            throw r8
        L45:
            byte[] r4 = r8.doFinal(r9, r4, r10)     // Catch: java.lang.Exception -> L7b
            goto L50
        L4a:
            int r6 = r9.length     // Catch: java.lang.Exception -> L7b
            int r6 = r6 - r4
            byte[] r4 = r8.doFinal(r9, r4, r6)     // Catch: java.lang.Exception -> L7b
        L50:
            int r6 = r4.length     // Catch: java.lang.Exception -> L7b
            r2.write(r4, r1, r6)     // Catch: java.lang.Exception -> L7b
            int r5 = r5 + r0
            int r4 = r5 * r10
            int r6 = com.xiaomi.push.service.bk.scheduleImpl
            int r6 = r6 + 65
            int r7 = r6 % 128
            com.xiaomi.push.service.bk.getErrorConfigVersion = r7
            int r6 = r6 % 2
            goto L17
        L62:
            byte[] r8 = r2.toByteArray()     // Catch: java.lang.Exception -> L7b
            int r9 = com.xiaomi.push.service.bk.scheduleImpl
            int r9 = r9 + 7
            int r10 = r9 % 128
            com.xiaomi.push.service.bk.getErrorConfigVersion = r10
            int r9 = r9 % 2
            if (r9 != 0) goto L73
            goto L74
        L73:
            r1 = 1
        L74:
            if (r1 == r0) goto L7a
            int r9 = r3.length     // Catch: java.lang.Throwable -> L78
            return r8
        L78:
            r8 = move-exception
            throw r8
        L7a:
            return r8
        L7b:
            r8 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            r9.<init>(r8)
            throw r9
        L82:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bk.KClassImpl$Data$declaredNonStaticMembers$2(javax.crypto.Cipher, byte[], int):byte[]");
    }

    public static String MyBillsEntityDataFactory(String str) {
        Object obj = null;
        if ((TextUtils.isEmpty(str) ? (char) 18 : 'O') == 'O') {
            try {
                Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION);
                cipher.init(1, MyBillsEntityDataFactory);
                Object[] objArr = new Object[1];
                a(6 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{48906, 27766, 51221, 57329, 9243, 53222}, objArr);
                return Base64.encodeToString(KClassImpl$Data$declaredNonStaticMembers$2(cipher, str.getBytes(((String) objArr[0]).intern()), MyBillsEntityDataFactory.getModulus().bitLength()), 2);
            } catch (Throwable unused) {
                return null;
            }
        }
        int i = getErrorConfigVersion + 125;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? '9' : '^') == '9') {
            obj.hashCode();
        }
        int i2 = getErrorConfigVersion + 45;
        scheduleImpl = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 7 : 'Q') != 'Q') {
            int i3 = 73 / 0;
            return null;
        }
        return null;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $11 + 69;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? 'B' : Typography.dollar) != '$') {
                int i4 = $10 + 77;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i6 = 58224;
                int i7 = 0;
                while (i7 < 16) {
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i6) ^ ((cArr3[0] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i6) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                    i6 -= 40503;
                    i7++;
                    int i8 = $10 + 73;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
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
