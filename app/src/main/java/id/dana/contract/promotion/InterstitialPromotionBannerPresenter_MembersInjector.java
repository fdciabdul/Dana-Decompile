package id.dana.contract.promotion;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.domain.featureconfig.interactor.CheckInterstitialBannerFeature;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerGapTime;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerResetTime;

/* loaded from: classes4.dex */
public final class InterstitialPromotionBannerPresenter_MembersInjector implements MembersInjector<InterstitialPromotionBannerPresenter> {
    public static void BuiltInFictitiousFunctionClassFactory(InterstitialPromotionBannerPresenter interstitialPromotionBannerPresenter, Lazy<SaveInterstitialBannerGapTime> lazy, Lazy<SaveInterstitialBannerResetTime> lazy2, Lazy<CheckInterstitialBannerFeature> lazy3) {
        interstitialPromotionBannerPresenter.getAuthRequestContext = lazy;
        interstitialPromotionBannerPresenter.BuiltInFictitiousFunctionClassFactory = lazy2;
        interstitialPromotionBannerPresenter.MyBillsEntityDataFactory = lazy3;
    }
}
