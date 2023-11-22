package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.ipg.IpgEntityRepository;
import id.dana.domain.ipg.IpgRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideIPGRepositoryFactory implements Factory<IpgRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<IpgEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideIPGRepositoryFactory(ApplicationModule applicationModule, Provider<IpgEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideIPGRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<IpgEntityRepository> provider) {
        return new ApplicationModule_ProvideIPGRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (IpgRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
