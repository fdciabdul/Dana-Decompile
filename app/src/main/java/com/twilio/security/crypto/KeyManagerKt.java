package com.twilio.security.crypto;

import java.security.KeyStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/twilio/security/crypto/KeyManager;", "PlaceComponentResult", "()Lcom/twilio/security/crypto/KeyManager;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class KeyManagerKt {
    public static final KeyManager PlaceComponentResult() {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Intrinsics.checkExpressionValueIsNotNull(keyStore, "");
        return new AndroidKeyManager(new AndroidKeyStore(keyStore));
    }
}
