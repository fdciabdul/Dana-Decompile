package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;

/* loaded from: classes3.dex */
class TranslationAnimationCreator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator getAuthRequestContext(View view, TransitionValues transitionValues, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.MyBillsEntityDataFactory.getTag(R.id.scheduleImpl)) != null) {
            f5 = (r4[0] - i) + translationX;
            f6 = (r4[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int round = Math.round(f5 - translationX);
        int round2 = Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f6, f4));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.MyBillsEntityDataFactory, i + round, i2 + round2, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofPropertyValuesHolder.addListener(transitionPositionListener);
        AnimatorUtils.KClassImpl$Data$declaredNonStaticMembers$2(ofPropertyValuesHolder, transitionPositionListener);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }

    /* loaded from: classes3.dex */
    static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private float BuiltInFictitiousFunctionClassFactory;
        private final View KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final float NetworkUserEntityData$$ExternalSyntheticLambda0;
        private float PlaceComponentResult;
        private final int getAuthRequestContext;
        private int[] lookAheadTest;
        private final View moveToNextValue;
        private final float scheduleImpl;

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        TransitionPositionListener(View view, View view2, int i, int i2, float f, float f2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
            this.moveToNextValue = view2;
            this.getAuthRequestContext = i - Math.round(view.getTranslationX());
            this.MyBillsEntityDataFactory = i2 - Math.round(view.getTranslationY());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
            this.scheduleImpl = f2;
            int[] iArr = (int[]) view2.getTag(R.id.scheduleImpl);
            this.lookAheadTest = iArr;
            if (iArr != null) {
                view2.setTag(R.id.scheduleImpl, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.lookAheadTest == null) {
                this.lookAheadTest = new int[2];
            }
            this.lookAheadTest[0] = Math.round(this.getAuthRequestContext + this.KClassImpl$Data$declaredNonStaticMembers$2.getTranslationX());
            this.lookAheadTest[1] = Math.round(this.MyBillsEntityDataFactory + this.KClassImpl$Data$declaredNonStaticMembers$2.getTranslationY());
            this.moveToNextValue.setTag(R.id.scheduleImpl, this.lookAheadTest);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.getTranslationX();
            this.PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.getTranslationY();
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTranslationX(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTranslationY(this.scheduleImpl);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTranslationX(this.BuiltInFictitiousFunctionClassFactory);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTranslationY(this.PlaceComponentResult);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTranslationX(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTranslationY(this.scheduleImpl);
            transition.removeListener(this);
        }
    }

    private TranslationAnimationCreator() {
    }
}
