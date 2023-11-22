package id.dana.nearbyme.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class MerchantSubcategoriesMapper_Factory implements Factory<MerchantSubcategoriesMapper> {
    public static MerchantSubcategoriesMapper_Factory getAuthRequestContext() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final MerchantSubcategoriesMapper_Factory getAuthRequestContext = new MerchantSubcategoriesMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantSubcategoriesMapper();
    }
}
