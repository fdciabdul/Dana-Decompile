package id.dana.data.di;

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.network.interceptor.DanaLoggingInterceptor;
import id.dana.data.network.interceptor.ETagCacheInterceptor;
import id.dana.data.network.interceptor.NetworkAvailabilityInterceptor;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideNonDanaServiceOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<Cache> cacheProvider;
    private final Provider<DanaLoggingInterceptor> danaLoggingInterceptorProvider;
    private final Provider<ETagCacheInterceptor> eTagCacheInterceptorProvider;
    private final Provider<EventListener.Factory> eventListenerFactoryProvider;
    private final Provider<FlipperOkhttpInterceptor> flipperOkhttpInterceptorProvider;
    private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;
    private final NetworkModule module;
    private final Provider<NetworkAvailabilityInterceptor> networkAvailabilityInterceptorProvider;

    public NetworkModule_ProvideNonDanaServiceOkHttpClientFactory(NetworkModule networkModule, Provider<HttpLoggingInterceptor> provider, Provider<NetworkAvailabilityInterceptor> provider2, Provider<ETagCacheInterceptor> provider3, Provider<FlipperOkhttpInterceptor> provider4, Provider<EventListener.Factory> provider5, Provider<DanaLoggingInterceptor> provider6, Provider<Cache> provider7) {
        this.module = networkModule;
        this.httpLoggingInterceptorProvider = provider;
        this.networkAvailabilityInterceptorProvider = provider2;
        this.eTagCacheInterceptorProvider = provider3;
        this.flipperOkhttpInterceptorProvider = provider4;
        this.eventListenerFactoryProvider = provider5;
        this.danaLoggingInterceptorProvider = provider6;
        this.cacheProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final OkHttpClient get() {
        return provideNonDanaServiceOkHttpClient(this.module, this.httpLoggingInterceptorProvider.get(), this.networkAvailabilityInterceptorProvider.get(), this.eTagCacheInterceptorProvider.get(), this.flipperOkhttpInterceptorProvider.get(), this.eventListenerFactoryProvider.get(), this.danaLoggingInterceptorProvider.get(), this.cacheProvider.get());
    }

    public static NetworkModule_ProvideNonDanaServiceOkHttpClientFactory create(NetworkModule networkModule, Provider<HttpLoggingInterceptor> provider, Provider<NetworkAvailabilityInterceptor> provider2, Provider<ETagCacheInterceptor> provider3, Provider<FlipperOkhttpInterceptor> provider4, Provider<EventListener.Factory> provider5, Provider<DanaLoggingInterceptor> provider6, Provider<Cache> provider7) {
        return new NetworkModule_ProvideNonDanaServiceOkHttpClientFactory(networkModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static OkHttpClient provideNonDanaServiceOkHttpClient(NetworkModule networkModule, HttpLoggingInterceptor httpLoggingInterceptor, NetworkAvailabilityInterceptor networkAvailabilityInterceptor, ETagCacheInterceptor eTagCacheInterceptor, FlipperOkhttpInterceptor flipperOkhttpInterceptor, EventListener.Factory factory, DanaLoggingInterceptor danaLoggingInterceptor, Cache cache) {
        return (OkHttpClient) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideNonDanaServiceOkHttpClient(httpLoggingInterceptor, networkAvailabilityInterceptor, eTagCacheInterceptor, flipperOkhttpInterceptor, factory, danaLoggingInterceptor, cache));
    }
}
