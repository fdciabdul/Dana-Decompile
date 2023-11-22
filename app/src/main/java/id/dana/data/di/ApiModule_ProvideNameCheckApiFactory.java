package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.sendmoney.repository.source.network.NameCheckSecureApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideNameCheckApiFactory implements Factory<NameCheckSecureApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideNameCheckApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NameCheckSecureApi get() {
        return provideNameCheckApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideNameCheckApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideNameCheckApiFactory(apiModule, provider);
    }

    public static NameCheckSecureApi provideNameCheckApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (NameCheckSecureApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideNameCheckApi(builder));
    }
}
