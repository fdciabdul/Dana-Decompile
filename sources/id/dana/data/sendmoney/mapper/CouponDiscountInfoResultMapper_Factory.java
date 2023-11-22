package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class CouponDiscountInfoResultMapper_Factory implements Factory<CouponDiscountInfoResultMapper> {
    @Override // javax.inject.Provider
    public final CouponDiscountInfoResultMapper get() {
        return newInstance();
    }

    public static CouponDiscountInfoResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static CouponDiscountInfoResultMapper newInstance() {
        return new CouponDiscountInfoResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CouponDiscountInfoResultMapper_Factory PlaceComponentResult = new CouponDiscountInfoResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
