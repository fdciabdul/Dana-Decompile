package id.dana.data.security.source;

import dagger.internal.Factory;
import id.dana.data.security.source.network.NetworkSecurityEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SecurityEntityDataFactory_Factory implements Factory<SecurityEntityDataFactory> {
    private final Provider<NetworkSecurityEntityData> networkSecurityEntityDataProvider;

    public SecurityEntityDataFactory_Factory(Provider<NetworkSecurityEntityData> provider) {
        this.networkSecurityEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SecurityEntityDataFactory get() {
        return newInstance(this.networkSecurityEntityDataProvider.get());
    }

    public static SecurityEntityDataFactory_Factory create(Provider<NetworkSecurityEntityData> provider) {
        return new SecurityEntityDataFactory_Factory(provider);
    }

    public static SecurityEntityDataFactory newInstance(NetworkSecurityEntityData networkSecurityEntityData) {
        return new SecurityEntityDataFactory(networkSecurityEntityData);
    }
}
