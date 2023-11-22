package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.synccontact.repository.SyncContactEntityRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSyncContactRepositoryFactory implements Factory<SyncContactRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SyncContactEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideSyncContactRepositoryFactory(ApplicationModule applicationModule, Provider<SyncContactEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideSyncContactRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<SyncContactEntityRepository> provider) {
        return new ApplicationModule_ProvideSyncContactRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SyncContactRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
