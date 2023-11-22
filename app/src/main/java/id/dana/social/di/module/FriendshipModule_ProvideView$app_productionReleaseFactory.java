package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FriendshipContract;

/* loaded from: classes5.dex */
public final class FriendshipModule_ProvideView$app_productionReleaseFactory implements Factory<FriendshipContract.View> {
    private final FriendshipModule BuiltInFictitiousFunctionClassFactory;

    private FriendshipModule_ProvideView$app_productionReleaseFactory(FriendshipModule friendshipModule) {
        this.BuiltInFictitiousFunctionClassFactory = friendshipModule;
    }

    public static FriendshipModule_ProvideView$app_productionReleaseFactory getAuthRequestContext(FriendshipModule friendshipModule) {
        return new FriendshipModule_ProvideView$app_productionReleaseFactory(friendshipModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getPlaceComponentResult());
    }
}
