package id.dana.myprofile.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PaymentSecuritySwitchMapper_Factory implements Factory<PaymentSecuritySwitchMapper> {
    public static PaymentSecuritySwitchMapper_Factory getAuthRequestContext() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final PaymentSecuritySwitchMapper_Factory BuiltInFictitiousFunctionClassFactory = new PaymentSecuritySwitchMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentSecuritySwitchMapper();
    }
}
