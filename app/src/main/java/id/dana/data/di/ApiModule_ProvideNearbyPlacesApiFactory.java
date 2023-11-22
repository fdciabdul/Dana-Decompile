package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.nearbyplaces.repository.source.network.NearbyPlacesApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes8.dex */
public final class ApiModule_ProvideNearbyPlacesApiFactory implements Factory<NearbyPlacesApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideNearbyPlacesApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NearbyPlacesApi get() {
        return provideNearbyPlacesApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideNearbyPlacesApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideNearbyPlacesApiFactory(apiModule, provider);
    }

    public static NearbyPlacesApi provideNearbyPlacesApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (NearbyPlacesApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideNearbyPlacesApi(builder));
    }
}
