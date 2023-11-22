package id.dana.data.merchant;

import dagger.internal.Factory;
import id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData;
import id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantCategoriesEntityDataFactory_Factory implements Factory<MerchantCategoriesEntityDataFactory> {
    private final Provider<DefaultMerchantCategoriesEntityData> defaultMerchantCategoriesEntityDataProvider;
    private final Provider<NetworkMerchantCategoriesEntityData> networkMerchantCategoriesEntityDataProvider;

    public MerchantCategoriesEntityDataFactory_Factory(Provider<NetworkMerchantCategoriesEntityData> provider, Provider<DefaultMerchantCategoriesEntityData> provider2) {
        this.networkMerchantCategoriesEntityDataProvider = provider;
        this.defaultMerchantCategoriesEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MerchantCategoriesEntityDataFactory get() {
        return newInstance(this.networkMerchantCategoriesEntityDataProvider.get(), this.defaultMerchantCategoriesEntityDataProvider.get());
    }

    public static MerchantCategoriesEntityDataFactory_Factory create(Provider<NetworkMerchantCategoriesEntityData> provider, Provider<DefaultMerchantCategoriesEntityData> provider2) {
        return new MerchantCategoriesEntityDataFactory_Factory(provider, provider2);
    }

    public static MerchantCategoriesEntityDataFactory newInstance(NetworkMerchantCategoriesEntityData networkMerchantCategoriesEntityData, DefaultMerchantCategoriesEntityData defaultMerchantCategoriesEntityData) {
        return new MerchantCategoriesEntityDataFactory(networkMerchantCategoriesEntityData, defaultMerchantCategoriesEntityData);
    }
}
