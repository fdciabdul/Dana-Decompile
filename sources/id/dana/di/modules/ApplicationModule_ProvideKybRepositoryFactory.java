package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kyb.data.repository.KybEntityRepository;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideKybRepositoryFactory implements Factory<KybRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<KybEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideKybRepositoryFactory(ApplicationModule applicationModule, Provider<KybEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideKybRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<KybEntityRepository> provider) {
        return new ApplicationModule_ProvideKybRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KybRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
