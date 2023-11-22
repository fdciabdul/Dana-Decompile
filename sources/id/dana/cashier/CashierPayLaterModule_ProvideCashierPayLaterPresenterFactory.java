package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.presenter.CashierPayLaterPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierPayLaterModule_ProvideCashierPayLaterPresenterFactory implements Factory<CashierPayLaterContract.Presenter> {
    private final Provider<CashierPayLaterPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final CashierPayLaterModule PlaceComponentResult;

    private CashierPayLaterModule_ProvideCashierPayLaterPresenterFactory(CashierPayLaterModule cashierPayLaterModule, Provider<CashierPayLaterPresenter> provider) {
        this.PlaceComponentResult = cashierPayLaterModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CashierPayLaterModule_ProvideCashierPayLaterPresenterFactory PlaceComponentResult(CashierPayLaterModule cashierPayLaterModule, Provider<CashierPayLaterPresenter> provider) {
        return new CashierPayLaterModule_ProvideCashierPayLaterPresenterFactory(cashierPayLaterModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierPayLaterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
