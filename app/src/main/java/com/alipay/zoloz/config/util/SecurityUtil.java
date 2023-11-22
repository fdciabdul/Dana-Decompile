package com.alipay.zoloz.config.util;

import android.text.TextUtils;
import com.alibaba.griver.base.common.utils.MD5Util;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes7.dex */
public class SecurityUtil {
    public static final String TAG = "SecurityUtil";

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("0");
                sb.append(hexString);
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(hexString);
                str = sb2.toString();
            }
        }
        return str.toLowerCase(Locale.ENGLISH);
    }

    public static String getSHA1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes(), 0, str.length());
            return bytes2Hex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }
}
