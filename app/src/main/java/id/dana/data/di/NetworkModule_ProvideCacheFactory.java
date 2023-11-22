package id.dana.data.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Cache;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideCacheFactory implements Factory<Cache> {
    private final Provider<Context> contextProvider;
    private final NetworkModule module;

    public NetworkModule_ProvideCacheFactory(NetworkModule networkModule, Provider<Context> provider) {
        this.module = networkModule;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final Cache get() {
        return provideCache(this.module, this.contextProvider.get());
    }

    public static NetworkModule_ProvideCacheFactory create(NetworkModule networkModule, Provider<Context> provider) {
        return new NetworkModule_ProvideCacheFactory(networkModule, provider);
    }

    public static Cache provideCache(NetworkModule networkModule, Context context) {
        return (Cache) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideCache(context));
    }
}
