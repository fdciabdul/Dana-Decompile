package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.recentrecipient.source.network.ConvertCardIndexNoSecureApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideConvertCardIndexNoApiFactory implements Factory<ConvertCardIndexNoSecureApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideConvertCardIndexNoApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConvertCardIndexNoSecureApi get() {
        return provideConvertCardIndexNoApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideConvertCardIndexNoApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideConvertCardIndexNoApiFactory(apiModule, provider);
    }

    public static ConvertCardIndexNoSecureApi provideConvertCardIndexNoApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (ConvertCardIndexNoSecureApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideConvertCardIndexNoApi(builder));
    }
}
