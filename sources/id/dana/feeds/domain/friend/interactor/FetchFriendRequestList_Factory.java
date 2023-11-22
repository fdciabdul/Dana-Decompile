package id.dana.feeds.domain.friend.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.friend.FriendRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class FetchFriendRequestList_Factory implements Factory<FetchFriendRequestList> {
    private final Provider<FriendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FetchFriendRequestList(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
