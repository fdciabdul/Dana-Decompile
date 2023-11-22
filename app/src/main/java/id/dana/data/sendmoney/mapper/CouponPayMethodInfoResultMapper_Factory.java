package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CouponPayMethodInfoResultMapper_Factory implements Factory<CouponPayMethodInfoResultMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;

    public CouponPayMethodInfoResultMapper_Factory(Provider<CurrencyAmountResultMapper> provider) {
        this.currencyAmountResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CouponPayMethodInfoResultMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get());
    }

    public static CouponPayMethodInfoResultMapper_Factory create(Provider<CurrencyAmountResultMapper> provider) {
        return new CouponPayMethodInfoResultMapper_Factory(provider);
    }

    public static CouponPayMethodInfoResultMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper) {
        return new CouponPayMethodInfoResultMapper(currencyAmountResultMapper);
    }
}
