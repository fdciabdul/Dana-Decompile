package id.dana.contract.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.user.GetUserInfoContract;

/* loaded from: classes4.dex */
public final class GetUserInfoModule_ProvideViewFactory implements Factory<GetUserInfoContract.View> {
    private final GetUserInfoModule KClassImpl$Data$declaredNonStaticMembers$2;

    private GetUserInfoModule_ProvideViewFactory(GetUserInfoModule getUserInfoModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getUserInfoModule;
    }

    public static GetUserInfoModule_ProvideViewFactory getAuthRequestContext(GetUserInfoModule getUserInfoModule) {
        return new GetUserInfoModule_ProvideViewFactory(getUserInfoModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetUserInfoContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}
