package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetShareFeedConsent_Factory implements Factory<GetShareFeedConsent> {
    private final Provider<FeedsShareRepository> BuiltInFictitiousFunctionClassFactory;

    private GetShareFeedConsent_Factory(Provider<FeedsShareRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetShareFeedConsent_Factory getAuthRequestContext(Provider<FeedsShareRepository> provider) {
        return new GetShareFeedConsent_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetShareFeedConsent(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
