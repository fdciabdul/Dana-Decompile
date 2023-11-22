package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CouponPayMethodInfoModelMapper_Factory implements Factory<CouponPayMethodInfoModelMapper> {
    private final Provider<CurrencyAmountModelMapper> MyBillsEntityDataFactory;

    private CouponPayMethodInfoModelMapper_Factory(Provider<CurrencyAmountModelMapper> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static CouponPayMethodInfoModelMapper_Factory PlaceComponentResult(Provider<CurrencyAmountModelMapper> provider) {
        return new CouponPayMethodInfoModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CouponPayMethodInfoModelMapper(this.MyBillsEntityDataFactory.get());
    }
}
