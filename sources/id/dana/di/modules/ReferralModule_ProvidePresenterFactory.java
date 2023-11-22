package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.referral.ReferralContract;
import id.dana.onboarding.referral.VerifyReferralCodePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReferralModule_ProvidePresenterFactory implements Factory<ReferralContract.Presenter> {
    private final Provider<VerifyReferralCodePresenter> PlaceComponentResult;
    private final ReferralModule getAuthRequestContext;

    private ReferralModule_ProvidePresenterFactory(ReferralModule referralModule, Provider<VerifyReferralCodePresenter> provider) {
        this.getAuthRequestContext = referralModule;
        this.PlaceComponentResult = provider;
    }

    public static ReferralModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(ReferralModule referralModule, Provider<VerifyReferralCodePresenter> provider) {
        return new ReferralModule_ProvidePresenterFactory(referralModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
