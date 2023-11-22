package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import id.dana.data.payasset.mapper.PayAssetMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendMoneyMapper_Factory implements Factory<SendMoneyMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<PayAssetMapper> payAssetMapperProvider;
    private final Provider<PayMethodRiskResultMapper> payMethodRiskResultMapperProvider;

    public SendMoneyMapper_Factory(Provider<CurrencyAmountResultMapper> provider, Provider<PayAssetMapper> provider2, Provider<PayMethodRiskResultMapper> provider3) {
        this.currencyAmountResultMapperProvider = provider;
        this.payAssetMapperProvider = provider2;
        this.payMethodRiskResultMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SendMoneyMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get(), this.payAssetMapperProvider.get(), this.payMethodRiskResultMapperProvider.get());
    }

    public static SendMoneyMapper_Factory create(Provider<CurrencyAmountResultMapper> provider, Provider<PayAssetMapper> provider2, Provider<PayMethodRiskResultMapper> provider3) {
        return new SendMoneyMapper_Factory(provider, provider2, provider3);
    }

    public static SendMoneyMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper, PayAssetMapper payAssetMapper, PayMethodRiskResultMapper payMethodRiskResultMapper) {
        return new SendMoneyMapper(currencyAmountResultMapper, payAssetMapper, payMethodRiskResultMapper);
    }
}
