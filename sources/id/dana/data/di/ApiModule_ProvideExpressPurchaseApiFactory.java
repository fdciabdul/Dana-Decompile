package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.expresspurchase.source.network.ExpressPurchaseApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideExpressPurchaseApiFactory implements Factory<ExpressPurchaseApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideExpressPurchaseApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ExpressPurchaseApi get() {
        return provideExpressPurchaseApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideExpressPurchaseApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideExpressPurchaseApiFactory(apiModule, provider);
    }

    public static ExpressPurchaseApi provideExpressPurchaseApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (ExpressPurchaseApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideExpressPurchaseApi(builder));
    }
}
