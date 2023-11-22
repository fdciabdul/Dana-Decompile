package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CouponChannelInfoResultMapper_Factory implements Factory<CouponChannelInfoResultMapper> {
    private final Provider<CouponDiscountInfoResultMapper> couponDiscountInfoResultMapperProvider;
    private final Provider<CouponPayMethodInfoResultMapper> couponPayMethodInfoResultMapperProvider;
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;

    public CouponChannelInfoResultMapper_Factory(Provider<CurrencyAmountResultMapper> provider, Provider<CouponDiscountInfoResultMapper> provider2, Provider<CouponPayMethodInfoResultMapper> provider3) {
        this.currencyAmountResultMapperProvider = provider;
        this.couponDiscountInfoResultMapperProvider = provider2;
        this.couponPayMethodInfoResultMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CouponChannelInfoResultMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get(), this.couponDiscountInfoResultMapperProvider.get(), this.couponPayMethodInfoResultMapperProvider.get());
    }

    public static CouponChannelInfoResultMapper_Factory create(Provider<CurrencyAmountResultMapper> provider, Provider<CouponDiscountInfoResultMapper> provider2, Provider<CouponPayMethodInfoResultMapper> provider3) {
        return new CouponChannelInfoResultMapper_Factory(provider, provider2, provider3);
    }

    public static CouponChannelInfoResultMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper, CouponDiscountInfoResultMapper couponDiscountInfoResultMapper, CouponPayMethodInfoResultMapper couponPayMethodInfoResultMapper) {
        return new CouponChannelInfoResultMapper(currencyAmountResultMapper, couponDiscountInfoResultMapper, couponPayMethodInfoResultMapper);
    }
}
