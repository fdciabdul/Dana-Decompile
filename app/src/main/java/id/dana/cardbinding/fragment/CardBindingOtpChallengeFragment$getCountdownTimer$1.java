package id.dana.cardbinding.fragment;

import android.os.CountDownTimer;
import android.widget.TextView;
import id.dana.R;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cardbinding/fragment/CardBindingOtpChallengeFragment$getCountdownTimer$1;", "Landroid/os/CountDownTimer;", "", "onFinish", "()V", "", "p0", "onTick", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardBindingOtpChallengeFragment$getCountdownTimer$1 extends CountDownTimer {
    final /* synthetic */ CardBindingOtpChallengeFragment KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBindingOtpChallengeFragment$getCountdownTimer$1(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment, long j, long j2) {
        super(j, j2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardBindingOtpChallengeFragment;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long p0) {
        TextView textView = (TextView) this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(R.id.setMinusSignString);
        if (textView != null) {
            String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.card_binding_otp_resend);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(p0))}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
        }
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        CardBindingOtpChallengeFragment.scheduleImpl(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
