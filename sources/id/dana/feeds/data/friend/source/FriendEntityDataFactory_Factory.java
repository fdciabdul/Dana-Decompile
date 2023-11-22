package id.dana.feeds.data.friend.source;

import dagger.internal.Factory;
import id.dana.feeds.data.friend.source.network.NetworkFriendEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FriendEntityDataFactory_Factory implements Factory<FriendEntityDataFactory> {
    private final Provider<NetworkFriendEntityData> getAuthRequestContext;

    private FriendEntityDataFactory_Factory(Provider<NetworkFriendEntityData> provider) {
        this.getAuthRequestContext = provider;
    }

    public static FriendEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkFriendEntityData> provider) {
        return new FriendEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FriendEntityDataFactory(this.getAuthRequestContext.get());
    }
}
