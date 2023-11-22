package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WithdrawChannelViewResultMapper_Factory implements Factory<WithdrawChannelViewResultMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<PayMethodViewResultMapper> payMethodViewResultMapperProvider;

    public WithdrawChannelViewResultMapper_Factory(Provider<CurrencyAmountResultMapper> provider, Provider<PayMethodViewResultMapper> provider2) {
        this.currencyAmountResultMapperProvider = provider;
        this.payMethodViewResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final WithdrawChannelViewResultMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get(), this.payMethodViewResultMapperProvider.get());
    }

    public static WithdrawChannelViewResultMapper_Factory create(Provider<CurrencyAmountResultMapper> provider, Provider<PayMethodViewResultMapper> provider2) {
        return new WithdrawChannelViewResultMapper_Factory(provider, provider2);
    }

    public static WithdrawChannelViewResultMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper, PayMethodViewResultMapper payMethodViewResultMapper) {
        return new WithdrawChannelViewResultMapper(currencyAmountResultMapper, payMethodViewResultMapper);
    }
}
