package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGlobalSearchConfig_Factory implements Factory<GetGlobalSearchConfig> {
    private final Provider<GlobalSearchRepository> MyBillsEntityDataFactory;

    private GetGlobalSearchConfig_Factory(Provider<GlobalSearchRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetGlobalSearchConfig_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalSearchRepository> provider) {
        return new GetGlobalSearchConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGlobalSearchConfig(this.MyBillsEntityDataFactory.get());
    }
}
