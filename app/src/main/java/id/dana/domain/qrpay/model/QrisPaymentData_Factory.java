package id.dana.domain.qrpay.model;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class QrisPaymentData_Factory implements Factory<QrisPaymentData> {
    @Override // javax.inject.Provider
    public final QrisPaymentData get() {
        return newInstance();
    }

    public static QrisPaymentData_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static QrisPaymentData newInstance() {
        return new QrisPaymentData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final QrisPaymentData_Factory MyBillsEntityDataFactory = new QrisPaymentData_Factory();

        private InstanceHolder() {
        }
    }
}
