package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.data.userconfig.repository.UserConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserConfigRepositoryFactory implements Factory<UserConfigRepository> {
    private final Provider<UserConfigEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideUserConfigRepositoryFactory(ApplicationModule applicationModule, Provider<UserConfigEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideUserConfigRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<UserConfigEntityRepository> provider) {
        return new ApplicationModule_ProvideUserConfigRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
