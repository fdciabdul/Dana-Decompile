package com.xiaomi.push;

import android.text.TextUtils;
import com.alibaba.griver.base.common.utils.MD5Util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes8.dex */
public class ac {
    public static String MyBillsEntityDataFactory(String str) {
        return BuiltInFictitiousFunctionClassFactory(str).subSequence(8, 24).toString();
    }

    public static byte[] getAuthRequestContext(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                byte b = digest[i];
                int i2 = (b & Byte.MAX_VALUE) + (b < 0 ? 128 : 0);
                StringBuilder sb = new StringBuilder();
                sb.append(i2 < 16 ? "0" : "");
                sb.append(Integer.toHexString(i2).toLowerCase());
                stringBuffer.append(sb.toString());
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
