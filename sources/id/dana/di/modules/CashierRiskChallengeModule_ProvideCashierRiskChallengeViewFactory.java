package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierRiskChallengeContract;

/* loaded from: classes4.dex */
public final class CashierRiskChallengeModule_ProvideCashierRiskChallengeViewFactory implements Factory<CashierRiskChallengeContract.View> {
    private final CashierRiskChallengeModule MyBillsEntityDataFactory;

    private CashierRiskChallengeModule_ProvideCashierRiskChallengeViewFactory(CashierRiskChallengeModule cashierRiskChallengeModule) {
        this.MyBillsEntityDataFactory = cashierRiskChallengeModule;
    }

    public static CashierRiskChallengeModule_ProvideCashierRiskChallengeViewFactory PlaceComponentResult(CashierRiskChallengeModule cashierRiskChallengeModule) {
        return new CashierRiskChallengeModule_ProvideCashierRiskChallengeViewFactory(cashierRiskChallengeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierRiskChallengeContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory());
    }
}
