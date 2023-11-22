package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.fullstory.FullstoryEntityDataRepository;
import id.dana.domain.fullstory.FullstoryRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFullstoryRepositoryFactory implements Factory<FullstoryRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<FullstoryEntityDataRepository> PlaceComponentResult;

    private ApplicationModule_ProvideFullstoryRepositoryFactory(ApplicationModule applicationModule, Provider<FullstoryEntityDataRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideFullstoryRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<FullstoryEntityDataRepository> provider) {
        return new ApplicationModule_ProvideFullstoryRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FullstoryRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
