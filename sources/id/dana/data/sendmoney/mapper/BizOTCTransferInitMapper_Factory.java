package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BizOTCTransferInitMapper_Factory implements Factory<BizOTCTransferInitMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<WithdrawMethodViewResultMapper> withdrawMethodViewResultMapperProvider;

    public BizOTCTransferInitMapper_Factory(Provider<CurrencyAmountResultMapper> provider, Provider<WithdrawMethodViewResultMapper> provider2) {
        this.currencyAmountResultMapperProvider = provider;
        this.withdrawMethodViewResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final BizOTCTransferInitMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get(), this.withdrawMethodViewResultMapperProvider.get());
    }

    public static BizOTCTransferInitMapper_Factory create(Provider<CurrencyAmountResultMapper> provider, Provider<WithdrawMethodViewResultMapper> provider2) {
        return new BizOTCTransferInitMapper_Factory(provider, provider2);
    }

    public static BizOTCTransferInitMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper, WithdrawMethodViewResultMapper withdrawMethodViewResultMapper) {
        return new BizOTCTransferInitMapper(currencyAmountResultMapper, withdrawMethodViewResultMapper);
    }
}
