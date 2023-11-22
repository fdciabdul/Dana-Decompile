package id.dana.popup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import id.dana.utils.foundation.logger.log.DanaLog;

/* loaded from: classes5.dex */
public class LockableViewPager extends ViewPager {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int getAuthRequestContext;

    public LockableViewPager(Context context) {
        super(context);
        this.getAuthRequestContext = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    public LockableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.BuiltInFictitiousFunctionClassFactory && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("onInterceptTouchEvent");
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory("LockableViewPager", sb.toString());
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        this.MyBillsEntityDataFactory = i;
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            if (this.getAuthRequestContext == 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    ViewPager.LayoutParams layoutParams = (ViewPager.LayoutParams) childAt.getLayoutParams();
                    if (layoutParams != null) {
                        if (layoutParams.MyBillsEntityDataFactory) {
                            int i4 = layoutParams.getAuthRequestContext & 112;
                            if (i4 == 48 || i4 == 80) {
                                this.KClassImpl$Data$declaredNonStaticMembers$2 += childAt.getMeasuredHeight();
                            }
                        } else {
                            int i5 = this.getAuthRequestContext;
                            childAt.measure(getChildMeasureSpec(this.MyBillsEntityDataFactory, getPaddingLeft() + getPaddingRight(), childAt.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
                            this.getAuthRequestContext = Math.max(i5, childAt.getMeasuredHeight());
                        }
                    }
                }
            }
            i2 = View.MeasureSpec.makeMeasureSpec(this.getAuthRequestContext + this.KClassImpl$Data$declaredNonStaticMembers$2 + getPaddingBottom() + getPaddingTop(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setSwipeable(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }
}
