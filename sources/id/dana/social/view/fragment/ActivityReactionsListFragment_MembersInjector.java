package id.dana.social.view.fragment;

import dagger.MembersInjector;
import id.dana.social.contract.ActivityReactionsContract;

/* loaded from: classes5.dex */
public final class ActivityReactionsListFragment_MembersInjector implements MembersInjector<ActivityReactionsListFragment> {
    public static void getAuthRequestContext(ActivityReactionsListFragment activityReactionsListFragment, ActivityReactionsContract.Presenter presenter) {
        activityReactionsListFragment.activityReactionsPresenter = presenter;
    }
}
