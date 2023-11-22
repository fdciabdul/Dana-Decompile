package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.presenter.FriendRequestPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FriendRequestListModule_ProvidePresenterFactory implements Factory<FriendRequestContract.Presenter> {
    private final FriendRequestListModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FriendRequestPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    public static FriendRequestContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(FriendRequestListModule friendRequestListModule, FriendRequestPresenter friendRequestPresenter) {
        return (FriendRequestContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(friendRequestListModule.getAuthRequestContext(friendRequestPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendRequestContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
