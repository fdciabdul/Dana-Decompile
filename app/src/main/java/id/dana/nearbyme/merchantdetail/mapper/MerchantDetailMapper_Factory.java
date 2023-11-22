package id.dana.nearbyme.merchantdetail.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class MerchantDetailMapper_Factory implements Factory<MerchantDetailMapper> {
    public static MerchantDetailMapper_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final MerchantDetailMapper_Factory MyBillsEntityDataFactory = new MerchantDetailMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantDetailMapper();
    }
}
