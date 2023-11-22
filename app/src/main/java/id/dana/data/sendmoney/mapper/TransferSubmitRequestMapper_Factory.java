package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class TransferSubmitRequestMapper_Factory implements Factory<TransferSubmitRequestMapper> {
    @Override // javax.inject.Provider
    public final TransferSubmitRequestMapper get() {
        return newInstance();
    }

    public static TransferSubmitRequestMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static TransferSubmitRequestMapper newInstance() {
        return new TransferSubmitRequestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final TransferSubmitRequestMapper_Factory MyBillsEntityDataFactory = new TransferSubmitRequestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
