package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class Fade extends Visibility {
    public Fade(int i) {
        setMode(i);
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.PlaceComponentResult);
        setMode(TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.getAuthRequestContext.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.PlaceComponentResult(transitionValues.MyBillsEntityDataFactory)));
    }

    private Animator MyBillsEntityDataFactory(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.MyBillsEntityDataFactory(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.KClassImpl$Data$declaredNonStaticMembers$2, f2);
        ofFloat.addListener(new FadeAnimatorListener(view));
        addListener(new TransitionListenerAdapter() { // from class: androidx.transition.Fade.1
            {
                Fade.this = this;
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                ViewUtils.MyBillsEntityDataFactory(view, 1.0f);
                ViewUtils.MyBillsEntityDataFactory(view);
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float MyBillsEntityDataFactory = MyBillsEntityDataFactory(transitionValues, 0.0f);
        return MyBillsEntityDataFactory(view, MyBillsEntityDataFactory != 1.0f ? MyBillsEntityDataFactory : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(view);
        return MyBillsEntityDataFactory(view, MyBillsEntityDataFactory(transitionValues, 1.0f), 0.0f);
    }

    private static float MyBillsEntityDataFactory(TransitionValues transitionValues, float f) {
        Float f2;
        return (transitionValues == null || (f2 = (Float) transitionValues.getAuthRequestContext.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* loaded from: classes.dex */
    public static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private final View KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory = false;

        FadeAnimatorListener(View view) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.BottomSheetCardBindingView$watcherCardNumberView$1(this.KClassImpl$Data$declaredNonStaticMembers$2) && this.KClassImpl$Data$declaredNonStaticMembers$2.getLayerType() == 0) {
                this.MyBillsEntityDataFactory = true;
                this.KClassImpl$Data$declaredNonStaticMembers$2.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 1.0f);
            if (this.MyBillsEntityDataFactory) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.setLayerType(0, null);
            }
        }
    }
}
