package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/* loaded from: classes3.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.core.widgets.Barrier KClassImpl$Data$declaredNonStaticMembers$2;
    private int PlaceComponentResult;
    private int getAuthRequestContext;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public int getType() {
        return this.PlaceComponentResult;
    }

    public void setType(int i) {
        this.PlaceComponentResult = i;
    }

    private void BuiltInFictitiousFunctionClassFactory(ConstraintWidget constraintWidget, int i, boolean z) {
        this.getAuthRequestContext = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.PlaceComponentResult;
            if (i2 == 5) {
                this.getAuthRequestContext = 0;
            } else if (i2 == 6) {
                this.getAuthRequestContext = 1;
            }
        } else if (z) {
            int i3 = this.PlaceComponentResult;
            if (i3 == 5) {
                this.getAuthRequestContext = 1;
            } else if (i3 == 6) {
                this.getAuthRequestContext = 0;
            }
        } else {
            int i4 = this.PlaceComponentResult;
            if (i4 == 5) {
                this.getAuthRequestContext = 0;
            } else if (i4 == 6) {
                this.getAuthRequestContext = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            ((androidx.constraintlayout.core.widgets.Barrier) constraintWidget).PlaceComponentResult = this.getAuthRequestContext;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        BuiltInFictitiousFunctionClassFactory(constraintWidget, this.PlaceComponentResult, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new androidx.constraintlayout.core.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.K) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index != R.styleable.getNameOrBuilderList) {
                    if (index == R.styleable.J) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    }
                } else {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = obtainStyledAttributes.getBoolean(index, true);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mHelperWidget = this.KClassImpl$Data$declaredNonStaticMembers$2;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = z;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public boolean getAllowsGoneWidget() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public void setDpMargin(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getMargin() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
    }

    public void setMargin(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            androidx.constraintlayout.core.widgets.Barrier barrier = (androidx.constraintlayout.core.widgets.Barrier) helperWidget;
            BuiltInFictitiousFunctionClassFactory(barrier, constraint.BuiltInFictitiousFunctionClassFactory.F, ((ConstraintWidgetContainer) helperWidget.W).C());
            barrier.getAuthRequestContext = constraint.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper;
            barrier.BuiltInFictitiousFunctionClassFactory = constraint.BuiltInFictitiousFunctionClassFactory.I;
        }
    }
}
