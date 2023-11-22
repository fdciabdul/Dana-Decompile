package com.twilio.security.crypto.key.cipher;

import com.twilio.security.crypto.KeyException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/twilio/security/crypto/key/cipher/Cipher;", "", "Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "p0", "", "PlaceComponentResult", "(Lcom/twilio/security/crypto/key/cipher/EncryptedData;)[B", "KClassImpl$Data$declaredNonStaticMembers$2", "([B)Lcom/twilio/security/crypto/key/cipher/EncryptedData;"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface Cipher {
    EncryptedData KClassImpl$Data$declaredNonStaticMembers$2(byte[] p0) throws KeyException;

    byte[] PlaceComponentResult(EncryptedData p0) throws KeyException;
}
