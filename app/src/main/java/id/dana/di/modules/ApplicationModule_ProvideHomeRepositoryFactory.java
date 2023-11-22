package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.homeinfo.repository.HomeInfoEntityRepository;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideHomeRepositoryFactory implements Factory<HomeInfoRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<HomeInfoEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideHomeRepositoryFactory(ApplicationModule applicationModule, Provider<HomeInfoEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideHomeRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<HomeInfoEntityRepository> provider) {
        return new ApplicationModule_ProvideHomeRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeInfoRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
