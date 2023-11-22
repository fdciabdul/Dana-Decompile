package com.twilio.security.crypto;

import com.twilio.security.crypto.key.cipher.Cipher;
import com.twilio.security.crypto.key.signer.Signer;
import com.twilio.security.crypto.key.template.CipherTemplate;
import com.twilio.security.crypto.key.template.SignerTemplate;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/twilio/security/crypto/KeyManager;", "", "Lcom/twilio/security/crypto/key/template/CipherTemplate;", "p0", "Lcom/twilio/security/crypto/key/cipher/Cipher;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/security/crypto/key/template/CipherTemplate;)Lcom/twilio/security/crypto/key/cipher/Cipher;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lcom/twilio/security/crypto/key/template/SignerTemplate;", "Lcom/twilio/security/crypto/key/signer/Signer;", "MyBillsEntityDataFactory", "(Lcom/twilio/security/crypto/key/template/SignerTemplate;)Lcom/twilio/security/crypto/key/signer/Signer;"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface KeyManager {
    Cipher BuiltInFictitiousFunctionClassFactory(CipherTemplate p0) throws KeyException;

    boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Signer MyBillsEntityDataFactory(SignerTemplate p0) throws KeyException;

    void PlaceComponentResult(String p0) throws KeyException;
}
