package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.NotificationCenterModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.notificationcenter.views.NotificationCenterFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {NotificationCenterModule.class, DeepLinkModule.class, PlayStoreReviewModules.class, CheckoutH5EventModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface NotificationCenterComponent {
    void MyBillsEntityDataFactory(NotificationCenterFragment notificationCenterFragment);
}
