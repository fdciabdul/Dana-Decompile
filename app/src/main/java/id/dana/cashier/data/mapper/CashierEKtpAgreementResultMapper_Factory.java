package id.dana.cashier.data.mapper;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CashierEKtpAgreementResultMapper_Factory implements Factory<CashierEKtpAgreementResultMapper> {
    @Override // javax.inject.Provider
    public final CashierEKtpAgreementResultMapper get() {
        return newInstance();
    }

    public static CashierEKtpAgreementResultMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static CashierEKtpAgreementResultMapper newInstance() {
        return new CashierEKtpAgreementResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CashierEKtpAgreementResultMapper_Factory MyBillsEntityDataFactory = new CashierEKtpAgreementResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
