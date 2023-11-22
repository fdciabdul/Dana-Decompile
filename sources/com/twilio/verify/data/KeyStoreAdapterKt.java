package com.twilio.verify.data;

import com.twilio.security.crypto.key.template.ECP256SignerTemplate;
import com.twilio.security.crypto.key.template.SignerTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"provider", "", "getSignerTemplate", "Lcom/twilio/security/crypto/key/template/SignerTemplate;", "alias", "shouldExist", "", "verify_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class KeyStoreAdapterKt {
    public static /* synthetic */ SignerTemplate getAuthRequestContext(String str) {
        Intrinsics.checkParameterIsNotNull(str, "");
        return new ECP256SignerTemplate(str, true);
    }

    public static final SignerTemplate KClassImpl$Data$declaredNonStaticMembers$2(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "");
        return new ECP256SignerTemplate(str, z);
    }
}
