package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.homereferral.HomeReferralContract;
import id.dana.richview.homereferral.HomeReferralPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class HomeReferralModule_ProvidePresenterFactory implements Factory<HomeReferralContract.Presenter> {
    private final Provider<HomeReferralPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final HomeReferralModule getAuthRequestContext;

    public static HomeReferralContract.Presenter getAuthRequestContext(HomeReferralModule homeReferralModule, HomeReferralPresenter homeReferralPresenter) {
        return (HomeReferralContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(homeReferralModule.getAuthRequestContext(homeReferralPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeReferralContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
