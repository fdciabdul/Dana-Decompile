package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.flexbox.FlexItem;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup implements FSDispatchDraw {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    public ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {116, 44, -28, -115, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int getAuthRequestContext = 142;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 6
            int r7 = r7 + 97
            int r9 = r9 * 5
            int r9 = 23 - r9
            byte[] r0 = androidx.constraintlayout.widget.ConstraintLayout.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 22
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + (-8)
            int r7 = r7 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a(int, byte, short, java.lang.Object[]):void");
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_ab19b2055450747a0a5e34d8e991603c(canvas, view, j);
    }

    public void fsSuperDispatchDraw_ab19b2055450747a0a5e34d8e991603c(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_ab19b2055450747a0a5e34d8e991603c(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.mDesignIds;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return null;
            }
            return this.mDesignIds.get(str);
        }
        return null;
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = DeepRecoverARiverProxy.TYPE_ENTITY_APP;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = DeepRecoverARiverProxy.TYPE_ENTITY_APP;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = DeepRecoverARiverProxy.TYPE_ENTITY_APP;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = DeepRecoverARiverProxy.TYPE_ENTITY_APP;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i, i2);
    }

    @Override // android.view.View
    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class Measurer implements BasicMeasure.Measurer {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        ConstraintLayout MyBillsEntityDataFactory;
        int PlaceComponentResult;
        int getAuthRequestContext;
        int getErrorConfigVersion;
        int moveToNextValue;

        public Measurer(ConstraintLayout constraintLayout) {
            this.MyBillsEntityDataFactory = constraintLayout;
        }

        private static boolean getAuthRequestContext(int i, int i2, int i3) {
            if (i == i2) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void getAuthRequestContext() {
            int childCount = this.MyBillsEntityDataFactory.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.MyBillsEntityDataFactory.getChildAt(i);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this.MyBillsEntityDataFactory);
                }
            }
            int size = this.MyBillsEntityDataFactory.mConstraintHelpers.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ((ConstraintHelper) this.MyBillsEntityDataFactory.mConstraintHelpers.get(i2)).updatePostMeasure(this.MyBillsEntityDataFactory);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:156:0x01e9  */
        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void PlaceComponentResult(androidx.constraintlayout.core.widgets.ConstraintWidget r18, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure r19) {
            /*
                Method dump skipped, instructions count: 837
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.Measurer.PlaceComponentResult(androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure):void");
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        this.mLayoutWidget.NetworkUserEntityData$$ExternalSyntheticLambda6 = this;
        this.mLayoutWidget.MyBillsEntityDataFactory(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.getOnBoardingScenario) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.B) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.C) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.VerifyPinStateManager$executeRiskChallenge$2$1) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.NewMerchantCategoryAdapter) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.TypeProjectionImpl) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.N) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.PlaceComponentResult(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.w = this.mOptimizationLevel;
        LinearSystem.moveToNextValue = constraintWidgetContainer.initRecordTimeStamp(512);
    }

    protected void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.core.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.c = new androidx.constraintlayout.core.widgets.Guideline();
            layoutParams.VerifyPinStateManager$executeRiskChallenge$2$2 = true;
            ((androidx.constraintlayout.core.widgets.Guideline) layoutParams.c).NetworkUserEntityData$$ExternalSyntheticLambda2(layoutParams.O);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).D = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.getContainerAuth.remove(viewWidget);
        viewWidget.whenAvailable();
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i));
            if (viewWidget != null) {
                viewWidget.whenAvailable();
            }
        }
        if (isInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).NetworkUserEntityData$$ExternalSyntheticLambda4 = resourceName;
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.BuiltInFictitiousFunctionClassFactory(this);
        }
        this.mLayoutWidget.getContainerAuth.clear();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                this.mConstraintHelpers.get(i4).updatePreLayout(this);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt3 = getChildAt(i5);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt4 = getChildAt(i6);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt5 = getChildAt(i7);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.mLayoutWidget.KClassImpl$Data$declaredNonStaticMembers$2(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
            }
        }
    }

    public void applyConstraintsFromLayoutParams(boolean z, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        layoutParams.PlaceComponentResult();
        layoutParams.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
        constraintWidget.h = view.getVisibility();
        if (layoutParams.getOnBoardingScenario) {
            constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            constraintWidget.h = 8;
        }
        constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda6 = view;
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).resolveRtl(constraintWidget, this.mLayoutWidget.C());
        }
        if (layoutParams.VerifyPinStateManager$executeRiskChallenge$2$2) {
            androidx.constraintlayout.core.widgets.Guideline guideline = (androidx.constraintlayout.core.widgets.Guideline) constraintWidget;
            int i = layoutParams.N;
            int i2 = layoutParams.SummaryVoucherView$$ExternalSyntheticLambda1;
            float f = layoutParams.S;
            if (Build.VERSION.SDK_INT < 17) {
                i = layoutParams.whenAvailable;
                i2 = layoutParams.getSupportButtonTintMode;
                f = layoutParams.SubSequence;
            }
            if (f != -1.0f) {
                guideline.PlaceComponentResult(f);
                return;
            } else if (i != -1) {
                guideline.DatabaseTableConfigUtil(i);
                return;
            } else if (i2 != -1) {
                guideline.initRecordTimeStamp(i2);
                return;
            } else {
                return;
            }
        }
        int i3 = layoutParams.R;
        int i4 = layoutParams.isAuth;
        int i5 = layoutParams.T;
        int i6 = layoutParams.U;
        int i7 = layoutParams.SummaryVoucherView$$ExternalSyntheticLambda0;
        int i8 = layoutParams.P;
        float f2 = layoutParams.SummaryVoucherView$$ExternalSyntheticLambda2;
        if (Build.VERSION.SDK_INT < 17) {
            i3 = layoutParams.I;
            int i9 = layoutParams.G;
            int i10 = layoutParams.V;
            int i11 = layoutParams.X;
            i7 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda3;
            i8 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda6;
            f2 = layoutParams.BottomSheetCardBindingView$watcherCardNumberView$1;
            if (i3 == -1 && i9 == -1) {
                if (layoutParams.Y != -1) {
                    i3 = layoutParams.Y;
                } else if (layoutParams.W != -1) {
                    i9 = layoutParams.W;
                }
            }
            if (i10 == -1 && i11 == -1) {
                if (layoutParams.PrepareContext != -1) {
                    i10 = layoutParams.PrepareContext;
                } else if (layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7 != -1) {
                    i11 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7;
                }
            }
            i6 = i11;
            i5 = i10;
            i4 = i9;
        }
        if (layoutParams.scheduleImpl != -1) {
            ConstraintWidget constraintWidget6 = sparseArray.get(layoutParams.scheduleImpl);
            if (constraintWidget6 != null) {
                float f3 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda0;
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER).BuiltInFictitiousFunctionClassFactory(constraintWidget6.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER), layoutParams.getErrorConfigVersion, 0, true);
                constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda3 = f3;
            }
        } else {
            if (i3 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray.get(i3);
                if (constraintWidget7 != null) {
                    constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT).BuiltInFictitiousFunctionClassFactory(constraintWidget7.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT), layoutParams.leftMargin, i7, true);
                }
            } else if (i4 != -1 && (constraintWidget2 = sparseArray.get(i4)) != null) {
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT).BuiltInFictitiousFunctionClassFactory(constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT), layoutParams.leftMargin, i7, true);
            }
            if (i5 != -1) {
                ConstraintWidget constraintWidget8 = sparseArray.get(i5);
                if (constraintWidget8 != null) {
                    constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT).BuiltInFictitiousFunctionClassFactory(constraintWidget8.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT), layoutParams.rightMargin, i8, true);
                }
            } else if (i6 != -1 && (constraintWidget3 = sparseArray.get(i6)) != null) {
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT).BuiltInFictitiousFunctionClassFactory(constraintWidget3.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT), layoutParams.rightMargin, i8, true);
            }
            if (layoutParams.isAuto != -1) {
                ConstraintWidget constraintWidget9 = sparseArray.get(layoutParams.isAuto);
                if (constraintWidget9 != null) {
                    constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP).BuiltInFictitiousFunctionClassFactory(constraintWidget9.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP), layoutParams.topMargin, layoutParams.getCallingPid, true);
                }
            } else if (layoutParams.Z != -1 && (constraintWidget4 = sparseArray.get(layoutParams.Z)) != null) {
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP).BuiltInFictitiousFunctionClassFactory(constraintWidget4.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM), layoutParams.topMargin, layoutParams.getCallingPid, true);
            }
            if (layoutParams.lookAheadTest != -1) {
                ConstraintWidget constraintWidget10 = sparseArray.get(layoutParams.lookAheadTest);
                if (constraintWidget10 != null) {
                    constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM).BuiltInFictitiousFunctionClassFactory(constraintWidget10.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP), layoutParams.bottomMargin, layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda4, true);
                }
            } else if (layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 != -1 && (constraintWidget5 = sparseArray.get(layoutParams.KClassImpl$Data$declaredNonStaticMembers$2)) != null) {
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM).BuiltInFictitiousFunctionClassFactory(constraintWidget5.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM), layoutParams.bottomMargin, layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda4, true);
            }
            if (layoutParams.PlaceComponentResult != -1) {
                setWidgetBaseline(constraintWidget, layoutParams, sparseArray, layoutParams.PlaceComponentResult, ConstraintAnchor.Type.BASELINE);
            } else if (layoutParams.BuiltInFictitiousFunctionClassFactory != -1) {
                setWidgetBaseline(constraintWidget, layoutParams, sparseArray, layoutParams.BuiltInFictitiousFunctionClassFactory, ConstraintAnchor.Type.TOP);
            } else if (layoutParams.MyBillsEntityDataFactory != -1) {
                setWidgetBaseline(constraintWidget, layoutParams, sparseArray, layoutParams.MyBillsEntityDataFactory, ConstraintAnchor.Type.BOTTOM);
            }
            if (f2 >= 0.0f) {
                constraintWidget.BottomSheetCardBindingView$watcherCardNumberView$1 = f2;
            }
            if (layoutParams.flip >= 0.0f) {
                constraintWidget.e = layoutParams.flip;
            }
        }
        if (z && (layoutParams.isLayoutRequested != -1 || layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda8 != -1)) {
            constraintWidget.MyBillsEntityDataFactory(layoutParams.isLayoutRequested, layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        if (!layoutParams.B) {
            if (layoutParams.width == -1) {
                if (layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    constraintWidget.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                } else {
                    constraintWidget.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                }
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT).getAuthRequestContext = layoutParams.leftMargin;
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT).getAuthRequestContext = layoutParams.rightMargin;
            } else {
                constraintWidget.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                constraintWidget.getErrorConfigVersion(0);
            }
        } else {
            constraintWidget.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.FIXED;
            constraintWidget.getErrorConfigVersion(layoutParams.width);
            if (layoutParams.width == -2) {
                constraintWidget.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
        }
        if (!layoutParams.b) {
            if (layoutParams.height == -1) {
                if (layoutParams.moveToNextValue) {
                    constraintWidget.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                } else {
                    constraintWidget.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                }
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP).getAuthRequestContext = layoutParams.topMargin;
                constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM).getAuthRequestContext = layoutParams.bottomMargin;
            } else {
                constraintWidget.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                constraintWidget.lookAheadTest(0);
            }
        } else {
            constraintWidget.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.FIXED;
            constraintWidget.lookAheadTest(layoutParams.height);
            if (layoutParams.height == -2) {
                constraintWidget.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
        }
        constraintWidget.BuiltInFictitiousFunctionClassFactory(layoutParams.GetContactSyncConfig);
        constraintWidget.i[0] = layoutParams.getValueOfTouchPositionAbsolute;
        constraintWidget.i[1] = layoutParams.d;
        constraintWidget.E = layoutParams.C;
        constraintWidget.f = layoutParams.shouldRecycleViewType;
        int i12 = layoutParams.f5944a;
        if (i12 >= 0 && i12 <= 3) {
            constraintWidget.connectForeground = i12;
        }
        int i13 = layoutParams.H;
        int i14 = layoutParams.M;
        int i15 = layoutParams.J;
        float f4 = layoutParams.getNameOrBuilderList;
        constraintWidget.N = i13;
        constraintWidget.P = i14;
        if (i15 == Integer.MAX_VALUE) {
            i15 = 0;
        }
        constraintWidget.O = i15;
        constraintWidget.S = f4;
        if (f4 > 0.0f && f4 < 1.0f && i13 == 0) {
            constraintWidget.N = 2;
        }
        int i16 = layoutParams.F;
        int i17 = layoutParams.K;
        int i18 = layoutParams.AppCompatEmojiTextHelper;
        float f5 = layoutParams.L;
        constraintWidget.K = i16;
        constraintWidget.SummaryVoucherView$$ExternalSyntheticLambda0 = i17;
        if (i18 == Integer.MAX_VALUE) {
            i18 = 0;
        }
        constraintWidget.Q = i18;
        constraintWidget.R = f5;
        if (f5 <= 0.0f || f5 >= 1.0f || i16 != 0) {
            return;
        }
        constraintWidget.K = 2;
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i);
        ConstraintWidget constraintWidget2 = sparseArray.get(i);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        layoutParams.Q = true;
        if (type == ConstraintAnchor.Type.BASELINE) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.Q = true;
            layoutParams2.c.scheduleImpl = true;
        }
        constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BASELINE).BuiltInFictitiousFunctionClassFactory(constraintWidget2.BuiltInFictitiousFunctionClassFactory(type), layoutParams.getAuthRequestContext, layoutParams.newProxyInstance, true);
        constraintWidget.scheduleImpl = true;
        constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP).lookAheadTest();
        constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM).lookAheadTest();
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).c;
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).c;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).c;
            }
            return null;
        }
        return null;
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.MyBillsEntityDataFactory(metrics);
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int max;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int max2 = Math.max(0, getPaddingTop());
        int max3 = Math.max(0, getPaddingBottom());
        int i4 = max2 + max3;
        int paddingWidth = getPaddingWidth();
        Measurer measurer = this.mMeasurer;
        measurer.getErrorConfigVersion = max2;
        measurer.BuiltInFictitiousFunctionClassFactory = max3;
        measurer.moveToNextValue = paddingWidth;
        measurer.PlaceComponentResult = i4;
        measurer.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        measurer.getAuthRequestContext = i3;
        if (Build.VERSION.SDK_INT >= 17) {
            max = Math.max(0, getPaddingStart());
            int max4 = Math.max(0, getPaddingEnd());
            if (max > 0 || max4 > 0) {
                if (isRtl()) {
                    max = max4;
                }
                int i5 = size - paddingWidth;
                int i6 = size2 - i4;
                setSelfDimensionBehaviour(constraintWidgetContainer, mode, i5, mode2, i6);
                constraintWidgetContainer.PlaceComponentResult(i, mode, i5, mode2, i6, max, max2);
            }
        }
        max = Math.max(0, getPaddingLeft());
        int i52 = size - paddingWidth;
        int i62 = size2 - i4;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i52, mode2, i62);
        constraintWidgetContainer.PlaceComponentResult(i, mode, i52, mode2, i62, max, max2);
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5 = this.mMeasurer.PlaceComponentResult;
        int resolveSizeAndState = resolveSizeAndState(i3 + this.mMeasurer.moveToNextValue, i, 0);
        int resolveSizeAndState2 = resolveSizeAndState(i4 + i5, i2, 0);
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & FlexItem.MAX_SIZE);
        int min2 = Math.min(this.mMaxHeight, resolveSizeAndState2 & FlexItem.MAX_SIZE);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.mOnMeasureWidthMeasureSpec;
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                } else if (getChildAt(i4).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.s = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
                constraintWidgetContainer.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer);
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
        int i5 = constraintWidgetContainer2.h == 8 ? 0 : constraintWidgetContainer2.FlowViewUtil$textChanges$2;
        ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutWidget;
        resolveMeasuredDimension(i, i2, i5, constraintWidgetContainer3.h == 8 ? 0 : constraintWidgetContainer3.C, this.mLayoutWidget.A(), this.mLayoutWidget.lookAheadTest());
    }

    public boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) {
            Context context = getContext();
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[41];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                if (((((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).flags & 4194304) != 0) && 1 == getLayoutDirection()) {
                    return true;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return false;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Build.VERSION.SDK_INT >= 17 ? Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart()) : 0;
        return max2 > 0 ? max2 : max;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        if (r13 != (r9.h == 8 ? 0 : r9.C)) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r0 = r8.mMeasurer
            int r0 = r0.PlaceComponentResult
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r1 = r8.mMeasurer
            int r1 = r1.moveToNextValue
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            int r4 = r8.getChildCount()
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 0
            if (r10 == r6) goto L31
            if (r10 == 0) goto L24
            if (r10 == r5) goto L1c
            goto L2f
        L1c:
            int r10 = r8.mMaxWidth
            int r10 = r10 - r1
            int r11 = java.lang.Math.min(r10, r11)
            goto L3b
        L24:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L2f
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r7, r10)
            goto L3b
        L2f:
            r11 = 0
            goto L3b
        L31:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L3b
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r7, r10)
        L3b:
            if (r12 == r6) goto L57
            if (r12 == 0) goto L4a
            if (r12 == r5) goto L42
            goto L55
        L42:
            int r10 = r8.mMaxHeight
            int r10 = r10 - r0
            int r13 = java.lang.Math.min(r10, r13)
            goto L61
        L4a:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L55
            int r10 = r8.mMinHeight
            int r13 = java.lang.Math.max(r7, r10)
            goto L61
        L55:
            r13 = 0
            goto L61
        L57:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L61
            int r10 = r8.mMinHeight
            int r13 = java.lang.Math.max(r7, r10)
        L61:
            int r10 = r9.h
            r12 = 8
            if (r10 != r12) goto L69
            r10 = 0
            goto L6b
        L69:
            int r10 = r9.FlowViewUtil$textChanges$2
        L6b:
            r4 = 1
            if (r11 != r10) goto L78
            int r10 = r9.h
            if (r10 != r12) goto L74
            r10 = 0
            goto L76
        L74:
            int r10 = r9.C
        L76:
            if (r13 == r10) goto L7c
        L78:
            androidx.constraintlayout.core.widgets.analyzer.DependencyGraph r10 = r9.getAuthRequestContext
            r10.getAuthRequestContext = r4
        L7c:
            r9.moveToNextValue(r7)
            r9.GetContactSyncConfig(r7)
            int r10 = r8.mMaxWidth
            int r10 = r10 - r1
            int[] r12 = r9.SummaryVoucherView$$ExternalSyntheticLambda2
            r12[r7] = r10
            int r10 = r8.mMaxHeight
            int r10 = r10 - r0
            int[] r12 = r9.SummaryVoucherView$$ExternalSyntheticLambda2
            r12[r4] = r10
            r9.scheduleImpl(r7)
            r9.NetworkUserEntityData$$ExternalSyntheticLambda0(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r9.getNameOrBuilderList
            r10[r7] = r2
            r9.getErrorConfigVersion(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r9.getNameOrBuilderList
            r10[r4] = r3
            r9.lookAheadTest(r13)
            int r10 = r8.mMinWidth
            int r10 = r10 - r1
            r9.scheduleImpl(r10)
            int r10 = r8.mMinHeight
            int r10 = r10 - r0
            r9.NetworkUserEntityData$$ExternalSyntheticLambda0(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int, int):void");
    }

    public void setState(int i, int i2, int i3) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.c;
            if ((childAt.getVisibility() != 8 || layoutParams.VerifyPinStateManager$executeRiskChallenge$2$2 || layoutParams.D || layoutParams.E || isInEditMode) && !layoutParams.getOnBoardingScenario) {
                int NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda1();
                int DatabaseTableConfigUtil = constraintWidget.DatabaseTableConfigUtil();
                int i6 = (constraintWidget.h == 8 ? 0 : constraintWidget.FlowViewUtil$textChanges$2) + NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i7 = (constraintWidget.h == 8 ? 0 : constraintWidget.C) + DatabaseTableConfigUtil;
                childAt.layout(NetworkUserEntityData$$ExternalSyntheticLambda1, DatabaseTableConfigUtil, i6, i7);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(NetworkUserEntityData$$ExternalSyntheticLambda1, DatabaseTableConfigUtil, i6, i7);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.mConstraintHelpers.get(i8).updatePostLayout(this);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.w = i;
        LinearSystem.moveToNextValue = constraintWidgetContainer.initRecordTimeStamp(512);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.w;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).updatePreDraw(this);
            }
        }
        fsSuperDispatchDraw_ab19b2055450747a0a5e34d8e991603c(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.MyBillsEntityDataFactory = constraintsChangedListener;
        }
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
                return;
            } catch (Resources.NotFoundException unused) {
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        boolean A;
        public int AppCompatEmojiTextHelper;
        boolean B;
        public float BottomSheetCardBindingView$watcherCardNumberView$1;
        public int BuiltInFictitiousFunctionClassFactory;
        public int C;
        boolean D;
        public String DatabaseTableConfigUtil;
        boolean E;
        public int F;
        public int FragmentBottomSheetPaymentSettingBinding;
        public int G;
        public String GetContactSyncConfig;
        public int H;
        public int I;
        public int J;
        public int K;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public float L;
        public int M;
        public int MyBillsEntityDataFactory;
        int N;
        public float NetworkUserEntityData$$ExternalSyntheticLambda0;
        int NetworkUserEntityData$$ExternalSyntheticLambda1;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
        public int NetworkUserEntityData$$ExternalSyntheticLambda3;
        public int NetworkUserEntityData$$ExternalSyntheticLambda4;
        public int NetworkUserEntityData$$ExternalSyntheticLambda5;
        public int NetworkUserEntityData$$ExternalSyntheticLambda6;
        public int NetworkUserEntityData$$ExternalSyntheticLambda7;
        public int NetworkUserEntityData$$ExternalSyntheticLambda8;
        public int O;
        int P;
        public int PlaceComponentResult;
        public int PrepareContext;
        boolean Q;
        boolean QrExpiredActivity;
        int R;
        float S;
        public float SubSequence;
        int SummaryVoucherView$$ExternalSyntheticLambda0;
        int SummaryVoucherView$$ExternalSyntheticLambda1;
        float SummaryVoucherView$$ExternalSyntheticLambda2;
        int T;
        int U;
        public int V;
        public boolean VerifyPinStateManager$executeRiskChallenge$2$1;
        boolean VerifyPinStateManager$executeRiskChallenge$2$2;
        public int W;
        public int X;
        public int Y;
        public int Z;

        /* renamed from: a  reason: collision with root package name */
        public int f5944a;
        boolean b;
        public ConstraintWidget c;
        public float d;
        public float flip;
        public int getAuthRequestContext;
        public int getCallingPid;
        public int getErrorConfigVersion;
        public float getNameOrBuilderList;
        boolean getOnBoardingScenario;
        public int getSupportButtonTintMode;
        public float getValueOfTouchPositionAbsolute;
        float initRecordTimeStamp;
        int isAuth;
        public int isAuto;
        public int isLayoutRequested;
        public int lookAheadTest;
        public boolean moveToNextValue;
        public int newProxyInstance;
        public boolean readMicros;
        public int scheduleImpl;
        public int shouldRecycleViewType;
        public int whenAvailable;

        /* loaded from: classes3.dex */
        static class Table {
            public static final SparseIntArray MyBillsEntityDataFactory;

            private Table() {
            }

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                MyBillsEntityDataFactory = sparseIntArray;
                sparseIntArray.append(R.styleable.onDecodeSuccess, 64);
                sparseIntArray.append(R.styleable.f5946o, 65);
                sparseIntArray.append(R.styleable.TypefaceCompatApi26Impl, 8);
                sparseIntArray.append(R.styleable.v, 9);
                sparseIntArray.append(R.styleable.y, 10);
                sparseIntArray.append(R.styleable.z, 11);
                sparseIntArray.append(R.styleable.FlowableCreate$BufferAsyncEmitter, 12);
                sparseIntArray.append(R.styleable.OtpRegistrationPresenter$input$1, 13);
                sparseIntArray.append(R.styleable.FlowViewUtil$textChanges$2, 14);
                sparseIntArray.append(R.styleable.connectForeground, 15);
                sparseIntArray.append(R.styleable.f, 16);
                sparseIntArray.append(R.styleable.i, 52);
                sparseIntArray.append(R.styleable.FlowViewUtil$textChanges$1, 53);
                sparseIntArray.append(R.styleable.j, 2);
                sparseIntArray.append(R.styleable.k, 3);
                sparseIntArray.append(R.styleable.m, 4);
                sparseIntArray.append(R.styleable.access$getCapacity$p, 49);
                sparseIntArray.append(R.styleable.f30reduceIndexedz1zDJgo, 50);
                sparseIntArray.append(R.styleable.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, 5);
                sparseIntArray.append(R.styleable.n, 6);
                sparseIntArray.append(R.styleable.p, 7);
                sparseIntArray.append(R.styleable.f5945a, 67);
                sparseIntArray.append(R.styleable.getValueOfTouchPositionAbsolute, 1);
                sparseIntArray.append(R.styleable.RequestMoneyQrContract$View, 17);
                sparseIntArray.append(R.styleable.initAnimators, 18);
                sparseIntArray.append(R.styleable.OtpRegistrationPresenter$input$2, 19);
                sparseIntArray.append(R.styleable.access$throwIllegalArgumentType, 20);
                sparseIntArray.append(R.styleable.SendMoneyScenario, 21);
                sparseIntArray.append(R.styleable.access$setShowcaseShowing$p, 22);
                sparseIntArray.append(R.styleable.InitSecurePreferenceAccount, 23);
                sparseIntArray.append(R.styleable.ReferralMapper_Factory, 24);
                sparseIntArray.append(R.styleable.retainOrRemoveAllInternal, 25);
                sparseIntArray.append(R.styleable.PromoCategoryPresenter$1, 26);
                sparseIntArray.append(R.styleable.checkRegisteredUserAndSendOtp, 55);
                sparseIntArray.append(R.styleable.getReadyFragment, 54);
                sparseIntArray.append(R.styleable.q, 29);
                sparseIntArray.append(R.styleable.FlowableReduce$ReduceSubscriber, 30);
                sparseIntArray.append(R.styleable.l, 44);
                sparseIntArray.append(R.styleable.w, 45);
                sparseIntArray.append(R.styleable.getContainerAuth, 46);
                sparseIntArray.append(R.styleable.x, 47);
                sparseIntArray.append(R.styleable.JsonParseException, 48);
                sparseIntArray.append(R.styleable.FillAnimation, 27);
                sparseIntArray.append(R.styleable.e, 28);
                sparseIntArray.append(R.styleable.getDefaultSenderId, 31);
                sparseIntArray.append(R.styleable.t, 32);
                sparseIntArray.append(R.styleable.ApiStatus$AvailableSince, 33);
                sparseIntArray.append(R.styleable.secondaryHash, 34);
                sparseIntArray.append(R.styleable.getIndexName, 35);
                sparseIntArray.append(R.styleable.SizeSelectors$OrSelector, 36);
                sparseIntArray.append(R.styleable.r, 37);
                sparseIntArray.append(R.styleable.s, 38);
                sparseIntArray.append(R.styleable.u, 39);
                sparseIntArray.append(R.styleable.verifyNotNull, 40);
                sparseIntArray.append(R.styleable.setNetAuthId, 41);
                sparseIntArray.append(R.styleable.h, 42);
                sparseIntArray.append(R.styleable.g, 43);
                sparseIntArray.append(R.styleable.getCardNumberOCR, 51);
                sparseIntArray.append(R.styleable.insertActivities, 66);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.whenAvailable = -1;
            this.getSupportButtonTintMode = -1;
            this.SubSequence = -1.0f;
            this.readMicros = true;
            this.I = -1;
            this.G = -1;
            this.V = -1;
            this.X = -1;
            this.isAuto = -1;
            this.Z = -1;
            this.lookAheadTest = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.PlaceComponentResult = -1;
            this.BuiltInFictitiousFunctionClassFactory = -1;
            this.MyBillsEntityDataFactory = -1;
            this.scheduleImpl = -1;
            this.getErrorConfigVersion = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
            this.W = -1;
            this.Y = -1;
            this.PrepareContext = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = Integer.MIN_VALUE;
            this.getCallingPid = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = Integer.MIN_VALUE;
            this.FragmentBottomSheetPaymentSettingBinding = Integer.MIN_VALUE;
            this.newProxyInstance = Integer.MIN_VALUE;
            this.getAuthRequestContext = 0;
            this.QrExpiredActivity = true;
            this.A = true;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = 0.5f;
            this.flip = 0.5f;
            this.GetContactSyncConfig = null;
            this.initRecordTimeStamp = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
            this.getValueOfTouchPositionAbsolute = -1.0f;
            this.d = -1.0f;
            this.C = 0;
            this.shouldRecycleViewType = 0;
            this.H = 0;
            this.F = 0;
            this.M = 0;
            this.K = 0;
            this.J = 0;
            this.AppCompatEmojiTextHelper = 0;
            this.getNameOrBuilderList = 1.0f;
            this.L = 1.0f;
            this.isLayoutRequested = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
            this.O = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
            this.moveToNextValue = false;
            this.DatabaseTableConfigUtil = null;
            this.f5944a = 0;
            this.B = true;
            this.b = true;
            this.Q = false;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
            this.D = false;
            this.getOnBoardingScenario = false;
            this.E = false;
            this.R = -1;
            this.isAuth = -1;
            this.T = -1;
            this.U = -1;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = 0.5f;
            this.c = new ConstraintWidget();
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = Table.MyBillsEntityDataFactory.get(index);
                switch (i2) {
                    case 1:
                        this.O = obtainStyledAttributes.getInt(index, this.O);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.scheduleImpl);
                        this.scheduleImpl = resourceId;
                        if (resourceId == -1) {
                            this.scheduleImpl = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.getErrorConfigVersion = obtainStyledAttributes.getDimensionPixelSize(index, this.getErrorConfigVersion);
                        break;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.NetworkUserEntityData$$ExternalSyntheticLambda0) % 360.0f;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
                        if (f < 0.0f) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.whenAvailable = obtainStyledAttributes.getDimensionPixelOffset(index, this.whenAvailable);
                        break;
                    case 6:
                        this.getSupportButtonTintMode = obtainStyledAttributes.getDimensionPixelOffset(index, this.getSupportButtonTintMode);
                        break;
                    case 7:
                        this.SubSequence = obtainStyledAttributes.getFloat(index, this.SubSequence);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.I);
                        this.I = resourceId2;
                        if (resourceId2 == -1) {
                            this.I = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.G);
                        this.G = resourceId3;
                        if (resourceId3 == -1) {
                            this.G = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.V);
                        this.V = resourceId4;
                        if (resourceId4 == -1) {
                            this.V = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.X);
                        this.X = resourceId5;
                        if (resourceId5 == -1) {
                            this.X = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.isAuto);
                        this.isAuto = resourceId6;
                        if (resourceId6 == -1) {
                            this.isAuto = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.Z);
                        this.Z = resourceId7;
                        if (resourceId7 == -1) {
                            this.Z = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.lookAheadTest);
                        this.lookAheadTest = resourceId8;
                        if (resourceId8 == -1) {
                            this.lookAheadTest = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = resourceId9;
                        if (resourceId9 == -1) {
                            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.PlaceComponentResult);
                        this.PlaceComponentResult = resourceId10;
                        if (resourceId10 == -1) {
                            this.PlaceComponentResult = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.W);
                        this.W = resourceId11;
                        if (resourceId11 == -1) {
                            this.W = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.Y);
                        this.Y = resourceId12;
                        if (resourceId12 == -1) {
                            this.Y = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.PrepareContext);
                        this.PrepareContext = resourceId13;
                        if (resourceId13 == -1) {
                            this.PrepareContext = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = resourceId14;
                        if (resourceId14 == -1) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        break;
                    case 22:
                        this.getCallingPid = obtainStyledAttributes.getDimensionPixelSize(index, this.getCallingPid);
                        break;
                    case 23:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
                        break;
                    case 24:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                        break;
                    case 25:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
                        break;
                    case 26:
                        this.FragmentBottomSheetPaymentSettingBinding = obtainStyledAttributes.getDimensionPixelSize(index, this.FragmentBottomSheetPaymentSettingBinding);
                        break;
                    case 27:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getBoolean(index, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        break;
                    case 28:
                        this.moveToNextValue = obtainStyledAttributes.getBoolean(index, this.moveToNextValue);
                        break;
                    case 29:
                        this.BottomSheetCardBindingView$watcherCardNumberView$1 = obtainStyledAttributes.getFloat(index, this.BottomSheetCardBindingView$watcherCardNumberView$1);
                        break;
                    case 30:
                        this.flip = obtainStyledAttributes.getFloat(index, this.flip);
                        break;
                    case 31:
                        int i3 = obtainStyledAttributes.getInt(index, 0);
                        this.H = i3;
                        if (i3 == 1) {
                            InstrumentInjector.log_e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i4 = obtainStyledAttributes.getInt(index, 0);
                        this.F = i4;
                        if (i4 == 1) {
                            InstrumentInjector.log_e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.getNameOrBuilderList = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.getNameOrBuilderList));
                        this.H = 2;
                        break;
                    case 36:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.AppCompatEmojiTextHelper = obtainStyledAttributes.getDimensionPixelSize(index, this.AppCompatEmojiTextHelper);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.AppCompatEmojiTextHelper) == -2) {
                                this.AppCompatEmojiTextHelper = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.L = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.L));
                        this.F = 2;
                        break;
                    default:
                        switch (i2) {
                            case 44:
                                ConstraintSet.BuiltInFictitiousFunctionClassFactory(this, obtainStyledAttributes.getString(index));
                                continue;
                            case 45:
                                this.getValueOfTouchPositionAbsolute = obtainStyledAttributes.getFloat(index, this.getValueOfTouchPositionAbsolute);
                                continue;
                            case 46:
                                this.d = obtainStyledAttributes.getFloat(index, this.d);
                                continue;
                            case 47:
                                this.C = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.shouldRecycleViewType = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.isLayoutRequested = obtainStyledAttributes.getDimensionPixelOffset(index, this.isLayoutRequested);
                                continue;
                            case 50:
                                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainStyledAttributes.getDimensionPixelOffset(index, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                continue;
                            case 51:
                                this.DatabaseTableConfigUtil = obtainStyledAttributes.getString(index);
                                continue;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.BuiltInFictitiousFunctionClassFactory);
                                this.BuiltInFictitiousFunctionClassFactory = resourceId15;
                                if (resourceId15 == -1) {
                                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.MyBillsEntityDataFactory);
                                this.MyBillsEntityDataFactory = resourceId16;
                                if (resourceId16 == -1) {
                                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 54:
                                this.getAuthRequestContext = obtainStyledAttributes.getDimensionPixelSize(index, this.getAuthRequestContext);
                                continue;
                            case 55:
                                this.newProxyInstance = obtainStyledAttributes.getDimensionPixelSize(index, this.newProxyInstance);
                                continue;
                            default:
                                switch (i2) {
                                    case 64:
                                        ConstraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this, obtainStyledAttributes, index, 0);
                                        this.QrExpiredActivity = true;
                                        continue;
                                        continue;
                                    case 65:
                                        ConstraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this, obtainStyledAttributes, index, 1);
                                        this.A = true;
                                        continue;
                                    case 66:
                                        this.f5944a = obtainStyledAttributes.getInt(index, this.f5944a);
                                        continue;
                                    case 67:
                                        this.readMicros = obtainStyledAttributes.getBoolean(index, this.readMicros);
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            PlaceComponentResult();
        }

        public final void PlaceComponentResult() {
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
            this.B = true;
            this.b = true;
            if (this.width == -2 && this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                this.B = false;
                if (this.H == 0) {
                    this.H = 1;
                }
            }
            if (this.height == -2 && this.moveToNextValue) {
                this.b = false;
                if (this.F == 0) {
                    this.F = 1;
                }
            }
            if (this.width == 0 || this.width == -1) {
                this.B = false;
                if (this.width == 0 && this.H == 1) {
                    this.width = -2;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.b = false;
                if (this.height == 0 && this.F == 1) {
                    this.height = -2;
                    this.moveToNextValue = true;
                }
            }
            if (this.SubSequence == -1.0f && this.whenAvailable == -1 && this.getSupportButtonTintMode == -1) {
                return;
            }
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = true;
            this.B = true;
            this.b = true;
            if (!(this.c instanceof androidx.constraintlayout.core.widgets.Guideline)) {
                this.c = new androidx.constraintlayout.core.widgets.Guideline();
            }
            ((androidx.constraintlayout.core.widgets.Guideline) this.c).NetworkUserEntityData$$ExternalSyntheticLambda2(this.O);
        }

        public LayoutParams(int i) {
            super(i, -2);
            this.whenAvailable = -1;
            this.getSupportButtonTintMode = -1;
            this.SubSequence = -1.0f;
            this.readMicros = true;
            this.I = -1;
            this.G = -1;
            this.V = -1;
            this.X = -1;
            this.isAuto = -1;
            this.Z = -1;
            this.lookAheadTest = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.PlaceComponentResult = -1;
            this.BuiltInFictitiousFunctionClassFactory = -1;
            this.MyBillsEntityDataFactory = -1;
            this.scheduleImpl = -1;
            this.getErrorConfigVersion = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
            this.W = -1;
            this.Y = -1;
            this.PrepareContext = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = Integer.MIN_VALUE;
            this.getCallingPid = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = Integer.MIN_VALUE;
            this.FragmentBottomSheetPaymentSettingBinding = Integer.MIN_VALUE;
            this.newProxyInstance = Integer.MIN_VALUE;
            this.getAuthRequestContext = 0;
            this.QrExpiredActivity = true;
            this.A = true;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = 0.5f;
            this.flip = 0.5f;
            this.GetContactSyncConfig = null;
            this.initRecordTimeStamp = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
            this.getValueOfTouchPositionAbsolute = -1.0f;
            this.d = -1.0f;
            this.C = 0;
            this.shouldRecycleViewType = 0;
            this.H = 0;
            this.F = 0;
            this.M = 0;
            this.K = 0;
            this.J = 0;
            this.AppCompatEmojiTextHelper = 0;
            this.getNameOrBuilderList = 1.0f;
            this.L = 1.0f;
            this.isLayoutRequested = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
            this.O = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
            this.moveToNextValue = false;
            this.DatabaseTableConfigUtil = null;
            this.f5944a = 0;
            this.B = true;
            this.b = true;
            this.Q = false;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
            this.D = false;
            this.getOnBoardingScenario = false;
            this.E = false;
            this.R = -1;
            this.isAuth = -1;
            this.T = -1;
            this.U = -1;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = 0.5f;
            this.c = new ConstraintWidget();
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.whenAvailable = -1;
            this.getSupportButtonTintMode = -1;
            this.SubSequence = -1.0f;
            this.readMicros = true;
            this.I = -1;
            this.G = -1;
            this.V = -1;
            this.X = -1;
            this.isAuto = -1;
            this.Z = -1;
            this.lookAheadTest = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.PlaceComponentResult = -1;
            this.BuiltInFictitiousFunctionClassFactory = -1;
            this.MyBillsEntityDataFactory = -1;
            this.scheduleImpl = -1;
            this.getErrorConfigVersion = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
            this.W = -1;
            this.Y = -1;
            this.PrepareContext = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = Integer.MIN_VALUE;
            this.getCallingPid = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Integer.MIN_VALUE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = Integer.MIN_VALUE;
            this.FragmentBottomSheetPaymentSettingBinding = Integer.MIN_VALUE;
            this.newProxyInstance = Integer.MIN_VALUE;
            this.getAuthRequestContext = 0;
            this.QrExpiredActivity = true;
            this.A = true;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = 0.5f;
            this.flip = 0.5f;
            this.GetContactSyncConfig = null;
            this.initRecordTimeStamp = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
            this.getValueOfTouchPositionAbsolute = -1.0f;
            this.d = -1.0f;
            this.C = 0;
            this.shouldRecycleViewType = 0;
            this.H = 0;
            this.F = 0;
            this.M = 0;
            this.K = 0;
            this.J = 0;
            this.AppCompatEmojiTextHelper = 0;
            this.getNameOrBuilderList = 1.0f;
            this.L = 1.0f;
            this.isLayoutRequested = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
            this.O = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
            this.moveToNextValue = false;
            this.DatabaseTableConfigUtil = null;
            this.f5944a = 0;
            this.B = true;
            this.b = true;
            this.Q = false;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
            this.D = false;
            this.getOnBoardingScenario = false;
            this.E = false;
            this.R = -1;
            this.isAuth = -1;
            this.T = -1;
            this.U = -1;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = 0.5f;
            this.c = new ConstraintWidget();
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0099  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 264
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.l == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.mLayoutWidget.l = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.mLayoutWidget.l = "parent";
            }
        }
        if (this.mLayoutWidget.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            constraintWidgetContainer.NetworkUserEntityData$$ExternalSyntheticLambda4 = constraintWidgetContainer.l;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" setDebugName ");
            sb2.append(this.mLayoutWidget.NetworkUserEntityData$$ExternalSyntheticLambda4);
            InstrumentInjector.log_v(TAG, sb2.toString());
        }
        Iterator<ConstraintWidget> it = this.mLayoutWidget.getContainerAuth.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (view != null) {
                if (next.l == null && (id2 = view.getId()) != -1) {
                    next.l = getContext().getResources().getResourceEntryName(id2);
                }
                if (next.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                    next.NetworkUserEntityData$$ExternalSyntheticLambda4 = next.l;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" setDebugName ");
                    sb3.append(next.NetworkUserEntityData$$ExternalSyntheticLambda4);
                    InstrumentInjector.log_v(TAG, sb3.toString());
                }
            }
        }
        this.mLayoutWidget.KClassImpl$Data$declaredNonStaticMembers$2(sb);
        return sb.toString();
    }
}
