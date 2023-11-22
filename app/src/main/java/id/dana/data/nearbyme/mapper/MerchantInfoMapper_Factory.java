package id.dana.data.nearbyme.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MerchantInfoMapper_Factory implements Factory<MerchantInfoMapper> {
    @Override // javax.inject.Provider
    public final MerchantInfoMapper get() {
        return newInstance();
    }

    public static MerchantInfoMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static MerchantInfoMapper newInstance() {
        return new MerchantInfoMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MerchantInfoMapper_Factory MyBillsEntityDataFactory = new MerchantInfoMapper_Factory();

        private InstanceHolder() {
        }
    }
}
