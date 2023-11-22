package id.dana.data.webviewinterceptor;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WebviewInterceptorEntityRepository_Factory implements Factory<WebviewInterceptorEntityRepository> {
    private final Provider<ConfigEntityDataFactory> BuiltInFictitiousFunctionClassFactory;

    private WebviewInterceptorEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static WebviewInterceptorEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<ConfigEntityDataFactory> provider) {
        return new WebviewInterceptorEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WebviewInterceptorEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
