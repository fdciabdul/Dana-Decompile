package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    RecyclerView BuiltInFictitiousFunctionClassFactory;
    private final RecyclerView.OnScrollListener KClassImpl$Data$declaredNonStaticMembers$2 = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.SnapHelper.1
        boolean BuiltInFictitiousFunctionClassFactory = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.BuiltInFictitiousFunctionClassFactory) {
                this.BuiltInFictitiousFunctionClassFactory = false;
                SnapHelper.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
    };
    private Scroller getAuthRequestContext;

    public abstract int PlaceComponentResult(RecyclerView.LayoutManager layoutManager, int i, int i2);

    public abstract View PlaceComponentResult(RecyclerView.LayoutManager layoutManager);

    public abstract int[] getAuthRequestContext(RecyclerView.LayoutManager layoutManager, View view);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.BuiltInFictitiousFunctionClassFactory.getLayoutManager();
        if (layoutManager == null || this.BuiltInFictitiousFunctionClassFactory.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.BuiltInFictitiousFunctionClassFactory.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && KClassImpl$Data$declaredNonStaticMembers$2(layoutManager, i, i2);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.BuiltInFictitiousFunctionClassFactory;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.BuiltInFictitiousFunctionClassFactory.setOnFlingListener(null);
        }
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.BuiltInFictitiousFunctionClassFactory.addOnScrollListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.BuiltInFictitiousFunctionClassFactory.setOnFlingListener(this);
            this.getAuthRequestContext = new Scroller(this.BuiltInFictitiousFunctionClassFactory.getContext(), new DecelerateInterpolator());
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final int[] getAuthRequestContext(int i, int i2) {
        this.getAuthRequestContext.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.getAuthRequestContext.getFinalX(), this.getAuthRequestContext.getFinalY()};
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        RecyclerView.SmoothScroller KClassImpl$Data$declaredNonStaticMembers$2;
        int PlaceComponentResult;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(layoutManager)) == null || (PlaceComponentResult = PlaceComponentResult(layoutManager, i, i2)) == -1) {
            return false;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.setTargetPosition(PlaceComponentResult);
        layoutManager.startSmoothScroll(KClassImpl$Data$declaredNonStaticMembers$2);
        return true;
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2() {
        RecyclerView.LayoutManager layoutManager;
        View PlaceComponentResult;
        RecyclerView recyclerView = this.BuiltInFictitiousFunctionClassFactory;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (PlaceComponentResult = PlaceComponentResult(layoutManager)) == null) {
            return;
        }
        int[] authRequestContext = getAuthRequestContext(layoutManager, PlaceComponentResult);
        int i = authRequestContext[0];
        if (i == 0 && authRequestContext[1] == 0) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.smoothScrollBy(i, authRequestContext[1]);
    }

    protected RecyclerView.SmoothScroller KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.BuiltInFictitiousFunctionClassFactory.getContext()) { // from class: androidx.recyclerview.widget.SnapHelper.2
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    if (SnapHelper.this.BuiltInFictitiousFunctionClassFactory == null) {
                        return;
                    }
                    SnapHelper snapHelper = SnapHelper.this;
                    int[] authRequestContext = snapHelper.getAuthRequestContext(snapHelper.BuiltInFictitiousFunctionClassFactory.getLayoutManager(), view);
                    int i = authRequestContext[0];
                    int i2 = authRequestContext[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
                        action.BuiltInFictitiousFunctionClassFactory = i;
                        action.getAuthRequestContext = i2;
                        action.MyBillsEntityDataFactory = calculateTimeForDeceleration;
                        action.KClassImpl$Data$declaredNonStaticMembers$2 = decelerateInterpolator;
                        action.PlaceComponentResult = true;
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
