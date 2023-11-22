package id.dana.data.sslpinning.interceptor;

import dagger.internal.Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SSLQuakeInterceptorImpl_Factory implements Factory<SSLQuakeInterceptorImpl> {
    private final Provider<SSLPinningRepository> sslPinningRepositoryProvider;

    public SSLQuakeInterceptorImpl_Factory(Provider<SSLPinningRepository> provider) {
        this.sslPinningRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SSLQuakeInterceptorImpl get() {
        return newInstance(this.sslPinningRepositoryProvider.get());
    }

    public static SSLQuakeInterceptorImpl_Factory create(Provider<SSLPinningRepository> provider) {
        return new SSLQuakeInterceptorImpl_Factory(provider);
    }

    public static SSLQuakeInterceptorImpl newInstance(SSLPinningRepository sSLPinningRepository) {
        return new SSLQuakeInterceptorImpl(sSLPinningRepository);
    }
}
