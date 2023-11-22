package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierContract;
import id.dana.cashier.presenter.CashierPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierModule_ProvideCashierPresenterFactory implements Factory<CashierContract.Presenter> {
    private final CashierModule MyBillsEntityDataFactory;
    private final Provider<CashierPresenter> PlaceComponentResult;

    private CashierModule_ProvideCashierPresenterFactory(CashierModule cashierModule, Provider<CashierPresenter> provider) {
        this.MyBillsEntityDataFactory = cashierModule;
        this.PlaceComponentResult = provider;
    }

    public static CashierModule_ProvideCashierPresenterFactory PlaceComponentResult(CashierModule cashierModule, Provider<CashierPresenter> provider) {
        return new CashierModule_ProvideCashierPresenterFactory(cashierModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
