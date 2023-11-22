package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.bank.contract.BankListContract;
import id.dana.bank.contract.BankListPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RequestMoneyBankListModule_ProvideRequestMoneyBankBankListPresenterFactory implements Factory<BankListContract.Presenter> {
    private final Provider<BankListPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final RequestMoneyBankListModule MyBillsEntityDataFactory;

    private RequestMoneyBankListModule_ProvideRequestMoneyBankBankListPresenterFactory(RequestMoneyBankListModule requestMoneyBankListModule, Provider<BankListPresenter> provider) {
        this.MyBillsEntityDataFactory = requestMoneyBankListModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static RequestMoneyBankListModule_ProvideRequestMoneyBankBankListPresenterFactory MyBillsEntityDataFactory(RequestMoneyBankListModule requestMoneyBankListModule, Provider<BankListPresenter> provider) {
        return new RequestMoneyBankListModule_ProvideRequestMoneyBankBankListPresenterFactory(requestMoneyBankListModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BankListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
