package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetRecentSearch_Factory implements Factory<GetRecentSearch> {
    private final Provider<GlobalSearchRepository> BuiltInFictitiousFunctionClassFactory;

    private GetRecentSearch_Factory(Provider<GlobalSearchRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetRecentSearch_Factory MyBillsEntityDataFactory(Provider<GlobalSearchRepository> provider) {
        return new GetRecentSearch_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetRecentSearch(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
