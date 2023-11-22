package id.dana.richview;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import id.dana.richview.DanaProtectionLoadingView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0002*+B'\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'B+\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b&\u0010)J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R:\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010\u0013"}, d2 = {"Lid/dana/richview/DanaProtectionLoadingView;", "Lid/dana/base/BaseRichView;", "", "isSkip", "", "finishLoading", "(Z)V", "", "getLayout", "()I", "hideVisibility", "()V", "Lid/dana/richview/DanaProtectionLoadingView$DanaProtectionLoadingListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLoadingListener", "(Lid/dana/richview/DanaProtectionLoadingView$DanaProtectionLoadingListener;)V", "setup", "startLoading", "MyBillsEntityDataFactory", "Z", "Lkotlin/Function0;", "value", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "getDanaActionFinishListener", "()Lkotlin/jvm/functions/Function0;", "setDanaActionFinishListener", "(Lkotlin/jvm/functions/Function0;)V", "danaActionFinishListener", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/richview/DanaProtectionLoadingView$DanaProtectionLoadingListener;", "PlaceComponentResult", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "DanaProtectionLoadingListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DanaProtectionLoadingView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Function0<Unit> danaActionFinishListener;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private DanaProtectionLoadingListener PlaceComponentResult;
    private boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    private boolean getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/DanaProtectionLoadingView$DanaProtectionLoadingListener;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface DanaProtectionLoadingListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaProtectionLoadingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaProtectionLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_dana_protection_loading;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaProtectionLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ DanaProtectionLoadingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaProtectionLoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getDanaActionFinishListener")
    public final Function0<Unit> getDanaActionFinishListener() {
        return this.danaActionFinishListener;
    }

    @JvmName(name = "setDanaActionFinishListener")
    public final void setDanaActionFinishListener(Function0<Unit> function0) {
        this.danaActionFinishListener = function0;
        if (this.BuiltInFictitiousFunctionClassFactory || !this.MyBillsEntityDataFactory || function0 == null) {
            return;
        }
        function0.invoke();
    }

    public final void startLoading() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0368_daggeremergencynotifcomponent_emergencynotifcomponentimpl);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        LoadingLottieAnimationView loadingLottieAnimationView = (LoadingLottieAnimationView) _$_findCachedViewById(R.id.lavDanaSecureLoading);
        if (loadingLottieAnimationView != null) {
            loadingLottieAnimationView.playAnimation();
        }
    }

    public static /* synthetic */ void finishLoading$default(DanaProtectionLoadingView danaProtectionLoadingView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        danaProtectionLoadingView.finishLoading(z);
    }

    public final void finishLoading(boolean isSkip) {
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.getAuthRequestContext = isSkip;
    }

    public final void hideVisibility() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0368_daggeremergencynotifcomponent_emergencynotifcomponentimpl);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public final void setLoadingListener(DanaProtectionLoadingListener r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        this.PlaceComponentResult = r2;
    }

    /* renamed from: $r8$lambda$-PYMJabINgMHxN1BXKaZ9cIBuhQ */
    public static /* synthetic */ void m2805$r8$lambda$PYMJabINgMHxN1BXKaZ9cIBuhQ(DanaProtectionLoadingView danaProtectionLoadingView) {
        Intrinsics.checkNotNullParameter(danaProtectionLoadingView, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) danaProtectionLoadingView._$_findCachedViewById(R.id.res_0x7f0a0368_daggeremergencynotifcomponent_emergencynotifcomponentimpl);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public static final /* synthetic */ void access$doActionFinish(final DanaProtectionLoadingView danaProtectionLoadingView) {
        Function0<Unit> function0 = danaProtectionLoadingView.danaActionFinishListener;
        if (function0 != null) {
            function0.invoke();
        }
        if (danaProtectionLoadingView.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.richview.DanaProtectionLoadingView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DanaProtectionLoadingView.m2805$r8$lambda$PYMJabINgMHxN1BXKaZ9cIBuhQ(DanaProtectionLoadingView.this);
            }
        }, 250L);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        LoadingLottieAnimationView loadingLottieAnimationView = (LoadingLottieAnimationView) _$_findCachedViewById(R.id.lavDanaSecureLoading);
        if (loadingLottieAnimationView != null) {
            loadingLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.richview.DanaProtectionLoadingView$initDanaProtectionLoading$1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator p0) {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    AppCompatTextView appCompatTextView;
                    Intrinsics.checkNotNullParameter(p0, "");
                    z = DanaProtectionLoadingView.this.BuiltInFictitiousFunctionClassFactory;
                    if (z) {
                        return;
                    }
                    z2 = DanaProtectionLoadingView.this.getAuthRequestContext;
                    if (!z2 && (appCompatTextView = (AppCompatTextView) DanaProtectionLoadingView.this._$_findCachedViewById(R.id.res_0x7f0a14ba_setbalancevisibility_params)) != null) {
                        Context context = DanaProtectionLoadingView.this.getContext();
                        appCompatTextView.setText(context != null ? context.getString(R.string.payment_secured) : null);
                    }
                    LoadingLottieAnimationView loadingLottieAnimationView2 = (LoadingLottieAnimationView) DanaProtectionLoadingView.this._$_findCachedViewById(R.id.lavDanaSecureLoading);
                    if (loadingLottieAnimationView2 != null) {
                        z3 = DanaProtectionLoadingView.this.getAuthRequestContext;
                        if (!z3) {
                            loadingLottieAnimationView2.setMinAndMaxFrame(loadingLottieAnimationView2.getIntroMaxFrame(), loadingLottieAnimationView2.getOutroMaxFrame());
                        }
                        loadingLottieAnimationView2.setRepeatCount(0);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator p0) {
                    DanaProtectionLoadingView.DanaProtectionLoadingListener danaProtectionLoadingListener;
                    Intrinsics.checkNotNullParameter(p0, "");
                    DanaProtectionLoadingView.this.MyBillsEntityDataFactory = true;
                    DanaProtectionLoadingView.access$doActionFinish(DanaProtectionLoadingView.this);
                    danaProtectionLoadingListener = DanaProtectionLoadingView.this.PlaceComponentResult;
                    if (danaProtectionLoadingListener != null) {
                        danaProtectionLoadingListener.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator p0) {
                    DanaProtectionLoadingView.DanaProtectionLoadingListener danaProtectionLoadingListener;
                    Intrinsics.checkNotNullParameter(p0, "");
                    danaProtectionLoadingListener = DanaProtectionLoadingView.this.PlaceComponentResult;
                    if (danaProtectionLoadingListener != null) {
                        danaProtectionLoadingListener.getAuthRequestContext();
                    }
                    AppCompatTextView appCompatTextView = (AppCompatTextView) DanaProtectionLoadingView.this._$_findCachedViewById(R.id.res_0x7f0a14ba_setbalancevisibility_params);
                    if (appCompatTextView != null) {
                        Context context = DanaProtectionLoadingView.this.getContext();
                        appCompatTextView.setText(context != null ? context.getString(R.string.securing_your_transaction) : null);
                    }
                    LoadingLottieAnimationView loadingLottieAnimationView2 = (LoadingLottieAnimationView) DanaProtectionLoadingView.this._$_findCachedViewById(R.id.lavDanaSecureLoading);
                    if (loadingLottieAnimationView2 != null) {
                        loadingLottieAnimationView2.setRepeatCount(-1);
                        LoadingLottieAnimationView loadingLottieAnimationView3 = (LoadingLottieAnimationView) loadingLottieAnimationView2.findViewById(R.id.lavDanaSecureLoading);
                        Intrinsics.checkNotNullExpressionValue(loadingLottieAnimationView3, "");
                        loadingLottieAnimationView2.setupIntroMinMaxFrame(loadingLottieAnimationView3);
                    }
                    DanaProtectionLoadingView.this.MyBillsEntityDataFactory = false;
                }
            });
        }
    }
}
