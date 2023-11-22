package id.dana.data.di;

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.network.interceptor.DanaLoggingInterceptor;
import id.dana.data.network.interceptor.ETagCacheInterceptor;
import id.dana.data.network.interceptor.NetworkAvailabilityInterceptor;
import id.dana.data.network.interceptor.RequestHeaderWithLocationCheckInterceptor;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideOkHttpWithLocationCheckBuilderFactory implements Factory<OkHttpClient.Builder> {
    private final Provider<Cache> cacheProvider;
    private final Provider<DanaLoggingInterceptor> danaLoggingInterceptorProvider;
    private final Provider<ETagCacheInterceptor> eTagCacheInterceptorProvider;
    private final Provider<EventListener.Factory> eventListenerFactoryProvider;
    private final Provider<FlipperOkhttpInterceptor> flipperOkhttpInterceptorProvider;
    private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;
    private final NetworkModule module;
    private final Provider<NetworkAvailabilityInterceptor> networkAvailabilityInterceptorProvider;
    private final Provider<RequestHeaderWithLocationCheckInterceptor> requestHeaderInterceptorProvider;

    public NetworkModule_ProvideOkHttpWithLocationCheckBuilderFactory(NetworkModule networkModule, Provider<HttpLoggingInterceptor> provider, Provider<RequestHeaderWithLocationCheckInterceptor> provider2, Provider<NetworkAvailabilityInterceptor> provider3, Provider<ETagCacheInterceptor> provider4, Provider<FlipperOkhttpInterceptor> provider5, Provider<EventListener.Factory> provider6, Provider<DanaLoggingInterceptor> provider7, Provider<Cache> provider8) {
        this.module = networkModule;
        this.httpLoggingInterceptorProvider = provider;
        this.requestHeaderInterceptorProvider = provider2;
        this.networkAvailabilityInterceptorProvider = provider3;
        this.eTagCacheInterceptorProvider = provider4;
        this.flipperOkhttpInterceptorProvider = provider5;
        this.eventListenerFactoryProvider = provider6;
        this.danaLoggingInterceptorProvider = provider7;
        this.cacheProvider = provider8;
    }

    @Override // javax.inject.Provider
    public final OkHttpClient.Builder get() {
        return provideOkHttpWithLocationCheckBuilder(this.module, this.httpLoggingInterceptorProvider.get(), this.requestHeaderInterceptorProvider.get(), this.networkAvailabilityInterceptorProvider.get(), this.eTagCacheInterceptorProvider.get(), this.flipperOkhttpInterceptorProvider.get(), this.eventListenerFactoryProvider.get(), this.danaLoggingInterceptorProvider.get(), this.cacheProvider.get());
    }

    public static NetworkModule_ProvideOkHttpWithLocationCheckBuilderFactory create(NetworkModule networkModule, Provider<HttpLoggingInterceptor> provider, Provider<RequestHeaderWithLocationCheckInterceptor> provider2, Provider<NetworkAvailabilityInterceptor> provider3, Provider<ETagCacheInterceptor> provider4, Provider<FlipperOkhttpInterceptor> provider5, Provider<EventListener.Factory> provider6, Provider<DanaLoggingInterceptor> provider7, Provider<Cache> provider8) {
        return new NetworkModule_ProvideOkHttpWithLocationCheckBuilderFactory(networkModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static OkHttpClient.Builder provideOkHttpWithLocationCheckBuilder(NetworkModule networkModule, HttpLoggingInterceptor httpLoggingInterceptor, RequestHeaderWithLocationCheckInterceptor requestHeaderWithLocationCheckInterceptor, NetworkAvailabilityInterceptor networkAvailabilityInterceptor, ETagCacheInterceptor eTagCacheInterceptor, FlipperOkhttpInterceptor flipperOkhttpInterceptor, EventListener.Factory factory, DanaLoggingInterceptor danaLoggingInterceptor, Cache cache) {
        return (OkHttpClient.Builder) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideOkHttpWithLocationCheckBuilder(httpLoggingInterceptor, requestHeaderWithLocationCheckInterceptor, networkAvailabilityInterceptor, eTagCacheInterceptor, flipperOkhttpInterceptor, factory, danaLoggingInterceptor, cache));
    }
}
