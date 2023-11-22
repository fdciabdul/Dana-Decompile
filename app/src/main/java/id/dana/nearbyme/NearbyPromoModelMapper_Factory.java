package id.dana.nearbyme;

import dagger.internal.Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NearbyPromoModelMapper_Factory implements Factory<NearbyPromoModelMapper> {
    private final Provider<CurrencyAmountModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    private NearbyPromoModelMapper_Factory(Provider<CurrencyAmountModelMapper> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static NearbyPromoModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<CurrencyAmountModelMapper> provider) {
        return new NearbyPromoModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NearbyPromoModelMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
