package id.dana.domain.promodiscovery.interactor;

import dagger.internal.Factory;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPromoDiscoverySectionConfig_Factory implements Factory<GetPromoDiscoverySectionConfig> {
    private final Provider<PromoDiscoveryRepository> promoDiscoveryRepositoryProvider;

    public GetPromoDiscoverySectionConfig_Factory(Provider<PromoDiscoveryRepository> provider) {
        this.promoDiscoveryRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPromoDiscoverySectionConfig get() {
        return newInstance(this.promoDiscoveryRepositoryProvider.get());
    }

    public static GetPromoDiscoverySectionConfig_Factory create(Provider<PromoDiscoveryRepository> provider) {
        return new GetPromoDiscoverySectionConfig_Factory(provider);
    }

    public static GetPromoDiscoverySectionConfig newInstance(PromoDiscoveryRepository promoDiscoveryRepository) {
        return new GetPromoDiscoverySectionConfig(promoDiscoveryRepository);
    }
}
