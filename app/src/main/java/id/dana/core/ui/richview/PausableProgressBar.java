package id.dana.core.ui.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.R;
import id.dana.core.ui.richview.PausableProgressBar;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0003+*,B%\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004R\u001c\u0010\u001a\u001a\b\u0018\u00010\u0018R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010!"}, d2 = {"Lid/dana/core/ui/richview/PausableProgressBar;", "Landroid/widget/FrameLayout;", "", "clear", "()V", "", "p0", "PlaceComponentResult", "(Z)V", "pauseProgress", "resumeProgress", "Lid/dana/core/ui/richview/PausableProgressBar$Callback;", "callback", "setCallback", "(Lid/dana/core/ui/richview/PausableProgressBar$Callback;)V", "", "duration", "setDuration", "(J)V", "setMax", "setMaxWithoutCallback", "setMin", "setMinWithoutCallback", "startProgress", "Lid/dana/core/ui/richview/PausableProgressBar$PausableScaleAnimation;", "Lid/dana/core/ui/richview/PausableProgressBar$PausableScaleAnimation;", "getAuthRequestContext", "Lid/dana/core/ui/richview/PausableProgressBar$Callback;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View;", "MyBillsEntityDataFactory", "J", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "Callback", "PausableScaleAnimation"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PausableProgressBar extends FrameLayout {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private long MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private View PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private View KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private PausableScaleAnimation getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Callback BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/richview/PausableProgressBar$Callback;", "", "", "PlaceComponentResult", "()V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Callback {
        void MyBillsEntityDataFactory();

        void PlaceComponentResult();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PausableProgressBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PausableProgressBar(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausableProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = 2000L;
        LayoutInflater.from(context).inflate(R.layout.pausable_progress, this);
        View findViewById = findViewById(R.id.front_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.PlaceComponentResult = findViewById;
        View findViewById2 = findViewById(R.id.res_0x7f0a0e66_verifypinstatemanager_executeriskchallenge_2_1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = findViewById2;
    }

    public /* synthetic */ PausableProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setDuration(long duration) {
        this.MyBillsEntityDataFactory = duration;
    }

    public final void setCallback(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "");
        this.BuiltInFictitiousFunctionClassFactory = callback;
    }

    private final void PlaceComponentResult(boolean p0) {
        if (p0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundResource(R.color.initRecordTimeStamp);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(p0 ? 0 : 8);
        this.PlaceComponentResult.setVisibility(p0 ? 0 : 8);
        PausableScaleAnimation pausableScaleAnimation = this.getAuthRequestContext;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            pausableScaleAnimation.cancel();
            Callback callback = this.BuiltInFictitiousFunctionClassFactory;
            if (callback != null) {
                callback.PlaceComponentResult();
            }
        }
    }

    public final void setMax() {
        PlaceComponentResult(true);
    }

    public final void setMin() {
        PlaceComponentResult(false);
    }

    public final void setMinWithoutCallback() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundResource(R.drawable.res_0x7f080578_networkuserentitydata_externalsyntheticlambda0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        PausableScaleAnimation pausableScaleAnimation = this.getAuthRequestContext;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            pausableScaleAnimation.cancel();
        }
    }

    public final void setMaxWithoutCallback() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundResource(R.drawable.rounded_white_border);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        PausableScaleAnimation pausableScaleAnimation = this.getAuthRequestContext;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            pausableScaleAnimation.cancel();
        }
    }

    public final void startProgress() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        PausableScaleAnimation pausableScaleAnimation = new PausableScaleAnimation();
        pausableScaleAnimation.setDuration(this.MyBillsEntityDataFactory);
        pausableScaleAnimation.setInterpolator(new LinearInterpolator());
        pausableScaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: id.dana.core.ui.richview.PausableProgressBar$startProgress$1$1
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation p0) {
                View view;
                PausableProgressBar.Callback callback;
                Intrinsics.checkNotNullParameter(p0, "");
                view = PausableProgressBar.this.PlaceComponentResult;
                view.setVisibility(0);
                callback = PausableProgressBar.this.BuiltInFictitiousFunctionClassFactory;
                if (callback != null) {
                    callback.MyBillsEntityDataFactory();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation p0) {
                PausableProgressBar.Callback callback;
                Intrinsics.checkNotNullParameter(p0, "");
                callback = PausableProgressBar.this.BuiltInFictitiousFunctionClassFactory;
                if (callback != null) {
                    callback.PlaceComponentResult();
                }
            }
        });
        pausableScaleAnimation.setFillAfter(true);
        this.PlaceComponentResult.startAnimation(pausableScaleAnimation);
        this.getAuthRequestContext = pausableScaleAnimation;
    }

    public final void pauseProgress() {
        PausableScaleAnimation pausableScaleAnimation = this.getAuthRequestContext;
        if (pausableScaleAnimation == null || pausableScaleAnimation.MyBillsEntityDataFactory) {
            return;
        }
        pausableScaleAnimation.PlaceComponentResult = 0L;
        pausableScaleAnimation.MyBillsEntityDataFactory = true;
    }

    public final void resumeProgress() {
        PausableScaleAnimation pausableScaleAnimation = this.getAuthRequestContext;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.MyBillsEntityDataFactory = false;
        }
    }

    public final void clear() {
        PausableScaleAnimation pausableScaleAnimation = this.getAuthRequestContext;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            pausableScaleAnimation.cancel();
            this.getAuthRequestContext = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/core/ui/richview/PausableProgressBar$PausableScaleAnimation;", "Landroid/view/animation/ScaleAnimation;", "", "p0", "Landroid/view/animation/Transformation;", "p1", "", "p2", "", "getTransformation", "(JLandroid/view/animation/Transformation;F)Z", "getAuthRequestContext", "J", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "MyBillsEntityDataFactory", "p3", "", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/core/ui/richview/PausableProgressBar;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final class PausableScaleAnimation extends ScaleAnimation {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        boolean MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        long PlaceComponentResult;

        public PausableScaleAnimation() {
            super(0.0f, 1.0f, 1.0f, 1.0f, 0, 0.0f, 1, 0.0f);
        }

        @Override // android.view.animation.Animation
        public final boolean getTransformation(long p0, Transformation p1, float p2) {
            Intrinsics.checkNotNullParameter(p1, "");
            if (this.MyBillsEntityDataFactory && this.PlaceComponentResult == 0) {
                this.PlaceComponentResult = p0 - getStartTime();
            }
            if (this.MyBillsEntityDataFactory) {
                setStartTime(p0 - this.PlaceComponentResult);
            }
            return super.getTransformation(p0, p1, p2);
        }
    }
}
