package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CouponPayMethodInfoListModelMapper_Factory implements Factory<CouponPayMethodInfoListModelMapper> {
    private final Provider<CouponPayMethodInfoModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    private CouponPayMethodInfoListModelMapper_Factory(Provider<CouponPayMethodInfoModelMapper> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CouponPayMethodInfoListModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<CouponPayMethodInfoModelMapper> provider) {
        return new CouponPayMethodInfoListModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CouponPayMethodInfoListModelMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
