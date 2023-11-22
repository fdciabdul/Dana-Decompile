package com.twilio.security.crypto.key.template;

import android.security.keystore.KeyGenParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0002\u001a\u00020\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048!X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8!X \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0001\u000e"}, d2 = {"Lcom/twilio/security/crypto/key/template/CipherTemplate;", "Lcom/twilio/security/crypto/key/template/Template;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lcom/twilio/security/crypto/key/template/CipherTemplate;", "", "PlaceComponentResult", "()Ljava/lang/String;", "getAuthRequestContext", "Landroid/security/keystore/KeyGenParameterSpec;", "BuiltInFictitiousFunctionClassFactory", "()Landroid/security/keystore/KeyGenParameterSpec;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "Lcom/twilio/security/crypto/key/template/AESGCMNoPaddingCipherTemplate;"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public abstract class CipherTemplate implements Template {
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public abstract KeyGenParameterSpec BuiltInFictitiousFunctionClassFactory();

    public abstract CipherTemplate NetworkUserEntityData$$ExternalSyntheticLambda0();

    @JvmName(name = "PlaceComponentResult")
    public abstract String PlaceComponentResult();

    private CipherTemplate() {
    }

    public /* synthetic */ CipherTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
