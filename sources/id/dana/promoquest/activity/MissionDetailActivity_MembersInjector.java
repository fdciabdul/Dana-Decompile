package id.dana.promoquest.activity;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promoquest.quest.MissionContract;
import id.dana.contract.promoquest.redeem.RedeemMissionContract;
import id.dana.contract.promoquest.redeem.RedeemQuestContract;
import id.dana.contract.promoquest.track.TrackQuestContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;

/* loaded from: classes5.dex */
public final class MissionDetailActivity_MembersInjector implements MembersInjector<MissionDetailActivity> {
    public static void MyBillsEntityDataFactory(MissionDetailActivity missionDetailActivity, ReadLinkPropertiesContract.Presenter presenter) {
        missionDetailActivity.readLinkPropertiesPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MissionDetailActivity missionDetailActivity, TrackQuestContract.Presenter presenter) {
        missionDetailActivity.trackPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(MissionDetailActivity missionDetailActivity, RedeemQuestContract.Presenter presenter) {
        missionDetailActivity.redeemQuestPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MissionDetailActivity missionDetailActivity, MissionContract.Presenter presenter) {
        missionDetailActivity.missionPresenter = presenter;
    }

    public static void getAuthRequestContext(MissionDetailActivity missionDetailActivity, RedeemMissionContract.Presenter presenter) {
        missionDetailActivity.redeemMissionPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MissionDetailActivity missionDetailActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        missionDetailActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
