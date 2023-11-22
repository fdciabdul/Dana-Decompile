package com.alipay.iap.android.f2fpay.cipher;

import com.alipay.iap.android.f2fpay.util.Base64Utils;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes3.dex */
public class b {
    private static PublicKey a(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        return a(bArr, a(Base64Utils.decode(str)));
    }

    private static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION);
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }
}
