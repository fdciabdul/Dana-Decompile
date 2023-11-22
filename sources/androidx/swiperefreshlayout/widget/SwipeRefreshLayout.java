package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.widget.ListViewCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    private static final String BuiltInFictitiousFunctionClassFactory = "SwipeRefreshLayout";
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final int LARGE = 0;
    private static final int[] getAuthRequestContext = {16842766};
    private int DatabaseTableConfigUtil;
    private Animation.AnimationListener FragmentBottomSheetPaymentSettingBinding;
    private final DecelerateInterpolator GetContactSyncConfig;
    private Animation KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private final Animation NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Animation NetworkUserEntityData$$ExternalSyntheticLambda3;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    private Animation NetworkUserEntityData$$ExternalSyntheticLambda5;
    private Animation NetworkUserEntityData$$ExternalSyntheticLambda6;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Animation PlaceComponentResult;
    private final NestedScrollingParentHelper PrepareContext;
    private View SubSequence;
    private int getCallingPid;
    private final Animation getErrorConfigVersion;
    private float getSupportButtonTintMode;
    private float initRecordTimeStamp;
    private final int[] isLayoutRequested;
    private int lookAheadTest;
    CircleImageView mCircleView;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    protected int mFrom;
    OnRefreshListener mListener;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    CircularProgressDrawable mProgress;
    boolean mRefreshing;
    boolean mScale;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    boolean mUsingCustomStart;
    private int moveToNextValue;
    private final NestedScrollingChildHelper newProxyInstance;
    private float readMicros;
    private OnChildScrollUpCallback scheduleImpl;

    /* loaded from: classes3.dex */
    public interface OnChildScrollUpCallback {
        boolean BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes3.dex */
    public interface OnRefreshListener {
        void MyBillsEntityDataFactory();
    }

    void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        this.mCircleView.getBackground().setAlpha(255);
        this.mProgress.setAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        reset();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.mScale = z;
        this.mOriginalOffsetTop = i;
        this.mSpinnerOffsetEnd = i2;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.mSpinnerOffsetEnd = i;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setSlingshotDistance(int i) {
        this.mCustomSlingshotDistance = i;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.moveToNextValue = (int) (displayMetrics.density * 56.0f);
            } else {
                this.moveToNextValue = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.MyBillsEntityDataFactory(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.readMicros = -1.0f;
        this.isLayoutRequested = new int[2];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new int[2];
        this.MyBillsEntityDataFactory = -1;
        this.lookAheadTest = -1;
        this.FragmentBottomSheetPaymentSettingBinding = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.mRefreshing) {
                    SwipeRefreshLayout.this.mProgress.setAlpha(255);
                    SwipeRefreshLayout.this.mProgress.start();
                    if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null) {
                        SwipeRefreshLayout.this.mListener.MyBillsEntityDataFactory();
                    }
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    swipeRefreshLayout.mCurrentTargetOffsetTop = swipeRefreshLayout.mCircleView.getTop();
                    return;
                }
                SwipeRefreshLayout.this.reset();
            }
        };
        this.getErrorConfigVersion = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                int i;
                if (!SwipeRefreshLayout.this.mUsingCustomStart) {
                    i = SwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop);
                } else {
                    i = SwipeRefreshLayout.this.mSpinnerOffsetEnd;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.mFrom + ((int) ((i - SwipeRefreshLayout.this.mFrom) * f))) - SwipeRefreshLayout.this.mCircleView.getTop());
                CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.mProgress;
                float f2 = 1.0f - f;
                CircularProgressDrawable.Ring ring = circularProgressDrawable.MyBillsEntityDataFactory;
                if (f2 != ring.PlaceComponentResult) {
                    ring.PlaceComponentResult = f2;
                }
                circularProgressDrawable.invalidateSelf();
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.getCallingPid = ViewConfiguration.get(context).getScaledTouchSlop();
        this.DatabaseTableConfigUtil = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.GetContactSyncConfig = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.moveToNextValue = (int) (displayMetrics.density * 40.0f);
        this.mCircleView = new CircleImageView(getContext());
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.mProgress = circularProgressDrawable;
        circularProgressDrawable.MyBillsEntityDataFactory(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.mSpinnerOffsetEnd = i;
        this.readMicros = i;
        this.PrepareContext = new NestedScrollingParentHelper();
        this.newProxyInstance = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.moveToNextValue;
        this.mCurrentTargetOffsetTop = i2;
        this.mOriginalOffsetTop = i2;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, getAuthRequestContext);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.lookAheadTest;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.mRefreshing != z) {
            this.mRefreshing = z;
            if (!this.mUsingCustomStart) {
                i = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
            } else {
                i = this.mSpinnerOffsetEnd;
            }
            setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop);
            this.mNotify = false;
            Animation.AnimationListener animationListener = this.FragmentBottomSheetPaymentSettingBinding;
            this.mCircleView.setVisibility(0);
            this.mProgress.setAlpha(255);
            Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
                @Override // android.view.animation.Animation
                public void applyTransformation(float f, Transformation transformation) {
                    SwipeRefreshLayout.this.setAnimationProgress(f);
                }
            };
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = animation;
            animation.setDuration(this.DatabaseTableConfigUtil);
            if (animationListener != null) {
                this.mCircleView.setAnimationListener(animationListener);
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            return;
        }
        getAuthRequestContext(z, false);
    }

    void setAnimationProgress(float f) {
        this.mCircleView.setScaleX(f);
        this.mCircleView.setScaleY(f);
    }

    private void getAuthRequestContext(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            KClassImpl$Data$declaredNonStaticMembers$2();
            this.mRefreshing = z;
            if (z) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.mCurrentTargetOffsetTop, this.FragmentBottomSheetPaymentSettingBinding);
            } else {
                startScaleDownAnimation(this.FragmentBottomSheetPaymentSettingBinding);
            }
        }
    }

    void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = animation;
        animation.setDuration(150L);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
    }

    private Animation PlaceComponentResult(final int i, final int i2) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.mProgress.setAlpha((int) (i + ((i2 - r0) * f)));
            }
        };
        animation.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(animation);
        return animation;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.BuiltInFictitiousFunctionClassFactory(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        CircularProgressDrawable.Ring ring = circularProgressDrawable.MyBillsEntityDataFactory;
        ring.getErrorConfigVersion = iArr;
        ring.lookAheadTest = 0;
        ring.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring.getErrorConfigVersion[0];
        CircularProgressDrawable.Ring ring2 = circularProgressDrawable.MyBillsEntityDataFactory;
        ring2.lookAheadTest = 0;
        ring2.NetworkUserEntityData$$ExternalSyntheticLambda0 = ring2.getErrorConfigVersion[0];
        circularProgressDrawable.invalidateSelf();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.SubSequence == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.SubSequence = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.readMicros = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.SubSequence == null) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        View view = this.SubSequence;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingLeft2 = getPaddingLeft();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - paddingLeft2) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        CircleImageView circleImageView = this.mCircleView;
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.mCurrentTargetOffsetTop;
        circleImageView.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.SubSequence == null) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        View view = this.SubSequence;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.moveToNextValue, 1073741824), View.MeasureSpec.makeMeasureSpec(this.moveToNextValue, 1073741824));
        this.lookAheadTest = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.mCircleView) {
                this.lookAheadTest = i3;
                return;
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.moveToNextValue;
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.scheduleImpl;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.BuiltInFictitiousFunctionClassFactory();
        }
        View view = this.SubSequence;
        if (view instanceof ListView) {
            return ListViewCompat.MyBillsEntityDataFactory((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.scheduleImpl = onChildScrollUpCallback;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        int actionMasked = motionEvent.getActionMasked();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 && actionMasked == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        }
        if (!isEnabled() || this.NetworkUserEntityData$$ExternalSyntheticLambda4 || canChildScrollUp() || this.mRefreshing || this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.MyBillsEntityDataFactory = pointerId;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            int findPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = motionEvent.getY(findPointerIndex);
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.MyBillsEntityDataFactory;
                    if (i == -1) {
                        InstrumentInjector.log_e(BuiltInFictitiousFunctionClassFactory, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(i);
                    if (findPointerIndex2 < 0) {
                        return false;
                    }
                    getAuthRequestContext(motionEvent.getY(findPointerIndex2));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        getAuthRequestContext(motionEvent);
                    }
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            this.MyBillsEntityDataFactory = -1;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.SubSequence instanceof AbsListView)) {
            View view = this.SubSequence;
            if (view == null || ViewCompat.getOnBoardingScenario(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.NetworkUserEntityData$$ExternalSyntheticLambda4 || this.mRefreshing || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        startNestedScroll(i & 2);
        this.getSupportButtonTintMode = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.getSupportButtonTintMode;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.getSupportButtonTintMode = 0.0f;
                } else {
                    this.getSupportButtonTintMode = f - f2;
                    iArr[1] = i2;
                }
                MyBillsEntityDataFactory(this.getSupportButtonTintMode);
            }
        }
        if (this.mUsingCustomStart && i2 > 0 && this.getSupportButtonTintMode == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.isLayoutRequested;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.PrepareContext;
        return nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory | nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        float f = this.getSupportButtonTintMode;
        if (f > 0.0f) {
            PlaceComponentResult(f);
            this.getSupportButtonTintMode = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        if (i4 + this.NetworkUserEntityData$$ExternalSyntheticLambda8[1] >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.getSupportButtonTintMode + Math.abs(r11);
        this.getSupportButtonTintMode = abs;
        MyBillsEntityDataFactory(abs);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.newProxyInstance;
        if (nestedScrollingChildHelper.PlaceComponentResult) {
            ViewCompat.F(nestedScrollingChildHelper.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        nestedScrollingChildHelper.PlaceComponentResult = z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.newProxyInstance.MyBillsEntityDataFactory();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.newProxyInstance.PlaceComponentResult(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.newProxyInstance;
        ViewParent viewParent = nestedScrollingChildHelper.getAuthRequestContext;
        if (viewParent != null) {
            ViewParentCompat.BuiltInFictitiousFunctionClassFactory(viewParent, nestedScrollingChildHelper.KClassImpl$Data$declaredNonStaticMembers$2, 0);
            nestedScrollingChildHelper.getAuthRequestContext = null;
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.newProxyInstance.getAuthRequestContext();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.newProxyInstance.BuiltInFictitiousFunctionClassFactory(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, iArr, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.newProxyInstance.PlaceComponentResult(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.newProxyInstance.getAuthRequestContext(f, f2);
    }

    private static boolean MyBillsEntityDataFactory(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void MyBillsEntityDataFactory(float f) {
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        CircularProgressDrawable.Ring ring = circularProgressDrawable.MyBillsEntityDataFactory;
        if (!ring.DatabaseTableConfigUtil) {
            ring.DatabaseTableConfigUtil = true;
        }
        circularProgressDrawable.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f / this.readMicros));
        double d = min;
        Double.isNaN(d);
        float max = (Math.max((float) (d - 0.4d), 0.0f) * 5.0f) / 3.0f;
        float abs = Math.abs(f);
        float f2 = this.readMicros;
        int i = this.mCustomSlingshotDistance;
        if (i <= 0) {
            i = this.mUsingCustomStart ? this.mSpinnerOffsetEnd - this.mOriginalOffsetTop : this.mSpinnerOffsetEnd;
        }
        float f3 = i;
        double max2 = Math.max(0.0f, Math.min(abs - f2, f3 * 2.0f) / f3) / 4.0f;
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f4 = ((float) (max2 - pow)) * 2.0f;
        int i2 = this.mOriginalOffsetTop;
        int i3 = (int) ((min * f3) + (f3 * f4 * 2.0f));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f / this.readMicros));
        }
        if (f < this.readMicros) {
            if (this.mProgress.getAlpha() > 76 && !MyBillsEntityDataFactory(this.PlaceComponentResult)) {
                this.PlaceComponentResult = PlaceComponentResult(this.mProgress.getAlpha(), 76);
            }
        } else if (this.mProgress.getAlpha() < 255 && !MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult(this.mProgress.getAlpha(), 255);
        }
        CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
        float min2 = Math.min(0.8f, max * 0.8f);
        circularProgressDrawable2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
        circularProgressDrawable2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = min2;
        circularProgressDrawable2.invalidateSelf();
        CircularProgressDrawable circularProgressDrawable3 = this.mProgress;
        float min3 = Math.min(1.0f, max);
        CircularProgressDrawable.Ring ring2 = circularProgressDrawable3.MyBillsEntityDataFactory;
        if (min3 != ring2.PlaceComponentResult) {
            ring2.PlaceComponentResult = min3;
        }
        circularProgressDrawable3.invalidateSelf();
        CircularProgressDrawable circularProgressDrawable4 = this.mProgress;
        circularProgressDrawable4.MyBillsEntityDataFactory.initRecordTimeStamp = (((max * 0.4f) - 0.25f) + (f4 * 2.0f)) * 0.5f;
        circularProgressDrawable4.invalidateSelf();
        setTargetOffsetTopAndBottom((i2 + i3) - this.mCurrentTargetOffsetTop);
    }

    private void PlaceComponentResult(float f) {
        if (f > this.readMicros) {
            getAuthRequestContext(true, true);
            return;
        }
        this.mRefreshing = false;
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        circularProgressDrawable.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
        circularProgressDrawable.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        circularProgressDrawable.invalidateSelf();
        Animation.AnimationListener animationListener = this.mScale ? null : new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.mScale) {
                    return;
                }
                SwipeRefreshLayout.this.startScaleDownAnimation(null);
            }
        };
        int i = this.mCurrentTargetOffsetTop;
        if (!this.mScale) {
            this.mFrom = i;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.reset();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setDuration(200L);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setInterpolator(this.GetContactSyncConfig);
            if (animationListener != null) {
                this.mCircleView.setAnimationListener(animationListener);
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        } else {
            this.mFrom = i;
            this.mStartingScale = this.mCircleView.getScaleX();
            Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.8
                @Override // android.view.animation.Animation
                public void applyTransformation(float f2, Transformation transformation) {
                    SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.mStartingScale + ((-SwipeRefreshLayout.this.mStartingScale) * f2));
                    SwipeRefreshLayout.this.moveToStart(f2);
                }
            };
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = animation;
            animation.setDuration(150L);
            if (animationListener != null) {
                this.mCircleView.setAnimationListener(animationListener);
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        }
        CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
        CircularProgressDrawable.Ring ring = circularProgressDrawable2.MyBillsEntityDataFactory;
        if (ring.DatabaseTableConfigUtil) {
            ring.DatabaseTableConfigUtil = false;
        }
        circularProgressDrawable2.invalidateSelf();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 && actionMasked == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        }
        if (!isEnabled() || this.NetworkUserEntityData$$ExternalSyntheticLambda4 || canChildScrollUp() || this.mRefreshing || this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            return false;
        }
        if (actionMasked == 0) {
            this.MyBillsEntityDataFactory = motionEvent.getPointerId(0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.MyBillsEntityDataFactory);
            if (findPointerIndex < 0) {
                InstrumentInjector.log_e(BuiltInFictitiousFunctionClassFactory, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                float y = motionEvent.getY(findPointerIndex);
                float f = this.initRecordTimeStamp;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                PlaceComponentResult((y - f) * 0.5f);
            }
            this.MyBillsEntityDataFactory = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.MyBillsEntityDataFactory);
            if (findPointerIndex2 < 0) {
                InstrumentInjector.log_e(BuiltInFictitiousFunctionClassFactory, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            getAuthRequestContext(y2);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                float f2 = (y2 - this.initRecordTimeStamp) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                MyBillsEntityDataFactory(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    InstrumentInjector.log_e(BuiltInFictitiousFunctionClassFactory, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.MyBillsEntityDataFactory = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                getAuthRequestContext(motionEvent);
            }
        }
        return true;
    }

    private void getAuthRequestContext(float f) {
        float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        float f3 = f - f2;
        float f4 = this.getCallingPid;
        if (f3 <= f4 || this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        this.initRecordTimeStamp = f2 + f4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.mProgress.setAlpha(76);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.getErrorConfigVersion.reset();
        this.getErrorConfigVersion.setDuration(200L);
        this.getErrorConfigVersion.setInterpolator(this.GetContactSyncConfig);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.getErrorConfigVersion);
    }

    void moveToStart(float f) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f))) - this.mCircleView.getTop());
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.mCircleView.bringToFront();
        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) this.mCircleView, i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private void getAuthRequestContext(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.MyBillsEntityDataFactory) {
            this.MyBillsEntityDataFactory = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
