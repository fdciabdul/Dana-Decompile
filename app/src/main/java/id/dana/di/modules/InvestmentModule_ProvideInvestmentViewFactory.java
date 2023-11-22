package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.investment.contract.InvestmentContract;

/* loaded from: classes4.dex */
public final class InvestmentModule_ProvideInvestmentViewFactory implements Factory<InvestmentContract.View> {
    private final InvestmentModule BuiltInFictitiousFunctionClassFactory;

    private InvestmentModule_ProvideInvestmentViewFactory(InvestmentModule investmentModule) {
        this.BuiltInFictitiousFunctionClassFactory = investmentModule;
    }

    public static InvestmentModule_ProvideInvestmentViewFactory KClassImpl$Data$declaredNonStaticMembers$2(InvestmentModule investmentModule) {
        return new InvestmentModule_ProvideInvestmentViewFactory(investmentModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InvestmentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getPlaceComponentResult());
    }
}
