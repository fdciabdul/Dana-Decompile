package id.dana.social.view;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.reaction.ReactionsContract;

/* loaded from: classes5.dex */
public final class ReactionSectionView_MembersInjector implements MembersInjector<ReactionSectionView> {
    public static void PlaceComponentResult(ReactionSectionView reactionSectionView, ReactionsContract.Presenter presenter) {
        reactionSectionView.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(ReactionSectionView reactionSectionView, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        reactionSectionView.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}
