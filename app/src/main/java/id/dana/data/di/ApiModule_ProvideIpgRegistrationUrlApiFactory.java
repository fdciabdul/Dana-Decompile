package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.lazada.repository.source.network.LazadaRegistrationUrlApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes8.dex */
public final class ApiModule_ProvideIpgRegistrationUrlApiFactory implements Factory<LazadaRegistrationUrlApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideIpgRegistrationUrlApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LazadaRegistrationUrlApi get() {
        return provideIpgRegistrationUrlApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideIpgRegistrationUrlApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideIpgRegistrationUrlApiFactory(apiModule, provider);
    }

    public static LazadaRegistrationUrlApi provideIpgRegistrationUrlApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (LazadaRegistrationUrlApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideIpgRegistrationUrlApi(builder));
    }
}
