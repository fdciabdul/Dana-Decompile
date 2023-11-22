package id.dana.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.EventListener;

/* loaded from: classes2.dex */
public final class NetworkModule_ProvideEventListenerFactoryFactory implements Factory<EventListener.Factory> {
    private final NetworkModule module;

    public NetworkModule_ProvideEventListenerFactoryFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    @Override // javax.inject.Provider
    public final EventListener.Factory get() {
        return provideEventListenerFactory(this.module);
    }

    public static NetworkModule_ProvideEventListenerFactoryFactory create(NetworkModule networkModule) {
        return new NetworkModule_ProvideEventListenerFactoryFactory(networkModule);
    }

    public static EventListener.Factory provideEventListenerFactory(NetworkModule networkModule) {
        return (EventListener.Factory) Preconditions.BuiltInFictitiousFunctionClassFactory(networkModule.provideEventListenerFactory());
    }
}
