package id.dana.notification;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import id.dana.util.MinApiUtils;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes5.dex */
public class SpinTheWheelNotificationDirector extends NotificationDirector {
    public SpinTheWheelNotificationDirector(Context context, NotificationData notificationData) {
        super(context, notificationData);
    }

    @Override // id.dana.notification.NotificationDirector
    public final void MyBillsEntityDataFactory() {
        NotificationData notificationData = this.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(this.PlaceComponentResult.DatabaseTableConfigUtil);
        notificationData.PlaceComponentResult = sb.toString();
        Intent intent = new Intent(this.MyBillsEntityDataFactory, NotificationActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(DanaFirebaseMessagingService.MESSAGE_DATA, this.PlaceComponentResult);
        NotificationUtils.getAuthRequestContext(this.MyBillsEntityDataFactory, this.PlaceComponentResult, PendingIntent.getActivity(this.MyBillsEntityDataFactory, 0, intent, MinApiUtils.PlaceComponentResult() ? 301989888 : SQLiteDatabase.CREATE_IF_NECESSARY));
    }

    @Override // id.dana.notification.NotificationDirector
    public final void PlaceComponentResult(Activity activity) {
        Intent intent = new Intent(activity, NotificationActivity.class);
        NotificationData notificationData = this.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(this.PlaceComponentResult.DatabaseTableConfigUtil);
        notificationData.PlaceComponentResult = sb.toString();
        intent.putExtra(DanaFirebaseMessagingService.MESSAGE_DATA, this.PlaceComponentResult);
        activity.startActivity(intent);
    }
}
