package id.dana.data.nearbyme.mapper;

import dagger.internal.Factory;
import id.dana.data.merchant.mapper.MerchantSubcategoryMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyShopsResultMapper_Factory implements Factory<NearbyShopsResultMapper> {
    private final Provider<PromoInfoEntityMapper> promoInfoEntityMapperProvider;
    private final Provider<MerchantSubcategoryMapper> subcategoryMapperProvider;

    public NearbyShopsResultMapper_Factory(Provider<MerchantSubcategoryMapper> provider, Provider<PromoInfoEntityMapper> provider2) {
        this.subcategoryMapperProvider = provider;
        this.promoInfoEntityMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NearbyShopsResultMapper get() {
        return newInstance(this.subcategoryMapperProvider.get(), this.promoInfoEntityMapperProvider.get());
    }

    public static NearbyShopsResultMapper_Factory create(Provider<MerchantSubcategoryMapper> provider, Provider<PromoInfoEntityMapper> provider2) {
        return new NearbyShopsResultMapper_Factory(provider, provider2);
    }

    public static NearbyShopsResultMapper newInstance(MerchantSubcategoryMapper merchantSubcategoryMapper, PromoInfoEntityMapper promoInfoEntityMapper) {
        return new NearbyShopsResultMapper(merchantSubcategoryMapper, promoInfoEntityMapper);
    }
}
