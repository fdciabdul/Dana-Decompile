package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WithdrawMethodViewResultMapper_Factory implements Factory<WithdrawMethodViewResultMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<PayMethodResultMapper> payMethodResultMapperProvider;
    private final Provider<WithdrawMethodOptionsResultMapper> withdrawMethodOptionsResultMapperProvider;

    public WithdrawMethodViewResultMapper_Factory(Provider<CurrencyAmountResultMapper> provider, Provider<WithdrawMethodOptionsResultMapper> provider2, Provider<PayMethodResultMapper> provider3) {
        this.currencyAmountResultMapperProvider = provider;
        this.withdrawMethodOptionsResultMapperProvider = provider2;
        this.payMethodResultMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final WithdrawMethodViewResultMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get(), this.withdrawMethodOptionsResultMapperProvider.get(), this.payMethodResultMapperProvider.get());
    }

    public static WithdrawMethodViewResultMapper_Factory create(Provider<CurrencyAmountResultMapper> provider, Provider<WithdrawMethodOptionsResultMapper> provider2, Provider<PayMethodResultMapper> provider3) {
        return new WithdrawMethodViewResultMapper_Factory(provider, provider2, provider3);
    }

    public static WithdrawMethodViewResultMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper, WithdrawMethodOptionsResultMapper withdrawMethodOptionsResultMapper, PayMethodResultMapper payMethodResultMapper) {
        return new WithdrawMethodViewResultMapper(currencyAmountResultMapper, withdrawMethodOptionsResultMapper, payMethodResultMapper);
    }
}
