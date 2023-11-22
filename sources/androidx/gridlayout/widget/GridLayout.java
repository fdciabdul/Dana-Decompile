package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.gridlayout.R;
import androidx.legacy.widget.Space;
import com.alipay.mobile.zebra.data.BoxData;
import com.j256.ormlite.stmt.query.SimpleComparison;
import id.dana.domain.model.KycStatus;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class GridLayout extends ViewGroup {
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE;
    public static final Alignment BOTTOM;
    static final int CAN_STRETCH = 2;
    public static final Alignment CENTER;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    static final boolean DEFAULT_ORDER_PRESERVED = true;
    public static final Alignment END;
    public static final Alignment FILL;
    public static final int HORIZONTAL = 0;
    static final int INFLEXIBLE = 0;
    public static final Alignment LEFT;
    static final int MAX_SIZE = 100000;
    private static final Alignment MyBillsEntityDataFactory;
    public static final Alignment RIGHT;
    public static final Alignment START;
    public static final Alignment TOP;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH = 0;
    public static final int VERTICAL = 1;
    private static final Alignment lookAheadTest;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final Printer NO_PRINTER = new Printer() { // from class: androidx.gridlayout.widget.GridLayout.1
        @Override // android.util.Printer
        public final void println(String str) {
        }
    };
    private static final int BuiltInFictitiousFunctionClassFactory = R.styleable.FragmentBottomSheetPaymentSettingBinding;
    private static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = R.styleable.getCallingPid;
    private static final int getAuthRequestContext = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3;
    private static final int moveToNextValue = R.styleable.readMicros;
    private static final int KClassImpl$Data$declaredNonStaticMembers$2 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda4;
    private static final int scheduleImpl = R.styleable.whenAvailable;
    private static final int PlaceComponentResult = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5;
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.2
        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        final String MyBillsEntityDataFactory() {
            return KycStatus.UNDEFINED;
        }

        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        final int PlaceComponentResult(View view, int i) {
            return Integer.MIN_VALUE;
        }

        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        public final int getAuthRequestContext(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }
    };

    static boolean canStretch(int i) {
        return (i & 2) != 0;
    }

    static {
        final Alignment alignment = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.3
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final String MyBillsEntityDataFactory() {
                return "LEADING";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final int PlaceComponentResult(View view, int i) {
                return 0;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int getAuthRequestContext(View view, int i, int i2) {
                return 0;
            }
        };
        MyBillsEntityDataFactory = alignment;
        final Alignment alignment2 = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.4
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final String MyBillsEntityDataFactory() {
                return "TRAILING";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final int PlaceComponentResult(View view, int i) {
                return i;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int getAuthRequestContext(View view, int i, int i2) {
                return i;
            }
        };
        lookAheadTest = alignment2;
        TOP = alignment;
        BOTTOM = alignment2;
        START = alignment;
        END = alignment2;
        LEFT = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.5
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final int PlaceComponentResult(View view, int i) {
                return (!(ViewCompat.initRecordTimeStamp(view) == 1) ? Alignment.this : alignment2).PlaceComponentResult(view, i);
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int getAuthRequestContext(View view, int i, int i2) {
                return (!(ViewCompat.initRecordTimeStamp(view) == 1) ? Alignment.this : alignment2).getAuthRequestContext(view, i, i2);
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final String MyBillsEntityDataFactory() {
                StringBuilder sb = new StringBuilder();
                sb.append("SWITCHING[L:");
                sb.append(Alignment.this.MyBillsEntityDataFactory());
                sb.append(", R:");
                sb.append(alignment2.MyBillsEntityDataFactory());
                sb.append("]");
                return sb.toString();
            }
        };
        RIGHT = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.5
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final int PlaceComponentResult(View view, int i) {
                return (!(ViewCompat.initRecordTimeStamp(view) == 1) ? Alignment.this : alignment).PlaceComponentResult(view, i);
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int getAuthRequestContext(View view, int i, int i2) {
                return (!(ViewCompat.initRecordTimeStamp(view) == 1) ? Alignment.this : alignment).getAuthRequestContext(view, i, i2);
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final String MyBillsEntityDataFactory() {
                StringBuilder sb = new StringBuilder();
                sb.append("SWITCHING[L:");
                sb.append(Alignment.this.MyBillsEntityDataFactory());
                sb.append(", R:");
                sb.append(alignment.MyBillsEntityDataFactory());
                sb.append("]");
                return sb.toString();
            }
        };
        CENTER = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.6
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final String MyBillsEntityDataFactory() {
                return "CENTER";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final int PlaceComponentResult(View view, int i) {
                return i >> 1;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int getAuthRequestContext(View view, int i, int i2) {
                return i >> 1;
            }
        };
        BASELINE = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.7
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final String MyBillsEntityDataFactory() {
                return "BASELINE";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final int PlaceComponentResult(View view, int i) {
                return 0;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int getAuthRequestContext(View view, int i, int i2) {
                if (view.getVisibility() == 8) {
                    return 0;
                }
                int baseline = view.getBaseline();
                if (baseline == -1) {
                    return Integer.MIN_VALUE;
                }
                return baseline;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final Bounds BuiltInFictitiousFunctionClassFactory() {
                return new Bounds() { // from class: androidx.gridlayout.widget.GridLayout.7.1
                    private int BuiltInFictitiousFunctionClassFactory;

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    protected final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        super.KClassImpl$Data$declaredNonStaticMembers$2();
                        this.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    protected final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
                        super.BuiltInFictitiousFunctionClassFactory(i, i2);
                        this.BuiltInFictitiousFunctionClassFactory = Math.max(this.BuiltInFictitiousFunctionClassFactory, i + i2);
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    protected final int BuiltInFictitiousFunctionClassFactory(boolean z) {
                        return Math.max(super.BuiltInFictitiousFunctionClassFactory(z), this.BuiltInFictitiousFunctionClassFactory);
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    protected final int MyBillsEntityDataFactory(GridLayout gridLayout, View view, Alignment alignment3, int i, boolean z) {
                        return Math.max(0, super.MyBillsEntityDataFactory(gridLayout, view, alignment3, i, z));
                    }
                };
            }
        };
        FILL = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.8
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int MyBillsEntityDataFactory(int i, int i2) {
                return i2;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final String MyBillsEntityDataFactory() {
                return "FILL";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            final int PlaceComponentResult(View view, int i) {
                return 0;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public final int getAuthRequestContext(View view, int i, int i2) {
                return Integer.MIN_VALUE;
            }
        };
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(R.dimen.res_0x7f0700b1_kclassimpl_data_declarednonstaticmembers_2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lookAheadTest);
        try {
            setRowCount(obtainStyledAttributes.getInt(NetworkUserEntityData$$ExternalSyntheticLambda0, Integer.MIN_VALUE));
            setColumnCount(obtainStyledAttributes.getInt(getAuthRequestContext, Integer.MIN_VALUE));
            setOrientation(obtainStyledAttributes.getInt(BuiltInFictitiousFunctionClassFactory, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(moveToNextValue, false));
            setAlignmentMode(obtainStyledAttributes.getInt(KClassImpl$Data$declaredNonStaticMembers$2, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(scheduleImpl, true));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(PlaceComponentResult, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            MyBillsEntityDataFactory();
            requestLayout();
        }
    }

    public int getRowCount() {
        Axis axis = this.mVerticalAxis;
        return Math.max(axis.getAuthRequestContext, axis.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public void setRowCount(int i) {
        this.mVerticalAxis.BuiltInFictitiousFunctionClassFactory(i);
        MyBillsEntityDataFactory();
        requestLayout();
    }

    public int getColumnCount() {
        Axis axis = this.mHorizontalAxis;
        return Math.max(axis.getAuthRequestContext, axis.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public void setColumnCount(int i) {
        this.mHorizontalAxis.BuiltInFictitiousFunctionClassFactory(i);
        MyBillsEntityDataFactory();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public void setUseDefaultMargins(boolean z) {
        this.mUseDefaultMargins = z;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public void setAlignmentMode(int i) {
        this.mAlignmentMode = i;
        requestLayout();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.lookAheadTest();
    }

    public void setRowOrderPreserved(boolean z) {
        Axis axis = this.mVerticalAxis;
        axis.PrepareContext = z;
        axis.PlaceComponentResult();
        MyBillsEntityDataFactory();
        requestLayout();
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.lookAheadTest();
    }

    public void setColumnOrderPreserved(boolean z) {
        Axis axis = this.mHorizontalAxis;
        axis.PrepareContext = z;
        axis.PlaceComponentResult();
        MyBillsEntityDataFactory();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    static int max2(int[] iArr, int i) {
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    static Alignment getAlignment(int i, boolean z) {
        int i2 = (i & (z ? 7 : 112)) >> (z ? 0 : 4);
        if (i2 != 1) {
            if (i2 == 3) {
                return z ? LEFT : TOP;
            } else if (i2 == 5) {
                return z ? RIGHT : BOTTOM;
            } else if (i2 != 7) {
                if (i2 != 8388611) {
                    if (i2 == 8388613) {
                        return END;
                    }
                    return UNDEFINED_ALIGNMENT;
                }
                return START;
            } else {
                return FILL;
            }
        }
        return CENTER;
    }

    int getMargin1(View view, boolean z, boolean z2) {
        int i;
        LayoutParams layoutParams = getLayoutParams(view);
        if (z) {
            i = z2 ? layoutParams.leftMargin : layoutParams.rightMargin;
        } else {
            i = z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        }
        if (i == Integer.MIN_VALUE) {
            if (this.mUseDefaultMargins) {
                Spec spec = z ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory;
                Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
                Interval interval = spec.getAuthRequestContext;
                if (z && KClassImpl$Data$declaredNonStaticMembers$2()) {
                    z2 = !z2;
                }
                if (z2) {
                    int i2 = interval.KClassImpl$Data$declaredNonStaticMembers$2;
                } else {
                    int i3 = interval.getAuthRequestContext;
                    int i4 = axis.getAuthRequestContext;
                    axis.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                if (view.getClass() != Space.class && view.getClass() != android.widget.Space.class) {
                    return this.mDefaultGap / 2;
                }
            }
            return 0;
        }
        return i;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return ViewCompat.initRecordTimeStamp(this) == 1;
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(View view, boolean z, boolean z2) {
        int[] iArr;
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, z, z2);
        }
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        if (z2) {
            if (axis.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                axis.NetworkUserEntityData$$ExternalSyntheticLambda1 = new int[Math.max(axis.getAuthRequestContext, axis.KClassImpl$Data$declaredNonStaticMembers$2()) + 1];
            }
            if (!axis.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                axis.BuiltInFictitiousFunctionClassFactory(true);
                axis.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            }
            iArr = axis.NetworkUserEntityData$$ExternalSyntheticLambda1;
        } else {
            if (axis.NetworkUserEntityData$$ExternalSyntheticLambda5 == null) {
                axis.NetworkUserEntityData$$ExternalSyntheticLambda5 = new int[Math.max(axis.getAuthRequestContext, axis.KClassImpl$Data$declaredNonStaticMembers$2()) + 1];
            }
            if (!axis.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                axis.BuiltInFictitiousFunctionClassFactory(false);
                axis.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
            }
            iArr = axis.NetworkUserEntityData$$ExternalSyntheticLambda5;
        }
        LayoutParams layoutParams = getLayoutParams(view);
        Interval interval = (z ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext;
        return iArr[z2 ? interval.KClassImpl$Data$declaredNonStaticMembers$2 : interval.getAuthRequestContext];
    }

    private static boolean PlaceComponentResult(int[] iArr, int i, int i2, int i3) {
        if (i3 > iArr.length) {
            return false;
        }
        while (i2 < i3) {
            if (iArr[i2] > i) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private void MyBillsEntityDataFactory() {
        this.mLastLayoutParamsHashCode = 0;
        Axis axis = this.mHorizontalAxis;
        if (axis != null) {
            axis.PlaceComponentResult();
        }
        Axis axis2 = this.mVerticalAxis;
        if (axis2 != null) {
            axis2.PlaceComponentResult();
        }
        Axis axis3 = this.mHorizontalAxis;
        if (axis3 == null || this.mVerticalAxis == null) {
            return;
        }
        axis3.MyBillsEntityDataFactory();
        this.mVerticalAxis.MyBillsEntityDataFactory();
    }

    final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    static void handleInvalidParams(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(". ");
        throw new IllegalArgumentException(sb.toString());
    }

    private void MyBillsEntityDataFactory(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        Interval interval = (z ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext;
        if (interval.KClassImpl$Data$declaredNonStaticMembers$2 != Integer.MIN_VALUE && interval.KClassImpl$Data$declaredNonStaticMembers$2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" indices must be positive");
            handleInvalidParams(sb.toString());
        }
        int i = (z ? this.mHorizontalAxis : this.mVerticalAxis).getAuthRequestContext;
        if (i != Integer.MIN_VALUE) {
            if (interval.getAuthRequestContext > i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" indices (start + span) mustn't exceed the ");
                sb2.append(str);
                sb2.append(" count");
                handleInvalidParams(sb2.toString());
            }
            if (interval.getAuthRequestContext - interval.KClassImpl$Data$declaredNonStaticMembers$2 > i) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" span mustn't exceed the ");
                sb3.append(str);
                sb3.append(" count");
                handleInvalidParams(sb3.toString());
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            MyBillsEntityDataFactory(layoutParams2, true);
            MyBillsEntityDataFactory(layoutParams2, false);
            return true;
        }
        return false;
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

    private int getAuthRequestContext() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                i = (i * 31) + ((LayoutParams) childAt.getLayoutParams()).hashCode();
            }
        }
        return i;
    }

    private void PlaceComponentResult() {
        while (true) {
            int i = this.mLastLayoutParamsHashCode;
            if (i != 0) {
                if (i == getAuthRequestContext()) {
                    return;
                }
                this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
                MyBillsEntityDataFactory();
            } else {
                boolean z = this.mOrientation == 0;
                Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
                int i2 = axis.getAuthRequestContext != Integer.MIN_VALUE ? axis.getAuthRequestContext : 0;
                int[] iArr = new int[i2];
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                    Spec spec = z ? layoutParams.BuiltInFictitiousFunctionClassFactory : layoutParams.getAuthRequestContext;
                    Interval interval = spec.getAuthRequestContext;
                    boolean z2 = spec.MyBillsEntityDataFactory;
                    int i6 = interval.getAuthRequestContext - interval.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (z2) {
                        i3 = interval.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                    Spec spec2 = z ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory;
                    Interval interval2 = spec2.getAuthRequestContext;
                    boolean z3 = spec2.MyBillsEntityDataFactory;
                    int i7 = interval2.getAuthRequestContext - interval2.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (i2 != 0) {
                        i7 = Math.min(i7, i2 - (z3 ? Math.min(interval2.KClassImpl$Data$declaredNonStaticMembers$2, i2) : 0));
                    }
                    if (z3) {
                        i4 = interval2.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                    if (i2 != 0) {
                        if (!z2 || !z3) {
                            while (true) {
                                int i8 = i4 + i7;
                                if (PlaceComponentResult(iArr, i3, i4, i8)) {
                                    break;
                                } else if (z3) {
                                    i3++;
                                } else if (i8 <= i2) {
                                    i4++;
                                } else {
                                    i3++;
                                    i4 = 0;
                                }
                            }
                        }
                        Arrays.fill(iArr, Math.min(i4, i2), Math.min(i4 + i7, i2), i3 + i6);
                    }
                    if (z) {
                        Interval interval3 = new Interval(i3, i6 + i3);
                        Spec spec3 = layoutParams.BuiltInFictitiousFunctionClassFactory;
                        layoutParams.BuiltInFictitiousFunctionClassFactory = new Spec(spec3.MyBillsEntityDataFactory, interval3, spec3.BuiltInFictitiousFunctionClassFactory, spec3.PlaceComponentResult);
                        Interval interval4 = new Interval(i4, i7 + i4);
                        Spec spec4 = layoutParams.getAuthRequestContext;
                        layoutParams.getAuthRequestContext = new Spec(spec4.MyBillsEntityDataFactory, interval4, spec4.BuiltInFictitiousFunctionClassFactory, spec4.PlaceComponentResult);
                    } else {
                        Interval interval5 = new Interval(i4, i7 + i4);
                        Spec spec5 = layoutParams.BuiltInFictitiousFunctionClassFactory;
                        layoutParams.BuiltInFictitiousFunctionClassFactory = new Spec(spec5.MyBillsEntityDataFactory, interval5, spec5.BuiltInFictitiousFunctionClassFactory, spec5.PlaceComponentResult);
                        Interval interval6 = new Interval(i3, i6 + i3);
                        Spec spec6 = layoutParams.getAuthRequestContext;
                        layoutParams.getAuthRequestContext = new Spec(spec6.MyBillsEntityDataFactory, interval6, spec6.BuiltInFictitiousFunctionClassFactory, spec6.PlaceComponentResult);
                    }
                    i4 += i7;
                }
                this.mLastLayoutParamsHashCode = getAuthRequestContext();
                return;
            }
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(int i, int i2, boolean z) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z) {
                    PlaceComponentResult(childAt, i, i2, layoutParams.width, layoutParams.height);
                } else {
                    boolean z2 = this.mOrientation == 0;
                    Spec spec = z2 ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory;
                    if (spec.PlaceComponentResult(z2) == FILL) {
                        Interval interval = spec.getAuthRequestContext;
                        int[] authRequestContext = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).getAuthRequestContext();
                        int KClassImpl$Data$declaredNonStaticMembers$22 = (authRequestContext[interval.getAuthRequestContext] - authRequestContext[interval.KClassImpl$Data$declaredNonStaticMembers$2]) - (KClassImpl$Data$declaredNonStaticMembers$2(childAt, z2, true) + KClassImpl$Data$declaredNonStaticMembers$2(childAt, z2, false));
                        if (z2) {
                            PlaceComponentResult(childAt, i, i2, KClassImpl$Data$declaredNonStaticMembers$22, layoutParams.height);
                        } else {
                            PlaceComponentResult(childAt, i, i2, layoutParams.width, KClassImpl$Data$declaredNonStaticMembers$22);
                        }
                    }
                }
            }
        }
    }

    static int adjust(int i, int i2) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2 + i), View.MeasureSpec.getMode(i));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int KClassImpl$Data$declaredNonStaticMembers$22;
        int i3;
        PlaceComponentResult();
        Axis axis = this.mHorizontalAxis;
        if (axis != null && this.mVerticalAxis != null) {
            axis.MyBillsEntityDataFactory();
            this.mVerticalAxis.MyBillsEntityDataFactory();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int adjust = adjust(i, -paddingLeft);
        int adjust2 = adjust(i2, -paddingTop);
        BuiltInFictitiousFunctionClassFactory(adjust, adjust2, true);
        if (this.mOrientation == 0) {
            KClassImpl$Data$declaredNonStaticMembers$22 = this.mHorizontalAxis.KClassImpl$Data$declaredNonStaticMembers$2(adjust);
            BuiltInFictitiousFunctionClassFactory(adjust, adjust2, false);
            i3 = this.mVerticalAxis.KClassImpl$Data$declaredNonStaticMembers$2(adjust2);
        } else {
            int KClassImpl$Data$declaredNonStaticMembers$23 = this.mVerticalAxis.KClassImpl$Data$declaredNonStaticMembers$2(adjust2);
            BuiltInFictitiousFunctionClassFactory(adjust, adjust2, false);
            KClassImpl$Data$declaredNonStaticMembers$22 = this.mHorizontalAxis.KClassImpl$Data$declaredNonStaticMembers$2(adjust);
            i3 = KClassImpl$Data$declaredNonStaticMembers$23;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(KClassImpl$Data$declaredNonStaticMembers$22 + paddingLeft, getSuggestedMinimumWidth()), i, 0), View.resolveSizeAndState(Math.max(i3 + paddingTop, getSuggestedMinimumHeight()), i2, 0));
    }

    final int getMeasurementIncludingMargin(View view, boolean z) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return (z ? view.getMeasuredWidth() : view.getMeasuredHeight()) + KClassImpl$Data$declaredNonStaticMembers$2(view, z, true) + KClassImpl$Data$declaredNonStaticMembers$2(view, z, false);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        MyBillsEntityDataFactory();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int[] iArr;
        View view;
        GridLayout gridLayout = this;
        PlaceComponentResult();
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Axis axis = gridLayout.mHorizontalAxis;
        int i6 = (i5 - paddingLeft) - paddingRight;
        axis.newProxyInstance.BuiltInFictitiousFunctionClassFactory = i6;
        axis.NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory = -i6;
        boolean z2 = false;
        axis.isLayoutRequested = false;
        axis.getAuthRequestContext();
        Axis axis2 = gridLayout.mVerticalAxis;
        int i7 = ((i4 - i2) - paddingTop) - paddingBottom;
        axis2.newProxyInstance.BuiltInFictitiousFunctionClassFactory = i7;
        axis2.NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory = -i7;
        axis2.isLayoutRequested = false;
        axis2.getAuthRequestContext();
        int[] authRequestContext = gridLayout.mHorizontalAxis.getAuthRequestContext();
        int[] authRequestContext2 = gridLayout.mVerticalAxis.getAuthRequestContext();
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = gridLayout.getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = gridLayout.getLayoutParams(childAt);
                Spec spec = layoutParams.getAuthRequestContext;
                Spec spec2 = layoutParams.BuiltInFictitiousFunctionClassFactory;
                Interval interval = spec.getAuthRequestContext;
                Interval interval2 = spec2.getAuthRequestContext;
                int i9 = authRequestContext[interval.KClassImpl$Data$declaredNonStaticMembers$2];
                int i10 = authRequestContext2[interval2.KClassImpl$Data$declaredNonStaticMembers$2];
                int i11 = authRequestContext[interval.getAuthRequestContext] - i9;
                int i12 = authRequestContext2[interval2.getAuthRequestContext] - i10;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                Alignment PlaceComponentResult2 = spec.PlaceComponentResult(true);
                Alignment PlaceComponentResult3 = spec2.PlaceComponentResult(z2);
                PackedMap<Spec, Bounds> BuiltInFictitiousFunctionClassFactory2 = gridLayout.mHorizontalAxis.BuiltInFictitiousFunctionClassFactory();
                Bounds bounds = BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2[i8]];
                PackedMap<Spec, Bounds> BuiltInFictitiousFunctionClassFactory3 = gridLayout.mVerticalAxis.BuiltInFictitiousFunctionClassFactory();
                Bounds bounds2 = BuiltInFictitiousFunctionClassFactory3.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2[i8]];
                iArr = authRequestContext;
                int PlaceComponentResult4 = PlaceComponentResult2.PlaceComponentResult(childAt, i11 - bounds.BuiltInFictitiousFunctionClassFactory(true));
                int PlaceComponentResult5 = PlaceComponentResult3.PlaceComponentResult(childAt, i12 - bounds2.BuiltInFictitiousFunctionClassFactory(true));
                int KClassImpl$Data$declaredNonStaticMembers$22 = gridLayout.KClassImpl$Data$declaredNonStaticMembers$2(childAt, true, true);
                int KClassImpl$Data$declaredNonStaticMembers$23 = gridLayout.KClassImpl$Data$declaredNonStaticMembers$2(childAt, false, true);
                int KClassImpl$Data$declaredNonStaticMembers$24 = gridLayout.KClassImpl$Data$declaredNonStaticMembers$2(childAt, true, false);
                int i13 = KClassImpl$Data$declaredNonStaticMembers$22 + KClassImpl$Data$declaredNonStaticMembers$24;
                int KClassImpl$Data$declaredNonStaticMembers$25 = KClassImpl$Data$declaredNonStaticMembers$23 + gridLayout.KClassImpl$Data$declaredNonStaticMembers$2(childAt, false, false);
                int MyBillsEntityDataFactory2 = bounds.MyBillsEntityDataFactory(this, childAt, PlaceComponentResult2, measuredWidth + i13, true);
                int MyBillsEntityDataFactory3 = bounds2.MyBillsEntityDataFactory(this, childAt, PlaceComponentResult3, measuredHeight + KClassImpl$Data$declaredNonStaticMembers$25, false);
                int MyBillsEntityDataFactory4 = PlaceComponentResult2.MyBillsEntityDataFactory(measuredWidth, i11 - i13);
                int MyBillsEntityDataFactory5 = PlaceComponentResult3.MyBillsEntityDataFactory(measuredHeight, i12 - KClassImpl$Data$declaredNonStaticMembers$25);
                int i14 = i9 + PlaceComponentResult4 + MyBillsEntityDataFactory2;
                int i15 = !KClassImpl$Data$declaredNonStaticMembers$2() ? paddingLeft + KClassImpl$Data$declaredNonStaticMembers$22 + i14 : (((i5 - MyBillsEntityDataFactory4) - paddingRight) - KClassImpl$Data$declaredNonStaticMembers$24) - i14;
                int i16 = paddingTop + i10 + PlaceComponentResult5 + MyBillsEntityDataFactory3 + KClassImpl$Data$declaredNonStaticMembers$23;
                if (MyBillsEntityDataFactory4 == childAt.getMeasuredWidth() && MyBillsEntityDataFactory5 == childAt.getMeasuredHeight()) {
                    view = childAt;
                } else {
                    view = childAt;
                    view.measure(View.MeasureSpec.makeMeasureSpec(MyBillsEntityDataFactory4, 1073741824), View.MeasureSpec.makeMeasureSpec(MyBillsEntityDataFactory5, 1073741824));
                }
                view.layout(i15, i16, MyBillsEntityDataFactory4 + i15, MyBillsEntityDataFactory5 + i16);
            } else {
                iArr = authRequestContext;
            }
            i8++;
            z2 = false;
            gridLayout = this;
            authRequestContext = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class Axis {
        public final boolean DatabaseTableConfigUtil;
        public boolean GetContactSyncConfig;
        public Arc[] KClassImpl$Data$declaredNonStaticMembers$2;
        public int[] NetworkUserEntityData$$ExternalSyntheticLambda1;
        public int[] NetworkUserEntityData$$ExternalSyntheticLambda5;
        public int[] NetworkUserEntityData$$ExternalSyntheticLambda7;
        PackedMap<Interval, MutableInt> PlaceComponentResult;
        public int[] lookAheadTest;
        PackedMap<Spec, Bounds> moveToNextValue;
        PackedMap<Interval, MutableInt> scheduleImpl;
        public int getAuthRequestContext = Integer.MIN_VALUE;
        private int NetworkUserEntityData$$ExternalSyntheticLambda4 = Integer.MIN_VALUE;
        public boolean getErrorConfigVersion = false;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        public boolean BuiltInFictitiousFunctionClassFactory = false;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
        public boolean MyBillsEntityDataFactory = false;
        public boolean isLayoutRequested = false;
        public boolean initRecordTimeStamp = false;
        boolean PrepareContext = true;
        MutableInt newProxyInstance = new MutableInt(0);
        MutableInt NetworkUserEntityData$$ExternalSyntheticLambda8 = new MutableInt(-100000);

        Axis(boolean z) {
            this.DatabaseTableConfigUtil = z;
        }

        final int KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 == Integer.MIN_VALUE) {
                int childCount = GridLayout.this.getChildCount();
                int i = -1;
                for (int i2 = 0; i2 < childCount; i2++) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                    Interval interval = (this.DatabaseTableConfigUtil ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext;
                    i = Math.max(Math.max(Math.max(i, interval.KClassImpl$Data$declaredNonStaticMembers$2), interval.getAuthRequestContext), interval.getAuthRequestContext - interval.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Math.max(0, i != -1 ? i : Integer.MIN_VALUE);
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }

        public final void BuiltInFictitiousFunctionClassFactory(int i) {
            if (i != Integer.MIN_VALUE && i < KClassImpl$Data$declaredNonStaticMembers$2()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.DatabaseTableConfigUtil ? "column" : "row");
                sb.append("Count must be greater than or equal to the maximum of all grid indices ");
                sb.append("(and spans) defined in the LayoutParams of each child");
                GridLayout.handleInvalidParams(sb.toString());
            }
            this.getAuthRequestContext = i;
        }

        public final boolean lookAheadTest() {
            return this.PrepareContext;
        }

        private PackedMap<Spec, Bounds> getErrorConfigVersion() {
            Assoc of = Assoc.of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                Spec spec = this.DatabaseTableConfigUtil ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory;
                of.put(spec, spec.PlaceComponentResult(this.DatabaseTableConfigUtil).BuiltInFictitiousFunctionClassFactory());
            }
            return of.pack();
        }

        private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
            int i;
            for (Bounds bounds : this.moveToNextValue.PlaceComponentResult) {
                bounds.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                Spec spec = this.DatabaseTableConfigUtil ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory;
                int measurementIncludingMargin = GridLayout.this.getMeasurementIncludingMargin(childAt, this.DatabaseTableConfigUtil);
                if (spec.PlaceComponentResult == 0.0f) {
                    i = 0;
                } else {
                    if (this.lookAheadTest == null) {
                        this.lookAheadTest = new int[GridLayout.this.getChildCount()];
                    }
                    i = this.lookAheadTest[i2];
                }
                PackedMap<Spec, Bounds> packedMap = this.moveToNextValue;
                packedMap.PlaceComponentResult[packedMap.KClassImpl$Data$declaredNonStaticMembers$2[i2]].getAuthRequestContext(GridLayout.this, childAt, spec, this, measurementIncludingMargin + i);
            }
        }

        public final PackedMap<Spec, Bounds> BuiltInFictitiousFunctionClassFactory() {
            if (this.moveToNextValue == null) {
                this.moveToNextValue = getErrorConfigVersion();
            }
            if (!this.getErrorConfigVersion) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
                this.getErrorConfigVersion = true;
            }
            return this.moveToNextValue;
        }

        private PackedMap<Interval, MutableInt> PlaceComponentResult(boolean z) {
            Interval interval;
            Assoc of = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory;
            int length = specArr.length;
            for (int i = 0; i < length; i++) {
                if (z) {
                    interval = specArr[i].getAuthRequestContext;
                } else {
                    Interval interval2 = specArr[i].getAuthRequestContext;
                    interval = new Interval(interval2.getAuthRequestContext, interval2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                of.put(interval, new MutableInt());
            }
            return of.pack();
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(PackedMap<Interval, MutableInt> packedMap, boolean z) {
            for (MutableInt mutableInt : packedMap.PlaceComponentResult) {
                mutableInt.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
            }
            Bounds[] boundsArr = BuiltInFictitiousFunctionClassFactory().PlaceComponentResult;
            for (int i = 0; i < boundsArr.length; i++) {
                int BuiltInFictitiousFunctionClassFactory = boundsArr[i].BuiltInFictitiousFunctionClassFactory(z);
                MutableInt mutableInt2 = packedMap.PlaceComponentResult[packedMap.KClassImpl$Data$declaredNonStaticMembers$2[i]];
                int i2 = mutableInt2.BuiltInFictitiousFunctionClassFactory;
                if (!z) {
                    BuiltInFictitiousFunctionClassFactory = -BuiltInFictitiousFunctionClassFactory;
                }
                mutableInt2.BuiltInFictitiousFunctionClassFactory = Math.max(i2, BuiltInFictitiousFunctionClassFactory);
            }
        }

        private PackedMap<Interval, MutableInt> DatabaseTableConfigUtil() {
            if (this.scheduleImpl == null) {
                this.scheduleImpl = PlaceComponentResult(true);
            }
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, true);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
            return this.scheduleImpl;
        }

        private PackedMap<Interval, MutableInt> initRecordTimeStamp() {
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = PlaceComponentResult(false);
            }
            if (!this.BuiltInFictitiousFunctionClassFactory) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, false);
                this.BuiltInFictitiousFunctionClassFactory = true;
            }
            return this.PlaceComponentResult;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.gridlayout.widget.GridLayout$Axis$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 {
            Arc[] BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ Arc[] MyBillsEntityDataFactory;
            Arc[][] PlaceComponentResult;
            int getAuthRequestContext;
            int[] getErrorConfigVersion;

            AnonymousClass1(Arc[] arcArr) {
                this.MyBillsEntityDataFactory = arcArr;
                int length = arcArr.length;
                this.BuiltInFictitiousFunctionClassFactory = new Arc[length];
                this.getAuthRequestContext = length - 1;
                int max = Math.max(Axis.this.getAuthRequestContext, Axis.this.KClassImpl$Data$declaredNonStaticMembers$2()) + 1;
                Arc[][] arcArr2 = new Arc[max];
                int[] iArr = new int[max];
                for (Arc arc : arcArr) {
                    int i = arc.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    iArr[i] = iArr[i] + 1;
                }
                for (int i2 = 0; i2 < max; i2++) {
                    arcArr2[i2] = new Arc[iArr[i2]];
                }
                Arrays.fill(iArr, 0);
                for (Arc arc2 : arcArr) {
                    int i3 = arc2.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    Arc[] arcArr3 = arcArr2[i3];
                    int i4 = iArr[i3];
                    iArr[i3] = i4 + 1;
                    arcArr3[i4] = arc2;
                }
                this.PlaceComponentResult = arcArr2;
                this.getErrorConfigVersion = new int[Math.max(Axis.this.getAuthRequestContext, Axis.this.KClassImpl$Data$declaredNonStaticMembers$2()) + 1];
            }

            final void PlaceComponentResult(int i) {
                int[] iArr = this.getErrorConfigVersion;
                if (iArr[i] == 0) {
                    iArr[i] = 1;
                    for (Arc arc : this.PlaceComponentResult[i]) {
                        PlaceComponentResult(arc.MyBillsEntityDataFactory.getAuthRequestContext);
                        Arc[] arcArr = this.BuiltInFictitiousFunctionClassFactory;
                        int i2 = this.getAuthRequestContext;
                        this.getAuthRequestContext = i2 - 1;
                        arcArr[i2] = arc;
                    }
                    this.getErrorConfigVersion[i] = 2;
                }
            }
        }

        private static void KClassImpl$Data$declaredNonStaticMembers$2(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            for (int i = 0; i < packedMap.MyBillsEntityDataFactory.length; i++) {
                KClassImpl$Data$declaredNonStaticMembers$2(list, packedMap.MyBillsEntityDataFactory[i], packedMap.PlaceComponentResult[i], false);
            }
        }

        private Arc[] scheduleImpl() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            KClassImpl$Data$declaredNonStaticMembers$2(arrayList, DatabaseTableConfigUtil());
            KClassImpl$Data$declaredNonStaticMembers$2(arrayList2, initRecordTimeStamp());
            if (this.PrepareContext) {
                int i = 0;
                while (i < Math.max(this.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2())) {
                    int i2 = i + 1;
                    KClassImpl$Data$declaredNonStaticMembers$2(arrayList, new Interval(i, i2), new MutableInt(0), true);
                    i = i2;
                }
            }
            int max = Math.max(this.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2());
            KClassImpl$Data$declaredNonStaticMembers$2(arrayList, new Interval(0, max), this.newProxyInstance, false);
            KClassImpl$Data$declaredNonStaticMembers$2(arrayList2, new Interval(max, 0), this.NetworkUserEntityData$$ExternalSyntheticLambda8, false);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((Arc[]) arrayList.toArray(new Arc[arrayList.size()]));
            int length = anonymousClass1.PlaceComponentResult.length;
            for (int i3 = 0; i3 < length; i3++) {
                anonymousClass1.PlaceComponentResult(i3);
            }
            Arc[] arcArr = anonymousClass1.BuiltInFictitiousFunctionClassFactory;
            AnonymousClass1 anonymousClass12 = new AnonymousClass1((Arc[]) arrayList2.toArray(new Arc[arrayList2.size()]));
            int length2 = anonymousClass12.PlaceComponentResult.length;
            for (int i4 = 0; i4 < length2; i4++) {
                anonymousClass12.PlaceComponentResult(i4);
            }
            return (Arc[]) GridLayout.append(arcArr, anonymousClass12.BuiltInFictitiousFunctionClassFactory);
        }

        private Arc[] GetContactSyncConfig() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = scheduleImpl();
            }
            if (!this.MyBillsEntityDataFactory) {
                DatabaseTableConfigUtil();
                initRecordTimeStamp();
                this.MyBillsEntityDataFactory = true;
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr, Arc arc) {
            if (arc.getAuthRequestContext) {
                Interval interval = arc.MyBillsEntityDataFactory;
                int i = interval.KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = interval.getAuthRequestContext;
                int i3 = iArr[i] + arc.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                if (i3 > iArr[i2]) {
                    iArr[i2] = i3;
                    return true;
                }
                return false;
            }
            return false;
        }

        private String KClassImpl$Data$declaredNonStaticMembers$2(List<Arc> list) {
            StringBuilder sb;
            String str = this.DatabaseTableConfigUtil ? "x" : "y";
            StringBuilder sb2 = new StringBuilder();
            boolean z = true;
            for (Arc arc : list) {
                if (z) {
                    z = false;
                } else {
                    sb2.append(", ");
                }
                int i = arc.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = arc.MyBillsEntityDataFactory.getAuthRequestContext;
                int i3 = arc.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                if (i < i2) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i2);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i);
                    sb.append(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION);
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i2);
                    sb.append(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION);
                    i3 = -i3;
                }
                sb.append(i3);
                sb2.append(sb.toString());
            }
            return sb2.toString();
        }

        private boolean BuiltInFictitiousFunctionClassFactory(Arc[] arcArr, int[] iArr) {
            return BuiltInFictitiousFunctionClassFactory(arcArr, iArr, true);
        }

        private boolean BuiltInFictitiousFunctionClassFactory(Arc[] arcArr, int[] iArr, boolean z) {
            String str = this.DatabaseTableConfigUtil ? BoxData.LAYOUT_HORIZONTAL : BoxData.LAYOUT_VERTICAL;
            int max = Math.max(this.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2()) + 1;
            boolean[] zArr = null;
            for (int i = 0; i < arcArr.length; i++) {
                Arrays.fill(iArr, 0);
                for (int i2 = 0; i2 < max; i2++) {
                    boolean z2 = false;
                    for (Arc arc : arcArr) {
                        z2 |= KClassImpl$Data$declaredNonStaticMembers$2(iArr, arc);
                    }
                    if (!z2) {
                        if (zArr != null) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            for (int i3 = 0; i3 < arcArr.length; i3++) {
                                Arc arc2 = arcArr[i3];
                                if (zArr[i3]) {
                                    arrayList.add(arc2);
                                }
                                if (!arc2.getAuthRequestContext) {
                                    arrayList2.add(arc2);
                                }
                            }
                            Printer printer = GridLayout.this.mPrinter;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(" constraints: ");
                            sb.append(KClassImpl$Data$declaredNonStaticMembers$2(arrayList));
                            sb.append(" are inconsistent; permanently removing: ");
                            sb.append(KClassImpl$Data$declaredNonStaticMembers$2(arrayList2));
                            sb.append(". ");
                            printer.println(sb.toString());
                        }
                        return true;
                    }
                }
                if (!z) {
                    return false;
                }
                boolean[] zArr2 = new boolean[arcArr.length];
                for (int i4 = 0; i4 < max; i4++) {
                    int length = arcArr.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        zArr2[i5] = zArr2[i5] | KClassImpl$Data$declaredNonStaticMembers$2(iArr, arcArr[i5]);
                    }
                }
                if (i == 0) {
                    zArr = zArr2;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= arcArr.length) {
                        break;
                    }
                    if (zArr2[i6]) {
                        Arc arc3 = arcArr[i6];
                        if (arc3.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 >= arc3.MyBillsEntityDataFactory.getAuthRequestContext) {
                            arc3.getAuthRequestContext = false;
                            break;
                        }
                    }
                    i6++;
                }
            }
            return true;
        }

        final void BuiltInFictitiousFunctionClassFactory(boolean z) {
            int[] iArr = z ? this.NetworkUserEntityData$$ExternalSyntheticLambda1 : this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    Interval interval = (this.DatabaseTableConfigUtil ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext;
                    int i2 = z ? interval.KClassImpl$Data$declaredNonStaticMembers$2 : interval.getAuthRequestContext;
                    iArr[i2] = Math.max(iArr[i2], GridLayout.this.getMargin1(childAt, this.DatabaseTableConfigUtil, z));
                }
            }
        }

        private boolean getAuthRequestContext(int[] iArr) {
            return BuiltInFictitiousFunctionClassFactory(GetContactSyncConfig(), iArr);
        }

        private boolean moveToNextValue() {
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    if ((this.DatabaseTableConfigUtil ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
            if (!this.initRecordTimeStamp) {
                this.GetContactSyncConfig = moveToNextValue();
                this.initRecordTimeStamp = true;
            }
            return this.GetContactSyncConfig;
        }

        private void PlaceComponentResult(int i, float f) {
            Arrays.fill(this.lookAheadTest, 0);
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    float f2 = (this.DatabaseTableConfigUtil ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult;
                    if (f2 != 0.0f) {
                        int round = Math.round((i * f2) / f);
                        this.lookAheadTest[i2] = round;
                        i -= round;
                        f -= f2;
                    }
                }
            }
        }

        private void MyBillsEntityDataFactory(int[] iArr) {
            if (!NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                getAuthRequestContext(iArr);
            } else {
                if (this.lookAheadTest == null) {
                    this.lookAheadTest = new int[GridLayout.this.getChildCount()];
                }
                Arrays.fill(this.lookAheadTest, 0);
                getAuthRequestContext(iArr);
                boolean z = true;
                int childCount = (this.newProxyInstance.BuiltInFictitiousFunctionClassFactory * GridLayout.this.getChildCount()) + 1;
                if (childCount >= 2) {
                    int childCount2 = GridLayout.this.getChildCount();
                    float f = 0.0f;
                    for (int i = 0; i < childCount2; i++) {
                        View childAt = GridLayout.this.getChildAt(i);
                        if (childAt.getVisibility() != 8) {
                            LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                            f += (this.DatabaseTableConfigUtil ? layoutParams.getAuthRequestContext : layoutParams.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult;
                        }
                    }
                    int i2 = -1;
                    int i3 = 0;
                    while (i3 < childCount) {
                        int i4 = (int) ((i3 + childCount) / 2);
                        MyBillsEntityDataFactory();
                        PlaceComponentResult(i4, f);
                        boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(GetContactSyncConfig(), iArr, false);
                        if (BuiltInFictitiousFunctionClassFactory) {
                            i3 = i4 + 1;
                            i2 = i4;
                        } else {
                            childCount = i4;
                        }
                        z = BuiltInFictitiousFunctionClassFactory;
                    }
                    if (i2 > 0 && !z) {
                        MyBillsEntityDataFactory();
                        PlaceComponentResult(i2, f);
                        getAuthRequestContext(iArr);
                    }
                }
            }
            if (this.PrepareContext) {
                return;
            }
            int i5 = iArr[0];
            int length = iArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = iArr[i6] - i5;
            }
        }

        public final int[] getAuthRequestContext() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new int[Math.max(this.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2()) + 1];
            }
            if (!this.isLayoutRequested) {
                MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                this.isLayoutRequested = true;
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }

        public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode != 1073741824) {
                        return 0;
                    }
                    return BuiltInFictitiousFunctionClassFactory(size, size);
                }
                return BuiltInFictitiousFunctionClassFactory(0, 100000);
            }
            return BuiltInFictitiousFunctionClassFactory(0, size);
        }

        public final void PlaceComponentResult() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Integer.MIN_VALUE;
            this.moveToNextValue = null;
            this.scheduleImpl = null;
            this.PlaceComponentResult = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
            this.lookAheadTest = null;
            this.initRecordTimeStamp = false;
            MyBillsEntityDataFactory();
        }

        public final void MyBillsEntityDataFactory() {
            this.getErrorConfigVersion = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            this.BuiltInFictitiousFunctionClassFactory = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
            this.MyBillsEntityDataFactory = false;
            this.isLayoutRequested = false;
        }

        private int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            this.newProxyInstance.BuiltInFictitiousFunctionClassFactory = i;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory = -i2;
            this.isLayoutRequested = false;
            return getAuthRequestContext()[Math.max(this.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2())];
        }

        private static void KClassImpl$Data$declaredNonStaticMembers$2(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z) {
            if (interval.getAuthRequestContext - interval.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                return;
            }
            if (z) {
                Iterator<Arc> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().MyBillsEntityDataFactory.equals(interval)) {
                        return;
                    }
                }
            }
            list.add(new Arc(interval, mutableInt));
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int DatabaseTableConfigUtil;
        private static final int GetContactSyncConfig;
        private static final int KClassImpl$Data$declaredNonStaticMembers$2;
        private static final int MyBillsEntityDataFactory;
        private static final int NetworkUserEntityData$$ExternalSyntheticLambda0;
        private static final int NetworkUserEntityData$$ExternalSyntheticLambda1;
        private static final int NetworkUserEntityData$$ExternalSyntheticLambda2;
        private static final int NetworkUserEntityData$$ExternalSyntheticLambda8;
        private static final int PlaceComponentResult;
        private static final int getErrorConfigVersion;
        private static final int initRecordTimeStamp;
        private static final int lookAheadTest;
        private static final Interval moveToNextValue;
        private static final int scheduleImpl;
        public Spec BuiltInFictitiousFunctionClassFactory;
        public Spec getAuthRequestContext;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, -2147483647);
            moveToNextValue = interval;
            lookAheadTest = interval.getAuthRequestContext - interval.KClassImpl$Data$declaredNonStaticMembers$2;
            GetContactSyncConfig = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0;
            scheduleImpl = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1;
            DatabaseTableConfigUtil = R.styleable.GetContactSyncConfig;
            PlaceComponentResult = R.styleable.DatabaseTableConfigUtil;
            MyBillsEntityDataFactory = R.styleable.initRecordTimeStamp;
            KClassImpl$Data$declaredNonStaticMembers$2 = R.styleable.newProxyInstance;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = R.styleable.PrepareContext;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = R.styleable.isLayoutRequested;
            initRecordTimeStamp = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6;
            getErrorConfigVersion = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }

        private LayoutParams(Spec spec, Spec spec2, byte b) {
            super(-2, -2);
            this.BuiltInFictitiousFunctionClassFactory = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            setMargins(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.BuiltInFictitiousFunctionClassFactory = spec;
            this.getAuthRequestContext = spec2;
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(spec, spec2, (byte) 0);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LayoutParams() {
            /*
                r1 = this;
                androidx.gridlayout.widget.GridLayout$Spec r0 = androidx.gridlayout.widget.GridLayout.Spec.KClassImpl$Data$declaredNonStaticMembers$2
                r1.<init>(r0, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.gridlayout.widget.GridLayout.LayoutParams.<init>():void");
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.BuiltInFictitiousFunctionClassFactory = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.BuiltInFictitiousFunctionClassFactory = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.BuiltInFictitiousFunctionClassFactory = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            this.BuiltInFictitiousFunctionClassFactory = layoutParams.BuiltInFictitiousFunctionClassFactory;
            this.getAuthRequestContext = layoutParams.getAuthRequestContext;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.BuiltInFictitiousFunctionClassFactory = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = Spec.KClassImpl$Data$declaredNonStaticMembers$2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.getErrorConfigVersion);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(GetContactSyncConfig, Integer.MIN_VALUE);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(scheduleImpl, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(NetworkUserEntityData$$ExternalSyntheticLambda8, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(DatabaseTableConfigUtil, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(PlaceComponentResult, dimensionPixelSize);
                obtainStyledAttributes.recycle();
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.getErrorConfigVersion);
                try {
                    int i = obtainStyledAttributes.getInt(getErrorConfigVersion, 0);
                    int i2 = obtainStyledAttributes.getInt(MyBillsEntityDataFactory, Integer.MIN_VALUE);
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2;
                    int i4 = lookAheadTest;
                    this.getAuthRequestContext = GridLayout.spec(i2, obtainStyledAttributes.getInt(i3, i4), GridLayout.getAlignment(i, true), obtainStyledAttributes.getFloat(NetworkUserEntityData$$ExternalSyntheticLambda0, 0.0f));
                    this.BuiltInFictitiousFunctionClassFactory = GridLayout.spec(obtainStyledAttributes.getInt(NetworkUserEntityData$$ExternalSyntheticLambda1, Integer.MIN_VALUE), obtainStyledAttributes.getInt(NetworkUserEntityData$$ExternalSyntheticLambda2, i4), GridLayout.getAlignment(i, false), obtainStyledAttributes.getFloat(initRecordTimeStamp, 0.0f));
                } finally {
                }
            } finally {
            }
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, -2);
            this.height = typedArray.getLayoutDimension(i2, -2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            return this.getAuthRequestContext.equals(layoutParams.getAuthRequestContext) && this.BuiltInFictitiousFunctionClassFactory.equals(layoutParams.BuiltInFictitiousFunctionClassFactory);
        }

        public int hashCode() {
            return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.getAuthRequestContext.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Arc {
        public final MutableInt BuiltInFictitiousFunctionClassFactory;
        public final Interval MyBillsEntityDataFactory;
        public boolean getAuthRequestContext = true;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.MyBillsEntityDataFactory = interval;
            this.BuiltInFictitiousFunctionClassFactory = mutableInt;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(" ");
            sb.append(!this.getAuthRequestContext ? "+>" : "->");
            sb.append(" ");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class MutableInt {
        public int BuiltInFictitiousFunctionClassFactory;

        public MutableInt() {
            this.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
        }

        public MutableInt(int i) {
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        public final String toString() {
            return Integer.toString(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> of(Class<K> cls, Class<V> cls2) {
            return new Assoc<>(cls, cls2);
        }

        public final void put(K k, V v) {
            add(Pair.create(k, v));
        }

        public final PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.valueType, size);
            for (int i = 0; i < size; i++) {
                objArr[i] = get(i).first;
                objArr2[i] = get(i).second;
            }
            return new PackedMap<>(objArr, objArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PackedMap<K, V> {
        public final int[] KClassImpl$Data$declaredNonStaticMembers$2;
        public final K[] MyBillsEntityDataFactory;
        public final V[] PlaceComponentResult;

        PackedMap(K[] kArr, V[] vArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap hashMap = new HashMap();
            for (int i = 0; i < length; i++) {
                K k = kArr[i];
                Integer num = (Integer) hashMap.get(k);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(k, num);
                }
                iArr[i] = num.intValue();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            this.MyBillsEntityDataFactory = (K[]) BuiltInFictitiousFunctionClassFactory(kArr, iArr);
            this.PlaceComponentResult = (V[]) BuiltInFictitiousFunctionClassFactory(vArr, iArr);
        }

        private static <K> K[] BuiltInFictitiousFunctionClassFactory(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1));
            for (int i = 0; i < length; i++) {
                kArr2[iArr[i]] = kArr[i];
            }
            return kArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Bounds {
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int PlaceComponentResult;

        Bounds() {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }

        protected void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MIN_VALUE;
            this.PlaceComponentResult = Integer.MIN_VALUE;
            this.MyBillsEntityDataFactory = 2;
        }

        protected void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
            this.PlaceComponentResult = Math.max(this.PlaceComponentResult, i2);
        }

        protected int BuiltInFictitiousFunctionClassFactory(boolean z) {
            if (z || !GridLayout.canStretch(this.MyBillsEntityDataFactory)) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2 + this.PlaceComponentResult;
            }
            return 100000;
        }

        protected int MyBillsEntityDataFactory(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 - alignment.getAuthRequestContext(view, i, ViewGroupCompat.PlaceComponentResult(gridLayout));
        }

        protected final void getAuthRequestContext(GridLayout gridLayout, View view, Spec spec, Axis axis, int i) {
            this.MyBillsEntityDataFactory &= (spec.BuiltInFictitiousFunctionClassFactory == GridLayout.UNDEFINED_ALIGNMENT && spec.PlaceComponentResult == 0.0f) ? 0 : 2;
            int authRequestContext = spec.PlaceComponentResult(axis.DatabaseTableConfigUtil).getAuthRequestContext(view, i, ViewGroupCompat.PlaceComponentResult(gridLayout));
            BuiltInFictitiousFunctionClassFactory(authRequestContext, i - authRequestContext);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Bounds{before=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", after=");
            sb.append(this.PlaceComponentResult);
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Interval {
        public final int KClassImpl$Data$declaredNonStaticMembers$2;
        public final int getAuthRequestContext;

        public Interval(int i, int i2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.getAuthRequestContext = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.getAuthRequestContext == interval.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2 == interval.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public final int hashCode() {
            return (this.KClassImpl$Data$declaredNonStaticMembers$2 * 31) + this.getAuthRequestContext;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", ");
            sb.append(this.getAuthRequestContext);
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class Spec {
        static final Spec KClassImpl$Data$declaredNonStaticMembers$2 = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment BuiltInFictitiousFunctionClassFactory;
        final boolean MyBillsEntityDataFactory;
        final float PlaceComponentResult;
        final Interval getAuthRequestContext;

        Spec(boolean z, Interval interval, Alignment alignment, float f) {
            this.MyBillsEntityDataFactory = z;
            this.getAuthRequestContext = interval;
            this.BuiltInFictitiousFunctionClassFactory = alignment;
            this.PlaceComponentResult = f;
        }

        Spec(boolean z, int i, int i2, Alignment alignment, float f) {
            this(z, new Interval(i, i2 + i), alignment, f);
        }

        public final Alignment PlaceComponentResult(boolean z) {
            if (this.BuiltInFictitiousFunctionClassFactory != GridLayout.UNDEFINED_ALIGNMENT) {
                return this.BuiltInFictitiousFunctionClassFactory;
            }
            if (this.PlaceComponentResult == 0.0f) {
                return z ? GridLayout.START : GridLayout.BASELINE;
            }
            return GridLayout.FILL;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Spec spec = (Spec) obj;
            return this.BuiltInFictitiousFunctionClassFactory.equals(spec.BuiltInFictitiousFunctionClassFactory) && this.getAuthRequestContext.equals(spec.getAuthRequestContext);
        }

        public int hashCode() {
            return (this.getAuthRequestContext.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }
    }

    public static Spec spec(int i, int i2, Alignment alignment, float f) {
        return new Spec(i != Integer.MIN_VALUE, i, i2, alignment, f);
    }

    public static Spec spec(int i, Alignment alignment, float f) {
        return spec(i, 1, alignment, f);
    }

    public static Spec spec(int i, int i2, float f) {
        return spec(i, i2, UNDEFINED_ALIGNMENT, f);
    }

    public static Spec spec(int i, float f) {
        return spec(i, 1, f);
    }

    public static Spec spec(int i, int i2, Alignment alignment) {
        return spec(i, i2, alignment, 0.0f);
    }

    public static Spec spec(int i, Alignment alignment) {
        return spec(i, 1, alignment);
    }

    public static Spec spec(int i, int i2) {
        return spec(i, i2, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i) {
        return spec(i, 1);
    }

    /* loaded from: classes3.dex */
    public static abstract class Alignment {
        int MyBillsEntityDataFactory(int i, int i2) {
            return i;
        }

        abstract String MyBillsEntityDataFactory();

        abstract int PlaceComponentResult(View view, int i);

        abstract int getAuthRequestContext(View view, int i, int i2);

        Alignment() {
        }

        Bounds BuiltInFictitiousFunctionClassFactory() {
            return new Bounds();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Alignment:");
            sb.append(MyBillsEntityDataFactory());
            return sb.toString();
        }
    }

    private void PlaceComponentResult(View view, int i, int i2, int i3, int i4) {
        view.measure(getChildMeasureSpec(i, KClassImpl$Data$declaredNonStaticMembers$2(view, true, true) + KClassImpl$Data$declaredNonStaticMembers$2(view, true, false), i3), getChildMeasureSpec(i2, KClassImpl$Data$declaredNonStaticMembers$2(view, false, true) + KClassImpl$Data$declaredNonStaticMembers$2(view, false, false), i4));
    }
}
