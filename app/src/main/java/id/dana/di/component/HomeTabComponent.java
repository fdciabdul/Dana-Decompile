package id.dana.di.component;

import dagger.Component;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.connectivity.ConnectivityMonitorModule;
import id.dana.contract.account.FirstTimeModule;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.contract.homeinfo.HomeRevampModule;
import id.dana.contract.notification.PushNotificationModule;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.promotion.InterstitialPromotionBannerModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.QrisCrossBorderModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {HomeRevampModule.class, FirstTimeModule.class, HomeInfoModule.class, InterstitialPromotionBannerModule.class, DeepLinkModule.class, PushNotificationModule.class, PlayStoreReviewModules.class, CheckoutH5EventModule.class, QrisCrossBorderModule.class, ConnectivityMonitorModule.class, PayLaterModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface HomeTabComponent {
    void PlaceComponentResult(HomeTabFragment homeTabFragment);
}
