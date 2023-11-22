package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;
import id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FriendsFeedsModule_ProvideFriendFeedsPresenterFactory implements Factory<FriendFeedsContract.Presenter> {
    private final Provider<FriendsFeedsPresenter> PlaceComponentResult;
    private final FriendsFeedsModule getAuthRequestContext;

    private FriendsFeedsModule_ProvideFriendFeedsPresenterFactory(FriendsFeedsModule friendsFeedsModule, Provider<FriendsFeedsPresenter> provider) {
        this.getAuthRequestContext = friendsFeedsModule;
        this.PlaceComponentResult = provider;
    }

    public static FriendsFeedsModule_ProvideFriendFeedsPresenterFactory MyBillsEntityDataFactory(FriendsFeedsModule friendsFeedsModule, Provider<FriendsFeedsPresenter> provider) {
        return new FriendsFeedsModule_ProvideFriendFeedsPresenterFactory(friendsFeedsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendFeedsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
