package id.dana.data.nearbyme.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyPromoResultMapper_Factory implements Factory<NearbyPromoResultMapper> {
    private final Provider<PromoInfoEntityMapper> promoInfoEntityMapperProvider;

    public NearbyPromoResultMapper_Factory(Provider<PromoInfoEntityMapper> provider) {
        this.promoInfoEntityMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NearbyPromoResultMapper get() {
        return newInstance(this.promoInfoEntityMapperProvider.get());
    }

    public static NearbyPromoResultMapper_Factory create(Provider<PromoInfoEntityMapper> provider) {
        return new NearbyPromoResultMapper_Factory(provider);
    }

    public static NearbyPromoResultMapper newInstance(PromoInfoEntityMapper promoInfoEntityMapper) {
        return new NearbyPromoResultMapper(promoInfoEntityMapper);
    }
}
