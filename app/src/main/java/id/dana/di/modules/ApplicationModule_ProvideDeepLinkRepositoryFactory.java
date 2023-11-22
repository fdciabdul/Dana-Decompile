package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.deeplink.repository.DeepLinkEntityRepository;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideDeepLinkRepositoryFactory implements Factory<DeepLinkRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeepLinkEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideDeepLinkRepositoryFactory(ApplicationModule applicationModule, Provider<DeepLinkEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideDeepLinkRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<DeepLinkEntityRepository> provider) {
        return new ApplicationModule_ProvideDeepLinkRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeepLinkRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
