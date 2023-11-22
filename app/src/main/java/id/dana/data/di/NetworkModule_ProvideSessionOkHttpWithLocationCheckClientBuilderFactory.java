package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.holdlogin.v2.interceptor.OkhttpHoldLoginV2Interceptor;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideSessionOkHttpWithLocationCheckClientBuilderFactory implements Factory<OkHttpClient.Builder> {
    private final Provider<OkHttpClient.Builder> builderProvider;
    private final NetworkModule module;
    private final Provider<OkhttpHoldLoginV2Interceptor> okhttpHoldLoginV2InterceptorProvider;

    public NetworkModule_ProvideSessionOkHttpWithLocationCheckClientBuilderFactory(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<OkhttpHoldLoginV2Interceptor> provider2) {
        this.module = networkModule;
        this.builderProvider = provider;
        this.okhttpHoldLoginV2InterceptorProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final OkHttpClient.Builder get() {
        return provideSessionOkHttpWithLocationCheckClientBuilder(this.module, this.builderProvider.get(), this.okhttpHoldLoginV2InterceptorProvider.get());
    }

    public static NetworkModule_ProvideSessionOkHttpWithLocationCheckClientBuilderFactory create(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<OkhttpHoldLoginV2Interceptor> provider2) {
        return new NetworkModule_ProvideSessionOkHttpWithLocationCheckClientBuilderFactory(networkModule, provider, provider2);
    }

    public static OkHttpClient.Builder provideSessionOkHttpWithLocationCheckClientBuilder(NetworkModule networkModule, OkHttpClient.Builder builder, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        return (OkHttpClient.Builder) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideSessionOkHttpWithLocationCheckClientBuilder(builder, okhttpHoldLoginV2Interceptor));
    }
}
