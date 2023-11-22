package com.alipay.zoloz.toyger.blob;

import android.util.Base64;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes7.dex */
public class RSAEncrypt {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final String privateKeyName = "privateKey.keystore";
    public static final String publickKeyName = "publicKey.keystore";

    public static RSAPublicKey loadPublicKeyByStr(String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("\n")) {
            if (str2.charAt(0) != '-') {
                sb.append(str2);
                sb.append('\r');
            }
        }
        try {
            return (RSAPublicKey) KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(sb.toString(), 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static byte[] encrypt(RSAPublicKey rSAPublicKey, byte[] bArr) throws Exception {
        if (rSAPublicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION);
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new Exception("加密公钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此加密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("明文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("明文长度非法");
        } catch (NoSuchPaddingException unused5) {
            return null;
        }
    }
}
