package id.dana.data.di;

import android.content.Context;
import com.alipay.imobile.network.sslpinning.api.ISSLPinningManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideISSLPinningManagerFactory implements Factory<ISSLPinningManager> {
    private final Provider<Context> contextProvider;
    private final NetworkModule module;

    public NetworkModule_ProvideISSLPinningManagerFactory(NetworkModule networkModule, Provider<Context> provider) {
        this.module = networkModule;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ISSLPinningManager get() {
        return provideISSLPinningManager(this.module, this.contextProvider.get());
    }

    public static NetworkModule_ProvideISSLPinningManagerFactory create(NetworkModule networkModule, Provider<Context> provider) {
        return new NetworkModule_ProvideISSLPinningManagerFactory(networkModule, provider);
    }

    public static ISSLPinningManager provideISSLPinningManager(NetworkModule networkModule, Context context) {
        return (ISSLPinningManager) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideISSLPinningManager(context));
    }
}
