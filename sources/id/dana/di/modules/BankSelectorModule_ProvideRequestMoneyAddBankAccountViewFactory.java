package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.bank.contract.BankSelectorContract;

/* loaded from: classes4.dex */
public final class BankSelectorModule_ProvideRequestMoneyAddBankAccountViewFactory implements Factory<BankSelectorContract.View> {
    private final BankSelectorModule BuiltInFictitiousFunctionClassFactory;

    private BankSelectorModule_ProvideRequestMoneyAddBankAccountViewFactory(BankSelectorModule bankSelectorModule) {
        this.BuiltInFictitiousFunctionClassFactory = bankSelectorModule;
    }

    public static BankSelectorModule_ProvideRequestMoneyAddBankAccountViewFactory MyBillsEntityDataFactory(BankSelectorModule bankSelectorModule) {
        return new BankSelectorModule_ProvideRequestMoneyAddBankAccountViewFactory(bankSelectorModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BankSelectorContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext());
    }
}
