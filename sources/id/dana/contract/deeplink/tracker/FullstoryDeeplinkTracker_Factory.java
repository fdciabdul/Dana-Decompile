package id.dana.contract.deeplink.tracker;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class FullstoryDeeplinkTracker_Factory implements Factory<FullstoryDeeplinkTracker> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class InstanceHolder {
        private static final FullstoryDeeplinkTracker_Factory getAuthRequestContext = new FullstoryDeeplinkTracker_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FullstoryDeeplinkTracker();
    }
}
