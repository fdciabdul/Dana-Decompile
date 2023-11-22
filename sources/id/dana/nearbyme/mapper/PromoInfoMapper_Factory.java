package id.dana.nearbyme.mapper;

import dagger.internal.Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PromoInfoMapper_Factory implements Factory<PromoInfoMapper> {
    private final Provider<PromoLimitInfoMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CurrencyAmountModelMapper> getAuthRequestContext;

    private PromoInfoMapper_Factory(Provider<CurrencyAmountModelMapper> provider, Provider<PromoLimitInfoMapper> provider2) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static PromoInfoMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<CurrencyAmountModelMapper> provider, Provider<PromoLimitInfoMapper> provider2) {
        return new PromoInfoMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoInfoMapper(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
