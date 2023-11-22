package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierHighlightContract;
import id.dana.cashier.presenter.CashierHighlightPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CashierHighlightModule_ProvideCashierHighlightPresenterFactory implements Factory<CashierHighlightContract.Presenter> {
    private final Provider<CashierHighlightPresenter> PlaceComponentResult;
    private final CashierHighlightModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierHighlightContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
