package id.dana.feeds.domain.friend.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.friend.FriendRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AddFriend_Factory implements Factory<AddFriend> {
    private final Provider<FriendRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MixpanelRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AddFriend(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
