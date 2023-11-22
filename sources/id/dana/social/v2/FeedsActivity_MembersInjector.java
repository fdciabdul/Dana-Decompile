package id.dana.social.v2;

import dagger.MembersInjector;
import id.dana.contract.contact.DanaContactPresenter;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;

/* loaded from: classes5.dex */
public final class FeedsActivity_MembersInjector implements MembersInjector<FeedsActivity> {
    public static void PlaceComponentResult(FeedsActivity feedsActivity, RelationshipBottomSheetContract.Presenter presenter) {
        feedsActivity.settingPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(FeedsActivity feedsActivity, FriendFeedsContract.Presenter presenter) {
        feedsActivity.presenter = presenter;
    }

    public static void getAuthRequestContext(FeedsActivity feedsActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        feedsActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(FeedsActivity feedsActivity, DanaContactPresenter danaContactPresenter) {
        feedsActivity.danaContactPresenter = danaContactPresenter;
    }
}
