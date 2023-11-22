package id.dana.data.wallet_v3.repository.source;

import dagger.internal.Factory;
import id.dana.data.wallet_v3.repository.source.network.NetworkWalletV3EntityData;
import id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletV3EntityDataFactory_Factory implements Factory<WalletV3EntityDataFactory> {
    private final Provider<NetworkWalletV3EntityData> networkWalletV3EntityDataProvider;
    private final Provider<PersistenceWalletV3EntityData> persistenceWalletV3EntityDataProvider;

    public WalletV3EntityDataFactory_Factory(Provider<NetworkWalletV3EntityData> provider, Provider<PersistenceWalletV3EntityData> provider2) {
        this.networkWalletV3EntityDataProvider = provider;
        this.persistenceWalletV3EntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final WalletV3EntityDataFactory get() {
        return newInstance(this.networkWalletV3EntityDataProvider.get(), this.persistenceWalletV3EntityDataProvider.get());
    }

    public static WalletV3EntityDataFactory_Factory create(Provider<NetworkWalletV3EntityData> provider, Provider<PersistenceWalletV3EntityData> provider2) {
        return new WalletV3EntityDataFactory_Factory(provider, provider2);
    }

    public static WalletV3EntityDataFactory newInstance(NetworkWalletV3EntityData networkWalletV3EntityData, PersistenceWalletV3EntityData persistenceWalletV3EntityData) {
        return new WalletV3EntityDataFactory(networkWalletV3EntityData, persistenceWalletV3EntityData);
    }
}
