package id.dana.notification;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.notification.PushVerifyNotificationUtils;
import id.dana.pushverify.view.verificationdetail.PushVerifyActivity;
import id.dana.util.MinApiUtils;
import id.dana.utils.RandomInteger;
import id.dana.utils.UrlUtil;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u0006*\u00020\u00020\u0002X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u00020\u000fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e"}, d2 = {"Lid/dana/notification/PushVerifyNotificationDirector;", "Lid/dana/notification/NotificationDirector;", "", "p0", "Lid/dana/pushverify/model/PushVerifyParamsModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/pushverify/model/PushVerifyParamsModel;", "", "MyBillsEntityDataFactory", "()V", "Landroid/app/Activity;", "PlaceComponentResult", "(Landroid/app/Activity;)V", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "", "getAuthRequestContext", "Landroid/content/Context;", "Lid/dana/notification/NotificationData;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/notification/NotificationData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushVerifyNotificationDirector extends NotificationDirector {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushVerifyNotificationDirector(Context context, final NotificationData notificationData) {
        super(context, notificationData);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(notificationData, "");
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.notification.PushVerifyNotificationDirector$pendingIntentFlags$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(MinApiUtils.PlaceComponentResult() ? 335544320 : SQLiteDatabase.CREATE_IF_NECESSARY);
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<String>() { // from class: id.dana.notification.PushVerifyNotificationDirector$deeplinkUrl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(NotificationData.this.DatabaseTableConfigUtil);
            }
        });
    }

    @Override // id.dana.notification.NotificationDirector
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.PlaceComponentResult = (String) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        String str = (String) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        Intrinsics.checkNotNullExpressionValue(str, "");
        PushVerifyParamsModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str);
        PushVerifyNotificationUtils pushVerifyNotificationUtils = PushVerifyNotificationUtils.INSTANCE;
        Context context = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(context, "");
        NotificationData notificationData = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(notificationData, "");
        Context context2 = this.MyBillsEntityDataFactory;
        int BuiltInFictitiousFunctionClassFactory = RandomInteger.BuiltInFictitiousFunctionClassFactory();
        PushVerifyActivity.Companion companion = PushVerifyActivity.INSTANCE;
        Context context3 = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(context3, "");
        PendingIntent activity = PendingIntent.getActivity(context2, BuiltInFictitiousFunctionClassFactory, PushVerifyActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context3, KClassImpl$Data$declaredNonStaticMembers$2, "Push Notification"), ((Number) this.MyBillsEntityDataFactory.getValue()).intValue());
        Intrinsics.checkNotNullExpressionValue(activity, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(notificationData, "");
        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
        Intrinsics.checkNotNullParameter(activity, "");
        int BuiltInFictitiousFunctionClassFactory2 = RandomInteger.BuiltInFictitiousFunctionClassFactory();
        NotificationUtils.BuiltInFictitiousFunctionClassFactory(context, notificationData, activity, true, CollectionsKt.listOf((Object[]) new NotificationCompat.Action[]{PushVerifyNotificationUtils.MyBillsEntityDataFactory(context, BuiltInFictitiousFunctionClassFactory2, KClassImpl$Data$declaredNonStaticMembers$2, false), PushVerifyNotificationUtils.MyBillsEntityDataFactory(context, BuiltInFictitiousFunctionClassFactory2, KClassImpl$Data$declaredNonStaticMembers$2, true)}), Integer.valueOf(BuiltInFictitiousFunctionClassFactory2));
    }

    @Override // id.dana.notification.NotificationDirector
    public final void PlaceComponentResult(Activity p0) {
        this.PlaceComponentResult.PlaceComponentResult = (String) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        String str = (String) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        Intrinsics.checkNotNullExpressionValue(str, "");
        PushVerifyParamsModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str);
        PushVerifyActivity.Companion companion = PushVerifyActivity.INSTANCE;
        Context context = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(context, "");
        p0.startActivity(PushVerifyActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2, "Push Notification"));
    }

    private static PushVerifyParamsModel KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Map<String, String> DatabaseTableConfigUtil = UrlUtil.DatabaseTableConfigUtil(p0);
        String str = DatabaseTableConfigUtil.get("token");
        if (str == null) {
            str = "";
        }
        String str2 = DatabaseTableConfigUtil.get(BranchLinkConstant.PushVerifyParams.TRANSACTION_ID);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = DatabaseTableConfigUtil.get("cacheKey");
        return new PushVerifyParamsModel(str, str2, str3 != null ? str3 : "");
    }
}
