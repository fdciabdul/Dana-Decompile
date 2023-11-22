package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.otp.repository.source.network.OtpApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class ApiModule_ProvideOtpApiFactory implements Factory<OtpApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final ApiModule module;

    public ApiModule_ProvideOtpApiFactory(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        this.module = apiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final OtpApi get() {
        return provideOtpApi(this.module, this.builderProvider.get());
    }

    public static ApiModule_ProvideOtpApiFactory create(ApiModule apiModule, Provider<Retrofit.Builder> provider) {
        return new ApiModule_ProvideOtpApiFactory(apiModule, provider);
    }

    public static OtpApi provideOtpApi(ApiModule apiModule, Retrofit.Builder builder) {
        return (OtpApi) Preconditions.BuiltInFictitiousFunctionClassFactory(apiModule.provideOtpApi(builder));
    }
}
