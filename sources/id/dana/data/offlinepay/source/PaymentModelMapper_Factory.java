package id.dana.data.offlinepay.source;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PaymentModelMapper_Factory implements Factory<PaymentModelMapper> {
    @Override // javax.inject.Provider
    public final PaymentModelMapper get() {
        return newInstance();
    }

    public static PaymentModelMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static PaymentModelMapper newInstance() {
        return new PaymentModelMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PaymentModelMapper_Factory getAuthRequestContext = new PaymentModelMapper_Factory();

        private InstanceHolder() {
        }
    }
}
