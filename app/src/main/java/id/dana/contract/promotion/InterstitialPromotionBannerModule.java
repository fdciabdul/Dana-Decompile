package id.dana.contract.promotion;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class InterstitialPromotionBannerModule {
    private final InterstitialPromotionBannerContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public InterstitialPromotionBannerContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(InterstitialPromotionBannerPresenter interstitialPromotionBannerPresenter) {
        return interstitialPromotionBannerPresenter;
    }

    public InterstitialPromotionBannerModule(InterstitialPromotionBannerContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public InterstitialPromotionBannerContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
