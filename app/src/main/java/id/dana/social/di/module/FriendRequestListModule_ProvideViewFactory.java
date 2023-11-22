package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FriendRequestContract;

/* loaded from: classes5.dex */
public final class FriendRequestListModule_ProvideViewFactory implements Factory<FriendRequestContract.View> {
    private final FriendRequestListModule PlaceComponentResult;

    public static FriendRequestContract.View getAuthRequestContext(FriendRequestListModule friendRequestListModule) {
        return (FriendRequestContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(friendRequestListModule.getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendRequestContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getBuiltInFictitiousFunctionClassFactory());
    }
}
