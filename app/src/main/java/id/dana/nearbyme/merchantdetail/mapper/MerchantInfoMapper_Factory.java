package id.dana.nearbyme.merchantdetail.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class MerchantInfoMapper_Factory implements Factory<MerchantInfoMapper> {
    public static MerchantInfoMapper_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final MerchantInfoMapper_Factory MyBillsEntityDataFactory = new MerchantInfoMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantInfoMapper();
    }
}
