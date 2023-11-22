package id.dana.investment.presenter;

import dagger.internal.Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.investment.contract.GoldInvestmentContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GoldInvestmentPresenter_Factory implements Factory<GoldInvestmentPresenter> {
    private final Provider<GoldInvestmentContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserInvestmentSummary> getAuthRequestContext;

    private GoldInvestmentPresenter_Factory(Provider<GoldInvestmentContract.View> provider, Provider<GetUserInvestmentSummary> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static GoldInvestmentPresenter_Factory PlaceComponentResult(Provider<GoldInvestmentContract.View> provider, Provider<GetUserInvestmentSummary> provider2) {
        return new GoldInvestmentPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GoldInvestmentPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
