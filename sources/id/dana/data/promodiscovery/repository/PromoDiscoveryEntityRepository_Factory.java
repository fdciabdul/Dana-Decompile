package id.dana.data.promodiscovery.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoDiscoveryEntityRepository_Factory implements Factory<PromoDiscoveryEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PromoDiscoveryEntityDataFactory> promoDiscoveryEntityDataFactoryProvider;

    public PromoDiscoveryEntityRepository_Factory(Provider<PromoDiscoveryEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.promoDiscoveryEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PromoDiscoveryEntityRepository get() {
        return newInstance(this.promoDiscoveryEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PromoDiscoveryEntityRepository_Factory create(Provider<PromoDiscoveryEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new PromoDiscoveryEntityRepository_Factory(provider, provider2);
    }

    public static PromoDiscoveryEntityRepository newInstance(PromoDiscoveryEntityDataFactory promoDiscoveryEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PromoDiscoveryEntityRepository(promoDiscoveryEntityDataFactory, holdLoginV1EntityRepository);
    }
}
