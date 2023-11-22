package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public static final byte[] PlaceComponentResult = {107, 3, 14, 112, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 211;
    private int BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private View lookAheadTest;
    Drawable mBackground;
    boolean mIsSplit;
    boolean mIsStacked;
    Drawable mSplitBackground;
    Drawable mStackedBackground;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2);
        this.mBackground = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.getAuthRequestContext);
        this.mStackedBackground = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.scheduleImpl);
        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1, -1);
        boolean z = true;
        if (getId() == R.id.getOnBoardingScenario) {
            this.mIsSplit = true;
            this.mSplitBackground = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.PlaceComponentResult);
        }
        obtainStyledAttributes.recycle();
        if (!this.mIsSplit ? this.mBackground != null || this.mStackedBackground != null : this.mSplitBackground != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.MyBillsEntityDataFactory = findViewById(R.id.KClassImpl$Data$declaredNonStaticMembers$2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = findViewById(R.id.scheduleImpl);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.mBackground;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.mBackground);
        }
        this.mBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.MyBillsEntityDataFactory;
            if (view != null) {
                this.mBackground.setBounds(view.getLeft(), this.MyBillsEntityDataFactory.getTop(), this.MyBillsEntityDataFactory.getRight(), this.MyBillsEntityDataFactory.getBottom());
            }
        }
        boolean z = true;
        if (!this.mIsSplit ? this.mBackground != null || this.mStackedBackground != null : this.mSplitBackground != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.MyBillsEntityDataFactory(this);
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.mStackedBackground;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.mStackedBackground);
        }
        this.mStackedBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsStacked && (drawable2 = this.mStackedBackground) != null) {
                drawable2.setBounds(this.lookAheadTest.getLeft(), this.lookAheadTest.getTop(), this.lookAheadTest.getRight(), this.lookAheadTest.getBottom());
            }
        }
        boolean z = true;
        if (!this.mIsSplit ? this.mBackground != null || this.mStackedBackground != null : this.mSplitBackground != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.MyBillsEntityDataFactory(this);
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.mSplitBackground);
        }
        this.mSplitBackground = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsSplit && (drawable2 = this.mSplitBackground) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.mIsSplit ? !(this.mBackground != null || this.mStackedBackground != null) : this.mSplitBackground == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.MyBillsEntityDataFactory(this);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.mStackedBackground;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.mBackground && !this.mIsSplit) || (drawable == this.mStackedBackground && this.mIsStacked) || ((drawable == this.mSplitBackground && this.mIsSplit) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mBackground;
        if (drawable != null && drawable.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
        Drawable drawable2 = this.mStackedBackground;
        if (drawable2 != null && drawable2.isStateful()) {
            this.mStackedBackground.setState(getDrawableState());
        }
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.mSplitBackground.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mStackedBackground;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.lookAheadTest;
        if (view != null) {
            removeView(view);
        }
        this.lookAheadTest = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.lookAheadTest;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            android.view.View r0 = r4.MyBillsEntityDataFactory
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1c
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            if (r0 != r1) goto L1c
            int r0 = r4.BuiltInFictitiousFunctionClassFactory
            if (r0 < 0) goto L1c
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r6 = java.lang.Math.min(r0, r6)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r1)
        L1c:
            super.onMeasure(r5, r6)
            android.view.View r5 = r4.MyBillsEntityDataFactory
            if (r5 != 0) goto L24
            return
        L24:
            int r5 = android.view.View.MeasureSpec.getMode(r6)
            android.view.View r0 = r4.lookAheadTest
            if (r0 == 0) goto L96
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L96
            r0 = 1073741824(0x40000000, float:2.0)
            if (r5 == r0) goto L96
            android.view.View r0 = r4.MyBillsEntityDataFactory
            boolean r0 = KClassImpl$Data$declaredNonStaticMembers$2(r0)
            if (r0 != 0) goto L53
            android.view.View r0 = r4.MyBillsEntityDataFactory
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r0 = r0.getMeasuredHeight()
            int r3 = r2.topMargin
            int r0 = r0 + r3
            int r2 = r2.bottomMargin
        L51:
            int r0 = r0 + r2
            goto L6e
        L53:
            android.view.View r0 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r0 = KClassImpl$Data$declaredNonStaticMembers$2(r0)
            if (r0 != 0) goto L6d
            android.view.View r0 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r0 = r0.getMeasuredHeight()
            int r3 = r2.topMargin
            int r0 = r0 + r3
            int r2 = r2.bottomMargin
            goto L51
        L6d:
            r0 = 0
        L6e:
            if (r5 != r1) goto L75
            int r5 = android.view.View.MeasureSpec.getSize(r6)
            goto L78
        L75:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L78:
            int r6 = r4.getMeasuredWidth()
            android.view.View r1 = r4.lookAheadTest
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r1 = r1.getMeasuredHeight()
            int r3 = r2.topMargin
            int r1 = r1 + r3
            int r2 = r2.bottomMargin
            int r1 = r1 + r2
            int r0 = r0 + r1
            int r5 = java.lang.Math.min(r0, r5)
            r4.setMeasuredDimension(r6, r5)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.lookAheadTest;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.mIsSplit) {
            Drawable drawable2 = this.mSplitBackground;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.mBackground != null) {
                if (this.MyBillsEntityDataFactory.getVisibility() == 0) {
                    this.mBackground.setBounds(this.MyBillsEntityDataFactory.getLeft(), this.MyBillsEntityDataFactory.getTop(), this.MyBillsEntityDataFactory.getRight(), this.MyBillsEntityDataFactory.getBottom());
                } else {
                    View view2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.mBackground.setBounds(this.KClassImpl$Data$declaredNonStaticMembers$2.getLeft(), this.KClassImpl$Data$declaredNonStaticMembers$2.getTop(), this.KClassImpl$Data$declaredNonStaticMembers$2.getRight(), this.KClassImpl$Data$declaredNonStaticMembers$2.getBottom());
                    } else {
                        this.mBackground.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.mIsStacked = z4;
            if (!z4 || (drawable = this.mStackedBackground) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        public static void MyBillsEntityDataFactory(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0045). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = androidx.appcompat.widget.ActionBarContainer.PlaceComponentResult
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 4
            r4 = 0
            if (r0 != 0) goto L13
            r6 = r2
            r5 = 4
            r7 = 23
            r8 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L45
        L13:
            r5 = 97
            r3 = r2
            r5 = 4
            r6 = 97
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            int r8 = r7 + 1
            byte r9 = (byte) r6
            r3[r7] = r9
            if (r8 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            r7 = r2[r5]
            r10 = r6
            r6 = r3
            r3 = r7
            r7 = r10
        L45:
            int r3 = -r3
            int r7 = r7 + r3
            int r5 = r5 + 1
            int r3 = r7 + (-8)
            r7 = r8
            r10 = r6
            r6 = r3
            r3 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
