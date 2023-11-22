package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* loaded from: classes6.dex */
public class ChangeClipBounds extends Transition {
    private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = {"android:clipBounds:clip"};

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void getAuthRequestContext(TransitionValues transitionValues) {
        View view = transitionValues.MyBillsEntityDataFactory;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect scheduleImpl = ViewCompat.scheduleImpl(view);
        transitionValues.getAuthRequestContext.put("android:clipBounds:clip", scheduleImpl);
        if (scheduleImpl == null) {
            transitionValues.getAuthRequestContext.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        getAuthRequestContext(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        getAuthRequestContext(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator = null;
        if (transitionValues != null && transitionValues2 != null && transitionValues.getAuthRequestContext.containsKey("android:clipBounds:clip") && transitionValues2.getAuthRequestContext.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) transitionValues.getAuthRequestContext.get("android:clipBounds:clip");
            Rect rect2 = (Rect) transitionValues2.getAuthRequestContext.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) transitionValues.getAuthRequestContext.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) transitionValues2.getAuthRequestContext.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            ViewCompat.PlaceComponentResult(transitionValues2.MyBillsEntityDataFactory, rect);
            objectAnimator = ObjectAnimator.ofObject(transitionValues2.MyBillsEntityDataFactory, (Property<View, V>) ViewUtils.MyBillsEntityDataFactory, (TypeEvaluator) new RectEvaluator(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z) {
                final View view = transitionValues2.MyBillsEntityDataFactory;
                objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeClipBounds.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewCompat.PlaceComponentResult(view, (Rect) null);
                    }
                });
            }
        }
        return objectAnimator;
    }
}
