package id.dana.domain.webviewinterceptor.interactor;

import dagger.internal.Factory;
import id.dana.domain.webviewinterceptor.WebviewInterceptorRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetListWebviewInterceptorDataConfig_Factory implements Factory<GetListWebviewInterceptorDataConfig> {
    private final Provider<WebviewInterceptorRepository> webviewInterceptorRepositoryProvider;

    public GetListWebviewInterceptorDataConfig_Factory(Provider<WebviewInterceptorRepository> provider) {
        this.webviewInterceptorRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetListWebviewInterceptorDataConfig get() {
        return newInstance(this.webviewInterceptorRepositoryProvider.get());
    }

    public static GetListWebviewInterceptorDataConfig_Factory create(Provider<WebviewInterceptorRepository> provider) {
        return new GetListWebviewInterceptorDataConfig_Factory(provider);
    }

    public static GetListWebviewInterceptorDataConfig newInstance(WebviewInterceptorRepository webviewInterceptorRepository) {
        return new GetListWebviewInterceptorDataConfig(webviewInterceptorRepository);
    }
}
