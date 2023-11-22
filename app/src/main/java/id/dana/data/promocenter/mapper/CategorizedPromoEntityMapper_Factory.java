package id.dana.data.promocenter.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class CategorizedPromoEntityMapper_Factory implements Factory<CategorizedPromoEntityMapper> {
    @Override // javax.inject.Provider
    public final CategorizedPromoEntityMapper get() {
        return newInstance();
    }

    public static CategorizedPromoEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static CategorizedPromoEntityMapper newInstance() {
        return new CategorizedPromoEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CategorizedPromoEntityMapper_Factory PlaceComponentResult = new CategorizedPromoEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
