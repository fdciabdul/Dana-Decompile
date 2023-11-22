package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.uploadfiles.UploadFilesApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideUploadFilesApiFactory implements Factory<UploadFilesApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideUploadFilesApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UploadFilesApi get() {
        return provideUploadFilesApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideUploadFilesApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideUploadFilesApiFactory(apiModule, provider);
    }

    public static UploadFilesApi provideUploadFilesApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (UploadFilesApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideUploadFilesApi(builder));
    }
}
