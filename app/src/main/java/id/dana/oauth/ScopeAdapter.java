package id.dana.oauth;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.oauth.model.ScopeModel;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class ScopeAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ScopeModel>, ScopeModel> {
    public boolean getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ScopeAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public ScopeAdapter() {
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void onBindViewHolder(BaseRecyclerViewHolder<ScopeModel> baseRecyclerViewHolder, int i) {
        super.onBindViewHolder((ScopeAdapter) baseRecyclerViewHolder, i);
        if (getItem(i).MyBillsEntityDataFactory.equals("Item Powered By Alipay")) {
            baseRecyclerViewHolder.bindData(getItem(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItem(i).MyBillsEntityDataFactory.equals("Item Powered By Alipay") ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new PoweredByAlipayViewHolder(viewGroup);
        }
        return new ScopeViewHolder(viewGroup, this.getAuthRequestContext);
    }
}
