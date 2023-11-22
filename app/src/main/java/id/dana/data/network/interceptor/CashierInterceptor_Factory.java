package id.dana.data.network.interceptor;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class CashierInterceptor_Factory implements Factory<CashierInterceptor> {
    public static CashierInterceptor_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CashierInterceptor_Factory BuiltInFictitiousFunctionClassFactory = new CashierInterceptor_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierInterceptor();
    }
}
