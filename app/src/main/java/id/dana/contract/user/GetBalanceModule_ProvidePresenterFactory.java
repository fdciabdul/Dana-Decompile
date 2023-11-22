package id.dana.contract.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.user.GetBalanceContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBalanceModule_ProvidePresenterFactory implements Factory<GetBalanceContract.Presenter> {
    private final Provider<GetBalancePresenter> BuiltInFictitiousFunctionClassFactory;
    private final GetBalanceModule KClassImpl$Data$declaredNonStaticMembers$2;

    private GetBalanceModule_ProvidePresenterFactory(GetBalanceModule getBalanceModule, Provider<GetBalancePresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getBalanceModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetBalanceModule_ProvidePresenterFactory getAuthRequestContext(GetBalanceModule getBalanceModule, Provider<GetBalancePresenter> provider) {
        return new GetBalanceModule_ProvidePresenterFactory(getBalanceModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetBalanceContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
