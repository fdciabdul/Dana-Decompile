package com.twilio.verify.domain.factor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", BridgeDSL.INVOKE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes.dex */
final /* synthetic */ class FactorRepository$delete$2 extends FunctionReference implements Function0<Unit> {
    final /* synthetic */ FactorRepository$delete$1 $deleteFactor$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FactorRepository$delete$2(FactorRepository$delete$1 factorRepository$delete$1) {
        super(0);
        this.$deleteFactor$1 = factorRepository$delete$1;
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "deleteFactor";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return null;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "invoke()V";
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$deleteFactor$1.invoke2();
    }
}
