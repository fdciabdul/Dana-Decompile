package id.dana.notification.decorator;

import android.app.PendingIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/notification/decorator/NotificationContentDecorator;", "Lid/dana/notification/decorator/NotificationDecorator;", "p0", "", "p1", "p2", "Landroid/app/PendingIntent;", "p3", "<init>", "(Lid/dana/notification/decorator/NotificationDecorator;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class NotificationContentDecorator extends NotificationDecorator {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationContentDecorator(NotificationDecorator notificationDecorator, String str, String str2) {
        super(notificationDecorator);
        Intrinsics.checkNotNullParameter(notificationDecorator, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        String str3 = str;
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(str3).getAuthRequestContext(str3).MyBillsEntityDataFactory(str2).KClassImpl$Data$declaredNonStaticMembers$2((PendingIntent) null);
    }
}
