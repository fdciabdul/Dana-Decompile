package id.dana.domain.promodiscovery.interactor;

import dagger.internal.Factory;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDanaDealsThumbnail_Factory implements Factory<GetDanaDealsThumbnail> {
    private final Provider<PromoDiscoveryRepository> promoDiscoveryRepositoryProvider;

    public GetDanaDealsThumbnail_Factory(Provider<PromoDiscoveryRepository> provider) {
        this.promoDiscoveryRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDanaDealsThumbnail get() {
        return newInstance(this.promoDiscoveryRepositoryProvider.get());
    }

    public static GetDanaDealsThumbnail_Factory create(Provider<PromoDiscoveryRepository> provider) {
        return new GetDanaDealsThumbnail_Factory(provider);
    }

    public static GetDanaDealsThumbnail newInstance(PromoDiscoveryRepository promoDiscoveryRepository) {
        return new GetDanaDealsThumbnail(promoDiscoveryRepository);
    }
}
