package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class TransferInitParamRequestMapper_Factory implements Factory<TransferInitParamRequestMapper> {
    @Override // javax.inject.Provider
    public final TransferInitParamRequestMapper get() {
        return newInstance();
    }

    public static TransferInitParamRequestMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static TransferInitParamRequestMapper newInstance() {
        return new TransferInitParamRequestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final TransferInitParamRequestMapper_Factory PlaceComponentResult = new TransferInitParamRequestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
