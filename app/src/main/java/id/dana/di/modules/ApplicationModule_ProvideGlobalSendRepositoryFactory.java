package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideGlobalSendRepositoryFactory implements Factory<GlobalSendRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GlobalSendEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideGlobalSendRepositoryFactory(ApplicationModule applicationModule, Provider<GlobalSendEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideGlobalSendRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<GlobalSendEntityRepository> provider) {
        return new ApplicationModule_ProvideGlobalSendRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSendRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
