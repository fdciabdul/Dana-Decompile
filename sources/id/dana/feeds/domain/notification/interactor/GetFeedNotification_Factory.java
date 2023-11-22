package id.dana.feeds.domain.notification.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetFeedNotification_Factory implements Factory<GetFeedNotification> {
    private final Provider<MixpanelRepository> MyBillsEntityDataFactory;
    private final Provider<FeedsConfigRepository> PlaceComponentResult;
    private final Provider<FeedsTimelineRepository> getAuthRequestContext;

    private GetFeedNotification_Factory(Provider<FeedsConfigRepository> provider, Provider<FeedsTimelineRepository> provider2, Provider<MixpanelRepository> provider3) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static GetFeedNotification_Factory MyBillsEntityDataFactory(Provider<FeedsConfigRepository> provider, Provider<FeedsTimelineRepository> provider2, Provider<MixpanelRepository> provider3) {
        return new GetFeedNotification_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFeedNotification(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
