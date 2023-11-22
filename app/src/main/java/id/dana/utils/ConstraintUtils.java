package id.dana.utils;

import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

/* loaded from: classes5.dex */
public class ConstraintUtils {
    private static ConstraintSet BuiltInFictitiousFunctionClassFactory;
    private static Transition MyBillsEntityDataFactory;

    /* loaded from: classes9.dex */
    public static class TransitionListener implements Transition.TransitionListener {
        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
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
    }

    private ConstraintUtils() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Transition.TransitionListener transitionListener) {
        BuiltInFictitiousFunctionClassFactory = new ConstraintSet();
        ChangeBounds changeBounds = new ChangeBounds();
        MyBillsEntityDataFactory = changeBounds;
        changeBounds.addListener(transitionListener);
        MyBillsEntityDataFactory.setInterpolator(new AnticipateOvershootInterpolator(0.0f));
        MyBillsEntityDataFactory.setDuration(200L);
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, ConstraintLayout constraintLayout) {
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(view.getId(), 3);
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(View view, ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(constraintLayout);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(view.getId(), 6, 0, 6, 0);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void getErrorConfigVersion(View view, ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(constraintLayout);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(view.getId(), 7, 0, 7, 0);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void MyBillsEntityDataFactory(View view, ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(constraintLayout);
        constraintSet.MyBillsEntityDataFactory(view.getId(), 6);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void PlaceComponentResult(View view, ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(constraintLayout);
        constraintSet.MyBillsEntityDataFactory(view.getId(), 7);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view, ConstraintLayout constraintLayout) {
        if (constraintLayout != null) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(constraintLayout);
        }
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(view.getId(), 4);
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void getAuthRequestContext(View view, ConstraintLayout constraintLayout) {
        if (constraintLayout != null) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(constraintLayout);
        }
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(view.getId(), 4, 0, 3);
        TransitionManager.getAuthRequestContext(constraintLayout, MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void getAuthRequestContext(View view, ConstraintLayout constraintLayout, boolean z) {
        if (constraintLayout != null) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(constraintLayout);
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(view.getId(), 3, 0, 3, 0);
        if (z) {
            TransitionManager.getAuthRequestContext(constraintLayout, MyBillsEntityDataFactory);
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view, ConstraintLayout constraintLayout, boolean z, int i) {
        if (constraintLayout != null) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(constraintLayout);
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(view.getId(), 3, 0, 3, i);
        if (z) {
            TransitionManager.getAuthRequestContext(constraintLayout, MyBillsEntityDataFactory);
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
    }
}
