package id.dana.investment.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.investment.interactor.CheckFeatureInvestment;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.investment.contract.InvestmentContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaPlusInvestmentPresenter_Factory implements Factory<DanaPlusInvestmentPresenter> {
    private final Provider<GetUserInvestmentSummary> MyBillsEntityDataFactory;
    private final Provider<InvestmentContract.View> PlaceComponentResult;
    private final Provider<CheckFeatureInvestment> getAuthRequestContext;

    private DanaPlusInvestmentPresenter_Factory(Provider<InvestmentContract.View> provider, Provider<CheckFeatureInvestment> provider2, Provider<GetUserInvestmentSummary> provider3) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static DanaPlusInvestmentPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<InvestmentContract.View> provider, Provider<CheckFeatureInvestment> provider2, Provider<GetUserInvestmentSummary> provider3) {
        return new DanaPlusInvestmentPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaPlusInvestmentPresenter(this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
