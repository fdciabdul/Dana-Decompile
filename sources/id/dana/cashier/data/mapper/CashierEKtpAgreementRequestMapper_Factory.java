package id.dana.cashier.data.mapper;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CashierEKtpAgreementRequestMapper_Factory implements Factory<CashierEKtpAgreementRequestMapper> {
    @Override // javax.inject.Provider
    public final CashierEKtpAgreementRequestMapper get() {
        return newInstance();
    }

    public static CashierEKtpAgreementRequestMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static CashierEKtpAgreementRequestMapper newInstance() {
        return new CashierEKtpAgreementRequestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CashierEKtpAgreementRequestMapper_Factory getAuthRequestContext = new CashierEKtpAgreementRequestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
