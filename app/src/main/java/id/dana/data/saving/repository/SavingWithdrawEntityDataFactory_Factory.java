package id.dana.data.saving.repository;

import dagger.internal.Factory;
import id.dana.data.saving.repository.source.local.DefaultSavingWithdrawEntityData;
import id.dana.data.saving.repository.source.network.NetworkSavingWithdrawEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SavingWithdrawEntityDataFactory_Factory implements Factory<SavingWithdrawEntityDataFactory> {
    private final Provider<DefaultSavingWithdrawEntityData> defaultSavingWithdrawEntityDataProvider;
    private final Provider<NetworkSavingWithdrawEntityData> networkSavingWithdrawEntityDataProvider;

    public SavingWithdrawEntityDataFactory_Factory(Provider<NetworkSavingWithdrawEntityData> provider, Provider<DefaultSavingWithdrawEntityData> provider2) {
        this.networkSavingWithdrawEntityDataProvider = provider;
        this.defaultSavingWithdrawEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SavingWithdrawEntityDataFactory get() {
        return newInstance(this.networkSavingWithdrawEntityDataProvider.get(), this.defaultSavingWithdrawEntityDataProvider.get());
    }

    public static SavingWithdrawEntityDataFactory_Factory create(Provider<NetworkSavingWithdrawEntityData> provider, Provider<DefaultSavingWithdrawEntityData> provider2) {
        return new SavingWithdrawEntityDataFactory_Factory(provider, provider2);
    }

    public static SavingWithdrawEntityDataFactory newInstance(NetworkSavingWithdrawEntityData networkSavingWithdrawEntityData, DefaultSavingWithdrawEntityData defaultSavingWithdrawEntityData) {
        return new SavingWithdrawEntityDataFactory(networkSavingWithdrawEntityData, defaultSavingWithdrawEntityData);
    }
}
