package id.dana.danah5.cashier;

import dagger.MembersInjector;
import id.dana.cashier.CashierEventHandler;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CashierUrlEventHandler_MembersInjector implements MembersInjector<CashierUrlEventHandler> {
    private final Provider<CashierEventHandler> cashierEventHandlerProvider;

    public CashierUrlEventHandler_MembersInjector(Provider<CashierEventHandler> provider) {
        this.cashierEventHandlerProvider = provider;
    }

    public static MembersInjector<CashierUrlEventHandler> create(Provider<CashierEventHandler> provider) {
        return new CashierUrlEventHandler_MembersInjector(provider);
    }

    public final void injectMembers(CashierUrlEventHandler cashierUrlEventHandler) {
        injectCashierEventHandler(cashierUrlEventHandler, this.cashierEventHandlerProvider.get());
    }

    public static void injectCashierEventHandler(CashierUrlEventHandler cashierUrlEventHandler, CashierEventHandler cashierEventHandler) {
        cashierUrlEventHandler.cashierEventHandler = cashierEventHandler;
    }
}
