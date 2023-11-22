package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    private int mMode;
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Mode {
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class VisibilityInfo {
        boolean BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        ViewGroup PlaceComponentResult;
        ViewGroup getAuthRequestContext;
        boolean moveToNextValue;

        VisibilityInfo() {
        }
    }

    public Visibility() {
        this.mMode = 3;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.NetworkUserEntityData$$ExternalSyntheticLambda2);
        int authRequestContext = TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (authRequestContext != 0) {
            setMode(authRequestContext);
        }
    }

    public void setMode(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.getAuthRequestContext.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.MyBillsEntityDataFactory.getVisibility()));
        transitionValues.getAuthRequestContext.put(PROPNAME_PARENT, transitionValues.MyBillsEntityDataFactory.getParent());
        int[] iArr = new int[2];
        transitionValues.MyBillsEntityDataFactory.getLocationOnScreen(iArr);
        transitionValues.getAuthRequestContext.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((Integer) transitionValues.getAuthRequestContext.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) transitionValues.getAuthRequestContext.get(PROPNAME_PARENT)) != null;
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.moveToNextValue = false;
        visibilityInfo.BuiltInFictitiousFunctionClassFactory = false;
        if (transitionValues != null && transitionValues.getAuthRequestContext.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.MyBillsEntityDataFactory = ((Integer) transitionValues.getAuthRequestContext.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.getAuthRequestContext = (ViewGroup) transitionValues.getAuthRequestContext.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.MyBillsEntityDataFactory = -1;
            visibilityInfo.getAuthRequestContext = null;
        }
        if (transitionValues2 != null && transitionValues2.getAuthRequestContext.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.KClassImpl$Data$declaredNonStaticMembers$2 = ((Integer) transitionValues2.getAuthRequestContext.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.PlaceComponentResult = (ViewGroup) transitionValues2.getAuthRequestContext.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            visibilityInfo.PlaceComponentResult = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            if (visibilityInfo.MyBillsEntityDataFactory == visibilityInfo.KClassImpl$Data$declaredNonStaticMembers$2 && visibilityInfo.getAuthRequestContext == visibilityInfo.PlaceComponentResult) {
                return visibilityInfo;
            }
            if (visibilityInfo.MyBillsEntityDataFactory != visibilityInfo.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (visibilityInfo.MyBillsEntityDataFactory == 0) {
                    visibilityInfo.BuiltInFictitiousFunctionClassFactory = false;
                    visibilityInfo.moveToNextValue = true;
                } else if (visibilityInfo.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                    visibilityInfo.BuiltInFictitiousFunctionClassFactory = true;
                    visibilityInfo.moveToNextValue = true;
                }
            } else if (visibilityInfo.PlaceComponentResult == null) {
                visibilityInfo.BuiltInFictitiousFunctionClassFactory = false;
                visibilityInfo.moveToNextValue = true;
            } else if (visibilityInfo.getAuthRequestContext == null) {
                visibilityInfo.BuiltInFictitiousFunctionClassFactory = true;
                visibilityInfo.moveToNextValue = true;
            }
        } else if (transitionValues == null && visibilityInfo.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            visibilityInfo.BuiltInFictitiousFunctionClassFactory = true;
            visibilityInfo.moveToNextValue = true;
        } else if (transitionValues2 == null && visibilityInfo.MyBillsEntityDataFactory == 0) {
            visibilityInfo.BuiltInFictitiousFunctionClassFactory = false;
            visibilityInfo.moveToNextValue = true;
        }
        return visibilityInfo;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.moveToNextValue) {
            if (visibilityChangeInfo.getAuthRequestContext == null && visibilityChangeInfo.PlaceComponentResult == null) {
                return null;
            }
            if (visibilityChangeInfo.BuiltInFictitiousFunctionClassFactory) {
                return onAppear(viewGroup, transitionValues, visibilityChangeInfo.MyBillsEntityDataFactory, transitionValues2, visibilityChangeInfo.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.MyBillsEntityDataFactory, transitionValues2, visibilityChangeInfo.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.MyBillsEntityDataFactory.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).moveToNextValue) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.MyBillsEntityDataFactory, transitionValues, transitionValues2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x007c, code lost:
    
        if (r9.mCanRemoveViews != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator onDisappear(final android.view.ViewGroup r10, androidx.transition.TransitionValues r11, int r12, androidx.transition.TransitionValues r13, int r14) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues == null || transitionValues2 == null || transitionValues2.getAuthRequestContext.containsKey(PROPNAME_VISIBILITY) == transitionValues.getAuthRequestContext.containsKey(PROPNAME_VISIBILITY)) {
            VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
            if (visibilityChangeInfo.moveToNextValue) {
                return visibilityChangeInfo.MyBillsEntityDataFactory == 0 || visibilityChangeInfo.KClassImpl$Data$declaredNonStaticMembers$2 == 0;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory;
        private final ViewGroup getAuthRequestContext;
        private final View getErrorConfigVersion;
        boolean BuiltInFictitiousFunctionClassFactory = false;
        private final boolean PlaceComponentResult = true;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        DisappearListener(View view, int i) {
            this.getErrorConfigVersion = view;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.getAuthRequestContext = (ViewGroup) view.getParent();
            MyBillsEntityDataFactory(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator animator) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            ViewUtils.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator animator) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            ViewUtils.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            getAuthRequestContext();
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            getAuthRequestContext();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            MyBillsEntityDataFactory(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            MyBillsEntityDataFactory(true);
        }

        private void getAuthRequestContext() {
            if (!this.BuiltInFictitiousFunctionClassFactory) {
                ViewUtils.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2);
                ViewGroup viewGroup = this.getAuthRequestContext;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            MyBillsEntityDataFactory(false);
        }

        private void MyBillsEntityDataFactory(boolean z) {
            ViewGroup viewGroup;
            if (!this.PlaceComponentResult || this.MyBillsEntityDataFactory == z || (viewGroup = this.getAuthRequestContext) == null) {
                return;
            }
            this.MyBillsEntityDataFactory = z;
            ViewGroupUtils.MyBillsEntityDataFactory(viewGroup, z);
        }
    }
}
