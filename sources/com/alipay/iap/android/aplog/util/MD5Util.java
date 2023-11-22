package com.alipay.iap.android.aplog.util;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class MD5Util {
    public static String encrypt(String str) {
        if (str == null || "".equals(str.trim())) {
            throw new IllegalArgumentException("input is null");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LottieParams.KEY_MD5);
            messageDigest.update(str.getBytes("UTF8"));
            return hex(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            InstrumentInjector.log_e(LottieParams.KEY_MD5, LottieParams.KEY_MD5, e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            InstrumentInjector.log_e(LottieParams.KEY_MD5, LottieParams.KEY_MD5, e2);
            return null;
        }
    }

    private static String hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append('0');
                sb.append(hexString);
                hexString = sb.toString();
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}
