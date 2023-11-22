package id.dana.data.merchant;

import dagger.internal.Factory;
import id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CacheMerchantCategoriesEntityDataFactory_Factory implements Factory<CacheMerchantCategoriesEntityDataFactory> {
    private final Provider<DefaultMerchantCategoriesEntityData> defaultMerchantCategoriesEntityDataProvider;

    public CacheMerchantCategoriesEntityDataFactory_Factory(Provider<DefaultMerchantCategoriesEntityData> provider) {
        this.defaultMerchantCategoriesEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CacheMerchantCategoriesEntityDataFactory get() {
        return newInstance(this.defaultMerchantCategoriesEntityDataProvider.get());
    }

    public static CacheMerchantCategoriesEntityDataFactory_Factory create(Provider<DefaultMerchantCategoriesEntityData> provider) {
        return new CacheMerchantCategoriesEntityDataFactory_Factory(provider);
    }

    public static CacheMerchantCategoriesEntityDataFactory newInstance(DefaultMerchantCategoriesEntityData defaultMerchantCategoriesEntityData) {
        return new CacheMerchantCategoriesEntityDataFactory(defaultMerchantCategoriesEntityData);
    }
}
