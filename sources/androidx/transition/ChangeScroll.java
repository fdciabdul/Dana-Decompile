package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes6.dex */
public class ChangeScroll extends Transition {
    private static final String[] PlaceComponentResult = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        PlaceComponentResult(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        PlaceComponentResult(transitionValues);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return PlaceComponentResult;
    }

    private static void PlaceComponentResult(TransitionValues transitionValues) {
        transitionValues.getAuthRequestContext.put("android:changeScroll:x", Integer.valueOf(transitionValues.MyBillsEntityDataFactory.getScrollX()));
        transitionValues.getAuthRequestContext.put("android:changeScroll:y", Integer.valueOf(transitionValues.MyBillsEntityDataFactory.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.MyBillsEntityDataFactory;
        int intValue = ((Integer) transitionValues.getAuthRequestContext.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) transitionValues2.getAuthRequestContext.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) transitionValues.getAuthRequestContext.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) transitionValues2.getAuthRequestContext.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        return TransitionUtils.BuiltInFictitiousFunctionClassFactory(objectAnimator, objectAnimator2);
    }
}
