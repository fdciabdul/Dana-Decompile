package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.homereferral.HomeReferralContract;

/* loaded from: classes8.dex */
public final class HomeReferralModule_ProvideViewFactory implements Factory<HomeReferralContract.View> {
    private final HomeReferralModule getAuthRequestContext;

    private HomeReferralModule_ProvideViewFactory(HomeReferralModule homeReferralModule) {
        this.getAuthRequestContext = homeReferralModule;
    }

    public static HomeReferralModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralModule homeReferralModule) {
        return new HomeReferralModule_ProvideViewFactory(homeReferralModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeReferralContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory());
    }
}
