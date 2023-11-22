package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.data.globalsearch.GlobalSearchEntityRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideGlobalSearchRepositoryFactory implements Factory<GlobalSearchRepository> {
    private final Provider<GlobalSearchEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideGlobalSearchRepositoryFactory(ApplicationModule applicationModule, Provider<GlobalSearchEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideGlobalSearchRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<GlobalSearchEntityRepository> provider) {
        return new ApplicationModule_ProvideGlobalSearchRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSearchRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
