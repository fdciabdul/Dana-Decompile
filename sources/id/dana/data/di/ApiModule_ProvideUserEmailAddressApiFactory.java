package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.useremailaddress.repository.source.network.UserEmailAddressApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideUserEmailAddressApiFactory implements Factory<UserEmailAddressApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideUserEmailAddressApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UserEmailAddressApi get() {
        return provideUserEmailAddressApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideUserEmailAddressApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideUserEmailAddressApiFactory(apiModule, provider);
    }

    public static UserEmailAddressApi provideUserEmailAddressApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (UserEmailAddressApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideUserEmailAddressApi(builder));
    }
}
