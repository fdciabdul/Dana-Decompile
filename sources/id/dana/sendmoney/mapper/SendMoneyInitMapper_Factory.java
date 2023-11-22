package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyInitMapper_Factory implements Factory<SendMoneyInitMapper> {
    private final Provider<CurrencyAmountModelMapper> PlaceComponentResult;

    private SendMoneyInitMapper_Factory(Provider<CurrencyAmountModelMapper> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SendMoneyInitMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<CurrencyAmountModelMapper> provider) {
        return new SendMoneyInitMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyInitMapper(this.PlaceComponentResult.get());
    }
}
