package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.notification.NotificationActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {DeepLinkModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface NotificationComponent {
    void PlaceComponentResult(NotificationActivity notificationActivity);
}
