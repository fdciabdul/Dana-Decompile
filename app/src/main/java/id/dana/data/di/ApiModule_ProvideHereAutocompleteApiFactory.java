package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.here.source.network.HereAutosuggestApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideHereAutocompleteApiFactory implements Factory<HereAutosuggestApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideHereAutocompleteApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HereAutosuggestApi get() {
        return provideHereAutocompleteApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideHereAutocompleteApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideHereAutocompleteApiFactory(apiModule, provider);
    }

    public static HereAutosuggestApi provideHereAutocompleteApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (HereAutosuggestApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideHereAutocompleteApi(builder));
    }
}
