package id.dana.feeds.domain.timeline.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetTimeline_Factory implements Factory<GetTimeline> {
    private final Provider<MixpanelRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsTimelineRepository> PlaceComponentResult;

    private GetTimeline_Factory(Provider<MixpanelRepository> provider, Provider<FeedsTimelineRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static GetTimeline_Factory BuiltInFictitiousFunctionClassFactory(Provider<MixpanelRepository> provider, Provider<FeedsTimelineRepository> provider2) {
        return new GetTimeline_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetTimeline(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
