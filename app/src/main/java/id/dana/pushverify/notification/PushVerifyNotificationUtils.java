package id.dana.pushverify.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.app.NotificationCompat;
import id.dana.R;
import id.dana.core.ui.util.OSUtil;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.receiver.PushVerifyReceiver;
import id.dana.util.MinApiUtils;
import id.dana.utils.RandomInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u000f\u001a\u00020\u0004X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/pushverify/notification/PushVerifyNotificationUtils;", "", "Landroid/content/Context;", "p0", "", "p1", "Lid/dana/pushverify/model/PushVerifyParamsModel;", "p2", "", "p3", "Landroidx/core/app/NotificationCompat$Action;", "MyBillsEntityDataFactory", "(Landroid/content/Context;ILid/dana/pushverify/model/PushVerifyParamsModel;Z)Landroidx/core/app/NotificationCompat$Action;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PushVerifyNotificationUtils {
    public static final PushVerifyNotificationUtils INSTANCE = new PushVerifyNotificationUtils();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.pushverify.notification.PushVerifyNotificationUtils$pendingIntentFlags$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(MinApiUtils.PlaceComponentResult() ? 335544320 : SQLiteDatabase.CREATE_IF_NECESSARY);
        }
    });

    private PushVerifyNotificationUtils() {
    }

    public static NotificationCompat.Action MyBillsEntityDataFactory(Context p0, int p1, PushVerifyParamsModel p2, boolean p3) {
        SpannableString spannableString;
        if (p3) {
            String string = p0.getString(R.string.pushverify_approve_verification_notif);
            Intrinsics.checkNotNullExpressionValue(string, "");
            spannableString = string;
        } else {
            SpannableString spannableString2 = new SpannableString(p0.getString(R.string.pushverify_reject_verification_notif));
            OSUtil oSUtil = OSUtil.INSTANCE;
            if (OSUtil.getErrorConfigVersion()) {
                spannableString2.setSpan(new ForegroundColorSpan(p0.getColor(R.color.f26712131100373)), 0, spannableString2.length(), 0);
            }
            spannableString = spannableString2;
        }
        int BuiltInFictitiousFunctionClassFactory2 = RandomInteger.BuiltInFictitiousFunctionClassFactory();
        PushVerifyReceiver.Companion companion = PushVerifyReceiver.INSTANCE;
        NotificationCompat.Action PlaceComponentResult = new NotificationCompat.Action.Builder(R.drawable.ic_dana, spannableString, PendingIntent.getBroadcast(p0, BuiltInFictitiousFunctionClassFactory2, PushVerifyReceiver.Companion.getAuthRequestContext(p0, p1, p2.getAuthRequestContext, p2.BuiltInFictitiousFunctionClassFactory, p2.MyBillsEntityDataFactory, p3), ((Number) BuiltInFictitiousFunctionClassFactory.getValue()).intValue())).PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }
}
