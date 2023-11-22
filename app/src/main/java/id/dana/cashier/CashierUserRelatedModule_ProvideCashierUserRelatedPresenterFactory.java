package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.cashier.presenter.CashierUserRelatedPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierUserRelatedModule_ProvideCashierUserRelatedPresenterFactory implements Factory<CashierUserRelatedContract.Presenter> {
    private final Provider<CashierUserRelatedPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final CashierUserRelatedModule PlaceComponentResult;

    private CashierUserRelatedModule_ProvideCashierUserRelatedPresenterFactory(CashierUserRelatedModule cashierUserRelatedModule, Provider<CashierUserRelatedPresenter> provider) {
        this.PlaceComponentResult = cashierUserRelatedModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CashierUserRelatedModule_ProvideCashierUserRelatedPresenterFactory getAuthRequestContext(CashierUserRelatedModule cashierUserRelatedModule, Provider<CashierUserRelatedPresenter> provider) {
        return new CashierUserRelatedModule_ProvideCashierUserRelatedPresenterFactory(cashierUserRelatedModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierUserRelatedContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
