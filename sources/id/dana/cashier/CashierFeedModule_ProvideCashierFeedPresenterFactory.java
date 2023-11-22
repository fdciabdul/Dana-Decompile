package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierFeedContract;
import id.dana.cashier.presenter.CashierFeedPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierFeedModule_ProvideCashierFeedPresenterFactory implements Factory<CashierFeedContract.Presenter> {
    private final Provider<CashierFeedPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final CashierFeedModule PlaceComponentResult;

    private CashierFeedModule_ProvideCashierFeedPresenterFactory(CashierFeedModule cashierFeedModule, Provider<CashierFeedPresenter> provider) {
        this.PlaceComponentResult = cashierFeedModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CashierFeedModule_ProvideCashierFeedPresenterFactory BuiltInFictitiousFunctionClassFactory(CashierFeedModule cashierFeedModule, Provider<CashierFeedPresenter> provider) {
        return new CashierFeedModule_ProvideCashierFeedPresenterFactory(cashierFeedModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierFeedContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
