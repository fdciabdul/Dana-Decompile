package id.dana.danah5.tnccardpayment;

import dagger.MembersInjector;
import id.dana.cashier.TncCardPaymentEventHandler;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TncCardPaymentBridge_MembersInjector implements MembersInjector<TncCardPaymentBridge> {
    private final Provider<TncCardPaymentEventHandler> tncCardPaymentEventHandlerProvider;

    public TncCardPaymentBridge_MembersInjector(Provider<TncCardPaymentEventHandler> provider) {
        this.tncCardPaymentEventHandlerProvider = provider;
    }

    public static MembersInjector<TncCardPaymentBridge> create(Provider<TncCardPaymentEventHandler> provider) {
        return new TncCardPaymentBridge_MembersInjector(provider);
    }

    public final void injectMembers(TncCardPaymentBridge tncCardPaymentBridge) {
        injectTncCardPaymentEventHandler(tncCardPaymentBridge, this.tncCardPaymentEventHandlerProvider.get());
    }

    public static void injectTncCardPaymentEventHandler(TncCardPaymentBridge tncCardPaymentBridge, TncCardPaymentEventHandler tncCardPaymentEventHandler) {
        tncCardPaymentBridge.tncCardPaymentEventHandler = tncCardPaymentEventHandler;
    }
}
