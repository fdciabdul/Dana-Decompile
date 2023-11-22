package id.dana.richview;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.promocenter.NewPromoCenterContract;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.feeds.GlobalFeedsContract;

/* loaded from: classes5.dex */
public final class NewPromoCenterView_MembersInjector implements MembersInjector<NewPromoCenterView> {
    public static void BuiltInFictitiousFunctionClassFactory(NewPromoCenterView newPromoCenterView, Lazy<GlobalFeedsContract.Presenter> lazy) {
        newPromoCenterView.globalFeedPresenter = lazy;
    }

    public static void PlaceComponentResult(NewPromoCenterView newPromoCenterView, Lazy<NewPromoCenterContract.Presenter> lazy) {
        newPromoCenterView.promoCenterPresenter = lazy;
    }

    public static void MyBillsEntityDataFactory(NewPromoCenterView newPromoCenterView, Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        newPromoCenterView.readDeepLinkPropertiesPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewPromoCenterView newPromoCenterView, Lazy<HomeTrackerImpl> lazy) {
        newPromoCenterView.homeTrackerImpl = lazy;
    }
}
