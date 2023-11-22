package com.huawei.agconnect.config.impl;

import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes7.dex */
class i {
    public static SecretKey BuiltInFictitiousFunctionClassFactory(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bArr.length == 16 && bArr2.length == 16 && bArr3.length == 16) {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(Hex.getAuthRequestContext(getAuthRequestContext(bArr, bArr2, bArr3)).toCharArray(), bArr4, i, 128)).getEncoded(), SecureKeyStorageProvider.ALGORITHM);
        }
        throw new IllegalArgumentException("invalid data for generating the key.");
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length == bArr2.length) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
            }
            return bArr3;
        }
        throw new IllegalArgumentException("left and right must be the same length.");
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i) {
        if (bArr != null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (i < 0) {
                    bArr[i2] = (byte) (bArr[i2] << (-i));
                } else {
                    bArr[i2] = (byte) (bArr[i2] >> i);
                }
            }
            return bArr;
        }
        throw new NullPointerException("bytes must not be null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] MyBillsEntityDataFactory(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    private static byte[] getAuthRequestContext(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(bArr, -4), bArr2), 6), bArr3);
    }
}
