package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3, FSDispatchDraw {
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    private static final Pools.Pool<Rect> sRectPool;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;
    public static final byte[] MyBillsEntityDataFactory = {56, -119, 46, TarHeader.LF_CONTIG, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 210;

    /* loaded from: classes3.dex */
    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes3.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DispatchChangeEvent {
    }

    public static Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(TypedArray typedArray, int i) {
        Object[] objArr = new Object[1];
        a((byte) -1, objArr);
        return Class.forName((String) objArr[0]).isInstance(typedArray) ? InstrumentInjector.Resources_getDrawable((Context) typedArray, i) : typedArray.getDrawable(i);
    }

    private static void a(byte b, Object[] objArr) {
        int i = b + 4;
        byte[] bArr = MyBillsEntityDataFactory;
        byte[] bArr2 = new byte[23];
        int i2 = 0;
        int i3 = bArr == null ? (97 + (-23)) - 8 : 97;
        while (true) {
            i++;
            bArr2[i2] = (byte) i3;
            i2++;
            if (i2 == 23) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + (-bArr[i])) - 8;
        }
    }

    private static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        return i == 0 ? BadgeDrawable.TOP_END : i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_4774dcc000161de84c13d383cdfdce85(canvas);
    }

    public void fsSuperDispatchDraw_4774dcc000161de84c13d383cdfdce85(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_4774dcc000161de84c13d383cdfdce85(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        Object[] objArr = new Object[1];
        a((byte) -1, objArr);
        CONSTRUCTOR_PARAMS = new Class[]{Class.forName((String) objArr[0]), AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new Pools.SynchronizedPool(12);
    }

    private static Rect acquireTempRect() {
        Rect BuiltInFictitiousFunctionClassFactory = sRectPool.BuiltInFictitiousFunctionClassFactory();
        return BuiltInFictitiousFunctionClassFactory == null ? new Rect() : BuiltInFictitiousFunctionClassFactory;
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.MyBillsEntityDataFactory(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MyBillsEntityDataFactory);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper();
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PlaceComponentResult, 0, R.style.MyBillsEntityDataFactory);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PlaceComponentResult, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, R.styleable.PlaceComponentResult, attributeSet, obtainStyledAttributes, 0, R.style.MyBillsEntityDataFactory);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.PlaceComponentResult, attributeSet, obtainStyledAttributes, i, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.initRecordTimeStamp, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mKeylines[i2] = (int) (r12[i2] * f);
            }
        }
        this.mStatusBarBackground = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.DatabaseTableConfigUtil);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(this) == 0) {
            ViewCompat.moveToNextValue((View) this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.DatabaseTableConfigUtil(this)) {
            ViewCompat.I(this);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.mStatusBarBackground = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.getAuthRequestContext(this.mStatusBarBackground, ViewCompat.initRecordTimeStamp(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.mStatusBarBackground.setVisible(z, false);
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.PlaceComponentResult(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        if (ObjectsCompat.MyBillsEntityDataFactory(this.mLastInsets, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.mLastInsets = windowInsetsCompat;
        boolean z = windowInsetsCompat != null && windowInsetsCompat.initRecordTimeStamp() > 0;
        this.mDrawStatusBarBackground = z;
        setWillNotDraw(!z && getBackground() == null);
        WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).lookAheadTest;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((LayoutParams) getChildAt(i2).getLayoutParams()).NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.lookAheadTest;
            if (!(z || z2) || actionMasked == 0) {
                if (!z && behavior != null) {
                    if (i == 0) {
                        z = behavior.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i == 1) {
                        z = behavior.onTouchEvent(this, view, motionEvent);
                    }
                    if (z) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean MyBillsEntityDataFactory2 = layoutParams.MyBillsEntityDataFactory();
                boolean authRequestContext = layoutParams.getAuthRequestContext(this, view);
                z2 = authRequestContext && !MyBillsEntityDataFactory2;
                if (authRequestContext && !z2) {
                    break;
                }
            } else if (behavior != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    behavior.onInterceptTouchEvent(this, view, motionEvent2);
                } else if (i == 1) {
                    behavior.onTouchEvent(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r3 != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L29
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.lookAheadTest
            if (r6 == 0) goto L29
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L2a
        L29:
            r6 = 0
        L2a:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.resetTouchBehaviors(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.mDisallowInterceptReset) {
            return;
        }
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
    }

    private int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i);
            InstrumentInjector.log_e(TAG, sb.toString());
            return 0;
        } else if (i < 0 || i >= iArr.length) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Keyline index ");
            sb2.append(i);
            sb2.append(" out of range for ");
            sb2.append(this);
            InstrumentInjector.log_e(TAG, sb2.toString());
            return 0;
        } else {
            return iArr[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(str);
            str = sb.toString();
        } else if (str.indexOf(46) < 0) {
            String str2 = WIDGET_PACKAGE_NAME;
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append('.');
                sb2.append(str);
                str = sb2.toString();
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = sConstructors;
            Map<String, Constructor<Behavior>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not inflate Behavior subclass ");
            sb3.append(str);
            throw new RuntimeException(sb3.toString(), e);
        }
    }

    LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.scheduleImpl) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    InstrumentInjector.log_e(TAG, "Attached behavior class is null");
                }
                layoutParams.MyBillsEntityDataFactory(behavior);
                layoutParams.scheduleImpl = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.MyBillsEntityDataFactory(defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Default behavior class ");
                        sb.append(defaultBehavior.value().getName());
                        sb.append(" could not be instantiated. Did you forget a default constructor?");
                        InstrumentInjector.log_e(TAG, sb.toString(), e);
                    }
                }
                layoutParams.scheduleImpl = true;
            }
        }
        return layoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        DirectedAcyclicGraph<View> directedAcyclicGraph = this.mChildDag;
        int size = directedAcyclicGraph.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = 0; i < size; i++) {
            ArrayList<View> arrayList = (ArrayList) directedAcyclicGraph.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[(i << 1) + 1];
            if (arrayList != null) {
                arrayList.clear();
                directedAcyclicGraph.getAuthRequestContext.MyBillsEntityDataFactory(arrayList);
            }
        }
        directedAcyclicGraph.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            if (resolvedLayoutParams.NetworkUserEntityData$$ExternalSyntheticLambda0 == -1) {
                resolvedLayoutParams.moveToNextValue = null;
                resolvedLayoutParams.getErrorConfigVersion = null;
            } else {
                if (resolvedLayoutParams.getErrorConfigVersion == null || !resolvedLayoutParams.KClassImpl$Data$declaredNonStaticMembers$2(childAt, this)) {
                    View findViewById = findViewById(resolvedLayoutParams.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    resolvedLayoutParams.getErrorConfigVersion = findViewById;
                    if (findViewById != null) {
                        if (findViewById == this) {
                            if (isInEditMode()) {
                                resolvedLayoutParams.moveToNextValue = null;
                                resolvedLayoutParams.getErrorConfigVersion = null;
                            } else {
                                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                            }
                        } else {
                            for (ViewParent parent = findViewById.getParent(); parent != this && parent != null; parent = parent.getParent()) {
                                if (parent == childAt) {
                                    if (isInEditMode()) {
                                        resolvedLayoutParams.moveToNextValue = null;
                                        resolvedLayoutParams.getErrorConfigVersion = null;
                                    } else {
                                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                                    }
                                } else {
                                    if (parent instanceof View) {
                                        findViewById = (View) parent;
                                    }
                                }
                            }
                            resolvedLayoutParams.moveToNextValue = findViewById;
                        }
                    } else if (isInEditMode()) {
                        resolvedLayoutParams.moveToNextValue = null;
                        resolvedLayoutParams.getErrorConfigVersion = null;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Could not find CoordinatorLayout descendant view with id ");
                        sb.append(getResources().getResourceName(resolvedLayoutParams.NetworkUserEntityData$$ExternalSyntheticLambda0));
                        sb.append(" to anchor view ");
                        sb.append(childAt);
                        throw new IllegalStateException(sb.toString());
                    }
                }
                View view = resolvedLayoutParams.getErrorConfigVersion;
            }
            DirectedAcyclicGraph<View> directedAcyclicGraph2 = this.mChildDag;
            if (!directedAcyclicGraph2.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(childAt)) {
                directedAcyclicGraph2.KClassImpl$Data$declaredNonStaticMembers$2.put(childAt, null);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (resolvedLayoutParams.getAuthRequestContext(this, childAt, childAt2)) {
                        if (!this.mChildDag.MyBillsEntityDataFactory(childAt2)) {
                            DirectedAcyclicGraph<View> directedAcyclicGraph3 = this.mChildDag;
                            if (!directedAcyclicGraph3.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(childAt2)) {
                                directedAcyclicGraph3.KClassImpl$Data$declaredNonStaticMembers$2.put(childAt2, null);
                            }
                        }
                        DirectedAcyclicGraph<View> directedAcyclicGraph4 = this.mChildDag;
                        if (!directedAcyclicGraph4.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(childAt2) || !directedAcyclicGraph4.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(childAt)) {
                            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                        }
                        ArrayList<View> arrayList2 = directedAcyclicGraph4.KClassImpl$Data$declaredNonStaticMembers$2.get(childAt2);
                        if (arrayList2 == null) {
                            arrayList2 = directedAcyclicGraph4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList<>();
                            }
                            directedAcyclicGraph4.KClassImpl$Data$declaredNonStaticMembers$2.put(childAt2, arrayList2);
                        }
                        arrayList2.add(childAt);
                    } else {
                        continue;
                    }
                }
            }
        }
        List<View> list = this.mDependencySortedChildren;
        DirectedAcyclicGraph<View> directedAcyclicGraph5 = this.mChildDag;
        directedAcyclicGraph5.MyBillsEntityDataFactory.clear();
        directedAcyclicGraph5.BuiltInFictitiousFunctionClassFactory.clear();
        int size2 = directedAcyclicGraph5.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            directedAcyclicGraph5.BuiltInFictitiousFunctionClassFactory(directedAcyclicGraph5.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[i4 << 1], directedAcyclicGraph5.MyBillsEntityDataFactory, directedAcyclicGraph5.BuiltInFictitiousFunctionClassFactory);
        }
        list.addAll(directedAcyclicGraph5.MyBillsEntityDataFactory);
        Collections.reverse(this.mDependencySortedChildren);
    }

    void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.PlaceComponentResult(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x011a, code lost:
    
        if (r0.onMeasureChild(r31, r19, r25, r20, r26, 0) == false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r32, int r33) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        Behavior behavior;
        if (windowInsetsCompat.GetContactSyncConfig()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.DatabaseTableConfigUtil(childAt) && (behavior = ((LayoutParams) childAt.getLayoutParams()).lookAheadTest) != null) {
                windowInsetsCompat = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.GetContactSyncConfig()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    public void onLayoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.BuiltInFictitiousFunctionClassFactory()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (layoutParams.getErrorConfigVersion != null) {
            layoutChildWithAnchor(view, layoutParams.getErrorConfigVersion, i);
        } else if (layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 >= 0) {
            layoutChildWithKeyline(view, layoutParams.KClassImpl$Data$declaredNonStaticMembers$2, i);
        } else {
            layoutChild(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behavior;
        int initRecordTimeStamp = ViewCompat.initRecordTimeStamp(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).lookAheadTest) == null || !behavior.onLayoutChild(this, view, initRecordTimeStamp))) {
                onLayoutChild(view, initRecordTimeStamp);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        int initRecordTimeStamp = windowInsetsCompat != null ? windowInsetsCompat.initRecordTimeStamp() : 0;
        if (initRecordTimeStamp > 0) {
            this.mStatusBarBackground.setBounds(0, 0, getWidth(), initRecordTimeStamp);
            this.mStatusBarBackground.draw(canvas);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).NetworkUserEntityData$$ExternalSyntheticLambda8.set(rect);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int width;
        int height;
        int BuiltInFictitiousFunctionClassFactory = GravityCompat.BuiltInFictitiousFunctionClassFactory(resolveAnchoredChildGravity(layoutParams.PlaceComponentResult), i);
        int BuiltInFictitiousFunctionClassFactory2 = GravityCompat.BuiltInFictitiousFunctionClassFactory(resolveGravity(layoutParams.BuiltInFictitiousFunctionClassFactory), i);
        int i4 = BuiltInFictitiousFunctionClassFactory & 7;
        int i5 = BuiltInFictitiousFunctionClassFactory & 112;
        int i6 = BuiltInFictitiousFunctionClassFactory2 & 7;
        int i7 = BuiltInFictitiousFunctionClassFactory2 & 112;
        if (i6 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i7 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int i3 = layoutParams.leftMargin;
        int i4 = paddingLeft + i3;
        int max = Math.max(i4, Math.min(rect.left, ((width - getPaddingRight()) - i) - layoutParams.rightMargin));
        int paddingTop = getPaddingTop();
        int i5 = layoutParams.topMargin;
        int i6 = paddingTop + i5;
        int max2 = Math.max(i6, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - layoutParams.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int BuiltInFictitiousFunctionClassFactory = GravityCompat.BuiltInFictitiousFunctionClassFactory(resolveKeylineGravity(layoutParams.PlaceComponentResult), i2);
        int i3 = BuiltInFictitiousFunctionClassFactory & 7;
        int i4 = BuiltInFictitiousFunctionClassFactory & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        int i5 = 0;
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int paddingLeft = getPaddingLeft();
        int i6 = layoutParams.leftMargin;
        int i7 = paddingLeft + i6;
        int max = Math.max(i7, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int paddingTop = getPaddingTop();
        int i8 = layoutParams.topMargin;
        int i9 = paddingTop + i8;
        int max2 = Math.max(i9, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void layoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.mLastInsets != null && ViewCompat.DatabaseTableConfigUtil(this) && !ViewCompat.DatabaseTableConfigUtil(view)) {
            acquireTempRect.left += this.mLastInsets.lookAheadTest();
            acquireTempRect.top += this.mLastInsets.initRecordTimeStamp();
            acquireTempRect.right -= this.mLastInsets.getErrorConfigVersion();
            acquireTempRect.bottom -= this.mLastInsets.moveToNextValue();
        }
        Rect acquireTempRect2 = acquireTempRect();
        GravityCompat.KClassImpl$Data$declaredNonStaticMembers$2(resolveGravity(layoutParams.PlaceComponentResult), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.lookAheadTest != null) {
            float scrimOpacity = layoutParams.lookAheadTest.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.lookAheadTest.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return fsSuperDrawChild_4774dcc000161de84c13d383cdfdce85(canvas, view, j);
    }

    final void onChildViewsChanged(int i) {
        boolean z;
        int initRecordTimeStamp = ViewCompat.initRecordTimeStamp(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.mDependencySortedChildren.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (layoutParams.moveToNextValue == this.mDependencySortedChildren.get(i3)) {
                        offsetChildToAnchor(view, initRecordTimeStamp);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (layoutParams.MyBillsEntityDataFactory != 0 && !acquireTempRect2.isEmpty()) {
                    int BuiltInFictitiousFunctionClassFactory = GravityCompat.BuiltInFictitiousFunctionClassFactory(layoutParams.MyBillsEntityDataFactory, initRecordTimeStamp);
                    int i4 = BuiltInFictitiousFunctionClassFactory & 112;
                    if (i4 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i4 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i5 = BuiltInFictitiousFunctionClassFactory & 7;
                    if (i5 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i5 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (layoutParams.getAuthRequestContext != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, initRecordTimeStamp);
                }
                if (i != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view2 = this.mDependencySortedChildren.get(i6);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams2.lookAheadTest;
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (i == 0 && layoutParams2.PlaceComponentResult()) {
                            layoutParams2.DatabaseTableConfigUtil = false;
                        } else {
                            if (i == 2) {
                                behavior.onDependentViewRemoved(this, view2, view);
                                z = true;
                            } else {
                                z = behavior.onDependentViewChanged(this, view2, view);
                            }
                            if (i == 1) {
                                layoutParams2.DatabaseTableConfigUtil = z;
                            }
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (ViewCompat.getValueOfTouchPositionAbsolute(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.lookAheadTest;
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behavior != null && behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
                if (!acquireTempRect2.contains(acquireTempRect)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Rect should be within the child's bounds. Rect:");
                    sb.append(acquireTempRect.toShortString());
                    sb.append(" | Bounds:");
                    sb.append(acquireTempRect2.toShortString());
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                acquireTempRect.set(acquireTempRect2);
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int BuiltInFictitiousFunctionClassFactory = GravityCompat.BuiltInFictitiousFunctionClassFactory(layoutParams.getAuthRequestContext, i);
            boolean z3 = true;
            if ((BuiltInFictitiousFunctionClassFactory & 48) != 48 || (i3 = (acquireTempRect.top - layoutParams.topMargin) - layoutParams.PrepareContext) >= rect.top) {
                z = false;
            } else {
                setInsetOffsetY(view, rect.top - i3);
                z = true;
            }
            if ((BuiltInFictitiousFunctionClassFactory & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.PrepareContext) < rect.bottom) {
                setInsetOffsetY(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view, 0);
            }
            if ((BuiltInFictitiousFunctionClassFactory & 3) != 3 || (i2 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7) >= rect.left) {
                z2 = false;
            } else {
                setInsetOffsetX(view, rect.left - i2);
                z2 = true;
            }
            if ((BuiltInFictitiousFunctionClassFactory & 5) != 5 || (width = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7) >= rect.right) {
                z3 = z2;
            } else {
                setInsetOffsetX(view, width - rect.right);
            }
            if (!z3) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    private void setInsetOffsetX(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7 != i) {
            ViewCompat.PlaceComponentResult(view, i - layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7);
            layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.PrepareContext != i) {
            ViewCompat.BuiltInFictitiousFunctionClassFactory(view, i - layoutParams.PrepareContext);
            layoutParams.PrepareContext = i;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        ArrayList<View> arrayList = this.mChildDag.KClassImpl$Data$declaredNonStaticMembers$2.get(view);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View view2 = arrayList.get(i);
            Behavior behavior = ((LayoutParams) view2.getLayoutParams()).lookAheadTest;
            if (behavior != null) {
                behavior.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public List<View> getDependencies(View view) {
        DirectedAcyclicGraph<View> directedAcyclicGraph = this.mChildDag;
        int size = directedAcyclicGraph.KClassImpl$Data$declaredNonStaticMembers$2.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            int i2 = i << 1;
            ArrayList arrayList2 = (ArrayList) directedAcyclicGraph.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[i2 + 1];
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(directedAcyclicGraph.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[i2]);
            }
        }
        this.mTempDependenciesList.clear();
        if (arrayList != null) {
            this.mTempDependenciesList.addAll(arrayList);
        }
        return this.mTempDependenciesList;
    }

    public List<View> getDependents(View view) {
        ArrayList<View> arrayList = this.mChildDag.KClassImpl$Data$declaredNonStaticMembers$2.get(view);
        this.mTempDependenciesList.clear();
        if (arrayList != null) {
            this.mTempDependenciesList.addAll(arrayList);
        }
        return this.mTempDependenciesList;
    }

    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z != this.mNeedsPreDrawListener) {
            if (z) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.KClassImpl$Data$declaredNonStaticMembers$2(view);
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    void offsetChildToAnchor(View view, int i) {
        Behavior behavior;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.getErrorConfigVersion != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.getErrorConfigVersion, acquireTempRect);
            getChildRect(view, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, i, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            boolean z = (acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top) ? false : true;
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, measuredHeight);
            int i2 = acquireTempRect3.left - acquireTempRect2.left;
            int i3 = acquireTempRect3.top - acquireTempRect2.top;
            if (i2 != 0) {
                ViewCompat.PlaceComponentResult(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.BuiltInFictitiousFunctionClassFactory(view, i3);
            }
            if (z && (behavior = layoutParams.lookAheadTest) != null) {
                behavior.onDependentViewChanged(this, view, layoutParams.getErrorConfigVersion);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() == 0 && view2.getVisibility() == 0) {
            Rect acquireTempRect = acquireTempRect();
            getChildRect(view, view.getParent() != this, acquireTempRect);
            Rect acquireTempRect2 = acquireTempRect();
            getChildRect(view2, view2.getParent() != this, acquireTempRect2);
            try {
                if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left) {
                    if (acquireTempRect.bottom >= acquireTempRect2.top) {
                        z = true;
                    }
                }
                return z;
            } finally {
                releaseTempRect(acquireTempRect);
                releaseTempRect(acquireTempRect2);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.lookAheadTest;
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    z |= onStartNestedScroll;
                    if (i2 == 0) {
                        layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda2 = onStartNestedScroll;
                    } else if (i2 == 1) {
                        layoutParams.GetContactSyncConfig = onStartNestedScroll;
                    }
                } else if (i2 == 0) {
                    layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                } else if (i2 == 1) {
                    layoutParams.GetContactSyncConfig = false;
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        Behavior behavior;
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        if (i2 == 1) {
            nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory = i;
        } else {
            nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.PlaceComponentResult(i2) && (behavior = layoutParams.lookAheadTest) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        if (i == 1) {
            nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory = 0;
        } else {
            nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.PlaceComponentResult(i)) {
                Behavior behavior = layoutParams.lookAheadTest;
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i);
                }
                if (i == 0) {
                    layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                } else if (i == 1) {
                    layoutParams.GetContactSyncConfig = false;
                }
                layoutParams.DatabaseTableConfigUtil = false;
            }
        }
        this.mNestedScrollingTarget = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Behavior behavior;
        int min;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.PlaceComponentResult(i5) && (behavior = layoutParams.lookAheadTest) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    int[] iArr3 = this.mBehaviorConsumed;
                    i6 = i3 > 0 ? Math.max(i6, iArr3[0]) : Math.min(i6, iArr3[0]);
                    if (i4 > 0) {
                        min = Math.max(i7, this.mBehaviorConsumed[1]);
                    } else {
                        min = Math.min(i7, this.mBehaviorConsumed[1]);
                    }
                    i7 = min;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.PlaceComponentResult(i3) && (behavior = layoutParams.lookAheadTest) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    int[] iArr3 = this.mBehaviorConsumed;
                    i4 = i > 0 ? Math.max(i4, iArr3[0]) : Math.min(i4, iArr3[0]);
                    int[] iArr4 = this.mBehaviorConsumed;
                    i5 = i2 > 0 ? Math.max(i5, iArr4[1]) : Math.min(i5, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.PlaceComponentResult(0) && (behavior = layoutParams.lookAheadTest) != null) {
                    z2 |= behavior.onNestedFling(this, childAt, view, f, f2, z);
                }
            }
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.PlaceComponentResult(0) && (behavior = layoutParams.lookAheadTest) != null) {
                    z |= behavior.onNestedPreFling(this, childAt, view, f, f2);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        return nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory | nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(View view, View view2) {
            float supportButtonTintMode = ViewCompat.getSupportButtonTintMode(view);
            float supportButtonTintMode2 = ViewCompat.getSupportButtonTintMode(view2);
            if (supportButtonTintMode > supportButtonTintMode2) {
                return -1;
            }
            return supportButtonTintMode < supportButtonTintMode2 ? 1 : 0;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Behavior<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onAttachedToLayoutParams(LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public static void setTag(View view, Object obj) {
            ((LayoutParams) view.getLayoutParams()).initRecordTimeStamp = obj;
        }

        public static Object getTag(View view) {
            return ((LayoutParams) view.getLayoutParams()).initRecordTimeStamp;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int BuiltInFictitiousFunctionClassFactory;
        boolean DatabaseTableConfigUtil;
        boolean GetContactSyncConfig;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
        int NetworkUserEntityData$$ExternalSyntheticLambda7;
        final Rect NetworkUserEntityData$$ExternalSyntheticLambda8;
        public int PlaceComponentResult;
        int PrepareContext;
        public int getAuthRequestContext;
        public View getErrorConfigVersion;
        Object initRecordTimeStamp;
        public Behavior lookAheadTest;
        public View moveToNextValue;
        boolean scheduleImpl;

        public LayoutParams() {
            super(-2, -2);
            this.scheduleImpl = false;
            this.PlaceComponentResult = 0;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            this.MyBillsEntityDataFactory = 0;
            this.getAuthRequestContext = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Rect();
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.scheduleImpl = false;
            this.PlaceComponentResult = 0;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            this.MyBillsEntityDataFactory = 0;
            this.getAuthRequestContext = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BuiltInFictitiousFunctionClassFactory);
            this.PlaceComponentResult = obtainStyledAttributes.getInteger(R.styleable.MyBillsEntityDataFactory, 0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getResourceId(R.styleable.getAuthRequestContext, -1);
            this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInteger(R.styleable.scheduleImpl, 0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInteger(R.styleable.getErrorConfigVersion, -1);
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(R.styleable.moveToNextValue, 0);
            this.getAuthRequestContext = obtainStyledAttributes.getInt(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.lookAheadTest);
            this.scheduleImpl = hasValue;
            if (hasValue) {
                this.lookAheadTest = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(R.styleable.lookAheadTest));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.lookAheadTest;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.scheduleImpl = false;
            this.PlaceComponentResult = 0;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            this.MyBillsEntityDataFactory = 0;
            this.getAuthRequestContext = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.scheduleImpl = false;
            this.PlaceComponentResult = 0;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            this.MyBillsEntityDataFactory = 0;
            this.getAuthRequestContext = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.scheduleImpl = false;
            this.PlaceComponentResult = 0;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            this.MyBillsEntityDataFactory = 0;
            this.getAuthRequestContext = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Rect();
        }

        public final void MyBillsEntityDataFactory(Behavior behavior) {
            Behavior behavior2 = this.lookAheadTest;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.lookAheadTest = behavior;
                this.initRecordTimeStamp = null;
                this.scheduleImpl = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.getErrorConfigVersion == null && this.NetworkUserEntityData$$ExternalSyntheticLambda0 != -1;
        }

        final boolean MyBillsEntityDataFactory() {
            if (this.lookAheadTest == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }

        final boolean getAuthRequestContext(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (z) {
                return true;
            }
            Behavior behavior = this.lookAheadTest;
            boolean blocksInteractionBelow = (behavior != null ? behavior.blocksInteractionBelow(coordinatorLayout, view) : false) | z;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        final boolean PlaceComponentResult(int i) {
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                return this.GetContactSyncConfig;
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }

        final boolean PlaceComponentResult() {
            return this.DatabaseTableConfigUtil;
        }

        final boolean getAuthRequestContext(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            return view2 == this.moveToNextValue || getAuthRequestContext(view2, ViewCompat.initRecordTimeStamp(coordinatorLayout)) || ((behavior = this.lookAheadTest) != null && behavior.layoutDependsOn(coordinatorLayout, view, view2));
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2(View view, CoordinatorLayout coordinatorLayout) {
            if (this.getErrorConfigVersion.getId() != this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return false;
            }
            View view2 = this.getErrorConfigVersion;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.moveToNextValue = null;
                    this.getErrorConfigVersion = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.moveToNextValue = view2;
            return true;
        }

        private boolean getAuthRequestContext(View view, int i) {
            int BuiltInFictitiousFunctionClassFactory = GravityCompat.BuiltInFictitiousFunctionClassFactory(((LayoutParams) view.getLayoutParams()).MyBillsEntityDataFactory, i);
            return BuiltInFictitiousFunctionClassFactory != 0 && (GravityCompat.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, i) & BuiltInFictitiousFunctionClassFactory) == BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes6.dex */
    class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.KClassImpl$Data$declaredNonStaticMembers$2;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id2 = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).lookAheadTest;
            if (id2 != -1 && behavior != null && (parcelable2 = sparseArray.get(id2)) != null) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id2 = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).lookAheadTest;
            if (id2 != -1 && behavior != null && (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id2, onSaveInstanceState);
            }
        }
        savedState.KClassImpl$Data$declaredNonStaticMembers$2 = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).lookAheadTest;
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.DatabaseTableConfigUtil(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.MyBillsEntityDataFactory(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(APEncodeOptions.DEFAULT_MAX_LEN);
            return;
        }
        ViewCompat.MyBillsEntityDataFactory(this, (OnApplyWindowInsetsListener) null);
    }

    /* loaded from: classes3.dex */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        SparseArray<Parcelable> KClassImpl$Data$declaredNonStaticMembers$2;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.KClassImpl$Data$declaredNonStaticMembers$2.keyAt(i2);
                parcelableArr[i2] = this.KClassImpl$Data$declaredNonStaticMembers$2.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }
}
