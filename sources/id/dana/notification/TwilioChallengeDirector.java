package id.dana.notification;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import id.dana.danah5.twilioverifysecurityproduct.TwilioPushVerifyEvent;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.twilio.identityverification.TwilioIdentityVerificationManager;
import id.dana.util.MinApiUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/notification/TwilioChallengeDirector;", "Lid/dana/notification/NotificationDirector;", "", "MyBillsEntityDataFactory", "()V", "Landroid/app/Activity;", "p0", "PlaceComponentResult", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "Lid/dana/notification/NotificationData;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/notification/NotificationData;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioChallengeDirector extends NotificationDirector {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwilioChallengeDirector(Context context, NotificationData notificationData) {
        super(context, notificationData);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(notificationData, "");
    }

    @Override // id.dana.notification.NotificationDirector
    public final void MyBillsEntityDataFactory() {
        Intent intent = new Intent(this.MyBillsEntityDataFactory, TwilioIdentityVerificationActivity.class);
        intent.setFlags(536870912);
        intent.putExtra(DanaFirebaseMessagingService.MESSAGE_DATA, this.PlaceComponentResult);
        PendingIntent activity = PendingIntent.getActivity(this.MyBillsEntityDataFactory, 0, intent, MinApiUtils.PlaceComponentResult() ? 301989888 : SQLiteDatabase.CREATE_IF_NECESSARY);
        TwilioIdentityVerificationManager twilioIdentityVerificationManager = TwilioIdentityVerificationManager.INSTANCE;
        TwilioIdentityVerificationManager.BuiltInFictitiousFunctionClassFactory = TwilioIdentityVerificationManager.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            EventBus eventBus = EventBus.getDefault();
            String str = this.PlaceComponentResult.GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            eventBus.post(new TwilioPushVerifyEvent(str, str2));
            return;
        }
        Context context = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(context, "");
        NotificationData notificationData = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(notificationData, "");
        Intrinsics.checkNotNullExpressionValue(activity, "");
        NotificationUtils.BuiltInFictitiousFunctionClassFactory(context, notificationData, activity, false, CollectionsKt.emptyList(), null);
    }

    @Override // id.dana.notification.NotificationDirector
    public final void PlaceComponentResult(Activity p0) {
        Intent intent = new Intent(p0, TwilioIdentityVerificationActivity.class);
        intent.putExtra(DanaFirebaseMessagingService.MESSAGE_DATA, this.PlaceComponentResult);
        p0.startActivity(intent);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0006\u001a\u00020\u0002@\u0007X\u0086\n¢\u0006\f\n\u0004\b\u0003\u0010\u0004\"\u0004\b\u0003\u0010\u0005"}, d2 = {"Lid/dana/notification/TwilioChallengeDirector$Companion;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "(Z)V", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
