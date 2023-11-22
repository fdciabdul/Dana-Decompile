package com.alipay.alipaysecuritysdk.common.a;

import com.alipay.alipaysecuritysdk.common.c.b;
import com.alipay.alipaysecuritysdk.common.e.e;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class a {
    public static String a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 58; i += 4) {
            sb.append("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#".charAt(i));
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        if (e.c(str) || e.c(str2)) {
            return null;
        }
        try {
            PBEKeySpec a2 = a(str);
            byte[] bytes = str2.getBytes();
            byte[] b = b();
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(a2).getEncoded(), SecureKeyStorageProvider.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(b));
            byte[] salt = a2.getSalt();
            ByteBuffer allocate = ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
            allocate.put(salt);
            cipher.doFinal(ByteBuffer.wrap(bytes), allocate);
            return a(allocate.array());
        } catch (Exception e) {
            b.a("SEC_SDK-tool", "Encrypt by new method ", e);
            return null;
        }
    }

    public static String b(String str, String str2) {
        byte[] doFinal;
        if (!e.c(str) && !e.c(str2)) {
            try {
                PBEKeySpec a2 = a(str);
                int length = str2.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
                }
                byte[] b = b();
                if (length <= 16) {
                    doFinal = null;
                } else {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(a2.getPassword(), Arrays.copyOf(bArr, 16), 10, 128)).getEncoded(), SecureKeyStorageProvider.ALGORITHM);
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, secretKeySpec, new IvParameterSpec(b));
                    doFinal = cipher.doFinal(bArr, 16, length - 16);
                }
                if (doFinal == null) {
                    b.b("SEC_SDK-tool", "decrypt data failed, return data is null");
                    return null;
                }
                String str3 = new String(doFinal);
                if (e.b(str3)) {
                    return str3;
                }
            } catch (Exception e) {
                b.a("SEC_SDK-tool", "Decrypt by new method ", e);
            }
        }
        return null;
    }

    private static PBEKeySpec a(String str) {
        Class<?> cls = Class.forName(new String(com.alipay.alipaysecuritysdk.common.b.a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object newInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        Method method = cls.getMethod("nextBytes", bArr.getClass());
        method.setAccessible(true);
        method.invoke(newInstance, bArr);
        return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    private static byte[] b() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 48; i += 2) {
                sb.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i));
            }
            return com.alipay.alipaysecuritysdk.common.b.a.a(sb.toString());
        } catch (Exception e) {
            b.a("SEC_SDK-tool", e);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }
}
