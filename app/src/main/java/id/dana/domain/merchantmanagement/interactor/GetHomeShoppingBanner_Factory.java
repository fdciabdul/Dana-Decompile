package id.dana.domain.merchantmanagement.interactor;

import dagger.internal.Factory;
import id.dana.domain.promotion.repository.PromotionRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetHomeShoppingBanner_Factory implements Factory<GetHomeShoppingBanner> {
    private final Provider<PromotionRepository> promotionRepositoryProvider;

    public GetHomeShoppingBanner_Factory(Provider<PromotionRepository> provider) {
        this.promotionRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetHomeShoppingBanner get() {
        return newInstance(this.promotionRepositoryProvider.get());
    }

    public static GetHomeShoppingBanner_Factory create(Provider<PromotionRepository> provider) {
        return new GetHomeShoppingBanner_Factory(provider);
    }

    public static GetHomeShoppingBanner newInstance(PromotionRepository promotionRepository) {
        return new GetHomeShoppingBanner(promotionRepository);
    }
}
