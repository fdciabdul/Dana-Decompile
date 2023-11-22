package id.dana.data.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideGsonFactory implements Factory<Gson> {
    private final NetworkModule module;

    public NetworkModule_ProvideGsonFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    @Override // javax.inject.Provider
    public final Gson get() {
        return provideGson(this.module);
    }

    public static NetworkModule_ProvideGsonFactory create(NetworkModule networkModule) {
        return new NetworkModule_ProvideGsonFactory(networkModule);
    }

    public static Gson provideGson(NetworkModule networkModule) {
        return (Gson) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideGson());
    }
}
