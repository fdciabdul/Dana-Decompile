package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.moreforyou.MoreForYouEntityRepository;
import id.dana.domain.moreforyou.MoreForYouRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMoreForYouRepositoryFactory implements Factory<MoreForYouRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MoreForYouEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideMoreForYouRepositoryFactory(ApplicationModule applicationModule, Provider<MoreForYouEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideMoreForYouRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<MoreForYouEntityRepository> provider) {
        return new ApplicationModule_ProvideMoreForYouRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MoreForYouRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
