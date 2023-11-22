package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.investment.contract.GoldInvestmentContract;
import id.dana.investment.presenter.GoldInvestmentPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GoldInvestmentModule_ProvidePresenter$app_productionReleaseFactory implements Factory<GoldInvestmentContract.Presenter> {
    private final Provider<GoldInvestmentPresenter> BuiltInFictitiousFunctionClassFactory;
    private final GoldInvestmentModule PlaceComponentResult;

    private GoldInvestmentModule_ProvidePresenter$app_productionReleaseFactory(GoldInvestmentModule goldInvestmentModule, Provider<GoldInvestmentPresenter> provider) {
        this.PlaceComponentResult = goldInvestmentModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GoldInvestmentModule_ProvidePresenter$app_productionReleaseFactory MyBillsEntityDataFactory(GoldInvestmentModule goldInvestmentModule, Provider<GoldInvestmentPresenter> provider) {
        return new GoldInvestmentModule_ProvidePresenter$app_productionReleaseFactory(goldInvestmentModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GoldInvestmentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
