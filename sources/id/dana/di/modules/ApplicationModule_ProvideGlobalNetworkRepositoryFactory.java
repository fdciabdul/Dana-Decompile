package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.globalnetwork.GlobalNetworkEntityRepository;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideGlobalNetworkRepositoryFactory implements Factory<GlobalNetworkRepository> {
    private final Provider<GlobalNetworkEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideGlobalNetworkRepositoryFactory(ApplicationModule applicationModule, Provider<GlobalNetworkEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideGlobalNetworkRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<GlobalNetworkEntityRepository> provider) {
        return new ApplicationModule_ProvideGlobalNetworkRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalNetworkRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
