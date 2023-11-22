package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetSearchByKeyword_Factory implements Factory<GetSearchByKeyword> {
    private final Provider<GlobalSearchRepository> BuiltInFictitiousFunctionClassFactory;

    private GetSearchByKeyword_Factory(Provider<GlobalSearchRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetSearchByKeyword_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalSearchRepository> provider) {
        return new GetSearchByKeyword_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetSearchByKeyword(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
