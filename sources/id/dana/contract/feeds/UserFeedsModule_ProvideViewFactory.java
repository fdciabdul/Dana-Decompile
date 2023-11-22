package id.dana.contract.feeds;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.feeds.UserFeedsContract;

/* loaded from: classes8.dex */
public final class UserFeedsModule_ProvideViewFactory implements Factory<UserFeedsContract.View> {
    private final UserFeedsModule getAuthRequestContext;

    private UserFeedsModule_ProvideViewFactory(UserFeedsModule userFeedsModule) {
        this.getAuthRequestContext = userFeedsModule;
    }

    public static UserFeedsModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(UserFeedsModule userFeedsModule) {
        return new UserFeedsModule_ProvideViewFactory(userFeedsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserFeedsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult());
    }
}
