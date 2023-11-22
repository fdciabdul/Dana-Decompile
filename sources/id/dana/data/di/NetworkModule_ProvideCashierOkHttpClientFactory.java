package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.holdlogin.v2.interceptor.OkhttpHoldLoginV2Interceptor;
import id.dana.data.network.interceptor.CashierInterceptor;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideCashierOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<OkHttpClient.Builder> builderProvider;
    private final Provider<CashierInterceptor> cashierInterceptorProvider;
    private final NetworkModule module;
    private final Provider<OkhttpHoldLoginV2Interceptor> okhttpHoldLoginV2InterceptorProvider;

    public NetworkModule_ProvideCashierOkHttpClientFactory(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<CashierInterceptor> provider2, Provider<OkhttpHoldLoginV2Interceptor> provider3) {
        this.module = networkModule;
        this.builderProvider = provider;
        this.cashierInterceptorProvider = provider2;
        this.okhttpHoldLoginV2InterceptorProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final OkHttpClient get() {
        return provideCashierOkHttpClient(this.module, this.builderProvider.get(), this.cashierInterceptorProvider.get(), this.okhttpHoldLoginV2InterceptorProvider.get());
    }

    public static NetworkModule_ProvideCashierOkHttpClientFactory create(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<CashierInterceptor> provider2, Provider<OkhttpHoldLoginV2Interceptor> provider3) {
        return new NetworkModule_ProvideCashierOkHttpClientFactory(networkModule, provider, provider2, provider3);
    }

    public static OkHttpClient provideCashierOkHttpClient(NetworkModule networkModule, OkHttpClient.Builder builder, CashierInterceptor cashierInterceptor, OkhttpHoldLoginV2Interceptor okhttpHoldLoginV2Interceptor) {
        return (OkHttpClient) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideCashierOkHttpClient(builder, cashierInterceptor, okhttpHoldLoginV2Interceptor));
    }
}
