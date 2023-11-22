package id.dana.data.promocode.repository;

import dagger.internal.Factory;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.promocode.repository.source.PromoCodeEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoCodeEntityRepository_Factory implements Factory<PromoCodeEntityRepository> {
    private final Provider<GeocodeEntityRepository> geocodeEntityRepositoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PromoCodeEntityDataFactory> promoCodeEntityDataFactoryProvider;

    public PromoCodeEntityRepository_Factory(Provider<GeocodeEntityRepository> provider, Provider<PromoCodeEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.geocodeEntityRepositoryProvider = provider;
        this.promoCodeEntityDataFactoryProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PromoCodeEntityRepository get() {
        return newInstance(this.geocodeEntityRepositoryProvider.get(), this.promoCodeEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PromoCodeEntityRepository_Factory create(Provider<GeocodeEntityRepository> provider, Provider<PromoCodeEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new PromoCodeEntityRepository_Factory(provider, provider2, provider3);
    }

    public static PromoCodeEntityRepository newInstance(GeocodeEntityRepository geocodeEntityRepository, PromoCodeEntityDataFactory promoCodeEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PromoCodeEntityRepository(geocodeEntityRepository, promoCodeEntityDataFactory, holdLoginV1EntityRepository);
    }
}
