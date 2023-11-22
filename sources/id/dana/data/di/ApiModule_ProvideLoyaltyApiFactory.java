package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.loyalty.repository.source.network.LoyaltyApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideLoyaltyApiFactory implements Factory<LoyaltyApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideLoyaltyApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LoyaltyApi get() {
        return provideLoyaltyApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideLoyaltyApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideLoyaltyApiFactory(apiModule, provider);
    }

    public static LoyaltyApi provideLoyaltyApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (LoyaltyApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideLoyaltyApi(builder));
    }
}
