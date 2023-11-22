package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.expresspurchase.source.network.ExpressPurchaseOfferApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideExpressPurchaseOfferApiFactory implements Factory<ExpressPurchaseOfferApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideExpressPurchaseOfferApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ExpressPurchaseOfferApi get() {
        return provideExpressPurchaseOfferApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideExpressPurchaseOfferApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideExpressPurchaseOfferApiFactory(apiModule, provider);
    }

    public static ExpressPurchaseOfferApi provideExpressPurchaseOfferApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (ExpressPurchaseOfferApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideExpressPurchaseOfferApi(builder));
    }
}
