package id.dana.myprofile.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PaymentSecurityInitMapper_Factory implements Factory<PaymentSecurityInitMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InstanceHolder {
        private static final PaymentSecurityInitMapper_Factory MyBillsEntityDataFactory = new PaymentSecurityInitMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentSecurityInitMapper();
    }
}
