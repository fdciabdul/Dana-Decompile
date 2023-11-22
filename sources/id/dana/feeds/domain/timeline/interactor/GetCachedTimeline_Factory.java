package id.dana.feeds.domain.timeline.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetCachedTimeline_Factory implements Factory<GetCachedTimeline> {
    private final Provider<FeedsTimelineRepository> MyBillsEntityDataFactory;
    private final Provider<MixpanelRepository> PlaceComponentResult;

    private GetCachedTimeline_Factory(Provider<MixpanelRepository> provider, Provider<FeedsTimelineRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static GetCachedTimeline_Factory PlaceComponentResult(Provider<MixpanelRepository> provider, Provider<FeedsTimelineRepository> provider2) {
        return new GetCachedTimeline_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetCachedTimeline(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
