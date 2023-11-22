package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeleteFeedActivity_Factory implements Factory<DeleteFeedActivity> {
    private final Provider<FeedsShareRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private DeleteFeedActivity_Factory(Provider<FeedsShareRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DeleteFeedActivity_Factory PlaceComponentResult(Provider<FeedsShareRepository> provider) {
        return new DeleteFeedActivity_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteFeedActivity(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
