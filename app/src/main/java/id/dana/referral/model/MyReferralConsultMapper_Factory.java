package id.dana.referral.model;

import dagger.internal.Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyReferralConsultMapper_Factory implements Factory<MyReferralConsultMapper> {
    private final Provider<CurrencyAmountModelMapper> BuiltInFictitiousFunctionClassFactory;

    private MyReferralConsultMapper_Factory(Provider<CurrencyAmountModelMapper> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static MyReferralConsultMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<CurrencyAmountModelMapper> provider) {
        return new MyReferralConsultMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyReferralConsultMapper(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
