package com.twilio.security.storage;

import android.content.SharedPreferences;
import com.twilio.security.crypto.KeyManager;
import com.twilio.security.crypto.KeyManagerKt;
import com.twilio.security.crypto.key.template.AESGCMNoPaddingCipherTemplate;
import com.twilio.security.storage.key.SecretKeyCipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "p0", "Landroid/content/SharedPreferences;", "p1", "Lcom/twilio/security/storage/EncryptedStorage;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Landroid/content/SharedPreferences;)Lcom/twilio/security/storage/EncryptedStorage;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class EncryptedStorageKt {
    public static final EncryptedStorage KClassImpl$Data$declaredNonStaticMembers$2(String str, SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "");
        KeyManager PlaceComponentResult = KeyManagerKt.PlaceComponentResult();
        SecretKeyCipher secretKeyCipher = new SecretKeyCipher(new AESGCMNoPaddingCipherTemplate(str, false, 2, null), PlaceComponentResult);
        if (!PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(str) && sharedPreferences.getAll().isEmpty()) {
            secretKeyCipher.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(secretKeyCipher.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        return new EncryptedPreferences(secretKeyCipher, sharedPreferences, new DefaultSerializer());
    }
}
