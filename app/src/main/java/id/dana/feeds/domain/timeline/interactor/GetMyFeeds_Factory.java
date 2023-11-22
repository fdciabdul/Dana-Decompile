package id.dana.feeds.domain.timeline.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetMyFeeds_Factory implements Factory<GetMyFeeds> {
    private final Provider<FeedsTimelineRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MixpanelRepository> MyBillsEntityDataFactory;

    private GetMyFeeds_Factory(Provider<FeedsTimelineRepository> provider, Provider<MixpanelRepository> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static GetMyFeeds_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsTimelineRepository> provider, Provider<MixpanelRepository> provider2) {
        return new GetMyFeeds_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetMyFeeds(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
