package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.presenter.CashierAddOnPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierAddOnModule_ProvideCashierAddOnPresenterFactory implements Factory<CashierAddOnContract.Presenter> {
    private final CashierAddOnModule MyBillsEntityDataFactory;
    private final Provider<CashierAddOnPresenter> PlaceComponentResult;

    private CashierAddOnModule_ProvideCashierAddOnPresenterFactory(CashierAddOnModule cashierAddOnModule, Provider<CashierAddOnPresenter> provider) {
        this.MyBillsEntityDataFactory = cashierAddOnModule;
        this.PlaceComponentResult = provider;
    }

    public static CashierAddOnModule_ProvideCashierAddOnPresenterFactory PlaceComponentResult(CashierAddOnModule cashierAddOnModule, Provider<CashierAddOnPresenter> provider) {
        return new CashierAddOnModule_ProvideCashierAddOnPresenterFactory(cashierAddOnModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierAddOnContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
