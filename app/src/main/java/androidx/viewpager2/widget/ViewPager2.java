package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    private CompositeOnPageChangeCallback BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    private LinearLayoutManager KClassImpl$Data$declaredNonStaticMembers$2;
    private RecyclerView.AdapterDataObserver MyBillsEntityDataFactory;
    private PagerSnapHelper NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda2;
    private FakeDrag PlaceComponentResult;
    private int getAuthRequestContext;
    private CompositeOnPageChangeCallback getErrorConfigVersion;
    private RecyclerView.ItemAnimator initRecordTimeStamp;
    private int lookAheadTest;
    AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    boolean mCurrentItemDirty;
    public RecyclerView mRecyclerView;
    ScrollEventAdapter mScrollEventAdapter;
    private PageTransformerAdapter moveToNextValue;
    private Parcelable scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OffscreenPageLimit {
    }

    /* loaded from: classes2.dex */
    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Orientation {
    }

    /* loaded from: classes3.dex */
    public interface PageTransformer {
        void KClassImpl$Data$declaredNonStaticMembers$2(View view, float f);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScrollState {
    }

    public ViewPager2(Context context) {
        super(context);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Rect();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Rect();
        this.BuiltInFictitiousFunctionClassFactory = new CompositeOnPageChangeCallback();
        this.mCurrentItemDirty = false;
        this.MyBillsEntityDataFactory = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2.this.mCurrentItemDirty = true;
                ViewPager2.this.mScrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
        };
        this.lookAheadTest = -1;
        this.initRecordTimeStamp = null;
        this.GetContactSyncConfig = false;
        this.DatabaseTableConfigUtil = true;
        this.getAuthRequestContext = -1;
        MyBillsEntityDataFactory(context, null);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Rect();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Rect();
        this.BuiltInFictitiousFunctionClassFactory = new CompositeOnPageChangeCallback();
        this.mCurrentItemDirty = false;
        this.MyBillsEntityDataFactory = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2.this.mCurrentItemDirty = true;
                ViewPager2.this.mScrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
        };
        this.lookAheadTest = -1;
        this.initRecordTimeStamp = null;
        this.GetContactSyncConfig = false;
        this.DatabaseTableConfigUtil = true;
        this.getAuthRequestContext = -1;
        MyBillsEntityDataFactory(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Rect();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Rect();
        this.BuiltInFictitiousFunctionClassFactory = new CompositeOnPageChangeCallback();
        this.mCurrentItemDirty = false;
        this.MyBillsEntityDataFactory = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2.this.mCurrentItemDirty = true;
                ViewPager2.this.mScrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
        };
        this.lookAheadTest = -1;
        this.initRecordTimeStamp = null;
        this.GetContactSyncConfig = false;
        this.DatabaseTableConfigUtil = true;
        this.getAuthRequestContext = -1;
        MyBillsEntityDataFactory(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Rect();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Rect();
        this.BuiltInFictitiousFunctionClassFactory = new CompositeOnPageChangeCallback();
        this.mCurrentItemDirty = false;
        this.MyBillsEntityDataFactory = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2.this.mCurrentItemDirty = true;
                ViewPager2.this.mScrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
        };
        this.lookAheadTest = -1;
        this.initRecordTimeStamp = null;
        this.GetContactSyncConfig = false;
        this.DatabaseTableConfigUtil = true;
        this.getAuthRequestContext = -1;
        MyBillsEntityDataFactory(context, attributeSet);
    }

    private void MyBillsEntityDataFactory(Context context, AttributeSet attributeSet) {
        this.mAccessibilityProvider = sFeatureEnhancedA11yEnabled ? new PageAwareAccessibilityProvider() : new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.MyBillsEntityDataFactory());
        this.mRecyclerView.setDescendantFocusability(AntDetector.SCENE_ID_LOGIN_REGIST);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayoutManagerImpl;
        this.mRecyclerView.setLayoutManager(linearLayoutManagerImpl);
        this.mRecyclerView.setScrollingTouchSlop(1);
        getAuthRequestContext(context, attributeSet);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: androidx.viewpager2.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public final void getAuthRequestContext(View view) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public final void MyBillsEntityDataFactory(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        });
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.mScrollEventAdapter = scrollEventAdapter;
        this.PlaceComponentResult = new FakeDrag(this, scrollEventAdapter, this.mRecyclerView);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pagerSnapHelperImpl;
        pagerSnapHelperImpl.KClassImpl$Data$declaredNonStaticMembers$2(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback();
        this.getErrorConfigVersion = compositeOnPageChangeCallback;
        this.mScrollEventAdapter.PlaceComponentResult = compositeOnPageChangeCallback;
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                if (ViewPager2.this.mCurrentItem != i) {
                    ViewPager2.this.mCurrentItem = i;
                    ViewPager2.this.mAccessibilityProvider.getErrorConfigVersion();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ViewPager2.this.updateCurrentItem();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.3
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.mRecyclerView.requestFocus(2);
                }
            }
        };
        this.getErrorConfigVersion.getAuthRequestContext.add(onPageChangeCallback);
        this.getErrorConfigVersion.getAuthRequestContext.add(onPageChangeCallback2);
        this.mAccessibilityProvider.PlaceComponentResult(this.mRecyclerView);
        this.getErrorConfigVersion.getAuthRequestContext.add(this.BuiltInFictitiousFunctionClassFactory);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.moveToNextValue = pageTransformerAdapter;
        this.getErrorConfigVersion.getAuthRequestContext.add(pageTransformerAdapter);
        RecyclerView recyclerView = this.mRecyclerView;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.PlaceComponentResult()) {
            return this.mAccessibilityProvider.BuiltInFictitiousFunctionClassFactory();
        }
        return super.getAccessibilityClassName();
    }

    private void getAuthRequestContext(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.scheduleImpl);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.scheduleImpl, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.getErrorConfigVersion, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.KClassImpl$Data$declaredNonStaticMembers$2 = this.mRecyclerView.getId();
        int i = this.lookAheadTest;
        if (i == -1) {
            i = this.mCurrentItem;
        }
        savedState.getAuthRequestContext = i;
        Parcelable parcelable = this.scheduleImpl;
        if (parcelable != null) {
            savedState.MyBillsEntityDataFactory = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.MyBillsEntityDataFactory = ((StatefulAdapter) adapter).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.lookAheadTest = savedState.getAuthRequestContext;
        this.scheduleImpl = savedState.MyBillsEntityDataFactory;
    }

    private void getAuthRequestContext() {
        RecyclerView.Adapter adapter;
        if (this.lookAheadTest == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.scheduleImpl;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).getAuthRequestContext(parcelable);
            }
            this.scheduleImpl = null;
        }
        int max = Math.max(0, Math.min(this.lookAheadTest, adapter.getItemCount() - 1));
        this.mCurrentItem = max;
        this.lookAheadTest = -1;
        this.mRecyclerView.scrollToPosition(max);
        this.mAccessibilityProvider.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).KClassImpl$Data$declaredNonStaticMembers$2;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        getAuthRequestContext();
    }

    /* loaded from: classes3.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager2.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, null) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int KClassImpl$Data$declaredNonStaticMembers$2;
        Parcelable MyBillsEntityDataFactory;
        int getAuthRequestContext;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
            this.getAuthRequestContext = parcel.readInt();
            this.MyBillsEntityDataFactory = parcel.readParcelable(classLoader);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
            this.getAuthRequestContext = parcel.readInt();
            this.MyBillsEntityDataFactory = parcel.readParcelable(null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
            parcel.writeInt(this.getAuthRequestContext);
            parcel.writeParcelable(this.MyBillsEntityDataFactory, i);
        }
    }

    public final void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter<?> adapter2 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.BuiltInFictitiousFunctionClassFactory(adapter2);
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.MyBillsEntityDataFactory);
        }
        this.mRecyclerView.setAdapter(adapter);
        this.mCurrentItem = 0;
        getAuthRequestContext();
        this.mAccessibilityProvider.getAuthRequestContext(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.MyBillsEntityDataFactory);
        }
    }

    public final RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" does not support direct child views");
        throw new IllegalStateException(sb.toString());
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        measureChild(this.mRecyclerView, i, i2);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(measuredWidth + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i, measuredState), resolveSizeAndState(Math.max(measuredHeight + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.left = getPaddingLeft();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.right = (i3 - i) - getPaddingRight();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.top = getPaddingTop();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.mRecyclerView.layout(this.NetworkUserEntityData$$ExternalSyntheticLambda1.left, this.NetworkUserEntityData$$ExternalSyntheticLambda1.top, this.NetworkUserEntityData$$ExternalSyntheticLambda1.right, this.NetworkUserEntityData$$ExternalSyntheticLambda1.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    final void updateCurrentItem() {
        PagerSnapHelper pagerSnapHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (pagerSnapHelper == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View PlaceComponentResult = pagerSnapHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (PlaceComponentResult == null) {
            return;
        }
        int position = this.KClassImpl$Data$declaredNonStaticMembers$2.getPosition(PlaceComponentResult);
        if (position != this.mCurrentItem && getScrollState() == 0) {
            this.getErrorConfigVersion.onPageSelected(position);
        }
        this.mCurrentItemDirty = false;
    }

    final int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.mRecyclerView;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public final void setOrientation(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOrientation(i);
        this.mAccessibilityProvider.lookAheadTest();
    }

    public final int getOrientation() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getOrientation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isRtl() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getLayoutDirection() == 1;
    }

    public final void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public final void setCurrentItem(int i, boolean z) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        setCurrentItemInternal(i, z);
    }

    final void setCurrentItemInternal(int i, boolean z) {
        OnPageChangeCallback onPageChangeCallback;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.lookAheadTest != -1) {
                this.lookAheadTest = Math.max(i, 0);
            }
        } else if (adapter.getItemCount() <= 0) {
        } else {
            int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
            if (min == this.mCurrentItem && this.mScrollEventAdapter.BuiltInFictitiousFunctionClassFactory()) {
                return;
            }
            int i2 = this.mCurrentItem;
            if (min == i2 && z) {
                return;
            }
            double d = i2;
            this.mCurrentItem = min;
            this.mAccessibilityProvider.getErrorConfigVersion();
            if (!this.mScrollEventAdapter.BuiltInFictitiousFunctionClassFactory()) {
                ScrollEventAdapter scrollEventAdapter = this.mScrollEventAdapter;
                scrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
                double d2 = scrollEventAdapter.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
                double d3 = scrollEventAdapter.moveToNextValue.PlaceComponentResult;
                Double.isNaN(d2);
                Double.isNaN(d3);
                d = d2 + d3;
            }
            ScrollEventAdapter scrollEventAdapter2 = this.mScrollEventAdapter;
            scrollEventAdapter2.getAuthRequestContext = z ? 2 : 3;
            scrollEventAdapter2.BuiltInFictitiousFunctionClassFactory = false;
            boolean z2 = scrollEventAdapter2.scheduleImpl != min;
            scrollEventAdapter2.scheduleImpl = min;
            scrollEventAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(2);
            if (z2 && (onPageChangeCallback = scrollEventAdapter2.PlaceComponentResult) != null) {
                onPageChangeCallback.onPageSelected(min);
            }
            if (!z) {
                this.mRecyclerView.scrollToPosition(min);
                return;
            }
            double d4 = min;
            Double.isNaN(d4);
            if (Math.abs(d4 - d) > 3.0d) {
                this.mRecyclerView.scrollToPosition(d4 > d ? min - 3 : min + 3);
                RecyclerView recyclerView = this.mRecyclerView;
                recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                return;
            }
            this.mRecyclerView.smoothScrollToPosition(min);
        }
    }

    public final int getCurrentItem() {
        return this.mCurrentItem;
    }

    public final int getScrollState() {
        return this.mScrollEventAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final boolean beginFakeDrag() {
        return this.PlaceComponentResult.PlaceComponentResult();
    }

    public final boolean fakeDragBy(float f) {
        return this.PlaceComponentResult.getAuthRequestContext(f);
    }

    public final boolean endFakeDrag() {
        return this.PlaceComponentResult.MyBillsEntityDataFactory();
    }

    public final boolean isFakeDragging() {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void snapToPage() {
        View PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (PlaceComponentResult == null) {
            return;
        }
        int[] authRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult);
        int i = authRequestContext[0];
        if (i == 0 && authRequestContext[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(i, authRequestContext[1]);
    }

    public final void setUserInputEnabled(boolean z) {
        this.DatabaseTableConfigUtil = z;
        this.mAccessibilityProvider.moveToNextValue();
    }

    public final boolean isUserInputEnabled() {
        return this.DatabaseTableConfigUtil;
    }

    public final void setOffscreenPageLimit(int i) {
        if (i <= 0 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.getAuthRequestContext = i;
        this.mRecyclerView.requestLayout();
    }

    public final int getOffscreenPageLimit() {
        return this.getAuthRequestContext;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.mRecyclerView.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.mRecyclerView.canScrollVertically(i);
    }

    public final void registerOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.add(onPageChangeCallback);
    }

    public final void unregisterOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.remove(onPageChangeCallback);
    }

    public final void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.GetContactSyncConfig) {
                this.initRecordTimeStamp = this.mRecyclerView.getItemAnimator();
                this.GetContactSyncConfig = true;
            }
            this.mRecyclerView.setItemAnimator(null);
        } else if (this.GetContactSyncConfig) {
            this.mRecyclerView.setItemAnimator(this.initRecordTimeStamp);
            this.initRecordTimeStamp = null;
            this.GetContactSyncConfig = false;
        }
        if (pageTransformer == this.moveToNextValue.PlaceComponentResult) {
            return;
        }
        this.moveToNextValue.PlaceComponentResult = pageTransformer;
        requestTransform();
    }

    public final void requestTransform() {
        if (this.moveToNextValue.PlaceComponentResult == null) {
            return;
        }
        ScrollEventAdapter scrollEventAdapter = this.mScrollEventAdapter;
        scrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
        double d = scrollEventAdapter.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
        double d2 = scrollEventAdapter.moveToNextValue.PlaceComponentResult;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d + d2;
        int i = (int) d3;
        double d4 = i;
        Double.isNaN(d4);
        float f = (float) (d3 - d4);
        this.moveToNextValue.onPageScrolled(i, f, Math.round(getPageSize() * f));
    }

    @Override // android.view.View
    public final void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.mAccessibilityProvider.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.KClassImpl$Data$declaredNonStaticMembers$2(accessibilityNodeInfo);
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.mAccessibilityProvider.MyBillsEntityDataFactory(i)) {
            return this.mAccessibilityProvider.getAuthRequestContext(i);
        }
        return super.performAccessibilityAction(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.mAccessibilityProvider.getAuthRequestContext()) {
                return ViewPager2.this.mAccessibilityProvider.MyBillsEntityDataFactory();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(ViewPager2.this.mCurrentItem);
            ViewPager2.this.mAccessibilityProvider.MyBillsEntityDataFactory(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i, Bundle bundle) {
            if (ViewPager2.this.mAccessibilityProvider.KClassImpl$Data$declaredNonStaticMembers$2(i)) {
                return ViewPager2.this.mAccessibilityProvider.PlaceComponentResult(i);
            }
            return super.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.mAccessibilityProvider.MyBillsEntityDataFactory(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public final View PlaceComponentResult(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.PlaceComponentResult(layoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SmoothScrollToPosition implements Runnable {
        private final RecyclerView PlaceComponentResult;
        private final int getAuthRequestContext;

        SmoothScrollToPosition(int i, RecyclerView recyclerView) {
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.PlaceComponentResult.smoothScrollToPosition(this.getAuthRequestContext);
        }
    }

    public final void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.addItemDecoration(itemDecoration);
    }

    public final void addItemDecoration(RecyclerView.ItemDecoration itemDecoration, int i) {
        this.mRecyclerView.addItemDecoration(itemDecoration, i);
    }

    public final RecyclerView.ItemDecoration getItemDecorationAt(int i) {
        return this.mRecyclerView.getItemDecorationAt(i);
    }

    public final int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public final void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public final void removeItemDecorationAt(int i) {
        this.mRecyclerView.removeItemDecorationAt(i);
    }

    public final void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.removeItemDecoration(itemDecoration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public abstract class AccessibilityProvider {
        void BuiltInFictitiousFunctionClassFactory(RecyclerView.Adapter<?> adapter) {
        }

        void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return false;
        }

        void MyBillsEntityDataFactory(AccessibilityEvent accessibilityEvent) {
        }

        void MyBillsEntityDataFactory(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        boolean MyBillsEntityDataFactory(int i) {
            return false;
        }

        void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        }

        void PlaceComponentResult(RecyclerView recyclerView) {
        }

        boolean PlaceComponentResult() {
            return false;
        }

        void getAuthRequestContext(RecyclerView.Adapter<?> adapter) {
        }

        boolean getAuthRequestContext() {
            return false;
        }

        void getErrorConfigVersion() {
        }

        void lookAheadTest() {
        }

        void moveToNextValue() {
        }

        private AccessibilityProvider() {
        }

        /* synthetic */ AccessibilityProvider(ViewPager2 viewPager2, byte b) {
            this();
        }

        String BuiltInFictitiousFunctionClassFactory() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean getAuthRequestContext(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean PlaceComponentResult(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence MyBillsEntityDataFactory() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final boolean getAuthRequestContext() {
            return true;
        }

        BasicAccessibilityProvider() {
            super(ViewPager2.this, (byte) 0);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final boolean PlaceComponentResult(int i) {
            if (KClassImpl$Data$declaredNonStaticMembers$2(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void MyBillsEntityDataFactory(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.getAuthRequestContext(AccessibilityNodeInfoCompat.AccessibilityActionCompat.getCallingPid);
            accessibilityNodeInfoCompat.getAuthRequestContext(AccessibilityNodeInfoCompat.AccessibilityActionCompat.C);
            accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final CharSequence MyBillsEntityDataFactory() {
            if (getAuthRequestContext()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PageAwareAccessibilityProvider extends AccessibilityProvider {
        private RecyclerView.AdapterDataObserver KClassImpl$Data$declaredNonStaticMembers$2;
        private final AccessibilityViewCommand MyBillsEntityDataFactory;
        private final AccessibilityViewCommand PlaceComponentResult;

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final boolean MyBillsEntityDataFactory(int i) {
            return i == 8192 || i == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final boolean PlaceComponentResult() {
            return true;
        }

        PageAwareAccessibilityProvider() {
            super(ViewPager2.this, (byte) 0);
            this.MyBillsEntityDataFactory = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.1
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider pageAwareAccessibilityProvider = PageAwareAccessibilityProvider.this;
                    int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                    if (ViewPager2.this.isUserInputEnabled()) {
                        ViewPager2.this.setCurrentItemInternal(currentItem, true);
                    }
                    return true;
                }
            };
            this.PlaceComponentResult = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.2
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider pageAwareAccessibilityProvider = PageAwareAccessibilityProvider.this;
                    int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
                    if (ViewPager2.this.isUserInputEnabled()) {
                        ViewPager2.this.setCurrentItemInternal(currentItem, true);
                    }
                    return true;
                }
            };
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void PlaceComponentResult(RecyclerView recyclerView) {
            ViewCompat.moveToNextValue((View) recyclerView, 2);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.3
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.scheduleImpl();
                }
            };
            if (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(ViewPager2.this) == 0) {
                ViewCompat.moveToNextValue((View) ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final String BuiltInFictitiousFunctionClassFactory() {
            if (PlaceComponentResult()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            scheduleImpl();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void getAuthRequestContext(RecyclerView.Adapter<?> adapter) {
            scheduleImpl();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void BuiltInFictitiousFunctionClassFactory(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void lookAheadTest() {
            scheduleImpl();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void getErrorConfigVersion() {
            scheduleImpl();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void moveToNextValue() {
            scheduleImpl();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
            scheduleImpl();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final boolean getAuthRequestContext(int i) {
            int currentItem;
            if (!MyBillsEntityDataFactory(i)) {
                throw new IllegalStateException();
            }
            if (i == 8192) {
                currentItem = ViewPager2.this.getCurrentItem() - 1;
            } else {
                currentItem = ViewPager2.this.getCurrentItem() + 1;
            }
            if (ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.setCurrentItemInternal(currentItem, true);
            }
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void MyBillsEntityDataFactory(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            if (PlaceComponentResult()) {
                accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
                return;
            }
            throw new IllegalStateException();
        }

        final void scheduleImpl() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((View) viewPager2, 16908360);
            ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((View) viewPager2, 16908361);
            ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((View) viewPager2, 16908358);
            ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((View) viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (ViewPager2.this.getOrientation() == 0) {
                boolean isRtl = ViewPager2.this.isRtl();
                int i = isRtl ? 16908360 : 16908361;
                int i2 = isRtl ? 16908361 : 16908360;
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    ViewCompat.PlaceComponentResult(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, null), null, this.MyBillsEntityDataFactory);
                }
                if (ViewPager2.this.mCurrentItem > 0) {
                    ViewCompat.PlaceComponentResult(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, null), null, this.PlaceComponentResult);
                    return;
                }
                return;
            }
            if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                ViewCompat.PlaceComponentResult(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, null), null, this.MyBillsEntityDataFactory);
            }
            if (ViewPager2.this.mCurrentItem > 0) {
                ViewCompat.PlaceComponentResult(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, null), null, this.PlaceComponentResult);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public final void KClassImpl$Data$declaredNonStaticMembers$2(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            int i2;
            RecyclerView.Adapter adapter;
            int itemCount;
            if (ViewPager2.this.getAdapter() == null) {
                i = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i = ViewPager2.this.getAdapter().getItemCount();
            } else {
                i2 = ViewPager2.this.getAdapter().getItemCount();
                i = 0;
                AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(accessibilityNodeInfo).PlaceComponentResult(AccessibilityNodeInfoCompat.CollectionInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, false, 0));
                if (Build.VERSION.SDK_INT >= 16 || (adapter = ViewPager2.this.getAdapter()) == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                    return;
                }
                if (ViewPager2.this.mCurrentItem > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
                return;
            }
            i2 = 0;
            AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(accessibilityNodeInfo).PlaceComponentResult(AccessibilityNodeInfoCompat.CollectionInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, false, 0));
            if (Build.VERSION.SDK_INT >= 16) {
            }
        }
    }

    /* loaded from: classes6.dex */
    static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        /* synthetic */ DataSetChangeObserver(byte b) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }
}
