package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.PushNotificationModule;
import id.dana.notification.DanaFirebaseMessagingService;

@Component(dependencies = {ApplicationComponent.class}, modules = {PushNotificationModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface PushNotificationComponent {
    void MyBillsEntityDataFactory(DanaFirebaseMessagingService danaFirebaseMessagingService);
}
