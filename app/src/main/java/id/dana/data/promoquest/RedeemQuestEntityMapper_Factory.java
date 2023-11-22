package id.dana.data.promoquest;

import dagger.internal.Factory;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RedeemQuestEntityMapper_Factory implements Factory<RedeemQuestEntityMapper> {
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;

    public RedeemQuestEntityMapper_Factory(Provider<CurrencyAmountResultMapper> provider) {
        this.currencyAmountResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RedeemQuestEntityMapper get() {
        return newInstance(this.currencyAmountResultMapperProvider.get());
    }

    public static RedeemQuestEntityMapper_Factory create(Provider<CurrencyAmountResultMapper> provider) {
        return new RedeemQuestEntityMapper_Factory(provider);
    }

    public static RedeemQuestEntityMapper newInstance(CurrencyAmountResultMapper currencyAmountResultMapper) {
        return new RedeemQuestEntityMapper(currencyAmountResultMapper);
    }
}
