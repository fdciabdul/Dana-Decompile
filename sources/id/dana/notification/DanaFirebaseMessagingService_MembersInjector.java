package id.dana.notification;

import dagger.MembersInjector;
import id.dana.contract.notification.PushNotificationPresenter;
import id.dana.twilio.tracker.TwilioMixpanelTracker;

/* loaded from: classes9.dex */
public final class DanaFirebaseMessagingService_MembersInjector implements MembersInjector<DanaFirebaseMessagingService> {
    public static void BuiltInFictitiousFunctionClassFactory(DanaFirebaseMessagingService danaFirebaseMessagingService, PushNotificationPresenter pushNotificationPresenter) {
        danaFirebaseMessagingService.pushNotificationPresenter = pushNotificationPresenter;
    }

    public static void MyBillsEntityDataFactory(DanaFirebaseMessagingService danaFirebaseMessagingService, NotificationDirectorFactory notificationDirectorFactory) {
        danaFirebaseMessagingService.notificationDirectorFactory = notificationDirectorFactory;
    }

    public static void MyBillsEntityDataFactory(DanaFirebaseMessagingService danaFirebaseMessagingService, TwilioMixpanelTracker twilioMixpanelTracker) {
        danaFirebaseMessagingService.twilioMixpanelTracker = twilioMixpanelTracker;
    }
}
