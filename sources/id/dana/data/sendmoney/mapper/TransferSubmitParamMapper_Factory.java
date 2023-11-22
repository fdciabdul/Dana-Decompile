package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class TransferSubmitParamMapper_Factory implements Factory<TransferSubmitParamMapper> {
    @Override // javax.inject.Provider
    public final TransferSubmitParamMapper get() {
        return newInstance();
    }

    public static TransferSubmitParamMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static TransferSubmitParamMapper newInstance() {
        return new TransferSubmitParamMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final TransferSubmitParamMapper_Factory getAuthRequestContext = new TransferSubmitParamMapper_Factory();

        private InstanceHolder() {
        }
    }
}
