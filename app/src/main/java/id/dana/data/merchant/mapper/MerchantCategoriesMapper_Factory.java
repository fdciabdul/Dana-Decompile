package id.dana.data.merchant.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MerchantCategoriesMapper_Factory implements Factory<MerchantCategoriesMapper> {
    @Override // javax.inject.Provider
    public final MerchantCategoriesMapper get() {
        return newInstance();
    }

    public static MerchantCategoriesMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static MerchantCategoriesMapper newInstance() {
        return new MerchantCategoriesMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MerchantCategoriesMapper_Factory getAuthRequestContext = new MerchantCategoriesMapper_Factory();

        private InstanceHolder() {
        }
    }
}
