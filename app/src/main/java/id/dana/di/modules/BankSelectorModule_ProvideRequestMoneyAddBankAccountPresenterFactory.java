package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.bank.contract.BankSelectorContract;
import id.dana.bank.contract.BankSelectorPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BankSelectorModule_ProvideRequestMoneyAddBankAccountPresenterFactory implements Factory<BankSelectorContract.Presenter> {
    private final BankSelectorModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<BankSelectorPresenter> MyBillsEntityDataFactory;

    private BankSelectorModule_ProvideRequestMoneyAddBankAccountPresenterFactory(BankSelectorModule bankSelectorModule, Provider<BankSelectorPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bankSelectorModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static BankSelectorModule_ProvideRequestMoneyAddBankAccountPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(BankSelectorModule bankSelectorModule, Provider<BankSelectorPresenter> provider) {
        return new BankSelectorModule_ProvideRequestMoneyAddBankAccountPresenterFactory(bankSelectorModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BankSelectorContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
