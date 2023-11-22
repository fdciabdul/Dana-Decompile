package id.dana.nearbyme.merchantdetail.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class MerchantAverageRatingMapper_Factory implements Factory<MerchantAverageRatingMapper> {
    public static MerchantAverageRatingMapper_Factory PlaceComponentResult() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final MerchantAverageRatingMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantAverageRatingMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantAverageRatingMapper();
    }
}
