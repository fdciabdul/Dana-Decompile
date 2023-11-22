package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import id.dana.data.sendmoney.mapper.PayMethodRiskResultMapper;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class PayChannelsInfoResultMapper_Factory implements Factory<PayChannelsInfoResultMapper> {
    private final Provider<PayMethodRiskResultMapper> payMethodRiskResultMapperProvider;
    private final Provider<VoucherInfoResultsMapper> voucherInfoResultsMapperProvider;

    public PayChannelsInfoResultMapper_Factory(Provider<PayMethodRiskResultMapper> provider, Provider<VoucherInfoResultsMapper> provider2) {
        this.payMethodRiskResultMapperProvider = provider;
        this.voucherInfoResultsMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PayChannelsInfoResultMapper get() {
        return newInstance(this.payMethodRiskResultMapperProvider.get(), this.voucherInfoResultsMapperProvider.get());
    }

    public static PayChannelsInfoResultMapper_Factory create(Provider<PayMethodRiskResultMapper> provider, Provider<VoucherInfoResultsMapper> provider2) {
        return new PayChannelsInfoResultMapper_Factory(provider, provider2);
    }

    public static PayChannelsInfoResultMapper newInstance(PayMethodRiskResultMapper payMethodRiskResultMapper, VoucherInfoResultsMapper voucherInfoResultsMapper) {
        return new PayChannelsInfoResultMapper(payMethodRiskResultMapper, voucherInfoResultsMapper);
    }
}
