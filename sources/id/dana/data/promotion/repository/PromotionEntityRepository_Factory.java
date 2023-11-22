package id.dana.data.promotion.repository;

import dagger.internal.Factory;
import id.dana.data.account.general.repository.GeneralEntityDataFactory;
import id.dana.data.banner.repository.source.BannerCacheEntityDataFactory;
import id.dana.data.banner.repository.source.BannerEntityDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.content.mapper.BannerListEntityMapper;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.promotion.repository.source.persistence.PromoEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromotionEntityRepository_Factory implements Factory<PromotionEntityRepository> {
    private final Provider<BannerCacheEntityDataFactory> bannerCacheEntityDataFactoryProvider;
    private final Provider<BannerEntityDataFactory> bannerEntityDataFactoryProvider;
    private final Provider<BannerListEntityMapper> bannerListEntityMapperProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<ContentDeliveryCacheEntityDataFactory> contentDeliveryCacheEntityDataFactorProvider;
    private final Provider<ContentDeliveryEntityDataFactory> contentDeliveryEntityDataFactoryProvider;
    private final Provider<GeneralEntityDataFactory> generalEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<SpaceResultMapper> mapperProvider;
    private final Provider<PromoEntityDataFactory> promoEntityDataFactoryProvider;
    private final Provider<SendMoneyDataFactory> sendMoneyDataFactoryProvider;

    public PromotionEntityRepository_Factory(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ContentDeliveryCacheEntityDataFactory> provider2, Provider<BannerCacheEntityDataFactory> provider3, Provider<ConfigEntityDataFactory> provider4, Provider<SpaceResultMapper> provider5, Provider<PromoEntityDataFactory> provider6, Provider<SendMoneyDataFactory> provider7, Provider<GeneralEntityDataFactory> provider8, Provider<BannerEntityDataFactory> provider9, Provider<BannerListEntityMapper> provider10, Provider<HoldLoginV1EntityRepository> provider11) {
        this.contentDeliveryEntityDataFactoryProvider = provider;
        this.contentDeliveryCacheEntityDataFactorProvider = provider2;
        this.bannerCacheEntityDataFactoryProvider = provider3;
        this.configEntityDataFactoryProvider = provider4;
        this.mapperProvider = provider5;
        this.promoEntityDataFactoryProvider = provider6;
        this.sendMoneyDataFactoryProvider = provider7;
        this.generalEntityDataFactoryProvider = provider8;
        this.bannerEntityDataFactoryProvider = provider9;
        this.bannerListEntityMapperProvider = provider10;
        this.holdLoginV1EntityRepositoryProvider = provider11;
    }

    @Override // javax.inject.Provider
    public final PromotionEntityRepository get() {
        return newInstance(this.contentDeliveryEntityDataFactoryProvider.get(), this.contentDeliveryCacheEntityDataFactorProvider.get(), this.bannerCacheEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.mapperProvider.get(), this.promoEntityDataFactoryProvider.get(), this.sendMoneyDataFactoryProvider.get(), this.generalEntityDataFactoryProvider.get(), this.bannerEntityDataFactoryProvider.get(), this.bannerListEntityMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PromotionEntityRepository_Factory create(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ContentDeliveryCacheEntityDataFactory> provider2, Provider<BannerCacheEntityDataFactory> provider3, Provider<ConfigEntityDataFactory> provider4, Provider<SpaceResultMapper> provider5, Provider<PromoEntityDataFactory> provider6, Provider<SendMoneyDataFactory> provider7, Provider<GeneralEntityDataFactory> provider8, Provider<BannerEntityDataFactory> provider9, Provider<BannerListEntityMapper> provider10, Provider<HoldLoginV1EntityRepository> provider11) {
        return new PromotionEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static PromotionEntityRepository newInstance(ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory, BannerCacheEntityDataFactory bannerCacheEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, SpaceResultMapper spaceResultMapper, PromoEntityDataFactory promoEntityDataFactory, SendMoneyDataFactory sendMoneyDataFactory, GeneralEntityDataFactory generalEntityDataFactory, BannerEntityDataFactory bannerEntityDataFactory, BannerListEntityMapper bannerListEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PromotionEntityRepository(contentDeliveryEntityDataFactory, contentDeliveryCacheEntityDataFactory, bannerCacheEntityDataFactory, configEntityDataFactory, spaceResultMapper, promoEntityDataFactory, sendMoneyDataFactory, generalEntityDataFactory, bannerEntityDataFactory, bannerListEntityMapper, holdLoginV1EntityRepository);
    }
}
