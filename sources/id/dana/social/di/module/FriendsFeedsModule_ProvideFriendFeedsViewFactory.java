package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;

/* loaded from: classes5.dex */
public final class FriendsFeedsModule_ProvideFriendFeedsViewFactory implements Factory<FriendFeedsContract.View> {
    private final FriendsFeedsModule BuiltInFictitiousFunctionClassFactory;

    private FriendsFeedsModule_ProvideFriendFeedsViewFactory(FriendsFeedsModule friendsFeedsModule) {
        this.BuiltInFictitiousFunctionClassFactory = friendsFeedsModule;
    }

    public static FriendsFeedsModule_ProvideFriendFeedsViewFactory BuiltInFictitiousFunctionClassFactory(FriendsFeedsModule friendsFeedsModule) {
        return new FriendsFeedsModule_ProvideFriendFeedsViewFactory(friendsFeedsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendFeedsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory());
    }
}
