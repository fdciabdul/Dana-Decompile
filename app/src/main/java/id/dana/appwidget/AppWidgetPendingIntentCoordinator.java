package id.dana.appwidget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import id.dana.statement.StatementActivity;
import id.dana.util.MinApiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/appwidget/AppWidgetPendingIntentCoordinator;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AppWidgetPendingIntentCoordinator {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\f"}, d2 = {"Lid/dana/appwidget/AppWidgetPendingIntentCoordinator$Companion;", "", "", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZZ)I", "Landroid/content/Context;", "", "p2", "Landroid/app/PendingIntent;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/app/PendingIntent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static int KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, boolean p1) {
            if (p0) {
                return 1;
            }
            return p1 ? 2 : 0;
        }

        private Companion() {
        }

        public static PendingIntent KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, StatementActivity.class);
            intent.putExtra("EXTRA_SOURCE", "Native Widget");
            intent.putExtra(StatementActivity.TAB_MENU_SELECTED, p2);
            intent.setAction(p1);
            PendingIntent activity = PendingIntent.getActivity(p0, 0, intent, MinApiUtils.PlaceComponentResult() ? 301989888 : SQLiteDatabase.CREATE_IF_NECESSARY);
            Intrinsics.checkNotNullExpressionValue(activity, "");
            return activity;
        }
    }
}
