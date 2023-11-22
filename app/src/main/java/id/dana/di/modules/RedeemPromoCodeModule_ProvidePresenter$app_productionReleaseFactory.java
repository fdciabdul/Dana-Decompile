package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.promocode.RedeemPromoCodeContract;
import id.dana.promocode.RedeemPromoCodePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RedeemPromoCodeModule_ProvidePresenter$app_productionReleaseFactory implements Factory<RedeemPromoCodeContract.Presenter> {
    private final RedeemPromoCodeModule PlaceComponentResult;
    private final Provider<RedeemPromoCodePresenter> getAuthRequestContext;

    private RedeemPromoCodeModule_ProvidePresenter$app_productionReleaseFactory(RedeemPromoCodeModule redeemPromoCodeModule, Provider<RedeemPromoCodePresenter> provider) {
        this.PlaceComponentResult = redeemPromoCodeModule;
        this.getAuthRequestContext = provider;
    }

    public static RedeemPromoCodeModule_ProvidePresenter$app_productionReleaseFactory PlaceComponentResult(RedeemPromoCodeModule redeemPromoCodeModule, Provider<RedeemPromoCodePresenter> provider) {
        return new RedeemPromoCodeModule_ProvidePresenter$app_productionReleaseFactory(redeemPromoCodeModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RedeemPromoCodeContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
