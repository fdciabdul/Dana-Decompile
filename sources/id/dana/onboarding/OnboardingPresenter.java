package id.dana.onboarding;

import id.dana.biometric.presentation.RiskTracker;
import id.dana.onboarding.OnboardingContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013JG\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010"}, d2 = {"Lid/dana/onboarding/OnboardingPresenter;", "Lid/dana/onboarding/OnboardingContract$Presenter;", "", "p0", "Lkotlin/Function0;", "", "p1", "p2", "Lkotlin/Function1;", "", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "onDestroy", "()V", "Lid/dana/biometric/presentation/RiskTracker;", "Lid/dana/biometric/presentation/RiskTracker;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/biometric/presentation/RiskTracker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnboardingPresenter implements OnboardingContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final RiskTracker MyBillsEntityDataFactory;

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
    }

    @Inject
    public OnboardingPresenter(RiskTracker riskTracker) {
        Intrinsics.checkNotNullParameter(riskTracker, "");
        this.MyBillsEntityDataFactory = riskTracker;
    }

    @Override // id.dana.onboarding.OnboardingContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, Function0<Unit> p1, Function0<Unit> p2, Function1<? super Boolean, Unit> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.MyBillsEntityDataFactory.getAuthRequestContext(p0, p1, p2, p3);
    }
}
