package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.here.source.network.HereTokenApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideHereTokenApiFactory implements Factory<HereTokenApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideHereTokenApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HereTokenApi get() {
        return provideHereTokenApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideHereTokenApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideHereTokenApiFactory(apiModule, provider);
    }

    public static HereTokenApi provideHereTokenApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (HereTokenApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideHereTokenApi(builder));
    }
}
