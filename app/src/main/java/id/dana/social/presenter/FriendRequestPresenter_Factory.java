package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.domain.config.interactor.ApproveFriendRequest;
import id.dana.feeds.domain.config.interactor.DeclineFriendRequest;
import id.dana.feeds.domain.friend.interactor.FetchFriendRequestList;
import id.dana.social.contract.FriendRequestContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class FriendRequestPresenter_Factory implements Factory<FriendRequestPresenter> {
    private final Provider<FetchFriendRequestList> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ApproveFriendRequest> MyBillsEntityDataFactory;
    private final Provider<FriendRequestContract.View> PlaceComponentResult;
    private final Provider<DeclineFriendRequest> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FriendRequestPresenter(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
