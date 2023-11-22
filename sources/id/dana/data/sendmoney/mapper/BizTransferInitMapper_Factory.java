package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BizTransferInitMapper_Factory implements Factory<BizTransferInitMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<WithdrawMethodViewResultMapper> withdrawMethodViewResultMapperProvider;

    public BizTransferInitMapper_Factory(Provider<WithdrawMethodViewResultMapper> provider, Provider<CurrencyAmountResultMapper> provider2) {
        this.withdrawMethodViewResultMapperProvider = provider;
        this.currencyAmountResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final BizTransferInitMapper get() {
        return newInstance(this.withdrawMethodViewResultMapperProvider.get(), this.currencyAmountResultMapperProvider.get());
    }

    public static BizTransferInitMapper_Factory create(Provider<WithdrawMethodViewResultMapper> provider, Provider<CurrencyAmountResultMapper> provider2) {
        return new BizTransferInitMapper_Factory(provider, provider2);
    }

    public static BizTransferInitMapper newInstance(WithdrawMethodViewResultMapper withdrawMethodViewResultMapper, CurrencyAmountResultMapper currencyAmountResultMapper) {
        return new BizTransferInitMapper(withdrawMethodViewResultMapper, currencyAmountResultMapper);
    }
}
