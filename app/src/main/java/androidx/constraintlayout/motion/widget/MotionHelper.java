package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    protected View[] views;

    public boolean isDecorator() {
        return false;
    }

    public void onFinishedMotionScene(MotionLayout motionLayout) {
    }

    public void onPostDraw(Canvas canvas) {
    }

    public void onPreDraw(Canvas canvas) {
    }

    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
    }

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
    }

    public void setProgress(View view, float f) {
    }

    public MotionHelper(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.PlaceComponentResult = false;
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.PlaceComponentResult = false;
        init(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.PlaceComponentResult = false;
        init(attributeSet);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.asEntryTransformer);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.onRefresh) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.NavGraphBuilder) {
                    this.PlaceComponentResult = obtainStyledAttributes.getBoolean(index, this.PlaceComponentResult);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isUsedOnShow() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public boolean isUseOnHide() {
        return this.PlaceComponentResult;
    }

    public float getProgress() {
        return this.MyBillsEntityDataFactory;
    }

    public void setProgress(float f) {
        this.MyBillsEntityDataFactory = f;
        int i = 0;
        if (this.mCount > 0) {
            this.views = getViews((ConstraintLayout) getParent());
            while (i < this.mCount) {
                setProgress(this.views[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f);
            }
            i++;
        }
    }
}
