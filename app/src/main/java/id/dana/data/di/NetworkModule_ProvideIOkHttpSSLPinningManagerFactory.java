package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.network.IOkHttpSSLPinningManager;
import id.dana.data.network.OkHttpSSLPinningManager;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideIOkHttpSSLPinningManagerFactory implements Factory<IOkHttpSSLPinningManager> {
    private final NetworkModule module;
    private final Provider<OkHttpSSLPinningManager> okHttpSSLPinningManagerProvider;

    public NetworkModule_ProvideIOkHttpSSLPinningManagerFactory(NetworkModule networkModule, Provider<OkHttpSSLPinningManager> provider) {
        this.module = networkModule;
        this.okHttpSSLPinningManagerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IOkHttpSSLPinningManager get() {
        return provideIOkHttpSSLPinningManager(this.module, this.okHttpSSLPinningManagerProvider.get());
    }

    public static NetworkModule_ProvideIOkHttpSSLPinningManagerFactory create(NetworkModule networkModule, Provider<OkHttpSSLPinningManager> provider) {
        return new NetworkModule_ProvideIOkHttpSSLPinningManagerFactory(networkModule, provider);
    }

    public static IOkHttpSSLPinningManager provideIOkHttpSSLPinningManager(NetworkModule networkModule, OkHttpSSLPinningManager okHttpSSLPinningManager) {
        return (IOkHttpSSLPinningManager) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideIOkHttpSSLPinningManager(okHttpSSLPinningManager));
    }
}
