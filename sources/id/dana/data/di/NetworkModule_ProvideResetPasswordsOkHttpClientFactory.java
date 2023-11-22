package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.holdlogin.v2.interceptor.OkhttpHoldLoginV2Interceptor;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideResetPasswordsOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<OkHttpClient.Builder> builderProvider;
    private final NetworkModule module;
    private final Provider<OkhttpHoldLoginV2Interceptor> okhttpHoldLoginV2InterceptorProvider;

    public NetworkModule_ProvideResetPasswordsOkHttpClientFactory(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<OkhttpHoldLoginV2Interceptor> provider2) {
        this.module = networkModule;
        this.builderProvider = provider;
        this.okhttpHoldLoginV2InterceptorProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final OkHttpClient get() {
        return provideResetPasswordsOkHttpClient(this.module, this.builderProvider.get(), this.okhttpHoldLoginV2InterceptorProvider.get());
    }

    public static NetworkModule_ProvideResetPasswordsOkHttpClientFactory create(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<OkhttpHoldLoginV2Interceptor> provider2) {
        return new NetworkModule_ProvideResetPasswordsOkHttpClientFactory(networkModule, provider, provider2);
    }

    public static OkHttpClient provideResetPasswordsOkHttpClient(NetworkModule networkModule, OkHttpClient.Builder builder, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        return (OkHttpClient) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideResetPasswordsOkHttpClient(builder, okhttpHoldLoginV2Interceptor));
    }
}
