package com.twilio.security.crypto.key.template;

import android.security.keystore.KeyGenParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028!X \u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058!X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\u000b"}, d2 = {"Lcom/twilio/security/crypto/key/template/SignerTemplate;", "Lcom/twilio/security/crypto/key/template/Template;", "Landroid/security/keystore/KeyGenParameterSpec;", "PlaceComponentResult", "()Landroid/security/keystore/KeyGenParameterSpec;", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "getAuthRequestContext", "<init>", "()V", "Lcom/twilio/security/crypto/key/template/ECP256SignerTemplate;"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public abstract class SignerTemplate implements Template {
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public abstract String BuiltInFictitiousFunctionClassFactory();

    @JvmName(name = "PlaceComponentResult")
    public abstract KeyGenParameterSpec PlaceComponentResult();

    private SignerTemplate() {
    }

    public /* synthetic */ SignerTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
