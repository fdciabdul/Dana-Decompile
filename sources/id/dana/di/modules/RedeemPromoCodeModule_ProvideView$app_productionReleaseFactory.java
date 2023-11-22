package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.promocode.RedeemPromoCodeContract;

/* loaded from: classes4.dex */
public final class RedeemPromoCodeModule_ProvideView$app_productionReleaseFactory implements Factory<RedeemPromoCodeContract.View> {
    private final RedeemPromoCodeModule getAuthRequestContext;

    private RedeemPromoCodeModule_ProvideView$app_productionReleaseFactory(RedeemPromoCodeModule redeemPromoCodeModule) {
        this.getAuthRequestContext = redeemPromoCodeModule;
    }

    public static RedeemPromoCodeModule_ProvideView$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(RedeemPromoCodeModule redeemPromoCodeModule) {
        return new RedeemPromoCodeModule_ProvideView$app_productionReleaseFactory(redeemPromoCodeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RedeemPromoCodeContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
