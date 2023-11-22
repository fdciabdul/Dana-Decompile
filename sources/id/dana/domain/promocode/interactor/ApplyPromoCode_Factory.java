package id.dana.domain.promocode.interactor;

import dagger.internal.Factory;
import id.dana.domain.promocode.repository.PromoCodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ApplyPromoCode_Factory implements Factory<ApplyPromoCode> {
    private final Provider<PromoCodeRepository> promoCodeRepositoryProvider;

    public ApplyPromoCode_Factory(Provider<PromoCodeRepository> provider) {
        this.promoCodeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ApplyPromoCode get() {
        return newInstance(this.promoCodeRepositoryProvider.get());
    }

    public static ApplyPromoCode_Factory create(Provider<PromoCodeRepository> provider) {
        return new ApplyPromoCode_Factory(provider);
    }

    public static ApplyPromoCode newInstance(PromoCodeRepository promoCodeRepository) {
        return new ApplyPromoCode(promoCodeRepository);
    }
}
