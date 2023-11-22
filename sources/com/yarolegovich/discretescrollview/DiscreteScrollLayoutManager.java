package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class DiscreteScrollLayoutManager extends RecyclerView.LayoutManager {
    DSVOrientation.Helper GetContactSyncConfig;
    protected int KClassImpl$Data$declaredNonStaticMembers$2;
    DiscreteScrollItemTransformer NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final ScrollStateListener NetworkUserEntityData$$ExternalSyntheticLambda4;
    private Context NetworkUserEntityData$$ExternalSyntheticLambda5;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected int PlaceComponentResult;
    protected int getAuthRequestContext;
    private int getCallingPid;
    protected boolean getErrorConfigVersion;
    protected int newProxyInstance;
    protected int scheduleImpl;
    private int whenAvailable;
    int NetworkUserEntityData$$ExternalSyntheticLambda7 = 300;
    protected int initRecordTimeStamp = -1;
    protected int MyBillsEntityDataFactory = -1;
    int lookAheadTest = 2100;
    boolean isLayoutRequested = false;
    protected Point DatabaseTableConfigUtil = new Point();
    protected Point BuiltInFictitiousFunctionClassFactory = new Point();
    protected Point PrepareContext = new Point();
    protected SparseArray<View> moveToNextValue = new SparseArray<>();
    RecyclerViewProxy NetworkUserEntityData$$ExternalSyntheticLambda1 = new RecyclerViewProxy(this);
    private int FragmentBottomSheetPaymentSettingBinding = 1;

    /* loaded from: classes8.dex */
    public interface InitialPositionProvider {
        int KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* loaded from: classes8.dex */
    public interface ScrollStateListener {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(float f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public DiscreteScrollLayoutManager(Context context, ScrollStateListener scrollStateListener, DSVOrientation dSVOrientation) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = scrollStateListener;
        this.GetContactSyncConfig = dSVOrientation.createHelper();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        if (this.getErrorConfigVersion) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult();
            this.getErrorConfigVersion = false;
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.MyBillsEntityDataFactory();
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.Recycler recycler, Direction direction, int i) {
        int applyTo = direction.applyTo(1);
        int i2 = this.initRecordTimeStamp;
        boolean z = i2 == -1 || !direction.sameAs(i2 - this.MyBillsEntityDataFactory);
        this.PrepareContext.set(this.BuiltInFictitiousFunctionClassFactory.x, this.BuiltInFictitiousFunctionClassFactory.y);
        int i3 = this.MyBillsEntityDataFactory;
        while (true) {
            i3 += applyTo;
            if (!PlaceComponentResult(i3)) {
                return;
            }
            if (i3 == this.initRecordTimeStamp) {
                z = true;
            }
            this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(direction, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.PrepareContext);
            if (MyBillsEntityDataFactory(this.PrepareContext, i)) {
                MyBillsEntityDataFactory(recycler, i3, this.PrepareContext);
            } else if (z) {
                return;
            }
        }
    }

    private void MyBillsEntityDataFactory(RecyclerView.Recycler recycler, int i, Point point) {
        if (i < 0) {
            return;
        }
        View view = this.moveToNextValue.get(i);
        if (view == null) {
            RecyclerViewProxy recyclerViewProxy = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            View BuiltInFictitiousFunctionClassFactory = recycler.BuiltInFictitiousFunctionClassFactory(i);
            recyclerViewProxy.getAuthRequestContext.addView(BuiltInFictitiousFunctionClassFactory);
            recyclerViewProxy.getAuthRequestContext.measureChildWithMargins(BuiltInFictitiousFunctionClassFactory, 0, 0);
            RecyclerViewProxy recyclerViewProxy2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            recyclerViewProxy2.getAuthRequestContext.layoutDecoratedWithMargins(BuiltInFictitiousFunctionClassFactory, point.x - this.PlaceComponentResult, point.y - this.getAuthRequestContext, point.x + this.PlaceComponentResult, point.y + this.getAuthRequestContext);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.attachView(view);
        this.moveToNextValue.remove(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.MyBillsEntityDataFactory;
        if (i3 == -1) {
            i3 = 0;
        } else if (i3 >= i) {
            i3 = Math.min(i3 + i2, this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getItemCount() - 1);
        }
        if (this.MyBillsEntityDataFactory != i3) {
            this.MyBillsEntityDataFactory = i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.MyBillsEntityDataFactory;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getItemCount() == 0) {
            i3 = -1;
        } else {
            int i4 = this.MyBillsEntityDataFactory;
            if (i4 >= i) {
                if (i4 < i + i2) {
                    this.MyBillsEntityDataFactory = -1;
                }
                i3 = Math.max(0, this.MyBillsEntityDataFactory - i2);
            }
        }
        if (this.MyBillsEntityDataFactory != i3) {
            this.MyBillsEntityDataFactory = i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.MyBillsEntityDataFactory = Math.min(Math.max(0, this.MyBillsEntityDataFactory), this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getItemCount() - 1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return BuiltInFictitiousFunctionClassFactory(i, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return BuiltInFictitiousFunctionClassFactory(i, recycler);
    }

    private int BuiltInFictitiousFunctionClassFactory(int i, RecyclerView.Recycler recycler) {
        int abs;
        boolean z;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildCount() == 0) {
            return 0;
        }
        Direction fromDelta = Direction.fromDelta(i);
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i2 != 0) {
            abs = Math.abs(i2);
        } else {
            boolean z2 = fromDelta.applyTo(this.newProxyInstance) > 0;
            if (fromDelta == Direction.START && this.MyBillsEntityDataFactory == 0) {
                int i3 = this.newProxyInstance;
                z = i3 == 0;
                if (!z) {
                    abs = Math.abs(i3);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2(z);
                }
                abs = 0;
                this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2(z);
            } else {
                if (fromDelta == Direction.END && this.MyBillsEntityDataFactory == this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getItemCount() - 1) {
                    int i4 = this.newProxyInstance;
                    z = i4 == 0;
                    if (!z) {
                        abs = Math.abs(i4);
                    }
                    abs = 0;
                } else {
                    if (z2) {
                        abs = this.NetworkUserEntityData$$ExternalSyntheticLambda8 - Math.abs(this.newProxyInstance);
                    } else {
                        abs = this.NetworkUserEntityData$$ExternalSyntheticLambda8 + Math.abs(this.newProxyInstance);
                    }
                    z = false;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }
        if (abs <= 0) {
            return 0;
        }
        int applyTo = fromDelta.applyTo(Math.min(abs, Math.abs(i)));
        this.newProxyInstance += applyTo;
        int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i5 != 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i5 - applyTo;
        }
        this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(-applyTo, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (this.GetContactSyncConfig.MyBillsEntityDataFactory(this)) {
            MyBillsEntityDataFactory(recycler);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext(-Math.min(Math.max(-1.0f, this.newProxyInstance / (this.initRecordTimeStamp != -1 ? Math.abs(this.newProxyInstance + this.NetworkUserEntityData$$ExternalSyntheticLambda2) : this.NetworkUserEntityData$$ExternalSyntheticLambda8)), 1.0f));
        moveToNextValue();
        return applyTo;
    }

    private void moveToNextValue() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int i2 = this.FragmentBottomSheetPaymentSettingBinding;
            for (int i3 = 0; i3 < this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildCount(); i3++) {
                View childAt = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildAt(i3);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(childAt, Math.min(Math.max(-1.0f, this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, getDecoratedLeft(childAt) + this.PlaceComponentResult, getDecoratedTop(childAt) + this.getAuthRequestContext) / (i * i2)), 1.0f));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (this.MyBillsEntityDataFactory == i) {
            return;
        }
        this.MyBillsEntityDataFactory = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        int i2;
        int i3;
        if (this.MyBillsEntityDataFactory == i || this.initRecordTimeStamp != -1) {
            return;
        }
        if (i >= 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i3 = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i3 = state.scheduleImpl;
            }
            if (i < i3) {
                if (this.MyBillsEntityDataFactory == -1) {
                    this.MyBillsEntityDataFactory = i;
                    return;
                } else {
                    BuiltInFictitiousFunctionClassFactory(i);
                    return;
                }
            }
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i2 = state.scheduleImpl;
        }
        objArr[1] = Integer.valueOf(i2);
        throw new IllegalArgumentException(String.format(locale, "target position out of bounds: position=%d, itemCount=%d", objArr));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.GetContactSyncConfig.PlaceComponentResult();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.GetContactSyncConfig.MyBillsEntityDataFactory();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 == 0 && i2 != i) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.BuiltInFictitiousFunctionClassFactory();
        }
        if (i == 0) {
            if (!lookAheadTest()) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext();
        } else if (i == 1) {
            int abs = Math.abs(this.newProxyInstance);
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (abs > i3) {
                int i4 = this.newProxyInstance;
                int i5 = i4 / i3;
                this.MyBillsEntityDataFactory += i5;
                this.newProxyInstance = i4 - (i5 * i3);
            }
            if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                this.MyBillsEntityDataFactory += Direction.fromDelta(this.newProxyInstance).applyTo(1);
                this.newProxyInstance = -Direction.fromDelta(this.newProxyInstance).applyTo(this.NetworkUserEntityData$$ExternalSyntheticLambda8 - Math.abs(this.newProxyInstance));
            }
            this.initRecordTimeStamp = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    private boolean lookAheadTest() {
        int i = this.initRecordTimeStamp;
        if (i != -1) {
            this.MyBillsEntityDataFactory = i;
            this.initRecordTimeStamp = -1;
            this.newProxyInstance = 0;
        }
        Direction fromDelta = Direction.fromDelta(this.newProxyInstance);
        if (Math.abs(this.newProxyInstance) == this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.MyBillsEntityDataFactory += fromDelta.applyTo(1);
            this.newProxyInstance = 0;
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Direction.fromDelta(this.newProxyInstance).applyTo(this.NetworkUserEntityData$$ExternalSyntheticLambda8 - Math.abs(this.newProxyInstance));
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -this.newProxyInstance;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == 0) {
            return true;
        }
        DiscreteLinearSmoothScroller discreteLinearSmoothScroller = new DiscreteLinearSmoothScroller(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        discreteLinearSmoothScroller.setTargetPosition(this.MyBillsEntityDataFactory);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.startSmoothScroll(discreteLinearSmoothScroller);
        return false;
    }

    public final void MyBillsEntityDataFactory(int i, int i2) {
        int BuiltInFictitiousFunctionClassFactory = this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(i, i2);
        int applyTo = this.MyBillsEntityDataFactory + Direction.fromDelta(BuiltInFictitiousFunctionClassFactory).applyTo(this.isLayoutRequested ? Math.abs(BuiltInFictitiousFunctionClassFactory / this.lookAheadTest) : 1);
        int itemCount = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getItemCount();
        int i3 = this.MyBillsEntityDataFactory;
        if (i3 == 0 || applyTo >= 0) {
            int i4 = itemCount - 1;
            if (i3 != i4 && applyTo >= itemCount) {
                applyTo = i4;
            }
        } else {
            applyTo = 0;
        }
        if ((BuiltInFictitiousFunctionClassFactory * this.newProxyInstance >= 0) && PlaceComponentResult(applyTo)) {
            BuiltInFictitiousFunctionClassFactory(applyTo);
            return;
        }
        int i5 = -this.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i5;
        if (i5 != 0) {
            getErrorConfigVersion();
        }
    }

    public final void MyBillsEntityDataFactory() {
        int i = -this.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        if (i != 0) {
            getErrorConfigVersion();
        }
    }

    private void getErrorConfigVersion() {
        DiscreteLinearSmoothScroller discreteLinearSmoothScroller = new DiscreteLinearSmoothScroller(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        discreteLinearSmoothScroller.setTargetPosition(this.MyBillsEntityDataFactory);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.startSmoothScroll(discreteLinearSmoothScroller);
    }

    private void BuiltInFictitiousFunctionClassFactory(int i) {
        int i2 = this.MyBillsEntityDataFactory;
        if (i2 == i) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -this.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 += Direction.fromDelta(i - i2).applyTo(Math.abs(i - this.MyBillsEntityDataFactory) * this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.initRecordTimeStamp = i;
        getErrorConfigVersion();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return getAuthRequestContext();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return getAuthRequestContext();
    }

    private int getAuthRequestContext() {
        int i = 0;
        if (getItemCount() == 0) {
            return 0;
        }
        if (getItemCount() != 0) {
            i = (getItemCount() - 1) * this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        return (int) (i / getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.initRecordTimeStamp = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        this.newProxyInstance = 0;
        if (adapter2 instanceof InitialPositionProvider) {
            this.MyBillsEntityDataFactory = ((InitialPositionProvider) adapter2).KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            this.MyBillsEntityDataFactory = 0;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        int i = this.initRecordTimeStamp;
        if (i != -1) {
            this.MyBillsEntityDataFactory = i;
        }
        bundle.putInt("extra_position", this.MyBillsEntityDataFactory);
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.MyBillsEntityDataFactory = ((Bundle) parcelable).getInt("extra_position");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.newProxyInstance;
        if (i == 0) {
            return this.MyBillsEntityDataFactory;
        }
        int i2 = this.initRecordTimeStamp;
        return i2 != -1 ? i2 : this.MyBillsEntityDataFactory + Direction.fromDelta(i).applyTo(1);
    }

    public final void MyBillsEntityDataFactory(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
        this.scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda8 * i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.requestLayout();
    }

    public final void getAuthRequestContext(int i) {
        this.FragmentBottomSheetPaymentSettingBinding = i;
        moveToNextValue();
    }

    public final int PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildCount() > 0) {
            AccessibilityRecordCompat MyBillsEntityDataFactory = AccessibilityEventCompat.MyBillsEntityDataFactory(accessibilityEvent);
            MyBillsEntityDataFactory.getAuthRequestContext(getPosition(this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildAt(0)));
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(getPosition(this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildAt(r0.getAuthRequestContext.getChildCount() - 1)));
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return ((float) Math.abs(this.newProxyInstance)) >= ((float) this.NetworkUserEntityData$$ExternalSyntheticLambda8) * 0.6f;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.scheduleImpl;
    }

    private boolean PlaceComponentResult(int i) {
        return i >= 0 && i < this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getItemCount();
    }

    private boolean MyBillsEntityDataFactory(Point point, int i) {
        return this.GetContactSyncConfig.MyBillsEntityDataFactory(point, this.PlaceComponentResult, this.getAuthRequestContext, i, this.scheduleImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class DiscreteLinearSmoothScroller extends LinearSmoothScroller {
        public DiscreteLinearSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i) {
            return DiscreteScrollLayoutManager.this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(-DiscreteScrollLayoutManager.this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i) {
            return DiscreteScrollLayoutManager.this.GetContactSyncConfig.getAuthRequestContext(-DiscreteScrollLayoutManager.this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i) {
            return (int) (Math.max(0.01f, Math.min(Math.abs(i), DiscreteScrollLayoutManager.this.NetworkUserEntityData$$ExternalSyntheticLambda8) / DiscreteScrollLayoutManager.this.NetworkUserEntityData$$ExternalSyntheticLambda8) * DiscreteScrollLayoutManager.this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            return new PointF(DiscreteScrollLayoutManager.this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(DiscreteScrollLayoutManager.this.NetworkUserEntityData$$ExternalSyntheticLambda2), DiscreteScrollLayoutManager.this.GetContactSyncConfig.getAuthRequestContext(DiscreteScrollLayoutManager.this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        int authRequestContext = getAuthRequestContext();
        return (this.MyBillsEntityDataFactory * authRequestContext) + ((int) ((this.newProxyInstance / this.NetworkUserEntityData$$ExternalSyntheticLambda8) * authRequestContext));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (getItemCount() == 0) {
            return 0;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 * (getItemCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        int authRequestContext = getAuthRequestContext();
        return (this.MyBillsEntityDataFactory * authRequestContext) + ((int) ((this.newProxyInstance / this.NetworkUserEntityData$$ExternalSyntheticLambda8) * authRequestContext));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (getItemCount() == 0) {
            return 0;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 * (getItemCount() - 1);
    }

    private void MyBillsEntityDataFactory(RecyclerView.Recycler recycler) {
        this.moveToNextValue.clear();
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildCount(); i++) {
            View childAt = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildAt(i);
            this.moveToNextValue.put(this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getPosition(childAt), childAt);
        }
        for (int i2 = 0; i2 < this.moveToNextValue.size(); i2++) {
            RecyclerViewProxy recyclerViewProxy = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            recyclerViewProxy.getAuthRequestContext.detachView(this.moveToNextValue.valueAt(i2));
        }
        this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.newProxyInstance, this.BuiltInFictitiousFunctionClassFactory);
        int authRequestContext = this.GetContactSyncConfig.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getWidth(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getHeight());
        if (MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, authRequestContext)) {
            MyBillsEntityDataFactory(recycler, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(recycler, Direction.START, authRequestContext);
        KClassImpl$Data$declaredNonStaticMembers$2(recycler, Direction.END, authRequestContext);
        for (int i3 = 0; i3 < this.moveToNextValue.size(); i3++) {
            RecyclerViewProxy.MyBillsEntityDataFactory(this.moveToNextValue.valueAt(i3), recycler);
        }
        this.moveToNextValue.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r0 >= r1) goto L17;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }
}
