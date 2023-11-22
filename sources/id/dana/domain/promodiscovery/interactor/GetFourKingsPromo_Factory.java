package id.dana.domain.promodiscovery.interactor;

import dagger.internal.Factory;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFourKingsPromo_Factory implements Factory<GetFourKingsPromo> {
    private final Provider<PromoDiscoveryRepository> promoDiscoveryRepositoryProvider;

    public GetFourKingsPromo_Factory(Provider<PromoDiscoveryRepository> provider) {
        this.promoDiscoveryRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFourKingsPromo get() {
        return newInstance(this.promoDiscoveryRepositoryProvider.get());
    }

    public static GetFourKingsPromo_Factory create(Provider<PromoDiscoveryRepository> provider) {
        return new GetFourKingsPromo_Factory(provider);
    }

    public static GetFourKingsPromo newInstance(PromoDiscoveryRepository promoDiscoveryRepository) {
        return new GetFourKingsPromo(promoDiscoveryRepository);
    }
}
