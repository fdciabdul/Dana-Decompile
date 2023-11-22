package id.dana.social;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.reaction.ReactionsContract;

/* loaded from: classes5.dex */
public final class AddReactionBottomSheetDialog_MembersInjector implements MembersInjector<AddReactionBottomSheetDialog> {
    public static void getAuthRequestContext(AddReactionBottomSheetDialog addReactionBottomSheetDialog, ReactionsContract.Presenter presenter) {
        addReactionBottomSheetDialog.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(AddReactionBottomSheetDialog addReactionBottomSheetDialog, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        addReactionBottomSheetDialog.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}
