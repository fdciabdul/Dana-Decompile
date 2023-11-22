package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.base.DanaContentApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideDanaCdnApiFactory implements Factory<DanaContentApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideDanaCdnApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DanaContentApi get() {
        return provideDanaCdnApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideDanaCdnApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideDanaCdnApiFactory(apiModule, provider);
    }

    public static DanaContentApi provideDanaCdnApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (DanaContentApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideDanaCdnApi(builder));
    }
}
