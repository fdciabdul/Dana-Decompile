package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.sslpinning.SSLQuakeInterceptor;
import id.dana.domain.sslpinning.SSLPinningRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSSLQuakeInterceptorFactory implements Factory<SSLQuakeInterceptor> {
    private final Provider<SSLPinningRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideSSLQuakeInterceptorFactory(ApplicationModule applicationModule, Provider<SSLPinningRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideSSLQuakeInterceptorFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<SSLPinningRepository> provider) {
        return new ApplicationModule_ProvideSSLQuakeInterceptorFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SSLQuakeInterceptor) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
