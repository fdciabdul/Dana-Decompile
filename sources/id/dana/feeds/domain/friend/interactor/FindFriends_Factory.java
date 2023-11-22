package id.dana.feeds.domain.friend.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.friend.FriendRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class FindFriends_Factory implements Factory<FindFriends> {
    private final Provider<FriendRepository> MyBillsEntityDataFactory;
    private final Provider<MixpanelRepository> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FindFriends(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
