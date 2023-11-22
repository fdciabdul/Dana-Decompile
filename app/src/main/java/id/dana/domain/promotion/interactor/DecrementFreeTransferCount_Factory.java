package id.dana.domain.promotion.interactor;

import dagger.internal.Factory;
import id.dana.domain.promotion.repository.PromotionRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DecrementFreeTransferCount_Factory implements Factory<DecrementFreeTransferCount> {
    private final Provider<PromotionRepository> promotionRepositoryProvider;

    public DecrementFreeTransferCount_Factory(Provider<PromotionRepository> provider) {
        this.promotionRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DecrementFreeTransferCount get() {
        return newInstance(this.promotionRepositoryProvider.get());
    }

    public static DecrementFreeTransferCount_Factory create(Provider<PromotionRepository> provider) {
        return new DecrementFreeTransferCount_Factory(provider);
    }

    public static DecrementFreeTransferCount newInstance(PromotionRepository promotionRepository) {
        return new DecrementFreeTransferCount(promotionRepository);
    }
}
