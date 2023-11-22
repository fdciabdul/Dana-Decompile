package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.yarolegovich.discretescrollview.util.ScrollListenerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class DiscreteScrollView extends RecyclerView {
    private static final int BuiltInFictitiousFunctionClassFactory = DSVOrientation.HORIZONTAL.ordinal();
    public static final int NO_POSITION = -1;
    private DiscreteScrollLayoutManager KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private List<ScrollStateChangeListener> getErrorConfigVersion;
    private List<OnItemChangedListener> moveToNextValue;

    /* loaded from: classes8.dex */
    public interface OnItemChangedListener<T extends RecyclerView.ViewHolder> {
    }

    /* loaded from: classes8.dex */
    public interface ScrollListener<T extends RecyclerView.ViewHolder> {
    }

    /* loaded from: classes8.dex */
    public interface ScrollStateChangeListener<T extends RecyclerView.ViewHolder> {
    }

    public DiscreteScrollView(Context context) {
        super(context);
        PlaceComponentResult(null);
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PlaceComponentResult(attributeSet);
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlaceComponentResult(attributeSet);
    }

    private void PlaceComponentResult(AttributeSet attributeSet) {
        this.getErrorConfigVersion = new ArrayList();
        this.moveToNextValue = new ArrayList();
        int i = BuiltInFictitiousFunctionClassFactory;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.isLayoutRequested);
            i = obtainStyledAttributes.getInt(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8, i);
            obtainStyledAttributes.recycle();
        }
        byte b = 0;
        this.MyBillsEntityDataFactory = getOverScrollMode() != 2;
        DiscreteScrollLayoutManager discreteScrollLayoutManager = new DiscreteScrollLayoutManager(getContext(), new ScrollStateListener(this, b), DSVOrientation.values()[i]);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = discreteScrollLayoutManager;
        setLayoutManager(discreteScrollLayoutManager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof DiscreteScrollLayoutManager) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException(getContext().getString(R.string.dsv_ex_msg_dont_set_lm));
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        boolean fling = super.fling(i, i2);
        if (fling) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i, i2);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }
        return fling;
    }

    public RecyclerView.ViewHolder getViewHolder(int i) {
        View findViewByPosition = this.KClassImpl$Data$declaredNonStaticMembers$2.findViewByPosition(i);
        if (findViewByPosition != null) {
            return getChildViewHolder(findViewByPosition);
        }
        return null;
    }

    public int getCurrentItem() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
    }

    public void setItemTransformer(DiscreteScrollItemTransformer discreteScrollItemTransformer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = discreteScrollItemTransformer;
    }

    public void setItemTransitionTimeMillis(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
    }

    public void setSlideOnFling(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested = z;
    }

    public void setSlideOnFlingThreshold(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = i;
    }

    public void setOrientation(DSVOrientation dSVOrientation) {
        DiscreteScrollLayoutManager discreteScrollLayoutManager = this.KClassImpl$Data$declaredNonStaticMembers$2;
        discreteScrollLayoutManager.GetContactSyncConfig = dSVOrientation.createHelper();
        discreteScrollLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.removeAllViews();
        discreteScrollLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.requestLayout();
    }

    public void setOffscreenItems(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i);
    }

    public void setClampTransformProgressAfter(int i) {
        if (i <= 1) {
            throw new IllegalArgumentException("must be >= 1");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(i);
    }

    public void setOverScrollEnabled(boolean z) {
        this.MyBillsEntityDataFactory = z;
        setOverScrollMode(2);
    }

    public void addScrollStateChangeListener(ScrollStateChangeListener<?> scrollStateChangeListener) {
        this.getErrorConfigVersion.add(scrollStateChangeListener);
    }

    public void addScrollListener(ScrollListener<?> scrollListener) {
        addScrollStateChangeListener(new ScrollListenerAdapter(scrollListener));
    }

    public void addOnItemChangedListener(OnItemChangedListener<?> onItemChangedListener) {
        this.moveToNextValue.add(onItemChangedListener);
    }

    public void removeScrollStateChangeListener(ScrollStateChangeListener<?> scrollStateChangeListener) {
        this.getErrorConfigVersion.remove(scrollStateChangeListener);
    }

    public void removeScrollListener(ScrollListener<?> scrollListener) {
        removeScrollStateChangeListener(new ScrollListenerAdapter(scrollListener));
    }

    public void removeItemChangedListener(OnItemChangedListener<?> onItemChangedListener) {
        this.moveToNextValue.remove(onItemChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory() {
        for (OnItemChangedListener onItemChangedListener : this.moveToNextValue) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class ScrollStateListener implements DiscreteScrollLayoutManager.ScrollStateListener {
        private ScrollStateListener() {
        }

        /* synthetic */ ScrollStateListener(DiscreteScrollView discreteScrollView, byte b) {
            this();
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            if (DiscreteScrollView.this.MyBillsEntityDataFactory) {
                DiscreteScrollView.this.setOverScrollMode(z ? 0 : 2);
            }
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            int PlaceComponentResult;
            RecyclerView.ViewHolder viewHolder;
            if (DiscreteScrollView.this.getErrorConfigVersion.isEmpty() || (viewHolder = DiscreteScrollView.this.getViewHolder((PlaceComponentResult = DiscreteScrollView.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()))) == null) {
                return;
            }
            DiscreteScrollView.access$400(DiscreteScrollView.this, viewHolder, PlaceComponentResult);
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public final void getAuthRequestContext() {
            int PlaceComponentResult;
            RecyclerView.ViewHolder viewHolder;
            if ((DiscreteScrollView.this.moveToNextValue.isEmpty() && DiscreteScrollView.this.getErrorConfigVersion.isEmpty()) || (viewHolder = DiscreteScrollView.this.getViewHolder((PlaceComponentResult = DiscreteScrollView.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()))) == null) {
                return;
            }
            DiscreteScrollView.access$600(DiscreteScrollView.this, viewHolder, PlaceComponentResult);
            DiscreteScrollView.this.MyBillsEntityDataFactory();
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public final void getAuthRequestContext(float f) {
            int currentItem;
            int KClassImpl$Data$declaredNonStaticMembers$2;
            if (DiscreteScrollView.this.getErrorConfigVersion.isEmpty() || (currentItem = DiscreteScrollView.this.getCurrentItem()) == (KClassImpl$Data$declaredNonStaticMembers$2 = DiscreteScrollView.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2())) {
                return;
            }
            DiscreteScrollView discreteScrollView = DiscreteScrollView.this;
            DiscreteScrollView.access$800(discreteScrollView, f, currentItem, KClassImpl$Data$declaredNonStaticMembers$2, discreteScrollView.getViewHolder(currentItem), DiscreteScrollView.this.getViewHolder(KClassImpl$Data$declaredNonStaticMembers$2));
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public final void PlaceComponentResult() {
            DiscreteScrollView.this.post(new Runnable() { // from class: com.yarolegovich.discretescrollview.DiscreteScrollView.ScrollStateListener.1
                @Override // java.lang.Runnable
                public void run() {
                    DiscreteScrollView.access$900(DiscreteScrollView.this);
                }
            });
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public final void MyBillsEntityDataFactory() {
            DiscreteScrollView.access$900(DiscreteScrollView.this);
        }
    }

    static /* synthetic */ void access$400(DiscreteScrollView discreteScrollView, RecyclerView.ViewHolder viewHolder, int i) {
        for (ScrollStateChangeListener scrollStateChangeListener : discreteScrollView.getErrorConfigVersion) {
        }
    }

    static /* synthetic */ void access$600(DiscreteScrollView discreteScrollView, RecyclerView.ViewHolder viewHolder, int i) {
        for (ScrollStateChangeListener scrollStateChangeListener : discreteScrollView.getErrorConfigVersion) {
        }
    }

    static /* synthetic */ void access$800(DiscreteScrollView discreteScrollView, float f, int i, int i2, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        for (ScrollStateChangeListener scrollStateChangeListener : discreteScrollView.getErrorConfigVersion) {
        }
    }

    static /* synthetic */ void access$900(DiscreteScrollView discreteScrollView) {
        if (discreteScrollView.moveToNextValue.isEmpty()) {
            return;
        }
        discreteScrollView.getViewHolder(discreteScrollView.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
        discreteScrollView.MyBillsEntityDataFactory();
    }
}
