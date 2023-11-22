package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3, FSDraw, FSDispatchDraw {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    public int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    public static final byte[] getAuthRequestContext = {4, -41, 37, 5, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int PlaceComponentResult = 240;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int BuiltInFictitiousFunctionClassFactory(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void MyBillsEntityDataFactory(View view);

        void getAuthRequestContext(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, MotionEvent motionEvent);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        boolean MyBillsEntityDataFactory(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
    }

    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean MyBillsEntityDataFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        public abstract View KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(TypedArray typedArray, int i) {
        Object[] objArr = new Object[1];
        r(-1, objArr);
        return Class.forName((String) objArr[0]).isInstance(typedArray) ? InstrumentInjector.Resources_getDrawable((Context) typedArray, i) : typedArray.getDrawable(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void r(int r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 + 4
            byte[] r0 = androidx.recyclerview.widget.RecyclerView.getAuthRequestContext
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 0
            if (r0 != 0) goto L12
            r4 = 3
            r5 = 0
            r6 = 22
            goto L28
        L12:
            r4 = 97
            r5 = 0
        L15:
            byte r6 = (byte) r4
            r1[r5] = r6
            int r7 = r7 + 1
            if (r5 != r2) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r3)
            r8[r3] = r7
            return
        L24:
            int r5 = r5 + 1
            r6 = r0[r7]
        L28:
            int r6 = -r6
            int r4 = r4 + r6
            int r4 = r4 + (-8)
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r(int, java.lang.Object[]):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_b7ce570bd9ad6f07f00c4b0c33e98a42(canvas);
    }

    public void fsSuperDispatchDraw_b7ce570bd9ad6f07f00c4b0c33e98a42(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_b7ce570bd9ad6f07f00c4b0c33e98a42(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public void fsSuperDraw_b7ce570bd9ad6f07f00c4b0c33e98a42(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    static {
        FORCE_INVALIDATE_DISPLAY_LIST = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        Object[] objArr = new Object[1];
        r(-1, objArr);
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Class.forName((String) objArr[0]), AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.BuiltInFictitiousFunctionClassFactory);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.mFirstLayoutComplete || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.mIsAttached) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.mLayoutSuppressed) {
                    RecyclerView.this.mLayoutWasDefered = true;
                } else {
                    RecyclerView.this.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public final void MyBillsEntityDataFactory(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.getAuthRequestContext(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public final void BuiltInFictitiousFunctionClassFactory(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public final void PlaceComponentResult(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.PlaceComponentResult(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.PlaceComponentResult(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public final void PlaceComponentResult(ViewHolder viewHolder) {
                RecyclerView.this.mLayout.removeAndRecycleView(viewHolder.itemView, RecyclerView.this.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.KClassImpl$Data$declaredNonStaticMembers$2(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getAuthRequestContext(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.lookAheadTest = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(this) == 0) {
            ViewCompat.moveToNextValue((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, i, 0);
        ViewCompat.MyBillsEntityDataFactory(this, context, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, attributeSet, obtainStyledAttributes, i, 0);
        String string = obtainStyledAttributes.getString(R.styleable.initRecordTimeStamp);
        if (obtainStyledAttributes.getInt(R.styleable.scheduleImpl, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R.styleable.getErrorConfigVersion, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.lookAheadTest, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.GetContactSyncConfig), __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.DatabaseTableConfigUtil), (StateListDrawable) __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2), __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            int[] iArr = NESTED_SCROLLING_ATTRS;
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
            ViewCompat.MyBillsEntityDataFactory(this, context, iArr, attributeSet, obtainStyledAttributes2, i, 0);
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(super.toString());
        sb.append(", adapter:");
        sb.append(this.mAdapter);
        sb.append(", layout:");
        sb.append(this.mLayout);
        sb.append(", context:");
        sb.append(getContext());
        return sb.toString();
    }

    private void initAutofill() {
        if (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda2(this) == 0) {
            ViewCompat.scheduleImpl(this, 8);
        }
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.MyBillsEntityDataFactory(this, recyclerViewAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        StringBuilder sb = new StringBuilder();
                        sb.append(attributeSet.getPositionDescription());
                        sb.append(": Error creating LayoutManager ");
                        sb.append(fullClassName);
                        throw new IllegalStateException(sb.toString(), e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((LayoutManager) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(attributeSet.getPositionDescription());
                sb2.append(": Class is not a LayoutManager ");
                sb2.append(fullClassName);
                throw new IllegalStateException(sb2.toString(), e3);
            } catch (ClassNotFoundException e4) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(attributeSet.getPositionDescription());
                sb3.append(": Unable to find LayoutManager ");
                sb3.append(fullClassName);
                throw new IllegalStateException(sb3.toString(), e4);
            } catch (IllegalAccessException e5) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(attributeSet.getPositionDescription());
                sb4.append(": Cannot access non-public constructor ");
                sb4.append(fullClassName);
                throw new IllegalStateException(sb4.toString(), e5);
            } catch (InstantiationException e6) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(attributeSet.getPositionDescription());
                sb5.append(": Could not instantiate the LayoutManager: ");
                sb5.append(fullClassName);
                throw new IllegalStateException(sb5.toString(), e6);
            } catch (InvocationTargetException e7) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(attributeSet.getPositionDescription());
                sb6.append(": Could not instantiate the LayoutManager: ");
                sb6.append(fullClassName);
                throw new IllegalStateException(sb6.toString(), e7);
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(str);
            return sb.toString();
        } else if (str.contains(".")) {
            return str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RecyclerView.class.getPackage().getName());
            sb2.append('.');
            sb2.append(str);
            return sb2.toString();
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final int MyBillsEntityDataFactory() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final void getAuthRequestContext(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final int MyBillsEntityDataFactory(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final void BuiltInFictitiousFunctionClassFactory(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final View getAuthRequestContext(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final ViewHolder KClassImpl$Data$declaredNonStaticMembers$2(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final void MyBillsEntityDataFactory(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Called attach on a child which is not detached: ");
                        sb.append(childViewHolderInt);
                        sb.append(RecyclerView.this.exceptionLabel());
                        throw new IllegalArgumentException(sb.toString());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final void BuiltInFictitiousFunctionClassFactory(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final void PlaceComponentResult(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final void MyBillsEntityDataFactory(int i) {
                ViewHolder childViewHolderInt;
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("called detach on an already detached child ");
                        sb.append(childViewHolderInt);
                        sb.append(RecyclerView.this.exceptionLabel());
                        throw new IllegalArgumentException(sb.toString());
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public final void getAuthRequestContext() {
                int childCount = RecyclerView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = RecyclerView.this.getChildAt(i);
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }
        });
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final ViewHolder MyBillsEntityDataFactory(int i) {
                ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.MyBillsEntityDataFactory(findViewHolderForPosition.itemView)) {
                    return null;
                }
                return findViewHolderForPosition;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView.this.mItemsAddedOrRemoved = true;
                RecyclerView.this.mState.PlaceComponentResult += i2;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final void PlaceComponentResult(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final void BuiltInFictitiousFunctionClassFactory(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(AdapterHelper.UpdateOp updateOp) {
                getAuthRequestContext(updateOp);
            }

            private void getAuthRequestContext(AdapterHelper.UpdateOp updateOp) {
                int i = updateOp.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i == 1) {
                    RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
                } else if (i == 2) {
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
                } else if (i == 4) {
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext, updateOp.BuiltInFictitiousFunctionClassFactory);
                } else if (i == 8) {
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext, 1);
                }
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final void BuiltInFictitiousFunctionClassFactory(AdapterHelper.UpdateOp updateOp) {
                getAuthRequestContext(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public final void MyBillsEntityDataFactory(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("setScrollingTouchSlop(): bad argument constant ");
                sb.append(i);
                sb.append("; using default value");
                InstrumentInjector.log_w(TAG, sb.toString());
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.PlaceComponentResult();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        Recycler recycler = this.mRecycler;
        recycler.PlaceComponentResult.clear();
        recycler.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private void setAdapterInternal(Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        AdapterHelper adapterHelper = this.mAdapterHelper;
        adapterHelper.BuiltInFictitiousFunctionClassFactory(adapterHelper.NetworkUserEntityData$$ExternalSyntheticLambda0);
        adapterHelper.BuiltInFictitiousFunctionClassFactory(adapterHelper.scheduleImpl);
        adapterHelper.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        Recycler recycler = this.mRecycler;
        Adapter adapter4 = this.mAdapter;
        recycler.PlaceComponentResult.clear();
        recycler.KClassImpl$Data$declaredNonStaticMembers$2();
        if (recycler.BuiltInFictitiousFunctionClassFactory == null) {
            recycler.BuiltInFictitiousFunctionClassFactory = new RecycledViewPool();
        }
        RecycledViewPool recycledViewPool = recycler.BuiltInFictitiousFunctionClassFactory;
        if (adapter3 != null) {
            recycledViewPool.KClassImpl$Data$declaredNonStaticMembers$2--;
        }
        if (!z && recycledViewPool.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            for (int i = 0; i < recycledViewPool.BuiltInFictitiousFunctionClassFactory.size(); i++) {
                recycledViewPool.BuiltInFictitiousFunctionClassFactory.valueAt(i).MyBillsEntityDataFactory.clear();
            }
        }
        if (adapter4 != null) {
            recycledViewPool.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        this.mState.DatabaseTableConfigUtil = true;
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    public void addRecyclerListener(RecyclerListener recyclerListener) {
        Preconditions.MyBillsEntityDataFactory(recyclerListener != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(recyclerListener);
    }

    public void removeRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListeners.remove(recyclerListener);
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        r1.PlaceComponentResult = 0;
        r1 = r1.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        r1 = r0.BuiltInFictitiousFunctionClassFactory.size() - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        if (r1 < 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        r0.MyBillsEntityDataFactory.PlaceComponentResult(r0.BuiltInFictitiousFunctionClassFactory.get(r1));
        r0.BuiltInFictitiousFunctionClassFactory.remove(r1);
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        r0.MyBillsEntityDataFactory.getAuthRequestContext();
        r4.mLayout = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        if (r5 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
    
        if (r5.mRecyclerView != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        r4.mLayout.setRecyclerView(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
    
        if (r4.mIsAttached == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
    
        r4.mLayout.dispatchAttachedToWindow(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("LayoutManager ");
        r0.append(r5);
        r0.append(" is already attached to a RecyclerView:");
        r0.append(r5.mRecyclerView.exceptionLabel());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
    
        throw new java.lang.IllegalArgumentException(r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bc, code lost:
    
        r4.mRecycler.PlaceComponentResult();
        requestLayout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c4, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setLayoutManager(androidx.recyclerview.widget.RecyclerView.LayoutManager r5) {
        /*
            r4 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            if (r5 != r0) goto L5
            return
        L5:
            r4.stopScroll()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            if (r0 == 0) goto L3f
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r4.mItemAnimator
            if (r0 == 0) goto L13
            r0.PlaceComponentResult()
        L13:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r4.mRecycler
            r0.removeAndRecycleAllViews(r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r4.mRecycler
            r0.removeAndRecycleScrapInt(r1)
            androidx.recyclerview.widget.RecyclerView$Recycler r0 = r4.mRecycler
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r1 = r0.PlaceComponentResult
            r1.clear()
            r0.KClassImpl$Data$declaredNonStaticMembers$2()
            boolean r0 = r4.mIsAttached
            if (r0 == 0) goto L36
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r4.mRecycler
            r0.dispatchDetachedFromWindow(r4, r1)
        L36:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            r1 = 0
            r0.setRecyclerView(r1)
            r4.mLayout = r1
            goto L49
        L3f:
            androidx.recyclerview.widget.RecyclerView$Recycler r0 = r4.mRecycler
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$ViewHolder> r1 = r0.PlaceComponentResult
            r1.clear()
            r0.KClassImpl$Data$declaredNonStaticMembers$2()
        L49:
            androidx.recyclerview.widget.ChildHelper r0 = r4.mChildHelper
            androidx.recyclerview.widget.ChildHelper$Bucket r1 = r0.getAuthRequestContext
            r2 = 0
            r1.PlaceComponentResult = r2
            androidx.recyclerview.widget.ChildHelper$Bucket r1 = r1.MyBillsEntityDataFactory
            if (r1 == 0) goto L5c
        L55:
            r1.PlaceComponentResult = r2
            androidx.recyclerview.widget.ChildHelper$Bucket r1 = r1.MyBillsEntityDataFactory
            if (r1 == 0) goto L5c
            goto L55
        L5c:
            java.util.List<android.view.View> r1 = r0.BuiltInFictitiousFunctionClassFactory
            int r1 = r1.size()
            int r1 = r1 + (-1)
        L64:
            if (r1 < 0) goto L7b
            androidx.recyclerview.widget.ChildHelper$Callback r2 = r0.MyBillsEntityDataFactory
            java.util.List<android.view.View> r3 = r0.BuiltInFictitiousFunctionClassFactory
            java.lang.Object r3 = r3.get(r1)
            android.view.View r3 = (android.view.View) r3
            r2.PlaceComponentResult(r3)
            java.util.List<android.view.View> r2 = r0.BuiltInFictitiousFunctionClassFactory
            r2.remove(r1)
            int r1 = r1 + (-1)
            goto L64
        L7b:
            androidx.recyclerview.widget.ChildHelper$Callback r0 = r0.MyBillsEntityDataFactory
            r0.getAuthRequestContext()
            r4.mLayout = r5
            if (r5 == 0) goto Lbc
            androidx.recyclerview.widget.RecyclerView r0 = r5.mRecyclerView
            if (r0 != 0) goto L97
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = r4.mLayout
            r5.setRecyclerView(r4)
            boolean r5 = r4.mIsAttached
            if (r5 == 0) goto Lbc
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = r4.mLayout
            r5.dispatchAttachedToWindow(r4)
            goto Lbc
        L97:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "LayoutManager "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " is already attached to a RecyclerView:"
            r0.append(r1)
            androidx.recyclerview.widget.RecyclerView r5 = r5.mRecyclerView
            java.lang.String r5 = r5.exceptionLabel()
            r0.append(r5)
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        Lbc:
            androidx.recyclerview.widget.RecyclerView$Recycler r5 = r4.mRecycler
            r5.PlaceComponentResult()
            r4.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.setLayoutManager(androidx.recyclerview.widget.RecyclerView$LayoutManager):void");
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.BuiltInFictitiousFunctionClassFactory = layoutManager.onSaveInstanceState();
            } else {
                savedState.BuiltInFictitiousFunctionClassFactory = null;
            }
        } else {
            savedState.BuiltInFictitiousFunctionClassFactory = savedState2.BuiltInFictitiousFunctionClassFactory;
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.getAuthRequestContext(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.KClassImpl$Data$declaredNonStaticMembers$2(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            ChildHelper childHelper = this.mChildHelper;
            int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory(view);
            if (MyBillsEntityDataFactory < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("view is not a child, cannot hide ");
                sb.append(view);
                throw new IllegalArgumentException(sb.toString());
            }
            childHelper.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
            childHelper.BuiltInFictitiousFunctionClassFactory.add(view);
            childHelper.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(view);
        } else {
            this.mChildHelper.MyBillsEntityDataFactory(view, -1, true);
        }
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean PlaceComponentResult2 = this.mChildHelper.PlaceComponentResult(view);
        if (PlaceComponentResult2) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.getAuthRequestContext(childViewHolderInt);
            this.mRecycler.BuiltInFictitiousFunctionClassFactory(childViewHolderInt);
        }
        stopInterceptRequestLayout(!PlaceComponentResult2);
        return PlaceComponentResult2;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        Recycler recycler = this.mRecycler;
        if (recycler.BuiltInFictitiousFunctionClassFactory == null) {
            recycler.BuiltInFictitiousFunctionClassFactory = new RecycledViewPool();
        }
        return recycler.BuiltInFictitiousFunctionClassFactory;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        Recycler recycler = this.mRecycler;
        if (recycler.BuiltInFictitiousFunctionClassFactory != null) {
            r1.KClassImpl$Data$declaredNonStaticMembers$2--;
        }
        recycler.BuiltInFictitiousFunctionClassFactory = recycledViewPool;
        if (recycledViewPool == null || RecyclerView.this.getAdapter() == null) {
            return;
        }
        recycler.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2++;
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.getErrorConfigVersion = viewCacheExtension;
    }

    public void setItemViewCacheSize(int i) {
        Recycler recycler = this.mRecycler;
        recycler.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        recycler.PlaceComponentResult();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        if (i != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i);
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" is an invalid index for size ");
            sb.append(itemDecorationCount);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.mItemDecorations.get(i);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" is an invalid index for size ");
            sb.append(itemDecorationCount);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            InstrumentInjector.log_e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        layoutManager.scrollToPosition(i);
        awakenScrollBars();
    }

    void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            InstrumentInjector.log_e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.mState, i);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        InstrumentInjector.log_w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            InstrumentInjector.log_e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null, 0);
            }
        }
    }

    public void nestedScrollBy(int i, int i2) {
        nestedScrollByInternal(i, i2, null, 1);
    }

    private void nestedScrollByInternal(int i, int i2, MotionEvent motionEvent, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            InstrumentInjector.log_e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            startNestedScroll(canScrollVertically ? canScrollHorizontally | 2 : canScrollHorizontally, i3);
            if (dispatchNestedPreScroll(canScrollHorizontally != 0 ? i : 0, canScrollVertically ? i2 : 0, this.mReusableIntPair, this.mScrollOffset, i3)) {
                int[] iArr2 = this.mReusableIntPair;
                i -= iArr2[0];
                i2 -= iArr2[1];
            }
            scrollByInternal(canScrollHorizontally != 0 ? i : 0, canScrollVertically ? i2 : 0, motionEvent, i3);
            GapWorker gapWorker = this.mGapWorker;
            if (gapWorker != null && (i != 0 || i2 != 0)) {
                gapWorker.getAuthRequestContext(this, i, i2);
            }
            stopNestedScroll(i3);
        }
    }

    void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.BuiltInFictitiousFunctionClassFactory(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        TraceCompat.BuiltInFictitiousFunctionClassFactory();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.BuiltInFictitiousFunctionClassFactory(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.BuiltInFictitiousFunctionClassFactory();
        } else if (this.mAdapterHelper.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (this.mAdapterHelper.getAuthRequestContext(4) && !this.mAdapterHelper.getAuthRequestContext(11)) {
                TraceCompat.BuiltInFictitiousFunctionClassFactory(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.PlaceComponentResult();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.getAuthRequestContext();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.BuiltInFictitiousFunctionClassFactory();
            } else if (this.mAdapterHelper.KClassImpl$Data$declaredNonStaticMembers$2()) {
                TraceCompat.BuiltInFictitiousFunctionClassFactory(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    private boolean hasUpdatedView() {
        ChildHelper childHelper = this.mChildHelper;
        int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            ChildHelper childHelper2 = this.mChildHelper;
            ViewHolder childViewHolderInt = getChildViewHolderInt(childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(i)));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean scrollByInternal(int i, int i2, MotionEvent motionEvent, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i, i2, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i - i8;
            i7 = i2 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i5, i4, i6, i7, this.mScrollOffset, i3, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i10 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i11 = iArr5[0];
        this.mLastTouchX = i10 - i11;
        int i12 = this.mLastTouchY;
        int i13 = iArr5[1];
        this.mLastTouchY = i12 - i13;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i11;
        iArr6[1] = iArr6[1] + i13;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i6 - r1, motionEvent.getY(), i7 - r0);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (i5 != 0 || i4 != 0) {
            dispatchOnScrolled(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth <= 0) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            InstrumentInjector.log_e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            if (!layoutManager.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return;
            }
            if (i3 == Integer.MIN_VALUE || i3 > 0) {
                if (z) {
                    int i4 = i != 0 ? 1 : 0;
                    if (i2 != 0) {
                        i4 |= 2;
                    }
                    startNestedScroll(i4, 1);
                }
                this.mViewFlinger.getAuthRequestContext(i, i2, i3, interpolator);
                return;
            }
            scrollBy(i, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public boolean fling(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            InstrumentInjector.log_e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            int canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            int i3 = (canScrollHorizontally == 0 || Math.abs(i) < this.mMinFlingVelocity) ? 0 : i;
            int i4 = (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : i2;
            if (i3 == 0 && i4 == 0) {
                return false;
            }
            float f = i3;
            float f2 = i4;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = canScrollHorizontally != 0 || canScrollVertically;
                dispatchNestedFling(f, f2, z);
                OnFlingListener onFlingListener = this.mOnFlingListener;
                if (onFlingListener != null && onFlingListener.KClassImpl$Data$declaredNonStaticMembers$2(i3, i4)) {
                    return true;
                }
                if (z) {
                    if (canScrollVertically) {
                        canScrollHorizontally = (canScrollHorizontally == true ? 1 : 0) | 2;
                    }
                    startNestedScroll(canScrollHorizontally, 1);
                    int i5 = this.mMaxFlingVelocity;
                    int max = Math.max(-i5, Math.min(i3, i5));
                    int i6 = this.mMaxFlingVelocity;
                    int max2 = Math.max(-i6, Math.min(i4, i6));
                    ViewFlinger viewFlinger = this.mViewFlinger;
                    RecyclerView.this.setScrollState(2);
                    viewFlinger.MyBillsEntityDataFactory = 0;
                    viewFlinger.getAuthRequestContext = 0;
                    Interpolator interpolator = viewFlinger.KClassImpl$Data$declaredNonStaticMembers$2;
                    Interpolator interpolator2 = sQuinticInterpolator;
                    if (interpolator != interpolator2) {
                        viewFlinger.KClassImpl$Data$declaredNonStaticMembers$2 = interpolator2;
                        viewFlinger.PlaceComponentResult = new OverScroller(RecyclerView.this.getContext(), sQuinticInterpolator);
                    }
                    viewFlinger.PlaceComponentResult.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    if (viewFlinger.BuiltInFictitiousFunctionClassFactory) {
                        viewFlinger.getErrorConfigVersion = true;
                    } else {
                        RecyclerView.this.removeCallbacks(viewFlinger);
                        ViewCompat.PlaceComponentResult(RecyclerView.this, viewFlinger);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        ViewFlinger viewFlinger = this.mViewFlinger;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.PlaceComponentResult.abortAnimation();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L20
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.EdgeEffectCompat.MyBillsEntityDataFactory(r3, r4, r9)
            goto L39
        L20:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.MyBillsEntityDataFactory(r3, r4, r9)
        L39:
            r9 = 1
            goto L3c
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.EdgeEffectCompat.MyBillsEntityDataFactory(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.EdgeEffectCompat.MyBillsEntityDataFactory(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.view.ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
    }

    void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect BuiltInFictitiousFunctionClassFactory = this.mEdgeEffectFactory.BuiltInFictitiousFunctionClassFactory(this, 0);
        this.mLeftGlow = BuiltInFictitiousFunctionClassFactory;
        if (this.mClipToPadding) {
            int measuredHeight = getMeasuredHeight();
            int paddingTop = getPaddingTop();
            BuiltInFictitiousFunctionClassFactory.setSize((measuredHeight - paddingTop) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            return;
        }
        BuiltInFictitiousFunctionClassFactory.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect BuiltInFictitiousFunctionClassFactory = this.mEdgeEffectFactory.BuiltInFictitiousFunctionClassFactory(this, 2);
        this.mRightGlow = BuiltInFictitiousFunctionClassFactory;
        if (this.mClipToPadding) {
            int measuredHeight = getMeasuredHeight();
            int paddingTop = getPaddingTop();
            BuiltInFictitiousFunctionClassFactory.setSize((measuredHeight - paddingTop) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            return;
        }
        BuiltInFictitiousFunctionClassFactory.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect BuiltInFictitiousFunctionClassFactory = this.mEdgeEffectFactory.BuiltInFictitiousFunctionClassFactory(this, 1);
        this.mTopGlow = BuiltInFictitiousFunctionClassFactory;
        if (this.mClipToPadding) {
            int measuredWidth = getMeasuredWidth();
            int paddingLeft = getPaddingLeft();
            BuiltInFictitiousFunctionClassFactory.setSize((measuredWidth - paddingLeft) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            return;
        }
        BuiltInFictitiousFunctionClassFactory.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect BuiltInFictitiousFunctionClassFactory = this.mEdgeEffectFactory.BuiltInFictitiousFunctionClassFactory(this, 3);
        this.mBottomGlow = BuiltInFictitiousFunctionClassFactory;
        if (this.mClipToPadding) {
            int measuredWidth = getMeasuredWidth();
            int paddingLeft = getPaddingLeft();
            BuiltInFictitiousFunctionClassFactory.setSize((measuredWidth - paddingLeft) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            return;
        }
        BuiltInFictitiousFunctionClassFactory.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return !isPreferredNextFocus(view, view2, i) ? super.focusSearch(view, i) : view2;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            requestChildOnScreen(view2, null);
            return view;
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i3 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i2 = 1;
        } else {
            i2 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c = 0;
        }
        if (i == 1) {
            if (c >= 0) {
                return c == 0 && i2 * i3 < 0;
            }
            return true;
        } else if (i == 2) {
            if (c <= 0) {
                return c == 0 && i2 * i3 > 0;
            }
            return true;
        } else if (i == 17) {
            return i2 < 0;
        } else if (i == 33) {
            return c < 0;
        } else if (i == 66) {
            return i2 > 0;
        } else if (i == 130) {
            return c > 0;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid direction: ");
            sb.append(i);
            sb.append(exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            GapWorker gapWorker = GapWorker.MyBillsEntityDataFactory.get();
            this.mGapWorker = gapWorker;
            if (gapWorker == null) {
                this.mGapWorker = new GapWorker();
                Display lookAheadTest = ViewCompat.lookAheadTest(this);
                float f = 60.0f;
                if (!isInEditMode() && lookAheadTest != null) {
                    float refreshRate = lookAheadTest.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                this.mGapWorker.BuiltInFictitiousFunctionClassFactory = 1.0E9f / f;
                GapWorker.MyBillsEntityDataFactory.set(this.mGapWorker);
            }
            this.mGapWorker.PlaceComponentResult.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.PlaceComponentResult();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        ViewInfoStore.getAuthRequestContext();
        if (!ALLOW_THREAD_GAP_WORK || (gapWorker = this.mGapWorker) == null) {
            return;
        }
        gapWorker.PlaceComponentResult.remove(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            sb.append(exceptionLabel());
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(exceptionLabel());
        throw new IllegalStateException(sb2.toString());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                sb.append(exceptionLabel());
                throw new IllegalStateException(sb.toString());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(exceptionLabel());
            InstrumentInjector.log_w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(sb2.toString()));
        }
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        onItemTouchListener.BuiltInFictitiousFunctionClassFactory(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (onItemTouchListener.MyBillsEntityDataFactory(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = canScrollHorizontally;
            if (canScrollVertically) {
                i = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error processing scroll; pointer index for id ");
                sb.append(this.mScrollPointerId);
                sb.append(" not found. Did any MotionEvents get skipped?");
                InstrumentInjector.log_e(TAG, sb.toString());
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = this.mInitialTouchX;
                int i3 = this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(x2 - i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(y2 - i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).KClassImpl$Data$declaredNonStaticMembers$2(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L60
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L61
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L5f
            r0 = 26
            float r3 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L55
            float r0 = -r3
            goto L60
        L55:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.mLayout
            boolean r0 = r0.canScrollHorizontally()
            if (r0 == 0) goto L5f
            r0 = 0
            goto L61
        L5f:
            r0 = 0
        L60:
            r3 = 0
        L61:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L69
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L69:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.nestedScrollByInternal(r2, r0, r6, r3)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z;
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.lookAheadTest == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i, i2);
            this.mState.moveToNextValue = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.moveToNextValue = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.initRecordTimeStamp) {
                    this.mState.BuiltInFictitiousFunctionClassFactory = true;
                } else {
                    this.mAdapterHelper.MyBillsEntityDataFactory();
                    this.mState.BuiltInFictitiousFunctionClassFactory = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.initRecordTimeStamp) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.scheduleImpl = adapter.getItemCount();
            } else {
                this.mState.scheduleImpl = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.BuiltInFictitiousFunctionClassFactory = false;
        }
    }

    void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda7(this)), LayoutManager.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.PrepareContext(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        invalidateGlows();
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.PlaceComponentResult();
            this.mItemAnimator.lookAheadTest = null;
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.lookAheadTest = this.mItemAnimatorListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i <= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        AccessibilityEventCompat.BuiltInFictitiousFunctionClassFactory(obtain, i);
        sendAccessibilityEventUnchecked(obtain);
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (isComputingLayout()) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = accessibilityEvent != null ? AccessibilityEventCompat.KClassImpl$Data$declaredNonStaticMembers$2(accessibilityEvent) : 0;
            this.mEatenAccessibilityChangeFlags |= KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? KClassImpl$Data$declaredNonStaticMembers$2 : 0;
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        ViewCompat.PlaceComponentResult(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z = false;
        if (this.mDataSetHasChangedAfterLayout) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            adapterHelper.BuiltInFictitiousFunctionClassFactory(adapterHelper.NetworkUserEntityData$$ExternalSyntheticLambda0);
            adapterHelper.BuiltInFictitiousFunctionClassFactory(adapterHelper.scheduleImpl);
            adapterHelper.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.PlaceComponentResult();
        } else {
            this.mAdapterHelper.MyBillsEntityDataFactory();
        }
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.GetContactSyncConfig = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        State state = this.mState;
        if (state.GetContactSyncConfig && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        state.initRecordTimeStamp = z;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            InstrumentInjector.log_w(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            InstrumentInjector.log_e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.moveToNextValue = false;
            boolean z = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
            this.mLastAutoMeasureNonExactMeasuredWidth = 0;
            this.mLastAutoMeasureNonExactMeasuredHeight = 0;
            this.mLastAutoMeasureSkippedDueToExact = false;
            if (this.mState.lookAheadTest == 1) {
                dispatchLayoutStep1();
            } else if (!this.mAdapterHelper.BuiltInFictitiousFunctionClassFactory() && !z && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep3();
            }
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        int absoluteAdapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        ViewHolder findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.KClassImpl$Data$declaredNonStaticMembers$2 = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        State state = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            absoluteAdapterPosition = -1;
        } else {
            absoluteAdapterPosition = findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAbsoluteAdapterPosition();
        }
        state.MyBillsEntityDataFactory = absoluteAdapterPosition;
        this.mState.getAuthRequestContext = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void resetFocusInfo() {
        this.mState.KClassImpl$Data$declaredNonStaticMembers$2 = -1L;
        this.mState.MyBillsEntityDataFactory = -1;
        this.mState.getAuthRequestContext = -1;
    }

    private View findNextViewToFocus() {
        int i;
        ViewHolder findViewHolderForAdapterPosition;
        int i2 = this.mState.MyBillsEntityDataFactory != -1 ? this.mState.MyBillsEntityDataFactory : 0;
        State state = this.mState;
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i = state.scheduleImpl;
        }
        for (int i3 = i2; i3 < i; i3++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(i, i2);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                ChildHelper childHelper = this.mChildHelper;
                if (childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.MyBillsEntityDataFactory(focusedChild)) {
                return;
            }
        }
        View view = null;
        ViewHolder findViewHolderForItemId = (this.mState.KClassImpl$Data$declaredNonStaticMembers$2 == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.KClassImpl$Data$declaredNonStaticMembers$2);
        if (findViewHolderForItemId == null || this.mChildHelper.MyBillsEntityDataFactory(findViewHolderForItemId.itemView) || !findViewHolderForItemId.itemView.hasFocusable()) {
            ChildHelper childHelper2 = this.mChildHelper;
            if (childHelper2.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper2.BuiltInFictitiousFunctionClassFactory.size() > 0) {
                view = findNextViewToFocus();
            }
        } else {
            view = findViewHolderForItemId.itemView;
        }
        if (view != null) {
            if (this.mState.getAuthRequestContext != -1 && (findViewById = view.findViewById(this.mState.getAuthRequestContext)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.PlaceComponentResult;
            state.NetworkUserEntityData$$ExternalSyntheticLambda0 = overScroller.getFinalX() - overScroller.getCurrX();
            state.NetworkUserEntityData$$ExternalSyntheticLambda2 = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        state.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    }

    private void dispatchLayoutStep1() {
        this.mState.getAuthRequestContext(1);
        fillRemainingScrollValues(this.mState);
        this.mState.moveToNextValue = false;
        startInterceptRequestLayout();
        ViewInfoStore viewInfoStore = this.mViewInfoStore;
        viewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        viewInfoStore.getAuthRequestContext.getAuthRequestContext();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        state.PrepareContext = state.GetContactSyncConfig && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        State state2 = this.mState;
        state2.BuiltInFictitiousFunctionClassFactory = state2.initRecordTimeStamp;
        this.mState.scheduleImpl = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.GetContactSyncConfig) {
            ChildHelper childHelper = this.mChildHelper;
            int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
            for (int i = 0; i < MyBillsEntityDataFactory; i++) {
                ChildHelper childHelper2 = this.mChildHelper;
                ViewHolder childViewHolderInt = getChildViewHolderInt(childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(i)));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    ItemAnimator.getAuthRequestContext(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    this.mViewInfoStore.BuiltInFictitiousFunctionClassFactory(childViewHolderInt, ItemAnimator.scheduleImpl().PlaceComponentResult(childViewHolderInt));
                    if (this.mState.PrepareContext && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.getAuthRequestContext.getAuthRequestContext(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.initRecordTimeStamp) {
            saveOldPositions();
            boolean z = this.mState.DatabaseTableConfigUtil;
            this.mState.DatabaseTableConfigUtil = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.DatabaseTableConfigUtil = z;
            int i2 = 0;
            while (true) {
                ChildHelper childHelper3 = this.mChildHelper;
                if (i2 >= childHelper3.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper3.BuiltInFictitiousFunctionClassFactory.size()) {
                    break;
                }
                ChildHelper childHelper4 = this.mChildHelper;
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(childHelper4.MyBillsEntityDataFactory.getAuthRequestContext(childHelper4.BuiltInFictitiousFunctionClassFactory(i2)));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.PlaceComponentResult(childViewHolderInt2)) {
                    ItemAnimator.getAuthRequestContext(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    childViewHolderInt2.getUnmodifiedPayloads();
                    ItemAnimator.ItemHolderInfo PlaceComponentResult2 = ItemAnimator.scheduleImpl().PlaceComponentResult(childViewHolderInt2);
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, PlaceComponentResult2);
                    } else {
                        ViewInfoStore viewInfoStore2 = this.mViewInfoStore;
                        ViewInfoStore.InfoRecord infoRecord = viewInfoStore2.KClassImpl$Data$declaredNonStaticMembers$2.get(childViewHolderInt2);
                        if (infoRecord == null) {
                            infoRecord = ViewInfoStore.InfoRecord.getAuthRequestContext();
                            viewInfoStore2.KClassImpl$Data$declaredNonStaticMembers$2.put(childViewHolderInt2, infoRecord);
                        }
                        infoRecord.MyBillsEntityDataFactory |= 2;
                        infoRecord.getAuthRequestContext = PlaceComponentResult2;
                    }
                }
                i2++;
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.lookAheadTest = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.getAuthRequestContext(6);
        this.mAdapterHelper.MyBillsEntityDataFactory();
        this.mState.scheduleImpl = this.mAdapter.getItemCount();
        this.mState.PlaceComponentResult = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            if (this.mPendingSavedState.BuiltInFictitiousFunctionClassFactory != null) {
                this.mLayout.onRestoreInstanceState(this.mPendingSavedState.BuiltInFictitiousFunctionClassFactory);
            }
            this.mPendingSavedState = null;
        }
        this.mState.BuiltInFictitiousFunctionClassFactory = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.DatabaseTableConfigUtil = false;
        State state = this.mState;
        state.GetContactSyncConfig = state.GetContactSyncConfig && this.mItemAnimator != null;
        this.mState.lookAheadTest = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.getAuthRequestContext(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.lookAheadTest = 1;
        if (this.mState.GetContactSyncConfig) {
            ChildHelper childHelper = this.mChildHelper;
            for (int MyBillsEntityDataFactory = (childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size()) - 1; MyBillsEntityDataFactory >= 0; MyBillsEntityDataFactory--) {
                ChildHelper childHelper2 = this.mChildHelper;
                ViewHolder childViewHolderInt = getChildViewHolderInt(childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory)));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo PlaceComponentResult2 = ItemAnimator.scheduleImpl().PlaceComponentResult(childViewHolderInt);
                    ViewHolder MyBillsEntityDataFactory2 = this.mViewInfoStore.getAuthRequestContext.MyBillsEntityDataFactory(changedHolderKey, null);
                    if (MyBillsEntityDataFactory2 != null && !MyBillsEntityDataFactory2.shouldIgnore()) {
                        boolean authRequestContext = this.mViewInfoStore.getAuthRequestContext(MyBillsEntityDataFactory2);
                        boolean authRequestContext2 = this.mViewInfoStore.getAuthRequestContext(childViewHolderInt);
                        if (!authRequestContext || MyBillsEntityDataFactory2 != childViewHolderInt) {
                            ItemAnimator.ItemHolderInfo authRequestContext3 = this.mViewInfoStore.getAuthRequestContext(MyBillsEntityDataFactory2, 4);
                            this.mViewInfoStore.getAuthRequestContext(childViewHolderInt, PlaceComponentResult2);
                            ItemAnimator.ItemHolderInfo authRequestContext4 = this.mViewInfoStore.getAuthRequestContext(childViewHolderInt, 8);
                            if (authRequestContext3 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, MyBillsEntityDataFactory2);
                            } else {
                                animateChange(MyBillsEntityDataFactory2, childViewHolderInt, authRequestContext3, authRequestContext4, authRequestContext, authRequestContext2);
                            }
                        }
                    }
                    this.mViewInfoStore.getAuthRequestContext(childViewHolderInt, PlaceComponentResult2);
                }
            }
            ViewInfoStore viewInfoStore = this.mViewInfoStore;
            ViewInfoStore.ProcessCallback processCallback = this.mViewInfoProcessCallback;
            for (int size = viewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) viewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[size << 1];
                ViewInfoStore.InfoRecord MyBillsEntityDataFactory3 = viewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(size);
                if ((MyBillsEntityDataFactory3.MyBillsEntityDataFactory & 3) == 3) {
                    processCallback.PlaceComponentResult(viewHolder);
                } else if ((MyBillsEntityDataFactory3.MyBillsEntityDataFactory & 1) != 0) {
                    if (MyBillsEntityDataFactory3.getAuthRequestContext == null) {
                        processCallback.PlaceComponentResult(viewHolder);
                    } else {
                        processCallback.MyBillsEntityDataFactory(viewHolder, MyBillsEntityDataFactory3.getAuthRequestContext, MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                } else if ((MyBillsEntityDataFactory3.MyBillsEntityDataFactory & 14) == 14) {
                    processCallback.BuiltInFictitiousFunctionClassFactory(viewHolder, MyBillsEntityDataFactory3.getAuthRequestContext, MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if ((MyBillsEntityDataFactory3.MyBillsEntityDataFactory & 12) == 12) {
                    processCallback.PlaceComponentResult(viewHolder, MyBillsEntityDataFactory3.getAuthRequestContext, MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if ((MyBillsEntityDataFactory3.MyBillsEntityDataFactory & 4) != 0) {
                    processCallback.MyBillsEntityDataFactory(viewHolder, MyBillsEntityDataFactory3.getAuthRequestContext, null);
                } else if ((MyBillsEntityDataFactory3.MyBillsEntityDataFactory & 8) != 0) {
                    processCallback.BuiltInFictitiousFunctionClassFactory(viewHolder, MyBillsEntityDataFactory3.getAuthRequestContext, MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2);
                } else {
                    int i = MyBillsEntityDataFactory3.MyBillsEntityDataFactory;
                }
                ViewInfoStore.InfoRecord.MyBillsEntityDataFactory(MyBillsEntityDataFactory3);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state = this.mState;
        state.getErrorConfigVersion = state.scheduleImpl;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.GetContactSyncConfig = false;
        this.mState.initRecordTimeStamp = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.getAuthRequestContext != null) {
            this.mRecycler.getAuthRequestContext.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            this.mLayout.mPrefetchMaxCountObserved = 0;
            this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.PlaceComponentResult();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        ViewInfoStore viewInfoStore2 = this.mViewInfoStore;
        viewInfoStore2.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        viewInfoStore2.getAuthRequestContext.getAuthRequestContext();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        ChildHelper childHelper = this.mChildHelper;
        int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            ChildHelper childHelper2 = this.mChildHelper;
            ViewHolder childViewHolderInt = getChildViewHolderInt(childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(i)));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j) {
                Adapter adapter = this.mAdapter;
                if (adapter != null && adapter.hasStableIds()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(viewHolder);
                    sb.append(exceptionLabel());
                    throw new IllegalStateException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(viewHolder);
                sb2.append(exceptionLabel());
                throw new IllegalStateException(sb2.toString());
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb3.append(viewHolder2);
        sb3.append(" cannot be found but it is necessary for ");
        sb3.append(viewHolder);
        sb3.append(exceptionLabel());
        InstrumentInjector.log_e(TAG, sb3.toString());
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.PrepareContext && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.getAuthRequestContext.getAuthRequestContext(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.BuiltInFictitiousFunctionClassFactory(viewHolder, itemHolderInfo);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        ChildHelper childHelper = this.mChildHelper;
        int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
        if (MyBillsEntityDataFactory == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < MyBillsEntityDataFactory; i3++) {
            ChildHelper childHelper2 = this.mChildHelper;
            ViewHolder childViewHolderInt = getChildViewHolderInt(childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(i3)));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                sb.append(exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.hasStableIds() ? viewHolder.getItemId() : viewHolder.mPosition;
    }

    void animateAppearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.MyBillsEntityDataFactory(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.getAuthRequestContext(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.PlaceComponentResult(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.BuiltInFictitiousFunctionClassFactory(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.BuiltInFictitiousFunctionClassFactory();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void markItemDecorInsetsDirty() {
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            ((LayoutParams) this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i).getLayoutParams()).mInsetsDirty = true;
        }
        Recycler recycler = this.mRecycler;
        int size = recycler.MyBillsEntityDataFactory.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutParams layoutParams = (LayoutParams) recycler.MyBillsEntityDataFactory.get(i2).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        fsSuperDraw_b7ce570bd9ad6f07f00c4b0c33e98a42(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if ((z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.getAuthRequestContext()) ? z : true) {
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("RecyclerView has no LayoutManager");
            sb.append(exceptionLabel());
            throw new IllegalStateException(sb.toString());
        }
        return layoutManager.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("RecyclerView has no LayoutManager");
            sb.append(exceptionLabel());
            throw new IllegalStateException(sb.toString());
        }
        return layoutManager.generateLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("RecyclerView has no LayoutManager");
            sb.append(exceptionLabel());
            throw new IllegalStateException(sb.toString());
        }
        return layoutManager.generateLayoutParams(layoutParams);
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator != null && itemAnimator.getAuthRequestContext();
    }

    void saveOldPositions() {
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        Recycler recycler = this.mRecycler;
        int size = recycler.MyBillsEntityDataFactory.size();
        for (int i2 = 0; i2 < size; i2++) {
            recycler.MyBillsEntityDataFactory.get(i2).clearOldPosition();
        }
        int size2 = recycler.PlaceComponentResult.size();
        for (int i3 = 0; i3 < size2; i3++) {
            recycler.PlaceComponentResult.get(i3).clearOldPosition();
        }
        ArrayList<ViewHolder> arrayList = recycler.getAuthRequestContext;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i4 = 0; i4 < size3; i4++) {
                recycler.getAuthRequestContext.get(i4).clearOldPosition();
            }
        }
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        int i8 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i9 = 0; i9 < MyBillsEntityDataFactory; i9++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i9));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i4 && childViewHolderInt.mPosition <= i3) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i5, false);
                }
                this.mState.DatabaseTableConfigUtil = true;
            }
        }
        Recycler recycler = this.mRecycler;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i8 = 1;
        }
        int size = recycler.MyBillsEntityDataFactory.size();
        for (int i10 = 0; i10 < size; i10++) {
            ViewHolder viewHolder = recycler.MyBillsEntityDataFactory.get(i10);
            if (viewHolder != null && viewHolder.mPosition >= i7 && viewHolder.mPosition <= i6) {
                if (viewHolder.mPosition == i) {
                    viewHolder.offsetPosition(i2 - i, false);
                } else {
                    viewHolder.offsetPosition(i8, false);
                }
            }
        }
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i3 = 0; i3 < MyBillsEntityDataFactory; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.DatabaseTableConfigUtil = true;
            }
        }
        Recycler recycler = this.mRecycler;
        int size = recycler.MyBillsEntityDataFactory.size();
        for (int i4 = 0; i4 < size; i4++) {
            ViewHolder viewHolder = recycler.MyBillsEntityDataFactory.get(i4);
            if (viewHolder != null && viewHolder.mPosition >= i) {
                viewHolder.offsetPosition(i2, false);
            }
        }
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i3 = 0; i3 < MyBillsEntityDataFactory; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i + i2) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.DatabaseTableConfigUtil = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.DatabaseTableConfigUtil = true;
                }
            }
        }
        Recycler recycler = this.mRecycler;
        for (int size = recycler.MyBillsEntityDataFactory.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = recycler.MyBillsEntityDataFactory.get(size);
            if (viewHolder != null) {
                if (viewHolder.mPosition >= i + i2) {
                    viewHolder.offsetPosition(-i2, z);
                } else if (viewHolder.mPosition >= i) {
                    viewHolder.addFlags(8);
                    recycler.BuiltInFictitiousFunctionClassFactory(recycler.MyBillsEntityDataFactory.get(size), true);
                    recycler.MyBillsEntityDataFactory.remove(size);
                }
            }
        }
        requestLayout();
    }

    void viewRangeUpdate(int i, int i2, Object obj) {
        int i3;
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i4 = 0; i4 < MyBillsEntityDataFactory; i4++) {
            View authRequestContext = this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i4);
            ViewHolder childViewHolderInt = getChildViewHolderInt(authRequestContext);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i + i2) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) authRequestContext.getLayoutParams()).mInsetsDirty = true;
            }
        }
        Recycler recycler = this.mRecycler;
        for (int size = recycler.MyBillsEntityDataFactory.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = recycler.MyBillsEntityDataFactory.get(size);
            if (viewHolder != null && (i3 = viewHolder.mPosition) >= i && i3 < i2 + i) {
                viewHolder.addFlags(2);
                recycler.BuiltInFictitiousFunctionClassFactory(recycler.MyBillsEntityDataFactory.get(size), true);
                recycler.MyBillsEntityDataFactory.remove(size);
            }
        }
    }

    boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator == null || itemAnimator.BuiltInFictitiousFunctionClassFactory(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        Recycler recycler = this.mRecycler;
        int size = recycler.MyBillsEntityDataFactory.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewHolder viewHolder = recycler.MyBillsEntityDataFactory.get(i2);
            if (viewHolder != null) {
                viewHolder.addFlags(6);
                viewHolder.addChangePayload(null);
            }
        }
        if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
            recycler.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a direct child of ");
            sb.append(this);
            throw new IllegalArgumentException(sb.toString());
        }
        return getChildViewHolderInt(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 == r2) goto L17
            r3 = 0
        L17:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i2 = 0; i2 < MyBillsEntityDataFactory; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i) {
                if (!this.mChildHelper.MyBillsEntityDataFactory(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.ViewHolder findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.ChildHelper r0 = r5.mChildHelper
            androidx.recyclerview.widget.ChildHelper$Callback r0 = r0.MyBillsEntityDataFactory
            int r0 = r0.MyBillsEntityDataFactory()
            r1 = 0
            r2 = 0
        La:
            if (r2 >= r0) goto L3e
            androidx.recyclerview.widget.ChildHelper r3 = r5.mChildHelper
            androidx.recyclerview.widget.ChildHelper$Callback r3 = r3.MyBillsEntityDataFactory
            android.view.View r3 = r3.getAuthRequestContext(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L3b
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L3b
            if (r7 == 0) goto L27
            int r4 = r3.mPosition
            if (r4 == r6) goto L2e
            goto L3b
        L27:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2e
            goto L3b
        L2e:
            androidx.recyclerview.widget.ChildHelper r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.MyBillsEntityDataFactory(r4)
            if (r1 == 0) goto L3a
            r1 = r3
            goto L3b
        L3a:
            return r3
        L3b:
            int r2 = r2 + 1
            goto La
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int MyBillsEntityDataFactory = this.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
            for (int i = 0; i < MyBillsEntityDataFactory; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (!this.mChildHelper.MyBillsEntityDataFactory(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public View findChildViewUnder(float f, float f2) {
        ChildHelper childHelper = this.mChildHelper;
        for (int MyBillsEntityDataFactory = (childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size()) - 1; MyBillsEntityDataFactory >= 0; MyBillsEntityDataFactory--) {
            ChildHelper childHelper2 = this.mChildHelper;
            View authRequestContext = childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            float translationX = authRequestContext.getTranslationX();
            float translationY = authRequestContext.getTranslationY();
            if (f >= authRequestContext.getLeft() + translationX && f <= authRequestContext.getRight() + translationX && f2 >= authRequestContext.getTop() + translationY && f2 <= authRequestContext.getBottom() + translationY) {
                return authRequestContext;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_b7ce570bd9ad6f07f00c4b0c33e98a42(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        ChildHelper childHelper = this.mChildHelper;
        int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
        for (int i2 = 0; i2 < MyBillsEntityDataFactory; i2++) {
            ChildHelper childHelper2 = this.mChildHelper;
            childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(i2)).offsetTopAndBottom(i);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        ChildHelper childHelper = this.mChildHelper;
        int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
        for (int i2 = 0; i2 < MyBillsEntityDataFactory; i2++) {
            ChildHelper childHelper2 = this.mChildHelper;
            childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(i2)).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        int left = view.getLeft();
        int i = rect2.left;
        int i2 = layoutParams.leftMargin;
        int top = view.getTop();
        int i3 = rect2.top;
        int i4 = layoutParams.topMargin;
        int right = view.getRight();
        int i5 = rect2.right;
        rect.set((left - i) - i2, (top - i3) - i4, right + i5 + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.KClassImpl$Data$declaredNonStaticMembers$2() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        int MyBillsEntityDataFactory;
        OverScroller PlaceComponentResult;
        int getAuthRequestContext;
        Interpolator KClassImpl$Data$declaredNonStaticMembers$2 = RecyclerView.sQuinticInterpolator;
        boolean BuiltInFictitiousFunctionClassFactory = false;
        boolean getErrorConfigVersion = false;

        ViewFlinger() {
            this.PlaceComponentResult = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            if (RecyclerView.this.mLayout != null) {
                this.getErrorConfigVersion = false;
                this.BuiltInFictitiousFunctionClassFactory = true;
                RecyclerView.this.consumePendingUpdateOperations();
                OverScroller overScroller = this.PlaceComponentResult;
                if (overScroller.computeScrollOffset()) {
                    int currX = overScroller.getCurrX();
                    int currY = overScroller.getCurrY();
                    int i4 = currX - this.getAuthRequestContext;
                    int i5 = currY - this.MyBillsEntityDataFactory;
                    this.getAuthRequestContext = currX;
                    this.MyBillsEntityDataFactory = currY;
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView = RecyclerView.this;
                    if (recyclerView.dispatchNestedPreScroll(i4, i5, recyclerView.mReusableIntPair, null, 1)) {
                        i4 -= RecyclerView.this.mReusableIntPair[0];
                        i5 -= RecyclerView.this.mReusableIntPair[1];
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.considerReleasingGlowsOnScroll(i4, i5);
                    }
                    if (RecyclerView.this.mAdapter != null) {
                        RecyclerView.this.mReusableIntPair[0] = 0;
                        RecyclerView.this.mReusableIntPair[1] = 0;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.scrollStep(i4, i5, recyclerView2.mReusableIntPair);
                        i = RecyclerView.this.mReusableIntPair[0];
                        i2 = RecyclerView.this.mReusableIntPair[1];
                        i4 -= i;
                        i5 -= i2;
                        SmoothScroller smoothScroller = RecyclerView.this.mLayout.mSmoothScroller;
                        if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                            State state = RecyclerView.this.mState;
                            if (state.BuiltInFictitiousFunctionClassFactory) {
                                i3 = state.getErrorConfigVersion - state.PlaceComponentResult;
                            } else {
                                i3 = state.scheduleImpl;
                            }
                            if (i3 == 0) {
                                smoothScroller.stop();
                            } else if (smoothScroller.getTargetPosition() >= i3) {
                                smoothScroller.setTargetPosition(i3 - 1);
                                smoothScroller.onAnimation(i, i2);
                            } else {
                                smoothScroller.onAnimation(i, i2);
                            }
                        }
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                        RecyclerView.this.invalidate();
                    }
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.dispatchNestedScroll(i, i2, i4, i5, null, 1, recyclerView3.mReusableIntPair);
                    int i6 = i4 - RecyclerView.this.mReusableIntPair[0];
                    int i7 = i5 - RecyclerView.this.mReusableIntPair[1];
                    if (i != 0 || i2 != 0) {
                        RecyclerView.this.dispatchOnScrolled(i, i2);
                    }
                    if (!RecyclerView.this.awakenScrollBars()) {
                        RecyclerView.this.invalidate();
                    }
                    boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                    SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                    if (!(smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) && z) {
                        if (RecyclerView.this.getOverScrollMode() != 2) {
                            int currVelocity = (int) overScroller.getCurrVelocity();
                            int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                            if (i7 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i7 <= 0) {
                                currVelocity = 0;
                            }
                            RecyclerView.this.absorbGlows(i8, currVelocity);
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                            GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                            int[] iArr = layoutPrefetchRegistryImpl.MyBillsEntityDataFactory;
                            if (iArr != null) {
                                Arrays.fill(iArr, -1);
                            }
                            layoutPrefetchRegistryImpl.getAuthRequestContext = 0;
                        }
                    } else {
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        if (RecyclerView.this.mGapWorker != null) {
                            RecyclerView.this.mGapWorker.getAuthRequestContext(RecyclerView.this, i, i2);
                        }
                    }
                }
                SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
                if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                    smoothScroller3.onAnimation(0, 0);
                }
                this.BuiltInFictitiousFunctionClassFactory = false;
                if (!this.getErrorConfigVersion) {
                    RecyclerView.this.setScrollState(0);
                    RecyclerView.this.stopNestedScroll(1);
                    return;
                }
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.PlaceComponentResult(RecyclerView.this, this);
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            this.PlaceComponentResult.abortAnimation();
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                this.getErrorConfigVersion = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.PlaceComponentResult(RecyclerView.this, this);
        }

        public final void getAuthRequestContext(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = PlaceComponentResult(i, i2);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != interpolator) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = interpolator;
                this.PlaceComponentResult = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.MyBillsEntityDataFactory = 0;
            this.getAuthRequestContext = 0;
            RecyclerView.this.setScrollState(2);
            this.PlaceComponentResult.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.PlaceComponentResult.computeScrollOffset();
            }
            KClassImpl$Data$declaredNonStaticMembers$2();
        }

        private int PlaceComponentResult(int i, int i2) {
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                abs = abs2;
            }
            return Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }
    }

    void repositionShadowingViews() {
        ChildHelper childHelper = this.mChildHelper;
        int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            ChildHelper childHelper2 = this.mChildHelper;
            View authRequestContext = childHelper2.MyBillsEntityDataFactory.getAuthRequestContext(childHelper2.BuiltInFictitiousFunctionClassFactory(i));
            ViewHolder childViewHolder = getChildViewHolder(authRequestContext);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = authRequestContext.getLeft();
                int top = authRequestContext.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.DatabaseTableConfigUtil = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.KClassImpl$Data$declaredNonStaticMembers$2()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.BuiltInFictitiousFunctionClassFactory(i, i2, obj)) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.PlaceComponentResult(i, i2)) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.BuiltInFictitiousFunctionClassFactory(i, i2)) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.PlaceComponentResult(i, i2, i3)) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        private void BuiltInFictitiousFunctionClassFactory() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
                RecyclerView recyclerView = RecyclerView.this;
                ViewCompat.PlaceComponentResult(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                return;
            }
            RecyclerView.this.mAdapterUpdateDuringMeasure = true;
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            if (RecyclerView.this.mPendingSavedState == null || (adapter = RecyclerView.this.mAdapter) == null || !adapter.canRestoreState()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface EdgeDirection {
        }

        protected EdgeEffect BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {
        SparseArray<ScrapData> BuiltInFictitiousFunctionClassFactory = new SparseArray<>();
        int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class ScrapData {
            final ArrayList<ViewHolder> MyBillsEntityDataFactory = new ArrayList<>();
            int PlaceComponentResult = 5;
            long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            long BuiltInFictitiousFunctionClassFactory = 0;

            ScrapData() {
            }
        }

        public final ViewHolder PlaceComponentResult(int i) {
            ScrapData scrapData = this.BuiltInFictitiousFunctionClassFactory.get(i);
            if (scrapData == null || scrapData.MyBillsEntityDataFactory.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = scrapData.MyBillsEntityDataFactory;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public final void MyBillsEntityDataFactory(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = KClassImpl$Data$declaredNonStaticMembers$2(itemViewType).MyBillsEntityDataFactory;
            if (this.BuiltInFictitiousFunctionClassFactory.get(itemViewType).PlaceComponentResult <= arrayList.size()) {
                return;
            }
            viewHolder.resetInternal();
            arrayList.add(viewHolder);
        }

        static long MyBillsEntityDataFactory(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        final void BuiltInFictitiousFunctionClassFactory(int i, long j) {
            ScrapData KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(i);
            long j2 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (j2 != 0) {
                j = (j / 4) + ((j2 / 4) * 3);
            }
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        }

        final boolean BuiltInFictitiousFunctionClassFactory(int i, long j, long j2) {
            long j3 = KClassImpl$Data$declaredNonStaticMembers$2(i).KClassImpl$Data$declaredNonStaticMembers$2;
            return j3 == 0 || j + j3 < j2;
        }

        final boolean getAuthRequestContext(int i, long j, long j2) {
            long j3 = KClassImpl$Data$declaredNonStaticMembers$2(i).BuiltInFictitiousFunctionClassFactory;
            return j3 == 0 || j + j3 < j2;
        }

        final ScrapData KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            ScrapData scrapData = this.BuiltInFictitiousFunctionClassFactory.get(i);
            if (scrapData == null) {
                ScrapData scrapData2 = new ScrapData();
                this.BuiltInFictitiousFunctionClassFactory.put(i, scrapData2);
                return scrapData2;
            }
            return scrapData;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
                if (findNestedRecyclerView != null) {
                    return findNestedRecyclerView;
                }
            }
            return null;
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        if (viewHolder.mNestedRecyclerView != null) {
            RecyclerView recyclerView = viewHolder.mNestedRecyclerView.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.itemView) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* loaded from: classes.dex */
    public final class Recycler {
        RecycledViewPool BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        final ArrayList<ViewHolder> MyBillsEntityDataFactory;
        public final ArrayList<ViewHolder> PlaceComponentResult;
        ArrayList<ViewHolder> getAuthRequestContext;
        ViewCacheExtension getErrorConfigVersion;
        int lookAheadTest;
        final List<ViewHolder> moveToNextValue;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.PlaceComponentResult = arrayList;
            this.getAuthRequestContext = null;
            this.MyBillsEntityDataFactory = new ArrayList<>();
            this.moveToNextValue = Collections.unmodifiableList(arrayList);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
            this.lookAheadTest = 2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void PlaceComponentResult() {
            this.lookAheadTest = this.KClassImpl$Data$declaredNonStaticMembers$2 + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.MyBillsEntityDataFactory.size() - 1; size >= 0 && this.MyBillsEntityDataFactory.size() > this.lookAheadTest; size--) {
                BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get(size), true);
                this.MyBillsEntityDataFactory.remove(size);
            }
        }

        private boolean PlaceComponentResult(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.mState.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            if (viewHolder.mPosition < 0 || viewHolder.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistency detected. Invalid view holder adapter position");
                sb.append(viewHolder);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (RecyclerView.this.mState.KClassImpl$Data$declaredNonStaticMembers$2() || RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) == viewHolder.getItemViewType()) {
                return !RecyclerView.this.mAdapter.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition);
            } else {
                return false;
            }
        }

        private boolean KClassImpl$Data$declaredNonStaticMembers$2(ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j == Long.MAX_VALUE || this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(itemViewType, nanoTime, j)) {
                RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i);
                long nanoTime2 = RecyclerView.this.getNanoTime();
                RecycledViewPool.ScrapData KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(viewHolder.getItemViewType());
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = RecycledViewPool.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, nanoTime2 - nanoTime);
                if (RecyclerView.this.isAccessibilityEnabled()) {
                    View view = viewHolder.itemView;
                    if (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(view) == 0) {
                        ViewCompat.moveToNextValue(view, 1);
                    }
                    if (RecyclerView.this.mAccessibilityDelegate != null) {
                        AccessibilityDelegateCompat itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                        if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                            RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate2 = (RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate;
                            AccessibilityDelegateCompat PlaceComponentResult = ViewCompat.PlaceComponentResult(view);
                            if (PlaceComponentResult != null && PlaceComponentResult != itemDelegate2) {
                                itemDelegate2.MyBillsEntityDataFactory.put(view, PlaceComponentResult);
                            }
                        }
                        ViewCompat.MyBillsEntityDataFactory(view, itemDelegate);
                    }
                }
                if (RecyclerView.this.mState.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    viewHolder.mPreLayoutPosition = i2;
                }
                return true;
            }
            return false;
        }

        public final int PlaceComponentResult(int i) {
            int i2;
            int i3;
            if (i >= 0) {
                State state = RecyclerView.this.mState;
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i3 = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i3 = state.scheduleImpl;
                }
                if (i < i3) {
                    return !RecyclerView.this.mState.KClassImpl$Data$declaredNonStaticMembers$2() ? i : RecyclerView.this.mAdapterHelper.KClassImpl$Data$declaredNonStaticMembers$2(i, 0);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("invalid position ");
            sb.append(i);
            sb.append(". State item count is ");
            State state2 = RecyclerView.this.mState;
            if (state2.BuiltInFictitiousFunctionClassFactory) {
                i2 = state2.getErrorConfigVersion - state2.PlaceComponentResult;
            } else {
                i2 = state2.scheduleImpl;
            }
            sb.append(i2);
            sb.append(RecyclerView.this.exceptionLabel());
            throw new IndexOutOfBoundsException(sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final View MyBillsEntityDataFactory(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i, Long.MAX_VALUE).itemView;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:106:0x021f  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x022d  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0249 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01c1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final androidx.recyclerview.widget.RecyclerView.ViewHolder KClassImpl$Data$declaredNonStaticMembers$2(int r18, long r19) {
            /*
                Method dump skipped, instructions count: 656
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.KClassImpl$Data$declaredNonStaticMembers$2(int, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    KClassImpl$Data$declaredNonStaticMembers$2((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void PlaceComponentResult(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            BuiltInFictitiousFunctionClassFactory(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.KClassImpl$Data$declaredNonStaticMembers$2(childViewHolderInt);
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            for (int size = this.MyBillsEntityDataFactory.size() - 1; size >= 0; size--) {
                BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get(size), true);
                this.MyBillsEntityDataFactory.remove(size);
            }
            this.MyBillsEntityDataFactory.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = layoutPrefetchRegistryImpl.MyBillsEntityDataFactory;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                layoutPrefetchRegistryImpl.getAuthRequestContext = 0;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        
            if (r6.NetworkUserEntityData$$ExternalSyntheticLambda0.mPrefetchRegistry.getAuthRequestContext(r7.mPosition) == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        
            r3 = r3 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        
            if (r3 < 0) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
        
            if (r6.NetworkUserEntityData$$ExternalSyntheticLambda0.mPrefetchRegistry.getAuthRequestContext(r6.MyBillsEntityDataFactory.get(r3).mPosition) == false) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
        
            r3 = r3 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void BuiltInFictitiousFunctionClassFactory(androidx.recyclerview.widget.RecyclerView.ViewHolder r7) {
            /*
                Method dump skipped, instructions count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.BuiltInFictitiousFunctionClassFactory(androidx.recyclerview.widget.RecyclerView$ViewHolder):void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void BuiltInFictitiousFunctionClassFactory(ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            if (RecyclerView.this.mAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                ViewCompat.MyBillsEntityDataFactory(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).MyBillsEntityDataFactory.remove(view) : null);
            }
            if (z) {
                KClassImpl$Data$declaredNonStaticMembers$2(viewHolder);
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new RecycledViewPool();
            }
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(viewHolder);
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.hasAnyOfTheFlags(12) || !childViewHolderInt.isUpdated() || RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                    sb.append(RecyclerView.this.exceptionLabel());
                    throw new IllegalArgumentException(sb.toString());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.PlaceComponentResult.add(childViewHolderInt);
                return;
            }
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.getAuthRequestContext.add(childViewHolderInt);
        }

        final void getAuthRequestContext(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.getAuthRequestContext.remove(viewHolder);
            } else {
                this.PlaceComponentResult.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        private ViewHolder getAuthRequestContext(int i) {
            int size;
            int KClassImpl$Data$declaredNonStaticMembers$2;
            ArrayList<ViewHolder> arrayList = this.getAuthRequestContext;
            if (arrayList == null || (size = arrayList.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.getAuthRequestContext.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (!RecyclerView.this.mAdapter.hasStableIds() || (KClassImpl$Data$declaredNonStaticMembers$2 = RecyclerView.this.mAdapterHelper.KClassImpl$Data$declaredNonStaticMembers$2(i, 0)) <= 0 || KClassImpl$Data$declaredNonStaticMembers$2 >= RecyclerView.this.mAdapter.getItemCount()) {
                return null;
            }
            long itemId = RecyclerView.this.mAdapter.getItemId(KClassImpl$Data$declaredNonStaticMembers$2);
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder2 = this.getAuthRequestContext.get(i3);
                if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                    viewHolder2.addFlags(32);
                    return viewHolder2;
                }
            }
            return null;
        }

        private ViewHolder getAuthRequestContext(int i, boolean z) {
            View view;
            int size = this.PlaceComponentResult.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.PlaceComponentResult.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i && !viewHolder.isInvalid() && (RecyclerView.this.mState.BuiltInFictitiousFunctionClassFactory || !viewHolder.isRemoved())) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            ChildHelper childHelper = RecyclerView.this.mChildHelper;
            int size2 = childHelper.BuiltInFictitiousFunctionClassFactory.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    view = null;
                    break;
                }
                view = childHelper.BuiltInFictitiousFunctionClassFactory.get(i3);
                ViewHolder KClassImpl$Data$declaredNonStaticMembers$2 = childHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(view);
                if (KClassImpl$Data$declaredNonStaticMembers$2.getLayoutPosition() == i && !KClassImpl$Data$declaredNonStaticMembers$2.isInvalid() && !KClassImpl$Data$declaredNonStaticMembers$2.isRemoved()) {
                    break;
                }
                i3++;
            }
            if (view != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                ChildHelper childHelper2 = RecyclerView.this.mChildHelper;
                int MyBillsEntityDataFactory = childHelper2.MyBillsEntityDataFactory.MyBillsEntityDataFactory(view);
                if (MyBillsEntityDataFactory < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("view is not a child, cannot hide ");
                    sb.append(view);
                    throw new IllegalArgumentException(sb.toString());
                } else if (!childHelper2.getAuthRequestContext.PlaceComponentResult(MyBillsEntityDataFactory)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("trying to unhide a view that was not hidden");
                    sb2.append(view);
                    throw new RuntimeException(sb2.toString());
                } else {
                    childHelper2.getAuthRequestContext.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
                    childHelper2.KClassImpl$Data$declaredNonStaticMembers$2(view);
                    int authRequestContext = RecyclerView.this.mChildHelper.getAuthRequestContext(view);
                    if (authRequestContext == -1) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("layout index should not be -1 after unhiding a view:");
                        sb3.append(childViewHolderInt);
                        sb3.append(RecyclerView.this.exceptionLabel());
                        throw new IllegalStateException(sb3.toString());
                    }
                    ChildHelper childHelper3 = RecyclerView.this.mChildHelper;
                    int BuiltInFictitiousFunctionClassFactory = childHelper3.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                    childHelper3.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                    childHelper3.MyBillsEntityDataFactory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    KClassImpl$Data$declaredNonStaticMembers$2(view);
                    childViewHolderInt.addFlags(8224);
                    return childViewHolderInt;
                }
            }
            int size3 = this.MyBillsEntityDataFactory.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ViewHolder viewHolder2 = this.MyBillsEntityDataFactory.get(i4);
                if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i && !viewHolder2.isAttachedToTransitionOverlay()) {
                    this.MyBillsEntityDataFactory.remove(i4);
                    return viewHolder2;
                }
            }
            return null;
        }

        private ViewHolder MyBillsEntityDataFactory(long j, int i, boolean z) {
            for (int size = this.PlaceComponentResult.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.PlaceComponentResult.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.wasReturnedFromScrap()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    }
                    this.PlaceComponentResult.remove(size);
                    RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(viewHolder.itemView);
                    childViewHolderInt.mScrapContainer = null;
                    childViewHolderInt.mInChangeScrap = false;
                    childViewHolderInt.clearReturnedFromScrapFlag();
                    BuiltInFictitiousFunctionClassFactory(childViewHolderInt);
                }
            }
            for (int size2 = this.MyBillsEntityDataFactory.size() - 1; size2 >= 0; size2--) {
                ViewHolder viewHolder2 = this.MyBillsEntityDataFactory.get(size2);
                if (viewHolder2.getItemId() == j && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i == viewHolder2.getItemViewType()) {
                        this.MyBillsEntityDataFactory.remove(size2);
                        return viewHolder2;
                    }
                    BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get(size2), true);
                    this.MyBillsEntityDataFactory.remove(size2);
                    return null;
                }
            }
            return null;
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(ViewHolder viewHolder) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i = 0; i < size; i++) {
                RecyclerView.this.mRecyclerListeners.get(i);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.MyBillsEntityDataFactory(viewHolder);
            }
        }

        public final View BuiltInFictitiousFunctionClassFactory(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i, Long.MAX_VALUE).itemView;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* loaded from: classes.dex */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends ViewHolder> adapter, ViewHolder viewHolder, int i) {
            if (adapter == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                TraceCompat.BuiltInFictitiousFunctionClassFactory(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                onCreateViewHolder.mItemViewType = i;
                return onCreateViewHolder;
            } finally {
                TraceCompat.BuiltInFictitiousFunctionClassFactory();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            boolean z = vh.mBindingAdapter == null;
            if (z) {
                vh.mPosition = i;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i);
                }
                vh.setFlags(1, 519);
                TraceCompat.BuiltInFictitiousFunctionClassFactory(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            if (z) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                TraceCompat.BuiltInFictitiousFunctionClassFactory();
            }
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.PlaceComponentResult();
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.MyBillsEntityDataFactory(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.MyBillsEntityDataFactory(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.MyBillsEntityDataFactory(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.MyBillsEntityDataFactory(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.getAuthRequestContext(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.BuiltInFictitiousFunctionClassFactory(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.getAuthRequestContext(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.PlaceComponentResult(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.PlaceComponentResult(i, i2);
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.MyBillsEntityDataFactory();
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        boolean canRestoreState() {
            int i = AnonymousClass7.PlaceComponentResult[this.mStateRestorationPolicy.ordinal()];
            if (i != 1) {
                return i != 2 || getItemCount() > 0;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$7  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).getAuthRequestContext(view);
            }
        }
    }

    void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).MyBillsEntityDataFactory(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {
        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void BuiltInFictitiousFunctionClassFactory(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class Properties {
            public boolean BuiltInFictitiousFunctionClassFactory;
            public boolean KClassImpl$Data$declaredNonStaticMembers$2;
            public int MyBillsEntityDataFactory;
            public int PlaceComponentResult;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onLayoutCompleted(State state) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback callback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final View MyBillsEntityDataFactory(int i) {
                    return LayoutManager.this.getChildAt(i);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int MyBillsEntityDataFactory() {
                    return LayoutManager.this.getPaddingLeft();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getAuthRequestContext() {
                    return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getAuthRequestContext(View view) {
                    return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int KClassImpl$Data$declaredNonStaticMembers$2(View view) {
                    return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
                }
            };
            this.mHorizontalBoundCheckCallback = callback;
            ViewBoundsCheck.Callback callback2 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final View MyBillsEntityDataFactory(int i) {
                    return LayoutManager.this.getChildAt(i);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int MyBillsEntityDataFactory() {
                    return LayoutManager.this.getPaddingTop();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getAuthRequestContext() {
                    return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getAuthRequestContext(View view) {
                    return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int KClassImpl$Data$declaredNonStaticMembers$2(View view) {
                    return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
                }
            };
            this.mVerticalBoundCheckCallback = callback2;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(callback);
            this.mVerticalBoundCheck = new ViewBoundsCheck(callback2);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i3, i4, i5, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            int width = rect.width();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int height = rect.height();
            int paddingTop = getPaddingTop();
            setMeasuredDimension(chooseSize(i, width + paddingLeft + paddingRight, getMinimumWidth()), chooseSize(i2, height + paddingTop + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.PlaceComponentResult();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.PlaceComponentResult(recyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            InstrumentInjector.log_e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            InstrumentInjector.log_e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public int getLayoutDirection() {
            return ViewCompat.initRecordTimeStamp(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        private void addViewInt(View view, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2(childViewHolderInt);
            } else {
                ViewInfoStore.InfoRecord infoRecord = this.mRecyclerView.mViewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2.get(childViewHolderInt);
                if (infoRecord != null) {
                    infoRecord.MyBillsEntityDataFactory &= -2;
                }
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.KClassImpl$Data$declaredNonStaticMembers$2(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int authRequestContext = this.mChildHelper.getAuthRequestContext(view);
                if (i == -1) {
                    ChildHelper childHelper = this.mChildHelper;
                    i = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
                }
                if (authRequestContext == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.mRecyclerView.indexOfChild(view));
                    sb.append(this.mRecyclerView.exceptionLabel());
                    throw new IllegalStateException(sb.toString());
                } else if (authRequestContext != i) {
                    this.mRecyclerView.mLayout.moveView(authRequestContext, i);
                }
            } else {
                this.mChildHelper.MyBillsEntityDataFactory(view, i, false);
                layoutParams.mInsetsDirty = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public void removeView(View view) {
            ChildHelper childHelper = this.mChildHelper;
            int MyBillsEntityDataFactory = childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory(view);
            if (MyBillsEntityDataFactory >= 0) {
                if (childHelper.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory)) {
                    childHelper.KClassImpl$Data$declaredNonStaticMembers$2(view);
                }
                childHelper.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
            }
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.MyBillsEntityDataFactory(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.MyBillsEntityDataFactory(childCount);
            }
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.MyBillsEntityDataFactory(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.KClassImpl$Data$declaredNonStaticMembers$2() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int authRequestContext = this.mChildHelper.getAuthRequestContext(view);
            if (authRequestContext >= 0) {
                detachViewInternal(authRequestContext, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        private void detachViewInternal(int i, View view) {
            ChildHelper childHelper = this.mChildHelper;
            int BuiltInFictitiousFunctionClassFactory = childHelper.BuiltInFictitiousFunctionClassFactory(i);
            childHelper.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
            childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2(childViewHolderInt);
            } else {
                ViewInfoStore.InfoRecord infoRecord = this.mRecyclerView.mViewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2.get(childViewHolderInt);
                if (infoRecord != null) {
                    infoRecord.MyBillsEntityDataFactory &= -2;
                }
            }
            this.mChildHelper.KClassImpl$Data$declaredNonStaticMembers$2(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot move a child from non-existing index:");
                sb.append(i);
                sb.append(this.mRecyclerView.toString());
                throw new IllegalArgumentException(sb.toString());
            }
            detachViewAt(i);
            attachView(childAt, i2);
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.getAuthRequestContext(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler) {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.PlaceComponentResult(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.PlaceComponentResult(childAt);
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() - childHelper.BuiltInFictitiousFunctionClassFactory.size();
            }
            return 0;
        }

        public View getChildAt(int i) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.MyBillsEntityDataFactory.getAuthRequestContext(childHelper.BuiltInFictitiousFunctionClassFactory(i));
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda4(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda6(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.MyBillsEntityDataFactory(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("View should be fully attached to be ignored");
                sb.append(this.mRecyclerView.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.MyBillsEntityDataFactory(childViewHolderInt);
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                recycler.BuiltInFictitiousFunctionClassFactory(childViewHolderInt);
                return;
            }
            detachViewAt(i);
            recycler.KClassImpl$Data$declaredNonStaticMembers$2(view);
            ViewInfoStore.InfoRecord infoRecord = this.mRecyclerView.mViewInfoStore.KClassImpl$Data$declaredNonStaticMembers$2.get(childViewHolderInt);
            if (infoRecord != null) {
                infoRecord.MyBillsEntityDataFactory &= -2;
            }
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left;
            int i4 = itemDecorInsetsForChild.right;
            int i5 = itemDecorInsetsForChild.top;
            int i6 = itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i + i3 + i4, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i2 + i5 + i6, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, layoutParams.width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, layoutParams.width) && isMeasurementUpToDate(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i;
                } else {
                    return true;
                }
            }
            return false;
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left;
            int i4 = itemDecorInsetsForChild.right;
            int i5 = itemDecorInsetsForChild.top;
            int i6 = itemDecorInsetsForChild.bottom;
            int width = getWidth();
            int widthMode = getWidthMode();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int i7 = layoutParams.leftMargin;
            int childMeasureSpec = getChildMeasureSpec(width, widthMode, paddingLeft + paddingRight + i7 + layoutParams.rightMargin + i + i3 + i4, layoutParams.width, canScrollHorizontally());
            int height = getHeight();
            int heightMode = getHeightMode();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i8 = layoutParams.topMargin;
            int childMeasureSpec2 = getChildMeasureSpec(height, heightMode, paddingTop + paddingBottom + i8 + layoutParams.bottomMargin + i2 + i5 + i6, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        
            if (r3 < 0) goto L15;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Ld
                if (r3 >= 0) goto Lf
                goto L1f
            Ld:
                if (r3 < 0) goto L12
            Lf:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L20
            L12:
                r4 = -1
                if (r3 != r4) goto L18
                r2 = 1073741824(0x40000000, float:2.0)
                goto L1d
            L18:
                r4 = -2
                if (r3 != r4) goto L1f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L1d:
                r3 = r1
                goto L20
            L1f:
                r3 = 0
            L20:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        
            if (r4 == 1073741824) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r3, int r4, int r5, int r6, boolean r7) {
            /*
                int r3 = r3 - r5
                r5 = 0
                int r3 = java.lang.Math.max(r5, r3)
                r0 = -1
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = 1073741824(0x40000000, float:2.0)
                if (r7 == 0) goto L18
                if (r6 >= 0) goto L1a
                if (r6 != r0) goto L2e
                if (r4 == r1) goto L2b
                if (r4 == 0) goto L2e
                if (r4 == r2) goto L2b
                goto L2e
            L18:
                if (r6 < 0) goto L1d
            L1a:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L2f
            L1d:
                if (r6 != r0) goto L20
                goto L2b
            L20:
                r7 = -2
                if (r6 != r7) goto L2e
                if (r4 == r1) goto L29
                if (r4 == r2) goto L29
                r4 = 0
                goto L2b
            L29:
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
            L2b:
                r6 = r3
                r5 = r4
                goto L2f
            L2e:
                r6 = 0
            L2f:
                int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r5)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i + rect.left + layoutParams.leftMargin, i2 + rect.top + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth();
            int paddingRight = getPaddingRight();
            int height = getHeight();
            int paddingBottom = getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width();
            int height2 = rect.height();
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = (width2 + left) - (width - paddingRight);
            int max = Math.max(0, i3);
            int max2 = Math.max(0, (height2 + top) - (height - paddingBottom));
            if (getLayoutDirection() == 1) {
                min = max != 0 ? max : Math.max(min, i3);
            } else if (min == 0) {
                min = Math.min(i, max);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = min;
            iArr[1] = min2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((!z2 || isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) && !(i == 0 && i2 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i, i2);
                } else {
                    recyclerView.smoothScrollBy(i, i2);
                }
                return true;
            }
            return false;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.getAuthRequestContext(view) && this.mVerticalBoundCheck.getAuthRequestContext(view);
            return z ? z3 : !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth();
            int paddingRight = getPaddingRight();
            int height = getHeight();
            int paddingBottom = getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width - paddingRight && rect.right - i > paddingLeft && rect.top - i2 < height - paddingBottom && rect.bottom - i2 > paddingTop;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onMeasure(Recycler recycler, State state, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda7(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return ViewCompat.PrepareContext(this.mRecyclerView);
        }

        void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(8192);
                accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(4096);
                accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(true);
            }
            accessibilityNodeInfoCompat.PlaceComponentResult(AccessibilityNodeInfoCompat.CollectionInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.mRecyclerView.mAdapter != null) {
                accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.MyBillsEntityDataFactory(childViewHolderInt.itemView)) {
                return;
            }
            onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int i, Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, i, i2);
            properties.PlaceComponentResult = obtainStyledAttributes.getInt(R.styleable.moveToNextValue, 1);
            properties.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(R.styleable.PrepareContext, 1);
            properties.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(R.styleable.newProxyInstance, false);
            properties.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getBoolean(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        void removeAndRecycleScrapInt(Recycler recycler) {
            int size = recycler.PlaceComponentResult.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = recycler.PlaceComponentResult.get(i).itemView;
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.KClassImpl$Data$declaredNonStaticMembers$2(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    recycler.BuiltInFictitiousFunctionClassFactory(childViewHolderInt2);
                }
            }
            recycler.PlaceComponentResult.clear();
            ArrayList<ViewHolder> arrayList = recycler.getAuthRequestContext;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter<? extends ViewHolder> mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        Recycler mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.getAuthRequestContext(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | ((i2 ^ (-1)) & this.mFlags);
        }

        void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list == null || list.size() == 0) {
                    return FULLUPDATE_PAYLOADS;
                }
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append(simpleName);
            sb.append("{");
            sb.append(Integer.toHexString(hashCode()));
            sb.append(" position=");
            sb.append(this.mPosition);
            sb.append(" id=");
            sb.append(this.mItemId);
            sb.append(", oldPos=");
            sb.append(this.mOldPosition);
            sb.append(", pLpos:");
            sb.append(this.mPreLayoutPosition);
            StringBuilder sb2 = new StringBuilder(sb.toString());
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" not recyclable(");
                sb3.append(this.mIsRecyclableCount);
                sb3.append(")");
                sb2.append(sb3.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                StringBuilder sb = new StringBuilder();
                sb.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb.append(this);
                InstrumentInjector.log_e("View", sb.toString());
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && i2 == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.B(this.itemView);
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.B(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.moveToNextValue(viewHolder.itemView, i);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.moveToNextValue(viewHolder.itemView, i);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        AdapterHelper adapterHelper = this.mAdapterHelper;
        int i = viewHolder.mPosition;
        int size = adapterHelper.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
        for (int i2 = 0; i2 < size; i2++) {
            AdapterHelper.UpdateOp updateOp = adapterHelper.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i2);
            int i3 = updateOp.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (updateOp.MyBillsEntityDataFactory == i) {
                            i = updateOp.getAuthRequestContext;
                        } else {
                            if (updateOp.MyBillsEntityDataFactory < i) {
                                i--;
                            }
                            if (updateOp.getAuthRequestContext <= i) {
                                i++;
                            }
                        }
                    }
                } else if (updateOp.MyBillsEntityDataFactory > i) {
                    continue;
                } else if (updateOp.MyBillsEntityDataFactory + updateOp.getAuthRequestContext > i) {
                    return -1;
                } else {
                    i -= updateOp.getAuthRequestContext;
                }
            } else if (updateOp.MyBillsEntityDataFactory <= i) {
                i += updateOp.getAuthRequestContext;
            }
        }
        return i;
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to set fast scroller without both required drawables.");
            sb.append(exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.BuiltInFictitiousFunctionClassFactory), resources.getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory), resources.getDimensionPixelOffset(R.dimen.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.PlaceComponentResult) {
            ViewCompat.F(scrollingChildHelper.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        scrollingChildHelper.PlaceComponentResult = z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().MyBillsEntityDataFactory();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().PlaceComponentResult(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().MyBillsEntityDataFactory(i, i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        NestedScrollingChildHelper scrollingChildHelper = getScrollingChildHelper();
        ViewParent viewParent = scrollingChildHelper.getAuthRequestContext;
        if (viewParent != null) {
            ViewParentCompat.BuiltInFictitiousFunctionClassFactory(viewParent, scrollingChildHelper.KClassImpl$Data$declaredNonStaticMembers$2, 0);
            scrollingChildHelper.getAuthRequestContext = null;
        }
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().MyBillsEntityDataFactory(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().getAuthRequestContext();
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().getAuthRequestContext(i);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().BuiltInFictitiousFunctionClassFactory(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().MyBillsEntityDataFactory(i, i2, i3, i4, iArr, i5);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().getAuthRequestContext(i, i2, i3, i4, iArr, i5, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().KClassImpl$Data$declaredNonStaticMembers$2(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().getAuthRequestContext(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().PlaceComponentResult(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().getAuthRequestContext(f, f2);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final Action mRecyclingAction = new Action((byte) 0);

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void onSeekTargetStep(int i, int i2, State state, Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, State state, Action action);

        void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            ViewFlinger viewFlinger = recyclerView.mViewFlinger;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.PlaceComponentResult.abortAnimation();
            if (this.mStarted) {
                StringBuilder sb = new StringBuilder();
                sb.append("An instance of ");
                sb.append(getClass().getSimpleName());
                sb.append(" was started more than once. Each instance of");
                sb.append(getClass().getSimpleName());
                sb.append(" is intended to only be used once. You should create a new instance for each use.");
                InstrumentInjector.log_w(RecyclerView.TAG, sb.toString());
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            if (this.mTargetPosition == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            ViewFlinger viewFlinger2 = this.mRecyclerView.mViewFlinger;
            if (viewFlinger2.BuiltInFictitiousFunctionClassFactory) {
                viewFlinger2.getErrorConfigVersion = true;
            } else {
                RecyclerView.this.removeCallbacks(viewFlinger2);
                ViewCompat.PlaceComponentResult(RecyclerView.this, viewFlinger2);
            }
            this.mStarted = true;
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sb.append(ScrollVectorProvider.class.getCanonicalName());
            InstrumentInjector.log_w(RecyclerView.TAG, sb.toString());
            return null;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.PlaceComponentResult(recyclerView);
                    stop();
                } else {
                    InstrumentInjector.log_e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.mRecyclingAction.KClassImpl$Data$declaredNonStaticMembers$2();
                this.mRecyclingAction.PlaceComponentResult(recyclerView);
                if (KClassImpl$Data$declaredNonStaticMembers$2 && this.mRunning) {
                    this.mPendingInitialRun = true;
                    ViewFlinger viewFlinger = recyclerView.mViewFlinger;
                    if (viewFlinger.BuiltInFictitiousFunctionClassFactory) {
                        viewFlinger.getErrorConfigVersion = true;
                        return;
                    }
                    RecyclerView.this.removeCallbacks(viewFlinger);
                    ViewCompat.PlaceComponentResult(RecyclerView.this, viewFlinger);
                }
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float sqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* loaded from: classes3.dex */
        public static class Action {
            int BuiltInFictitiousFunctionClassFactory;
            Interpolator KClassImpl$Data$declaredNonStaticMembers$2;
            int MyBillsEntityDataFactory;
            boolean PlaceComponentResult;
            int getAuthRequestContext;
            int lookAheadTest;
            private int moveToNextValue;

            public Action(byte b) {
                this();
            }

            private Action() {
                this.lookAheadTest = -1;
                this.PlaceComponentResult = false;
                this.moveToNextValue = 0;
                this.BuiltInFictitiousFunctionClassFactory = 0;
                this.getAuthRequestContext = 0;
                this.MyBillsEntityDataFactory = Integer.MIN_VALUE;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }

            final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.lookAheadTest >= 0;
            }

            final void PlaceComponentResult(RecyclerView recyclerView) {
                int i = this.lookAheadTest;
                if (i >= 0) {
                    this.lookAheadTest = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.PlaceComponentResult = false;
                } else if (this.PlaceComponentResult) {
                    MyBillsEntityDataFactory();
                    recyclerView.mViewFlinger.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    int i2 = this.moveToNextValue + 1;
                    this.moveToNextValue = i2;
                    if (i2 > 10) {
                        InstrumentInjector.log_e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.PlaceComponentResult = false;
                } else {
                    this.moveToNextValue = 0;
                }
            }

            private void MyBillsEntityDataFactory() {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null && this.MyBillsEntityDataFactory <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.MyBillsEntityDataFactory <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public final boolean PlaceComponentResult() {
            return !this.mObservers.isEmpty();
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public final void MyBillsEntityDataFactory() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }

        public final void MyBillsEntityDataFactory(int i, int i2) {
            MyBillsEntityDataFactory(i, i2, null);
        }

        public final void MyBillsEntityDataFactory(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public final void getAuthRequestContext(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public final void PlaceComponentResult(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable BuiltInFictitiousFunctionClassFactory;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.BuiltInFictitiousFunctionClassFactory = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.BuiltInFictitiousFunctionClassFactory, 0);
        }
    }

    /* loaded from: classes.dex */
    public static class State {
        long KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        int NetworkUserEntityData$$ExternalSyntheticLambda2;
        private SparseArray<Object> NetworkUserEntityData$$ExternalSyntheticLambda8;
        int getAuthRequestContext;
        int NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
        public int getErrorConfigVersion = 0;
        public int PlaceComponentResult = 0;
        int lookAheadTest = 1;
        public int scheduleImpl = 0;
        boolean DatabaseTableConfigUtil = false;
        public boolean BuiltInFictitiousFunctionClassFactory = false;
        boolean PrepareContext = false;
        boolean moveToNextValue = false;
        boolean GetContactSyncConfig = false;
        boolean initRecordTimeStamp = false;

        final void getAuthRequestContext(int i) {
            if ((this.lookAheadTest & i) != 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Layout state should be one of ");
            sb.append(Integer.toBinaryString(i));
            sb.append(" but it is ");
            sb.append(Integer.toBinaryString(this.lookAheadTest));
            throw new IllegalStateException(sb.toString());
        }

        public final boolean MyBillsEntityDataFactory() {
            return this.moveToNextValue;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public final boolean getAuthRequestContext() {
            return this.initRecordTimeStamp;
        }

        public final boolean PlaceComponentResult() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda1 != -1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State{mTargetPosition=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb.append(", mData=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            sb.append(", mItemCount=");
            sb.append(this.scheduleImpl);
            sb.append(", mIsMeasuring=");
            sb.append(this.moveToNextValue);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.PlaceComponentResult);
            sb.append(", mStructureChanged=");
            sb.append(this.DatabaseTableConfigUtil);
            sb.append(", mInPreLayout=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.GetContactSyncConfig);
            sb.append(", mRunPredictiveAnimations=");
            sb.append(this.initRecordTimeStamp);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public final void BuiltInFictitiousFunctionClassFactory(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (viewHolder.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(viewHolder.itemView) || !viewHolder.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public ItemAnimatorListener lookAheadTest = null;
        private ArrayList<ItemAnimatorFinishedListener> PlaceComponentResult = new ArrayList<>();
        public long NetworkUserEntityData$$ExternalSyntheticLambda0 = 120;
        public long GetContactSyncConfig = 120;
        public long initRecordTimeStamp = 250;
        public long moveToNextValue = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface AdapterChanges {
        }

        /* loaded from: classes3.dex */
        public interface ItemAnimatorFinishedListener {
        }

        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
            void BuiltInFictitiousFunctionClassFactory(ViewHolder viewHolder);
        }

        public abstract void KClassImpl$Data$declaredNonStaticMembers$2();

        public abstract void KClassImpl$Data$declaredNonStaticMembers$2(ViewHolder viewHolder);

        public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean MyBillsEntityDataFactory(ViewHolder viewHolder) {
            return true;
        }

        public abstract boolean MyBillsEntityDataFactory(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract void PlaceComponentResult();

        public abstract boolean PlaceComponentResult(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean PlaceComponentResult(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean getAuthRequestContext();

        static int getAuthRequestContext(ViewHolder viewHolder) {
            int i = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i : i | 2048;
            }
            return i;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return getAuthRequestContext();
        }

        public boolean BuiltInFictitiousFunctionClassFactory(ViewHolder viewHolder, List<Object> list) {
            return MyBillsEntityDataFactory(viewHolder);
        }

        public final void MyBillsEntityDataFactory() {
            int size = this.PlaceComponentResult.size();
            for (int i = 0; i < size; i++) {
                this.PlaceComponentResult.get(i);
            }
            this.PlaceComponentResult.clear();
        }

        public static ItemHolderInfo scheduleImpl() {
            return new ItemHolderInfo();
        }

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int BuiltInFictitiousFunctionClassFactory;
            public int MyBillsEntityDataFactory;
            public int PlaceComponentResult;
            public int getAuthRequestContext;

            public final ItemHolderInfo PlaceComponentResult(ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                this.BuiltInFictitiousFunctionClassFactory = view.getLeft();
                this.PlaceComponentResult = view.getTop();
                this.MyBillsEntityDataFactory = view.getRight();
                this.getAuthRequestContext = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return childDrawingOrderCallback.BuiltInFictitiousFunctionClassFactory(i, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }
}
