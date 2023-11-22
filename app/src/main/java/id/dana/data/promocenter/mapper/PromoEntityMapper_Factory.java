package id.dana.data.promocenter.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PromoEntityMapper_Factory implements Factory<PromoEntityMapper> {
    @Override // javax.inject.Provider
    public final PromoEntityMapper get() {
        return newInstance();
    }

    public static PromoEntityMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static PromoEntityMapper newInstance() {
        return new PromoEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PromoEntityMapper_Factory BuiltInFictitiousFunctionClassFactory = new PromoEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
