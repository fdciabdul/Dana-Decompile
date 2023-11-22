package id.dana.danah5.sendmoney;

import dagger.MembersInjector;
import id.dana.sendmoney_v2.recipient.SendMoneyEventHandler;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyBridge_MembersInjector implements MembersInjector<SendMoneyBridge> {
    private final Provider<SendMoneyEventHandler> sendMoneyEventHandlerProvider;

    public SendMoneyBridge_MembersInjector(Provider<SendMoneyEventHandler> provider) {
        this.sendMoneyEventHandlerProvider = provider;
    }

    public static MembersInjector<SendMoneyBridge> create(Provider<SendMoneyEventHandler> provider) {
        return new SendMoneyBridge_MembersInjector(provider);
    }

    public final void injectMembers(SendMoneyBridge sendMoneyBridge) {
        injectSendMoneyEventHandler(sendMoneyBridge, this.sendMoneyEventHandlerProvider.get());
    }

    public static void injectSendMoneyEventHandler(SendMoneyBridge sendMoneyBridge, SendMoneyEventHandler sendMoneyEventHandler) {
        sendMoneyBridge.sendMoneyEventHandler = sendMoneyEventHandler;
    }
}
