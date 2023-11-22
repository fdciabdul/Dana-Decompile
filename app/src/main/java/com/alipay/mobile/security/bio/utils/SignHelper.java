package com.alipay.mobile.security.bio.utils;

import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.griver.base.common.utils.MD5Util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import o.E;

/* loaded from: classes7.dex */
public class SignHelper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 8799700314808001340L;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 13492;
    private static int MyBillsEntityDataFactory = -956812108;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    public static String SHA1(String str) {
        String str2;
        int i = PlaceComponentResult + 35;
        getAuthRequestContext = i % 128;
        Object[] objArr = null;
        try {
            if ((i % 2 == 0 ? '\b' : ';') != ';') {
                str2 = bytetoString(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
                int i2 = 15 / 0;
            } else {
                str2 = bytetoString(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
            }
        } catch (NoSuchAlgorithmException unused) {
            str2 = null;
        }
        int i3 = getAuthRequestContext + 63;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int length = objArr.length;
            return str2;
        }
        return str2;
    }

    private static String bytetoString(byte[] bArr) {
        String obj;
        int i = getAuthRequestContext + 79;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
        }
        String str = "";
        int i2 = 1;
        while (true) {
            if (i2 < bArr.length) {
                int i3 = PlaceComponentResult + 65;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                String hexString = Integer.toHexString(bArr[i2] & 255);
                if (hexString.length() == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("0");
                    sb.append(hexString);
                    obj = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(hexString);
                    obj = sb2.toString();
                }
                str = obj;
                i2++;
            } else {
                return str.toLowerCase();
            }
        }
    }

    public static String MD5(String str) {
        try {
            if (StringUtil.isNullorEmpty(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            Object[] objArr = new Object[1];
            a(new char[]{3082, 10590, 2003, 17855, 58151}, new char[]{54630, 26764, 5526, 60332}, (char) (44053 - View.MeasureSpec.makeMeasureSpec(0, 0)), new char[]{6024, 34046, 35542, 18075}, (ViewConfiguration.getMaximumFlingVelocity() >> 16) - 1771533099, objArr);
            messageDigest.update(str.getBytes(((String) objArr[0]).intern()));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                if ((i < 16 ? 'G' : '?') == 'G') {
                    int i2 = getAuthRequestContext + 33;
                    PlaceComponentResult = i2 % 128;
                    if ((i2 % 2 != 0 ? '\f' : (char) 14) != '\f') {
                        sb.append(String.format("%02x", Byte.valueOf(digest[i])));
                        i++;
                    } else {
                        sb.append(String.format("%02x", Byte.valueOf(digest[i])));
                        i += 43;
                    }
                    int i3 = getAuthRequestContext + 19;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r7 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        r7 = com.alipay.mobile.security.bio.utils.SignHelper.PlaceComponentResult + 17;
        com.alipay.mobile.security.bio.utils.SignHelper.getAuthRequestContext = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r0 = java.security.MessageDigest.getInstance(com.alibaba.griver.base.common.utils.MD5Util.ALGORIGTHM_MD5);
        r0.update(r7);
        r7 = r0.digest();
        r0 = new java.lang.StringBuilder();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        if (r4 >= 16) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        if (r5 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        r0.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(r7[r4])));
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        return r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if ((r7 == null) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String MD5(byte[] r7) {
        /*
            int r0 = com.alipay.mobile.security.bio.utils.SignHelper.getAuthRequestContext
            int r0 = r0 + 81
            int r1 = r0 % 128
            com.alipay.mobile.security.bio.utils.SignHelper.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L1a
            int r0 = r1.length     // Catch: java.lang.Throwable -> L18
            if (r7 != 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L27
            goto L1c
        L18:
            r7 = move-exception
            throw r7
        L1a:
            if (r7 != 0) goto L27
        L1c:
            int r7 = com.alipay.mobile.security.bio.utils.SignHelper.PlaceComponentResult
            int r7 = r7 + 17
            int r0 = r7 % 128
            com.alipay.mobile.security.bio.utils.SignHelper.getAuthRequestContext = r0
            int r7 = r7 % 2
            return r1
        L27:
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch: java.lang.Exception -> L5e
            r0.update(r7)     // Catch: java.lang.Exception -> L5e
            byte[] r7 = r0.digest()     // Catch: java.lang.Exception -> L5e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e
            r0.<init>()     // Catch: java.lang.Exception -> L5e
            r4 = 0
        L3a:
            r5 = 16
            if (r4 >= r5) goto L40
            r5 = 1
            goto L41
        L40:
            r5 = 0
        L41:
            if (r5 == 0) goto L59
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L5e
            r6 = r7[r4]     // Catch: java.lang.Exception -> L5e
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch: java.lang.Exception -> L5e
            r5[r3] = r6     // Catch: java.lang.Exception -> L5e
            java.lang.String r6 = "%02x"
            java.lang.String r5 = java.lang.String.format(r6, r5)     // Catch: java.lang.Exception -> L5e
            r0.append(r5)     // Catch: java.lang.Exception -> L5e
            int r4 = r4 + 1
            goto L3a
        L59:
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Exception -> L5e
            return r7
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.bio.utils.SignHelper.MD5(byte[]):java.lang.String");
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
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? (char) 15 : 'V') != 15) {
                break;
            }
            int i2 = $10 + 3;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        String str = new String(cArr6);
        int i6 = $10 + 61;
        $11 = i6 % 128;
        if ((i6 % 2 == 0 ? '.' : 'c') != '.') {
            objArr[0] = str;
            return;
        }
        int i7 = 71 / 0;
        objArr[0] = str;
    }
}
