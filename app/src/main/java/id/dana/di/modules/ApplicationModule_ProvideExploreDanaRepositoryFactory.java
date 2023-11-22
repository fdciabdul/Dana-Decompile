package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.exploredana.repository.ExploreDanaEntityRepository;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideExploreDanaRepositoryFactory implements Factory<ExploreDanaRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<ExploreDanaEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideExploreDanaRepositoryFactory(ApplicationModule applicationModule, Provider<ExploreDanaEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideExploreDanaRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<ExploreDanaEntityRepository> provider) {
        return new ApplicationModule_ProvideExploreDanaRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExploreDanaRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
