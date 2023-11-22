package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class WithdrawNameCheckMapper_Factory implements Factory<WithdrawNameCheckMapper> {
    @Override // javax.inject.Provider
    public final WithdrawNameCheckMapper get() {
        return newInstance();
    }

    public static WithdrawNameCheckMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static WithdrawNameCheckMapper newInstance() {
        return new WithdrawNameCheckMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final WithdrawNameCheckMapper_Factory BuiltInFictitiousFunctionClassFactory = new WithdrawNameCheckMapper_Factory();

        private InstanceHolder() {
        }
    }
}
