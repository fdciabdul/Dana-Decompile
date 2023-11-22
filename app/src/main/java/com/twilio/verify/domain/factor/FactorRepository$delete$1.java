package com.twilio.verify.domain.factor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
final class FactorRepository$delete$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Factor $$factor;
    final /* synthetic */ Function0 $$success;
    final /* synthetic */ FactorRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FactorRepository$delete$1(FactorRepository factorRepository, Factor factor, Function0 function0) {
        super(0);
        this.this$0 = factorRepository;
        this.$$factor = factor;
        this.$$success = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FactorRepository factorRepository = this.this$0;
        Factor factor = this.$$factor;
        Intrinsics.checkParameterIsNotNull(factor, "");
        factorRepository.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(factor.getLookAheadTest());
        this.$$success.invoke();
    }
}
