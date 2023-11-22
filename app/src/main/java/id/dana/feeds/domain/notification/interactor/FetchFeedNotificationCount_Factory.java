package id.dana.feeds.domain.notification.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.notification.FeedsNotificationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FetchFeedNotificationCount_Factory implements Factory<FetchFeedNotificationCount> {
    private final Provider<FeedsNotificationRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MixpanelRepository> PlaceComponentResult;

    private FetchFeedNotificationCount_Factory(Provider<FeedsNotificationRepository> provider, Provider<MixpanelRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static FetchFeedNotificationCount_Factory PlaceComponentResult(Provider<FeedsNotificationRepository> provider, Provider<MixpanelRepository> provider2) {
        return new FetchFeedNotificationCount_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FetchFeedNotificationCount(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
