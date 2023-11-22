package id.dana.wallet_v3.util;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.core.ui.util.DANAToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\n\u001a\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"", "isBalanceVisible", "Lid/dana/base/BaseActivity;", "baseActivity", "", "walletViewType", "", "showHideBalanceToast", "(ZLid/dana/base/BaseActivity;I)V", "showSuccessHideBalanceToast", "(Lid/dana/base/BaseActivity;I)V", "showSuccessShowBalanceToast", "", "successHideBalanceToastWording", "(Lid/dana/base/BaseActivity;I)Ljava/lang/String;", "successShowBalanceToastWording", "Landroid/content/Context;", HummerConstants.CONTEXT, "vibrateWhenShowHideBalance", "(Landroid/content/Context;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletV3ToastUtilKt {
    public static final void showHideBalanceToast(boolean z, BaseActivity baseActivity, int i) {
        if (z) {
            showSuccessShowBalanceToast(baseActivity, i);
        } else {
            showSuccessHideBalanceToast(baseActivity, i);
        }
    }

    private static final void showSuccessHideBalanceToast(BaseActivity baseActivity, int i) {
        if (baseActivity != null) {
            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
            DANAToast.PlaceComponentResult(baseActivity, successHideBalanceToastWording(baseActivity, i), "");
        }
    }

    private static final String successHideBalanceToastWording(BaseActivity baseActivity, int i) {
        if (i == 5) {
            String string = baseActivity.getString(R.string.success_hide_emas_balance_msg);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        } else if (i == 6) {
            String string2 = baseActivity.getString(R.string.success_hide_goal_balance_msg);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            return string2;
        } else {
            String string3 = baseActivity.getString(R.string.success_hide_dana_balance_msg);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            return string3;
        }
    }

    private static final void showSuccessShowBalanceToast(BaseActivity baseActivity, int i) {
        if (baseActivity != null) {
            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
            DANAToast.PlaceComponentResult(baseActivity, successShowBalanceToastWording(baseActivity, i), "");
        }
    }

    private static final String successShowBalanceToastWording(BaseActivity baseActivity, int i) {
        if (i == 5) {
            String string = baseActivity.getString(R.string.success_show_emas_balance_msg);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        } else if (i == 6) {
            String string2 = baseActivity.getString(R.string.success_show_goal_balance_msg);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            return string2;
        } else {
            String string3 = baseActivity.getString(R.string.success_show_dana_balance_msg);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            return string3;
        }
    }

    public static final void vibrateWhenShowHideBalance(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = context.getSystemService("vibrator_manager");
            VibratorManager vibratorManager = systemService instanceof VibratorManager ? (VibratorManager) systemService : null;
            if (vibratorManager != null) {
                vibratorManager.getDefaultVibrator();
            }
        } else if (Build.VERSION.SDK_INT >= 29) {
            Object systemService2 = context.getSystemService("vibrator");
            Vibrator vibrator = systemService2 instanceof Vibrator ? (Vibrator) systemService2 : null;
            if (vibrator != null) {
                vibrator.cancel();
            }
            if (vibrator != null) {
                vibrator.vibrate(VibrationEffect.createPredefined(0));
            }
        } else if (Build.VERSION.SDK_INT == 26) {
            Object systemService3 = context.getSystemService("vibrator");
            Vibrator vibrator2 = systemService3 instanceof Vibrator ? (Vibrator) systemService3 : null;
            if (vibrator2 != null) {
                vibrator2.cancel();
            }
            if (vibrator2 != null) {
                vibrator2.vibrate(VibrationEffect.createOneShot(250L, -1));
            }
        } else {
            Vibrator vibrator3 = (Vibrator) context.getSystemService("vibrator");
            if (vibrator3 != null) {
                vibrator3.cancel();
            }
            if (vibrator3 != null) {
                vibrator3.vibrate(250L);
            }
        }
    }
}
