package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.domain.friend.interactor.AddFriend;
import id.dana.feeds.domain.friend.interactor.CancelAddFriend;
import id.dana.feeds.domain.friend.interactor.FindFriends;
import id.dana.social.contract.FriendListContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class FriendListPresenter_Factory implements Factory<FriendListPresenter> {
    private final Provider<FindFriends> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FriendListContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CancelAddFriend> PlaceComponentResult;
    private final Provider<AddFriend> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FriendListPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
