package com.xiaomi.channel.commonutils.android;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes8.dex */
public class b {
    private static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {100, Ascii.ETB, 84, 114, 72, 0, 4, 97, 73, 97, 2, TarHeader.LF_BLK, 84, 102, 18, 32};

    public static byte[] BuiltInFictitiousFunctionClassFactory(byte[] bArr, byte[] bArr2) {
        return KClassImpl$Data$declaredNonStaticMembers$2(bArr, 2).doFinal(bArr2);
    }

    private static Cipher KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SecureKeyStorageProvider.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(KClassImpl$Data$declaredNonStaticMembers$2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, ivParameterSpec);
        return cipher;
    }

    public static byte[] MyBillsEntityDataFactory(byte[] bArr, byte[] bArr2) {
        return KClassImpl$Data$declaredNonStaticMembers$2(bArr, 1).doFinal(bArr2);
    }
}
