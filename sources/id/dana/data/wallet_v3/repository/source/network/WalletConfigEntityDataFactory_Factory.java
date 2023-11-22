package id.dana.data.wallet_v3.repository.source.network;

import dagger.internal.Factory;
import id.dana.data.wallet_v3.repository.source.local.LocalWalletConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletConfigEntityDataFactory_Factory implements Factory<WalletConfigEntityDataFactory> {
    private final Provider<LocalWalletConfigEntityData> localWalletConfigEntityDataProvider;

    public WalletConfigEntityDataFactory_Factory(Provider<LocalWalletConfigEntityData> provider) {
        this.localWalletConfigEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final WalletConfigEntityDataFactory get() {
        return newInstance(this.localWalletConfigEntityDataProvider.get());
    }

    public static WalletConfigEntityDataFactory_Factory create(Provider<LocalWalletConfigEntityData> provider) {
        return new WalletConfigEntityDataFactory_Factory(provider);
    }

    public static WalletConfigEntityDataFactory newInstance(LocalWalletConfigEntityData localWalletConfigEntityData) {
        return new WalletConfigEntityDataFactory(localWalletConfigEntityData);
    }
}
