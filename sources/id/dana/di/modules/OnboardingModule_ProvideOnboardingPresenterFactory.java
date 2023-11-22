package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.OnboardingContract;
import id.dana.onboarding.OnboardingPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OnboardingModule_ProvideOnboardingPresenterFactory implements Factory<OnboardingContract.Presenter> {
    private final Provider<OnboardingPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final OnboardingModule MyBillsEntityDataFactory;

    private OnboardingModule_ProvideOnboardingPresenterFactory(OnboardingModule onboardingModule, Provider<OnboardingPresenter> provider) {
        this.MyBillsEntityDataFactory = onboardingModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static OnboardingModule_ProvideOnboardingPresenterFactory MyBillsEntityDataFactory(OnboardingModule onboardingModule, Provider<OnboardingPresenter> provider) {
        return new OnboardingModule_ProvideOnboardingPresenterFactory(onboardingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OnboardingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
