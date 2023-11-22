package id.dana.promocenter.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PromoAdsModelMapper_Factory implements Factory<PromoAdsModelMapper> {
    public static PromoAdsModelMapper_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final PromoAdsModelMapper_Factory BuiltInFictitiousFunctionClassFactory = new PromoAdsModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoAdsModelMapper();
    }
}
