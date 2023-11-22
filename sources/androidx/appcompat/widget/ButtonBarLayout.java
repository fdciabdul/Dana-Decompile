package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* loaded from: classes6.dex */
public class ButtonBarLayout extends LinearLayout {
    private int BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BuiltInFictitiousFunctionClassFactory = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.n);
        ViewCompat.MyBillsEntityDataFactory(this, context, R.styleable.n, attributeSet, obtainStyledAttributes, 0, 0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(R.styleable.OtpRegistrationPresenter$input$2, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            if (!z && getAuthRequestContext()) {
                getAuthRequestContext(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int i5 = 0;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (size > this.BuiltInFictitiousFunctionClassFactory && getAuthRequestContext()) {
                getAuthRequestContext(false);
            }
            this.BuiltInFictitiousFunctionClassFactory = size;
        }
        if (getAuthRequestContext() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 && !getAuthRequestContext()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                getAuthRequestContext(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            i4 = -1;
            if (i6 >= childCount) {
                i6 = -1;
                break;
            } else if (getChildAt(i6).getVisibility() == 0) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            View childAt = getChildAt(i6);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (!getAuthRequestContext()) {
                i5 = paddingTop + getPaddingBottom();
            } else {
                int i7 = i6 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i7 >= childCount2) {
                        break;
                    } else if (getChildAt(i7).getVisibility() == 0) {
                        i4 = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (i4 >= 0) {
                    paddingTop += getChildAt(i4).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i5 = paddingTop;
            }
        }
        if (ViewCompat.PrepareContext(this) != i5) {
            setMinimumHeight(i5);
            if (i2 == 0) {
                super.onMeasure(i, i2);
            }
        }
    }

    private void getAuthRequestContext(boolean z) {
        if (this.MyBillsEntityDataFactory != z) {
            if (!z || this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.MyBillsEntityDataFactory = z;
                setOrientation(z ? 1 : 0);
                setGravity(z ? 8388613 : 80);
                View findViewById = findViewById(R.id.E);
                if (findViewById != null) {
                    findViewById.setVisibility(z ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    private boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
