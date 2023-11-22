package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import id.dana.data.sendmoney.mapper.CouponPayMethodInfoResultMapper;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class VoucherInfoResultsMapper_Factory implements Factory<VoucherInfoResultsMapper> {
    private final Provider<CouponPayMethodInfoResultMapper> couponPayMethodInfoResultMapperProvider;

    public VoucherInfoResultsMapper_Factory(Provider<CouponPayMethodInfoResultMapper> provider) {
        this.couponPayMethodInfoResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VoucherInfoResultsMapper get() {
        return newInstance(this.couponPayMethodInfoResultMapperProvider.get());
    }

    public static VoucherInfoResultsMapper_Factory create(Provider<CouponPayMethodInfoResultMapper> provider) {
        return new VoucherInfoResultsMapper_Factory(provider);
    }

    public static VoucherInfoResultsMapper newInstance(CouponPayMethodInfoResultMapper couponPayMethodInfoResultMapper) {
        return new VoucherInfoResultsMapper(couponPayMethodInfoResultMapper);
    }
}
