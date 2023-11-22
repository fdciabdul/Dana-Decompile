package id.dana.cashier.data.repository.source;

import dagger.internal.Factory;
import id.dana.cashier.data.repository.source.local.LocalCashierEntityData;
import id.dana.cashier.data.repository.source.network.NetworkCashierEntityData;
import id.dana.cashier.data.repository.source.split.SplitCashierEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CashierEntityDataFactory_Factory implements Factory<CashierEntityDataFactory> {
    private final Provider<LocalCashierEntityData> localCashierEntityDataProvider;
    private final Provider<NetworkCashierEntityData> networkCashierEntityDataProvider;
    private final Provider<SplitCashierEntityData> splitCashierEntityDataProvider;

    public CashierEntityDataFactory_Factory(Provider<NetworkCashierEntityData> provider, Provider<SplitCashierEntityData> provider2, Provider<LocalCashierEntityData> provider3) {
        this.networkCashierEntityDataProvider = provider;
        this.splitCashierEntityDataProvider = provider2;
        this.localCashierEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CashierEntityDataFactory get() {
        return newInstance(this.networkCashierEntityDataProvider.get(), this.splitCashierEntityDataProvider.get(), this.localCashierEntityDataProvider.get());
    }

    public static CashierEntityDataFactory_Factory create(Provider<NetworkCashierEntityData> provider, Provider<SplitCashierEntityData> provider2, Provider<LocalCashierEntityData> provider3) {
        return new CashierEntityDataFactory_Factory(provider, provider2, provider3);
    }

    public static CashierEntityDataFactory newInstance(NetworkCashierEntityData networkCashierEntityData, SplitCashierEntityData splitCashierEntityData, LocalCashierEntityData localCashierEntityData) {
        return new CashierEntityDataFactory(networkCashierEntityData, splitCashierEntityData, localCashierEntityData);
    }
}
