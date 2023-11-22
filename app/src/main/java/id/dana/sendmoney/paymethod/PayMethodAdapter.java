package id.dana.sendmoney.paymethod;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney_v2.paymethod.viewholder.AddCardViewHolder;
import id.dana.sendmoney_v2.paymethod.viewholder.BalanceViewHolder;
import id.dana.sendmoney_v2.paymethod.viewholder.DebitCardViewHolder;
import id.dana.sendmoney_v2.paymethod.viewholder.DirectDebitViewHolder;
import id.dana.sendmoney_v2.paymethod.viewholder.OneKlikViewHolder;
import id.dana.sendmoney_v2.paymethod.viewholder.SectionViewHolder;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PayMethodAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PayMethodModel>, PayMethodModel> {
    private BaseRecyclerViewHolder.OnItemClickListener BuiltInFictitiousFunctionClassFactory;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public TopUpButtonListener MyBillsEntityDataFactory;
    public boolean PlaceComponentResult = false;

    /* loaded from: classes5.dex */
    public interface TopUpButtonListener {
        void getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public PayMethodAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItem(i).BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder.OnItemClickListener getOnItemClickListener() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.BuiltInFictitiousFunctionClassFactory = onItemClickListener;
    }

    public final PayMethodModel KClassImpl$Data$declaredNonStaticMembers$2() {
        for (PayMethodModel payMethodModel : getItems()) {
            if (6 != payMethodModel.BuiltInFictitiousFunctionClassFactory() && !"BALANCE".equals(payMethodModel.newProxyInstance)) {
                return payMethodModel;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.PlaceComponentResult) {
                return new AddCardViewHolder(viewGroup);
            }
            return new id.dana.sendmoney.paymethod.viewholder.AddCardViewHolder(viewGroup);
        } else if (i == 1) {
            if (this.PlaceComponentResult) {
                return new BalanceViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
            }
            return new id.dana.sendmoney.paymethod.viewholder.BalanceViewHolder(viewGroup);
        } else if (i == 3) {
            if (this.PlaceComponentResult) {
                return new DirectDebitViewHolder(viewGroup);
            }
            return new id.dana.sendmoney.paymethod.viewholder.DirectDebitViewHolder(viewGroup);
        } else if (i == 4) {
            if (this.PlaceComponentResult) {
                return new OneKlikViewHolder(viewGroup);
            }
            return new id.dana.sendmoney.paymethod.viewholder.OneKlikViewHolder(viewGroup);
        } else if (i != 6) {
            if (this.PlaceComponentResult) {
                return new DebitCardViewHolder(viewGroup);
            }
            return new id.dana.sendmoney.paymethod.viewholder.DebitCardViewHolder(viewGroup);
        } else if (this.PlaceComponentResult) {
            return new SectionViewHolder(viewGroup);
        } else {
            return new id.dana.sendmoney.paymethod.viewholder.SectionViewHolder(viewGroup);
        }
    }
}
