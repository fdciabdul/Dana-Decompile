package id.dana.data.merchant.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MerchantSubcategoryMapper_Factory implements Factory<MerchantSubcategoryMapper> {
    @Override // javax.inject.Provider
    public final MerchantSubcategoryMapper get() {
        return newInstance();
    }

    public static MerchantSubcategoryMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static MerchantSubcategoryMapper newInstance() {
        return new MerchantSubcategoryMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MerchantSubcategoryMapper_Factory MyBillsEntityDataFactory = new MerchantSubcategoryMapper_Factory();

        private InstanceHolder() {
        }
    }
}
