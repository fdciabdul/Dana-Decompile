package id.dana.danah5.share;

import dagger.MembersInjector;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ShareBridge_MembersInjector implements MembersInjector<ShareBridge> {
    private final Provider<ShareTextBroadcastReceiver> shareTextBroadcastReceiverProvider;

    public ShareBridge_MembersInjector(Provider<ShareTextBroadcastReceiver> provider) {
        this.shareTextBroadcastReceiverProvider = provider;
    }

    public static MembersInjector<ShareBridge> create(Provider<ShareTextBroadcastReceiver> provider) {
        return new ShareBridge_MembersInjector(provider);
    }

    public final void injectMembers(ShareBridge shareBridge) {
        injectShareTextBroadcastReceiver(shareBridge, this.shareTextBroadcastReceiverProvider.get());
    }

    public static void injectShareTextBroadcastReceiver(ShareBridge shareBridge, ShareTextBroadcastReceiver shareTextBroadcastReceiver) {
        shareBridge.shareTextBroadcastReceiver = shareTextBroadcastReceiver;
    }
}
