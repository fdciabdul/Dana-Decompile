package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.deeplink.repository.source.network.BranchApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideBranchIoApiFactory implements Factory<BranchApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideBranchIoApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BranchApi get() {
        return provideBranchIoApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideBranchIoApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideBranchIoApiFactory(apiModule, provider);
    }

    public static BranchApi provideBranchIoApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (BranchApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideBranchIoApi(builder));
    }
}
