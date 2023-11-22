package id.dana.feeds.domain.friend.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.friend.FriendRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CancelAddFriend_Factory implements Factory<CancelAddFriend> {
    private final Provider<FriendRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MixpanelRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CancelAddFriend(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
