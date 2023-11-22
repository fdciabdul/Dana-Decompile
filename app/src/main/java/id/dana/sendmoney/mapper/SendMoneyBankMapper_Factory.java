package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyBankMapper_Factory implements Factory<SendMoneyBankMapper> {
    private final Provider<CurrencyAmountModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PayMethodRiskMapper> PlaceComponentResult;

    private SendMoneyBankMapper_Factory(Provider<PayMethodRiskMapper> provider, Provider<CurrencyAmountModelMapper> provider2) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static SendMoneyBankMapper_Factory PlaceComponentResult(Provider<PayMethodRiskMapper> provider, Provider<CurrencyAmountModelMapper> provider2) {
        return new SendMoneyBankMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyBankMapper(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
