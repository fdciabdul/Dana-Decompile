package id.dana.notification;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes2.dex */
public abstract class NotificationDirector {
    protected Context MyBillsEntityDataFactory;
    protected NotificationData PlaceComponentResult;

    public abstract void MyBillsEntityDataFactory();

    public abstract void PlaceComponentResult(Activity activity);

    public NotificationDirector(Context context, NotificationData notificationData) {
        this.MyBillsEntityDataFactory = context;
        this.PlaceComponentResult = notificationData;
    }
}
