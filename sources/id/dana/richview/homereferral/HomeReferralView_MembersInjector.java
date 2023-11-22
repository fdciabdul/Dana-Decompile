package id.dana.richview.homereferral;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.richview.homereferral.HomeReferralContract;

/* loaded from: classes9.dex */
public final class HomeReferralView_MembersInjector implements MembersInjector<HomeReferralView> {
    public static void getAuthRequestContext(HomeReferralView homeReferralView, ReadLinkPropertiesContract.Presenter presenter) {
        homeReferralView.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralView homeReferralView, MissionSummaryContract.Presenter presenter) {
        homeReferralView.missionSummaryPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralView homeReferralView, HomeReferralContract.Presenter presenter) {
        homeReferralView.presenter = presenter;
    }
}
