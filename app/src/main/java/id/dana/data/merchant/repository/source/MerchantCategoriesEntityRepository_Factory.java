package id.dana.data.merchant.repository.source;

import dagger.internal.Factory;
import id.dana.data.merchant.CacheMerchantCategoriesEntityDataFactory;
import id.dana.data.merchant.MerchantCategoriesEntityDataFactory;
import id.dana.data.merchant.mapper.MerchantCategoriesMapper;
import id.dana.data.merchant.mapper.MerchantSubcategoryMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantCategoriesEntityRepository_Factory implements Factory<MerchantCategoriesEntityRepository> {
    private final Provider<CacheMerchantCategoriesEntityDataFactory> cacheMerchantCategoriesEntityDataFactoryProvider;
    private final Provider<MerchantCategoriesEntityDataFactory> merchantCategoriesEntityDataFactoryProvider;
    private final Provider<MerchantCategoriesMapper> merchantCategoriesMapperProvider;
    private final Provider<MerchantSubcategoryMapper> merchantSubcategoryMapperProvider;

    public MerchantCategoriesEntityRepository_Factory(Provider<MerchantCategoriesEntityDataFactory> provider, Provider<MerchantCategoriesMapper> provider2, Provider<MerchantSubcategoryMapper> provider3, Provider<CacheMerchantCategoriesEntityDataFactory> provider4) {
        this.merchantCategoriesEntityDataFactoryProvider = provider;
        this.merchantCategoriesMapperProvider = provider2;
        this.merchantSubcategoryMapperProvider = provider3;
        this.cacheMerchantCategoriesEntityDataFactoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final MerchantCategoriesEntityRepository get() {
        return newInstance(this.merchantCategoriesEntityDataFactoryProvider.get(), this.merchantCategoriesMapperProvider.get(), this.merchantSubcategoryMapperProvider.get(), this.cacheMerchantCategoriesEntityDataFactoryProvider.get());
    }

    public static MerchantCategoriesEntityRepository_Factory create(Provider<MerchantCategoriesEntityDataFactory> provider, Provider<MerchantCategoriesMapper> provider2, Provider<MerchantSubcategoryMapper> provider3, Provider<CacheMerchantCategoriesEntityDataFactory> provider4) {
        return new MerchantCategoriesEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static MerchantCategoriesEntityRepository newInstance(MerchantCategoriesEntityDataFactory merchantCategoriesEntityDataFactory, MerchantCategoriesMapper merchantCategoriesMapper, MerchantSubcategoryMapper merchantSubcategoryMapper, CacheMerchantCategoriesEntityDataFactory cacheMerchantCategoriesEntityDataFactory) {
        return new MerchantCategoriesEntityRepository(merchantCategoriesEntityDataFactory, merchantCategoriesMapper, merchantSubcategoryMapper, cacheMerchantCategoriesEntityDataFactory);
    }
}
