package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.permission.PermissionEntityRepository;
import id.dana.domain.permission.PermissionRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePermissionRepositoryFactory implements Factory<PermissionRepository> {
    private final Provider<PermissionEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvidePermissionRepositoryFactory(ApplicationModule applicationModule, Provider<PermissionEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvidePermissionRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<PermissionEntityRepository> provider) {
        return new ApplicationModule_ProvidePermissionRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PermissionRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
