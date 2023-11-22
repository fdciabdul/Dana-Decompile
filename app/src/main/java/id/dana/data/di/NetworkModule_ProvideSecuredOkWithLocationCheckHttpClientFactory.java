package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideSecuredOkWithLocationCheckHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<OkHttpClient.Builder> builderProvider;
    private final NetworkModule module;

    public NetworkModule_ProvideSecuredOkWithLocationCheckHttpClientFactory(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider) {
        this.module = networkModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final OkHttpClient get() {
        return provideSecuredOkWithLocationCheckHttpClient(this.module, this.builderProvider.get());
    }

    public static NetworkModule_ProvideSecuredOkWithLocationCheckHttpClientFactory create(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider) {
        return new NetworkModule_ProvideSecuredOkWithLocationCheckHttpClientFactory(networkModule, provider);
    }

    public static OkHttpClient provideSecuredOkWithLocationCheckHttpClient(NetworkModule networkModule, OkHttpClient.Builder builder) {
        return (OkHttpClient) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideSecuredOkWithLocationCheckHttpClient(builder));
    }
}
