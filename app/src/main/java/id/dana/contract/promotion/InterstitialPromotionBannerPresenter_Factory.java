package id.dana.contract.promotion;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import id.dana.domain.featureconfig.interactor.CheckInterstitialBannerFeature;
import id.dana.domain.promotion.interactor.GetInterstitialPromotionBanner;
import id.dana.domain.promotion.interactor.ReadInterstitialPromotionBanner;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerGapTime;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerResetTime;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InterstitialPromotionBannerPresenter_Factory implements Factory<InterstitialPromotionBannerPresenter> {
    private final Provider<ReadInterstitialPromotionBanner> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckInterstitialBannerFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetInterstitialPromotionBanner> MyBillsEntityDataFactory;
    private final Provider<SaveInterstitialBannerResetTime> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<SaveInterstitialBannerGapTime> getAuthRequestContext;
    private final Provider<InterstitialPromotionBannerContract.View> lookAheadTest;

    private InterstitialPromotionBannerPresenter_Factory(Provider<InterstitialPromotionBannerContract.View> provider, Provider<GetInterstitialPromotionBanner> provider2, Provider<ReadInterstitialPromotionBanner> provider3, Provider<Context> provider4, Provider<SaveInterstitialBannerGapTime> provider5, Provider<SaveInterstitialBannerResetTime> provider6, Provider<CheckInterstitialBannerFeature> provider7) {
        this.lookAheadTest = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.PlaceComponentResult = provider4;
        this.getAuthRequestContext = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
    }

    public static InterstitialPromotionBannerPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<InterstitialPromotionBannerContract.View> provider, Provider<GetInterstitialPromotionBanner> provider2, Provider<ReadInterstitialPromotionBanner> provider3, Provider<Context> provider4, Provider<SaveInterstitialBannerGapTime> provider5, Provider<SaveInterstitialBannerResetTime> provider6, Provider<CheckInterstitialBannerFeature> provider7) {
        return new InterstitialPromotionBannerPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        InterstitialPromotionBannerPresenter interstitialPromotionBannerPresenter = new InterstitialPromotionBannerPresenter(DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), this.PlaceComponentResult.get());
        InterstitialPromotionBannerPresenter_MembersInjector.BuiltInFictitiousFunctionClassFactory(interstitialPromotionBannerPresenter, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
        return interstitialPromotionBannerPresenter;
    }
}
