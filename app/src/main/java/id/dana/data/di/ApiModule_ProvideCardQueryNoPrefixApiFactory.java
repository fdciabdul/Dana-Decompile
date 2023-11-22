package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.senddigitalmoney.repository.source.network.CardQueryNoPrefixApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideCardQueryNoPrefixApiFactory implements Factory<CardQueryNoPrefixApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideCardQueryNoPrefixApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CardQueryNoPrefixApi get() {
        return provideCardQueryNoPrefixApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideCardQueryNoPrefixApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideCardQueryNoPrefixApiFactory(apiModule, provider);
    }

    public static CardQueryNoPrefixApi provideCardQueryNoPrefixApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (CardQueryNoPrefixApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideCardQueryNoPrefixApi(builder));
    }
}
