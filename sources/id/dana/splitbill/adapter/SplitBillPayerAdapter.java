package id.dana.splitbill.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.splitbill.adapter.PayerViewHolder;
import id.dana.splitbill.model.SplitBillPayerModel;
import java.util.List;

/* loaded from: classes5.dex */
public class SplitBillPayerAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SplitBillPayerModel>, SplitBillPayerModel> {
    public SplitBillPayerModel BuiltInFictitiousFunctionClassFactory;
    public PayerViewHolder.OnModifyPayerListener MyBillsEntityDataFactory;
    private long PlaceComponentResult;

    public SplitBillPayerAdapter(long j) {
        SplitBillPayerModel splitBillPayerModel = new SplitBillPayerModel();
        this.BuiltInFictitiousFunctionClassFactory = splitBillPayerModel;
        splitBillPayerModel.GetContactSyncConfig = 1;
        this.PlaceComponentResult = j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItem(i).GetContactSyncConfig;
    }

    public final void BuiltInFictitiousFunctionClassFactory(List<SplitBillPayerModel> list) {
        SplitBillPayerModel item = getItem(0);
        getItems().clear();
        getItems().add(item);
        if (!getItems().contains(this.BuiltInFictitiousFunctionClassFactory)) {
            super.appendItems(list);
            appendItem(this.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        super.addItemsAt(getPlaceComponentResult() - 1, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new AddMorePayerViewHolder(viewGroup);
        }
        return new PayerViewHolder(viewGroup, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
    }
}
