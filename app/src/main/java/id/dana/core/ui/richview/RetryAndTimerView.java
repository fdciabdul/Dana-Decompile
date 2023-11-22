package id.dana.core.ui.richview;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.databinding.ViewRetryAndTimerBinding;
import id.dana.core.ui.richview.RetryAndTimerView;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B/\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\n\u0012\b\b\u0002\u0010<\u001a\u00020\n¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\tJ\u001b\u0010\u0016\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u0015\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\rJ\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\rJ\u0015\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010\rJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010-R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u00100R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00103\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104"}, d2 = {"Lid/dana/core/ui/richview/RetryAndTimerView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/core/ui/databinding/ViewRetryAndTimerBinding;", "inflateViewBinding", "()Lid/dana/core/ui/databinding/ViewRetryAndTimerBinding;", "", "enable", "", "setEnable", "(Z)V", "", "fallback", "setFallbackText", "(I)V", "", "(Ljava/lang/String;)V", "hasFallback", "setHasFallback", GriverMonitorConstants.KEY_IS_LOADING, "setLoadingView", "Lkotlin/Function0;", "onFallbackClick", "setOnFallbackClick", "(Lkotlin/jvm/functions/Function0;)V", "onTryAgainClick", "setOnTryAgainClick", "remainingAttempts", "setRemainingAttempts", "resend", "setResendText", "timeUntilNextAttempt", "setTimeUntilNextAttempt", "setup", "()V", "Lid/dana/core/ui/richview/RetryAndTimerView$ButtonState;", "buttonState", "setupButton", "(Lid/dana/core/ui/richview/RetryAndTimerView$ButtonState;)V", "Landroid/os/CountDownTimer;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/CountDownTimer;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Z", "", "Ljava/lang/CharSequence;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "lookAheadTest", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "moveToNextValue", "scheduleImpl", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ButtonState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RetryAndTimerView extends BaseViewBindingRichView<ViewRetryAndTimerBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private CountDownTimer PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function0<Unit> getAuthRequestContext;
    private boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function0<Unit> getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int scheduleImpl;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/core/ui/richview/RetryAndTimerView$ButtonState;", "", "<init>", "(Ljava/lang/String;I)V", "COUNTDOWN_TIMER", "TRY_AGAIN", "FALLBACK"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum ButtonState {
        COUNTDOWN_TIMER,
        TRY_AGAIN,
        FALLBACK
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ButtonState.values().length];
            iArr[ButtonState.COUNTDOWN_TIMER.ordinal()] = 1;
            iArr[ButtonState.TRY_AGAIN.ordinal()] = 2;
            iArr[ButtonState.FALLBACK.ordinal()] = 3;
            MyBillsEntityDataFactory = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RetryAndTimerView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RetryAndTimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RetryAndTimerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryAndTimerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scheduleImpl = 1000;
        this.getErrorConfigVersion = new Function0<Unit>() { // from class: id.dana.core.ui.richview.RetryAndTimerView$onTryAgainClick$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.getAuthRequestContext = new Function0<Unit>() { // from class: id.dana.core.ui.richview.RetryAndTimerView$onFallbackClick$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.MyBillsEntityDataFactory = true;
    }

    public /* synthetic */ RetryAndTimerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewRetryAndTimerBinding inflateViewBinding() {
        ViewRetryAndTimerBinding BuiltInFictitiousFunctionClassFactory = ViewRetryAndTimerBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        super.setup();
    }

    public final void setEnable(boolean enable) {
        this.MyBillsEntityDataFactory = enable;
        if (enable) {
            setLoadingView(false);
            getBinding().BuiltInFictitiousFunctionClassFactory.setEnabled(true);
            TextView textView = getBinding().getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
            LottieAnimationView lottieAnimationView = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
            lottieAnimationView.setVisibility(8);
            lottieAnimationView.pauseAnimation();
            return;
        }
        setLoadingView(false);
        getBinding().BuiltInFictitiousFunctionClassFactory.setEnabled(false);
        TextView textView2 = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(0);
        LottieAnimationView lottieAnimationView2 = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "");
        lottieAnimationView2.setVisibility(0);
        lottieAnimationView2.resumeAnimation();
    }

    public final void setFallbackText(int fallback) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getContext().getText(fallback);
    }

    public final void setFallbackText(String fallback) {
        Intrinsics.checkNotNullParameter(fallback, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fallback;
    }

    public final void setResendText(int resend) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getContext().getText(resend);
    }

    public final void setHasFallback(boolean hasFallback) {
        this.BuiltInFictitiousFunctionClassFactory = hasFallback;
    }

    public final void setOnTryAgainClick(Function0<Unit> onTryAgainClick) {
        Intrinsics.checkNotNullParameter(onTryAgainClick, "");
        this.getErrorConfigVersion = onTryAgainClick;
    }

    public final void setOnFallbackClick(Function0<Unit> onFallbackClick) {
        Intrinsics.checkNotNullParameter(onFallbackClick, "");
        this.getAuthRequestContext = onFallbackClick;
    }

    public final void setTimeUntilNextAttempt(int timeUntilNextAttempt) {
        this.scheduleImpl = timeUntilNextAttempt;
    }

    public final void setRemainingAttempts(int remainingAttempts) {
        this.lookAheadTest = remainingAttempts;
    }

    public final void setLoadingView(boolean r6) {
        LinearLayout linearLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(r6 ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(r6 ? 0 : 8);
        LottieAnimationView lottieAnimationView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(r6 ? 0 : 8);
        if (r6) {
            lottieAnimationView.resumeAnimation();
        } else {
            lottieAnimationView.pauseAnimation();
        }
    }

    public final void setupButton(ButtonState buttonState) {
        Intrinsics.checkNotNullParameter(buttonState, "");
        int i = WhenMappings.MyBillsEntityDataFactory[buttonState.ordinal()];
        if (i != 1) {
            if (i == 2) {
                getBinding().BuiltInFictitiousFunctionClassFactory.setText(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.richview.RetryAndTimerView$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RetryAndTimerView.m620$r8$lambda$vxSBLkJNFUwhXLG48ksaqbxm0A(RetryAndTimerView.this, view);
                    }
                });
                setEnable(true);
                return;
            } else if (i == 3) {
                getBinding().BuiltInFictitiousFunctionClassFactory.setText(this.KClassImpl$Data$declaredNonStaticMembers$2);
                getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.richview.RetryAndTimerView$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RetryAndTimerView.$r8$lambda$bE0eX3JTq4n5xUT6s_kMzaWV_lI(RetryAndTimerView.this, view);
                    }
                });
                setEnable(true);
                return;
            } else {
                return;
            }
        }
        setEnable(false);
        double d = this.scheduleImpl;
        Double.isNaN(d);
        this.scheduleImpl = (int) Math.ceil(d / 1000.0d);
        CountDownTimer countDownTimer = this.PlaceComponentResult;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (this.PlaceComponentResult == null) {
            final long millis = TimeUnit.SECONDS.toMillis(this.scheduleImpl);
            final long millis2 = TimeUnit.SECONDS.toMillis(1L);
            this.PlaceComponentResult = new CountDownTimer(millis, millis2) { // from class: id.dana.core.ui.richview.RetryAndTimerView$setupButton$1
                @Override // android.os.CountDownTimer
                public final void onTick(long p0) {
                    int i2;
                    ViewRetryAndTimerBinding binding;
                    CharSequence charSequence;
                    ViewRetryAndTimerBinding binding2;
                    i2 = RetryAndTimerView.this.scheduleImpl;
                    long j = i2 - p0;
                    long abs = Math.abs(TimeUnit.MILLISECONDS.toMinutes(j) % 60);
                    long abs2 = Math.abs(TimeUnit.MILLISECONDS.toSeconds(j) % 60);
                    binding = RetryAndTimerView.this.getBinding();
                    Button button = binding.BuiltInFictitiousFunctionClassFactory;
                    charSequence = RetryAndTimerView.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    button.setText(charSequence);
                    binding2 = RetryAndTimerView.this.getBinding();
                    TextView textView = binding2.getErrorConfigVersion;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(abs), Long.valueOf(abs2)}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    textView.setText(format);
                }

                @Override // android.os.CountDownTimer
                public final void onFinish() {
                    int i2;
                    boolean z;
                    RetryAndTimerView.this.scheduleImpl = 0;
                    i2 = RetryAndTimerView.this.lookAheadTest;
                    if (i2 <= 0) {
                        z = RetryAndTimerView.this.BuiltInFictitiousFunctionClassFactory;
                        if (z) {
                            RetryAndTimerView.this.setupButton(RetryAndTimerView.ButtonState.FALLBACK);
                            return;
                        }
                    }
                    RetryAndTimerView.this.setupButton(RetryAndTimerView.ButtonState.TRY_AGAIN);
                }
            };
        }
        CountDownTimer countDownTimer2 = this.PlaceComponentResult;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
    }

    public static /* synthetic */ void $r8$lambda$bE0eX3JTq4n5xUT6s_kMzaWV_lI(RetryAndTimerView retryAndTimerView, View view) {
        Intrinsics.checkNotNullParameter(retryAndTimerView, "");
        retryAndTimerView.getAuthRequestContext.invoke();
    }

    /* renamed from: $r8$lambda$vxSBLkJ-NFUwhXLG48ksaqbxm0A */
    public static /* synthetic */ void m620$r8$lambda$vxSBLkJNFUwhXLG48ksaqbxm0A(RetryAndTimerView retryAndTimerView, View view) {
        Intrinsics.checkNotNullParameter(retryAndTimerView, "");
        retryAndTimerView.getErrorConfigVersion.invoke();
    }
}
