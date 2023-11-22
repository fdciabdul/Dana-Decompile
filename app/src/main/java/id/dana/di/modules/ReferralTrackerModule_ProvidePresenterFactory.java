package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.contract.referraltracker.ReferralTrackerPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReferralTrackerModule_ProvidePresenterFactory implements Factory<ReferralTrackerContract.Presenter> {
    private final ReferralTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ReferralTrackerPresenter> MyBillsEntityDataFactory;

    private ReferralTrackerModule_ProvidePresenterFactory(ReferralTrackerModule referralTrackerModule, Provider<ReferralTrackerPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = referralTrackerModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ReferralTrackerModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(ReferralTrackerModule referralTrackerModule, Provider<ReferralTrackerPresenter> provider) {
        return new ReferralTrackerModule_ProvidePresenterFactory(referralTrackerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralTrackerContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
