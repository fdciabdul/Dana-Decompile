package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class TransferOTCSubmitRequestMapper_Factory implements Factory<TransferOTCSubmitRequestMapper> {
    @Override // javax.inject.Provider
    public final TransferOTCSubmitRequestMapper get() {
        return newInstance();
    }

    public static TransferOTCSubmitRequestMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static TransferOTCSubmitRequestMapper newInstance() {
        return new TransferOTCSubmitRequestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final TransferOTCSubmitRequestMapper_Factory getAuthRequestContext = new TransferOTCSubmitRequestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
