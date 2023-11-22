package id.dana.social.view;

import dagger.MembersInjector;
import id.dana.social.contract.reaction.ReactionsContract;

/* loaded from: classes5.dex */
public final class ActivityReactionsBottomSheetDialog_MembersInjector implements MembersInjector<ActivityReactionsBottomSheetDialog> {
    public static void getAuthRequestContext(ActivityReactionsBottomSheetDialog activityReactionsBottomSheetDialog, ReactionsContract.Presenter presenter) {
        activityReactionsBottomSheetDialog.presenter = presenter;
    }
}
