package id.dana.cashier.data.mapper;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CashierAddOnModalTooltipRequestMapper_Factory implements Factory<CashierAddOnModalTooltipRequestMapper> {
    @Override // javax.inject.Provider
    public final CashierAddOnModalTooltipRequestMapper get() {
        return newInstance();
    }

    public static CashierAddOnModalTooltipRequestMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static CashierAddOnModalTooltipRequestMapper newInstance() {
        return new CashierAddOnModalTooltipRequestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CashierAddOnModalTooltipRequestMapper_Factory PlaceComponentResult = new CashierAddOnModalTooltipRequestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
