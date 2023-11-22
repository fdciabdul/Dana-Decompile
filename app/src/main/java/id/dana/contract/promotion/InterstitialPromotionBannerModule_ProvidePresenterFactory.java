package id.dana.contract.promotion;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InterstitialPromotionBannerModule_ProvidePresenterFactory implements Factory<InterstitialPromotionBannerContract.Presenter> {
    private final InterstitialPromotionBannerModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<InterstitialPromotionBannerPresenter> MyBillsEntityDataFactory;

    private InterstitialPromotionBannerModule_ProvidePresenterFactory(InterstitialPromotionBannerModule interstitialPromotionBannerModule, Provider<InterstitialPromotionBannerPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = interstitialPromotionBannerModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static InterstitialPromotionBannerModule_ProvidePresenterFactory PlaceComponentResult(InterstitialPromotionBannerModule interstitialPromotionBannerModule, Provider<InterstitialPromotionBannerPresenter> provider) {
        return new InterstitialPromotionBannerModule_ProvidePresenterFactory(interstitialPromotionBannerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InterstitialPromotionBannerContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
