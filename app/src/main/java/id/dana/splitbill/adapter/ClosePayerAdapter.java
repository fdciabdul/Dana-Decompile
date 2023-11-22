package id.dana.splitbill.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.splitbill.adapter.ClosePayerViewHolder;
import id.dana.splitbill.model.PayerModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ClosePayerAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PayerModel>, PayerModel> {
    private OnAllCheckBoxEventFinishedListener BuiltInFictitiousFunctionClassFactory;
    private ClosePayerViewHolder.OnCheckedListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes5.dex */
    public interface OnAllCheckBoxEventFinishedListener {
        void BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ClosePayerAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    public ClosePayerAdapter(ClosePayerViewHolder.OnCheckedListener onCheckedListener, OnAllCheckBoxEventFinishedListener onAllCheckBoxEventFinishedListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onCheckedListener;
        this.BuiltInFictitiousFunctionClassFactory = onAllCheckBoxEventFinishedListener;
    }

    public final List<PayerModel> getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        for (PayerModel payerModel : getItems()) {
            if (payerModel.BuiltInFictitiousFunctionClassFactory()) {
                arrayList.add(payerModel);
            }
        }
        return arrayList;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void onBindViewHolder(BaseRecyclerViewHolder<PayerModel> baseRecyclerViewHolder, int i) {
        baseRecyclerViewHolder.bindData(getItem(i));
        if (i == getItems().size() - 1) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ClosePayerViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
