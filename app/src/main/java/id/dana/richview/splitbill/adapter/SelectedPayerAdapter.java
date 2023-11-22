package id.dana.richview.splitbill.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.splitbill.adapter.viewholder.RecentContactPayerViewHolder;
import id.dana.richview.splitbill.adapter.viewholder.SelectedContactPayerViewHolder;
import id.dana.sendmoney.model.RecipientModel;

/* loaded from: classes5.dex */
public class SelectedPayerAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<RecipientModel>, RecipientModel> {
    public Listener MyBillsEntityDataFactory;

    /* loaded from: classes5.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory(RecipientModel recipientModel);

        void PlaceComponentResult(RecipientModel recipientModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        String str = getItem(i).readMicros;
        str.hashCode();
        return !str.equals("recentContacts") ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new RecentContactPayerViewHolder(viewGroup, this.MyBillsEntityDataFactory);
        }
        return new SelectedContactPayerViewHolder(viewGroup, this.MyBillsEntityDataFactory);
    }
}
