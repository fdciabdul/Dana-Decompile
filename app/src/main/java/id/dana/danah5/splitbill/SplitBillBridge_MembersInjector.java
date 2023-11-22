package id.dana.danah5.splitbill;

import dagger.MembersInjector;
import id.dana.splitbill.SplitBillEventHandler;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SplitBillBridge_MembersInjector implements MembersInjector<SplitBillBridge> {
    private final Provider<SplitBillEventHandler> splitBillEventHandlerProvider;

    public SplitBillBridge_MembersInjector(Provider<SplitBillEventHandler> provider) {
        this.splitBillEventHandlerProvider = provider;
    }

    public static MembersInjector<SplitBillBridge> create(Provider<SplitBillEventHandler> provider) {
        return new SplitBillBridge_MembersInjector(provider);
    }

    public final void injectMembers(SplitBillBridge splitBillBridge) {
        injectSplitBillEventHandler(splitBillBridge, this.splitBillEventHandlerProvider.get());
    }

    public static void injectSplitBillEventHandler(SplitBillBridge splitBillBridge, SplitBillEventHandler splitBillEventHandler) {
        splitBillBridge.splitBillEventHandler = splitBillEventHandler;
    }
}
