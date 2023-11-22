package id.dana.cashier.data.mapper;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CashierPayInfoRequestMapper_Factory implements Factory<CashierPayInfoRequestMapper> {
    @Override // javax.inject.Provider
    public final CashierPayInfoRequestMapper get() {
        return newInstance();
    }

    public static CashierPayInfoRequestMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static CashierPayInfoRequestMapper newInstance() {
        return new CashierPayInfoRequestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CashierPayInfoRequestMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new CashierPayInfoRequestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
