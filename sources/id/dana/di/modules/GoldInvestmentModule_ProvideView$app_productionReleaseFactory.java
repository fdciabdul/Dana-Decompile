package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.investment.contract.GoldInvestmentContract;

/* loaded from: classes4.dex */
public final class GoldInvestmentModule_ProvideView$app_productionReleaseFactory implements Factory<GoldInvestmentContract.View> {
    private final GoldInvestmentModule MyBillsEntityDataFactory;

    private GoldInvestmentModule_ProvideView$app_productionReleaseFactory(GoldInvestmentModule goldInvestmentModule) {
        this.MyBillsEntityDataFactory = goldInvestmentModule;
    }

    public static GoldInvestmentModule_ProvideView$app_productionReleaseFactory getAuthRequestContext(GoldInvestmentModule goldInvestmentModule) {
        return new GoldInvestmentModule_ProvideView$app_productionReleaseFactory(goldInvestmentModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GoldInvestmentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getGetAuthRequestContext());
    }
}
