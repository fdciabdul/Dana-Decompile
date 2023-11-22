package id.dana.data.saving.repository;

import dagger.internal.Factory;
import id.dana.data.saving.repository.source.local.DefaultConfigSavingCategoryEntityData;
import id.dana.data.saving.repository.source.local.NetworkConfigSavingCategoryEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SavingCategoryEntityDataFactory_Factory implements Factory<SavingCategoryEntityDataFactory> {
    private final Provider<DefaultConfigSavingCategoryEntityData> defaultSavingCategoryEntityDataDataProvider;
    private final Provider<NetworkConfigSavingCategoryEntityData> networkSavingCategoryEntityDataProvider;

    public SavingCategoryEntityDataFactory_Factory(Provider<NetworkConfigSavingCategoryEntityData> provider, Provider<DefaultConfigSavingCategoryEntityData> provider2) {
        this.networkSavingCategoryEntityDataProvider = provider;
        this.defaultSavingCategoryEntityDataDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SavingCategoryEntityDataFactory get() {
        return newInstance(this.networkSavingCategoryEntityDataProvider.get(), this.defaultSavingCategoryEntityDataDataProvider.get());
    }

    public static SavingCategoryEntityDataFactory_Factory create(Provider<NetworkConfigSavingCategoryEntityData> provider, Provider<DefaultConfigSavingCategoryEntityData> provider2) {
        return new SavingCategoryEntityDataFactory_Factory(provider, provider2);
    }

    public static SavingCategoryEntityDataFactory newInstance(NetworkConfigSavingCategoryEntityData networkConfigSavingCategoryEntityData, DefaultConfigSavingCategoryEntityData defaultConfigSavingCategoryEntityData) {
        return new SavingCategoryEntityDataFactory(networkConfigSavingCategoryEntityData, defaultConfigSavingCategoryEntityData);
    }
}
