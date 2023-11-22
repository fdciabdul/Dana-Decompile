package id.dana.notification;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import id.dana.util.MinApiUtils;
import id.dana.utils.RandomInteger;
import id.dana.utils.UrlUtil;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/notification/DeeplinkNotificationDirector;", "Lid/dana/notification/NotificationDirector;", "", "MyBillsEntityDataFactory", "()V", "Landroid/app/Activity;", "p0", "PlaceComponentResult", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "Lid/dana/notification/NotificationData;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/notification/NotificationData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeeplinkNotificationDirector extends NotificationDirector {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeeplinkNotificationDirector(Context context, NotificationData notificationData) {
        super(context, notificationData);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(notificationData, "");
    }

    @Override // id.dana.notification.NotificationDirector
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.PlaceComponentResult = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.DatabaseTableConfigUtil);
        Intent intent = new Intent(this.MyBillsEntityDataFactory, NotificationActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(DanaFirebaseMessagingService.MESSAGE_DATA, this.PlaceComponentResult);
        PendingIntent activity = PendingIntent.getActivity(this.MyBillsEntityDataFactory, RandomInteger.BuiltInFictitiousFunctionClassFactory(), intent, MinApiUtils.PlaceComponentResult() ? 335544320 : SQLiteDatabase.CREATE_IF_NECESSARY);
        Context context = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(context, "");
        NotificationData notificationData = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(notificationData, "");
        Intrinsics.checkNotNullExpressionValue(activity, "");
        NotificationUtils.BuiltInFictitiousFunctionClassFactory(context, notificationData, activity, false, CollectionsKt.emptyList(), null);
    }

    @Override // id.dana.notification.NotificationDirector
    public final void PlaceComponentResult(Activity p0) {
        this.PlaceComponentResult.PlaceComponentResult = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.DatabaseTableConfigUtil);
        Intent intent = new Intent(p0, NotificationActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(DanaFirebaseMessagingService.MESSAGE_DATA, this.PlaceComponentResult);
        p0.startActivity(intent);
    }
}
