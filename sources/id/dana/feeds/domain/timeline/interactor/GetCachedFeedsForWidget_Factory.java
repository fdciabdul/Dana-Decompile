package id.dana.feeds.domain.timeline.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetCachedFeedsForWidget_Factory implements Factory<GetCachedFeedsForWidget> {
    private final Provider<FeedsTimelineRepository> BuiltInFictitiousFunctionClassFactory;

    private GetCachedFeedsForWidget_Factory(Provider<FeedsTimelineRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetCachedFeedsForWidget_Factory PlaceComponentResult(Provider<FeedsTimelineRepository> provider) {
        return new GetCachedFeedsForWidget_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetCachedFeedsForWidget(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
