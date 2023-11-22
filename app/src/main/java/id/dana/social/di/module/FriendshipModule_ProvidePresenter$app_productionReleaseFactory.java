package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FriendshipContract;
import id.dana.social.presenter.FriendshipPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FriendshipModule_ProvidePresenter$app_productionReleaseFactory implements Factory<FriendshipContract.Presenter> {
    private final FriendshipModule MyBillsEntityDataFactory;
    private final Provider<FriendshipPresenter> PlaceComponentResult;

    private FriendshipModule_ProvidePresenter$app_productionReleaseFactory(FriendshipModule friendshipModule, Provider<FriendshipPresenter> provider) {
        this.MyBillsEntityDataFactory = friendshipModule;
        this.PlaceComponentResult = provider;
    }

    public static FriendshipModule_ProvidePresenter$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(FriendshipModule friendshipModule, Provider<FriendshipPresenter> provider) {
        return new FriendshipModule_ProvidePresenter$app_productionReleaseFactory(friendshipModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
