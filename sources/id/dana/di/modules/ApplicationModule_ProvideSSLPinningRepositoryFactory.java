package id.dana.di.modules;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.sslpinning.LocalConfigSSLPinningEntityRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSSLPinningRepositoryFactory implements Factory<SSLPinningRepository> {
    private final Provider<LocalConfigSSLPinningEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideSSLPinningRepositoryFactory(ApplicationModule applicationModule, Provider<LocalConfigSSLPinningEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideSSLPinningRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<LocalConfigSSLPinningEntityRepository> provider) {
        return new ApplicationModule_ProvideSSLPinningRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SSLPinningRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)));
    }
}
