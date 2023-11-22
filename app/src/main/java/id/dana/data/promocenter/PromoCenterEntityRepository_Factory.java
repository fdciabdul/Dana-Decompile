package id.dana.data.promocenter;

import dagger.internal.Factory;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.promocenter.mapper.CategorizedPromoEntityMapper;
import id.dana.data.promocenter.mapper.CategoryEntityMapper;
import id.dana.data.promocenter.mapper.PromoEntityMapper;
import id.dana.data.promocenter.repository.PromoCenterEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoCenterEntityRepository_Factory implements Factory<PromoCenterEntityRepository> {
    private final Provider<CategorizedPromoEntityMapper> categorizedPromoEntityMapperProvider;
    private final Provider<CategoryEntityMapper> categoryEntityMapperProvider;
    private final Provider<FeatureConfigEntityRepository> featureConfigEntityRepositoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PromoCenterEntityDataFactory> promoCenterEntityDataFactoryProvider;
    private final Provider<PromoEntityMapper> promoEntityMapperProvider;

    public PromoCenterEntityRepository_Factory(Provider<PromoCenterEntityDataFactory> provider, Provider<FeatureConfigEntityRepository> provider2, Provider<CategorizedPromoEntityMapper> provider3, Provider<CategoryEntityMapper> provider4, Provider<PromoEntityMapper> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        this.promoCenterEntityDataFactoryProvider = provider;
        this.featureConfigEntityRepositoryProvider = provider2;
        this.categorizedPromoEntityMapperProvider = provider3;
        this.categoryEntityMapperProvider = provider4;
        this.promoEntityMapperProvider = provider5;
        this.holdLoginV1EntityRepositoryProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final PromoCenterEntityRepository get() {
        return newInstance(this.promoCenterEntityDataFactoryProvider.get(), this.featureConfigEntityRepositoryProvider.get(), this.categorizedPromoEntityMapperProvider.get(), this.categoryEntityMapperProvider.get(), this.promoEntityMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PromoCenterEntityRepository_Factory create(Provider<PromoCenterEntityDataFactory> provider, Provider<FeatureConfigEntityRepository> provider2, Provider<CategorizedPromoEntityMapper> provider3, Provider<CategoryEntityMapper> provider4, Provider<PromoEntityMapper> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        return new PromoCenterEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PromoCenterEntityRepository newInstance(PromoCenterEntityDataFactory promoCenterEntityDataFactory, FeatureConfigEntityRepository featureConfigEntityRepository, CategorizedPromoEntityMapper categorizedPromoEntityMapper, CategoryEntityMapper categoryEntityMapper, PromoEntityMapper promoEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PromoCenterEntityRepository(promoCenterEntityDataFactory, featureConfigEntityRepository, categorizedPromoEntityMapper, categoryEntityMapper, promoEntityMapper, holdLoginV1EntityRepository);
    }
}
