package id.dana.data.userconfig.repository.source;

import dagger.internal.Factory;
import id.dana.data.userconfig.repository.source.local.PersistenceUserConfigEntityData;
import id.dana.data.userconfig.repository.source.network.NetworkUserConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserConfigEntityDataFactory_Factory implements Factory<UserConfigEntityDataFactory> {
    private final Provider<PersistenceUserConfigEntityData> localDataSourceProvider;
    private final Provider<NetworkUserConfigEntityData> networkDataSourceProvider;

    public UserConfigEntityDataFactory_Factory(Provider<NetworkUserConfigEntityData> provider, Provider<PersistenceUserConfigEntityData> provider2) {
        this.networkDataSourceProvider = provider;
        this.localDataSourceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UserConfigEntityDataFactory get() {
        return newInstance(this.networkDataSourceProvider.get(), this.localDataSourceProvider.get());
    }

    public static UserConfigEntityDataFactory_Factory create(Provider<NetworkUserConfigEntityData> provider, Provider<PersistenceUserConfigEntityData> provider2) {
        return new UserConfigEntityDataFactory_Factory(provider, provider2);
    }

    public static UserConfigEntityDataFactory newInstance(NetworkUserConfigEntityData networkUserConfigEntityData, PersistenceUserConfigEntityData persistenceUserConfigEntityData) {
        return new UserConfigEntityDataFactory(networkUserConfigEntityData, persistenceUserConfigEntityData);
    }
}
