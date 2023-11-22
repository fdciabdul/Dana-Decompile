package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.homeinfo.repository.HomeConfigEntityRepository;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideHomeConfigEntityRepositoryFactory implements Factory<HomeConfigRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<HomeConfigEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideHomeConfigEntityRepositoryFactory(ApplicationModule applicationModule, Provider<HomeConfigEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideHomeConfigEntityRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<HomeConfigEntityRepository> provider) {
        return new ApplicationModule_ProvideHomeConfigEntityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
