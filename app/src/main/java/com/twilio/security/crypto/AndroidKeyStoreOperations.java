package com.twilio.security.crypto;

import com.twilio.security.crypto.key.cipher.EncryptedData;
import java.security.Key;
import java.security.PrivateKey;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/twilio/security/crypto/AndroidKeyStoreOperations;", "", "Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "p0", "", "p1", "Ljava/security/Key;", "p2", "", "PlaceComponentResult", "(Lcom/twilio/security/crypto/key/cipher/EncryptedData;Ljava/lang/String;Ljava/security/Key;)[B", "KClassImpl$Data$declaredNonStaticMembers$2", "([BLjava/lang/String;Ljava/security/Key;)Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "Ljava/security/PrivateKey;", "MyBillsEntityDataFactory", "([BLjava/lang/String;Ljava/security/PrivateKey;)[B"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface AndroidKeyStoreOperations {
    EncryptedData KClassImpl$Data$declaredNonStaticMembers$2(byte[] p0, String p1, Key p2);

    byte[] MyBillsEntityDataFactory(byte[] p0, String p1, PrivateKey p2);

    byte[] PlaceComponentResult(EncryptedData p0, String p1, Key p2);
}
