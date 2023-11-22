package id.dana.cashier.data.mapper;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CashierAddOnModalTooltipResultMapper_Factory implements Factory<CashierAddOnModalTooltipResultMapper> {
    @Override // javax.inject.Provider
    public final CashierAddOnModalTooltipResultMapper get() {
        return newInstance();
    }

    public static CashierAddOnModalTooltipResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static CashierAddOnModalTooltipResultMapper newInstance() {
        return new CashierAddOnModalTooltipResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CashierAddOnModalTooltipResultMapper_Factory PlaceComponentResult = new CashierAddOnModalTooltipResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
