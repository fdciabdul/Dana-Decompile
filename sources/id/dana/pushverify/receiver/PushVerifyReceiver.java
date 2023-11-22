package id.dana.pushverify.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.notification.NotificationUtils;
import id.dana.pushverify.worker.PushVerifyWorker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/pushverify/receiver/PushVerifyReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PushVerifyReceiver extends BroadcastReceiver {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final Intent createIntent(Context context, int i, String str, String str2, String str3, boolean z) {
        return Companion.getAuthRequestContext(context, i, str, str2, str3, z);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int intExtra = intent != null ? intent.getIntExtra("KEY_NOTIFICATION_ID", -1) : -1;
        String stringExtra = intent != null ? intent.getStringExtra("TRANSACTION_ID") : null;
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = intent != null ? intent.getStringExtra("CACHE_LEY") : null;
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String stringExtra3 = intent != null ? intent.getStringExtra("TOKEN") : null;
        String str = stringExtra3 != null ? stringExtra3 : "";
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("APPROVE_VERIFY", false) : false;
        if (context != null) {
            if (stringExtra.length() > 0) {
                if (stringExtra2.length() > 0) {
                    if (str.length() > 0) {
                        PushVerifyWorker.Companion companion = PushVerifyWorker.INSTANCE;
                        PushVerifyWorker.Companion.MyBillsEntityDataFactory(context, stringExtra, stringExtra2, str, booleanExtra);
                        if (intExtra != -1) {
                            NotificationUtils.KClassImpl$Data$declaredNonStaticMembers$2(context, intExtra);
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/pushverify/receiver/PushVerifyReceiver$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "p3", "p4", "", "p5", "Landroid/content/Intent;", "getAuthRequestContext", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent getAuthRequestContext(Context p0, int p1, String p2, String p3, String p4, boolean p5) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intent intent = new Intent(p0, PushVerifyReceiver.class);
            intent.putExtra("KEY_NOTIFICATION_ID", p1);
            intent.putExtra("TRANSACTION_ID", p2);
            intent.putExtra("CACHE_LEY", p3);
            intent.putExtra("TOKEN", p4);
            intent.putExtra("APPROVE_VERIFY", p5);
            return intent;
        }
    }
}
