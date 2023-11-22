package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* loaded from: classes6.dex */
public class SlidingPaneLayout extends ViewGroup implements Openable, FSDraw, FSDispatchDraw {
    public static final int LOCK_MODE_LOCKED = 3;
    public static final int LOCK_MODE_LOCKED_CLOSED = 2;
    public static final int LOCK_MODE_LOCKED_OPEN = 1;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static boolean PlaceComponentResult;
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final List<PanelSlideListener> DatabaseTableConfigUtil;
    private FoldingFeatureObserver.OnFoldingFeatureChangeListener GetContactSyncConfig;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Drawable PrepareContext;
    private boolean getAuthRequestContext;
    private int getErrorConfigVersion;
    private PanelSlideListener initRecordTimeStamp;
    private Field isLayoutRequested;
    private float lookAheadTest;
    final ViewDragHelper mDragHelper;
    FoldingFeature mFoldingFeature;
    boolean mIsUnableToDrag;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private FoldingFeatureObserver moveToNextValue;
    private int newProxyInstance;
    private Method scheduleImpl;

    /* loaded from: classes6.dex */
    public interface PanelSlideListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(View view);

        void PlaceComponentResult(View view);

        void getAuthRequestContext(View view);
    }

    /* loaded from: classes6.dex */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public final void PlaceComponentResult(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public final void getAuthRequestContext(View view) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_6891225ba9c0ee2e204cfe11dc18bc31(canvas);
    }

    public void fsSuperDispatchDraw_6891225ba9c0ee2e204cfe11dc18bc31(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_6891225ba9c0ee2e204cfe11dc18bc31(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public void fsSuperDraw_6891225ba9c0ee2e204cfe11dc18bc31(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    static {
        PlaceComponentResult = Build.VERSION.SDK_INT >= 29;
    }

    public final void setLockMode(int i) {
        this.getErrorConfigVersion = i;
    }

    public final int getLockMode() {
        return this.getErrorConfigVersion;
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.newProxyInstance = 0;
        this.mSlideOffset = 1.0f;
        this.DatabaseTableConfigUtil = new CopyOnWriteArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        this.GetContactSyncConfig = new FoldingFeatureObserver.OnFoldingFeatureChangeListener() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.1
            @Override // androidx.slidingpanelayout.widget.FoldingFeatureObserver.OnFoldingFeatureChangeListener
            public final void PlaceComponentResult(FoldingFeature foldingFeature) {
                SlidingPaneLayout.this.mFoldingFeature = foldingFeature;
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(300L);
                changeBounds.setInterpolator(PathInterpolatorCompat.KClassImpl$Data$declaredNonStaticMembers$2(0.2f, 0.0f, 0.0f, 1.0f));
                TransitionManager.getAuthRequestContext(SlidingPaneLayout.this, changeBounds);
                SlidingPaneLayout.this.requestLayout();
            }
        };
        float f = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.MyBillsEntityDataFactory(this, new AccessibilityDelegate());
        ViewCompat.moveToNextValue((View) this, 1);
        ViewDragHelper MyBillsEntityDataFactory = ViewDragHelper.MyBillsEntityDataFactory(this, 0.5f, new DragHelperCallback());
        this.mDragHelper = MyBillsEntityDataFactory;
        MyBillsEntityDataFactory.moveToNextValue = f * 400.0f;
        FoldingFeatureObserver foldingFeatureObserver = new FoldingFeatureObserver(WindowInfoTracker.CC.PlaceComponentResult(context), ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context));
        this.moveToNextValue = foldingFeatureObserver;
        FoldingFeatureObserver.OnFoldingFeatureChangeListener onFoldingFeatureChangeListener = this.GetContactSyncConfig;
        Intrinsics.checkNotNullParameter(onFoldingFeatureChangeListener, "");
        foldingFeatureObserver.getAuthRequestContext = onFoldingFeatureChangeListener;
    }

    public void setParallaxDistance(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Deprecated
    public void setSliderFadeColor(int i) {
        this.newProxyInstance = i;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.newProxyInstance;
    }

    @Deprecated
    public void setCoveredFadeColor(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.MyBillsEntityDataFactory;
    }

    @Deprecated
    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        PanelSlideListener panelSlideListener2 = this.initRecordTimeStamp;
        if (panelSlideListener2 != null) {
            removePanelSlideListener(panelSlideListener2);
        }
        if (panelSlideListener != null) {
            addPanelSlideListener(panelSlideListener);
        }
        this.initRecordTimeStamp = panelSlideListener;
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.DatabaseTableConfigUtil.add(panelSlideListener);
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        this.DatabaseTableConfigUtil.remove(panelSlideListener);
    }

    void dispatchOnPanelSlide(View view) {
        Iterator<PanelSlideListener> it = this.DatabaseTableConfigUtil.iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult(view);
        }
    }

    void dispatchOnPanelOpened(View view) {
        Iterator<PanelSlideListener> it = this.DatabaseTableConfigUtil.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelClosed(View view) {
        Iterator<PanelSlideListener> it = this.DatabaseTableConfigUtil.iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext(view);
        }
        sendAccessibilityEvent(32);
    }

    void updateObscuredViewsVisibility(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        boolean z;
        int i5;
        int i6;
        int i7;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int width = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight();
        int paddingBottom = getPaddingBottom();
        if (view2 == null || !PlaceComponentResult(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount && (childAt = getChildAt(i8)) != view2) {
            if (childAt.getVisibility() != 8) {
                int max = Math.max(isLayoutRtlSupport ? paddingLeft : width, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                z = isLayoutRtlSupport;
                if (isLayoutRtlSupport) {
                    i7 = width;
                    i5 = i7;
                } else {
                    i5 = width;
                    i7 = paddingLeft;
                }
                i6 = paddingLeft;
                childAt.setVisibility((max < i || max2 < i3 || Math.min(i7, childAt.getRight()) > i2 || Math.min(height - paddingBottom, childAt.getBottom()) > i4) ? 0 : 4);
            } else {
                z = isLayoutRtlSupport;
                i5 = width;
                i6 = paddingLeft;
            }
            i8++;
            view2 = view;
            isLayoutRtlSupport = z;
            width = i5;
            paddingLeft = i6;
        }
    }

    void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean PlaceComponentResult(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new TouchBlocker(view), i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view.getParent() instanceof TouchBlocker) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Activity activity;
        Job launch$default;
        super.onAttachedToWindow();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.moveToNextValue != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                FoldingFeatureObserver foldingFeatureObserver = this.moveToNextValue;
                Intrinsics.checkNotNullParameter(activity, "");
                Job job = foldingFeatureObserver.MyBillsEntityDataFactory;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(foldingFeatureObserver.BuiltInFictitiousFunctionClassFactory)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(foldingFeatureObserver, activity, null), 3, null);
                foldingFeatureObserver.MyBillsEntityDataFactory = launch$default;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Job job;
        super.onDetachedFromWindow();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        FoldingFeatureObserver foldingFeatureObserver = this.moveToNextValue;
        if (foldingFeatureObserver != null && (job = foldingFeatureObserver.MyBillsEntityDataFactory) != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
    
        if (r7.width != 0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019c  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v29 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r21, int r22) {
        /*
            Method dump skipped, instructions count: 828
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int i9 = i3 - i;
        int paddingRight = isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.mSlideOffset = (this.getAuthRequestContext && this.mPreservedOpenState) ? 0.0f : 1.0f;
        }
        int i10 = paddingRight;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.BuiltInFictitiousFunctionClassFactory) {
                    int i12 = i9 - paddingLeft;
                    int min = (Math.min(paddingRight, i12) - i10) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = min;
                    int i13 = isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = ((i10 + i13) + min) + (measuredWidth / 2) > i12;
                    int i14 = (int) (min * this.mSlideOffset);
                    this.mSlideOffset = i14 / this.mSlideRange;
                    i10 += i13 + i14;
                    i5 = 0;
                } else if (!this.getAuthRequestContext || (i6 = this.NetworkUserEntityData$$ExternalSyntheticLambda2) == 0) {
                    i10 = paddingRight;
                    i5 = 0;
                } else {
                    i5 = (int) ((1.0f - this.mSlideOffset) * i6);
                    i10 = paddingRight;
                }
                if (isLayoutRtlSupport) {
                    i8 = (i9 - i10) + i5;
                    i7 = i8 - measuredWidth;
                } else {
                    i7 = i10 - i5;
                    i8 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                FoldingFeature foldingFeature = this.mFoldingFeature;
                paddingRight += childAt.getWidth() + Math.abs((foldingFeature != null && foldingFeature.BuiltInFictitiousFunctionClassFactory() == FoldingFeature.Orientation.getAuthRequestContext && this.mFoldingFeature.KClassImpl$Data$declaredNonStaticMembers$2()) ? this.mFoldingFeature.getAuthRequestContext().width() : 0);
            }
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (this.getAuthRequestContext && this.NetworkUserEntityData$$ExternalSyntheticLambda2 != 0) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.mSlideOffset);
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.getAuthRequestContext) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.getAuthRequestContext && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = ViewDragHelper.PlaceComponentResult(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.getAuthRequestContext || (this.mIsUnableToDrag && actionMasked != 0)) {
            ViewDragHelper viewDragHelper = this.mDragHelper;
            viewDragHelper.MyBillsEntityDataFactory = -1;
            viewDragHelper.PlaceComponentResult();
            VelocityTracker velocityTracker = viewDragHelper.scheduleImpl;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                viewDragHelper.scheduleImpl = null;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            ViewDragHelper viewDragHelper2 = this.mDragHelper;
            viewDragHelper2.MyBillsEntityDataFactory = -1;
            viewDragHelper2.PlaceComponentResult();
            VelocityTracker velocityTracker2 = viewDragHelper2.scheduleImpl;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                viewDragHelper2.scheduleImpl = null;
            }
            return false;
        } else {
            if (actionMasked == 0) {
                this.mIsUnableToDrag = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.lookAheadTest = x;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = y;
                if (ViewDragHelper.PlaceComponentResult(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                    z = true;
                    return this.mDragHelper.MyBillsEntityDataFactory(motionEvent) || z;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.lookAheadTest);
                float abs2 = Math.abs(y2 - this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                if (abs > this.mDragHelper.lookAheadTest && abs2 > abs) {
                    ViewDragHelper viewDragHelper3 = this.mDragHelper;
                    viewDragHelper3.MyBillsEntityDataFactory = -1;
                    viewDragHelper3.PlaceComponentResult();
                    VelocityTracker velocityTracker3 = viewDragHelper3.scheduleImpl;
                    if (velocityTracker3 != null) {
                        velocityTracker3.recycle();
                        viewDragHelper3.scheduleImpl = null;
                    }
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
            z = false;
            if (this.mDragHelper.MyBillsEntityDataFactory(motionEvent)) {
                return true;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.getAuthRequestContext) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.lookAheadTest = x;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = y;
        } else if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.lookAheadTest;
            float f2 = y2 - this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i = this.mDragHelper.lookAheadTest;
            if ((f * f) + (f2 * f2) < i * i && ViewDragHelper.PlaceComponentResult(this.mSlideableView, (int) x2, (int) y2)) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }
        return true;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        if (!this.getAuthRequestContext) {
            this.mPreservedOpenState = false;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 || smoothSlideTo(1.0f, 0)) {
            this.mPreservedOpenState = false;
            return true;
        }
        return false;
    }

    private boolean MyBillsEntityDataFactory() {
        if (!this.getAuthRequestContext) {
            this.mPreservedOpenState = true;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 || smoothSlideTo(0.0f, 0)) {
            this.mPreservedOpenState = true;
            return true;
        }
        return false;
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openPane();
    }

    public boolean openPane() {
        return MyBillsEntityDataFactory();
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        closePane();
    }

    public boolean closePane() {
        return BuiltInFictitiousFunctionClassFactory();
    }

    public boolean isOpen() {
        return !this.getAuthRequestContext || this.mSlideOffset == 0.0f;
    }

    @Deprecated
    public boolean canSlide() {
        return this.getAuthRequestContext;
    }

    public boolean isSlideable() {
        return this.getAuthRequestContext;
    }

    void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = (i - ((isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin))) / this.mSlideRange;
        this.mSlideOffset = paddingRight;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 != 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(paddingRight);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        WindowInsetsCompat NetworkUserEntityData$$ExternalSyntheticLambda3;
        WindowInsetsCompat NetworkUserEntityData$$ExternalSyntheticLambda32;
        Insets insets = null;
        if (isLayoutRtlSupport() ^ isOpen()) {
            this.mDragHelper.getErrorConfigVersion = 1;
            if (PlaceComponentResult && (NetworkUserEntityData$$ExternalSyntheticLambda32 = ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda3(this)) != null) {
                insets = NetworkUserEntityData$$ExternalSyntheticLambda32.scheduleImpl();
            }
            if (insets != null) {
                ViewDragHelper viewDragHelper = this.mDragHelper;
                viewDragHelper.getAuthRequestContext = Math.max(viewDragHelper.KClassImpl$Data$declaredNonStaticMembers$2, insets.PlaceComponentResult);
            }
        } else {
            this.mDragHelper.getErrorConfigVersion = 2;
            if (PlaceComponentResult && (NetworkUserEntityData$$ExternalSyntheticLambda3 = ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda3(this)) != null) {
                insets = NetworkUserEntityData$$ExternalSyntheticLambda3.scheduleImpl();
            }
            if (insets != null) {
                ViewDragHelper viewDragHelper2 = this.mDragHelper;
                viewDragHelper2.getAuthRequestContext = Math.max(viewDragHelper2.KClassImpl$Data$declaredNonStaticMembers$2, insets.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.getAuthRequestContext && !layoutParams.BuiltInFictitiousFunctionClassFactory && this.mSlideableView != null) {
            canvas.getClipBounds(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            if (isLayoutRtlSupport()) {
                Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        boolean fsSuperDrawChild_6891225ba9c0ee2e204cfe11dc18bc31 = fsSuperDrawChild_6891225ba9c0ee2e204cfe11dc18bc31(canvas, view, j);
        canvas.restoreToCount(save);
        return fsSuperDrawChild_6891225ba9c0ee2e204cfe11dc18bc31;
    }

    void invalidateChildRegion(View view) {
        Field field;
        if (Build.VERSION.SDK_INT >= 17) {
            ViewCompat.PlaceComponentResult(view, ((LayoutParams) view.getLayoutParams()).PlaceComponentResult);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.BuiltInFictitiousFunctionClassFactory) {
                try {
                    this.scheduleImpl = View.class.getDeclaredMethod("getDisplayList", null);
                } catch (NoSuchMethodException e) {
                    InstrumentInjector.log_e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
                }
                try {
                    Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                    this.isLayoutRequested = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    InstrumentInjector.log_e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.BuiltInFictitiousFunctionClassFactory = true;
            }
            if (this.scheduleImpl == null || (field = this.isLayoutRequested) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.scheduleImpl.invoke(view, null);
            } catch (Exception e3) {
                InstrumentInjector.log_e("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        ViewCompat.MyBillsEntityDataFactory(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        if (this.getAuthRequestContext) {
            boolean isLayoutRtlSupport = isLayoutRtlSupport();
            LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
            if (isLayoutRtlSupport) {
                paddingLeft = (int) (getWidth() - (((getPaddingRight() + layoutParams.rightMargin) + (f * this.mSlideRange)) + this.mSlideableView.getWidth()));
            } else {
                paddingLeft = (int) (getPaddingLeft() + layoutParams.leftMargin + (f * this.mSlideRange));
            }
            ViewDragHelper viewDragHelper = this.mDragHelper;
            View view = this.mSlideableView;
            if (viewDragHelper.KClassImpl$Data$declaredNonStaticMembers$2(view, paddingLeft, view.getTop())) {
                setAllChildrenVisible();
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (!this.getAuthRequestContext) {
                this.mDragHelper.getAuthRequestContext();
            } else {
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
            }
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.PrepareContext = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawableLeft(InstrumentInjector.Resources_getDrawable(getResources(), i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.PlaceComponentResult(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.PlaceComponentResult(getContext(), i));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        fsSuperDraw_6891225ba9c0ee2e204cfe11dc18bc31(canvas);
        if (isLayoutRtlSupport()) {
            drawable = this.PrepareContext;
        } else {
            drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isLayoutRtlSupport()) {
            i2 = childAt.getRight();
            i = intrinsicWidth + i2;
        } else {
            int left = childAt.getLeft();
            int i3 = left - intrinsicWidth;
            i = left;
            i2 = i3;
        }
        drawable.setBounds(i2, top, i, bottom);
        drawable.draw(canvas);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.mSlideableView) {
                float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                float f3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f;
                int i2 = ((int) ((1.0f - f2) * f3)) - ((int) ((1.0f - f) * f3));
                if (isLayoutRtlSupport) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
            }
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z) {
            if (view.canScrollHorizontally(!isLayoutRtlSupport() ? -i : i)) {
                return true;
            }
        }
        return false;
    }

    boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        return this.getAuthRequestContext && ((LayoutParams) view.getLayoutParams()).KClassImpl$Data$declaredNonStaticMembers$2 && this.mSlideOffset > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.getAuthRequestContext = isSlideable() ? isOpen() : this.mPreservedOpenState;
        savedState.KClassImpl$Data$declaredNonStaticMembers$2 = this.getErrorConfigVersion;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.getAuthRequestContext) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.getAuthRequestContext;
        setLockMode(savedState.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* loaded from: classes6.dex */
    class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (getAuthRequestContext()) {
                return ((LayoutParams) view.getLayoutParams()).BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.mDragHelper.PlaceComponentResult == 0) {
                if (SlidingPaneLayout.this.mSlideOffset == 1.0f) {
                    SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                    return;
                }
                SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
                slidingPaneLayout3.dispatchOnPanelOpened(slidingPaneLayout3.mSlideableView);
                SlidingPaneLayout.this.mPreservedOpenState = true;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.onPanelDragged(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.getAuthRequestContext(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i, int i2) {
            if (getAuthRequestContext()) {
                SlidingPaneLayout.this.mDragHelper.getAuthRequestContext(SlidingPaneLayout.this.mSlideableView, i2);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            if (getAuthRequestContext()) {
                SlidingPaneLayout.this.mDragHelper.getAuthRequestContext(SlidingPaneLayout.this.mSlideableView, i2);
            }
        }

        private boolean getAuthRequestContext() {
            if (SlidingPaneLayout.this.mIsUnableToDrag || SlidingPaneLayout.this.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            return SlidingPaneLayout.this.isOpen() || SlidingPaneLayout.this.getLockMode() != 2;
        }
    }

    /* loaded from: classes6.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] getAuthRequestContext = {16843137};
        boolean BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        public float MyBillsEntityDataFactory;
        Paint PlaceComponentResult;

        public LayoutParams() {
            super(-1, -1);
            this.MyBillsEntityDataFactory = 0.0f;
        }

        public LayoutParams(int i) {
            super(i, -1);
            this.MyBillsEntityDataFactory = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.MyBillsEntityDataFactory = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.MyBillsEntityDataFactory = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.MyBillsEntityDataFactory = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, getAuthRequestContext);
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes6.dex */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int KClassImpl$Data$declaredNonStaticMembers$2;
        boolean getAuthRequestContext;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel, null);
            this.getAuthRequestContext = parcel.readInt() != 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.getAuthRequestContext ? 1 : 0);
            parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes6.dex */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect PlaceComponentResult = new Rect();

        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat MyBillsEntityDataFactory;
            MyBillsEntityDataFactory = AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.MyBillsEntityDataFactory));
            super.onInitializeAccessibilityNodeInfo(view, MyBillsEntityDataFactory);
            Rect rect = this.PlaceComponentResult;
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(rect);
            accessibilityNodeInfoCompat.MyBillsEntityDataFactory(rect);
            accessibilityNodeInfoCompat.PrepareContext(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4());
            accessibilityNodeInfoCompat.scheduleImpl(MyBillsEntityDataFactory.moveToNextValue());
            accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory.getAuthRequestContext());
            accessibilityNodeInfoCompat.PlaceComponentResult(MyBillsEntityDataFactory.scheduleImpl());
            accessibilityNodeInfoCompat.moveToNextValue(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8());
            accessibilityNodeInfoCompat.PlaceComponentResult(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsEntityDataFactory.newProxyInstance());
            accessibilityNodeInfoCompat.scheduleImpl(MyBillsEntityDataFactory.PrepareContext());
            accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory.GetContactSyncConfig());
            accessibilityNodeInfoCompat.GetContactSyncConfig(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda2(MyBillsEntityDataFactory.isLayoutRequested());
            accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult());
            accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0());
            MyBillsEntityDataFactory.whenAvailable();
            accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(view);
            ViewParent FragmentBottomSheetPaymentSettingBinding = ViewCompat.FragmentBottomSheetPaymentSettingBinding(view);
            if (FragmentBottomSheetPaymentSettingBinding instanceof View) {
                accessibilityNodeInfoCompat.PlaceComponentResult((View) FragmentBottomSheetPaymentSettingBinding);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!KClassImpl$Data$declaredNonStaticMembers$2(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.moveToNextValue(childAt, 1);
                    accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (KClassImpl$Data$declaredNonStaticMembers$2(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        private boolean KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }
    }

    /* loaded from: classes6.dex */
    static class TouchBlocker extends FrameLayout {
        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        TouchBlocker(View view) {
            super(view.getContext());
            addView(view);
        }
    }

    /* loaded from: classes6.dex */
    class DisableLayerRunnable implements Runnable {
        final /* synthetic */ SlidingPaneLayout PlaceComponentResult;
        final View getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            if (this.getAuthRequestContext.getParent() == this.PlaceComponentResult) {
                this.getAuthRequestContext.setLayerType(0, null);
                this.PlaceComponentResult.invalidateChildRegion(this.getAuthRequestContext);
            }
            this.PlaceComponentResult.mPostedRunnables.remove(this);
        }
    }

    boolean isLayoutRtlSupport() {
        return ViewCompat.initRecordTimeStamp(this) == 1;
    }
}
