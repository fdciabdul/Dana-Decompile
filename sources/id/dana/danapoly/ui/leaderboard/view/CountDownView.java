package id.dana.danapoly.ui.leaderboard.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ViewCountdownBinding;
import id.dana.data.util.DateTimeUtil;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB/\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/view/CountDownView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewCountdownBinding;", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewCountdownBinding;", "", "eventExpiryDate", "", "setCountdown", "(Ljava/lang/Long;)V", "Landroid/os/CountDownTimer;", "MyBillsEntityDataFactory", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "timer", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CountDownView extends BaseViewBindingRichView<ViewCountdownBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private CountDownTimer timer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ CountDownView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @JvmName(name = "getTimer")
    public final CountDownTimer getTimer() {
        return this.timer;
    }

    @JvmName(name = "setTimer")
    public final void setTimer(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCountdownBinding inflateViewBinding() {
        ViewCountdownBinding authRequestContext = ViewCountdownBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public static /* synthetic */ void setCountdown$default(CountDownView countDownView, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        countDownView.setCountdown(l);
    }

    public final void setCountdown(Long eventExpiryDate) {
        Unit unit;
        if (eventExpiryDate != null) {
            long longValue = eventExpiryDate.longValue();
            long currentTimeMillis = DateTimeUtil.getCurrentTimeMillis();
            if (DateTimeUtil.getDifferenceInHours(longValue, currentTimeMillis) > 24) {
                int differenceInDays = (int) DateTimeUtil.INSTANCE.getDifferenceInDays(new Date(longValue), new Date(System.currentTimeMillis()));
                getBinding().PlaceComponentResult.setText(getResources().getQuantityString(R.plurals.res_0x7f110002_kclassimpl_data_declarednonstaticmembers_2, differenceInDays, Integer.valueOf(differenceInDays)));
            } else {
                final long j = longValue - currentTimeMillis;
                if (this.timer == null) {
                    CountDownTimer countDownTimer = new CountDownTimer(j) { // from class: id.dana.danapoly.ui.leaderboard.view.CountDownView$setupCountDownTimer$1
                        @Override // android.os.CountDownTimer
                        public final void onTick(long p0) {
                            CountDownView.access$setInHourFormat(this, p0);
                        }

                        @Override // android.os.CountDownTimer
                        public final void onFinish() {
                            CountDownView.access$hideCountdown(this);
                        }
                    };
                    this.timer = countDownTimer;
                    countDownTimer.start();
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.timer = null;
            ConstraintLayout constraintLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(8);
        }
    }

    public static final /* synthetic */ void access$hideCountdown(CountDownView countDownView) {
        countDownView.timer = null;
        ConstraintLayout constraintLayout = countDownView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
    }

    public static final /* synthetic */ void access$setInHourFormat(CountDownView countDownView, long j) {
        AppCompatTextView appCompatTextView = countDownView.getBinding().PlaceComponentResult;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d : %02d : %02d", Arrays.copyOf(new Object[]{Long.valueOf((j / 3600000) % 24), Long.valueOf((j / 60000) % 60), Long.valueOf((j / 1000) % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "");
        appCompatTextView.setText(format);
    }
}
