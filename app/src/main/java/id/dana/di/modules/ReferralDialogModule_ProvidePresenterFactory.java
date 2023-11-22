package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.referral.ReferralDialogContract;
import id.dana.onboarding.referral.ReferralDialogPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReferralDialogModule_ProvidePresenterFactory implements Factory<ReferralDialogContract.Presenter> {
    private final ReferralDialogModule MyBillsEntityDataFactory;
    private final Provider<ReferralDialogPresenter> getAuthRequestContext;

    private ReferralDialogModule_ProvidePresenterFactory(ReferralDialogModule referralDialogModule, Provider<ReferralDialogPresenter> provider) {
        this.MyBillsEntityDataFactory = referralDialogModule;
        this.getAuthRequestContext = provider;
    }

    public static ReferralDialogModule_ProvidePresenterFactory MyBillsEntityDataFactory(ReferralDialogModule referralDialogModule, Provider<ReferralDialogPresenter> provider) {
        return new ReferralDialogModule_ProvidePresenterFactory(referralDialogModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralDialogContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
