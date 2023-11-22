package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.redeem.RedeemQuestContract;
import id.dana.contract.promoquest.redeem.RedeemQuestPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RedeemQuestModule_ProvideRedeemQuestPresenterFactory implements Factory<RedeemQuestContract.Presenter> {
    private final RedeemQuestModule PlaceComponentResult;
    private final Provider<RedeemQuestPresenter> getAuthRequestContext;

    private RedeemQuestModule_ProvideRedeemQuestPresenterFactory(RedeemQuestModule redeemQuestModule, Provider<RedeemQuestPresenter> provider) {
        this.PlaceComponentResult = redeemQuestModule;
        this.getAuthRequestContext = provider;
    }

    public static RedeemQuestModule_ProvideRedeemQuestPresenterFactory BuiltInFictitiousFunctionClassFactory(RedeemQuestModule redeemQuestModule, Provider<RedeemQuestPresenter> provider) {
        return new RedeemQuestModule_ProvideRedeemQuestPresenterFactory(redeemQuestModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RedeemQuestContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
