package id.dana.biometric.presentation;

import id.dana.biometric.domain.model.RiskType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class RiskClient$onPageTrack$1$1 extends FunctionReferenceImpl implements Function1<RiskType, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RiskClient$onPageTrack$1$1(Object obj) {
        super(1, obj, RiskClient.class, "registerSensor", "registerSensor(Lid/dana/biometric/domain/model/RiskType;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(RiskType riskType) {
        invoke2(riskType);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(RiskType riskType) {
        Intrinsics.checkNotNullParameter(riskType, "");
        RiskClient.KClassImpl$Data$declaredNonStaticMembers$2((RiskClient) this.receiver, riskType);
    }
}
