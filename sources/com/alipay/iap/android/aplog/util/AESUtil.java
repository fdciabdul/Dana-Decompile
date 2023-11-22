package com.alipay.iap.android.aplog.util;

import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final String TAG = "LogAESUtil";
    private static Cipher decryptCipher;
    private static Cipher encryptCipher;

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] doFinal;
        synchronized (AESUtil.class) {
            try {
                if (encryptCipher == null) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    Cipher cipher = Cipher.getInstance("AES");
                    encryptCipher = cipher;
                    cipher.init(1, secretKeySpec);
                }
                doFinal = encryptCipher.doFinal(bArr2, i, i2);
            } catch (Throwable th) {
                encryptCipher = null;
                InstrumentInjector.log_w(TAG, th);
                return null;
            }
        }
        return doFinal;
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] doFinal;
        synchronized (AESUtil.class) {
            try {
                if (decryptCipher == null) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    Cipher cipher = Cipher.getInstance("AES");
                    decryptCipher = cipher;
                    cipher.init(2, secretKeySpec);
                }
                doFinal = decryptCipher.doFinal(bArr2, i, i2);
            } catch (Throwable th) {
                decryptCipher = null;
                InstrumentInjector.log_w(TAG, th);
                return null;
            }
        }
        return doFinal;
    }

    public static byte[] getRawKey(byte[] bArr) {
        SecureRandom secureRandom;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    secureRandom = SecureRandom.getInstance(SHA1PRNG, "Crypto");
                } catch (Throwable unused) {
                    secureRandom = SecureRandom.getInstance(SHA1PRNG);
                }
            } else {
                secureRandom = SecureRandom.getInstance(SHA1PRNG);
            }
            secureRandom.setSeed(bArr);
            keyGenerator.init(128, secureRandom);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable th) {
            InstrumentInjector.log_w(TAG, th);
            return null;
        }
    }
}
