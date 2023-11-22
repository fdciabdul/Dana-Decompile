package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PayMethodResultMapper_Factory implements Factory<PayMethodResultMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<PayMethodViewResultMapper> payMethodViewResultMapperProvider;

    public PayMethodResultMapper_Factory(Provider<CurrencyAmountResultMapper> provider, Provider<PayMethodViewResultMapper> provider2) {
        this.currencyAmountResultMapperProvider = provider;
        this.payMethodViewResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PayMethodResultMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get(), this.payMethodViewResultMapperProvider.get());
    }

    public static PayMethodResultMapper_Factory create(Provider<CurrencyAmountResultMapper> provider, Provider<PayMethodViewResultMapper> provider2) {
        return new PayMethodResultMapper_Factory(provider, provider2);
    }

    public static PayMethodResultMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper, PayMethodViewResultMapper payMethodViewResultMapper) {
        return new PayMethodResultMapper(currencyAmountResultMapper, payMethodViewResultMapper);
    }
}
