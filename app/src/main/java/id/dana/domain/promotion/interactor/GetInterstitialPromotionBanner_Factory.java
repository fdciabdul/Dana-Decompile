package id.dana.domain.promotion.interactor;

import dagger.internal.Factory;
import id.dana.domain.promotion.repository.PromotionRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetInterstitialPromotionBanner_Factory implements Factory<GetInterstitialPromotionBanner> {
    private final Provider<PromotionRepository> promotionRepositoryProvider;

    public GetInterstitialPromotionBanner_Factory(Provider<PromotionRepository> provider) {
        this.promotionRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetInterstitialPromotionBanner get() {
        return newInstance(this.promotionRepositoryProvider.get());
    }

    public static GetInterstitialPromotionBanner_Factory create(Provider<PromotionRepository> provider) {
        return new GetInterstitialPromotionBanner_Factory(provider);
    }

    public static GetInterstitialPromotionBanner newInstance(PromotionRepository promotionRepository) {
        return new GetInterstitialPromotionBanner(promotionRepository);
    }
}
