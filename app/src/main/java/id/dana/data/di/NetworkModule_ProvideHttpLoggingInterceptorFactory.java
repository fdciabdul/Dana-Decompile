package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideHttpLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
    private final NetworkModule module;

    public NetworkModule_ProvideHttpLoggingInterceptorFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    @Override // javax.inject.Provider
    public final HttpLoggingInterceptor get() {
        return provideHttpLoggingInterceptor(this.module);
    }

    public static NetworkModule_ProvideHttpLoggingInterceptorFactory create(NetworkModule networkModule) {
        return new NetworkModule_ProvideHttpLoggingInterceptorFactory(networkModule);
    }

    public static HttpLoggingInterceptor provideHttpLoggingInterceptor(NetworkModule networkModule) {
        return (HttpLoggingInterceptor) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideHttpLoggingInterceptor());
    }
}
