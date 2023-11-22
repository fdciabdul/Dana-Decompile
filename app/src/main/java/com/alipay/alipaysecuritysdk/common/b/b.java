package com.alipay.alipaysecuritysdk.common.b;

import android.view.View;
import com.alibaba.griver.base.common.utils.MD5Util;
import java.security.MessageDigest;
import o.getOnBoardingScenario;

/* loaded from: classes3.dex */
public final class b {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long MyBillsEntityDataFactory = 7118452570250712726L;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    public static String a(String str) {
        int i = PlaceComponentResult + 125;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            c(23011 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{18304, 7778, 62549, 19025, 8289}, objArr);
            String a2 = a(str.getBytes(((String) objArr[0]).intern()));
            int i3 = PlaceComponentResult + 79;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 == 0 ? 'A' : '8') != 'A') {
                return a2;
            }
            int i4 = 47 / 0;
            return a2;
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (!(bArr != null) || bArr.length == 0) {
            return "";
        }
        Object obj = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                if ((i < digest.length ? '+' : '5') == '5') {
                    break;
                }
                int i2 = PlaceComponentResult + 115;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                sb.append(String.format("%02x", Byte.valueOf(digest[i])));
                i++;
            }
            String obj2 = sb.toString();
            int i4 = PlaceComponentResult + 1;
            getAuthRequestContext = i4 % 128;
            if (i4 % 2 == 0) {
                obj.hashCode();
                return obj2;
            }
            return obj2;
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return null;
        }
    }

    public static String b(byte[] bArr) {
        int i = getAuthRequestContext + 11;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            int i2 = 76 / 0;
            if (bArr == null) {
                return null;
            }
        } else {
            if ((bArr != null ? '\\' : 'O') != '\\') {
                return null;
            }
        }
        try {
            if (bArr.length == 0) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            while (true) {
                if ((i3 < 16 ? '_' : (char) 17) == '_') {
                    sb.append(String.format("%02x", Byte.valueOf(digest[i3])));
                    i3++;
                    int i4 = getAuthRequestContext + 101;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? 'R' : '\t') == '\t') {
                break;
            }
            int i2 = $10 + 97;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (MyBillsEntityDataFactory ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            try {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i4 = $10 + 57;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
