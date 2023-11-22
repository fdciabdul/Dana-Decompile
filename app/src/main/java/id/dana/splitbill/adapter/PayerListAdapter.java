package id.dana.splitbill.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.splitbill.model.PayerModel;

/* loaded from: classes5.dex */
public class PayerListAdapter extends BaseRecyclerViewAdapter<PayerListViewHolder, PayerModel> {
    public boolean BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((PayerListViewHolder) viewHolder).MyBillsEntityDataFactory(getItem(i), this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public /* synthetic */ void onBindViewHolder(PayerListViewHolder payerListViewHolder, int i) {
        payerListViewHolder.MyBillsEntityDataFactory(getItem(i), this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PayerListViewHolder(viewGroup);
    }
}
