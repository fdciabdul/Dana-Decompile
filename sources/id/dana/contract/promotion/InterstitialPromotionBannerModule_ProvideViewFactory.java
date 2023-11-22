package id.dana.contract.promotion;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;

/* loaded from: classes4.dex */
public final class InterstitialPromotionBannerModule_ProvideViewFactory implements Factory<InterstitialPromotionBannerContract.View> {
    private final InterstitialPromotionBannerModule MyBillsEntityDataFactory;

    private InterstitialPromotionBannerModule_ProvideViewFactory(InterstitialPromotionBannerModule interstitialPromotionBannerModule) {
        this.MyBillsEntityDataFactory = interstitialPromotionBannerModule;
    }

    public static InterstitialPromotionBannerModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(InterstitialPromotionBannerModule interstitialPromotionBannerModule) {
        return new InterstitialPromotionBannerModule_ProvideViewFactory(interstitialPromotionBannerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InterstitialPromotionBannerContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
