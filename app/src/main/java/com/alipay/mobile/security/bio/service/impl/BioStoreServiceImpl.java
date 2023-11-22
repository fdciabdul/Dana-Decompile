package com.alipay.mobile.security.bio.service.impl;

import android.util.Base64;
import com.alipay.mobile.security.bio.security.AESEncrypt;
import com.alipay.mobile.security.bio.security.RSAEncrypt;
import com.alipay.mobile.security.bio.security.RandomHelper;
import com.alipay.mobile.security.bio.service.BioStoreParameter;
import com.alipay.mobile.security.bio.service.BioStoreResult;
import com.alipay.mobile.security.bio.service.BioStoreService;

/* loaded from: classes7.dex */
public class BioStoreServiceImpl extends BioStoreService {
    @Override // com.alipay.mobile.security.bio.service.BioStoreService
    public String encrypt(String str, String str2) {
        byte[] bArr = null;
        try {
            byte[] random = RandomHelper.random(16);
            byte[] encrypt = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(str2), random);
            byte[] encrypt2 = AESEncrypt.encrypt(str.getBytes(), random);
            bArr = new byte[encrypt.length + encrypt2.length];
            System.arraycopy(encrypt2, 0, bArr, 0, encrypt2.length);
            System.arraycopy(encrypt, 0, bArr, encrypt2.length, encrypt.length);
        } catch (Exception unused) {
        }
        return Base64.encodeToString(bArr, 8);
    }

    @Override // com.alipay.mobile.security.bio.service.BioStoreService
    public byte[] getRandom() {
        return RandomHelper.random(16);
    }

    @Override // com.alipay.mobile.security.bio.service.BioStoreService
    public byte[] encryptWithRandom(byte[] bArr, String str, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            byte[] encrypt = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(str), bArr2);
            byte[] encrypt2 = AESEncrypt.encrypt(bArr, bArr2);
            bArr3 = new byte[encrypt.length + encrypt2.length];
            System.arraycopy(encrypt2, 0, bArr3, 0, encrypt2.length);
            System.arraycopy(encrypt, 0, bArr3, encrypt2.length, encrypt.length);
            return bArr3;
        } catch (Exception unused) {
            return bArr3;
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioStoreService
    public BioStoreResult encryptWithRandom(BioStoreParameter bioStoreParameter) {
        if (bioStoreParameter == null) {
            throw new IllegalArgumentException("parameter can not be null");
        }
        BioStoreResult bioStoreResult = new BioStoreResult();
        try {
            byte[] encrypt = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(bioStoreParameter.publicKey), bioStoreParameter.random);
            byte[] encrypt2 = AESEncrypt.encrypt(bioStoreParameter.content, bioStoreParameter.random);
            bioStoreResult.encodeSeed = encrypt;
            bioStoreResult.encodeContent = encrypt2;
        } catch (Exception unused) {
        }
        return bioStoreResult;
    }
}
