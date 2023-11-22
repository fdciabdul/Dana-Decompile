package id.dana.sendmoney.paymethod;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PayMethodAdapter_Factory implements Factory<PayMethodAdapter> {
    public static PayMethodAdapter BuiltInFictitiousFunctionClassFactory() {
        return new PayMethodAdapter();
    }

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final PayMethodAdapter_Factory BuiltInFictitiousFunctionClassFactory = new PayMethodAdapter_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PayMethodAdapter();
    }
}
