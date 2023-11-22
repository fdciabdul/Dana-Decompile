package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes2.dex */
public class GridLayoutManager extends LinearLayoutManager {
    final Rect BuiltInFictitiousFunctionClassFactory;
    int[] KClassImpl$Data$declaredNonStaticMembers$2;
    final SparseIntArray MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    final SparseIntArray getAuthRequestContext;
    public int getErrorConfigVersion;
    View[] lookAheadTest;
    public SpanSizeLookup moveToNextValue;
    private boolean scheduleImpl;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.PlaceComponentResult = false;
        this.getErrorConfigVersion = -1;
        this.getAuthRequestContext = new SparseIntArray();
        this.MyBillsEntityDataFactory = new SparseIntArray();
        this.moveToNextValue = new DefaultSpanSizeLookup();
        this.BuiltInFictitiousFunctionClassFactory = new Rect();
        PlaceComponentResult(getProperties(context, attributeSet, i, i2).MyBillsEntityDataFactory);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.PlaceComponentResult = false;
        this.getErrorConfigVersion = -1;
        this.getAuthRequestContext = new SparseIntArray();
        this.MyBillsEntityDataFactory = new SparseIntArray();
        this.moveToNextValue = new DefaultSpanSizeLookup();
        this.BuiltInFictitiousFunctionClassFactory = new Rect();
        PlaceComponentResult(i);
    }

    public GridLayoutManager(Context context, int i, byte b) {
        super(context, 1, false);
        this.PlaceComponentResult = false;
        this.getErrorConfigVersion = -1;
        this.getAuthRequestContext = new SparseIntArray();
        this.MyBillsEntityDataFactory = new SparseIntArray();
        this.moveToNextValue = new DefaultSpanSizeLookup();
        this.BuiltInFictitiousFunctionClassFactory = new Rect();
        PlaceComponentResult(i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        if (this.mOrientation == 0) {
            return this.getErrorConfigVersion;
        }
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i = state.scheduleImpl;
        }
        if (i <= 0) {
            return 0;
        }
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i2 = state.scheduleImpl;
        }
        return PlaceComponentResult(recycler, state, i2 - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        if (this.mOrientation == 1) {
            return this.getErrorConfigVersion;
        }
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i = state.scheduleImpl;
        }
        if (i <= 0) {
            return 0;
        }
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i2 = state.scheduleImpl;
        }
        return PlaceComponentResult(recycler, state, i2 - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int PlaceComponentResult = PlaceComponentResult(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.MyBillsEntityDataFactory(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.PlaceComponentResult(layoutParams2.MyBillsEntityDataFactory, layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.MyBillsEntityDataFactory(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.PlaceComponentResult(PlaceComponentResult, 1, layoutParams2.MyBillsEntityDataFactory, layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                this.getAuthRequestContext.put(viewLayoutPosition, layoutParams.KClassImpl$Data$declaredNonStaticMembers$2);
                this.MyBillsEntityDataFactory.put(viewLayoutPosition, layoutParams.MyBillsEntityDataFactory);
            }
        }
        super.onLayoutChildren(recycler, state);
        this.getAuthRequestContext.clear();
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.PlaceComponentResult = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.clear();
        this.moveToNextValue.getAuthRequestContext.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.clear();
        this.moveToNextValue.getAuthRequestContext.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.clear();
        this.moveToNextValue.getAuthRequestContext.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.clear();
        this.moveToNextValue.getAuthRequestContext.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.clear();
        this.moveToNextValue.getAuthRequestContext.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private void getAuthRequestContext() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        getAuthRequestContext(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            chooseSize = chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            chooseSize2 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    private void getAuthRequestContext(int i) {
        int i2;
        int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = this.getErrorConfigVersion;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
    }

    private int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = this.getErrorConfigVersion - i;
            return iArr[i3] - iArr[i3 - i2];
        }
        int[] iArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return iArr2[i2 + i] - iArr2[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        int i2;
        int i3;
        int i4;
        int authRequestContext;
        super.onAnchorReady(recycler, state, anchorInfo, i);
        getAuthRequestContext();
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i2 = state.scheduleImpl;
        }
        if (i2 > 0 && !state.KClassImpl$Data$declaredNonStaticMembers$2()) {
            boolean z = i == 1;
            int authRequestContext2 = getAuthRequestContext(recycler, state, anchorInfo.getAuthRequestContext);
            if (z) {
                while (authRequestContext2 > 0 && anchorInfo.getAuthRequestContext > 0) {
                    anchorInfo.getAuthRequestContext--;
                    authRequestContext2 = getAuthRequestContext(recycler, state, anchorInfo.getAuthRequestContext);
                }
            } else {
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i3 = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i3 = state.scheduleImpl;
                }
                int i5 = anchorInfo.getAuthRequestContext;
                while (i5 < i3 - 1 && (authRequestContext = getAuthRequestContext(recycler, state, (i4 = i5 + 1))) > authRequestContext2) {
                    i5 = i4;
                    authRequestContext2 = authRequestContext;
                }
                anchorInfo.getAuthRequestContext = i5;
            }
        }
        View[] viewArr = this.lookAheadTest;
        if (viewArr == null || viewArr.length != this.getErrorConfigVersion) {
            this.lookAheadTest = new View[this.getErrorConfigVersion];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        getAuthRequestContext();
        View[] viewArr = this.lookAheadTest;
        if (viewArr == null || viewArr.length != this.getErrorConfigVersion) {
            this.lookAheadTest = new View[this.getErrorConfigVersion];
        }
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        getAuthRequestContext();
        View[] viewArr = this.lookAheadTest;
        if (viewArr == null || viewArr.length != this.getErrorConfigVersion) {
            this.lookAheadTest = new View[this.getErrorConfigVersion];
        }
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i;
        int i2;
        int childCount = getChildCount();
        int i3 = 1;
        int i4 = -1;
        if (z2) {
            i = getChildCount() - 1;
            i3 = -1;
        } else {
            i4 = childCount;
            i = 0;
        }
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i2 = state.scheduleImpl;
        }
        ensureLayoutState();
        int moveToNextValue = this.mOrientationHelper.moveToNextValue();
        int authRequestContext = this.mOrientationHelper.getAuthRequestContext();
        View view = null;
        View view2 = null;
        while (i != i4) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i2 && getAuthRequestContext(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getAuthRequestContext(childAt) < authRequestContext && this.mOrientationHelper.PlaceComponentResult(childAt) >= moveToNextValue) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i3;
        }
        return view == null ? view2 : view;
    }

    private int PlaceComponentResult(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(i, this.getErrorConfigVersion);
        }
        int PlaceComponentResult = recycler.PlaceComponentResult(i);
        if (PlaceComponentResult == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find span size for pre layout position. ");
            sb.append(i);
            InstrumentInjector.log_w("GridLayoutManager", sb.toString());
            return 0;
        }
        return this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, this.getErrorConfigVersion);
    }

    private int getAuthRequestContext(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return this.moveToNextValue.MyBillsEntityDataFactory(i, this.getErrorConfigVersion);
        }
        int i2 = this.MyBillsEntityDataFactory.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int PlaceComponentResult = recycler.PlaceComponentResult(i);
        if (PlaceComponentResult == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            sb.append(i);
            InstrumentInjector.log_w("GridLayoutManager", sb.toString());
            return 0;
        }
        return this.moveToNextValue.MyBillsEntityDataFactory(PlaceComponentResult, this.getErrorConfigVersion);
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return this.moveToNextValue.PlaceComponentResult(i);
        }
        int i2 = this.getAuthRequestContext.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int PlaceComponentResult = recycler.PlaceComponentResult(i);
        if (PlaceComponentResult == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            sb.append(i);
            InstrumentInjector.log_w("GridLayoutManager", sb.toString());
            return 1;
        }
        return this.moveToNextValue.PlaceComponentResult(PlaceComponentResult);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.getErrorConfigVersion;
        for (int i2 = 0; i2 < this.getErrorConfigVersion && layoutState.MyBillsEntityDataFactory(state) && i > 0; i2++) {
            int i3 = layoutState.PlaceComponentResult;
            layoutPrefetchRegistry.BuiltInFictitiousFunctionClassFactory(i3, Math.max(0, layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2));
            i -= this.moveToNextValue.PlaceComponentResult(i3);
            layoutState.PlaceComponentResult += layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
    
        r23.getAuthRequestContext = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009f, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void layoutChunk(androidx.recyclerview.widget.RecyclerView.Recycler r20, androidx.recyclerview.widget.RecyclerView.State r21, androidx.recyclerview.widget.LinearLayoutManager.LayoutState r22, androidx.recyclerview.widget.LinearLayoutManager.LayoutChunkResult r23) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, androidx.recyclerview.widget.LinearLayoutManager$LayoutState, androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult):void");
    }

    private void MyBillsEntityDataFactory(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(layoutParams.MyBillsEntityDataFactory, layoutParams.KClassImpl$Data$declaredNonStaticMembers$2);
        if (this.mOrientation == 1) {
            i3 = getChildMeasureSpec(BuiltInFictitiousFunctionClassFactory, i, i5, layoutParams.width, false);
            i2 = getChildMeasureSpec(this.mOrientationHelper.scheduleImpl(), getHeightMode(), i4, layoutParams.height, true);
        } else {
            int childMeasureSpec = getChildMeasureSpec(BuiltInFictitiousFunctionClassFactory, i, i4, layoutParams.height, false);
            int childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.scheduleImpl(), getWidthMode(), i5, layoutParams.width, true);
            i2 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        BuiltInFictitiousFunctionClassFactory(view, i3, i2, z);
    }

    private void BuiltInFictitiousFunctionClassFactory(View view, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, i, i2, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, i, i2, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(i, i2);
        }
    }

    public final void PlaceComponentResult(int i) {
        if (i == this.getErrorConfigVersion) {
            return;
        }
        this.PlaceComponentResult = true;
        if (i <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Span count should be at least 1. Provided ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        this.getErrorConfigVersion = i;
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.clear();
        requestLayout();
    }

    /* loaded from: classes3.dex */
    public static abstract class SpanSizeLookup {
        final SparseIntArray BuiltInFictitiousFunctionClassFactory = new SparseIntArray();
        final SparseIntArray getAuthRequestContext = new SparseIntArray();
        private boolean PlaceComponentResult = false;
        private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;

        public abstract int PlaceComponentResult(int i);

        final int MyBillsEntityDataFactory(int i, int i2) {
            if (!this.PlaceComponentResult) {
                return PlaceComponentResult(i, i2);
            }
            int i3 = this.BuiltInFictitiousFunctionClassFactory.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int PlaceComponentResult = PlaceComponentResult(i, i2);
            this.BuiltInFictitiousFunctionClassFactory.put(i, PlaceComponentResult);
            return PlaceComponentResult;
        }

        final int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return BuiltInFictitiousFunctionClassFactory(i, i2);
            }
            int i3 = this.getAuthRequestContext.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i, i2);
            this.getAuthRequestContext.put(i, BuiltInFictitiousFunctionClassFactory);
            return BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002d -> B:17:0x0032). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002f -> B:17:0x0032). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:17:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int PlaceComponentResult(int r7, int r8) {
            /*
                r6 = this;
                int r0 = r6.PlaceComponentResult(r7)
                r1 = 0
                if (r0 != r8) goto L8
                return r1
            L8:
                boolean r2 = r6.PlaceComponentResult
                if (r2 == 0) goto L21
                android.util.SparseIntArray r2 = r6.BuiltInFictitiousFunctionClassFactory
                int r2 = getAuthRequestContext(r2, r7)
                if (r2 < 0) goto L21
                android.util.SparseIntArray r3 = r6.BuiltInFictitiousFunctionClassFactory
                int r3 = r3.get(r2)
                int r4 = r6.PlaceComponentResult(r2)
                int r3 = r3 + r4
                r4 = r6
                goto L32
            L21:
                r4 = r6
                r2 = 0
                r3 = 0
            L24:
                if (r2 >= r7) goto L35
                int r5 = r4.PlaceComponentResult(r2)
                int r3 = r3 + r5
                if (r3 != r8) goto L2f
                r3 = 0
                goto L32
            L2f:
                if (r3 <= r8) goto L32
                r3 = r5
            L32:
                int r2 = r2 + 1
                goto L24
            L35:
                int r0 = r0 + r3
                if (r0 > r8) goto L39
                return r3
            L39:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.PlaceComponentResult(int, int):int");
        }

        private static int getAuthRequestContext(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int BuiltInFictitiousFunctionClassFactory(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2
                r1 = 0
                if (r0 == 0) goto L24
                android.util.SparseIntArray r0 = r6.getAuthRequestContext
                int r0 = getAuthRequestContext(r0, r7)
                r2 = -1
                if (r0 == r2) goto L24
                android.util.SparseIntArray r2 = r6.getAuthRequestContext
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.MyBillsEntityDataFactory(r0, r8)
                int r0 = r6.PlaceComponentResult(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L27
                int r2 = r2 + 1
                goto L26
            L24:
                r2 = 0
                r3 = 0
            L26:
                r4 = 0
            L27:
                int r0 = r6.PlaceComponentResult(r7)
            L2b:
                if (r3 >= r7) goto L40
                int r5 = r6.PlaceComponentResult(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L38
                int r2 = r2 + 1
                r4 = 0
                goto L3d
            L38:
                if (r4 <= r8) goto L3d
                int r2 = r2 + 1
                r4 = r5
            L3d:
                int r3 = r3 + 1
                goto L2b
            L40:
                int r4 = r4 + r0
                if (r4 <= r8) goto L45
                int r2 = r2 + 1
            L45:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.BuiltInFictitiousFunctionClassFactory(int, int):int");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d4, code lost:
    
        if (r13 == (r2 > r15)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f3, code lost:
    
        if (r13 != (r2 > r11)) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0106  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.Recycler r25, androidx.recyclerview.widget.RecyclerView.State r26) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.PlaceComponentResult;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.scheduleImpl) {
            return getAuthRequestContext(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.scheduleImpl) {
            return getAuthRequestContext(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.scheduleImpl) {
            return BuiltInFictitiousFunctionClassFactory(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.scheduleImpl) {
            return BuiltInFictitiousFunctionClassFactory(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    private int getAuthRequestContext(RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        if (getChildCount() != 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i != 0) {
                ensureLayoutState();
                View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
                View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
                if (findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null) {
                    return 0;
                }
                if (!isSmoothScrollbarEnabled()) {
                    SpanSizeLookup spanSizeLookup = this.moveToNextValue;
                    if (state.BuiltInFictitiousFunctionClassFactory) {
                        i3 = state.getErrorConfigVersion - state.PlaceComponentResult;
                    } else {
                        i3 = state.scheduleImpl;
                    }
                    return spanSizeLookup.KClassImpl$Data$declaredNonStaticMembers$2(i3 - 1, this.getErrorConfigVersion) + 1;
                }
                int PlaceComponentResult = this.mOrientationHelper.PlaceComponentResult(findFirstVisibleChildClosestToEnd);
                int authRequestContext = this.mOrientationHelper.getAuthRequestContext(findFirstVisibleChildClosestToStart);
                int KClassImpl$Data$declaredNonStaticMembers$2 = this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(getPosition(findFirstVisibleChildClosestToStart), this.getErrorConfigVersion);
                int KClassImpl$Data$declaredNonStaticMembers$22 = this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(getPosition(findFirstVisibleChildClosestToEnd), this.getErrorConfigVersion);
                SpanSizeLookup spanSizeLookup2 = this.moveToNextValue;
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i2 = state.scheduleImpl;
                }
                return (int) (((PlaceComponentResult - authRequestContext) / ((KClassImpl$Data$declaredNonStaticMembers$22 - KClassImpl$Data$declaredNonStaticMembers$2) + 1)) * (spanSizeLookup2.KClassImpl$Data$declaredNonStaticMembers$2(i2 - 1, this.getErrorConfigVersion) + 1));
            }
            return 0;
        }
        return 0;
    }

    private int BuiltInFictitiousFunctionClassFactory(RecyclerView.State state) {
        int i;
        int i2;
        int max;
        if (getChildCount() != 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i != 0) {
                ensureLayoutState();
                boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
                boolean z = !isSmoothScrollbarEnabled;
                View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(z, true);
                View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(z, true);
                if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                    int KClassImpl$Data$declaredNonStaticMembers$2 = this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(getPosition(findFirstVisibleChildClosestToStart), this.getErrorConfigVersion);
                    int KClassImpl$Data$declaredNonStaticMembers$22 = this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(getPosition(findFirstVisibleChildClosestToEnd), this.getErrorConfigVersion);
                    int min = Math.min(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22);
                    int max2 = Math.max(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22);
                    SpanSizeLookup spanSizeLookup = this.moveToNextValue;
                    if (state.BuiltInFictitiousFunctionClassFactory) {
                        i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
                    } else {
                        i2 = state.scheduleImpl;
                    }
                    int KClassImpl$Data$declaredNonStaticMembers$23 = spanSizeLookup.KClassImpl$Data$declaredNonStaticMembers$2(i2 - 1, this.getErrorConfigVersion);
                    if (this.mShouldReverseLayout) {
                        max = Math.max(0, ((KClassImpl$Data$declaredNonStaticMembers$23 + 1) - max2) - 1);
                    } else {
                        max = Math.max(0, min);
                    }
                    if (isSmoothScrollbarEnabled) {
                        return Math.round((max * (Math.abs(this.mOrientationHelper.PlaceComponentResult(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getAuthRequestContext(findFirstVisibleChildClosestToStart)) / ((this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(getPosition(findFirstVisibleChildClosestToEnd), this.getErrorConfigVersion) - this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(getPosition(findFirstVisibleChildClosestToStart), this.getErrorConfigVersion)) + 1))) + (this.mOrientationHelper.moveToNextValue() - this.mOrientationHelper.getAuthRequestContext(findFirstVisibleChildClosestToStart)));
                    }
                    return max;
                }
            }
        }
        return 0;
    }

    /* loaded from: classes3.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public final int PlaceComponentResult(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public final int PlaceComponentResult(int i, int i2) {
            return i % i2;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.MyBillsEntityDataFactory = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.MyBillsEntityDataFactory = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.MyBillsEntityDataFactory = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.MyBillsEntityDataFactory = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
    }
}
