package id.dana.onboarding;

import dagger.internal.Factory;
import id.dana.biometric.presentation.RiskTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class OnboardingPresenter_Factory implements Factory<OnboardingPresenter> {
    private final Provider<RiskTracker> MyBillsEntityDataFactory;

    private OnboardingPresenter_Factory(Provider<RiskTracker> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static OnboardingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RiskTracker> provider) {
        return new OnboardingPresenter_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OnboardingPresenter(this.MyBillsEntityDataFactory.get());
    }
}
