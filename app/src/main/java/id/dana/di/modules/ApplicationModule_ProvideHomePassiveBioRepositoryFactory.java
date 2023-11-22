package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.home.HomePassiveBioEntityRepository;
import id.dana.domain.home.HomePassiveBioRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideHomePassiveBioRepositoryFactory implements Factory<HomePassiveBioRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<HomePassiveBioEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideHomePassiveBioRepositoryFactory(ApplicationModule applicationModule, Provider<HomePassiveBioEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideHomePassiveBioRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<HomePassiveBioEntityRepository> provider) {
        return new ApplicationModule_ProvideHomePassiveBioRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomePassiveBioRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
