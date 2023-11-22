package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.here.source.network.HereGeocodeApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideHereGeocodeApiFactory implements Factory<HereGeocodeApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideHereGeocodeApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HereGeocodeApi get() {
        return provideHereGeocodeApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideHereGeocodeApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideHereGeocodeApiFactory(apiModule, provider);
    }

    public static HereGeocodeApi provideHereGeocodeApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (HereGeocodeApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideHereGeocodeApi(builder));
    }
}
