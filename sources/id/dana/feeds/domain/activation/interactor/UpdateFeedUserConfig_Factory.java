package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UpdateFeedUserConfig_Factory implements Factory<UpdateFeedUserConfig> {
    private final Provider<FeedInitRepository> MyBillsEntityDataFactory;

    private UpdateFeedUserConfig_Factory(Provider<FeedInitRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static UpdateFeedUserConfig_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedInitRepository> provider) {
        return new UpdateFeedUserConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UpdateFeedUserConfig(this.MyBillsEntityDataFactory.get());
    }
}
