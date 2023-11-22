package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeleteLastShareFeedRequest_Factory implements Factory<DeleteLastShareFeedRequest> {
    private final Provider<FeedsShareRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private DeleteLastShareFeedRequest_Factory(Provider<FeedsShareRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DeleteLastShareFeedRequest_Factory getAuthRequestContext(Provider<FeedsShareRepository> provider) {
        return new DeleteLastShareFeedRequest_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteLastShareFeedRequest(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
