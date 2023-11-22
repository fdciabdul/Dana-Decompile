package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.promocenter.PromoCenterEntityRepository;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePromoCenterRepositoryFactory implements Factory<PromoCenterRepository> {
    private final Provider<PromoCenterEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvidePromoCenterRepositoryFactory(ApplicationModule applicationModule, Provider<PromoCenterEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvidePromoCenterRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<PromoCenterEntityRepository> provider) {
        return new ApplicationModule_ProvidePromoCenterRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoCenterRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
