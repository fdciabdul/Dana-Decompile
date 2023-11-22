package id.dana.notification;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/notification/PersistentNotificationDirector;", "Lid/dana/notification/NotificationDirector;", "", "MyBillsEntityDataFactory", "()V", "Landroid/app/Activity;", "p0", "PlaceComponentResult", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "Lid/dana/notification/NotificationData;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/notification/NotificationData;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentNotificationDirector extends NotificationDirector {
    @Override // id.dana.notification.NotificationDirector
    public final void PlaceComponentResult(Activity p0) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentNotificationDirector(Context context, NotificationData notificationData) {
        super(context, notificationData);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(notificationData, "");
    }

    @Override // id.dana.notification.NotificationDirector
    public final void MyBillsEntityDataFactory() {
        Context context = this.MyBillsEntityDataFactory;
        NotificationData notificationData = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(notificationData, "");
        NotificationUtils.getAuthRequestContext(context, notificationData);
    }
}
