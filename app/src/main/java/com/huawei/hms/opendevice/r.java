package com.huawei.hms.opendevice;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import o.E;

/* loaded from: classes8.dex */
public final class r {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = -3559867497673905901L;
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = -956812108;
    private static char getAuthRequestContext = 13492;

    public static String PlaceComponentResult(String str, String str2) {
        int i = BuiltInFictitiousFunctionClassFactory + 121;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(new char[]{39793, 14674, 12235, 50054, 32807}, new char[]{31874, 49473, 26089, 1457}, (char) (45413 - (ViewConfiguration.getTapTimeout() >> 16)), new char[]{7591, 63304, 38233, 61981}, (-373210755) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            if (TextUtils.isEmpty(str2)) {
                int i3 = MyBillsEntityDataFactory + 43;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 10 / 0;
                }
                str2 = "SHA-256";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes);
            return HEX.encodeHexString(messageDigest.digest(), false);
        } catch (UnsupportedEncodingException unused) {
            HMSLog.e("SHACoder", "trans failed .");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            HMSLog.e("SHACoder", "encrypt failed .");
            return null;
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
        int i2 = $10 + 91;
        while (true) {
            $11 = i2 % 128;
            int i3 = i2 % 2;
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? '\r' : 'Y') != 'Y') {
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                i2 = $10 + 75;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
