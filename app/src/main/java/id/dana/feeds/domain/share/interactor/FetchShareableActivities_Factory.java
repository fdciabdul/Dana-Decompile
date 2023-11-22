package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FetchShareableActivities_Factory implements Factory<FetchShareableActivities> {
    private final Provider<FeedsShareRepository> PlaceComponentResult;
    private final Provider<MixpanelRepository> getAuthRequestContext;

    private FetchShareableActivities_Factory(Provider<FeedsShareRepository> provider, Provider<MixpanelRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
    }

    public static FetchShareableActivities_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsShareRepository> provider, Provider<MixpanelRepository> provider2) {
        return new FetchShareableActivities_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FetchShareableActivities(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
