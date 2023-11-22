package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class TransferBankMapper_Factory implements Factory<TransferBankMapper> {
    public static TransferBankMapper_Factory getAuthRequestContext() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final TransferBankMapper_Factory PlaceComponentResult = new TransferBankMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferBankMapper();
    }
}
