package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.zendesk.repository.source.network.ZendeskApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideZendeskApiFactory implements Factory<ZendeskApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideZendeskApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ZendeskApi get() {
        return provideZendeskApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideZendeskApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideZendeskApiFactory(apiModule, provider);
    }

    public static ZendeskApi provideZendeskApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (ZendeskApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideZendeskApi(builder));
    }
}
