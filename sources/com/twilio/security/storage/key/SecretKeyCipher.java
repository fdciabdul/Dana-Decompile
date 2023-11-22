package com.twilio.security.storage.key;

import com.twilio.security.crypto.KeyManager;
import com.twilio.security.crypto.key.cipher.EncryptedDataKt;
import com.twilio.security.crypto.key.template.CipherTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\u0006\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/twilio/security/storage/key/SecretKeyCipher;", "Lcom/twilio/security/storage/key/SecretKeyProvider;", "", "p0", "PlaceComponentResult", "([B)[B", "getAuthRequestContext", "Lcom/twilio/security/crypto/KeyManager;", "Lcom/twilio/security/crypto/KeyManager;", "Lcom/twilio/security/crypto/key/template/CipherTemplate;", "MyBillsEntityDataFactory", "Lcom/twilio/security/crypto/key/template/CipherTemplate;", "p1", "<init>", "(Lcom/twilio/security/crypto/key/template/CipherTemplate;Lcom/twilio/security/crypto/KeyManager;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class SecretKeyCipher implements SecretKeyProvider {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final CipherTemplate getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final KeyManager PlaceComponentResult;

    public SecretKeyCipher(CipherTemplate cipherTemplate, KeyManager keyManager) {
        Intrinsics.checkParameterIsNotNull(cipherTemplate, "");
        Intrinsics.checkParameterIsNotNull(keyManager, "");
        this.getAuthRequestContext = cipherTemplate;
        this.PlaceComponentResult = keyManager;
    }

    @Override // com.twilio.security.storage.key.SecretKeyProvider
    public final byte[] getAuthRequestContext(byte[] p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        return EncryptedDataKt.getAuthRequestContext(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2(p0));
    }

    @Override // com.twilio.security.storage.key.SecretKeyProvider
    public final byte[] PlaceComponentResult(byte[] p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext).PlaceComponentResult(EncryptedDataKt.PlaceComponentResult(p0));
    }
}
