package id.dana.data.errorconfig;

import dagger.internal.Factory;
import id.dana.data.errorconfig.local.LocalErrorConfigEntityData;
import id.dana.data.errorconfig.network.NetworkErrorConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ErrorConfigFactory_Factory implements Factory<ErrorConfigFactory> {
    private final Provider<LocalErrorConfigEntityData> localErrorConfigEntityDataProvider;
    private final Provider<NetworkErrorConfigEntityData> networkErrorConfigEntityDataProvider;

    public ErrorConfigFactory_Factory(Provider<NetworkErrorConfigEntityData> provider, Provider<LocalErrorConfigEntityData> provider2) {
        this.networkErrorConfigEntityDataProvider = provider;
        this.localErrorConfigEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ErrorConfigFactory get() {
        return newInstance(this.networkErrorConfigEntityDataProvider.get(), this.localErrorConfigEntityDataProvider.get());
    }

    public static ErrorConfigFactory_Factory create(Provider<NetworkErrorConfigEntityData> provider, Provider<LocalErrorConfigEntityData> provider2) {
        return new ErrorConfigFactory_Factory(provider, provider2);
    }

    public static ErrorConfigFactory newInstance(NetworkErrorConfigEntityData networkErrorConfigEntityData, LocalErrorConfigEntityData localErrorConfigEntityData) {
        return new ErrorConfigFactory(networkErrorConfigEntityData, localErrorConfigEntityData);
    }
}
