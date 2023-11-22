package com.iap.ac.config.lite.utils;

import android.util.Base64;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class AesUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final IvParameterSpec f7652a = new IvParameterSpec("amcsalipayaesivs".getBytes());

    public static String decrypt(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), SecureKeyStorageProvider.ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, f7652a);
        return new String(cipher.doFinal(Base64.decode(str, 0)));
    }
}
