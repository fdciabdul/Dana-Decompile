package id.dana.contract.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.user.GetBalanceContract;

/* loaded from: classes4.dex */
public final class GetBalanceModule_ProvideViewFactory implements Factory<GetBalanceContract.View> {
    private final GetBalanceModule MyBillsEntityDataFactory;

    private GetBalanceModule_ProvideViewFactory(GetBalanceModule getBalanceModule) {
        this.MyBillsEntityDataFactory = getBalanceModule;
    }

    public static GetBalanceModule_ProvideViewFactory MyBillsEntityDataFactory(GetBalanceModule getBalanceModule) {
        return new GetBalanceModule_ProvideViewFactory(getBalanceModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetBalanceContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult());
    }
}
