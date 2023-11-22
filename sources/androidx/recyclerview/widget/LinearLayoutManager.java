package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.PlaceComponentResult);
        setReverseLayout(properties.KClassImpl$Data$declaredNonStaticMembers$2);
        setStackFromEnd(properties.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.PlaceComponentResult.clear();
            recycler.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.getAuthRequestContext = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.PlaceComponentResult = this.mOrientationHelper.getAuthRequestContext() - this.mOrientationHelper.PlaceComponentResult(childClosestToEnd);
                savedState.KClassImpl$Data$declaredNonStaticMembers$2 = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.KClassImpl$Data$declaredNonStaticMembers$2 = getPosition(childClosestToStart);
                savedState.PlaceComponentResult = this.mOrientationHelper.getAuthRequestContext(childClosestToStart) - this.mOrientationHelper.moveToNextValue();
            }
        } else {
            savedState.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid orientation:");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            OrientationHelper PlaceComponentResult = OrientationHelper.PlaceComponentResult(this, i);
            this.mOrientationHelper = PlaceComponentResult;
            this.mAnchorInfo.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
            this.mOrientation = i;
            requestLayout();
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.PlaceComponentResult()) {
            return this.mOrientationHelper.scheduleImpl();
        }
        return 0;
    }

    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.moveToNextValue == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        if (this.mOrientation == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int fixLayoutEndGap;
        int i6;
        View findViewByPosition;
        int authRequestContext;
        int i7;
        if (this.mPendingSavedState != null || this.mPendingScrollPosition != -1) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i == 0) {
                removeAndRecycleAllViews(recycler);
                return;
            }
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.PlaceComponentResult()) {
            this.mPendingScrollPosition = this.mPendingSavedState.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        ensureLayoutState();
        this.mLayoutState.DatabaseTableConfigUtil = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.PlaceComponentResult || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            AnchorInfo anchorInfo = this.mAnchorInfo;
            anchorInfo.getAuthRequestContext = -1;
            anchorInfo.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
            anchorInfo.MyBillsEntityDataFactory = false;
            anchorInfo.PlaceComponentResult = false;
            this.mAnchorInfo.MyBillsEntityDataFactory = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, this.mAnchorInfo);
            this.mAnchorInfo.PlaceComponentResult = true;
        } else if (focusedChild != null && (this.mOrientationHelper.getAuthRequestContext(focusedChild) >= this.mOrientationHelper.getAuthRequestContext() || this.mOrientationHelper.PlaceComponentResult(focusedChild) <= this.mOrientationHelper.moveToNextValue())) {
            this.mAnchorInfo.PlaceComponentResult(focusedChild, getPosition(focusedChild));
        }
        LayoutState layoutState = this.mLayoutState;
        layoutState.moveToNextValue = layoutState.lookAheadTest >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.moveToNextValue();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.PlaceComponentResult();
        if (state.KClassImpl$Data$declaredNonStaticMembers$2() && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.getAuthRequestContext() - this.mOrientationHelper.PlaceComponentResult(findViewByPosition);
                authRequestContext = this.mPendingScrollPositionOffset;
            } else {
                authRequestContext = this.mOrientationHelper.getAuthRequestContext(findViewByPosition) - this.mOrientationHelper.moveToNextValue();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i8 = i7 - authRequestContext;
            if (i8 > 0) {
                max += i8;
            } else {
                max2 -= i8;
            }
        }
        onAnchorReady(recycler, state, this.mAnchorInfo, (!this.mAnchorInfo.MyBillsEntityDataFactory ? this.mShouldReverseLayout : !this.mShouldReverseLayout) ? 1 : -1);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.MyBillsEntityDataFactory = resolveIsInfinite();
        this.mLayoutState.KClassImpl$Data$declaredNonStaticMembers$2 = state.KClassImpl$Data$declaredNonStaticMembers$2();
        this.mLayoutState.scheduleImpl = 0;
        if (this.mAnchorInfo.MyBillsEntityDataFactory) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.getAuthRequestContext = max;
            fill(recycler, this.mLayoutState, state, false);
            i3 = this.mLayoutState.getErrorConfigVersion;
            int i9 = this.mLayoutState.PlaceComponentResult;
            if (this.mLayoutState.BuiltInFictitiousFunctionClassFactory > 0) {
                max2 += this.mLayoutState.BuiltInFictitiousFunctionClassFactory;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.getAuthRequestContext = max2;
            this.mLayoutState.PlaceComponentResult += this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0;
            fill(recycler, this.mLayoutState, state, false);
            i2 = this.mLayoutState.getErrorConfigVersion;
            if (this.mLayoutState.BuiltInFictitiousFunctionClassFactory > 0) {
                int i10 = this.mLayoutState.BuiltInFictitiousFunctionClassFactory;
                updateLayoutStateToFillStart(i9, i3);
                this.mLayoutState.getAuthRequestContext = i10;
                fill(recycler, this.mLayoutState, state, false);
                i3 = this.mLayoutState.getErrorConfigVersion;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.getAuthRequestContext = max2;
            fill(recycler, this.mLayoutState, state, false);
            i2 = this.mLayoutState.getErrorConfigVersion;
            int i11 = this.mLayoutState.PlaceComponentResult;
            if (this.mLayoutState.BuiltInFictitiousFunctionClassFactory > 0) {
                max += this.mLayoutState.BuiltInFictitiousFunctionClassFactory;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.getAuthRequestContext = max;
            this.mLayoutState.PlaceComponentResult += this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0;
            fill(recycler, this.mLayoutState, state, false);
            i3 = this.mLayoutState.getErrorConfigVersion;
            if (this.mLayoutState.BuiltInFictitiousFunctionClassFactory > 0) {
                int i12 = this.mLayoutState.BuiltInFictitiousFunctionClassFactory;
                updateLayoutStateToFillEnd(i11, i2);
                this.mLayoutState.getAuthRequestContext = i12;
                fill(recycler, this.mLayoutState, state, false);
                i2 = this.mLayoutState.getErrorConfigVersion;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i2, recycler, state, true);
                i4 = i3 + fixLayoutEndGap2;
                i5 = i2 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i4, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i3, recycler, state, true);
                i4 = i3 + fixLayoutStartGap;
                i5 = i2 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i5, recycler, state, false);
            }
            i3 = i4 + fixLayoutEndGap;
            i2 = i5 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recycler, state, i3, i2);
        if (!state.KClassImpl$Data$declaredNonStaticMembers$2()) {
            OrientationHelper orientationHelper = this.mOrientationHelper;
            orientationHelper.PlaceComponentResult = orientationHelper.scheduleImpl();
        } else {
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            anchorInfo2.getAuthRequestContext = -1;
            anchorInfo2.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
            anchorInfo2.MyBillsEntityDataFactory = false;
            anchorInfo2.PlaceComponentResult = false;
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        AnchorInfo anchorInfo = this.mAnchorInfo;
        anchorInfo.getAuthRequestContext = -1;
        anchorInfo.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
        anchorInfo.MyBillsEntityDataFactory = false;
        anchorInfo.PlaceComponentResult = false;
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        if (!state.getAuthRequestContext() || getChildCount() == 0 || state.KClassImpl$Data$declaredNonStaticMembers$2() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.ViewHolder> list = recycler.moveToNextValue;
        int size = list.size();
        int position = getPosition(getChildAt(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.ViewHolder viewHolder = list.get(i5);
            if (!viewHolder.isRemoved()) {
                if (((viewHolder.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.mOrientationHelper.MyBillsEntityDataFactory(viewHolder.itemView);
                } else {
                    i4 += this.mOrientationHelper.MyBillsEntityDataFactory(viewHolder.itemView);
                }
            }
        }
        this.mLayoutState.initRecordTimeStamp = list;
        if (i3 > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            this.mLayoutState.getAuthRequestContext = i3;
            this.mLayoutState.BuiltInFictitiousFunctionClassFactory = 0;
            this.mLayoutState.getAuthRequestContext(null);
            fill(recycler, this.mLayoutState, state, false);
        }
        if (i4 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            this.mLayoutState.getAuthRequestContext = i4;
            this.mLayoutState.BuiltInFictitiousFunctionClassFactory = 0;
            this.mLayoutState.getAuthRequestContext(null);
            fill(recycler, this.mLayoutState, state, false);
        }
        this.mLayoutState.initRecordTimeStamp = null;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int moveToNextValue;
        int i;
        int i2;
        if (updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(recycler, state, anchorInfo)) {
            return;
        }
        if (anchorInfo.MyBillsEntityDataFactory) {
            moveToNextValue = anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
        } else {
            moveToNextValue = anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
        }
        anchorInfo.BuiltInFictitiousFunctionClassFactory = moveToNextValue;
        if (this.mStackFromEnd) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i2 = state.scheduleImpl;
            }
            i = i2 - 1;
        } else {
            i = 0;
        }
        anchorInfo.getAuthRequestContext = i;
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View findReferenceChild;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && AnchorInfo.getAuthRequestContext(focusedChild, state)) {
            anchorInfo.PlaceComponentResult(focusedChild, getPosition(focusedChild));
            return true;
        } else if (this.mLastStackFromEnd == this.mStackFromEnd && (findReferenceChild = findReferenceChild(recycler, state, anchorInfo.MyBillsEntityDataFactory, this.mStackFromEnd)) != null) {
            anchorInfo.MyBillsEntityDataFactory(findReferenceChild, getPosition(findReferenceChild));
            if (!state.KClassImpl$Data$declaredNonStaticMembers$2() && supportsPredictiveItemAnimations()) {
                int authRequestContext = this.mOrientationHelper.getAuthRequestContext(findReferenceChild);
                int PlaceComponentResult = this.mOrientationHelper.PlaceComponentResult(findReferenceChild);
                int moveToNextValue = this.mOrientationHelper.moveToNextValue();
                int authRequestContext2 = this.mOrientationHelper.getAuthRequestContext();
                boolean z2 = PlaceComponentResult <= moveToNextValue && authRequestContext < moveToNextValue;
                if (authRequestContext >= authRequestContext2 && PlaceComponentResult > authRequestContext2) {
                    z = true;
                }
                if (z2 || z) {
                    if (anchorInfo.MyBillsEntityDataFactory) {
                        moveToNextValue = authRequestContext2;
                    }
                    anchorInfo.BuiltInFictitiousFunctionClassFactory = moveToNextValue;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        int i2;
        int moveToNextValue;
        int authRequestContext;
        int moveToNextValue2;
        if (!state.KClassImpl$Data$declaredNonStaticMembers$2() && (i = this.mPendingScrollPosition) != -1) {
            if (i >= 0) {
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i2 = state.scheduleImpl;
                }
                if (i < i2) {
                    anchorInfo.getAuthRequestContext = this.mPendingScrollPosition;
                    SavedState savedState = this.mPendingSavedState;
                    if (savedState != null && savedState.PlaceComponentResult()) {
                        anchorInfo.MyBillsEntityDataFactory = this.mPendingSavedState.getAuthRequestContext;
                        if (anchorInfo.MyBillsEntityDataFactory) {
                            anchorInfo.BuiltInFictitiousFunctionClassFactory = this.mOrientationHelper.getAuthRequestContext() - this.mPendingSavedState.PlaceComponentResult;
                        } else {
                            anchorInfo.BuiltInFictitiousFunctionClassFactory = this.mOrientationHelper.moveToNextValue() + this.mPendingSavedState.PlaceComponentResult;
                        }
                        return true;
                    } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                        View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                        if (findViewByPosition != null) {
                            if (this.mOrientationHelper.MyBillsEntityDataFactory(findViewByPosition) <= this.mOrientationHelper.scheduleImpl()) {
                                if (this.mOrientationHelper.getAuthRequestContext(findViewByPosition) - this.mOrientationHelper.moveToNextValue() < 0) {
                                    anchorInfo.BuiltInFictitiousFunctionClassFactory = this.mOrientationHelper.moveToNextValue();
                                    anchorInfo.MyBillsEntityDataFactory = false;
                                    return true;
                                } else if (this.mOrientationHelper.getAuthRequestContext() - this.mOrientationHelper.PlaceComponentResult(findViewByPosition) < 0) {
                                    anchorInfo.BuiltInFictitiousFunctionClassFactory = this.mOrientationHelper.getAuthRequestContext();
                                    anchorInfo.MyBillsEntityDataFactory = true;
                                    return true;
                                } else {
                                    if (anchorInfo.MyBillsEntityDataFactory) {
                                        int PlaceComponentResult = this.mOrientationHelper.PlaceComponentResult(findViewByPosition);
                                        OrientationHelper orientationHelper = this.mOrientationHelper;
                                        authRequestContext = PlaceComponentResult + (Integer.MIN_VALUE != orientationHelper.PlaceComponentResult ? orientationHelper.scheduleImpl() - orientationHelper.PlaceComponentResult : 0);
                                    } else {
                                        authRequestContext = this.mOrientationHelper.getAuthRequestContext(findViewByPosition);
                                    }
                                    anchorInfo.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                                }
                            } else {
                                if (anchorInfo.MyBillsEntityDataFactory) {
                                    moveToNextValue2 = anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                                } else {
                                    moveToNextValue2 = anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
                                }
                                anchorInfo.BuiltInFictitiousFunctionClassFactory = moveToNextValue2;
                                return true;
                            }
                        } else {
                            if (getChildCount() > 0) {
                                anchorInfo.MyBillsEntityDataFactory = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                            }
                            if (anchorInfo.MyBillsEntityDataFactory) {
                                moveToNextValue = anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                            } else {
                                moveToNextValue = anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
                            }
                            anchorInfo.BuiltInFictitiousFunctionClassFactory = moveToNextValue;
                        }
                        return true;
                    } else {
                        anchorInfo.MyBillsEntityDataFactory = this.mShouldReverseLayout;
                        if (this.mShouldReverseLayout) {
                            anchorInfo.BuiltInFictitiousFunctionClassFactory = this.mOrientationHelper.getAuthRequestContext() - this.mPendingScrollPositionOffset;
                        } else {
                            anchorInfo.BuiltInFictitiousFunctionClassFactory = this.mOrientationHelper.moveToNextValue() + this.mPendingScrollPositionOffset;
                        }
                        return true;
                    }
                }
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int authRequestContext;
        int authRequestContext2 = this.mOrientationHelper.getAuthRequestContext() - i;
        if (authRequestContext2 > 0) {
            int i2 = -scrollBy(-authRequestContext2, recycler, state);
            if (!z || (authRequestContext = this.mOrientationHelper.getAuthRequestContext() - (i + i2)) <= 0) {
                return i2;
            }
            this.mOrientationHelper.PlaceComponentResult(authRequestContext);
            return authRequestContext + i2;
        }
        return 0;
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int moveToNextValue;
        int moveToNextValue2 = i - this.mOrientationHelper.moveToNextValue();
        if (moveToNextValue2 > 0) {
            int i2 = -scrollBy(moveToNextValue2, recycler, state);
            if (!z || (moveToNextValue = (i + i2) - this.mOrientationHelper.moveToNextValue()) <= 0) {
                return i2;
            }
            this.mOrientationHelper.PlaceComponentResult(-moveToNextValue);
            return i2 - moveToNextValue;
        }
        return 0;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.getAuthRequestContext, anchorInfo.BuiltInFictitiousFunctionClassFactory);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.BuiltInFictitiousFunctionClassFactory = this.mOrientationHelper.getAuthRequestContext() - i2;
        this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.mShouldReverseLayout ? -1 : 1;
        this.mLayoutState.PlaceComponentResult = i;
        this.mLayoutState.moveToNextValue = 1;
        this.mLayoutState.getErrorConfigVersion = i2;
        this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.getAuthRequestContext, anchorInfo.BuiltInFictitiousFunctionClassFactory);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.BuiltInFictitiousFunctionClassFactory = i2 - this.mOrientationHelper.moveToNextValue();
        this.mLayoutState.PlaceComponentResult = i;
        this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.mShouldReverseLayout ? 1 : -1;
        this.mLayoutState.moveToNextValue = -1;
        this.mLayoutState.getErrorConfigVersion = i2;
        this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.KClassImpl$Data$declaredNonStaticMembers$2(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.BuiltInFictitiousFunctionClassFactory(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.PlaceComponentResult(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.State state) {
        int moveToNextValue;
        this.mLayoutState.MyBillsEntityDataFactory = resolveIsInfinite();
        this.mLayoutState.moveToNextValue = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i == 1;
        this.mLayoutState.getAuthRequestContext = z2 ? max2 : max;
        LayoutState layoutState = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        layoutState.scheduleImpl = max;
        if (z2) {
            this.mLayoutState.getAuthRequestContext += this.mOrientationHelper.PlaceComponentResult();
            View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.mShouldReverseLayout ? -1 : 1;
            this.mLayoutState.PlaceComponentResult = getPosition(childClosestToEnd) + this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.mLayoutState.getErrorConfigVersion = this.mOrientationHelper.PlaceComponentResult(childClosestToEnd);
            moveToNextValue = this.mOrientationHelper.PlaceComponentResult(childClosestToEnd) - this.mOrientationHelper.getAuthRequestContext();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.getAuthRequestContext += this.mOrientationHelper.moveToNextValue();
            this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.mShouldReverseLayout ? 1 : -1;
            this.mLayoutState.PlaceComponentResult = getPosition(childClosestToStart) + this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.mLayoutState.getErrorConfigVersion = this.mOrientationHelper.getAuthRequestContext(childClosestToStart);
            moveToNextValue = (-this.mOrientationHelper.getAuthRequestContext(childClosestToStart)) + this.mOrientationHelper.moveToNextValue();
        }
        this.mLayoutState.BuiltInFictitiousFunctionClassFactory = i2;
        if (z) {
            this.mLayoutState.BuiltInFictitiousFunctionClassFactory -= moveToNextValue;
        }
        this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 = moveToNextValue;
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.KClassImpl$Data$declaredNonStaticMembers$2() == 0 && this.mOrientationHelper.MyBillsEntityDataFactory() == 0;
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i;
        int i2 = layoutState.PlaceComponentResult;
        if (i2 >= 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i2 < i) {
                layoutPrefetchRegistry.BuiltInFictitiousFunctionClassFactory(i2, Math.max(0, layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.PlaceComponentResult()) {
            z = this.mPendingSavedState.getAuthRequestContext;
            i2 = this.mPendingSavedState.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.BuiltInFictitiousFunctionClassFactory(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, state);
        collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
    }

    int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.DatabaseTableConfigUtil = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, state);
        int fill = this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 + fill(recycler, this.mLayoutState, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.PlaceComponentResult(-i);
        this.mLayoutState.lookAheadTest = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
            return;
        }
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            removeAndRecycleViewAt(i2, recycler);
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.PlaceComponentResult(childAt) > i3 || this.mOrientationHelper.BuiltInFictitiousFunctionClassFactory(childAt) > i3) {
                    recycleChildren(recycler, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.PlaceComponentResult(childAt2) > i3 || this.mOrientationHelper.BuiltInFictitiousFunctionClassFactory(childAt2) > i3) {
                recycleChildren(recycler, i5, i6);
                return;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int MyBillsEntityDataFactory = (this.mOrientationHelper.MyBillsEntityDataFactory() - i) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.getAuthRequestContext(childAt) < MyBillsEntityDataFactory || this.mOrientationHelper.moveToNextValue(childAt) < MyBillsEntityDataFactory) {
                    recycleChildren(recycler, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.getAuthRequestContext(childAt2) < MyBillsEntityDataFactory || this.mOrientationHelper.moveToNextValue(childAt2) < MyBillsEntityDataFactory) {
                recycleChildren(recycler, i4, i5);
                return;
            }
        }
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.DatabaseTableConfigUtil || layoutState.MyBillsEntityDataFactory) {
            return;
        }
        int i = layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int i2 = layoutState.scheduleImpl;
        if (layoutState.moveToNextValue == -1) {
            recycleViewsFromEnd(recycler, i, i2);
        } else {
            recycleViewsFromStart(recycler, i, i2);
        }
    }

    int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        int i = layoutState.BuiltInFictitiousFunctionClassFactory;
        if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 != Integer.MIN_VALUE) {
            if (layoutState.BuiltInFictitiousFunctionClassFactory < 0) {
                layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 += layoutState.BuiltInFictitiousFunctionClassFactory;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i2 = layoutState.BuiltInFictitiousFunctionClassFactory + layoutState.getAuthRequestContext;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.MyBillsEntityDataFactory && i2 <= 0) || !layoutState.MyBillsEntityDataFactory(state)) {
                break;
            }
            layoutChunkResult.MyBillsEntityDataFactory = 0;
            layoutChunkResult.getAuthRequestContext = false;
            layoutChunkResult.BuiltInFictitiousFunctionClassFactory = false;
            layoutChunkResult.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.getAuthRequestContext) {
                layoutState.getErrorConfigVersion += layoutChunkResult.MyBillsEntityDataFactory * layoutState.moveToNextValue;
                if (!layoutChunkResult.BuiltInFictitiousFunctionClassFactory || layoutState.initRecordTimeStamp != null || !state.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    layoutState.BuiltInFictitiousFunctionClassFactory -= layoutChunkResult.MyBillsEntityDataFactory;
                    i2 -= layoutChunkResult.MyBillsEntityDataFactory;
                }
                if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 != Integer.MIN_VALUE) {
                    layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 += layoutChunkResult.MyBillsEntityDataFactory;
                    if (layoutState.BuiltInFictitiousFunctionClassFactory < 0) {
                        layoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 += layoutState.BuiltInFictitiousFunctionClassFactory;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z && layoutChunkResult.KClassImpl$Data$declaredNonStaticMembers$2) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.BuiltInFictitiousFunctionClassFactory;
    }

    void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        View PlaceComponentResult = layoutState.PlaceComponentResult(recycler);
        if (PlaceComponentResult == null) {
            layoutChunkResult.getAuthRequestContext = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) PlaceComponentResult.getLayoutParams();
        if (layoutState.initRecordTimeStamp == null) {
            if (this.mShouldReverseLayout == (layoutState.moveToNextValue == -1)) {
                addView(PlaceComponentResult);
            } else {
                addView(PlaceComponentResult, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (layoutState.moveToNextValue == -1)) {
                addDisappearingView(PlaceComponentResult);
            } else {
                addDisappearingView(PlaceComponentResult, 0);
            }
        }
        measureChildWithMargins(PlaceComponentResult, 0, 0);
        layoutChunkResult.MyBillsEntityDataFactory = this.mOrientationHelper.MyBillsEntityDataFactory(PlaceComponentResult);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                KClassImpl$Data$declaredNonStaticMembers$2 = getWidth() - getPaddingRight();
                i4 = KClassImpl$Data$declaredNonStaticMembers$2 - this.mOrientationHelper.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
            } else {
                i4 = getPaddingLeft();
                KClassImpl$Data$declaredNonStaticMembers$2 = this.mOrientationHelper.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult) + i4;
            }
            if (layoutState.moveToNextValue == -1) {
                int i5 = layoutState.getErrorConfigVersion;
                i2 = layoutState.getErrorConfigVersion - layoutChunkResult.MyBillsEntityDataFactory;
                i = KClassImpl$Data$declaredNonStaticMembers$2;
                i3 = i5;
            } else {
                int i6 = layoutState.getErrorConfigVersion;
                i3 = layoutState.getErrorConfigVersion + layoutChunkResult.MyBillsEntityDataFactory;
                i = KClassImpl$Data$declaredNonStaticMembers$2;
                i2 = i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int KClassImpl$Data$declaredNonStaticMembers$22 = this.mOrientationHelper.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult) + paddingTop;
            if (layoutState.moveToNextValue == -1) {
                i2 = paddingTop;
                i = layoutState.getErrorConfigVersion;
                i3 = KClassImpl$Data$declaredNonStaticMembers$22;
                i4 = layoutState.getErrorConfigVersion - layoutChunkResult.MyBillsEntityDataFactory;
            } else {
                int i7 = layoutState.getErrorConfigVersion;
                i = layoutState.getErrorConfigVersion + layoutChunkResult.MyBillsEntityDataFactory;
                i2 = paddingTop;
                i3 = KClassImpl$Data$declaredNonStaticMembers$22;
                i4 = i7;
            }
        }
        layoutDecoratedWithMargins(PlaceComponentResult, i4, i2, i, i3);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.BuiltInFictitiousFunctionClassFactory = true;
        }
        layoutChunkResult.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation != 1 ? Integer.MIN_VALUE : -1 : this.mOrientation != 0 ? Integer.MIN_VALUE : -1 : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        ensureLayoutState();
        int childCount = getChildCount();
        int i4 = -1;
        if (z2) {
            i = getChildCount() - 1;
            i2 = -1;
        } else {
            i4 = childCount;
            i = 0;
            i2 = 1;
        }
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i3 = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i3 = state.scheduleImpl;
        }
        int moveToNextValue = this.mOrientationHelper.moveToNextValue();
        int authRequestContext = this.mOrientationHelper.getAuthRequestContext();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i != i4) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            int authRequestContext2 = this.mOrientationHelper.getAuthRequestContext(childAt);
            int PlaceComponentResult = this.mOrientationHelper.PlaceComponentResult(childAt);
            if (position >= 0 && position < i3) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    boolean z3 = PlaceComponentResult <= moveToNextValue && authRequestContext2 < moveToNextValue;
                    boolean z4 = authRequestContext2 >= authRequestContext && PlaceComponentResult > authRequestContext;
                    if (!z3 && !z4) {
                        return childAt;
                    }
                    if (z) {
                        if (!z4) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    } else {
                        if (!z3) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i += i2;
        }
        return view == null ? view2 != null ? view2 : view3 : view;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild != null) {
            return getPosition(findOneVisibleChild);
        }
        return -1;
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild != null) {
            return getPosition(findOneVisibleChild);
        }
        return -1;
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, i4);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.getAuthRequestContext(getChildAt(i)) < this.mOrientationHelper.moveToNextValue()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.scheduleImpl() * MAX_SCROLL_FACTOR), false, state);
        this.mLayoutState.NetworkUserEntityData$$ExternalSyntheticLambda2 = Integer.MIN_VALUE;
        this.mLayoutState.DatabaseTableConfigUtil = false;
        fill(recycler, this.mLayoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (childClosestToEnd.hasFocusable()) {
            if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
                return null;
            }
            return childClosestToEnd;
        }
        return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
    }

    private void logChildren() {
        InstrumentInjector.log_d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append("item ");
            sb.append(getPosition(childAt));
            sb.append(", coord:");
            sb.append(this.mOrientationHelper.getAuthRequestContext(childAt));
            InstrumentInjector.log_d(TAG, sb.toString());
        }
        InstrumentInjector.log_d(TAG, "==============");
    }

    void validateChildOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("validating child count ");
        sb.append(getChildCount());
        InstrumentInjector.log_d(TAG, sb.toString());
        if (getChildCount() <= 0) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int authRequestContext = this.mOrientationHelper.getAuthRequestContext(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int authRequestContext2 = this.mOrientationHelper.getAuthRequestContext(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    sb2.append(authRequestContext2 < authRequestContext);
                    throw new RuntimeException(sb2.toString());
                } else if (authRequestContext2 > authRequestContext) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int authRequestContext3 = this.mOrientationHelper.getAuthRequestContext(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("detected invalid position. loc invalid? ");
                sb3.append(authRequestContext3 < authRequestContext);
                throw new RuntimeException(sb3.toString());
            } else if (authRequestContext3 < authRequestContext) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getAuthRequestContext() - (this.mOrientationHelper.getAuthRequestContext(view2) + this.mOrientationHelper.MyBillsEntityDataFactory(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getAuthRequestContext() - this.mOrientationHelper.PlaceComponentResult(view2));
            }
        } else if (c == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getAuthRequestContext(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.PlaceComponentResult(view2) - this.mOrientationHelper.MyBillsEntityDataFactory(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class LayoutState {
        int BuiltInFictitiousFunctionClassFactory;
        boolean MyBillsEntityDataFactory;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        int NetworkUserEntityData$$ExternalSyntheticLambda2;
        int PlaceComponentResult;
        int getErrorConfigVersion;
        int lookAheadTest;
        int moveToNextValue;
        boolean DatabaseTableConfigUtil = true;
        int getAuthRequestContext = 0;
        int scheduleImpl = 0;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
        List<RecyclerView.ViewHolder> initRecordTimeStamp = null;

        LayoutState() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean MyBillsEntityDataFactory(RecyclerView.State state) {
            int i;
            int i2 = this.PlaceComponentResult;
            if (i2 >= 0) {
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i = state.scheduleImpl;
                }
                if (i2 < i) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final View PlaceComponentResult(RecyclerView.Recycler recycler) {
            if (this.initRecordTimeStamp != null) {
                return MyBillsEntityDataFactory();
            }
            View MyBillsEntityDataFactory = recycler.MyBillsEntityDataFactory(this.PlaceComponentResult);
            this.PlaceComponentResult += this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            return MyBillsEntityDataFactory;
        }

        private View MyBillsEntityDataFactory() {
            int size = this.initRecordTimeStamp.size();
            for (int i = 0; i < size; i++) {
                View view = this.initRecordTimeStamp.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.PlaceComponentResult == layoutParams.getViewLayoutPosition()) {
                    getAuthRequestContext(view);
                    return view;
                }
            }
            return null;
        }

        public final void getAuthRequestContext(View view) {
            View MyBillsEntityDataFactory = MyBillsEntityDataFactory(view);
            if (MyBillsEntityDataFactory == null) {
                this.PlaceComponentResult = -1;
            } else {
                this.PlaceComponentResult = ((RecyclerView.LayoutParams) MyBillsEntityDataFactory.getLayoutParams()).getViewLayoutPosition();
            }
        }

        private View MyBillsEntityDataFactory(View view) {
            int viewLayoutPosition;
            int size = this.initRecordTimeStamp.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.initRecordTimeStamp.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.PlaceComponentResult) * this.NetworkUserEntityData$$ExternalSyntheticLambda0) >= 0 && viewLayoutPosition < i) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int PlaceComponentResult;
        boolean getAuthRequestContext;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
            this.PlaceComponentResult = parcel.readInt();
            this.getAuthRequestContext = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = savedState.KClassImpl$Data$declaredNonStaticMembers$2;
            this.PlaceComponentResult = savedState.PlaceComponentResult;
            this.getAuthRequestContext = savedState.getAuthRequestContext;
        }

        final boolean PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 >= 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
            parcel.writeInt(this.PlaceComponentResult);
            parcel.writeInt(this.getAuthRequestContext ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AnchorInfo {
        OrientationHelper KClassImpl$Data$declaredNonStaticMembers$2;
        int getAuthRequestContext = -1;
        int BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
        boolean MyBillsEntityDataFactory = false;
        boolean PlaceComponentResult = false;

        AnchorInfo() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnchorInfo{mPosition=");
            sb.append(this.getAuthRequestContext);
            sb.append(", mCoordinate=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", mLayoutFromEnd=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", mValid=");
            sb.append(this.PlaceComponentResult);
            sb.append('}');
            return sb.toString();
        }

        static boolean getAuthRequestContext(View view, RecyclerView.State state) {
            int i;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0) {
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i = state.scheduleImpl;
                }
                if (viewLayoutPosition < i) {
                    return true;
                }
            }
            return false;
        }

        public final void PlaceComponentResult(View view, int i) {
            OrientationHelper orientationHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int scheduleImpl = Integer.MIN_VALUE == orientationHelper.PlaceComponentResult ? 0 : orientationHelper.scheduleImpl() - orientationHelper.PlaceComponentResult;
            if (scheduleImpl >= 0) {
                MyBillsEntityDataFactory(view, i);
                return;
            }
            this.getAuthRequestContext = i;
            if (this.MyBillsEntityDataFactory) {
                int authRequestContext = (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext() - scheduleImpl) - this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(view);
                this.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext() - authRequestContext;
                if (authRequestContext > 0) {
                    int MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(view);
                    int i2 = this.BuiltInFictitiousFunctionClassFactory;
                    int moveToNextValue = this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
                    int min = (i2 - MyBillsEntityDataFactory) - (moveToNextValue + Math.min(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(view) - moveToNextValue, 0));
                    if (min < 0) {
                        this.BuiltInFictitiousFunctionClassFactory += Math.min(authRequestContext, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int authRequestContext2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(view);
            int moveToNextValue2 = authRequestContext2 - this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
            this.BuiltInFictitiousFunctionClassFactory = authRequestContext2;
            if (moveToNextValue2 > 0) {
                int authRequestContext3 = (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext() - Math.min(0, (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext() - scheduleImpl) - this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(view))) - (authRequestContext2 + this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(view));
                if (authRequestContext3 < 0) {
                    this.BuiltInFictitiousFunctionClassFactory -= Math.min(moveToNextValue2, -authRequestContext3);
                }
            }
        }

        public final void MyBillsEntityDataFactory(View view, int i) {
            if (this.MyBillsEntityDataFactory) {
                int PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(view);
                OrientationHelper orientationHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult + (Integer.MIN_VALUE == orientationHelper.PlaceComponentResult ? 0 : orientationHelper.scheduleImpl() - orientationHelper.PlaceComponentResult);
            } else {
                this.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(view);
            }
            this.getAuthRequestContext = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class LayoutChunkResult {
        public boolean BuiltInFictitiousFunctionClassFactory;
        public boolean KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public boolean getAuthRequestContext;

        protected LayoutChunkResult() {
        }
    }
}
