package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetCachedInitAndFeedStatus_Factory implements Factory<GetCachedInitAndFeedStatus> {
    private final Provider<FeedInitRepository> PlaceComponentResult;

    private GetCachedInitAndFeedStatus_Factory(Provider<FeedInitRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetCachedInitAndFeedStatus_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedInitRepository> provider) {
        return new GetCachedInitAndFeedStatus_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetCachedInitAndFeedStatus(this.PlaceComponentResult.get());
    }
}
