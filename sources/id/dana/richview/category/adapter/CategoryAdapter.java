package id.dana.richview.category.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.category.adapter.viewholder.CategorySkeletonViewHolder;
import id.dana.richview.category.adapter.viewholder.ChipCategoryViewHolder;
import id.dana.richview.category.model.CategoryModel;

/* loaded from: classes5.dex */
public class CategoryAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<CategoryModel>, CategoryModel> {
    public int MyBillsEntityDataFactory = 0;
    private BaseRecyclerViewHolder.OnItemClickListener PlaceComponentResult;

    public CategoryAdapter(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.PlaceComponentResult = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItem(i).scheduleImpl;
    }

    public final boolean PlaceComponentResult(int i) {
        return i == this.MyBillsEntityDataFactory;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (1 == i) {
            return new ChipCategoryViewHolder(viewGroup, this.PlaceComponentResult);
        }
        return new CategorySkeletonViewHolder(viewGroup);
    }
}
