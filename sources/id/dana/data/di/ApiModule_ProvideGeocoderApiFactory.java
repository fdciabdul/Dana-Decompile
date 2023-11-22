package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.geocode.repository.source.network.GeocoderApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideGeocoderApiFactory implements Factory<GeocoderApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideGeocoderApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GeocoderApi get() {
        return provideGeocoderApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideGeocoderApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideGeocoderApiFactory(apiModule, provider);
    }

    public static GeocoderApi provideGeocoderApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (GeocoderApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideGeocoderApi(builder));
    }
}
