package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class BizTransferOrderCreateResultMapper_Factory implements Factory<BizTransferOrderCreateResultMapper> {
    @Override // javax.inject.Provider
    public final BizTransferOrderCreateResultMapper get() {
        return newInstance();
    }

    public static BizTransferOrderCreateResultMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static BizTransferOrderCreateResultMapper newInstance() {
        return new BizTransferOrderCreateResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final BizTransferOrderCreateResultMapper_Factory getAuthRequestContext = new BizTransferOrderCreateResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
