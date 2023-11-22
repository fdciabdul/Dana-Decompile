package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InitSocialFeed_Factory implements Factory<InitSocialFeed> {
    private final Provider<FeedInitRepository> MyBillsEntityDataFactory;

    private InitSocialFeed_Factory(Provider<FeedInitRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static InitSocialFeed_Factory MyBillsEntityDataFactory(Provider<FeedInitRepository> provider) {
        return new InitSocialFeed_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InitSocialFeed(this.MyBillsEntityDataFactory.get());
    }
}
