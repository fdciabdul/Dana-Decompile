package id.dana.data.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideSecuredRetrofitNameCheckBuilderFactory implements Factory<Retrofit.Builder> {
    private final Provider<Gson> gsonProvider;
    private final NetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPrefStartupConfig> sharedPrefStartupConfigProvider;

    public NetworkModule_ProvideSecuredRetrofitNameCheckBuilderFactory(NetworkModule networkModule, Provider<Gson> provider, Provider<OkHttpClient> provider2, Provider<SharedPrefStartupConfig> provider3) {
        this.module = networkModule;
        this.gsonProvider = provider;
        this.okHttpClientProvider = provider2;
        this.sharedPrefStartupConfigProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final Retrofit.Builder get() {
        return provideSecuredRetrofitNameCheckBuilder(this.module, this.gsonProvider.get(), this.okHttpClientProvider.get(), this.sharedPrefStartupConfigProvider.get());
    }

    public static NetworkModule_ProvideSecuredRetrofitNameCheckBuilderFactory create(NetworkModule networkModule, Provider<Gson> provider, Provider<OkHttpClient> provider2, Provider<SharedPrefStartupConfig> provider3) {
        return new NetworkModule_ProvideSecuredRetrofitNameCheckBuilderFactory(networkModule, provider, provider2, provider3);
    }

    public static Retrofit.Builder provideSecuredRetrofitNameCheckBuilder(NetworkModule networkModule, Gson gson, OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        return (Retrofit.Builder) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideSecuredRetrofitNameCheckBuilder(gson, okHttpClient, sharedPrefStartupConfig));
    }
}
