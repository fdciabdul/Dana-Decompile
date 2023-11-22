package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InitFeedWithoutContact_Factory implements Factory<InitFeedWithoutContact> {
    private final Provider<FeedInitRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsShareRepository> getAuthRequestContext;

    private InitFeedWithoutContact_Factory(Provider<FeedInitRepository> provider, Provider<FeedsShareRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static InitFeedWithoutContact_Factory MyBillsEntityDataFactory(Provider<FeedInitRepository> provider, Provider<FeedsShareRepository> provider2) {
        return new InitFeedWithoutContact_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InitFeedWithoutContact(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
