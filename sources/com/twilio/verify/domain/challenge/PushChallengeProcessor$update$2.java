package com.twilio.verify.domain.challenge;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.twilio.verify.models.Challenge;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/twilio/verify/models/Challenge;", "Lkotlin/ParameterName;", "name", ClientData.KEY_CHALLENGE, BridgeDSL.INVOKE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final /* synthetic */ class PushChallengeProcessor$update$2 extends FunctionReference implements Function1<Challenge, Unit> {
    final /* synthetic */ PushChallengeProcessor$update$1 $updateChallenge$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushChallengeProcessor$update$2(PushChallengeProcessor$update$1 pushChallengeProcessor$update$1) {
        super(1);
        this.$updateChallenge$1 = pushChallengeProcessor$update$1;
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "updateChallenge";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return null;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "invoke(Lcom/twilio/verify/models/Challenge;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Challenge challenge) {
        invoke2(challenge);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Challenge challenge) {
        Intrinsics.checkParameterIsNotNull(challenge, "");
        this.$updateChallenge$1.invoke2(challenge);
    }
}
