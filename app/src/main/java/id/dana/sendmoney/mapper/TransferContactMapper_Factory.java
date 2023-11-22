package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class TransferContactMapper_Factory implements Factory<TransferContactMapper> {
    public static TransferContactMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final TransferContactMapper_Factory MyBillsEntityDataFactory = new TransferContactMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferContactMapper();
    }
}
