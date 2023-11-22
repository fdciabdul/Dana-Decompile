package id.dana.feeds.domain.notification.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGlobalNotification_Factory implements Factory<GetGlobalNotification> {
    private final Provider<MixpanelRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsTimelineRepository> getAuthRequestContext;

    private GetGlobalNotification_Factory(Provider<FeedsTimelineRepository> provider, Provider<MixpanelRepository> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static GetGlobalNotification_Factory PlaceComponentResult(Provider<FeedsTimelineRepository> provider, Provider<MixpanelRepository> provider2) {
        return new GetGlobalNotification_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGlobalNotification(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
