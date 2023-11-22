package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class WithdrawOTCMapper_Factory implements Factory<WithdrawOTCMapper> {
    public static WithdrawOTCMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final WithdrawOTCMapper_Factory BuiltInFictitiousFunctionClassFactory = new WithdrawOTCMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WithdrawOTCMapper();
    }
}
