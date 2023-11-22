package id.dana.contract.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.user.GetUserInfoContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserInfoModule_ProvidePresenterFactory implements Factory<GetUserInfoContract.Presenter> {
    private final Provider<GetUserInfoPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetUserInfoModule getAuthRequestContext;

    private GetUserInfoModule_ProvidePresenterFactory(GetUserInfoModule getUserInfoModule, Provider<GetUserInfoPresenter> provider) {
        this.getAuthRequestContext = getUserInfoModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetUserInfoModule_ProvidePresenterFactory MyBillsEntityDataFactory(GetUserInfoModule getUserInfoModule, Provider<GetUserInfoPresenter> provider) {
        return new GetUserInfoModule_ProvidePresenterFactory(getUserInfoModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetUserInfoContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
