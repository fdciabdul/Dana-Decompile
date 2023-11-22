package id.dana.riskChallenges.ui.missedCallOtp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.rum.Rum;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/PhoneStateReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PhoneStateReceiver extends BroadcastReceiver {
    public static final String ACTION_LAST_FOUR_DIGIT = "android.intent.action.last_four_digit";
    public static final String ACTION_VERIFY = "android.intent.action.verify";
    public static final String LAST_FOUR_DIGIT = "last_four_digit";
    public static final String VERIFY = "verify";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("PhoneStateReceiver.onReceive");
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.intent.action.PHONE_STATE")) {
            try {
                String stringExtra = intent.getStringExtra("state");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                String stringExtra2 = intent.getStringExtra("incoming_number");
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                if (Intrinsics.areEqual(stringExtra, TelephonyManager.EXTRA_STATE_RINGING)) {
                    if ((stringExtra2.length() > 0) && !Intrinsics.areEqual(stringExtra2, "null")) {
                        String substring = stringExtra2.substring(stringExtra2.length() - 4);
                        Intrinsics.checkNotNullExpressionValue(substring, "");
                        Intent putExtra = new Intent(ACTION_LAST_FOUR_DIGIT).putExtra(LAST_FOUR_DIGIT, substring);
                        Intrinsics.checkNotNullExpressionValue(putExtra, "");
                        if (context != null) {
                            context.sendBroadcast(putExtra, "android.permission.READ_PHONE_STATE");
                        }
                    }
                }
                if (Intrinsics.areEqual(stringExtra, TelephonyManager.EXTRA_STATE_IDLE)) {
                    if (stringExtra2.length() > 0) {
                        Intent putExtra2 = new Intent(ACTION_VERIFY).putExtra(VERIFY, true);
                        Intrinsics.checkNotNullExpressionValue(putExtra2, "");
                        if (context != null) {
                            context.sendBroadcast(putExtra2, "android.permission.READ_PHONE_STATE");
                        }
                    }
                }
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PHONE_STATE_RECEIVER, e.getMessage());
            }
        }
        Rum.Companion companion2 = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("PhoneStateReceiver.onReceive");
    }
}
