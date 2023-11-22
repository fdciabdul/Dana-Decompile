package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3, FSDraw, FSDispatchDraw {
    private final Runnable BuiltInFictitiousFunctionClassFactory;
    private DecorToolbar DatabaseTableConfigUtil;
    private WindowInsetsCompat FragmentBottomSheetPaymentSettingBinding;
    private OverScroller GetContactSyncConfig;
    private int MyBillsEntityDataFactory;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda5;
    private int NetworkUserEntityData$$ExternalSyntheticLambda6;
    private WindowInsetsCompat NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda8;
    private boolean PrepareContext;
    private ActionBarVisibilityCallback getAuthRequestContext;
    private final Runnable getCallingPid;
    private final Rect getErrorConfigVersion;
    private Drawable getSupportButtonTintMode;
    private int initRecordTimeStamp;
    private WindowInsetsCompat isLayoutRequested;
    private WindowInsetsCompat lookAheadTest;
    ActionBarContainer mActionBarTop;
    boolean mAnimatingForFling;
    ViewPropertyAnimator mCurrentActionBarTopAnimator;
    final AnimatorListenerAdapter mTopAnimatorListener;
    private ContentFrameLayout moveToNextValue;
    private final Rect newProxyInstance;
    private int readMicros;
    private final Rect scheduleImpl;
    private final NestedScrollingParentHelper whenAvailable;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {104, -68, 0, 44, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int PlaceComponentResult = TarHeader.USTAR_FILENAME_PREFIX;
    static final int[] ATTRS = {R.attr.PlaceComponentResult, 16842841};

    /* loaded from: classes.dex */
    public interface ActionBarVisibilityCallback {
        void BuiltInFictitiousFunctionClassFactory(int i);

        void GetContactSyncConfig();

        void NetworkUserEntityData$$ExternalSyntheticLambda1();

        void NetworkUserEntityData$$ExternalSyntheticLambda2();

        void moveToNextValue(boolean z);
    }

    public static Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(TypedArray typedArray, int i) {
        byte b = (byte) (PlaceComponentResult & 5);
        byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[2];
        Object[] objArr = new Object[1];
        a(b, b2, b2, objArr);
        return Class.forName((String) objArr[0]).isInstance(typedArray) ? InstrumentInjector.Resources_getDrawable((Context) typedArray, i) : typedArray.getDrawable(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 22
            int r7 = 25 - r7
            byte[] r0 = androidx.appcompat.widget.ActionBarOverlayLayout.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 6
            int r8 = r8 + 97
            int r9 = r9 * 5
            int r9 = 23 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            int r7 = r7 + 1
            if (r5 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-8)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.a(int, short, short, java.lang.Object[]):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_4cd02ea059c4058ece6112dde1a10fb3(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_4cd02ea059c4058ece6112dde1a10fb3(canvas, view, j);
    }

    public void fsSuperDispatchDraw_4cd02ea059c4058ece6112dde1a10fb3(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_4cd02ea059c4058ece6112dde1a10fb3(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public void fsSuperDraw_4cd02ea059c4058ece6112dde1a10fb3(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.readMicros = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Rect();
        this.newProxyInstance = new Rect();
        this.getErrorConfigVersion = new Rect();
        this.scheduleImpl = new Rect();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new Rect();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Rect();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new Rect();
        this.lookAheadTest = WindowInsetsCompat.getAuthRequestContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = WindowInsetsCompat.getAuthRequestContext;
        this.isLayoutRequested = WindowInsetsCompat.getAuthRequestContext;
        this.FragmentBottomSheetPaymentSettingBinding = WindowInsetsCompat.getAuthRequestContext;
        this.mTopAnimatorListener = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }
        };
        this.getCallingPid = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(-ActionBarOverlayLayout.this.mActionBarTop.getHeight()).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
            }
        };
        KClassImpl$Data$declaredNonStaticMembers$2(context);
        this.whenAvailable = new NestedScrollingParentHelper();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.MyBillsEntityDataFactory = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 1);
        this.getSupportButtonTintMode = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d;
        setWillNotDraw(__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d == null);
        obtainStyledAttributes.recycle();
        try {
            byte b = (byte) (PlaceComponentResult & 5);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[2];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[2];
            byte b4 = (byte) (b3 + 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            this.PrepareContext = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion < 19;
            this.GetContactSyncConfig = new OverScroller(context);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.getAuthRequestContext = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.readMicros);
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.I(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = z;
        boolean z2 = false;
        if (z) {
            Context context = getContext();
            try {
                byte b = (byte) (PlaceComponentResult & 5);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[2];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[2];
                byte b4 = (byte) (b3 + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                if (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion < 19) {
                    z2 = true;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        this.PrepareContext = z2;
    }

    public boolean isInOverlayMode() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        ViewCompat.I(this);
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        pullChildren();
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.getAuthRequestContext;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.moveToNextValue(!z2);
            if (z || !z2) {
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1();
            } else {
                this.getAuthRequestContext.GetContactSyncConfig();
            }
        }
        if (((i ^ i2) & 256) == 0 || this.getAuthRequestContext == null) {
            return;
        }
        ViewCompat.I(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.readMicros = i;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.getAuthRequestContext;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.BuiltInFictitiousFunctionClassFactory(i);
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(View view, Rect rect, boolean z) {
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        } else {
            z2 = false;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        pullChildren();
        boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.mActionBarTop, rect, false);
        this.scheduleImpl.set(rect);
        ViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(this, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda4.equals(this.scheduleImpl)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.set(this.scheduleImpl);
            BuiltInFictitiousFunctionClassFactory = true;
        }
        if (!this.newProxyInstance.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            this.newProxyInstance.set(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            BuiltInFictitiousFunctionClassFactory = true;
        }
        if (BuiltInFictitiousFunctionClassFactory) {
            requestLayout();
        }
        return true;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        pullChildren();
        WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$22 = WindowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(windowInsets, this);
        boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.mActionBarTop, new Rect(KClassImpl$Data$declaredNonStaticMembers$22.lookAheadTest(), KClassImpl$Data$declaredNonStaticMembers$22.initRecordTimeStamp(), KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion(), KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue()), false);
        ViewCompat.getAuthRequestContext(this, KClassImpl$Data$declaredNonStaticMembers$22, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        WindowInsetsCompat PlaceComponentResult2 = KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0.left, this.NetworkUserEntityData$$ExternalSyntheticLambda0.top, this.NetworkUserEntityData$$ExternalSyntheticLambda0.right, this.NetworkUserEntityData$$ExternalSyntheticLambda0.bottom);
        this.lookAheadTest = PlaceComponentResult2;
        boolean z = true;
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.equals(PlaceComponentResult2)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = this.lookAheadTest;
            BuiltInFictitiousFunctionClassFactory = true;
        }
        if (this.newProxyInstance.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            z = BuiltInFictitiousFunctionClassFactory;
        } else {
            this.newProxyInstance.set(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        if (z) {
            requestLayout();
        }
        return KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int max = Math.max(0, this.mActionBarTop.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        boolean z = (ViewCompat.whenAvailable(this) & 256) != 0;
        if (z) {
            measuredHeight = this.MyBillsEntityDataFactory;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 && this.mActionBarTop.getTabContainer() != null) {
                measuredHeight += this.MyBillsEntityDataFactory;
            }
        } else {
            measuredHeight = this.mActionBarTop.getVisibility() != 8 ? this.mActionBarTop.getMeasuredHeight() : 0;
        }
        this.getErrorConfigVersion.set(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.isLayoutRequested = this.lookAheadTest;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.set(this.scheduleImpl);
        }
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda3 && !z) {
            this.getErrorConfigVersion.top += measuredHeight;
            this.getErrorConfigVersion.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.isLayoutRequested = this.isLayoutRequested.PlaceComponentResult(0, measuredHeight, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.isLayoutRequested = new WindowInsetsCompat.Builder(this.isLayoutRequested).getAuthRequestContext(Insets.PlaceComponentResult(this.isLayoutRequested.lookAheadTest(), this.isLayoutRequested.initRecordTimeStamp() + measuredHeight, this.isLayoutRequested.getErrorConfigVersion(), this.isLayoutRequested.moveToNextValue() + 0)).getAuthRequestContext();
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.top += measuredHeight;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.bottom += 0;
        }
        BuiltInFictitiousFunctionClassFactory(this.moveToNextValue, this.getErrorConfigVersion, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.FragmentBottomSheetPaymentSettingBinding.equals(this.isLayoutRequested)) {
            WindowInsetsCompat windowInsetsCompat = this.isLayoutRequested;
            this.FragmentBottomSheetPaymentSettingBinding = windowInsetsCompat;
            ViewCompat.PlaceComponentResult(this.moveToNextValue, windowInsetsCompat);
        } else if (Build.VERSION.SDK_INT < 21 && !this.NetworkUserEntityData$$ExternalSyntheticLambda5.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.set(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.moveToNextValue.dispatchFitSystemWindows(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        measureChildWithMargins(this.moveToNextValue, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.moveToNextValue.getLayoutParams();
        int max3 = Math.max(max, this.moveToNextValue.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.moveToNextValue.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.moveToNextValue.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        fsSuperDraw_4cd02ea059c4058ece6112dde1a10fb3(canvas);
        if (this.getSupportButtonTintMode == null || this.PrepareContext) {
            return;
        }
        int bottom = this.mActionBarTop.getVisibility() == 0 ? (int) (this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY() + 0.5f) : 0;
        this.getSupportButtonTintMode.setBounds(0, bottom, getWidth(), this.getSupportButtonTintMode.getIntrinsicHeight() + bottom);
        this.getSupportButtonTintMode.draw(canvas);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.mActionBarTop.getVisibility() != 0) {
            return false;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.whenAvailable.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.initRecordTimeStamp = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.getAuthRequestContext;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.initRecordTimeStamp + i2;
        this.initRecordTimeStamp = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || this.mAnimatingForFling) {
            return;
        }
        if (this.initRecordTimeStamp <= this.mActionBarTop.getHeight()) {
            haltActionBarHideOffsetAnimations();
            postDelayed(this.getCallingPid, 600L);
            return;
        }
        haltActionBarHideOffsetAnimations();
        postDelayed(this.BuiltInFictitiousFunctionClassFactory, 600L);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 && z) {
            if (KClassImpl$Data$declaredNonStaticMembers$2(f2)) {
                haltActionBarHideOffsetAnimations();
                this.BuiltInFictitiousFunctionClassFactory.run();
            } else {
                haltActionBarHideOffsetAnimations();
                this.getCallingPid.run();
            }
            this.mAnimatingForFling = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.whenAvailable;
        return nestedScrollingParentHelper.BuiltInFictitiousFunctionClassFactory | nestedScrollingParentHelper.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    void pullChildren() {
        DecorToolbar wrapper;
        if (this.moveToNextValue == null) {
            this.moveToNextValue = (ContentFrameLayout) findViewById(R.id.getAuthRequestContext);
            this.mActionBarTop = (ActionBarContainer) findViewById(R.id.PlaceComponentResult);
            View findViewById = findViewById(R.id.KClassImpl$Data$declaredNonStaticMembers$2);
            if (findViewById instanceof DecorToolbar) {
                wrapper = (DecorToolbar) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't make a decor toolbar out of ");
                sb.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(sb.toString());
            }
            this.DatabaseTableConfigUtil = wrapper;
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
            if (z) {
                return;
            }
            haltActionBarHideOffsetAnimations();
            setActionBarHideOffset(0);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(i, this.mActionBarTop.getHeight())));
    }

    void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.getCallingPid);
        removeCallbacks(this.BuiltInFictitiousFunctionClassFactory);
        ViewPropertyAnimator viewPropertyAnimator = this.mCurrentActionBarTopAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        this.GetContactSyncConfig.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.GetContactSyncConfig.getFinalY() > this.mActionBarTop.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        pullChildren();
        this.DatabaseTableConfigUtil.getAuthRequestContext(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        pullChildren();
        this.DatabaseTableConfigUtil.getAuthRequestContext(charSequence);
    }

    public CharSequence getTitle() {
        pullChildren();
        return this.DatabaseTableConfigUtil.lookAheadTest();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int i) {
        pullChildren();
        if (i == 2) {
            this.DatabaseTableConfigUtil.isLayoutRequested();
        } else if (i == 5) {
            this.DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda2();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public boolean hasIcon() {
        pullChildren();
        return this.DatabaseTableConfigUtil.initRecordTimeStamp();
    }

    public boolean hasLogo() {
        pullChildren();
        return this.DatabaseTableConfigUtil.GetContactSyncConfig();
    }

    public void setIcon(int i) {
        pullChildren();
        this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(i);
    }

    public void setIcon(Drawable drawable) {
        pullChildren();
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(drawable);
    }

    public void setLogo(int i) {
        pullChildren();
        this.DatabaseTableConfigUtil.PlaceComponentResult(i);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.DatabaseTableConfigUtil.getAuthRequestContext();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.DatabaseTableConfigUtil.newProxyInstance();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.DatabaseTableConfigUtil.PrepareContext();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        pullChildren();
        return this.DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda7();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        pullChildren();
        return this.DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda8();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        pullChildren();
        this.DatabaseTableConfigUtil.MyBillsEntityDataFactory(menu, callback);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        pullChildren();
        this.DatabaseTableConfigUtil.MyBillsEntityDataFactory(sparseArray);
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        pullChildren();
        this.DatabaseTableConfigUtil.PlaceComponentResult(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        pullChildren();
        this.DatabaseTableConfigUtil.PlaceComponentResult();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
