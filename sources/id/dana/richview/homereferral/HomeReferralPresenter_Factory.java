package id.dana.richview.homereferral;

import dagger.internal.Factory;
import id.dana.domain.promotion.interactor.GetHomeReferralBanner;
import id.dana.domain.promotion.interactor.GetHomeReferralP2PBanner;
import id.dana.domain.referral.interactor.GetReferralStatusConsult;
import id.dana.domain.referralconfig.interactor.GetReferralHomeConfig;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.mapper.LeaderboardMapper;
import id.dana.mapper.ReferralStatusMapper;
import id.dana.richview.homereferral.HomeReferralContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class HomeReferralPresenter_Factory implements Factory<HomeReferralPresenter> {
    private final Provider<GetReferralSendMoneyConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetHomeReferralP2PBanner> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetReferralStatusConsult> MyBillsEntityDataFactory;
    private final Provider<LeaderboardMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetHomeReferralBanner> PlaceComponentResult;
    private final Provider<GetReferralHomeConfig> getAuthRequestContext;
    private final Provider<HomeReferralContract.View> lookAheadTest;
    private final Provider<ReferralStatusMapper> scheduleImpl;

    private HomeReferralPresenter_Factory(Provider<GetReferralHomeConfig> provider, Provider<GetReferralSendMoneyConfig> provider2, Provider<GetReferralStatusConsult> provider3, Provider<GetHomeReferralP2PBanner> provider4, Provider<GetHomeReferralBanner> provider5, Provider<LeaderboardMapper> provider6, Provider<ReferralStatusMapper> provider7, Provider<HomeReferralContract.View> provider8) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.PlaceComponentResult = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider6;
        this.scheduleImpl = provider7;
        this.lookAheadTest = provider8;
    }

    public static HomeReferralPresenter_Factory PlaceComponentResult(Provider<GetReferralHomeConfig> provider, Provider<GetReferralSendMoneyConfig> provider2, Provider<GetReferralStatusConsult> provider3, Provider<GetHomeReferralP2PBanner> provider4, Provider<GetHomeReferralBanner> provider5, Provider<LeaderboardMapper> provider6, Provider<ReferralStatusMapper> provider7, Provider<HomeReferralContract.View> provider8) {
        return new HomeReferralPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeReferralPresenter(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.scheduleImpl.get(), this.lookAheadTest.get());
    }
}
