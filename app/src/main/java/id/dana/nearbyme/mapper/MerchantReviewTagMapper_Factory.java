package id.dana.nearbyme.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class MerchantReviewTagMapper_Factory implements Factory<MerchantReviewTagMapper> {
    public static MerchantReviewTagMapper_Factory PlaceComponentResult() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final MerchantReviewTagMapper_Factory BuiltInFictitiousFunctionClassFactory = new MerchantReviewTagMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantReviewTagMapper();
    }
}
