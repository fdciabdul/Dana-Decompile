package id.dana.data.di;

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideOkhttpInterceptorFactory implements Factory<FlipperOkhttpInterceptor> {
    private final NetworkModule module;

    public NetworkModule_ProvideOkhttpInterceptorFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    @Override // javax.inject.Provider
    public final FlipperOkhttpInterceptor get() {
        return provideOkhttpInterceptor(this.module);
    }

    public static NetworkModule_ProvideOkhttpInterceptorFactory create(NetworkModule networkModule) {
        return new NetworkModule_ProvideOkhttpInterceptorFactory(networkModule);
    }

    public static FlipperOkhttpInterceptor provideOkhttpInterceptor(NetworkModule networkModule) {
        return (FlipperOkhttpInterceptor) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideOkhttpInterceptor());
    }
}
