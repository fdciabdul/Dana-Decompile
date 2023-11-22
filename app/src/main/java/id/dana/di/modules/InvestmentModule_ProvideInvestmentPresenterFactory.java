package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InvestmentModule_ProvideInvestmentPresenterFactory implements Factory<InvestmentContract.Presenter> {
    private final InvestmentModule MyBillsEntityDataFactory;
    private final Provider<DanaPlusInvestmentPresenter> PlaceComponentResult;

    private InvestmentModule_ProvideInvestmentPresenterFactory(InvestmentModule investmentModule, Provider<DanaPlusInvestmentPresenter> provider) {
        this.MyBillsEntityDataFactory = investmentModule;
        this.PlaceComponentResult = provider;
    }

    public static InvestmentModule_ProvideInvestmentPresenterFactory PlaceComponentResult(InvestmentModule investmentModule, Provider<DanaPlusInvestmentPresenter> provider) {
        return new InvestmentModule_ProvideInvestmentPresenterFactory(investmentModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InvestmentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
