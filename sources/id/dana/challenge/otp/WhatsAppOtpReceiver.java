package id.dana.challenge.otp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.richview.socialshare.AppPackageName;
import id.dana.rum.Rum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/challenge/otp/WhatsAppOtpReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WhatsAppOtpReceiver extends BroadcastReceiver {
    public static final String ACTION_RECEIVE_OTP = "android.intent.action.receiveotp";
    public static final String CI = "_ci_";
    public static final String CODE = "code";
    public static final String OTP = "otp";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("WhatsAppOtpReceiver.onReceive");
        PendingIntent pendingIntent = intent != null ? (PendingIntent) intent.getParcelableExtra(CI) : null;
        String creatorPackage = pendingIntent != null ? pendingIntent.getCreatorPackage() : null;
        if (Intrinsics.areEqual("com.whatsapp", creatorPackage) || Intrinsics.areEqual(AppPackageName.WHATSAPP_FOR_BUSINESS, creatorPackage)) {
            String stringExtra = intent.getStringExtra("code");
            if (stringExtra == null) {
                stringExtra = "";
            }
            Intent putExtra = new Intent(ACTION_RECEIVE_OTP).putExtra(OTP, stringExtra);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            if (context != null) {
                context.sendBroadcast(putExtra);
            }
        }
        Rum.Companion companion2 = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("WhatsAppOtpReceiver.onReceive");
    }
}
