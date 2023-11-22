package id.dana.pushverify.utlis;

import android.content.Context;
import android.os.CountDownTimer;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¨\u0006\u000e"}, d2 = {"Lid/dana/pushverify/utlis/VerificationExpiryUtil;", "", "()V", "startCountDownTimer", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "secondsUntilExpired", "", "onCountDown", "Lkotlin/Function1;", "", "onComplete", "Lkotlin/Function0;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationExpiryUtil {
    public static final VerificationExpiryUtil getAuthRequestContext = new VerificationExpiryUtil();

    private VerificationExpiryUtil() {
    }

    public static void MyBillsEntityDataFactory(final Context context, int i, final Function1<? super String, Unit> function1, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function0, "");
        final long millis = TimeUnit.SECONDS.toMillis(i);
        final long millis2 = TimeUnit.SECONDS.toMillis(1L);
        new CountDownTimer(millis, millis2) { // from class: id.dana.pushverify.utlis.VerificationExpiryUtil$startCountDownTimer$countDownTimer$1
            @Override // android.os.CountDownTimer
            public final void onTick(long p0) {
                String obj;
                long j = p0 / 1000;
                long j2 = j / 60;
                long j3 = j % 60;
                if (j2 < 10 && j3 < 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('0');
                    sb.append(j2);
                    sb.append(":0");
                    sb.append(j3);
                    obj = sb.toString();
                } else if (j2 < 10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('0');
                    sb2.append(j2);
                    sb2.append(':');
                    sb2.append(j3);
                    obj = sb2.toString();
                } else if (j3 < 10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(j2);
                    sb3.append(":0");
                    sb3.append(j3);
                    obj = sb3.toString();
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(j2);
                    sb4.append(':');
                    sb4.append(j3);
                    obj = sb4.toString();
                }
                String string = context.getString(R.string.pushverify_expire_in, obj);
                Intrinsics.checkNotNullExpressionValue(string, "");
                function1.invoke(string);
            }

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                function0.invoke();
            }
        }.start();
    }
}
