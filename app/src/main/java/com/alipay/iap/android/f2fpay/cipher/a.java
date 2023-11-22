package com.alipay.iap.android.f2fpay.cipher;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static KeyGenerator f6948a;

    public static byte[] a() {
        if (f6948a == null) {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(SecureKeyStorageProvider.ALGORITHM);
                f6948a = keyGenerator;
                keyGenerator.init(128);
            } catch (NoSuchAlgorithmException e) {
                LoggerWrapper.e(F2FPayConstants.TAG, "generateKey", e);
                return null;
            }
        }
        return f6948a.generateKey().getEncoded();
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SecureKeyStorageProvider.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }
}
