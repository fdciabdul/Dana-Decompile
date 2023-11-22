package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CashierRiskChallengeModule_ProvideCashierRiskChallengePresenterFactory implements Factory<CashierRiskChallengeContract.Presenter> {
    private final CashierRiskChallengeModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<CashierRiskChallengePresenter> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierRiskChallengeContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
