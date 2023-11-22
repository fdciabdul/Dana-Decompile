package id.dana.feeds.domain.timeline.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetFriendTimeline_Factory implements Factory<GetFriendTimeline> {
    private final Provider<MixpanelRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsTimelineRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFriendTimeline(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
