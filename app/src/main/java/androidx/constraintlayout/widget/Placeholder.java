package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class Placeholder extends View {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private View getAuthRequestContext;

    public Placeholder(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 4;
        getAuthRequestContext(null);
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 4;
        getAuthRequestContext(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 4;
        getAuthRequestContext(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 4;
        getAuthRequestContext(attributeSet);
    }

    private void getAuthRequestContext(AttributeSet attributeSet) {
        super.setVisibility(this.BuiltInFictitiousFunctionClassFactory);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CYFMonitor$ChallengeActionCallback);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.getRawPath) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.WrappedDrawableState) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(index, this.BuiltInFictitiousFunctionClassFactory);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setEmptyVisibility(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    public int getEmptyVisibility() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public View getContent() {
        return this.getAuthRequestContext;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(InstrumentInjector.typefaceCreateDerived(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == -1 && !isInEditMode()) {
            setVisibility(this.BuiltInFictitiousFunctionClassFactory);
        }
        View findViewById = constraintLayout.findViewById(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.getAuthRequestContext = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).getOnBoardingScenario = true;
            this.getAuthRequestContext.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == i) {
            return;
        }
        View view = this.getAuthRequestContext;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.getAuthRequestContext.getLayoutParams()).getOnBoardingScenario = false;
            this.getAuthRequestContext = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.getAuthRequestContext == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.getAuthRequestContext.getLayoutParams();
        layoutParams2.c.h = 0;
        if (layoutParams.c.getNameOrBuilderList[0] != ConstraintWidget.DimensionBehaviour.FIXED) {
            ConstraintWidget constraintWidget = layoutParams.c;
            ConstraintWidget constraintWidget2 = layoutParams2.c;
            constraintWidget.getErrorConfigVersion(constraintWidget2.h == 8 ? 0 : constraintWidget2.FlowViewUtil$textChanges$2);
        }
        if (layoutParams.c.getNameOrBuilderList[1] != ConstraintWidget.DimensionBehaviour.FIXED) {
            ConstraintWidget constraintWidget3 = layoutParams.c;
            ConstraintWidget constraintWidget4 = layoutParams2.c;
            constraintWidget3.lookAheadTest(constraintWidget4.h != 8 ? constraintWidget4.C : 0);
        }
        layoutParams2.c.h = 8;
    }
}
