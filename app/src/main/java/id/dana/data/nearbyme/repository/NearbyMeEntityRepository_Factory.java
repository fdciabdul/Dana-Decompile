package id.dana.data.nearbyme.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.merchant.MerchantCategoriesEntityDataFactory;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository;
import id.dana.data.nearbyme.mapper.MerchantInfoMapper;
import id.dana.data.nearbyme.mapper.NearbyPromoResultMapper;
import id.dana.data.nearbyme.mapper.NearbyShopsResultMapper;
import id.dana.data.nearbyme.mapper.OtherStoreListResultMapper;
import id.dana.data.nearbyme.repository.source.CacheNearbyPromoFactory;
import id.dana.data.nearbyme.repository.source.NearbyMeDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyMeEntityRepository_Factory implements Factory<NearbyMeEntityRepository> {
    private final Provider<CacheNearbyPromoFactory> cacheNearbyPromoFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<MerchantCategoriesEntityRepository> merchantCategoriesEntityRepositoryProvider;
    private final Provider<MerchantCategoriesEntityDataFactory> merchantCategoryDataFactoryProvider;
    private final Provider<MerchantInfoMapper> merchantInfoMapperProvider;
    private final Provider<NearbyMeDataFactory> nearbyMeDataFactoryProvider;
    private final Provider<NearbyPromoResultMapper> nearbyPromoResultMapperProvider;
    private final Provider<OtherStoreListResultMapper> otherStoreListResultMapperProvider;
    private final Provider<NearbyShopsResultMapper> shopsResultMapperProvider;
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;

    public NearbyMeEntityRepository_Factory(Provider<NearbyMeDataFactory> provider, Provider<NearbyShopsResultMapper> provider2, Provider<MerchantInfoMapper> provider3, Provider<NearbyPromoResultMapper> provider4, Provider<OtherStoreListResultMapper> provider5, Provider<MerchantCategoriesEntityRepository> provider6, Provider<MerchantCategoriesEntityDataFactory> provider7, Provider<SplitConfigEntityData> provider8, Provider<CacheNearbyPromoFactory> provider9, Provider<ConfigEntityDataFactory> provider10, Provider<HoldLoginV1EntityRepository> provider11) {
        this.nearbyMeDataFactoryProvider = provider;
        this.shopsResultMapperProvider = provider2;
        this.merchantInfoMapperProvider = provider3;
        this.nearbyPromoResultMapperProvider = provider4;
        this.otherStoreListResultMapperProvider = provider5;
        this.merchantCategoriesEntityRepositoryProvider = provider6;
        this.merchantCategoryDataFactoryProvider = provider7;
        this.splitConfigEntityDataProvider = provider8;
        this.cacheNearbyPromoFactoryProvider = provider9;
        this.configEntityDataFactoryProvider = provider10;
        this.holdLoginV1EntityRepositoryProvider = provider11;
    }

    @Override // javax.inject.Provider
    public final NearbyMeEntityRepository get() {
        return newInstance(this.nearbyMeDataFactoryProvider.get(), this.shopsResultMapperProvider.get(), this.merchantInfoMapperProvider.get(), this.nearbyPromoResultMapperProvider.get(), this.otherStoreListResultMapperProvider.get(), this.merchantCategoriesEntityRepositoryProvider.get(), this.merchantCategoryDataFactoryProvider.get(), this.splitConfigEntityDataProvider.get(), this.cacheNearbyPromoFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static NearbyMeEntityRepository_Factory create(Provider<NearbyMeDataFactory> provider, Provider<NearbyShopsResultMapper> provider2, Provider<MerchantInfoMapper> provider3, Provider<NearbyPromoResultMapper> provider4, Provider<OtherStoreListResultMapper> provider5, Provider<MerchantCategoriesEntityRepository> provider6, Provider<MerchantCategoriesEntityDataFactory> provider7, Provider<SplitConfigEntityData> provider8, Provider<CacheNearbyPromoFactory> provider9, Provider<ConfigEntityDataFactory> provider10, Provider<HoldLoginV1EntityRepository> provider11) {
        return new NearbyMeEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static NearbyMeEntityRepository newInstance(NearbyMeDataFactory nearbyMeDataFactory, NearbyShopsResultMapper nearbyShopsResultMapper, MerchantInfoMapper merchantInfoMapper, NearbyPromoResultMapper nearbyPromoResultMapper, OtherStoreListResultMapper otherStoreListResultMapper, MerchantCategoriesEntityRepository merchantCategoriesEntityRepository, MerchantCategoriesEntityDataFactory merchantCategoriesEntityDataFactory, SplitConfigEntityData splitConfigEntityData, CacheNearbyPromoFactory cacheNearbyPromoFactory, ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new NearbyMeEntityRepository(nearbyMeDataFactory, nearbyShopsResultMapper, merchantInfoMapper, nearbyPromoResultMapper, otherStoreListResultMapper, merchantCategoriesEntityRepository, merchantCategoriesEntityDataFactory, splitConfigEntityData, cacheNearbyPromoFactory, configEntityDataFactory, holdLoginV1EntityRepository);
    }
}
