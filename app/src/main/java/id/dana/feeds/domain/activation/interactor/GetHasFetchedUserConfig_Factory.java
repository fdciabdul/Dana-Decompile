package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetHasFetchedUserConfig_Factory implements Factory<GetHasFetchedUserConfig> {
    private final Provider<FeedInitRepository> BuiltInFictitiousFunctionClassFactory;

    private GetHasFetchedUserConfig_Factory(Provider<FeedInitRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetHasFetchedUserConfig_Factory PlaceComponentResult(Provider<FeedInitRepository> provider) {
        return new GetHasFetchedUserConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetHasFetchedUserConfig(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
