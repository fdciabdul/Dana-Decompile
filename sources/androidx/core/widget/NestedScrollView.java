package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView, FSDraw {
    static final int ANIMATED_SCROLL_GAP = 250;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private final NestedScrollingChildHelper BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    private OverScroller FragmentBottomSheetPaymentSettingBinding;
    private int GetContactSyncConfig;
    private int MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda5;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private SavedState NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final NestedScrollingParentHelper NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int PrepareContext;
    private float getCallingPid;
    private boolean getErrorConfigVersion;
    private VelocityTracker getSupportButtonTintMode;
    private long initRecordTimeStamp;
    private OnScrollChangeListener isLayoutRequested;
    private View lookAheadTest;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    private boolean moveToNextValue;
    private final float newProxyInstance;
    private int readMicros;
    private boolean scheduleImpl;
    private static final float getAuthRequestContext = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final AccessibilityDelegate PlaceComponentResult = new AccessibilityDelegate();
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {16843130};

    /* loaded from: classes3.dex */
    public interface OnScrollChangeListener {
        void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public void fsSuperDraw_525147df17cfa12d62e03b9c86575ca7(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new Rect();
        this.moveToNextValue = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.lookAheadTest = null;
        this.scheduleImpl = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        this.MyBillsEntityDataFactory = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new int[2];
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new int[2];
        this.mEdgeGlowTop = EdgeEffectCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, attributeSet);
        this.mEdgeGlowBottom = EdgeEffectCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, attributeSet);
        this.newProxyInstance = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.FragmentBottomSheetPaymentSettingBinding = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.readMicros = viewConfiguration.getScaledTouchSlop();
        this.GetContactSyncConfig = viewConfiguration.getScaledMinimumFlingVelocity();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, KClassImpl$Data$declaredNonStaticMembers$2, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new NestedScrollingParentHelper();
        this.BuiltInFictitiousFunctionClassFactory = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.MyBillsEntityDataFactory(this, PlaceComponentResult);
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(i, i2);
    }

    public void stopNestedScroll(int i) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(i);
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (nestedScrollingChildHelper.PlaceComponentResult) {
            ViewCompat.F(nestedScrollingChildHelper.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        nestedScrollingChildHelper.PlaceComponentResult = z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        MyBillsEntityDataFactory(i4, i5, iArr);
    }

    private void MyBillsEntityDataFactory(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (i2 == 1) {
            nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory = i;
        } else {
            nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
        startNestedScroll(2, i2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (i == 1) {
            nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory = 0;
        } else {
            nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
        stopNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        MyBillsEntityDataFactory(i4, i5, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        MyBillsEntityDataFactory(i4, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        fling((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        return nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory | nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * MAX_SCROLL_FACTOR);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.isLayoutRequested = onScrollChangeListener;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
        }
        return false;
    }

    public boolean isFillViewport() {
        return this.getErrorConfigVersion;
    }

    public void setFillViewport(boolean z) {
        if (z != this.getErrorConfigVersion) {
            this.getErrorConfigVersion = z;
            requestLayout();
        }
    }

    public boolean isSmoothScrollingEnabled() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = z;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.isLayoutRequested;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.getAuthRequestContext(this, i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.getErrorConfigVersion && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i3 = layoutParams.leftMargin;
                childAt.measure(getChildMeasureSpec(i, paddingLeft + paddingRight + i3 + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.setEmpty();
        if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                if (!keyEvent.isAltPressed()) {
                    return arrowScroll(33);
                }
                return fullScroll(33);
            } else if (keyCode == 20) {
                if (!keyEvent.isAltPressed()) {
                    return arrowScroll(130);
                }
                return fullScroll(130);
            } else if (keyCode != 62) {
                return false;
            } else {
                pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.scheduleImpl) {
            return true;
        }
        int i = action & 255;
        if (i == 0) {
            int y = (int) motionEvent.getY();
            if (!KClassImpl$Data$declaredNonStaticMembers$2((int) motionEvent.getX(), y)) {
                if (!PlaceComponentResult(motionEvent) && this.FragmentBottomSheetPaymentSettingBinding.isFinished()) {
                    z = false;
                }
                this.scheduleImpl = z;
                VelocityTracker velocityTracker = this.getSupportButtonTintMode;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.getSupportButtonTintMode = null;
                }
            } else {
                this.DatabaseTableConfigUtil = y;
                this.MyBillsEntityDataFactory = motionEvent.getPointerId(0);
                VelocityTracker velocityTracker2 = this.getSupportButtonTintMode;
                if (velocityTracker2 == null) {
                    this.getSupportButtonTintMode = VelocityTracker.obtain();
                } else {
                    velocityTracker2.clear();
                }
                this.getSupportButtonTintMode.addMovement(motionEvent);
                this.FragmentBottomSheetPaymentSettingBinding.computeScrollOffset();
                if (!PlaceComponentResult(motionEvent) && this.FragmentBottomSheetPaymentSettingBinding.isFinished()) {
                    z = false;
                }
                this.scheduleImpl = z;
                startNestedScroll(2, 0);
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.MyBillsEntityDataFactory;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid pointerId=");
                            sb.append(i2);
                            sb.append(" in onInterceptTouchEvent");
                            InstrumentInjector.log_e("NestedScrollView", sb.toString());
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.DatabaseTableConfigUtil) > this.readMicros && (2 & getNestedScrollAxes()) == 0) {
                                this.scheduleImpl = true;
                                this.DatabaseTableConfigUtil = y2;
                                if (this.getSupportButtonTintMode == null) {
                                    this.getSupportButtonTintMode = VelocityTracker.obtain();
                                }
                                this.getSupportButtonTintMode.addMovement(motionEvent);
                                this.PrepareContext = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        MyBillsEntityDataFactory(motionEvent);
                    }
                }
            }
            this.scheduleImpl = false;
            this.MyBillsEntityDataFactory = -1;
            VelocityTracker velocityTracker3 = this.getSupportButtonTintMode;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.getSupportButtonTintMode = null;
            }
            if (this.FragmentBottomSheetPaymentSettingBinding.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
            }
            stopNestedScroll(0);
        }
        return this.scheduleImpl;
    }

    private boolean getAuthRequestContext(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float authRequestContext = EdgeEffectCompat.getAuthRequestContext(edgeEffect);
        float height = getHeight();
        double log = Math.log((Math.abs(-i) * 0.35f) / (this.newProxyInstance * 0.015f));
        double d = getAuthRequestContext;
        double d2 = this.newProxyInstance * 0.015f;
        Double.isNaN(d);
        Double.isNaN(d);
        double exp = Math.exp((d / (d - 1.0d)) * log);
        Double.isNaN(d2);
        return ((float) (d2 * exp)) < authRequestContext * height;
    }

    int consumeFlingInVerticalStretch(int i) {
        int height = getHeight();
        if (i > 0 && EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowTop) != 0.0f) {
            int round = Math.round(((-height) / 4.0f) * EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowTop, ((-i) * 4.0f) / height, MAX_SCROLL_FACTOR));
            if (round != i) {
                this.mEdgeGlowTop.finish();
            }
            return i - round;
        } else if (i >= 0 || EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowBottom) == 0.0f) {
            return i;
        } else {
            float f = height;
            int round2 = Math.round((f / 4.0f) * EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowBottom, (i * 4.0f) / f, MAX_SCROLL_FACTOR));
            if (round2 != i) {
                this.mEdgeGlowBottom.finish();
            }
            return i - round2;
        }
    }

    private boolean PlaceComponentResult(int i) {
        int i2;
        if (EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowTop) != 0.0f) {
            if (getAuthRequestContext(this.mEdgeGlowTop, i)) {
                this.mEdgeGlowTop.onAbsorb(i);
            } else {
                i2 = -i;
                fling(i2);
            }
        } else if (EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowBottom) == 0.0f) {
            return false;
        } else {
            i2 = -i;
            if (getAuthRequestContext(this.mEdgeGlowBottom, i2)) {
                this.mEdgeGlowBottom.onAbsorb(i2);
            }
            fling(i2);
        }
        return true;
    }

    private boolean PlaceComponentResult(MotionEvent motionEvent) {
        boolean z;
        if (EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowTop) != 0.0f) {
            EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowTop, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        if (EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowBottom) != 0.0f) {
            EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowBottom, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z;
    }

    private void MyBillsEntityDataFactory(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.MyBillsEntityDataFactory) {
            int i = actionIndex == 0 ? 1 : 0;
            this.DatabaseTableConfigUtil = (int) motionEvent.getY(i);
            this.MyBillsEntityDataFactory = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.getSupportButtonTintMode;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        boolean z;
        int i = 0;
        if (motionEvent.getAction() == 8 && !this.scheduleImpl) {
            if (MotionEventCompat.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent, 2)) {
                axisValue = motionEvent.getAxisValue(9);
            } else {
                axisValue = MotionEventCompat.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent, 4194304) ? motionEvent.getAxisValue(26) : 0.0f;
            }
            if (axisValue != 0.0f) {
                if (this.getCallingPid == 0.0f) {
                    TypedValue typedValue = new TypedValue();
                    Context context = getContext();
                    if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                    }
                    this.getCallingPid = typedValue.getDimension(context.getResources().getDisplayMetrics());
                }
                int i2 = (int) (axisValue * this.getCallingPid);
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY - i2;
                if (i3 < 0) {
                    if (PlaceComponentResult() && !MotionEventCompat.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent, 8194)) {
                        EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowTop, (-i3) / getHeight(), MAX_SCROLL_FACTOR);
                        this.mEdgeGlowTop.onRelease();
                        invalidate();
                        z = 1;
                    } else {
                        i3 = 0;
                        i = i3;
                        z = 0;
                    }
                } else {
                    if (i3 > scrollRange) {
                        if (PlaceComponentResult() && !MotionEventCompat.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent, 8194)) {
                            EdgeEffectCompat.getAuthRequestContext(this.mEdgeGlowBottom, (i3 - scrollRange) / getHeight(), MAX_SCROLL_FACTOR);
                            this.mEdgeGlowBottom.onRelease();
                            invalidate();
                            i = 1;
                        }
                        z = i;
                        i = scrollRange;
                    }
                    i = i3;
                    z = 0;
                }
                if (i != scrollY) {
                    super.scrollTo(getScrollX(), i);
                    return true;
                }
                return z;
            }
        }
        return false;
    }

    private boolean PlaceComponentResult() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L29
            if (r1 != r5) goto L27
            if (r2 != 0) goto L29
        L27:
            r2 = 0
            goto L2a
        L29:
            r2 = 1
        L2a:
            if (r1 == 0) goto L32
            if (r1 != r5) goto L30
            if (r3 != 0) goto L32
        L30:
            r1 = 0
            goto L33
        L32:
            r1 = 1
        L33:
            int r3 = r15 + r13
            if (r2 != 0) goto L39
            r2 = 0
            goto L3b
        L39:
            r2 = r19
        L3b:
            int r6 = r16 + r14
            if (r1 != 0) goto L41
            r1 = 0
            goto L43
        L41:
            r1 = r20
        L43:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L4d
            r3 = r2
            goto L50
        L4d:
            if (r3 >= r7) goto L52
            r3 = r7
        L50:
            r2 = 1
            goto L53
        L52:
            r2 = 0
        L53:
            if (r6 <= r1) goto L57
            r6 = r1
            goto L5a
        L57:
            if (r6 >= r8) goto L5c
            r6 = r8
        L5a:
            r1 = 1
            goto L5d
        L5c:
            r1 = 0
        L5d:
            if (r1 == 0) goto L7c
            boolean r7 = r12.hasNestedScrollingParent(r5)
            if (r7 != 0) goto L7c
            android.widget.OverScroller r7 = r0.FragmentBottomSheetPaymentSettingBinding
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7c:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L83
            if (r1 == 0) goto L84
        L83:
            r4 = 1
        L84:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.overScrollByCompat(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight();
            int i = layoutParams.topMargin;
            return Math.max(0, ((height + i) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    public boolean pageScroll(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.top + height > bottom) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda4.top = bottom - height;
                }
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.top = getScrollY() - height;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.top < 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4.top = 0;
            }
        }
        Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        rect.bottom = rect.top + height;
        return getAuthRequestContext(i, this.NetworkUserEntityData$$ExternalSyntheticLambda4.top, this.NetworkUserEntityData$$ExternalSyntheticLambda4.bottom);
    }

    public boolean fullScroll(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.top = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            rect.top = rect.bottom - height;
        }
        return getAuthRequestContext(i, this.NetworkUserEntityData$$ExternalSyntheticLambda4.top, this.NetworkUserEntityData$$ExternalSyntheticLambda4.bottom);
    }

    private boolean getAuthRequestContext(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = i == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else {
                        if (!z5) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            int i6 = z2 ? i2 - scrollY : i3 - i4;
            if (i6 != 0) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                    smoothScrollBy(0, i6);
                } else {
                    scrollBy(0, i6);
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && KClassImpl$Data$declaredNonStaticMembers$2(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            offsetDescendantRectToMyCoords(findNextFocus, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                    smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                } else {
                    scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                }
            }
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                maxScrollAmount = Math.min((childAt.getBottom() + layoutParams.bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            if (maxScrollAmount != 0) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                    smoothScrollBy(0, maxScrollAmount);
                } else {
                    scrollBy(0, maxScrollAmount);
                }
            }
        }
        if (findFocus != null && findFocus.isFocused() && PlaceComponentResult(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(AntDetector.SCENE_ID_LOGIN_REGIST);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    private boolean PlaceComponentResult(View view) {
        return !KClassImpl$Data$declaredNonStaticMembers$2(view, 0, getHeight());
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(View view, int i, int i2) {
        view.getDrawingRect(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        offsetDescendantRectToMyCoords(view, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4.bottom + i >= getScrollY() && this.NetworkUserEntityData$$ExternalSyntheticLambda4.top - i <= getScrollY() + i2;
    }

    public final void smoothScrollBy(int i, int i2) {
        MyBillsEntityDataFactory(i, i2, 250, false);
    }

    public final void smoothScrollBy(int i, int i2, int i3) {
        MyBillsEntityDataFactory(i, i2, i3, false);
    }

    private void MyBillsEntityDataFactory(int i, int i2, int i3, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.initRecordTimeStamp > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight();
            int i4 = layoutParams.topMargin;
            int i5 = layoutParams.bottomMargin;
            int height2 = getHeight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int scrollY = getScrollY();
            this.FragmentBottomSheetPaymentSettingBinding.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, ((height + i4) + i5) - ((height2 - paddingTop) - paddingBottom)))) - scrollY, i3);
            if (z) {
                startNestedScroll(2, 1);
            } else {
                stopNestedScroll(1);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getScrollY();
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        } else {
            if (!this.FragmentBottomSheetPaymentSettingBinding.isFinished()) {
                this.FragmentBottomSheetPaymentSettingBinding.abortAnimation();
                stopNestedScroll(1);
            }
            scrollBy(i, i2);
        }
        this.initRecordTimeStamp = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 250, false);
    }

    public final void smoothScrollTo(int i, int i2, int i3) {
        smoothScrollTo(i, i2, i3, false);
    }

    void smoothScrollTo(int i, int i2, boolean z) {
        smoothScrollTo(i, i2, 250, z);
    }

    void smoothScrollTo(int i, int i2, int i3, boolean z) {
        MyBillsEntityDataFactory(i - getScrollX(), i2 - getScrollY(), i3, z);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = marginLayoutParams.leftMargin;
        view.measure(getChildMeasureSpec(i, paddingLeft + paddingRight + i5 + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.FragmentBottomSheetPaymentSettingBinding.isFinished()) {
            return;
        }
        this.FragmentBottomSheetPaymentSettingBinding.computeScrollOffset();
        int currY = this.FragmentBottomSheetPaymentSettingBinding.getCurrY();
        int consumeFlingInVerticalStretch = consumeFlingInVerticalStretch(currY - this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = currY;
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        boolean z = false;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, consumeFlingInVerticalStretch, iArr, null, 1);
        int i = consumeFlingInVerticalStretch - this.NetworkUserEntityData$$ExternalSyntheticLambda3[1];
        int scrollRange = getScrollRange();
        if (i != 0) {
            int scrollY = getScrollY();
            overScrollByCompat(0, i, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i2 = i - scrollY2;
            int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i2, this.NetworkUserEntityData$$ExternalSyntheticLambda5, 1, iArr2);
            i = i2 - this.NetworkUserEntityData$$ExternalSyntheticLambda3[1];
        }
        if (i != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                if (i < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.FragmentBottomSheetPaymentSettingBinding.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.FragmentBottomSheetPaymentSettingBinding.getCurrVelocity());
                }
            }
            this.FragmentBottomSheetPaymentSettingBinding.abortAnimation();
            stopNestedScroll(1);
        }
        if (!this.FragmentBottomSheetPaymentSettingBinding.isFinished()) {
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        } else {
            stopNestedScroll(1);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        view.getDrawingRect(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        offsetDescendantRectToMyCoords(view, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean MyBillsEntityDataFactory(Rect rect, boolean z) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i4;
            }
            return Math.min(i2 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        } else if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        } else {
            if (rect.height() > height) {
                i = 0 - (i4 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            return Math.max(i, -getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.moveToNextValue) {
            KClassImpl$Data$declaredNonStaticMembers$2(view2);
        } else {
            this.lookAheadTest = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || PlaceComponentResult(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return MyBillsEntityDataFactory(rect, z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.moveToNextValue = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int i6 = 0;
        this.moveToNextValue = false;
        View view = this.lookAheadTest;
        if (view != null && KClassImpl$Data$declaredNonStaticMembers$2(view, this)) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
        }
        this.lookAheadTest = null;
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
                scrollTo(getScrollX(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory);
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i5 = 0;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int scrollY = getScrollY();
            int i7 = ((i4 - i2) - paddingTop) - paddingBottom;
            if (i7 < i5 && scrollY >= 0) {
                i6 = i7 + scrollY > i5 ? i5 - i7 : scrollY;
            }
            if (i6 != scrollY) {
                scrollTo(getScrollX(), i6);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !KClassImpl$Data$declaredNonStaticMembers$2(findFocus, 0, i4)) {
            return;
        }
        findFocus.getDrawingRect(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        offsetDescendantRectToMyCoords(findFocus, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && KClassImpl$Data$declaredNonStaticMembers$2((View) parent, view2);
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            this.FragmentBottomSheetPaymentSettingBinding.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            startNestedScroll(2, 1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getScrollY();
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
    }

    private void getAuthRequestContext() {
        this.scheduleImpl = false;
        VelocityTracker velocityTracker = this.getSupportButtonTintMode;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.getSupportButtonTintMode = null;
        }
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = getWidth();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = childAt.getWidth();
            int i3 = layoutParams.leftMargin;
            int i4 = layoutParams.rightMargin;
            int height = getHeight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height2 = childAt.getHeight();
            int i5 = layoutParams.topMargin;
            int i6 = layoutParams.bottomMargin;
            int i7 = (width - paddingLeft) - paddingRight;
            int i8 = width2 + i3 + i4;
            if (i7 >= i8 || i < 0) {
                i = 0;
            } else if (i7 + i > i8) {
                i = i8 - i7;
            }
            int i9 = (height - paddingTop) - paddingBottom;
            int i10 = height2 + i5 + i6;
            if (i9 >= i10 || i2 < 0) {
                i2 = 0;
            } else if (i9 + i2 > i10) {
                i2 = i10 - i9;
            }
            if (i == getScrollX() && i2 == getScrollY()) {
                return;
            }
            super.scrollTo(i, i2);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        fsSuperDraw_525147df17cfa12d62e03b9c86575ca7(canvas);
        int scrollY = getScrollY();
        int i = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft() + 0;
            } else {
                paddingLeft = 0;
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(paddingLeft, min);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
            }
            canvas.restoreToCount(save);
        }
        if (this.mEdgeGlowBottom.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
            width2 -= getPaddingLeft() + getPaddingRight();
            i = 0 + getPaddingLeft();
        }
        if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
            height2 -= getPaddingTop() + getPaddingBottom();
            max -= getPaddingBottom();
        }
        canvas.translate(i - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        this.mEdgeGlowBottom.setSize(width2, height2);
        if (this.mEdgeGlowBottom.draw(canvas)) {
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.BuiltInFictitiousFunctionClassFactory = getScrollY();
        return savedState;
    }

    /* loaded from: classes3.dex */
    static class SavedState extends View.BaseSavedState {
        public int BuiltInFictitiousFunctionClassFactory;
        public static final byte[] PlaceComponentResult = {1, 78, 11, -6, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int getAuthRequestContext = 179;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, byte r8, int r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 15
                int r7 = 18 - r7
                int r9 = r9 * 4
                int r9 = 16 - r9
                int r8 = 106 - r8
                byte[] r0 = androidx.core.widget.NestedScrollView.SavedState.PlaceComponentResult
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L35
            L17:
                r3 = 0
            L18:
                r6 = r9
                r9 = r8
                r8 = r6
                int r4 = r3 + 1
                int r7 = r7 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r8) goto L2c
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2c:
                r3 = r0[r7]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L35:
                int r8 = -r8
                int r10 = r10 + r8
                int r8 = r10 + 2
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.SavedState.a(byte, byte, int, java.lang.Object[]):void");
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HorizontalScrollView.SavedState{");
            try {
                Object[] objArr = {this};
                byte b = (byte) (PlaceComponentResult[0] - 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = PlaceComponentResult[0];
                byte b4 = b3;
                Object[] objArr3 = new Object[1];
                a(b3, b4, (byte) (b4 - 1), objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append(" scrollPosition=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append("}");
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled()) {
                int height = nestedScrollView.getHeight();
                Rect rect = new Rect();
                if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                    height = rect.height();
                }
                if (i != 4096) {
                    if (i == 8192 || i == 16908344) {
                        int paddingBottom = nestedScrollView.getPaddingBottom();
                        int max = Math.max(nestedScrollView.getScrollY() - ((height - paddingBottom) - nestedScrollView.getPaddingTop()), 0);
                        if (max != nestedScrollView.getScrollY()) {
                            nestedScrollView.smoothScrollTo(0, max, true);
                            return true;
                        }
                        return false;
                    } else if (i != 16908346) {
                        return false;
                    }
                }
                int paddingBottom2 = nestedScrollView.getPaddingBottom();
                int paddingTop = nestedScrollView.getPaddingTop();
                int min = Math.min(nestedScrollView.getScrollY() + ((height - paddingBottom2) - paddingTop), nestedScrollView.getScrollRange());
                if (min != nestedScrollView.getScrollY()) {
                    nestedScrollView.smoothScrollTo(0, min, true);
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.PlaceComponentResult(AccessibilityNodeInfoCompat.AccessibilityActionCompat.getCallingPid);
                accessibilityNodeInfoCompat.PlaceComponentResult(AccessibilityNodeInfoCompat.AccessibilityActionCompat.getValueOfTouchPositionAbsolute);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.PlaceComponentResult(AccessibilityNodeInfoCompat.AccessibilityActionCompat.C);
                accessibilityNodeInfoCompat.PlaceComponentResult(AccessibilityNodeInfoCompat.AccessibilityActionCompat.VerifyPinStateManager$executeRiskChallenge$2$1);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.MyBillsEntityDataFactory(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.PlaceComponentResult(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }

    /* loaded from: classes3.dex */
    static class Api21Impl {
        private Api21Impl() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0238  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 719
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.getSupportButtonTintMode) != null) {
            velocityTracker.recycle();
            this.getSupportButtonTintMode = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }
}
