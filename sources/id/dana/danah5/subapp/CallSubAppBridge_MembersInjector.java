package id.dana.danah5.subapp;

import dagger.MembersInjector;
import id.dana.cashier.CashierEventHandler;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CallSubAppBridge_MembersInjector implements MembersInjector<CallSubAppBridge> {
    private final Provider<CashierEventHandler> cashierEventHandlerProvider;

    public CallSubAppBridge_MembersInjector(Provider<CashierEventHandler> provider) {
        this.cashierEventHandlerProvider = provider;
    }

    public static MembersInjector<CallSubAppBridge> create(Provider<CashierEventHandler> provider) {
        return new CallSubAppBridge_MembersInjector(provider);
    }

    public final void injectMembers(CallSubAppBridge callSubAppBridge) {
        injectCashierEventHandler(callSubAppBridge, this.cashierEventHandlerProvider.get());
    }

    public static void injectCashierEventHandler(CallSubAppBridge callSubAppBridge, CashierEventHandler cashierEventHandler) {
        callSubAppBridge.cashierEventHandler = cashierEventHandler;
    }
}
