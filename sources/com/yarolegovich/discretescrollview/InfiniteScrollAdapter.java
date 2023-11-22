package com.yarolegovich.discretescrollview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager;

/* loaded from: classes8.dex */
public class InfiniteScrollAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> implements DiscreteScrollLayoutManager.InitialPositionProvider {
    private RecyclerView.Adapter<T> BuiltInFictitiousFunctionClassFactory;
    private DiscreteScrollLayoutManager KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.BuiltInFictitiousFunctionClassFactory.onAttachedToRecyclerView(recyclerView);
        if (recyclerView instanceof DiscreteScrollView) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (DiscreteScrollLayoutManager) recyclerView.getLayoutManager();
            return;
        }
        throw new RuntimeException(recyclerView.getContext().getString(R.string.dsv_ex_msg_adapter_wrong_recycler));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.BuiltInFictitiousFunctionClassFactory.onDetachedFromRecyclerView(recyclerView);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.BuiltInFictitiousFunctionClassFactory.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(T t, int i) {
        if (PlaceComponentResult(i)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.scrollToPosition(BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()) + 1073741823);
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.onBindViewHolder(t, BuiltInFictitiousFunctionClassFactory(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.BuiltInFictitiousFunctionClassFactory.getItemViewType(BuiltInFictitiousFunctionClassFactory(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getGetAuthRequestContext() {
        if (BuiltInFictitiousFunctionClassFactory()) {
            return Integer.MAX_VALUE;
        }
        return this.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext();
    }

    private int BuiltInFictitiousFunctionClassFactory(int i) {
        if (i < 1073741823) {
            int getAuthRequestContext = (1073741823 - i) % this.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext();
            if (getAuthRequestContext == 0) {
                return 0;
            }
            return this.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext() - getAuthRequestContext;
        }
        return (i - 1073741823) % this.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext();
    }

    private boolean PlaceComponentResult(int i) {
        return BuiltInFictitiousFunctionClassFactory() && (i <= 100 || i >= 2147483547);
    }

    final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext() > 1;
    }

    @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.InitialPositionProvider
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return BuiltInFictitiousFunctionClassFactory() ? 1073741823 : 0;
    }

    /* loaded from: classes8.dex */
    class DataSetChangeDelegate extends RecyclerView.AdapterDataObserver {
        final /* synthetic */ InfiniteScrollAdapter PlaceComponentResult;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            InfiniteScrollAdapter infiniteScrollAdapter = this.PlaceComponentResult;
            InfiniteScrollAdapter.KClassImpl$Data$declaredNonStaticMembers$2(infiniteScrollAdapter, infiniteScrollAdapter.BuiltInFictitiousFunctionClassFactory() ? 1073741823 : 0);
            this.PlaceComponentResult.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            InfiniteScrollAdapter infiniteScrollAdapter = this.PlaceComponentResult;
            infiniteScrollAdapter.notifyItemRangeChanged(0, infiniteScrollAdapter.getGetAuthRequestContext());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            InfiniteScrollAdapter infiniteScrollAdapter = this.PlaceComponentResult;
            infiniteScrollAdapter.notifyItemRangeChanged(0, infiniteScrollAdapter.getGetAuthRequestContext(), obj);
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(InfiniteScrollAdapter infiniteScrollAdapter, int i) {
        infiniteScrollAdapter.KClassImpl$Data$declaredNonStaticMembers$2.scrollToPosition(i);
    }
}
