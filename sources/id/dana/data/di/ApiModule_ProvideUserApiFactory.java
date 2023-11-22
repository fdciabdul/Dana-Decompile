package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.account.avatar.repository.source.network.AvatarApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideUserApiFactory implements Factory<AvatarApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideUserApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AvatarApi get() {
        return provideUserApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideUserApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideUserApiFactory(apiModule, provider);
    }

    public static AvatarApi provideUserApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (AvatarApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideUserApi(builder));
    }
}
