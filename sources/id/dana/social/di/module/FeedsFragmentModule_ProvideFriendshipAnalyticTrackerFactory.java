package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.feeds.ui.tracker.FriendshipMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class FeedsFragmentModule_ProvideFriendshipAnalyticTrackerFactory implements Factory<FriendshipAnalyticTracker> {
    private final Provider<FriendshipMixpanelTracker> BuiltInFictitiousFunctionClassFactory;
    private final FeedsFragmentModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
