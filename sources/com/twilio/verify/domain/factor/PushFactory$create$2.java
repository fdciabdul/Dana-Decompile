package com.twilio.verify.domain.factor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/twilio/verify/models/Factor;", "Lkotlin/ParameterName;", "name", "factor", BridgeDSL.INVOKE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes.dex */
final /* synthetic */ class PushFactory$create$2 extends FunctionReference implements Function1<Factor, Unit> {
    final /* synthetic */ PushFactory$create$1 $onFactorCreated$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushFactory$create$2(PushFactory$create$1 pushFactory$create$1) {
        super(1);
        this.$onFactorCreated$1 = pushFactory$create$1;
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "onFactorCreated";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return null;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "invoke(Lcom/twilio/verify/models/Factor;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
        invoke2(factor);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Factor factor) {
        Intrinsics.checkParameterIsNotNull(factor, "");
        this.$onFactorCreated$1.invoke2(factor);
    }
}
