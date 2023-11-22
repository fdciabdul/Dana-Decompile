package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SetLastShareFeedRequest_Factory implements Factory<SetLastShareFeedRequest> {
    private final Provider<FeedsShareRepository> PlaceComponentResult;

    private SetLastShareFeedRequest_Factory(Provider<FeedsShareRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SetLastShareFeedRequest_Factory PlaceComponentResult(Provider<FeedsShareRepository> provider) {
        return new SetLastShareFeedRequest_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SetLastShareFeedRequest(this.PlaceComponentResult.get());
    }
}
