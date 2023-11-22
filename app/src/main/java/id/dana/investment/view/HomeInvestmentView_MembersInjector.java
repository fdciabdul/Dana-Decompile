package id.dana.investment.view;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.investment.contract.InvestmentContract;

/* loaded from: classes5.dex */
public final class HomeInvestmentView_MembersInjector implements MembersInjector<HomeInvestmentView> {
    public static void BuiltInFictitiousFunctionClassFactory(HomeInvestmentView homeInvestmentView, Lazy<InvestmentContract.Presenter> lazy) {
        homeInvestmentView.investmentPresenter = lazy;
    }
}
