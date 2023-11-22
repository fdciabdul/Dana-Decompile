package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetHomeSearchBarVisibility_Factory implements Factory<GetHomeSearchBarVisibility> {
    private final Provider<GlobalSearchRepository> BuiltInFictitiousFunctionClassFactory;

    private GetHomeSearchBarVisibility_Factory(Provider<GlobalSearchRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetHomeSearchBarVisibility_Factory PlaceComponentResult(Provider<GlobalSearchRepository> provider) {
        return new GetHomeSearchBarVisibility_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetHomeSearchBarVisibility(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
