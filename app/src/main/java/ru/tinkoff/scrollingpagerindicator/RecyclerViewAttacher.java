package ru.tinkoff.scrollingpagerindicator;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

/* loaded from: classes6.dex */
public class RecyclerViewAttacher implements ScrollingPagerIndicator.PagerAttacher<RecyclerView> {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private RecyclerView.AdapterDataObserver KClassImpl$Data$declaredNonStaticMembers$2;
    private RecyclerView.Adapter<?> MyBillsEntityDataFactory;
    private LinearLayoutManager NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final int PlaceComponentResult;
    private ScrollingPagerIndicator getAuthRequestContext;
    private int getErrorConfigVersion;
    private RecyclerView.OnScrollListener lookAheadTest;
    private RecyclerView moveToNextValue;

    @Override // ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.PagerAttacher
    public final /* synthetic */ void PlaceComponentResult(final ScrollingPagerIndicator scrollingPagerIndicator, RecyclerView recyclerView) {
        RecyclerView recyclerView2 = recyclerView;
        if (!(recyclerView2.getLayoutManager() instanceof LinearLayoutManager)) {
            throw new IllegalStateException("Only LinearLayoutManager is supported");
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearLayoutManager;
        if (linearLayoutManager.getOrientation() != 0) {
            throw new IllegalStateException("Only HORIZONTAL orientation is supported");
        }
        this.moveToNextValue = recyclerView2;
        this.MyBillsEntityDataFactory = recyclerView2.getAdapter();
        this.getAuthRequestContext = scrollingPagerIndicator;
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: ru.tinkoff.scrollingpagerindicator.RecyclerViewAttacher.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                scrollingPagerIndicator.setDotCount(RecyclerViewAttacher.this.MyBillsEntityDataFactory.getPlaceComponentResult());
                RecyclerViewAttacher.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, Object obj) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                onChanged();
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = adapterDataObserver;
        this.MyBillsEntityDataFactory.registerAdapterDataObserver(adapterDataObserver);
        scrollingPagerIndicator.setDotCount(this.MyBillsEntityDataFactory.getPlaceComponentResult());
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: ru.tinkoff.scrollingpagerindicator.RecyclerViewAttacher.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView3, int i) {
                int BuiltInFictitiousFunctionClassFactory;
                if (i == 0 && RecyclerViewAttacher.this.lookAheadTest() && (BuiltInFictitiousFunctionClassFactory = RecyclerViewAttacher.this.BuiltInFictitiousFunctionClassFactory()) != -1) {
                    scrollingPagerIndicator.setDotCount(RecyclerViewAttacher.this.MyBillsEntityDataFactory.getPlaceComponentResult());
                    if (BuiltInFictitiousFunctionClassFactory < RecyclerViewAttacher.this.MyBillsEntityDataFactory.getPlaceComponentResult()) {
                        scrollingPagerIndicator.setCurrentPosition(BuiltInFictitiousFunctionClassFactory);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView3, int i, int i2) {
                RecyclerViewAttacher.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        };
        this.lookAheadTest = onScrollListener;
        this.moveToNextValue.addOnScrollListener(onScrollListener);
    }

    public RecyclerViewAttacher() {
        this.PlaceComponentResult = 0;
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    public RecyclerViewAttacher(int i) {
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    @Override // ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.PagerAttacher
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.unregisterAdapterDataObserver(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.moveToNextValue.removeOnScrollListener(this.lookAheadTest);
        this.getErrorConfigVersion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int childAdapterPosition;
        float f;
        View KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || (childAdapterPosition = this.moveToNextValue.getChildAdapterPosition(KClassImpl$Data$declaredNonStaticMembers$2)) == -1) {
            return;
        }
        int placeComponentResult = this.MyBillsEntityDataFactory.getPlaceComponentResult();
        if (childAdapterPosition >= placeComponentResult && placeComponentResult != 0) {
            childAdapterPosition %= placeComponentResult;
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            f = (this.moveToNextValue.getMeasuredWidth() - PlaceComponentResult()) / 2.0f;
        } else {
            f = this.PlaceComponentResult;
        }
        float x = (f - KClassImpl$Data$declaredNonStaticMembers$2.getX()) / KClassImpl$Data$declaredNonStaticMembers$2.getMeasuredWidth();
        if (x < 0.0f || x > 1.0f || childAdapterPosition >= placeComponentResult) {
            return;
        }
        this.getAuthRequestContext.onPageScrolled(childAdapterPosition, x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BuiltInFictitiousFunctionClassFactory() {
        float f;
        RecyclerView.ViewHolder findContainingViewHolder;
        for (int i = 0; i < this.moveToNextValue.getChildCount(); i++) {
            View childAt = this.moveToNextValue.getChildAt(i);
            float x = childAt.getX();
            if (this.BuiltInFictitiousFunctionClassFactory) {
                f = (this.moveToNextValue.getMeasuredWidth() - PlaceComponentResult()) / 2.0f;
            } else {
                f = this.PlaceComponentResult;
            }
            if (x >= f && childAt.getX() + childAt.getMeasuredWidth() <= MyBillsEntityDataFactory() && (findContainingViewHolder = this.moveToNextValue.findContainingViewHolder(childAt)) != null && findContainingViewHolder.getAdapterPosition() != -1) {
                return findContainingViewHolder.getAdapterPosition();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lookAheadTest() {
        return BuiltInFictitiousFunctionClassFactory() != -1;
    }

    private View KClassImpl$Data$declaredNonStaticMembers$2() {
        float f;
        int childCount = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getChildAt(i2);
            int x = (int) childAt.getX();
            if (childAt.getMeasuredWidth() + x < i) {
                float measuredWidth = childAt.getMeasuredWidth() + x;
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    f = (this.moveToNextValue.getMeasuredWidth() - PlaceComponentResult()) / 2.0f;
                } else {
                    f = this.PlaceComponentResult;
                }
                if (measuredWidth > f) {
                    view = childAt;
                    i = x;
                }
            }
        }
        return view;
    }

    private float MyBillsEntityDataFactory() {
        float f;
        float PlaceComponentResult;
        if (this.BuiltInFictitiousFunctionClassFactory) {
            f = (this.moveToNextValue.getMeasuredWidth() - PlaceComponentResult()) / 2.0f;
            PlaceComponentResult = PlaceComponentResult();
        } else {
            f = this.PlaceComponentResult;
            PlaceComponentResult = PlaceComponentResult();
        }
        return f + PlaceComponentResult;
    }

    private float PlaceComponentResult() {
        int i;
        if (this.getErrorConfigVersion == 0) {
            for (int i2 = 0; i2 < this.moveToNextValue.getChildCount(); i2++) {
                View childAt = this.moveToNextValue.getChildAt(i2);
                if (childAt.getMeasuredWidth() != 0) {
                    i = childAt.getMeasuredWidth();
                    this.getErrorConfigVersion = i;
                    break;
                }
            }
        }
        i = this.getErrorConfigVersion;
        return i;
    }
}
