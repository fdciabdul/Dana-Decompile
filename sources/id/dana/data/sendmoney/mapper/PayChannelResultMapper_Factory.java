package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PayChannelResultMapper_Factory implements Factory<PayChannelResultMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;

    public PayChannelResultMapper_Factory(Provider<CurrencyAmountResultMapper> provider) {
        this.currencyAmountResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PayChannelResultMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get());
    }

    public static PayChannelResultMapper_Factory create(Provider<CurrencyAmountResultMapper> provider) {
        return new PayChannelResultMapper_Factory(provider);
    }

    public static PayChannelResultMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper) {
        return new PayChannelResultMapper(currencyAmountResultMapper);
    }
}
