package com.twilio.verify.domain.challenge;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0017\u0010\u0007\u001a\u0013\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "response", "p2", "", "signatureFieldsHeader", BridgeDSL.INVOKE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final /* synthetic */ class ChallengeRepository$get$2 extends FunctionReference implements Function2<JSONObject, String, Unit> {
    final /* synthetic */ ChallengeRepository$get$1 $toChallenge$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeRepository$get$2(ChallengeRepository$get$1 challengeRepository$get$1) {
        super(2);
        this.$toChallenge$1 = challengeRepository$get$1;
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "toChallenge";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return null;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "invoke(Lorg/json/JSONObject;Ljava/lang/String;)V";
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
        invoke2(jSONObject, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject jSONObject, String str) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "");
        this.$toChallenge$1.invoke2(jSONObject, str);
    }
}
