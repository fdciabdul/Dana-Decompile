package id.dana.feeds.data.timeline.source;

import dagger.internal.Factory;
import id.dana.feeds.data.timeline.source.network.NetworkFeedsTimelineData;
import id.dana.feeds.data.timeline.source.persistence.PersistenceFeedsTimelineEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsTimelineDataFactory_Factory implements Factory<FeedsTimelineDataFactory> {
    private final Provider<PersistenceFeedsTimelineEntityData> PlaceComponentResult;
    private final Provider<NetworkFeedsTimelineData> getAuthRequestContext;

    private FeedsTimelineDataFactory_Factory(Provider<NetworkFeedsTimelineData> provider, Provider<PersistenceFeedsTimelineEntityData> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static FeedsTimelineDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<NetworkFeedsTimelineData> provider, Provider<PersistenceFeedsTimelineEntityData> provider2) {
        return new FeedsTimelineDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsTimelineDataFactory(this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
