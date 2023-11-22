package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FriendListContract;
import id.dana.social.presenter.FriendListPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FriendListModule_ProvidePresenterFactory implements Factory<FriendListContract.Presenter> {
    private final Provider<FriendListPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final FriendListModule PlaceComponentResult;

    public static FriendListContract.Presenter BuiltInFictitiousFunctionClassFactory(FriendListModule friendListModule, FriendListPresenter friendListPresenter) {
        return (FriendListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(friendListModule.getAuthRequestContext(friendListPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
