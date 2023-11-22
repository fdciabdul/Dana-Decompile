package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.presenter.TopUpAndPayPresenter;

/* loaded from: classes4.dex */
public final class CashierOneKlikChallengeFragment_MembersInjector implements MembersInjector<CashierOneKlikChallengeFragment> {
    public static void PlaceComponentResult(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        cashierOneKlikChallengeFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment, CashierPresenter cashierPresenter) {
        cashierOneKlikChallengeFragment.cashierPresenter = cashierPresenter;
    }

    public static void getAuthRequestContext(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment, TopUpAndPayPresenter topUpAndPayPresenter) {
        cashierOneKlikChallengeFragment.topUpAndPayPresenter = topUpAndPayPresenter;
    }
}
