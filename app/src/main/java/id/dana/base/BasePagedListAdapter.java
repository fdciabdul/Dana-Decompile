package id.dana.base;

import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import id.dana.base.BaseRecyclerViewHolder;

/* loaded from: classes4.dex */
public abstract class BasePagedListAdapter<VH extends BaseRecyclerViewHolder<T>, T> extends PagedListAdapter<T, VH> {
    public BaseRecyclerViewHolder.OnItemClickListener MyBillsEntityDataFactory;

    public BasePagedListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        super(itemCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: PlaceComponentResult */
    public void onBindViewHolder(VH vh, int i) {
        T t;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        PagedList<T> pagedList = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
        PagedList<T> pagedList2 = asyncPagedListDiffer.moveToNextValue;
        if (pagedList != null) {
            t = pagedList.get(i);
        } else if (pagedList2 != null) {
            pagedList2.getAuthRequestContext(i);
            t = pagedList2.get(i);
        } else {
            throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
        }
        vh.bindData(t);
        vh.setOnItemClickListener(this.MyBillsEntityDataFactory);
    }
}
