package com.twilio.security.crypto.key.cipher;

import com.twilio.security.crypto.AndroidKeyStoreOperations;
import com.twilio.security.crypto.KeyException;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u0005\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u000fX\u0000¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/twilio/security/crypto/key/cipher/AESCipher;", "Lcom/twilio/security/crypto/key/cipher/Cipher;", "Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "p0", "", "PlaceComponentResult", "(Lcom/twilio/security/crypto/key/cipher/EncryptedData;)[B", "KClassImpl$Data$declaredNonStaticMembers$2", "([B)Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "Lcom/twilio/security/crypto/AndroidKeyStoreOperations;", "Lcom/twilio/security/crypto/AndroidKeyStoreOperations;", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Ljavax/crypto/SecretKey;", "getAuthRequestContext", "Ljavax/crypto/SecretKey;", "p1", "p2", "<init>", "(Ljavax/crypto/SecretKey;Ljava/lang/String;Lcom/twilio/security/crypto/AndroidKeyStoreOperations;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class AESCipher implements Cipher {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AndroidKeyStoreOperations MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SecretKey KClassImpl$Data$declaredNonStaticMembers$2;

    public AESCipher(SecretKey secretKey, String str, AndroidKeyStoreOperations androidKeyStoreOperations) {
        Intrinsics.checkParameterIsNotNull(secretKey, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(androidKeyStoreOperations, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = secretKey;
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = androidKeyStoreOperations;
    }

    @Override // com.twilio.security.crypto.key.cipher.Cipher
    public final EncryptedData KClassImpl$Data$declaredNonStaticMembers$2(byte[] p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
            throw new KeyException(e);
        }
    }

    @Override // com.twilio.security.crypto.key.cipher.Cipher
    public final byte[] PlaceComponentResult(EncryptedData p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            return this.MyBillsEntityDataFactory.PlaceComponentResult(p0, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
            throw new KeyException(e);
        }
    }
}
