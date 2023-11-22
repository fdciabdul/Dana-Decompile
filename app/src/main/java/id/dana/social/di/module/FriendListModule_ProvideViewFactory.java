package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FriendListContract;

/* loaded from: classes5.dex */
public final class FriendListModule_ProvideViewFactory implements Factory<FriendListContract.View> {
    private final FriendListModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static FriendListContract.View BuiltInFictitiousFunctionClassFactory(FriendListModule friendListModule) {
        return (FriendListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(friendListModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
