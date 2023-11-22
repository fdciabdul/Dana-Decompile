package id.dana.cashier.data.repository.source;

import dagger.internal.Factory;
import id.dana.cashier.data.repository.source.network.NetworkCashierBannerManagementEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CashierBannerManagementEntityDataFactory_Factory implements Factory<CashierBannerManagementEntityDataFactory> {
    private final Provider<NetworkCashierBannerManagementEntityData> networkCashierBannerManagementEntityDataProvider;

    public CashierBannerManagementEntityDataFactory_Factory(Provider<NetworkCashierBannerManagementEntityData> provider) {
        this.networkCashierBannerManagementEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CashierBannerManagementEntityDataFactory get() {
        return newInstance(this.networkCashierBannerManagementEntityDataProvider.get());
    }

    public static CashierBannerManagementEntityDataFactory_Factory create(Provider<NetworkCashierBannerManagementEntityData> provider) {
        return new CashierBannerManagementEntityDataFactory_Factory(provider);
    }

    public static CashierBannerManagementEntityDataFactory newInstance(NetworkCashierBannerManagementEntityData networkCashierBannerManagementEntityData) {
        return new CashierBannerManagementEntityDataFactory(networkCashierBannerManagementEntityData);
    }
}
