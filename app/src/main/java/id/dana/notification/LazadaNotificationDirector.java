package id.dana.notification;

import android.app.Activity;
import android.content.Context;
import id.dana.lazada.LazadaGuideActivity;

/* loaded from: classes5.dex */
public class LazadaNotificationDirector extends NotificationDirector {
    public LazadaNotificationDirector(Context context, NotificationData notificationData) {
        super(context, notificationData);
    }

    @Override // id.dana.notification.NotificationDirector
    public final void MyBillsEntityDataFactory() {
        NotificationUtils.getAuthRequestContext(this.MyBillsEntityDataFactory, this.PlaceComponentResult, LazadaGuideActivity.createPendingIntent(this.MyBillsEntityDataFactory));
    }

    @Override // id.dana.notification.NotificationDirector
    public final void PlaceComponentResult(Activity activity) {
        activity.startActivity(LazadaGuideActivity.createIntent(activity));
    }
}
