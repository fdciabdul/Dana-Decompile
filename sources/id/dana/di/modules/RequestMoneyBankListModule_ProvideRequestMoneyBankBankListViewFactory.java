package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.bank.contract.BankListContract;

/* loaded from: classes4.dex */
public final class RequestMoneyBankListModule_ProvideRequestMoneyBankBankListViewFactory implements Factory<BankListContract.View> {
    private final RequestMoneyBankListModule KClassImpl$Data$declaredNonStaticMembers$2;

    private RequestMoneyBankListModule_ProvideRequestMoneyBankBankListViewFactory(RequestMoneyBankListModule requestMoneyBankListModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = requestMoneyBankListModule;
    }

    public static RequestMoneyBankListModule_ProvideRequestMoneyBankBankListViewFactory getAuthRequestContext(RequestMoneyBankListModule requestMoneyBankListModule) {
        return new RequestMoneyBankListModule_ProvideRequestMoneyBankBankListViewFactory(requestMoneyBankListModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BankListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
