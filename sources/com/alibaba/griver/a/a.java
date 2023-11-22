package com.alibaba.griver.a;

import com.alibaba.griver.base.common.logger.GriverLogger;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class a {
    public static byte[] a(byte[] bArr, byte[] bArr2, int i, int i2, String str) {
        byte[] doFinal;
        synchronized (a.class) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SecureKeyStorageProvider.ALGORITHM);
                Cipher cipher = Cipher.getInstance(str);
                cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
                doFinal = cipher.doFinal(bArr2, i, i2);
            } catch (Throwable th) {
                GriverLogger.w("LogAESUtil", "encrypt exception", th);
                return null;
            }
        }
        return doFinal;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2, String str) {
        byte[] doFinal;
        synchronized (a.class) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SecureKeyStorageProvider.ALGORITHM);
                Cipher cipher = Cipher.getInstance(str);
                cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
                doFinal = cipher.doFinal(bArr2, i, i2);
            } catch (Throwable th) {
                GriverLogger.w("LogAESUtil", "decrypt failed", th);
                return null;
            }
        }
        return doFinal;
    }
}
