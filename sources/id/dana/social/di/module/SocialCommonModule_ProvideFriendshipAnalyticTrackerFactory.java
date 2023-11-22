package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.feeds.ui.tracker.FriendshipMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialCommonModule_ProvideFriendshipAnalyticTrackerFactory implements Factory<FriendshipAnalyticTracker> {
    private final SocialCommonModule MyBillsEntityDataFactory;
    private final Provider<FriendshipMixpanelTracker> PlaceComponentResult;

    private SocialCommonModule_ProvideFriendshipAnalyticTrackerFactory(SocialCommonModule socialCommonModule, Provider<FriendshipMixpanelTracker> provider) {
        this.MyBillsEntityDataFactory = socialCommonModule;
        this.PlaceComponentResult = provider;
    }

    public static SocialCommonModule_ProvideFriendshipAnalyticTrackerFactory BuiltInFictitiousFunctionClassFactory(SocialCommonModule socialCommonModule, Provider<FriendshipMixpanelTracker> provider) {
        return new SocialCommonModule_ProvideFriendshipAnalyticTrackerFactory(socialCommonModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
