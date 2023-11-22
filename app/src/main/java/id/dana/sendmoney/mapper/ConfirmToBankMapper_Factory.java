package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ConfirmToBankMapper_Factory implements Factory<ConfirmToBankMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InstanceHolder {
        private static final ConfirmToBankMapper_Factory MyBillsEntityDataFactory = new ConfirmToBankMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConfirmToBankMapper();
    }
}
