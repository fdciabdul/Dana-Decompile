package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.webviewinterceptor.WebviewInterceptorEntityRepository;
import id.dana.domain.webviewinterceptor.WebviewInterceptorRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideWebviewInterceptorRepositoryFactory implements Factory<WebviewInterceptorRepository> {
    private final Provider<WebviewInterceptorEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideWebviewInterceptorRepositoryFactory(ApplicationModule applicationModule, Provider<WebviewInterceptorEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideWebviewInterceptorRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<WebviewInterceptorEntityRepository> provider) {
        return new ApplicationModule_ProvideWebviewInterceptorRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (WebviewInterceptorRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
