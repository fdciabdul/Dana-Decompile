package com.alibaba.griver.ui.ant.basic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.R;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class AUHorizontalListView extends AdapterView implements ViewTreeObserver.OnTouchModeChangeListener, FSDraw, FSDispatchDraw {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {116, -27, -60, 115, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int MyBillsEntityDataFactory = 114;
    public static final int[] STATE_NOTHING = {0};
    private float A;
    private int B;
    private Rect C;
    private int D;
    private CheckForTap E;
    private CheckForLongPress F;
    private CheckForKeyLongPress G;
    private PerformClick H;
    private Runnable I;
    private int J;
    private boolean K;
    private boolean L;
    private Drawable M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private SelectionNotifier R;
    private boolean S;
    private int T;
    private int U;
    private long V;
    private long W;

    /* renamed from: a  reason: collision with root package name */
    private final RecycleBin f6661a;
    private int aa;
    private int ab;
    private long ac;
    private int ad;
    private long ae;
    private int af;
    private long ag;
    private ChoiceMode ah;
    private int ai;
    private SparseBooleanArray aj;
    private ContextMenu.ContextMenuInfo ak;
    private int al;
    private int am;
    private int an;
    private VelocityTracker ao;
    private EdgeEffectCompat ap;
    private EdgeEffectCompat aq;
    private OnScrollListener ar;
    private int as;

    /* renamed from: at  reason: collision with root package name */
    private View f6662at;
    private ListItemAccessibilityDelegate au;
    private int av;
    private int aw;
    private final int b;
    private final int c;
    private final int d;
    private final Rect e;
    private final ArrowScrollFocusResult f;
    private final Rect g;
    private final int h;
    private final Scroller i;
    private ListAdapter j;
    private boolean k;
    private int l;
    private boolean m;
    LongSparseArray<Integer> mCheckedIdStates;
    final boolean[] mIsScrap;
    private boolean n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6663o;
    private AdapterDataSetObserver p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private SavedState y;
    private float z;

    /* loaded from: classes6.dex */
    public enum ChoiceMode {
        NONE,
        SINGLE,
        MULTIPLE
    }

    /* loaded from: classes6.dex */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScroll(AUHorizontalListView aUHorizontalListView, int i, int i2, int i3);

        void onScrollStateChanged(AUHorizontalListView aUHorizontalListView, int i);
    }

    /* loaded from: classes6.dex */
    public interface RecyclerListener {
        void onMovedToScrapHeap(View view);
    }

    public static Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(TypedArray typedArray, int i) {
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        byte b = (byte) (bArr[8] - 1);
        byte b2 = bArr[41];
        Object[] objArr = new Object[1];
        ax(b, b2, (byte) (b2 + 1), objArr);
        return Class.forName((String) objArr[0]).isInstance(typedArray) ? InstrumentInjector.Resources_getDrawable((Context) typedArray, i) : typedArray.getDrawable(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ax(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 22
            int r7 = r7 + 4
            int r8 = r8 * 5
            int r8 = r8 + 18
            byte[] r0 = com.alibaba.griver.ui.ant.basic.AUHorizontalListView.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 * 6
            int r6 = 103 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L33:
            int r7 = r7 + 1
            int r6 = r6 + r8
            int r6 = r6 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.ax(short, byte, int, java.lang.Object[]):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_74224bc0ea6e2c3a69a8fa1f5b54019e(canvas, view, j);
    }

    public void fsSuperDispatchDraw_74224bc0ea6e2c3a69a8fa1f5b54019e(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_74224bc0ea6e2c3a69a8fa1f5b54019e(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public void fsSuperDraw_74224bc0ea6e2c3a69a8fa1f5b54019e(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    protected boolean recycleOnMeasure() {
        return true;
    }

    public AUHorizontalListView(Context context) {
        this(context, null);
    }

    public AUHorizontalListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AUHorizontalListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsScrap = new boolean[1];
        this.S = false;
        this.ao = null;
        this.al = 0;
        this.am = -1;
        this.an = -1;
        this.f6663o = false;
        this.ak = null;
        this.ar = null;
        this.as = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = a(viewConfiguration);
        this.O = 0;
        this.i = new Scroller(context);
        this.k = true;
        this.q = false;
        this.e = new Rect();
        this.f = new ArrowScrollFocusResult();
        this.N = -1;
        this.g = new Rect();
        this.J = -1;
        this.aa = 0;
        this.ab = -1;
        this.ac = Long.MIN_VALUE;
        this.ad = -1;
        this.ae = Long.MIN_VALUE;
        this.af = -1;
        this.ag = Long.MIN_VALUE;
        this.ah = ChoiceMode.NONE;
        this.ai = 0;
        this.mCheckedIdStates = null;
        this.aj = null;
        this.f6661a = new RecycleBin();
        this.p = null;
        this.v = true;
        this.ap = null;
        this.aq = null;
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setWillNotDraw(false);
        setClipToPadding(false);
        ViewCompat.getErrorConfigVersion(this, 1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griver_AUHorizontalListView, i, 0);
        this.L = obtainStyledAttributes.getBoolean(R.styleable.griver_AUHorizontalListView_drawSelectorOnTop, false);
        Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.griver_AUHorizontalListView_listSelector);
        if (__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d != null) {
            setSelector(__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d);
        }
        a();
        int i2 = obtainStyledAttributes.getInt(R.styleable.griver_AUHorizontalListView_choiceMode, -1);
        if (i2 >= 0) {
            setChoiceMode(ChoiceMode.values()[i2]);
        }
        obtainStyledAttributes.recycle();
        g();
    }

    private static int a(Rect rect, Rect rect2, int i) {
        int width;
        int height;
        int width2;
        int i2;
        int height2;
        int i3;
        if (i == 1 || i == 2) {
            width = rect.right + (rect.width() / 2);
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.left + (rect2.width() / 2);
            i2 = rect2.top;
            height2 = rect2.height() / 2;
        } else if (i != 17) {
            if (i == 33) {
                width = rect.left + (rect.width() / 2);
                height = rect.top;
                width2 = rect2.left + (rect2.width() / 2);
                i3 = rect2.bottom;
            } else if (i == 66) {
                width = rect.right;
                height = (rect.height() / 2) + rect.top;
                width2 = rect2.left;
                i2 = rect2.top;
                height2 = rect2.height() / 2;
            } else if (i == 130) {
                width = rect.left + (rect.width() / 2);
                height = rect.bottom;
                width2 = rect2.left + (rect2.width() / 2);
                i3 = rect2.top;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            int i4 = width2 - width;
            int i5 = i3 - height;
            return (i5 * i5) + (i4 * i4);
        } else {
            width = rect.left;
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.right;
            i2 = rect2.top;
            height2 = rect2.height() / 2;
        }
        i3 = height2 + i2;
        int i42 = width2 - width;
        int i52 = i3 - height;
        return (i52 * i52) + (i42 * i42);
    }

    private void a() {
        this.k = false;
        g();
        resetState();
        this.f6661a.clear();
        requestLayout();
    }

    public Drawable getSelector() {
        return this.M;
    }

    public void setSelector(int i) {
        setSelector(InstrumentInjector.Resources_getDrawable(getResources(), i));
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.M;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.M);
        }
        this.M = drawable;
        drawable.getPadding(new Rect());
        drawable.setCallback(this);
        s();
    }

    @Override // android.widget.AdapterView
    public int getSelectedItemPosition() {
        return this.ab;
    }

    @Override // android.widget.AdapterView
    public long getSelectedItemId() {
        return this.ac;
    }

    public boolean isItemChecked(int i) {
        SparseBooleanArray sparseBooleanArray;
        if (this.ah.compareTo(ChoiceMode.NONE) != 0 || (sparseBooleanArray = this.aj) == null) {
            return false;
        }
        return sparseBooleanArray.get(i);
    }

    public void setChoiceMode(ChoiceMode choiceMode) {
        ListAdapter listAdapter;
        this.ah = choiceMode;
        if (choiceMode.compareTo(ChoiceMode.NONE) != 0) {
            if (this.aj == null) {
                this.aj = new SparseBooleanArray();
            }
            if (this.mCheckedIdStates == null && (listAdapter = this.j) != null && listAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.j;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        AdapterDataSetObserver adapterDataSetObserver;
        ListAdapter listAdapter2 = this.j;
        if (listAdapter2 != null && (adapterDataSetObserver = this.p) != null) {
            listAdapter2.unregisterDataSetObserver(adapterDataSetObserver);
        }
        resetState();
        this.f6661a.clear();
        this.j = listAdapter;
        this.r = true;
        this.af = -1;
        this.ag = Long.MIN_VALUE;
        SparseBooleanArray sparseBooleanArray = this.aj;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.getAuthRequestContext();
        }
        if (this.j != null) {
            this.t = this.s;
            this.s = listAdapter.getCount();
            AdapterDataSetObserver adapterDataSetObserver2 = new AdapterDataSetObserver();
            this.p = adapterDataSetObserver2;
            this.j.registerDataSetObserver(adapterDataSetObserver2);
            this.f6661a.setViewTypeCount(listAdapter.getViewTypeCount());
            this.u = listAdapter.hasStableIds();
            this.v = listAdapter.areAllItemsEnabled();
            if (this.ah.compareTo(ChoiceMode.NONE) != 0 && this.u && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            int o2 = o(0);
            setSelectedPositionInt(o2);
            setNextSelectedPositionInt(o2);
            if (this.s == 0) {
                t();
            }
        } else {
            this.s = 0;
            this.u = false;
            this.v = true;
            t();
        }
        F();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.w;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return (this.w + getChildCount()) - 1;
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        return this.s;
    }

    @Override // android.widget.AdapterView
    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return this.w + i;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getParent() == this) {
            selectedView.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(selectedView, rect);
            return;
        }
        super.getFocusedRect(rect);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        ListAdapter listAdapter;
        super.onFocusChanged(z, i, rect);
        if (z && this.ad < 0 && !isInTouchMode()) {
            if (!this.f6663o && (listAdapter = this.j) != null) {
                this.r = true;
                this.t = this.s;
                this.s = listAdapter.getCount();
            }
            resurrectSelection();
        }
        ListAdapter listAdapter2 = this.j;
        int i2 = -1;
        int i3 = 0;
        if (listAdapter2 != null && z && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter2.getCount() < getChildCount() + this.w) {
                this.al = 0;
                x();
            }
            Rect rect2 = this.e;
            int childCount = getChildCount();
            int i4 = this.w;
            int i5 = 0;
            int i6 = Integer.MAX_VALUE;
            while (i3 < childCount) {
                if (listAdapter2.isEnabled(i4 + i3)) {
                    View childAt = getChildAt(i3);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int a2 = a(rect, rect2, i);
                    if (a2 < i6) {
                        i5 = this.k ? childAt.getTop() : childAt.getLeft();
                        i2 = i3;
                        i6 = a2;
                    }
                }
                i3++;
            }
            i3 = i5;
        }
        if (i2 >= 0) {
            setSelectionFromOffset(i2 + this.w, i3);
        } else {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.j != null && this.p == null) {
            AdapterDataSetObserver adapterDataSetObserver = new AdapterDataSetObserver();
            this.p = adapterDataSetObserver;
            this.j.registerDataSetObserver(adapterDataSetObserver);
            this.r = true;
            this.t = this.s;
            this.s = this.j.getCount();
        }
        this.f6663o = true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6661a.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        ListAdapter listAdapter = this.j;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(this.p);
            this.p = null;
        }
        PerformClick performClick = this.H;
        if (performClick != null) {
            removeCallbacks(performClick);
        }
        Runnable runnable = this.I;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.I.run();
        }
        this.f6663o = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i = !isInTouchMode();
        if (z) {
            int i2 = this.an;
            if (i != i2 && i2 != -1) {
                if (i == 1) {
                    resurrectSelection();
                } else {
                    p();
                    this.al = 0;
                    x();
                }
            }
        } else if (i == 1) {
            this.J = this.ad;
        }
        this.an = i;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        boolean z3 = this.k;
        boolean z4 = true;
        if (z3 && this.O != i2) {
            onScrollChanged(getScrollX(), i2, getScrollX(), this.O);
            this.O = i2;
        } else if (z3 || this.O == i) {
            z4 = false;
        } else {
            onScrollChanged(i, getScrollY(), this.O, getScrollY());
            this.O = i;
        }
        if (z4) {
            invalidate();
            l();
        }
    }

    private boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (Build.VERSION.SDK_INT < 9) {
            return false;
        }
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        if (Build.VERSION.SDK_INT < 9) {
            return;
        }
        if (i != 2) {
            if (this.ap == null) {
                Context context = getContext();
                this.ap = new EdgeEffectCompat(context);
                this.aq = new EdgeEffectCompat(context);
            }
        } else {
            this.ap = null;
            this.aq = null;
        }
        super.setOverScrollMode(i);
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.C;
        if (rect == null) {
            rect = new Rect();
            this.C = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.w + childCount;
                }
            }
        }
        return -1;
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int top = childAt.getTop();
        int height = childAt.getHeight();
        if (height > 0) {
            i += (top * 100) / height;
        }
        View childAt2 = getChildAt(childCount - 1);
        int bottom = childAt2.getBottom();
        int height2 = childAt2.getHeight();
        return height2 > 0 ? i - (((bottom - getHeight()) * 100) / height2) : i;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            i += (left * 100) / width;
        }
        View childAt2 = getChildAt(childCount - 1);
        int right = childAt2.getRight();
        int width2 = childAt2.getWidth();
        return width2 > 0 ? i - (((right - getWidth()) * 100) / width2) : i;
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        int i = this.w;
        int childCount = getChildCount();
        if (i >= 0 && childCount != 0) {
            View childAt = getChildAt(0);
            int top = childAt.getTop();
            int height = childAt.getHeight();
            if (height > 0) {
                return Math.max((i * 100) - ((top * 100) / height), 0);
            }
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        int i = this.w;
        int childCount = getChildCount();
        if (i >= 0 && childCount != 0) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max((i * 100) - ((left * 100) / width), 0);
            }
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        int i;
        int max = Math.max(this.s * 100, 0);
        return (!this.k || (i = this.O) == 0) ? max : max + Math.abs((int) ((i / getHeight()) * this.s * 100.0f));
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        int i;
        int max = Math.max(this.s * 100, 0);
        return (this.k || (i = this.O) == 0) ? max : max + Math.abs((int) ((i / getWidth()) * this.s * 100.0f));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.j.getItemId(positionForView);
            AdapterView.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
            boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(this, view, positionForView, itemId) : false;
            if (onItemLongClick) {
                return onItemLongClick;
            }
            this.ak = a(getChildAt(positionForView - this.w), positionForView, itemId);
            return super.showContextMenuForChild(view);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            d();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f6663o
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r2 = 1
            if (r0 == 0) goto L76
            if (r0 == r2) goto L6a
            r3 = 2
            if (r0 == r3) goto L19
            r6 = 3
            if (r0 == r6) goto L6a
            goto Lac
        L19:
            int r0 = r5.am
            if (r0 != 0) goto Lac
            r5.c()
            android.view.VelocityTracker r0 = r5.ao
            r0.addMovement(r6)
            int r0 = r5.B
            int r0 = androidx.core.view.MotionEventCompat.BuiltInFictitiousFunctionClassFactory(r6, r0)
            if (r0 >= 0) goto L4b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "onInterceptTouchEvent could not find pointer with id "
            r6.append(r0)
            int r0 = r5.B
            r6.append(r0)
            java.lang.String r0 = " - did TwoWayView receive an inconsistent event stream?"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "APHorizontalListView"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r0, r6)
            return r1
        L4b:
            boolean r3 = r5.k
            if (r3 == 0) goto L54
            float r6 = androidx.core.view.MotionEventCompat.getAuthRequestContext(r6, r0)
            goto L58
        L54:
            float r6 = androidx.core.view.MotionEventCompat.PlaceComponentResult(r6, r0)
        L58:
            float r0 = r5.z
            float r6 = r6 - r0
            float r0 = r5.A
            float r6 = r6 + r0
            int r0 = (int) r6
            float r3 = (float) r0
            float r6 = r6 - r3
            r5.A = r6
            boolean r6 = r5.h(r0)
            if (r6 == 0) goto Lac
            return r2
        L6a:
            r6 = -1
            r5.B = r6
            r5.am = r6
            r5.d()
            r5.g(r1)
            goto Lac
        L76:
            r5.b()
            android.view.VelocityTracker r0 = r5.ao
            r0.addMovement(r6)
            android.widget.Scroller r0 = r5.i
            r0.abortAnimation()
            float r0 = r6.getX()
            float r3 = r6.getY()
            boolean r4 = r5.k
            if (r4 == 0) goto L90
            r0 = r3
        L90:
            r5.z = r0
            int r0 = (int) r0
            int r0 = r5.l(r0)
            int r6 = androidx.core.view.MotionEventCompat.MyBillsEntityDataFactory(r6, r1)
            r5.B = r6
            r6 = 0
            r5.A = r6
            int r6 = r5.am
            r3 = 4
            if (r6 != r3) goto La6
            return r2
        La6:
            if (r0 < 0) goto Lac
            r5.D = r0
            r5.am = r1
        Lac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        boolean z;
        EdgeEffectCompat edgeEffectCompat;
        float PlaceComponentResult;
        float PlaceComponentResult2;
        boolean z2 = false;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        } else if (this.f6663o) {
            c();
            this.ao.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                requestLayout();
                if (!this.r) {
                    this.ao.clear();
                    this.i.abortAnimation();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.z = this.k ? y : x;
                    int pointToPosition = pointToPosition((int) x, (int) y);
                    this.B = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, 0);
                    this.A = 0.0f;
                    if (!this.r) {
                        if (this.am == 4) {
                            this.am = 3;
                            g(1);
                            l((int) this.z);
                            return true;
                        }
                        int i = this.D;
                        if (i >= 0 && this.j.isEnabled(i)) {
                            this.am = 0;
                            h();
                        }
                        this.D = pointToPosition;
                    }
                }
            } else if (action == 1) {
                int i2 = this.am;
                if (i2 == 0 || i2 == 1 || i2 == 2) {
                    int i3 = this.D;
                    final View childAt = getChildAt(i3 - this.w);
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    boolean z3 = !this.k ? y2 <= ((float) getPaddingTop()) || y2 >= ((float) (getHeight() - getPaddingBottom())) : x2 <= ((float) getPaddingLeft()) || x2 >= ((float) (getWidth() - getPaddingRight()));
                    if (childAt != null && !childAt.hasFocusable() && z3) {
                        if (this.am != 0) {
                            childAt.setPressed(false);
                        }
                        if (this.H == null) {
                            this.H = new PerformClick();
                        }
                        final PerformClick performClick = this.H;
                        performClick.mClickMotionPosition = i3;
                        performClick.rememberWindowAttachCount();
                        this.J = i3;
                        int i4 = this.am;
                        if (i4 == 0 || i4 == 1) {
                            if (i4 == 0) {
                                i();
                            } else {
                                k();
                            }
                            this.al = 0;
                            if (!this.r && this.j.isEnabled(i3)) {
                                this.am = 1;
                                setPressed(true);
                                a(this.D, childAt);
                                childAt.setPressed(true);
                                Drawable drawable = this.M;
                                if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                    ((TransitionDrawable) current).resetTransition();
                                }
                                Runnable runnable = this.I;
                                if (runnable != null) {
                                    removeCallbacks(runnable);
                                }
                                Runnable runnable2 = new Runnable() { // from class: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AUHorizontalListView.this.am = -1;
                                        AUHorizontalListView.this.setPressed(false);
                                        childAt.setPressed(false);
                                        if (!AUHorizontalListView.this.r) {
                                            performClick.run();
                                        }
                                        AUHorizontalListView.this.I = null;
                                    }
                                };
                                this.I = runnable2;
                                postDelayed(runnable2, ViewConfiguration.getPressedStateDuration());
                            } else {
                                this.am = -1;
                                s();
                            }
                        } else if (!this.r && this.j.isEnabled(i3)) {
                            performClick.run();
                        }
                    }
                    this.am = -1;
                    s();
                } else if (i2 != 3) {
                    if (i2 == 5) {
                        this.am = -1;
                        g(0);
                    }
                } else if (f()) {
                    this.am = -1;
                    g(0);
                } else {
                    this.ao.computeCurrentVelocity(1000, this.c);
                    if (this.k) {
                        PlaceComponentResult = VelocityTrackerCompat.getAuthRequestContext(this.ao, this.B);
                    } else {
                        PlaceComponentResult = VelocityTrackerCompat.PlaceComponentResult(this.ao, this.B);
                    }
                    if (Math.abs(PlaceComponentResult) >= this.d) {
                        this.am = 4;
                        g(2);
                        Scroller scroller = this.i;
                        boolean z4 = this.k;
                        int i5 = (int) (z4 ? 0.0f : PlaceComponentResult);
                        if (!z4) {
                            PlaceComponentResult = 0.0f;
                        }
                        scroller.fling(0, 0, i5, (int) PlaceComponentResult, z4 ? 0 : Integer.MIN_VALUE, z4 ? 0 : Integer.MAX_VALUE, z4 ? Integer.MIN_VALUE : 0, z4 ? Integer.MAX_VALUE : 0);
                        this.z = 0.0f;
                        z = true;
                        i();
                        k();
                        setPressed(false);
                        edgeEffectCompat = this.ap;
                        if (edgeEffectCompat != null && this.aq != null) {
                            z |= edgeEffectCompat.PlaceComponentResult() | this.aq.PlaceComponentResult();
                        }
                        z2 = z;
                        d();
                    } else {
                        this.am = -1;
                        g(0);
                    }
                }
                z = false;
                i();
                k();
                setPressed(false);
                edgeEffectCompat = this.ap;
                if (edgeEffectCompat != null) {
                    z |= edgeEffectCompat.PlaceComponentResult() | this.aq.PlaceComponentResult();
                }
                z2 = z;
                d();
            } else if (action == 2) {
                int BuiltInFictitiousFunctionClassFactory2 = MotionEventCompat.BuiltInFictitiousFunctionClassFactory(motionEvent, this.B);
                if (BuiltInFictitiousFunctionClassFactory2 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onInterceptTouchEvent could not find pointer with id ");
                    sb.append(this.B);
                    sb.append(" - did TwoWayView receive an inconsistent event stream?");
                    InstrumentInjector.log_e("APHorizontalListView", sb.toString());
                    return false;
                }
                if (this.k) {
                    PlaceComponentResult2 = MotionEventCompat.getAuthRequestContext(motionEvent, BuiltInFictitiousFunctionClassFactory2);
                } else {
                    PlaceComponentResult2 = MotionEventCompat.PlaceComponentResult(motionEvent, BuiltInFictitiousFunctionClassFactory2);
                }
                if (this.r) {
                    x();
                }
                float f = (PlaceComponentResult2 - this.z) + this.A;
                int i6 = (int) f;
                this.A = f - i6;
                int i7 = this.am;
                if (i7 == 0 || i7 == 1 || i7 == 2) {
                    h(i6);
                } else if (i7 == 3 || i7 == 5) {
                    this.z = PlaceComponentResult2;
                    i(i6);
                }
            } else if (action == 3) {
                i();
                this.am = -1;
                g(0);
                setPressed(false);
                View childAt2 = getChildAt(this.D - this.w);
                if (childAt2 != null) {
                    childAt2.setPressed(false);
                }
                EdgeEffectCompat edgeEffectCompat2 = this.ap;
                if (edgeEffectCompat2 != null && this.aq != null) {
                    z2 = edgeEffectCompat2.PlaceComponentResult() | this.aq.PlaceComponentResult();
                }
                d();
            }
            if (z2) {
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            p();
            if (getWidth() > 0 && getHeight() > 0 && getChildCount() > 0) {
                x();
            }
            s();
        } else if (this.am != 5 || this.O == 0) {
        } else {
            this.O = 0;
            m();
            invalidate();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return a(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return a(i, i2, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return a(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        if (i == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.av == firstVisiblePosition && this.aw == lastVisiblePosition) {
                return;
            }
            this.av = firstVisiblePosition;
            this.aw = lastVisiblePosition;
        }
        super.sendAccessibilityEvent(i);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AUHorizontalListView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AUHorizontalListView.class.getName());
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat((Object) accessibilityNodeInfo);
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(4096);
            }
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        int width;
        int paddingRight;
        int width2;
        int paddingRight2;
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (i == 4096) {
            if (!isEnabled() || getLastVisiblePosition() >= getCount() - 1) {
                return false;
            }
            if (this.k) {
                width = getHeight() - getPaddingTop();
                paddingRight = getPaddingBottom();
            } else {
                width = getWidth() - getPaddingLeft();
                paddingRight = getPaddingRight();
            }
            n(width - paddingRight);
            return true;
        } else if (i == 8192 && isEnabled() && this.w > 0) {
            if (this.k) {
                width2 = getHeight() - getPaddingTop();
                paddingRight2 = getPaddingBottom();
            } else {
                width2 = getWidth() - getPaddingLeft();
                paddingRight2 = getPaddingRight();
            }
            n(-(width2 - paddingRight2));
            return true;
        } else {
            return false;
        }
    }

    private boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private void a(int i) {
        boolean z = this.k;
        if (z && i != 33 && i != 130) {
            throw new IllegalArgumentException("Focus direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN} for vertical orientation");
        }
        if (!z && i != 17 && i != 66) {
            throw new IllegalArgumentException("Focus direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT} for vertical orientation");
        }
    }

    private void b(int i) {
        boolean z = this.k;
        if (z && i != 17 && i != 66) {
            throw new IllegalArgumentException("Direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT} for vertical orientation");
        }
        if (!z && i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN} for horizontal orientation");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean pageScroll(int r5) {
        /*
            r4 = this;
            r4.a(r5)
            r0 = 0
            r1 = 1
            r2 = 33
            if (r5 == r2) goto L28
            r2 = 17
            if (r5 == r2) goto L28
            r2 = 130(0x82, float:1.82E-43)
            if (r5 == r2) goto L17
            r2 = 66
            if (r5 == r2) goto L17
            r5 = -1
            goto L34
        L17:
            int r5 = r4.s
            int r5 = r5 - r1
            int r2 = r4.ad
            int r3 = r4.getChildCount()
            int r2 = r2 + r3
            int r2 = r2 - r1
            int r5 = java.lang.Math.min(r5, r2)
            r2 = 1
            goto L35
        L28:
            int r5 = r4.ad
            int r2 = r4.getChildCount()
            int r5 = r5 - r2
            int r5 = r5 - r1
            int r5 = java.lang.Math.max(r0, r5)
        L34:
            r2 = 0
        L35:
            if (r5 >= 0) goto L38
            return r0
        L38:
            int r5 = r4.a(r5, r2)
            if (r5 < 0) goto L78
            r0 = 4
            r4.al = r0
            boolean r0 = r4.k
            if (r0 == 0) goto L4a
            int r0 = r4.getPaddingTop()
            goto L4e
        L4a:
            int r0 = r4.getPaddingLeft()
        L4e:
            r4.x = r0
            if (r2 == 0) goto L5e
            int r0 = r4.s
            int r3 = r4.getChildCount()
            int r0 = r0 - r3
            if (r5 <= r0) goto L5e
            r0 = 3
            r4.al = r0
        L5e:
            if (r2 != 0) goto L68
            int r0 = r4.getChildCount()
            if (r5 >= r0) goto L68
            r4.al = r1
        L68:
            r4.setSelectionInt(r5)
            r4.e()
            boolean r5 = r4.l()
            if (r5 != 0) goto L77
            r4.invalidate()
        L77:
            return r1
        L78:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.pageScroll(int):boolean");
    }

    boolean fullScroll(int i) {
        a(i);
        boolean z = false;
        if (i == 33 || i == 17) {
            if (this.ad != 0) {
                int a2 = a(0, true);
                if (a2 >= 0) {
                    this.al = 1;
                    setSelectionInt(a2);
                    e();
                }
                z = true;
            }
        } else if (i == 130 || i == 66) {
            int i2 = this.ad;
            int i3 = this.s - 1;
            if (i2 < i3) {
                int a3 = a(i3, true);
                if (a3 >= 0) {
                    this.al = 3;
                    setSelectionInt(a3);
                    e();
                }
                z = true;
            }
        }
        if (z && !l()) {
            l();
            invalidate();
        }
        return z;
    }

    private boolean c(int i) {
        View selectedView;
        b(i);
        int childCount = getChildCount();
        if (!this.q || childCount <= 0 || this.ad == -1 || (selectedView = getSelectedView()) == null || !selectedView.hasFocus() || !(selectedView instanceof ViewGroup)) {
            return false;
        }
        View findFocus = selectedView.findFocus();
        View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i);
        if (findNextFocus != null) {
            findFocus.getFocusedRect(this.e);
            offsetDescendantRectToMyCoords(findFocus, this.e);
            offsetRectIntoDescendantCoords(findNextFocus, this.e);
            if (findNextFocus.requestFocus(i, this.e)) {
                return true;
            }
        }
        View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
        if (findNextFocus2 != null) {
            return a(findNextFocus2, this);
        }
        return false;
    }

    private boolean d(int i) {
        a(i);
        try {
            this.m = true;
            boolean f = f(i);
            if (f) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return f;
        } finally {
            this.m = false;
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean z2;
        View view2;
        a(i);
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        int i3 = this.ad;
        int i4 = this.w;
        int i5 = i3 - i4;
        int i6 = i2 - i4;
        boolean z3 = false;
        if (i == 33 || i == 17) {
            z2 = true;
            view2 = view;
            view = getChildAt(i6);
            i5 = i6;
            i6 = i5;
        } else {
            view2 = getChildAt(i6);
            z2 = false;
        }
        int childCount = getChildCount();
        if (view != null) {
            view.setSelected(!z && z2);
            a(view, i5, childCount);
        }
        if (view2 != null) {
            if (!z && !z2) {
                z3 = true;
            }
            view2.setSelected(z3);
            a(view2, i6, childCount);
        }
    }

    private void a(View view, int i, int i2) {
        int height = view.getHeight();
        c(view);
        if (view.getMeasuredHeight() == height) {
            return;
        }
        d(view);
        int measuredHeight = view.getMeasuredHeight();
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            getChildAt(i).offsetTopAndBottom(measuredHeight - height);
        }
    }

    private ArrowScrollFocusResult e(int i) {
        int i2;
        int max;
        View findNextFocusFromRect;
        int width;
        int paddingRight;
        int i3;
        a(i);
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130 || i == 66) {
                int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
                if (selectedView != null) {
                    i2 = this.k ? selectedView.getTop() : selectedView.getLeft();
                } else {
                    i2 = paddingTop;
                }
                max = Math.max(i2, paddingTop);
            } else {
                if (this.k) {
                    width = getHeight();
                    paddingRight = getPaddingBottom();
                } else {
                    width = getWidth();
                    paddingRight = getPaddingRight();
                }
                int i4 = width - paddingRight;
                if (selectedView != null) {
                    i3 = this.k ? selectedView.getBottom() : selectedView.getRight();
                } else {
                    i3 = i4;
                }
                max = Math.min(i3, i4);
            }
            boolean z = this.k;
            int i5 = z ? 0 : max;
            if (!z) {
                max = 0;
            }
            this.e.set(i5, max, i5, max);
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.e, i);
        }
        if (findNextFocusFromRect != null) {
            int a2 = a(findNextFocusFromRect);
            int i6 = this.ad;
            if (i6 != -1 && a2 != i6) {
                int p = p(i);
                boolean z2 = i == 130 || i == 66;
                boolean z3 = i == 33 || i == 17;
                if (p != -1 && ((z2 && p < a2) || (z3 && p > a2))) {
                    return null;
                }
            }
            int a3 = a(i, findNextFocusFromRect, a2);
            int maxScrollAmount = getMaxScrollAmount();
            if (a3 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.f.populate(a2, a3);
                return this.f;
            } else if (b(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.f.populate(a2, maxScrollAmount);
                return this.f;
            }
        }
        return null;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.33f);
    }

    private int getArrowScrollPreviewLength() {
        return this.l + Math.max(10, this.k ? getVerticalFadingEdgeLength() : getHorizontalFadingEdgeLength());
    }

    private int a(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return this.w + i;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private boolean f(int i) {
        View focusedChild;
        a(i);
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i2 = this.ad;
        int p = p(i);
        int a2 = a(i, p);
        View view = null;
        ArrowScrollFocusResult e = this.q ? e(i) : null;
        if (e != null) {
            p = e.getSelectedPosition();
            a2 = e.getAmountToScroll();
        }
        boolean z = e != null;
        if (p != -1) {
            a(selectedView, i, p, e != null);
            setSelectedPositionInt(p);
            setNextSelectedPositionInt(p);
            selectedView = getSelectedView();
            if (this.q && e == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            t();
            i2 = p;
            z = true;
        }
        if (a2 > 0) {
            if (i != 33 && i != 17) {
                a2 = -a2;
            }
            n(a2);
            z = true;
        }
        if (this.q && e == null && selectedView != null && selectedView.hasFocus()) {
            View findFocus = selectedView.findFocus();
            if (!a(findFocus, this) || b(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (p != -1 || selectedView == null || a(selectedView, this)) {
            view = selectedView;
        } else {
            p();
            this.J = -1;
        }
        if (z) {
            if (view != null) {
                a(i2, view);
                this.aa = view.getTop();
            }
            if (!l()) {
                invalidate();
            }
            e();
            return true;
        }
        return false;
    }

    private int a(int i, int i2) {
        int width;
        int paddingRight;
        a(i);
        int childCount = getChildCount();
        if (i == 130 || i == 66) {
            if (this.k) {
                width = getHeight();
                paddingRight = getPaddingBottom();
            } else {
                width = getWidth();
                paddingRight = getPaddingRight();
            }
            int i3 = width - paddingRight;
            int i4 = childCount - 1;
            int i5 = i2 != -1 ? i2 - this.w : i4;
            int i6 = this.w;
            View childAt = getChildAt(i5);
            int arrowScrollPreviewLength = i6 + i5 < this.s + (-1) ? i3 - getArrowScrollPreviewLength() : i3;
            int top = this.k ? childAt.getTop() : childAt.getLeft();
            int bottom = this.k ? childAt.getBottom() : childAt.getRight();
            if (bottom <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - top < getMaxScrollAmount()) {
                int i7 = bottom - arrowScrollPreviewLength;
                if (this.w + childCount == this.s) {
                    View childAt2 = getChildAt(i4);
                    i7 = Math.min(i7, (this.k ? childAt2.getBottom() : childAt2.getRight()) - i3);
                }
                return Math.min(i7, getMaxScrollAmount());
            }
            return 0;
        }
        int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
        int i8 = i2 != -1 ? i2 - this.w : 0;
        int i9 = this.w;
        View childAt3 = getChildAt(i8);
        int arrowScrollPreviewLength2 = i9 + i8 > 0 ? getArrowScrollPreviewLength() + paddingTop : paddingTop;
        int top2 = this.k ? childAt3.getTop() : childAt3.getLeft();
        int bottom2 = this.k ? childAt3.getBottom() : childAt3.getRight();
        if (top2 >= arrowScrollPreviewLength2) {
            return 0;
        }
        if (i2 == -1 || bottom2 - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
            int i10 = arrowScrollPreviewLength2 - top2;
            if (this.w == 0) {
                View childAt4 = getChildAt(0);
                i10 = Math.min(i10, paddingTop - (this.k ? childAt4.getTop() : childAt4.getLeft()));
            }
            return Math.min(i10, getMaxScrollAmount());
        }
        return 0;
    }

    private int a(int i, View view, int i2) {
        int i3;
        int arrowScrollPreviewLength;
        int width;
        int paddingRight;
        a(i);
        view.getDrawingRect(this.e);
        offsetDescendantRectToMyCoords(view, this.e);
        if (i == 33 || i == 17) {
            int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
            int i4 = this.k ? this.e.top : this.e.left;
            if (i4 >= paddingTop) {
                return 0;
            }
            i3 = paddingTop - i4;
            if (i2 <= 0) {
                return i3;
            }
            arrowScrollPreviewLength = getArrowScrollPreviewLength();
        } else {
            if (this.k) {
                width = getHeight();
                paddingRight = getPaddingBottom();
            } else {
                width = getWidth();
                paddingRight = getPaddingRight();
            }
            int i5 = width - paddingRight;
            int i6 = this.k ? this.e.bottom : this.e.right;
            if (i6 <= i5) {
                return 0;
            }
            i3 = i6 - i5;
            if (i2 >= this.s - 1) {
                return i3;
            }
            arrowScrollPreviewLength = getArrowScrollPreviewLength();
        }
        return i3 + arrowScrollPreviewLength;
    }

    private int b(View view) {
        int width;
        int paddingRight;
        view.getDrawingRect(this.e);
        offsetDescendantRectToMyCoords(view, this.e);
        int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
        if (this.k) {
            width = getHeight();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth();
            paddingRight = getPaddingRight();
        }
        int i = width - paddingRight;
        int i2 = this.k ? this.e.top : this.e.left;
        int i3 = this.k ? this.e.bottom : this.e.right;
        if (i3 < paddingTop) {
            return paddingTop - i3;
        }
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    private boolean a(KeyEvent keyEvent, int i, int i2) {
        if (keyEvent.hasNoModifiers()) {
            boolean resurrectSelectionIfNeeded = resurrectSelectionIfNeeded();
            if (resurrectSelectionIfNeeded) {
                return resurrectSelectionIfNeeded;
            }
            while (i > 0 && d(i2)) {
                i--;
                resurrectSelectionIfNeeded = true;
            }
            return resurrectSelectionIfNeeded;
        } else if (keyEvent.hasModifiers(2)) {
            return resurrectSelectionIfNeeded() || fullScroll(i2);
        } else {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x012a, code lost:
    
        if (fullScroll(r9.k ? 33 : 17) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a9, code lost:
    
        if (fullScroll(r9.k ? 130 : 66) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c3, code lost:
    
        if (fullScroll(r9.k ? 33 : 17) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dd, code lost:
    
        if (pageScroll(r9.k ? 130 : 66) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f7, code lost:
    
        if (fullScroll(r9.k ? 130 : 66) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0111, code lost:
    
        if (pageScroll(r9.k ? 33 : 17) != false) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(int r10, int r11, android.view.KeyEvent r12) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.a(int, int, android.view.KeyEvent):boolean");
    }

    private void b() {
        VelocityTracker velocityTracker = this.ao;
        if (velocityTracker == null) {
            this.ao = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void c() {
        if (this.ao == null) {
            this.ao = VelocityTracker.obtain();
        }
    }

    private void d() {
        VelocityTracker velocityTracker = this.ao;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.ao = null;
        }
    }

    private void e() {
        OnScrollListener onScrollListener = this.ar;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.w, getChildCount(), this.s);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    private void g(int i) {
        OnScrollListener onScrollListener;
        if (i == this.as || (onScrollListener = this.ar) == null) {
            return;
        }
        this.as = i;
        onScrollListener.onScrollStateChanged(this, i);
    }

    private boolean h(int i) {
        boolean z = this.O != 0;
        if (Math.abs(i) > this.b || z) {
            if (z) {
                this.am = 5;
            } else {
                this.am = 3;
            }
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            k();
            setPressed(false);
            View childAt = getChildAt(this.D - this.w);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            g(1);
            return true;
        }
        return false;
    }

    private void i(int i) {
        int i2 = this.am;
        if (i2 == 3) {
            j(i);
        } else if (i2 == 5) {
            k(i);
        }
    }

    private void j(int i) {
        int childCount;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        int i2 = this.D;
        if (i2 >= 0) {
            childCount = i2 - this.w;
        } else {
            childCount = getChildCount() / 2;
        }
        int i3 = 0;
        View childAt = getChildAt(childCount);
        if (childAt != null) {
            i3 = this.k ? childAt.getTop() : childAt.getLeft();
        }
        boolean n = n(i);
        View childAt2 = getChildAt(childCount);
        if (childAt2 != null) {
            int top = this.k ? childAt2.getTop() : childAt2.getLeft();
            if (n) {
                b(i, (-i) - (top - i3));
            }
        }
    }

    private void b(int i, int i2) {
        VelocityTracker velocityTracker;
        boolean z = this.k;
        a(z ? 0 : i2, z ? i2 : 0, z ? 0 : this.O, z ? this.O : 0, 0, 0, z ? 0 : this.h, z ? this.h : 0, true);
        if (Math.abs(this.h) == Math.abs(this.O) && (velocityTracker = this.ao) != null) {
            velocityTracker.clear();
        }
        int isLayoutRequested = ViewCompat.isLayoutRequested(this);
        if (isLayoutRequested == 0 || (isLayoutRequested == 1 && !f())) {
            this.am = 5;
            float height = i2 / (this.k ? getHeight() : getWidth());
            if (i > 0) {
                this.ap.PlaceComponentResult(height);
                if (!this.aq.getAuthRequestContext()) {
                    this.aq.PlaceComponentResult();
                }
            } else if (i < 0) {
                this.aq.PlaceComponentResult(height);
                if (!this.ap.getAuthRequestContext()) {
                    this.ap.PlaceComponentResult();
                }
            }
            if (i != 0) {
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
            }
        }
    }

    private void k(int i) {
        int i2;
        int i3 = this.O;
        int i4 = i3 - i;
        int i5 = -i;
        if ((i4 >= 0 || i3 < 0) && (i4 <= 0 || i3 > 0)) {
            i2 = 0;
        } else {
            i5 = -i3;
            i2 = i + i5;
        }
        if (i5 != 0) {
            b(i2, i5);
        }
        if (i2 != 0) {
            if (this.O != 0) {
                this.O = 0;
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
            }
            n(i2);
            this.am = 3;
            this.D = m((int) this.z);
            this.A = 0.0f;
        }
    }

    private int l(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((this.k && i <= childAt.getBottom()) || (!this.k && i <= childAt.getRight())) {
                return this.w + i2;
            }
        }
        return -1;
    }

    private int m(int i) {
        if (getChildCount() == 0) {
            return -1;
        }
        int l = l(i);
        return l != -1 ? l : (this.w + r0) - 1;
    }

    private int a(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT < 9) {
            return 0;
        }
        return viewConfiguration.getScaledOverscrollDistance();
    }

    private boolean f() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.s) {
            return false;
        }
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(childCount - 1);
        return this.k ? childAt.getTop() >= getPaddingTop() && childAt2.getBottom() <= getHeight() - getPaddingBottom() : childAt.getLeft() >= getPaddingLeft() && childAt2.getRight() <= getWidth() - getPaddingRight();
    }

    private void g() {
        setHorizontalScrollBarEnabled(!this.k);
        setVerticalScrollBarEnabled(this.k);
    }

    private void h() {
        if (this.E == null) {
            this.E = new CheckForTap();
        }
        postDelayed(this.E, ViewConfiguration.getTapTimeout());
    }

    private void i() {
        CheckForTap checkForTap = this.E;
        if (checkForTap == null) {
            return;
        }
        removeCallbacks(checkForTap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.F == null) {
            this.F = new CheckForLongPress();
        }
        this.F.rememberWindowAttachCount();
        postDelayed(this.F, ViewConfiguration.getLongPressTimeout());
    }

    private void k() {
        CheckForLongPress checkForLongPress = this.F;
        if (checkForLongPress == null) {
            return;
        }
        removeCallbacks(checkForLongPress);
    }

    private boolean n(int i) {
        int width;
        int width2;
        int min;
        int i2;
        int i3;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        View childAt = getChildAt(0);
        int top = this.k ? childAt.getTop() : childAt.getLeft();
        int i5 = childCount - 1;
        View childAt2 = getChildAt(i5);
        int bottom = this.k ? childAt2.getBottom() : childAt2.getRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        boolean z = this.k;
        int i6 = z ? paddingTop : paddingLeft;
        if (z) {
            width = getHeight() - paddingBottom;
        } else {
            width = getWidth() - paddingRight;
        }
        if (this.k) {
            width2 = (getHeight() - paddingBottom) - paddingTop;
        } else {
            width2 = (getWidth() - paddingRight) - paddingLeft;
        }
        if (i < 0) {
            min = Math.max(-(width2 - 1), i);
        } else {
            min = Math.min(width2 - 1, i);
        }
        int i7 = this.w;
        boolean z2 = i7 == 0 && top >= i6 && min >= 0;
        boolean z3 = i7 + childCount == this.s && bottom <= width && min <= 0;
        if (z2 || z3) {
            return min != 0;
        }
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            p();
        }
        boolean z4 = min < 0;
        if (z4) {
            int i8 = -min;
            i3 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt3 = getChildAt(i9);
                if ((this.k ? childAt3.getBottom() : childAt3.getRight()) >= i8 + i6) {
                    break;
                }
                i3++;
                this.f6661a.addScrapView(childAt3, i7 + i9);
            }
            i2 = 0;
        } else {
            i2 = 0;
            i3 = 0;
            while (i5 >= 0) {
                View childAt4 = getChildAt(i5);
                if ((this.k ? childAt4.getTop() : childAt4.getLeft()) <= width - min) {
                    break;
                }
                i3++;
                this.f6661a.addScrapView(childAt4, i7 + i5);
                int i10 = i5;
                i5--;
                i2 = i10;
            }
        }
        this.n = true;
        if (i3 > 0) {
            detachViewsFromParent(i2, i3);
        }
        if (!l()) {
            invalidate();
        }
        q(min);
        if (z4) {
            this.w += i3;
        }
        int abs = Math.abs(min);
        if (i6 - top < abs || bottom - width < abs) {
            fillGap(z4);
        }
        if (!isInTouchMode && (i4 = this.ad) != -1) {
            int i11 = i4 - this.w;
            if (i11 >= 0 && i11 < getChildCount()) {
                a(this.ad, getChildAt(i11));
            }
        } else {
            int i12 = this.N;
            if (i12 != -1) {
                int i13 = i12 - this.w;
                if (i13 >= 0 && i13 < getChildCount()) {
                    a(-1, getChildAt(i13));
                }
            } else {
                this.g.setEmpty();
            }
        }
        this.n = false;
        e();
        return false;
    }

    private final float getCurrVelocity() {
        if (Build.VERSION.SDK_INT >= 14) {
            return this.i.getCurrVelocity();
        }
        return 0.0f;
    }

    private boolean l() {
        if (Build.VERSION.SDK_INT >= 5) {
            return super.awakenScrollBars();
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        int currX;
        if (this.i.computeScrollOffset()) {
            if (this.k) {
                currX = this.i.getCurrY();
            } else {
                currX = this.i.getCurrX();
            }
            float f = currX;
            int i = (int) (f - this.z);
            this.z = f;
            boolean n = n(i);
            if (!n && !this.i.isFinished()) {
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
                return;
            }
            if (n) {
                if (ViewCompat.isLayoutRequested(this) != 2) {
                    if ((i > 0 ? this.ap : this.aq).KClassImpl$Data$declaredNonStaticMembers$2(Math.abs((int) getCurrVelocity()))) {
                        ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
                    }
                }
                this.i.abortAnimation();
            }
            this.am = -1;
            g(0);
        }
    }

    private void m() {
        EdgeEffectCompat edgeEffectCompat = this.ap;
        if (edgeEffectCompat != null) {
            edgeEffectCompat.MyBillsEntityDataFactory();
        }
        EdgeEffectCompat edgeEffectCompat2 = this.aq;
        if (edgeEffectCompat2 != null) {
            edgeEffectCompat2.MyBillsEntityDataFactory();
        }
    }

    private boolean a(Canvas canvas) {
        if (this.ap.getAuthRequestContext()) {
            return false;
        }
        if (this.k) {
            return this.ap.MyBillsEntityDataFactory(canvas);
        }
        int save = canvas.save();
        canvas.translate(0.0f, (getHeight() - getPaddingTop()) - getPaddingBottom());
        canvas.rotate(270.0f);
        boolean MyBillsEntityDataFactory2 = this.ap.MyBillsEntityDataFactory(canvas);
        canvas.restoreToCount(save);
        return MyBillsEntityDataFactory2;
    }

    private boolean b(Canvas canvas) {
        if (this.aq.getAuthRequestContext()) {
            return false;
        }
        int save = canvas.save();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = getHeight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (this.k) {
            canvas.translate(-width, (height - paddingTop) - paddingBottom);
            canvas.rotate(180.0f, width, 0.0f);
        } else {
            canvas.translate(width, 0.0f);
            canvas.rotate(90.0f);
        }
        boolean MyBillsEntityDataFactory2 = this.aq.MyBillsEntityDataFactory(canvas);
        canvas.restoreToCount(save);
        return MyBillsEntityDataFactory2;
    }

    private void c(Canvas canvas) {
        if (this.g.isEmpty()) {
            return;
        }
        Drawable drawable = this.M;
        drawable.setBounds(this.g);
        drawable.draw(canvas);
    }

    private void n() {
        setSelector(InstrumentInjector.Resources_getDrawable(getResources(), 17301602));
    }

    private boolean o() {
        return (hasFocus() && !isInTouchMode()) || q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, View view) {
        if (i != -1) {
            this.N = i;
        }
        this.g.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        boolean z = this.K;
        if (view.isEnabled() != z) {
            this.K = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void p() {
        int i = this.ad;
        if (i != -1) {
            if (this.al != 4) {
                this.J = i;
            }
            int i2 = this.ab;
            if (i2 >= 0 && i2 != i) {
                this.J = i2;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.aa = 0;
        }
    }

    private void setSelectedPositionInt(int i) {
        this.ad = i;
        this.ae = getItemIdAtPosition(i);
    }

    private void setSelectionInt(int i) {
        setNextSelectedPositionInt(i);
        int i2 = this.ad;
        boolean z = true;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        x();
        if (z) {
            l();
        }
    }

    private void setNextSelectedPositionInt(int i) {
        this.ab = i;
        long itemIdAtPosition = getItemIdAtPosition(i);
        this.ac = itemIdAtPosition;
        if (this.S && this.T == 0 && i >= 0) {
            this.U = i;
            this.V = itemIdAtPosition;
        }
    }

    private boolean q() {
        int i = this.am;
        return i == 1 || i == 2;
    }

    private void r() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.M;
            Rect rect = this.g;
            if (drawable != null) {
                if ((isFocused() || q()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.ad - this.w);
                    if (childAt != null) {
                        if (childAt.hasFocusable()) {
                            return;
                        }
                        childAt.setPressed(true);
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (!isLongClickable || this.r) {
                        return;
                    }
                    if (this.G == null) {
                        this.G = new CheckForKeyLongPress();
                    }
                    this.G.rememberWindowAttachCount();
                    postDelayed(this.G, ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    private void s() {
        if (this.M != null) {
            if (o()) {
                this.M.setState(getDrawableState());
            } else {
                this.M.setState(STATE_NOTHING);
            }
        }
    }

    private void t() {
        if (this.ad == this.af && this.ae == this.ag) {
            return;
        }
        u();
        this.af = this.ad;
        this.ag = this.ae;
    }

    private void u() {
        if (getOnItemSelectedListener() == null) {
            return;
        }
        if (this.m || this.n) {
            if (this.R == null) {
                this.R = new SelectionNotifier();
            }
            post(this.R);
            return;
        }
        v();
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        AdapterView.OnItemSelectedListener onItemSelectedListener = getOnItemSelectedListener();
        if (onItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            onItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, this.j.getItemId(selectedItemPosition));
        } else {
            onItemSelectedListener.onNothingSelected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    private int o(int i) {
        return a(i, true);
    }

    private int a(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.j;
        if (listAdapter != null && !isInTouchMode()) {
            int i2 = this.s;
            if (!this.v) {
                if (z) {
                    min = Math.max(0, i);
                    while (min < i2 && !listAdapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i, i2 - 1);
                    while (min >= 0 && !listAdapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= i2) {
                    return -1;
                }
                return min;
            } else if (i >= 0 && i < i2) {
                return i;
            }
        }
        return -1;
    }

    private int p(int i) {
        a(i);
        int i2 = this.w;
        ListAdapter adapter = getAdapter();
        if (i == 130 || i == 66) {
            int i3 = this.ad;
            int i4 = i3 != -1 ? i3 + 1 : i2;
            if (i4 >= adapter.getCount()) {
                return -1;
            }
            if (i4 < i2) {
                i4 = i2;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            while (i4 <= lastVisiblePosition) {
                if (adapter.isEnabled(i4) && getChildAt(i4 - i2).getVisibility() == 0) {
                    return i4;
                }
                i4++;
            }
        } else {
            int childCount = (getChildCount() + i2) - 1;
            int i5 = this.ad;
            if (i5 == -1) {
                i5 = getChildCount() + i2;
            }
            int i6 = i5 - 1;
            if (i6 < 0 || i6 >= adapter.getCount()) {
                return -1;
            }
            if (i6 <= childCount) {
                childCount = i6;
            }
            while (childCount >= i2) {
                if (adapter.isEnabled(childCount) && getChildAt(childCount - i2).getVisibility() == 0) {
                    return childCount;
                }
                childCount--;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.K) {
            return super.onCreateDrawableState(i);
        }
        int i2 = ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            } else if (onCreateDrawableState[length] == i2) {
                break;
            } else {
                length--;
            }
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.s > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z = this.L;
        if (!z) {
            c(canvas);
        }
        fsSuperDispatchDraw_74224bc0ea6e2c3a69a8fa1f5b54019e(canvas);
        if (z) {
            c(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        fsSuperDraw_74224bc0ea6e2c3a69a8fa1f5b54019e(canvas);
        boolean a2 = this.ap != null ? false | a(canvas) : false;
        if (this.aq != null) {
            a2 |= b(canvas);
        }
        if (a2) {
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.m || this.n) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        int i;
        if (this.s <= 0 || (i = this.ad) < 0) {
            return null;
        }
        return getChildAt(i - this.w);
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        setSelectionFromOffset(i, 0);
    }

    public void setSelectionFromOffset(int i, int i2) {
        if (this.j == null) {
            return;
        }
        if (!isInTouchMode()) {
            i = o(i);
            if (i >= 0) {
                setNextSelectedPositionInt(i);
            }
        } else {
            this.J = i;
        }
        if (i >= 0) {
            this.al = 4;
            if (this.k) {
                this.x = getPaddingTop() + i2;
            } else {
                this.x = getPaddingLeft() + i2;
            }
            if (this.S) {
                this.U = i;
                this.V = this.j.getItemId(i);
            }
            requestLayout();
        }
    }

    public void scrollBy(int i) {
        n(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        if (this.M == null) {
            n();
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        ListAdapter listAdapter = this.j;
        int i4 = 0;
        int count = listAdapter == null ? 0 : listAdapter.getCount();
        this.s = count;
        if (count <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
        } else {
            View a2 = a(0, this.mIsScrap);
            b(a2, 0, this.k ? i : i2);
            i4 = a2.getMeasuredWidth();
            i3 = a2.getMeasuredHeight();
            if (recycleOnMeasure()) {
                this.f6661a.addScrapView(a2, -1);
            }
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
            if (this.k) {
                size += getVerticalScrollbarWidth();
            }
        }
        int i5 = size;
        if (mode2 == 0) {
            size2 = getPaddingTop() + getPaddingBottom() + i3;
            if (!this.k && getChildCount() != 0) {
                size2 += getHorizontalScrollbarHeight();
            }
        }
        int i6 = size2;
        if (this.k && mode2 == Integer.MIN_VALUE) {
            i6 = a(i, 0, -1, i6, -1);
        }
        int i7 = i6;
        if (!this.k && mode == Integer.MIN_VALUE) {
            i5 = b(i2, 0, -1, i5, -1);
        }
        setMeasuredDimension(i5, i7);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.m = true;
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).forceLayout();
            }
            this.f6661a.markChildrenDirty();
        }
        x();
        this.m = false;
        int paddingLeft = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
        int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        EdgeEffectCompat edgeEffectCompat = this.ap;
        if (edgeEffectCompat == null || this.aq == null) {
            return;
        }
        if (this.k) {
            edgeEffectCompat.KClassImpl$Data$declaredNonStaticMembers$2(paddingLeft, paddingTop);
            this.aq.KClassImpl$Data$declaredNonStaticMembers$2(paddingLeft, paddingTop);
            return;
        }
        edgeEffectCompat.KClassImpl$Data$declaredNonStaticMembers$2(paddingTop, paddingLeft);
        this.aq.KClassImpl$Data$declaredNonStaticMembers$2(paddingTop, paddingLeft);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01c7, code lost:
    
        r0 = getFocusedChild();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01cb, code lost:
    
        if (r0 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01cd, code lost:
    
        r0.clearFocus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01d0, code lost:
    
        a(-1, r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e A[Catch: all -> 0x027f, TryCatch #0 {all -> 0x027f, blocks: (B:9:0x0016, B:11:0x001d, B:15:0x0027, B:17:0x002b, B:19:0x0034, B:21:0x0039, B:23:0x004a, B:32:0x0060, B:35:0x0069, B:37:0x006f, B:39:0x0077, B:41:0x007c, B:48:0x009a, B:50:0x009e, B:51:0x00a1, B:53:0x00a5, B:57:0x00af, B:59:0x00b7, B:63:0x00c5, B:65:0x00d6, B:68:0x00de, B:70:0x00e4, B:73:0x00ed, B:75:0x00f5, B:76:0x00fa, B:78:0x00ff, B:91:0x0155, B:111:0x019d, B:113:0x01a2, B:115:0x01a7, B:117:0x01ad, B:121:0x01b7, B:128:0x01c7, B:130:0x01cd, B:131:0x01d0, B:134:0x01e1, B:136:0x01e5, B:138:0x01ee, B:152:0x021e, B:154:0x0224, B:155:0x0227, B:157:0x0237, B:158:0x023a, B:137:0x01ea, B:132:0x01d4, B:123:0x01bd, B:133:0x01de, B:139:0x01f1, B:143:0x01f8, B:145:0x0203, B:147:0x0211, B:150:0x0219, B:146:0x0209, B:92:0x015d, B:94:0x0161, B:97:0x0167, B:99:0x016b, B:100:0x0170, B:101:0x0174, B:102:0x017b, B:105:0x0183, B:107:0x0187, B:108:0x018c, B:109:0x0190, B:110:0x0197, B:79:0x0105, B:80:0x010f, B:81:0x0119, B:82:0x0125, B:84:0x0133, B:86:0x0137, B:88:0x0140, B:87:0x013c, B:89:0x0145, B:90:0x014a, B:64:0x00d3, B:162:0x0245, B:163:0x027e, B:42:0x0087, B:45:0x0090, B:22:0x0042, B:18:0x0030), top: B:169:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5 A[Catch: all -> 0x027f, TRY_LEAVE, TryCatch #0 {all -> 0x027f, blocks: (B:9:0x0016, B:11:0x001d, B:15:0x0027, B:17:0x002b, B:19:0x0034, B:21:0x0039, B:23:0x004a, B:32:0x0060, B:35:0x0069, B:37:0x006f, B:39:0x0077, B:41:0x007c, B:48:0x009a, B:50:0x009e, B:51:0x00a1, B:53:0x00a5, B:57:0x00af, B:59:0x00b7, B:63:0x00c5, B:65:0x00d6, B:68:0x00de, B:70:0x00e4, B:73:0x00ed, B:75:0x00f5, B:76:0x00fa, B:78:0x00ff, B:91:0x0155, B:111:0x019d, B:113:0x01a2, B:115:0x01a7, B:117:0x01ad, B:121:0x01b7, B:128:0x01c7, B:130:0x01cd, B:131:0x01d0, B:134:0x01e1, B:136:0x01e5, B:138:0x01ee, B:152:0x021e, B:154:0x0224, B:155:0x0227, B:157:0x0237, B:158:0x023a, B:137:0x01ea, B:132:0x01d4, B:123:0x01bd, B:133:0x01de, B:139:0x01f1, B:143:0x01f8, B:145:0x0203, B:147:0x0211, B:150:0x0219, B:146:0x0209, B:92:0x015d, B:94:0x0161, B:97:0x0167, B:99:0x016b, B:100:0x0170, B:101:0x0174, B:102:0x017b, B:105:0x0183, B:107:0x0187, B:108:0x018c, B:109:0x0190, B:110:0x0197, B:79:0x0105, B:80:0x010f, B:81:0x0119, B:82:0x0125, B:84:0x0133, B:86:0x0137, B:88:0x0140, B:87:0x013c, B:89:0x0145, B:90:0x014a, B:64:0x00d3, B:162:0x0245, B:163:0x027e, B:42:0x0087, B:45:0x0090, B:22:0x0042, B:18:0x0030), top: B:169:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af A[Catch: all -> 0x027f, TRY_ENTER, TryCatch #0 {all -> 0x027f, blocks: (B:9:0x0016, B:11:0x001d, B:15:0x0027, B:17:0x002b, B:19:0x0034, B:21:0x0039, B:23:0x004a, B:32:0x0060, B:35:0x0069, B:37:0x006f, B:39:0x0077, B:41:0x007c, B:48:0x009a, B:50:0x009e, B:51:0x00a1, B:53:0x00a5, B:57:0x00af, B:59:0x00b7, B:63:0x00c5, B:65:0x00d6, B:68:0x00de, B:70:0x00e4, B:73:0x00ed, B:75:0x00f5, B:76:0x00fa, B:78:0x00ff, B:91:0x0155, B:111:0x019d, B:113:0x01a2, B:115:0x01a7, B:117:0x01ad, B:121:0x01b7, B:128:0x01c7, B:130:0x01cd, B:131:0x01d0, B:134:0x01e1, B:136:0x01e5, B:138:0x01ee, B:152:0x021e, B:154:0x0224, B:155:0x0227, B:157:0x0237, B:158:0x023a, B:137:0x01ea, B:132:0x01d4, B:123:0x01bd, B:133:0x01de, B:139:0x01f1, B:143:0x01f8, B:145:0x0203, B:147:0x0211, B:150:0x0219, B:146:0x0209, B:92:0x015d, B:94:0x0161, B:97:0x0167, B:99:0x016b, B:100:0x0170, B:101:0x0174, B:102:0x017b, B:105:0x0183, B:107:0x0187, B:108:0x018c, B:109:0x0190, B:110:0x0197, B:79:0x0105, B:80:0x010f, B:81:0x0119, B:82:0x0125, B:84:0x0133, B:86:0x0137, B:88:0x0140, B:87:0x013c, B:89:0x0145, B:90:0x014a, B:64:0x00d3, B:162:0x0245, B:163:0x027e, B:42:0x0087, B:45:0x0090, B:22:0x0042, B:18:0x0030), top: B:169:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x() {
        /*
            Method dump skipped, instructions count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.x():void");
    }

    private void q(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (this.k) {
                childAt.offsetTopAndBottom(i);
            } else {
                childAt.offsetLeftAndRight(i);
            }
        }
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a2;
        int i4 = this.ad;
        int top = this.k ? view.getTop() : view.getLeft();
        int bottom = this.k ? view.getBottom() : view.getRight();
        if (i > 0) {
            View a3 = a(i4 - 1, top, true, false);
            int i5 = this.l;
            a2 = a(i4, bottom + i5, true, true);
            int top2 = this.k ? a2.getTop() : a2.getLeft();
            int bottom2 = this.k ? a2.getBottom() : a2.getRight();
            if (bottom2 > i3) {
                int min = Math.min(Math.min(top2 - i2, bottom2 - i3), (i3 - i2) / 2);
                if (this.k) {
                    int i6 = -min;
                    a3.offsetTopAndBottom(i6);
                    a2.offsetTopAndBottom(i6);
                } else {
                    int i7 = -min;
                    a3.offsetLeftAndRight(i7);
                    a2.offsetLeftAndRight(i7);
                }
            }
            c(this.ad - 2, top2 - i5);
            A();
            d(this.ad + 1, bottom2 + i5);
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, this.k ? view2.getTop() : view2.getLeft(), true, true);
            } else {
                a2 = a(i4, top, false, true);
            }
            int top3 = this.k ? a2.getTop() : a2.getLeft();
            int bottom3 = this.k ? a2.getBottom() : a2.getRight();
            if (top3 < i2) {
                int min2 = Math.min(Math.min(i2 - top3, i3 - bottom3), (i3 - i2) / 2);
                if (this.k) {
                    a2.offsetTopAndBottom(min2);
                } else {
                    a2.offsetLeftAndRight(min2);
                }
            }
            a(a2, i4);
        } else {
            a2 = a(i4, top, true, true);
            int top4 = this.k ? a2.getTop() : a2.getLeft();
            int bottom4 = this.k ? a2.getBottom() : a2.getRight();
            if (top < i2 && bottom4 < i2 + 20) {
                if (this.k) {
                    a2.offsetTopAndBottom(i2 - top4);
                } else {
                    a2.offsetLeftAndRight(i2 - top4);
                }
            }
            a(a2, i4);
        }
        return a2;
    }

    void confirmCheckedPositionsById() {
        boolean z;
        this.aj.clear();
        int i = 0;
        while (true) {
            LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            if (i >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            LongSparseArray<Integer> longSparseArray2 = this.mCheckedIdStates;
            if (longSparseArray2.MyBillsEntityDataFactory) {
                longSparseArray2.BuiltInFictitiousFunctionClassFactory();
            }
            long j = longSparseArray2.PlaceComponentResult[i];
            LongSparseArray<Integer> longSparseArray3 = this.mCheckedIdStates;
            if (longSparseArray3.MyBillsEntityDataFactory) {
                longSparseArray3.BuiltInFictitiousFunctionClassFactory();
            }
            int intValue = ((Integer) longSparseArray3.BuiltInFictitiousFunctionClassFactory[i]).intValue();
            if (j != this.j.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.s);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else if (j == this.j.getItemId(max)) {
                        this.aj.put(max, true);
                        LongSparseArray<Integer> longSparseArray4 = this.mCheckedIdStates;
                        Integer valueOf = Integer.valueOf(max);
                        if (longSparseArray4.MyBillsEntityDataFactory) {
                            longSparseArray4.BuiltInFictitiousFunctionClassFactory();
                        }
                        longSparseArray4.BuiltInFictitiousFunctionClassFactory[i] = valueOf;
                        z = true;
                    } else {
                        max++;
                    }
                }
                if (!z) {
                    this.mCheckedIdStates.PlaceComponentResult(j);
                    i--;
                    this.ai--;
                }
            } else {
                this.aj.put(intValue, true);
            }
            i++;
        }
    }

    private void y() {
        ListAdapter listAdapter;
        if (this.ah.compareTo(ChoiceMode.NONE) != 0 && (listAdapter = this.j) != null && listAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        this.f6661a.clearTransientStateViews();
        int i = this.s;
        if (i > 0) {
            if (this.S) {
                this.S = false;
                this.y = null;
                int i2 = this.T;
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.al = 5;
                        this.U = Math.min(Math.max(0, this.U), i - 1);
                        return;
                    }
                } else if (isInTouchMode()) {
                    this.al = 5;
                    this.U = Math.min(Math.max(0, this.U), i - 1);
                    return;
                } else {
                    int C = C();
                    if (C >= 0 && a(C, true) == C) {
                        this.U = C;
                        if (this.W == getHeight()) {
                            this.al = 5;
                        } else {
                            this.al = 2;
                        }
                        setNextSelectedPositionInt(C);
                        return;
                    }
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                if (selectedItemPosition >= i) {
                    selectedItemPosition = i - 1;
                }
                if (selectedItemPosition < 0) {
                    selectedItemPosition = 0;
                }
                int a2 = a(selectedItemPosition, true);
                if (a2 >= 0) {
                    setNextSelectedPositionInt(a2);
                    return;
                }
                int a3 = a(selectedItemPosition, false);
                if (a3 >= 0) {
                    setNextSelectedPositionInt(a3);
                    return;
                }
            } else if (this.J >= 0) {
                return;
            }
        }
        this.al = 1;
        this.ad = -1;
        this.ae = Long.MIN_VALUE;
        this.ab = -1;
        this.ac = Long.MIN_VALUE;
        this.S = false;
        this.y = null;
        this.N = -1;
        t();
    }

    private int z() {
        int i = this.ad;
        if (i < 0) {
            i = this.J;
        }
        return Math.min(Math.max(0, i), this.s - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean resurrectSelection() {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.resurrectSelection():boolean");
    }

    boolean resurrectSelectionIfNeeded() {
        if (this.ad >= 0 || !resurrectSelection()) {
            return false;
        }
        s();
        return true;
    }

    private int a(LayoutParams layoutParams) {
        if (!this.k && layoutParams.width == -2) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        if (this.k) {
            return View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
    }

    private int b(LayoutParams layoutParams) {
        if (this.k && layoutParams.height == -2) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        if (!this.k) {
            return View.MeasureSpec.makeMeasureSpec((getHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
    }

    private void c(View view) {
        a(view, (LayoutParams) view.getLayoutParams());
    }

    private void a(View view, LayoutParams layoutParams) {
        view.measure(a(layoutParams), b(layoutParams));
    }

    private void d(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int top = view.getTop();
        view.layout(paddingLeft, top, measuredWidth + paddingLeft, measuredHeight + top);
    }

    private void b(View view, int i, int i2) {
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.viewType = this.j.getItemViewType(i);
        layoutParams.forceAdd = true;
        if (this.k) {
            i3 = b(layoutParams);
        } else {
            i2 = a(layoutParams);
            i3 = i2;
        }
        view.measure(i2, i3);
    }

    private int a(int i, int i2, int i3, int i4, int i5) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        ListAdapter listAdapter = this.j;
        int i6 = paddingTop + paddingBottom;
        if (listAdapter == null) {
            return i6;
        }
        int i7 = this.l;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        RecycleBin recycleBin = this.f6661a;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        int i8 = 0;
        while (i2 <= i3) {
            View a2 = a(i2, zArr);
            b(a2, i2, i);
            if (i2 > 0) {
                i6 += i7;
            }
            if (recycleOnMeasure) {
                recycleBin.addScrapView(a2, -1);
            }
            i6 += a2.getMeasuredHeight();
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i8 <= 0 || i6 == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    private int b(int i, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        ListAdapter listAdapter = this.j;
        int i6 = paddingLeft + paddingRight;
        if (listAdapter == null) {
            return i6;
        }
        int i7 = this.l;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        RecycleBin recycleBin = this.f6661a;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        int i8 = 0;
        while (i2 <= i3) {
            View a2 = a(i2, zArr);
            b(a2, i2, i);
            if (i2 > 0) {
                i6 += i7;
            }
            if (recycleOnMeasure) {
                recycleBin.addScrapView(a2, -1);
            }
            i6 += a2.getMeasuredHeight();
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i8 <= 0 || i6 == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        int i3;
        int paddingTop;
        View activeView;
        if (this.k) {
            paddingTop = i2;
            i3 = getPaddingLeft();
        } else {
            i3 = i2;
            paddingTop = getPaddingTop();
        }
        if (!this.r && (activeView = this.f6661a.getActiveView(i)) != null) {
            a(activeView, i, paddingTop, i3, z, z2, true);
            return activeView;
        }
        View a2 = a(i, this.mIsScrap);
        a(a2, i, paddingTop, i3, z, z2, this.mIsScrap[0]);
        return a2;
    }

    private void a(View view, int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        SparseBooleanArray sparseBooleanArray;
        boolean z4 = z2 && o();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.am;
        boolean z6 = i4 > 0 && i4 < 3 && this.D == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        layoutParams.viewType = this.j.getItemViewType(i);
        if (z3 && !layoutParams.forceAdd) {
            attachViewToParent(view, z ? -1 : 0, layoutParams);
        } else {
            layoutParams.forceAdd = false;
            addViewInLayout(view, z ? -1 : 0, layoutParams, true);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.ah.compareTo(ChoiceMode.NONE) != 0 && (sparseBooleanArray = this.aj) != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(sparseBooleanArray.get(i));
            } else {
                Context context = getContext();
                try {
                    byte b = (byte) (BuiltInFictitiousFunctionClassFactory[8] - 1);
                    byte b2 = BuiltInFictitiousFunctionClassFactory[41];
                    Object[] objArr = new Object[1];
                    ax(b, b2, (byte) (b2 + 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = BuiltInFictitiousFunctionClassFactory[41];
                    Object[] objArr2 = new Object[1];
                    ax(b3, (byte) (b3 + 1), BuiltInFictitiousFunctionClassFactory[41], objArr2);
                    if (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion >= 11) {
                        view.setActivated(this.aj.get(i));
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        }
        if (z8) {
            a(view, layoutParams);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z9 = this.k;
        if (z9 && !z) {
            i2 -= measuredHeight;
        }
        if (!z9 && !z) {
            i3 -= measuredWidth;
        }
        if (z8) {
            view.layout(i3, i2, measuredWidth + i3, measuredHeight + i2);
            return;
        }
        view.offsetLeftAndRight(i3 - view.getLeft());
        view.offsetTopAndBottom(i2 - view.getTop());
    }

    void fillGap(boolean z) {
        int width;
        int left;
        int right;
        try {
            int childCount = getChildCount();
            if (z) {
                int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
                if (this.k) {
                    right = getChildAt(childCount - 1).getBottom();
                } else {
                    right = getChildAt(childCount - 1).getRight();
                }
                if (childCount > 0) {
                    paddingTop = this.l + right;
                }
                d(this.w + childCount, paddingTop);
                s(getChildCount());
                return;
            }
            if (this.k) {
                width = getHeight() - getPaddingBottom();
                left = getChildAt(0).getTop();
            } else {
                width = getWidth() - getPaddingRight();
                left = getChildAt(0).getLeft();
            }
            if (childCount > 0) {
                width = left - this.l;
            }
            c(this.w - 1, width);
            t(getChildCount());
        } catch (Exception unused) {
        }
    }

    private View c(int i, int i2) {
        int left;
        int i3;
        int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
        View view = null;
        while (true) {
            if (i2 <= paddingTop || i < 0) {
                break;
            }
            boolean z = i == this.ad;
            View a2 = a(i, i2, false, z);
            if (this.k) {
                left = a2.getTop();
                i3 = this.l;
            } else {
                left = a2.getLeft();
                i3 = this.l;
            }
            if (z) {
                view = a2;
            }
            i--;
            i2 = left - i3;
        }
        this.w = i + 1;
        return view;
    }

    private View d(int i, int i2) {
        int width;
        int paddingRight;
        int right;
        int i3;
        if (this.k) {
            width = getHeight();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth();
            paddingRight = getPaddingRight();
        }
        View view = null;
        while (i2 < width - paddingRight && i < this.s) {
            boolean z = i == this.ad;
            View a2 = a(i, i2, true, z);
            if (this.k) {
                right = a2.getBottom();
                i3 = this.l;
            } else {
                right = a2.getRight();
                i3 = this.l;
            }
            if (z) {
                view = a2;
            }
            i++;
            i2 = right + i3;
        }
        return view;
    }

    private View e(int i, int i2) {
        int left;
        int right;
        boolean z = i == this.ad;
        View a2 = a(i, i2, true, z);
        this.w = i;
        int i3 = this.l;
        if (this.k) {
            left = a2.getTop();
        } else {
            left = a2.getLeft();
        }
        View c = c(i - 1, left - i3);
        A();
        if (this.k) {
            right = a2.getBottom();
        } else {
            right = a2.getRight();
        }
        View d = d(i + 1, right + i3);
        int childCount = getChildCount();
        if (childCount > 0) {
            s(childCount);
        }
        return z ? a2 : c != null ? c : d;
    }

    private View r(int i) {
        int min = Math.min(this.w, this.ad);
        this.w = min;
        int min2 = Math.min(min, this.s - 1);
        this.w = min2;
        if (min2 < 0) {
            this.w = 0;
        }
        return d(this.w, i);
    }

    private View f(int i, int i2) {
        int i3 = i2 - i;
        int z = z();
        View a2 = a(z, i, true, true);
        this.w = z;
        if (this.k) {
            int measuredHeight = a2.getMeasuredHeight();
            if (measuredHeight <= i3) {
                a2.offsetTopAndBottom((i3 - measuredHeight) / 2);
            }
        } else {
            int measuredWidth = a2.getMeasuredWidth();
            if (measuredWidth <= i3) {
                a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
            }
        }
        a(a2, z);
        s(getChildCount());
        return a2;
    }

    private void a(View view, int i) {
        int left;
        int right;
        int i2 = this.l;
        if (this.k) {
            left = view.getTop();
        } else {
            left = view.getLeft();
        }
        c(i - 1, left - i2);
        A();
        if (this.k) {
            right = view.getBottom();
        } else {
            right = view.getRight();
        }
        d(i + 1, right + i2);
    }

    private View a(int i, int i2, int i3) {
        int i4 = this.ad;
        View a2 = a(i4, i, true, true);
        int top = this.k ? a2.getTop() : a2.getLeft();
        int bottom = this.k ? a2.getBottom() : a2.getRight();
        if (bottom > i3) {
            a2.offsetTopAndBottom(-Math.min(top - i2, bottom - i3));
        } else if (top < i2) {
            a2.offsetTopAndBottom(Math.min(i2 - top, i3 - bottom));
        }
        a(a2, i4);
        s(getChildCount());
        return a2;
    }

    private void s(int i) {
        int right;
        int width;
        int paddingRight;
        if ((this.w + i) - 1 != this.s - 1 || i == 0) {
            return;
        }
        View childAt = getChildAt(i - 1);
        if (this.k) {
            right = childAt.getBottom();
        } else {
            right = childAt.getRight();
        }
        int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
        if (this.k) {
            width = getHeight();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth();
            paddingRight = getPaddingRight();
        }
        int i2 = (width - paddingRight) - right;
        View childAt2 = getChildAt(0);
        int top = this.k ? childAt2.getTop() : childAt2.getLeft();
        if (i2 > 0) {
            int i3 = this.w;
            if (i3 > 0 || top < paddingTop) {
                if (i3 == 0) {
                    i2 = Math.min(i2, paddingTop - top);
                }
                q(i2);
                if (this.w > 0) {
                    c(this.w - 1, (this.k ? childAt2.getTop() : childAt2.getLeft()) - this.l);
                    A();
                }
            }
        }
    }

    private void t(int i) {
        int width;
        int paddingRight;
        if (this.w != 0 || i == 0) {
            return;
        }
        View childAt = getChildAt(0);
        int top = this.k ? childAt.getTop() : childAt.getLeft();
        int paddingTop = this.k ? getPaddingTop() : getPaddingLeft();
        if (this.k) {
            width = getHeight();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth();
            paddingRight = getPaddingRight();
        }
        int i2 = width - paddingRight;
        int i3 = top - paddingTop;
        View childAt2 = getChildAt(i - 1);
        int bottom = this.k ? childAt2.getBottom() : childAt2.getRight();
        int i4 = (this.w + i) - 1;
        if (i3 > 0) {
            int i5 = this.s - 1;
            if (i4 >= i5 && bottom <= i2) {
                if (i4 == i5) {
                    A();
                    return;
                }
                return;
            }
            if (i4 == i5) {
                i3 = Math.min(i3, bottom - i2);
            }
            q(-i3);
            if (i4 < this.s - 1) {
                d(i4 + 1, (this.k ? childAt2.getBottom() : childAt2.getRight()) + this.l);
                A();
            }
        }
    }

    private void A() {
        int left;
        int i;
        if (getChildCount() == 0) {
            return;
        }
        View childAt = getChildAt(0);
        if (this.k) {
            left = childAt.getTop() - getPaddingTop();
            i = this.l;
        } else {
            left = childAt.getLeft() - getPaddingLeft();
            i = this.l;
        }
        int i2 = left - i;
        int i3 = i2 >= 0 ? i2 : 0;
        if (i3 != 0) {
            q(-i3);
        }
    }

    private SparseBooleanArray B() {
        if (this.aj == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return this.aj.clone();
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int i = 0; i < this.aj.size(); i++) {
            sparseBooleanArray.put(this.aj.keyAt(i), this.aj.valueAt(i));
        }
        return sparseBooleanArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int C() {
        /*
            r19 = this;
            r0 = r19
            int r1 = r0.s
            r2 = -1
            if (r1 != 0) goto L8
            return r2
        L8:
            long r3 = r0.V
            r5 = -9223372036854775808
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L11
            return r2
        L11:
            int r5 = r0.U
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            r7 = 1
            int r1 = r1 - r7
            int r5 = java.lang.Math.min(r1, r5)
            long r8 = android.os.SystemClock.uptimeMillis()
            android.widget.ListAdapter r10 = r0.j
            if (r10 != 0) goto L27
            return r2
        L27:
            r11 = r5
        L28:
            r12 = r5
            r13 = 0
        L2a:
            long r14 = android.os.SystemClock.uptimeMillis()
            r16 = 100
            long r16 = r8 + r16
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 > 0) goto L61
            long r14 = r10.getItemId(r12)
            int r16 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r16 != 0) goto L3f
            return r12
        L3f:
            if (r5 != r1) goto L43
            r14 = 1
            goto L44
        L43:
            r14 = 0
        L44:
            if (r11 != 0) goto L48
            r15 = 1
            goto L49
        L48:
            r15 = 0
        L49:
            if (r14 == 0) goto L4d
            if (r15 != 0) goto L61
        L4d:
            if (r15 != 0) goto L5e
            if (r13 == 0) goto L53
            if (r14 == 0) goto L5e
        L53:
            if (r14 != 0) goto L59
            if (r13 != 0) goto L2a
            if (r15 != 0) goto L2a
        L59:
            int r12 = r11 + (-1)
            r11 = r12
            r13 = 1
            goto L2a
        L5e:
            int r5 = r5 + 1
            goto L28
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.C():int");
    }

    private View a(int i, boolean[] zArr) {
        View view;
        zArr[0] = false;
        View transientStateView = this.f6661a.getTransientStateView(i);
        if (transientStateView != null) {
            return transientStateView;
        }
        View scrapView = this.f6661a.getScrapView(i);
        if (scrapView != null) {
            view = this.j.getView(i, scrapView, this);
            if (view != scrapView) {
                this.f6661a.addScrapView(scrapView, i);
            } else {
                zArr[0] = true;
            }
        } else {
            view = this.j.getView(i, null, this);
        }
        if (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(view) == 0) {
            ViewCompat.moveToNextValue(view, 1);
        }
        if (this.u) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            } else if (!checkLayoutParams(layoutParams)) {
                layoutParams = generateLayoutParams((ViewGroup.LayoutParams) layoutParams);
            }
            layoutParams.f6666id = this.j.getItemId(i);
            view.setLayoutParams(layoutParams);
        }
        if (this.au == null) {
            this.au = new ListItemAccessibilityDelegate();
        }
        ViewCompat.MyBillsEntityDataFactory(view, this.au);
        return view;
    }

    void resetState() {
        this.i.forceFinished(true);
        removeAllViewsInLayout();
        this.aa = 0;
        this.w = 0;
        this.r = false;
        this.S = false;
        this.y = null;
        this.af = -1;
        this.ag = Long.MIN_VALUE;
        this.O = 0;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.N = -1;
        this.g.setEmpty();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (getChildCount() == 0) {
            return;
        }
        this.S = true;
        int i = this.ad;
        if (i >= 0) {
            View childAt = getChildAt(i - this.w);
            this.V = this.ac;
            this.U = this.ab;
            if (childAt != null) {
                this.x = this.k ? childAt.getTop() : childAt.getLeft();
            }
            this.T = 0;
            return;
        }
        View childAt2 = getChildAt(0);
        ListAdapter adapter = getAdapter();
        int i2 = this.w;
        if (i2 >= 0 && i2 < adapter.getCount()) {
            this.V = adapter.getItemId(this.w);
        } else {
            this.V = -1L;
        }
        this.U = this.w;
        if (childAt2 != null) {
            this.x = this.k ? childAt2.getTop() : childAt2.getLeft();
        }
        this.T = 1;
    }

    private ContextMenu.ContextMenuInfo a(View view, int i, long j) {
        return new AdapterView.AdapterContextMenuInfo(view, i, j);
    }

    private void E() {
        int i = this.w;
        int childCount = getChildCount();
        Context context = getContext();
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[8] - 1);
            byte b2 = BuiltInFictitiousFunctionClassFactory[41];
            Object[] objArr = new Object[1];
            ax(b, b2, (byte) (b2 + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[41];
            Object[] objArr2 = new Object[1];
            ax(b3, (byte) (b3 + 1), BuiltInFictitiousFunctionClassFactory[41], objArr2);
            boolean z = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion >= 11;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int i3 = i + i2;
                if (childAt instanceof Checkable) {
                    ((Checkable) childAt).setChecked(this.aj.get(i3));
                } else if (z) {
                    childAt.setActivated(this.aj.get(i3));
                }
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    @Override // android.widget.AdapterView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performItemClick(android.view.View r7, int r8, long r9) {
        /*
            r6 = this;
            com.alibaba.griver.ui.ant.basic.AUHorizontalListView$ChoiceMode r0 = r6.ah
            com.alibaba.griver.ui.ant.basic.AUHorizontalListView$ChoiceMode r1 = com.alibaba.griver.ui.ant.basic.AUHorizontalListView.ChoiceMode.MULTIPLE
            int r0 = r0.compareTo(r1)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L4f
            android.util.SparseBooleanArray r0 = r6.aj
            boolean r0 = r0.get(r8, r1)
            r0 = r0 ^ r2
            android.util.SparseBooleanArray r1 = r6.aj
            r1.put(r8, r0)
            androidx.collection.LongSparseArray<java.lang.Integer> r1 = r6.mCheckedIdStates
            if (r1 == 0) goto L41
            android.widget.ListAdapter r1 = r6.j
            boolean r1 = r1.hasStableIds()
            if (r1 == 0) goto L41
            if (r0 == 0) goto L36
            androidx.collection.LongSparseArray<java.lang.Integer> r1 = r6.mCheckedIdStates
            android.widget.ListAdapter r3 = r6.j
            long r3 = r3.getItemId(r8)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r1.getAuthRequestContext(r3, r5)
            goto L41
        L36:
            androidx.collection.LongSparseArray<java.lang.Integer> r1 = r6.mCheckedIdStates
            android.widget.ListAdapter r3 = r6.j
            long r3 = r3.getItemId(r8)
            r1.PlaceComponentResult(r3)
        L41:
            if (r0 == 0) goto L49
            int r0 = r6.ai
            int r0 = r0 + r2
            r6.ai = r0
            goto La1
        L49:
            int r0 = r6.ai
            int r0 = r0 - r2
            r6.ai = r0
            goto La1
        L4f:
            com.alibaba.griver.ui.ant.basic.AUHorizontalListView$ChoiceMode r0 = r6.ah
            com.alibaba.griver.ui.ant.basic.AUHorizontalListView$ChoiceMode r3 = com.alibaba.griver.ui.ant.basic.AUHorizontalListView.ChoiceMode.SINGLE
            int r0 = r0.compareTo(r3)
            if (r0 != 0) goto La2
            android.util.SparseBooleanArray r0 = r6.aj
            boolean r0 = r0.get(r8, r1)
            r0 = r0 ^ r2
            if (r0 == 0) goto L8f
            android.util.SparseBooleanArray r0 = r6.aj
            r0.clear()
            android.util.SparseBooleanArray r0 = r6.aj
            r0.put(r8, r2)
            androidx.collection.LongSparseArray<java.lang.Integer> r0 = r6.mCheckedIdStates
            if (r0 == 0) goto L8c
            android.widget.ListAdapter r0 = r6.j
            boolean r0 = r0.hasStableIds()
            if (r0 == 0) goto L8c
            androidx.collection.LongSparseArray<java.lang.Integer> r0 = r6.mCheckedIdStates
            r0.getAuthRequestContext()
            androidx.collection.LongSparseArray<java.lang.Integer> r0 = r6.mCheckedIdStates
            android.widget.ListAdapter r1 = r6.j
            long r3 = r1.getItemId(r8)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r0.getAuthRequestContext(r3, r1)
        L8c:
            r6.ai = r2
            goto La1
        L8f:
            android.util.SparseBooleanArray r0 = r6.aj
            int r0 = r0.size()
            if (r0 == 0) goto L9f
            android.util.SparseBooleanArray r0 = r6.aj
            boolean r0 = r0.valueAt(r1)
            if (r0 != 0) goto La1
        L9f:
            r6.ai = r1
        La1:
            r1 = 1
        La2:
            if (r1 == 0) goto La7
            r6.E()
        La7:
            boolean r7 = super.performItemClick(r7, r8, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.performItemClick(android.view.View, int, long):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view, int i, long j) {
        AdapterView.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(this, view, i, j) : false;
        if (!onItemLongClick) {
            this.ak = a(view, i, j);
            onItemLongClick = super.showContextMenuForChild(this);
        }
        if (onItemLongClick) {
            performHapticFeedback(0);
        }
        return onItemLongClick;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        if (this.k) {
            return new LayoutParams(-1, -2);
        }
        return new LayoutParams(-2, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.ak;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.y;
        if (savedState2 != null) {
            savedState.selectedId = savedState2.selectedId;
            savedState.firstId = this.y.firstId;
            savedState.viewStart = this.y.viewStart;
            savedState.position = this.y.position;
            savedState.height = this.y.height;
            return savedState;
        }
        boolean z = getChildCount() > 0 && this.s > 0;
        long selectedItemId = getSelectedItemId();
        savedState.selectedId = selectedItemId;
        savedState.height = getHeight();
        if (selectedItemId >= 0) {
            savedState.viewStart = this.aa;
            savedState.position = getSelectedItemPosition();
            savedState.firstId = -1L;
        } else if (z && this.w > 0) {
            View childAt = getChildAt(0);
            savedState.viewStart = this.k ? childAt.getTop() : childAt.getLeft();
            int i = this.w;
            int i2 = this.s;
            if (i >= i2) {
                i = i2 - 1;
            }
            savedState.position = i;
            savedState.firstId = this.j.getItemId(i);
        } else {
            savedState.viewStart = 0;
            savedState.firstId = -1L;
            savedState.position = 0;
        }
        if (this.aj != null) {
            savedState.checkState = B();
        }
        if (this.mCheckedIdStates != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            LongSparseArray<Integer> longSparseArray2 = this.mCheckedIdStates;
            if (longSparseArray2.MyBillsEntityDataFactory) {
                longSparseArray2.BuiltInFictitiousFunctionClassFactory();
            }
            int i3 = longSparseArray2.KClassImpl$Data$declaredNonStaticMembers$2;
            for (int i4 = 0; i4 < i3; i4++) {
                LongSparseArray<Integer> longSparseArray3 = this.mCheckedIdStates;
                if (longSparseArray3.MyBillsEntityDataFactory) {
                    longSparseArray3.BuiltInFictitiousFunctionClassFactory();
                }
                long j = longSparseArray3.PlaceComponentResult[i4];
                LongSparseArray<Integer> longSparseArray4 = this.mCheckedIdStates;
                if (longSparseArray4.MyBillsEntityDataFactory) {
                    longSparseArray4.BuiltInFictitiousFunctionClassFactory();
                }
                longSparseArray.getAuthRequestContext(j, longSparseArray4.BuiltInFictitiousFunctionClassFactory[i4]);
            }
            savedState.checkIdState = longSparseArray;
        }
        savedState.checkedItemCount = this.ai;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.r = true;
        this.W = savedState.height;
        if (savedState.selectedId >= 0) {
            this.S = true;
            this.y = savedState;
            this.V = savedState.selectedId;
            this.U = savedState.position;
            this.x = savedState.viewStart;
            this.T = 0;
        } else if (savedState.firstId >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.N = -1;
            this.S = true;
            this.y = savedState;
            this.V = savedState.firstId;
            this.U = savedState.position;
            this.x = savedState.viewStart;
            this.T = 1;
        }
        if (savedState.checkState != null) {
            this.aj = savedState.checkState;
        }
        if (savedState.checkIdState != null) {
            this.mCheckedIdStates = savedState.checkIdState;
        }
        this.ai = savedState.checkedItemCount;
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setEmptyView(View view) {
        super.setEmptyView(view);
        this.f6662at = view;
        G();
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        ListAdapter adapter = getAdapter();
        boolean z2 = adapter == null || adapter.getCount() == 0;
        this.P = z;
        if (!z) {
            this.Q = false;
        }
        super.setFocusable(z && !z2);
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setFocusableInTouchMode(boolean z) {
        ListAdapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.Q = z;
        if (z) {
            this.P = true;
        }
        if (z && !z3) {
            z2 = true;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        ListAdapter adapter = getAdapter();
        boolean z = adapter != null && adapter.getCount() > 0;
        super.setFocusableInTouchMode(z && this.Q);
        super.setFocusable(z && this.P);
        if (this.f6662at != null) {
            G();
        }
    }

    private void G() {
        ListAdapter listAdapter = this.j;
        if (listAdapter == null || listAdapter.isEmpty()) {
            View view = this.f6662at;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.r) {
                layout(getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.f6662at;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    /* loaded from: classes6.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        boolean forceAdd;

        /* renamed from: id  reason: collision with root package name */
        long f6666id;
        int scrappedFromPosition;
        int viewType;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f6666id = -1L;
            if (this.width == -1) {
                InstrumentInjector.log_w("APHorizontalListView", "Constructing LayoutParams with width FILL_PARENT does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.width = -2;
            }
            if (this.height == -1) {
                InstrumentInjector.log_w("APHorizontalListView", "Constructing LayoutParams with height FILL_PARENT does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.height = -2;
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6666id = -1L;
            if (this.width == -1) {
                InstrumentInjector.log_w("APHorizontalListView", "Inflation setting LayoutParams width to MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.width = -1;
            }
            if (this.height == -1) {
                InstrumentInjector.log_w("APHorizontalListView", "Inflation setting LayoutParams height to MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.height = -2;
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6666id = -1L;
            if (this.width == -1) {
                InstrumentInjector.log_w("APHorizontalListView", "Constructing LayoutParams with width MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.width = -2;
            }
            if (this.height == -1) {
                InstrumentInjector.log_w("APHorizontalListView", "Constructing LayoutParams with height MATCH_PARENT - does not make much sense as the view might change orientation. Falling back to WRAP_CONTENT");
                this.height = -2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        LongSparseArray<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        long firstId;
        int height;
        int position;
        long selectedId;
        int viewStart;
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {90, -83, 93, -67, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int getAuthRequestContext = 190;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.alibaba.griver.ui.ant.basic.AUHorizontalListView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        private static void a(short s, int i, byte b, Object[] objArr) {
            int i2 = s + 105;
            byte[] bArr = BuiltInFictitiousFunctionClassFactory;
            int i3 = (i * 15) + 4;
            int i4 = 16 - (b * 2);
            byte[] bArr2 = new byte[i4];
            int i5 = -1;
            int i6 = i4 - 1;
            if (bArr == null) {
                i3++;
                i2 = i6 + i2 + 2;
                i6 = i6;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i5 = -1;
            }
            while (true) {
                int i7 = i5 + 1;
                bArr2[i7] = (byte) i2;
                if (i7 == i6) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                byte b2 = bArr[i3];
                i3++;
                i2 = i2 + b2 + 2;
                i6 = i6;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i5 = i7;
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.firstId = parcel.readLong();
            this.viewStart = parcel.readInt();
            this.position = parcel.readInt();
            this.height = parcel.readInt();
            this.checkedItemCount = parcel.readInt();
            this.checkState = parcel.readSparseBooleanArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.checkIdState = new LongSparseArray<>();
                for (int i = 0; i < readInt; i++) {
                    this.checkIdState.getAuthRequestContext(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeLong(this.firstId);
            parcel.writeInt(this.viewStart);
            parcel.writeInt(this.position);
            parcel.writeInt(this.height);
            parcel.writeInt(this.checkedItemCount);
            parcel.writeSparseBooleanArray(this.checkState);
            LongSparseArray<Integer> longSparseArray = this.checkIdState;
            if (longSparseArray != null) {
                if (longSparseArray.MyBillsEntityDataFactory) {
                    longSparseArray.BuiltInFictitiousFunctionClassFactory();
                }
                i2 = longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                LongSparseArray<Integer> longSparseArray2 = this.checkIdState;
                if (longSparseArray2.MyBillsEntityDataFactory) {
                    longSparseArray2.BuiltInFictitiousFunctionClassFactory();
                }
                parcel.writeLong(longSparseArray2.PlaceComponentResult[i3]);
                LongSparseArray<Integer> longSparseArray3 = this.checkIdState;
                if (longSparseArray3.MyBillsEntityDataFactory) {
                    longSparseArray3.BuiltInFictitiousFunctionClassFactory();
                }
                parcel.writeInt(((Integer) longSparseArray3.BuiltInFictitiousFunctionClassFactory[i3]).intValue());
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TwoWayView.SavedState{");
            try {
                Object[] objArr = {this};
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b4 = b3;
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append(" selectedId=");
                sb.append(this.selectedId);
                sb.append(" firstId=");
                sb.append(this.firstId);
                sb.append(" viewStart=");
                sb.append(this.viewStart);
                sb.append(" height=");
                sb.append(this.height);
                sb.append(" position=");
                sb.append(this.position);
                sb.append(" checkState=");
                sb.append(this.checkState);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ArrowScrollFocusResult {

        /* renamed from: a  reason: collision with root package name */
        private int f6665a;
        private int b;

        private ArrowScrollFocusResult() {
        }

        void populate(int i, int i2) {
            this.f6665a = i;
            this.b = i2;
        }

        public int getSelectedPosition() {
            return this.f6665a;
        }

        public int getAmountToScroll() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class RecycleBin {

        /* renamed from: a  reason: collision with root package name */
        private RecyclerListener f6667a;
        private int b;
        private View[] c = new View[0];
        private ArrayList<View>[] d;
        private int e;
        private ArrayList<View> f;
        private SparseArrayCompat<View> g;

        public boolean shouldRecycleViewType(int i) {
            return i >= 0;
        }

        RecycleBin() {
        }

        public void setViewTypeCount(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.e = i;
            this.f = arrayListArr[0];
            this.d = arrayListArr;
        }

        public void markChildrenDirty() {
            int i = this.e;
            if (i == 1) {
                ArrayList<View> arrayList = this.f;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).forceLayout();
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.d[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.g;
            if (sparseArrayCompat != null) {
                int MyBillsEntityDataFactory = sparseArrayCompat.MyBillsEntityDataFactory();
                for (int i5 = 0; i5 < MyBillsEntityDataFactory; i5++) {
                    this.g.lookAheadTest(i5).forceLayout();
                }
            }
        }

        void clear() {
            int i = this.e;
            if (i == 1) {
                ArrayList<View> arrayList = this.f;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AUHorizontalListView.this.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.d[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AUHorizontalListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.g;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.PlaceComponentResult();
            }
        }

        void fillActiveViews(int i, int i2) {
            if (this.c.length < i) {
                this.c = new View[i];
            }
            this.b = i2;
            View[] viewArr = this.c;
            for (int i3 = 0; i3 < i; i3++) {
                viewArr[i3] = AUHorizontalListView.this.getChildAt(i3);
            }
        }

        View getActiveView(int i) {
            int i2 = i - this.b;
            View[] viewArr = this.c;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View getTransientStateView(int i) {
            int MyBillsEntityDataFactory;
            SparseArrayCompat<View> sparseArrayCompat = this.g;
            if (sparseArrayCompat != null && (MyBillsEntityDataFactory = sparseArrayCompat.MyBillsEntityDataFactory(i)) >= 0) {
                View lookAheadTest = this.g.lookAheadTest(MyBillsEntityDataFactory);
                this.g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                return lookAheadTest;
            }
            return null;
        }

        void clearTransientStateViews() {
            SparseArrayCompat<View> sparseArrayCompat = this.g;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.PlaceComponentResult();
            }
        }

        View getScrapView(int i) {
            if (this.e != 1) {
                int itemViewType = AUHorizontalListView.this.j.getItemViewType(i);
                if (itemViewType >= 0) {
                    ArrayList<View>[] arrayListArr = this.d;
                    if (itemViewType < arrayListArr.length) {
                        return retrieveFromScrap(arrayListArr[itemViewType], i);
                    }
                    return null;
                }
                return null;
            }
            return retrieveFromScrap(this.f, i);
        }

        void addScrapView(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.scrappedFromPosition = i;
            int i2 = layoutParams.viewType;
            boolean B = ViewCompat.B(view);
            if (!shouldRecycleViewType(i2) || B) {
                if (B) {
                    if (this.g == null) {
                        this.g = new SparseArrayCompat<>();
                    }
                    this.g.PlaceComponentResult(i, view);
                    return;
                }
                return;
            }
            if (this.e == 1) {
                this.f.add(view);
            } else {
                this.d[i2].add(view);
            }
            if (Build.VERSION.SDK_INT >= 14) {
                InstrumentInjector.setAccessibilityDelegate(view, null);
            }
            RecyclerListener recyclerListener = this.f6667a;
            if (recyclerListener != null) {
                recyclerListener.onMovedToScrapHeap(view);
            }
        }

        void scrapActiveViews() {
            View[] viewArr = this.c;
            boolean z = this.e > 1;
            ArrayList<View> arrayList = this.f;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i = layoutParams.viewType;
                    viewArr[length] = null;
                    boolean B = ViewCompat.B(view);
                    if (shouldRecycleViewType(i) && !B) {
                        if (z) {
                            arrayList = this.d[i];
                        }
                        layoutParams.scrappedFromPosition = this.b + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            InstrumentInjector.setAccessibilityDelegate(view, null);
                        }
                        RecyclerListener recyclerListener = this.f6667a;
                        if (recyclerListener != null) {
                            recyclerListener.onMovedToScrapHeap(view);
                        }
                    } else if (B) {
                        AUHorizontalListView.this.removeDetachedView(view, false);
                        if (this.g == null) {
                            this.g = new SparseArrayCompat<>();
                        }
                        this.g.PlaceComponentResult(this.b + length, view);
                    }
                }
            }
            a();
        }

        private void a() {
            int length = this.c.length;
            int i = this.e;
            ArrayList<View>[] arrayListArr = this.d;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                ArrayList<View> arrayList = arrayListArr[i3];
                int size = arrayList.size();
                int i4 = size - 1;
                int i5 = 0;
                while (i5 < size - length) {
                    AUHorizontalListView.this.removeDetachedView(arrayList.remove(i4), false);
                    i5++;
                    i4--;
                }
            }
            if (this.g != null) {
                while (i2 < this.g.MyBillsEntityDataFactory()) {
                    if (!ViewCompat.B(this.g.lookAheadTest(i2))) {
                        this.g.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                        i2--;
                    }
                    i2++;
                }
            }
        }

        void reclaimScrapViews(List<View> list) {
            int i = this.e;
            if (i == 1) {
                list.addAll(this.f);
                return;
            }
            ArrayList<View>[] arrayListArr = this.d;
            for (int i2 = 0; i2 < i; i2++) {
                list.addAll(arrayListArr[i2]);
            }
        }

        View retrieveFromScrap(ArrayList<View> arrayList, int i) {
            int size = arrayList.size();
            if (size <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                if (((LayoutParams) view.getLayoutParams()).scrappedFromPosition == i) {
                    arrayList.remove(i2);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class AdapterDataSetObserver extends DataSetObserver {

        /* renamed from: a  reason: collision with root package name */
        private Parcelable f6664a;

        private AdapterDataSetObserver() {
            this.f6664a = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AUHorizontalListView.this.r = true;
            AUHorizontalListView aUHorizontalListView = AUHorizontalListView.this;
            aUHorizontalListView.t = aUHorizontalListView.s;
            AUHorizontalListView aUHorizontalListView2 = AUHorizontalListView.this;
            aUHorizontalListView2.s = aUHorizontalListView2.getAdapter().getCount();
            if (!AUHorizontalListView.this.u || this.f6664a == null || AUHorizontalListView.this.t != 0 || AUHorizontalListView.this.s <= 0) {
                AUHorizontalListView.this.D();
            } else {
                AUHorizontalListView.this.onRestoreInstanceState(this.f6664a);
                this.f6664a = null;
            }
            AUHorizontalListView.this.F();
            AUHorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AUHorizontalListView.this.r = true;
            if (AUHorizontalListView.this.u) {
                this.f6664a = AUHorizontalListView.this.onSaveInstanceState();
            }
            AUHorizontalListView aUHorizontalListView = AUHorizontalListView.this;
            aUHorizontalListView.t = aUHorizontalListView.s;
            AUHorizontalListView.this.s = 0;
            AUHorizontalListView.this.ad = -1;
            AUHorizontalListView.this.ae = Long.MIN_VALUE;
            AUHorizontalListView.this.ab = -1;
            AUHorizontalListView.this.ac = Long.MIN_VALUE;
            AUHorizontalListView.this.S = false;
            AUHorizontalListView.this.F();
            AUHorizontalListView.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class SelectionNotifier implements Runnable {
        private SelectionNotifier() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AUHorizontalListView.this.r) {
                if (AUHorizontalListView.this.j != null) {
                    AUHorizontalListView.this.post(this);
                    return;
                }
                return;
            }
            AUHorizontalListView.this.v();
            AUHorizontalListView.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class WindowRunnnable {

        /* renamed from: a  reason: collision with root package name */
        private int f6668a;

        private WindowRunnnable() {
        }

        public void rememberWindowAttachCount() {
            this.f6668a = AUHorizontalListView.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return AUHorizontalListView.this.hasWindowFocus() && AUHorizontalListView.this.getWindowAttachCount() == this.f6668a;
        }
    }

    /* loaded from: classes6.dex */
    class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;

        private PerformClick() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AUHorizontalListView aUHorizontalListView;
            View childAt;
            if (AUHorizontalListView.this.r) {
                return;
            }
            ListAdapter listAdapter = AUHorizontalListView.this.j;
            int i = this.mClickMotionPosition;
            if (listAdapter == null || AUHorizontalListView.this.s <= 0 || i == -1 || i >= listAdapter.getCount() || !sameWindow() || (childAt = (aUHorizontalListView = AUHorizontalListView.this).getChildAt(i - aUHorizontalListView.w)) == null) {
                return;
            }
            AUHorizontalListView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class CheckForTap implements Runnable {
        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Drawable current;
            if (AUHorizontalListView.this.am != 0) {
                return;
            }
            AUHorizontalListView.this.am = 1;
            AUHorizontalListView aUHorizontalListView = AUHorizontalListView.this;
            View childAt = aUHorizontalListView.getChildAt(aUHorizontalListView.D - AUHorizontalListView.this.w);
            if (childAt == null || childAt.hasFocusable()) {
                return;
            }
            AUHorizontalListView.this.al = 0;
            if (AUHorizontalListView.this.r) {
                AUHorizontalListView.this.am = 2;
                return;
            }
            AUHorizontalListView.this.setPressed(true);
            childAt.setPressed(true);
            AUHorizontalListView.this.x();
            AUHorizontalListView aUHorizontalListView2 = AUHorizontalListView.this;
            aUHorizontalListView2.a(aUHorizontalListView2.D, childAt);
            AUHorizontalListView.this.refreshDrawableState();
            AUHorizontalListView aUHorizontalListView3 = AUHorizontalListView.this;
            aUHorizontalListView3.a(aUHorizontalListView3.D, childAt);
            AUHorizontalListView.this.refreshDrawableState();
            boolean isLongClickable = AUHorizontalListView.this.isLongClickable();
            if (AUHorizontalListView.this.M != null && (current = AUHorizontalListView.this.M.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                if (isLongClickable) {
                    ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                } else {
                    ((TransitionDrawable) current).resetTransition();
                }
            }
            if (isLongClickable) {
                AUHorizontalListView.this.j();
            } else {
                AUHorizontalListView.this.am = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class CheckForLongPress extends WindowRunnnable implements Runnable {
        private CheckForLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = AUHorizontalListView.this.D;
            AUHorizontalListView aUHorizontalListView = AUHorizontalListView.this;
            View childAt = aUHorizontalListView.getChildAt(i - aUHorizontalListView.w);
            if (childAt != null) {
                if ((!sameWindow() || AUHorizontalListView.this.r) ? false : AUHorizontalListView.this.b(childAt, i, AUHorizontalListView.this.j.getItemId(AUHorizontalListView.this.D))) {
                    AUHorizontalListView.this.am = -1;
                    AUHorizontalListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AUHorizontalListView.this.am = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        private CheckForKeyLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (!AUHorizontalListView.this.isPressed() || AUHorizontalListView.this.ad < 0) {
                return;
            }
            View childAt = AUHorizontalListView.this.getChildAt(AUHorizontalListView.this.ad - AUHorizontalListView.this.w);
            if (!AUHorizontalListView.this.r) {
                if (sameWindow()) {
                    AUHorizontalListView aUHorizontalListView = AUHorizontalListView.this;
                    z = aUHorizontalListView.b(childAt, aUHorizontalListView.ad, AUHorizontalListView.this.ae);
                } else {
                    z = false;
                }
                if (z) {
                    AUHorizontalListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                return;
            }
            AUHorizontalListView.this.setPressed(false);
            if (childAt != null) {
                childAt.setPressed(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ListItemAccessibilityDelegate extends AccessibilityDelegateCompat {
        private ListItemAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int positionForView = AUHorizontalListView.this.getPositionForView(view);
            ListAdapter adapter = AUHorizontalListView.this.getAdapter();
            if (positionForView == -1 || adapter == null || !AUHorizontalListView.this.isEnabled() || !adapter.isEnabled(positionForView)) {
                return;
            }
            if (positionForView == AUHorizontalListView.this.getSelectedItemPosition()) {
                accessibilityNodeInfoCompat.GetContactSyncConfig(true);
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(8);
            } else {
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(4);
            }
            if (AUHorizontalListView.this.isClickable()) {
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(16);
                accessibilityNodeInfoCompat.PlaceComponentResult(true);
            }
            if (AUHorizontalListView.this.isLongClickable()) {
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(32);
                accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda2(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            int positionForView = AUHorizontalListView.this.getPositionForView(view);
            ListAdapter adapter = AUHorizontalListView.this.getAdapter();
            if (positionForView != -1 && adapter != null && AUHorizontalListView.this.isEnabled() && adapter.isEnabled(positionForView)) {
                long itemIdAtPosition = AUHorizontalListView.this.getItemIdAtPosition(positionForView);
                if (i != 4) {
                    if (i == 8) {
                        if (AUHorizontalListView.this.getSelectedItemPosition() == positionForView) {
                            AUHorizontalListView.this.setSelection(-1);
                            return true;
                        }
                        return false;
                    } else if (i == 16) {
                        if (AUHorizontalListView.this.isClickable()) {
                            return AUHorizontalListView.this.performItemClick(view, positionForView, itemIdAtPosition);
                        }
                        return false;
                    } else if (i == 32 && AUHorizontalListView.this.isLongClickable()) {
                        return AUHorizontalListView.this.b(view, positionForView, itemIdAtPosition);
                    } else {
                        return false;
                    }
                } else if (AUHorizontalListView.this.getSelectedItemPosition() != positionForView) {
                    AUHorizontalListView.this.setSelection(positionForView);
                    return true;
                }
            }
            return false;
        }
    }
}
