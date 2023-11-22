package id.dana.data.payasset.mapper;

import dagger.internal.Factory;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PayAssetMapper_Factory implements Factory<PayAssetMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;

    public PayAssetMapper_Factory(Provider<CurrencyAmountResultMapper> provider) {
        this.currencyAmountResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PayAssetMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get());
    }

    public static PayAssetMapper_Factory create(Provider<CurrencyAmountResultMapper> provider) {
        return new PayAssetMapper_Factory(provider);
    }

    public static PayAssetMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper) {
        return new PayAssetMapper(currencyAmountResultMapper);
    }
}
