package id.dana.animation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import id.dana.utils.AnimationUtil;

/* loaded from: classes8.dex */
public class OverScrollBounceBehavior extends CoordinatorLayout.Behavior<View> {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private OnScrollChangeListener PlaceComponentResult;
    private float getAuthRequestContext;
    private View lookAheadTest;
    private View moveToNextValue;

    /* loaded from: classes8.dex */
    public interface OnScrollChangeListener {
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(int i) {
        return i == 0;
    }

    public OverScrollBounceBehavior() {
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.getAuthRequestContext = 1.8f;
    }

    public OverScrollBounceBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.getAuthRequestContext = 1.8f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        if (BuiltInFictitiousFunctionClassFactory(i2) && BuiltInFictitiousFunctionClassFactory()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
            int height = this.lookAheadTest.getHeight();
            this.BuiltInFictitiousFunctionClassFactory = height;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) (height * this.getAuthRequestContext);
            return true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        View view3;
        if (i4 >= 0) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 -= i4;
        if (!BuiltInFictitiousFunctionClassFactory(i5) || !BuiltInFictitiousFunctionClassFactory() || this.NetworkUserEntityData$$ExternalSyntheticLambda0 <= 0 || this.lookAheadTest.getLayoutParams().height + Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda0) > this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.lookAheadTest.getLayoutParams().height = this.BuiltInFictitiousFunctionClassFactory + Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.lookAheadTest.requestLayout();
        if (this.PlaceComponentResult == null || (view3 = this.lookAheadTest) == null) {
            return;
        }
        int i6 = view3.getLayoutParams().height;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        if (BuiltInFictitiousFunctionClassFactory(i) && BuiltInFictitiousFunctionClassFactory() && this.lookAheadTest.getHeight() > this.BuiltInFictitiousFunctionClassFactory) {
            if (this.lookAheadTest.getAnimation() != null) {
                this.lookAheadTest.getAnimation().cancel();
            }
            boolean z = this.MyBillsEntityDataFactory && this.lookAheadTest.getHeight() >= this.moveToNextValue.getHeight();
            if (this.moveToNextValue != null && this.lookAheadTest.getHeight() > this.moveToNextValue.getHeight()) {
                ResetAnimation resetAnimation = new ResetAnimation(this.lookAheadTest, this.moveToNextValue.getHeight(), null);
                resetAnimation.setDuration(150L);
                this.lookAheadTest.startAnimation(resetAnimation);
            } else {
                View view3 = this.lookAheadTest;
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                final OnScrollChangeListener onScrollChangeListener = this.PlaceComponentResult;
                ResetAnimation resetAnimation2 = new ResetAnimation(view3, i2, onScrollChangeListener);
                resetAnimation2.setDuration(300L);
                resetAnimation2.setStartOffset(z ? RangedBeacon.DEFAULT_MAX_TRACKING_AGE : 0L);
                resetAnimation2.setAnimationListener(new AnimationUtil.AnimationListener() { // from class: id.dana.home.view.OverScrollBounceBehavior.1
                    @Override // id.dana.utils.AnimationUtil.AnimationListener, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                    }
                });
                view3.startAnimation(resetAnimation2);
            }
            this.lookAheadTest.getHeight();
            this.moveToNextValue.getHeight();
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return this.lookAheadTest != null;
    }

    /* loaded from: classes8.dex */
    public static class ResetAnimation extends Animation {
        OnScrollChangeListener BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        View getAuthRequestContext;

        ResetAnimation(View view, int i, OnScrollChangeListener onScrollChangeListener) {
            this.getAuthRequestContext = view;
            this.PlaceComponentResult = i;
            int height = view.getHeight();
            this.MyBillsEntityDataFactory = height;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult - height;
            this.BuiltInFictitiousFunctionClassFactory = onScrollChangeListener;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            this.getAuthRequestContext.getLayoutParams().height = (int) (this.PlaceComponentResult - (this.KClassImpl$Data$declaredNonStaticMembers$2 * (1.0f - f)));
            this.getAuthRequestContext.requestLayout();
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                OverScrollBounceBehavior.PlaceComponentResult(this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
            }
        }
    }

    static /* synthetic */ float PlaceComponentResult(View view, int i, int i2) {
        if (view != null) {
            return (i - view.getLayoutParams().height) / (i - i2);
        }
        return 0.0f;
    }
}
