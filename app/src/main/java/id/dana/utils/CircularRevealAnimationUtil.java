package id.dana.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* loaded from: classes5.dex */
public class CircularRevealAnimationUtil {

    /* loaded from: classes5.dex */
    public interface OnAnimationFinishedListener {
        void onRevealAnimationStart();

        void onUnRevealAnimationEnd();
    }

    private CircularRevealAnimationUtil() {
    }

    public static void PlaceComponentResult(final Context context, final View view, final OnAnimationFinishedListener onAnimationFinishedListener) {
        if (OSUtil.scheduleImpl()) {
            view.setVisibility(4);
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.utils.CircularRevealAnimationUtil.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        CircularRevealAnimationUtil.KClassImpl$Data$declaredNonStaticMembers$2(context, view, onAnimationFinishedListener);
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
                return;
            }
            return;
        }
        view.setVisibility(0);
        view.setAlpha(0.0f);
        ViewCompat.MyBillsEntityDataFactory(view).getAuthRequestContext(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(context.getResources().getInteger(17694722));
    }

    private static Animator PlaceComponentResult(View view, int i, boolean z) {
        float sqrt;
        int left = view.getLeft();
        int bottom = view.getBottom();
        int width = view.getWidth();
        int height = view.getHeight();
        float f = 0.0f;
        if (z) {
            sqrt = 0.0f;
        } else {
            double d = width;
            double d2 = height * height;
            Double.isNaN(d);
            Double.isNaN(d);
            Double.isNaN(d2);
            sqrt = (float) Math.sqrt((d * d) + d2);
        }
        if (z) {
            double d3 = width;
            double d4 = height * height;
            Double.isNaN(d3);
            Double.isNaN(d3);
            Double.isNaN(d4);
            f = (float) Math.sqrt((d3 * d3) + d4);
        }
        Animator duration = ViewAnimationUtils.createCircularReveal(view, left, bottom, sqrt, f).setDuration(i);
        duration.setInterpolator(new FastOutSlowInInterpolator());
        return duration;
    }

    public static void MyBillsEntityDataFactory(Context context, View view, final OnAnimationFinishedListener onAnimationFinishedListener) {
        if (OSUtil.scheduleImpl()) {
            Animator PlaceComponentResult = PlaceComponentResult(view, context.getResources().getInteger(17694722), false);
            PlaceComponentResult.addListener(new AnimatorListenerAdapter() { // from class: id.dana.utils.CircularRevealAnimationUtil.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    OnAnimationFinishedListener.this.onUnRevealAnimationEnd();
                }
            });
            PlaceComponentResult.start();
            return;
        }
        ViewCompat.MyBillsEntityDataFactory(view).getAuthRequestContext(0.0f).KClassImpl$Data$declaredNonStaticMembers$2(context.getResources().getInteger(17694722)).KClassImpl$Data$declaredNonStaticMembers$2(new ViewPropertyAnimatorListenerAdapter() { // from class: id.dana.utils.CircularRevealAnimationUtil.4
            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void getAuthRequestContext(View view2) {
                super.getAuthRequestContext(view2);
                OnAnimationFinishedListener.this.onUnRevealAnimationEnd();
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Context context, View view, final OnAnimationFinishedListener onAnimationFinishedListener) {
        Animator PlaceComponentResult = PlaceComponentResult(view, context.getResources().getInteger(17694722), true);
        view.setVisibility(0);
        PlaceComponentResult.addListener(new AnimatorListenerAdapter() { // from class: id.dana.utils.CircularRevealAnimationUtil.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                OnAnimationFinishedListener.this.onRevealAnimationStart();
            }
        });
        PlaceComponentResult.start();
    }
}
