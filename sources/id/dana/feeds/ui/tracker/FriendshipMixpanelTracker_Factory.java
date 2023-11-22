package id.dana.feeds.ui.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FriendshipMixpanelTracker_Factory implements Factory<FriendshipMixpanelTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private FriendshipMixpanelTracker_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static FriendshipMixpanelTracker_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new FriendshipMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FriendshipMixpanelTracker(this.MyBillsEntityDataFactory.get());
    }
}
