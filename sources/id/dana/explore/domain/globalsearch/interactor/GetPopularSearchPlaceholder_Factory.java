package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetPopularSearchPlaceholder_Factory implements Factory<GetPopularSearchPlaceholder> {
    private final Provider<GlobalSearchRepository> BuiltInFictitiousFunctionClassFactory;

    private GetPopularSearchPlaceholder_Factory(Provider<GlobalSearchRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetPopularSearchPlaceholder_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalSearchRepository> provider) {
        return new GetPopularSearchPlaceholder_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPopularSearchPlaceholder(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
