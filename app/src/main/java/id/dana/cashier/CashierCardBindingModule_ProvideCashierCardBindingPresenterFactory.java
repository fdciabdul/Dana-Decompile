package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierCardBindingContract;
import id.dana.cashier.presenter.CashierCardBindingPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CashierCardBindingModule_ProvideCashierCardBindingPresenterFactory implements Factory<CashierCardBindingContract.Presenter> {
    private final Provider<CashierCardBindingPresenter> BuiltInFictitiousFunctionClassFactory;
    private final CashierCardBindingModule KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierCardBindingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
