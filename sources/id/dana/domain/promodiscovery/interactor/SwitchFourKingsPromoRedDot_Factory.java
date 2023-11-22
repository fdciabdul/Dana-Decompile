package id.dana.domain.promodiscovery.interactor;

import dagger.internal.Factory;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SwitchFourKingsPromoRedDot_Factory implements Factory<SwitchFourKingsPromoRedDot> {
    private final Provider<PromoDiscoveryRepository> promoDiscoveryRepositoryProvider;

    public SwitchFourKingsPromoRedDot_Factory(Provider<PromoDiscoveryRepository> provider) {
        this.promoDiscoveryRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SwitchFourKingsPromoRedDot get() {
        return newInstance(this.promoDiscoveryRepositoryProvider.get());
    }

    public static SwitchFourKingsPromoRedDot_Factory create(Provider<PromoDiscoveryRepository> provider) {
        return new SwitchFourKingsPromoRedDot_Factory(provider);
    }

    public static SwitchFourKingsPromoRedDot newInstance(PromoDiscoveryRepository promoDiscoveryRepository) {
        return new SwitchFourKingsPromoRedDot(promoDiscoveryRepository);
    }
}
