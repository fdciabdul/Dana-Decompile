package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes3.dex */
public class Guideline extends View implements FSDraw {
    private boolean MyBillsEntityDataFactory;

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public Guideline(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.MyBillsEntityDataFactory && layoutParams.whenAvailable == i) {
            return;
        }
        layoutParams.whenAvailable = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.MyBillsEntityDataFactory && layoutParams.getSupportButtonTintMode == i) {
            return;
        }
        layoutParams.getSupportButtonTintMode = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.MyBillsEntityDataFactory && layoutParams.SubSequence == f) {
            return;
        }
        layoutParams.SubSequence = f;
        setLayoutParams(layoutParams);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }
}
