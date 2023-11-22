package id.dana.notification.decorator;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/notification/decorator/NotificationDecorator;", "", "Landroidx/core/app/NotificationCompat$Builder;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/core/app/NotificationCompat$Builder;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "<init>", "(Landroid/content/Context;Ljava/lang/String;Z)V", "(Lid/dana/notification/decorator/NotificationDecorator;)V", "(Landroidx/core/app/NotificationCompat$Builder;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public class NotificationDecorator {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final NotificationCompat.Builder BuiltInFictitiousFunctionClassFactory;

    private NotificationDecorator(NotificationCompat.Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = builder;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NotificationDecorator(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder
            r1.<init>(r3, r4)
            r3 = 0
            androidx.core.app.NotificationCompat$Builder r3 = r1.BuiltInFictitiousFunctionClassFactory(r3)
            androidx.core.app.NotificationCompat$Builder r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.notification.decorator.NotificationDecorator.<init>(android.content.Context, java.lang.String, boolean):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NotificationDecorator(NotificationDecorator notificationDecorator) {
        this(notificationDecorator.BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullParameter(notificationDecorator, "");
    }
}
