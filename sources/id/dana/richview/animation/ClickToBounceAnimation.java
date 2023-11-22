package id.dana.richview.animation;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import id.dana.biometric.domain.model.RiskActionConstant;
import id.dana.utils.showcase.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015"}, d2 = {"Lid/dana/richview/animation/ClickToBounceAnimation;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "p0", "Landroid/view/MotionEvent;", "p1", "", RiskActionConstant.ON_TOUCH, "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "", "p2", "p3", "KClassImpl$Data$declaredNonStaticMembers$2", "(FFII)Z", "", "getAuthRequestContext", "(Landroid/view/View;)V", "Landroid/view/View$OnClickListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View$OnClickListener;", "Z", "PlaceComponentResult", "<init>", "(Landroid/view/View$OnClickListener;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClickToBounceAnimation implements View.OnTouchListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final View.OnClickListener getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, android.view.View$OnClickListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ClickToBounceAnimation() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r0, r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.animation.ClickToBounceAnimation.<init>():void");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(float p0, float p1, int p2, int p3) {
        return p0 >= 0.0f && p1 >= 0.0f && p0 < ((float) p2) && p1 < ((float) p3);
    }

    public ClickToBounceAnimation(View.OnClickListener onClickListener, boolean z) {
        this.getAuthRequestContext = onClickListener;
        this.PlaceComponentResult = z;
    }

    public /* synthetic */ ClickToBounceAnimation(View.OnClickListener onClickListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : onClickListener, (i & 2) != 0 ? false : z);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View p0, MotionEvent p1) {
        float x = p1 != null ? p1.getX() : 0.0f;
        float y = p1 != null ? p1.getY() : 0.0f;
        if (p0 != null) {
            int width = p0.getWidth();
            int height = p0.getHeight();
            Integer valueOf = p1 != null ? Integer.valueOf(p1.getAction()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                ViewPropertyAnimator animate = p0.animate();
                animate.scaleX(0.95f);
                animate.scaleY(0.95f);
                animate.setDuration(150L);
                p0.invalidate();
                return false;
            } else if (valueOf != null && valueOf.intValue() == 1) {
                if (KClassImpl$Data$declaredNonStaticMembers$2(x, y, width, height)) {
                    ViewPropertyAnimator animate2 = p0.animate();
                    Intrinsics.checkNotNullExpressionValue(animate2, "");
                    animate2.scaleX(1.0f);
                    animate2.scaleY(1.0f);
                    animate2.setDuration(100L);
                    animate2.withEndAction(new Runnable() { // from class: id.dana.richview.animation.ClickToBounceAnimation$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ClickToBounceAnimation.KClassImpl$Data$declaredNonStaticMembers$2(ClickToBounceAnimation.this, p0, p0);
                        }
                    });
                    p0.invalidate();
                    return false;
                }
                return false;
            } else if (valueOf == null || valueOf.intValue() != 2) {
                if (valueOf == null || valueOf.intValue() != 3) {
                    return false;
                }
                getAuthRequestContext(p0);
                return false;
            } else if (x < 0.0f || y < 0.0f || x > width || y > height) {
                getAuthRequestContext(p0);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    private static void getAuthRequestContext(View view) {
        ViewPropertyAnimator animate = view.animate();
        Intrinsics.checkNotNullExpressionValue(animate, "");
        animate.scaleX(1.0f);
        animate.scaleY(1.0f);
        animate.setDuration(100L);
        view.invalidate();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ClickToBounceAnimation clickToBounceAnimation, View view, View view2) {
        Intrinsics.checkNotNullParameter(clickToBounceAnimation, "");
        Intrinsics.checkNotNullParameter(view2, "");
        if (clickToBounceAnimation.PlaceComponentResult) {
            Utils.getAuthRequestContext(view.getContext(), 25L);
        }
        View.OnClickListener onClickListener = clickToBounceAnimation.getAuthRequestContext;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }
}
