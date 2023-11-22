package id.dana.richview.bank;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.model.BankModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class AutoCompleteBankAdapter extends BaseRecyclerViewAdapter<ViewHolder, BankModel> implements Filterable {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    List<BankModel> MyBillsEntityDataFactory;
    private List<BankModel> PlaceComponentResult;

    /* loaded from: classes9.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder getAuthRequestContext;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.getAuthRequestContext = viewHolder;
            viewHolder.ivBankLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_bank_logo, "field 'ivBankLogo'", ImageView.class);
            viewHolder.tvBankName = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_bank_name, "field 'tvBankName'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            ViewHolder viewHolder = this.getAuthRequestContext;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.getAuthRequestContext = null;
            viewHolder.ivBankLogo = null;
            viewHolder.tvBankName = null;
        }
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: id.dana.richview.bank.AutoCompleteBankAdapter.1
            {
                AutoCompleteBankAdapter.this = this;
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                AutoCompleteBankAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2 = charSequence.toString();
                ArrayList arrayList = new ArrayList();
                for (BankModel bankModel : AutoCompleteBankAdapter.this.MyBillsEntityDataFactory) {
                    if (bankModel.scheduleImpl.toLowerCase().contains(AutoCompleteBankAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.toLowerCase())) {
                        arrayList.add(bankModel);
                    }
                    if (arrayList.size() == 3) {
                        break;
                    }
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                AutoCompleteBankAdapter.this.PlaceComponentResult = (ArrayList) filterResults.values;
                AutoCompleteBankAdapter autoCompleteBankAdapter = AutoCompleteBankAdapter.this;
                autoCompleteBankAdapter.setItems(autoCompleteBankAdapter.PlaceComponentResult);
            }
        };
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public List<BankModel> getItems() {
        return this.MyBillsEntityDataFactory;
    }

    /* loaded from: classes9.dex */
    protected class ViewHolder extends BaseRecyclerViewHolder<BankModel> {
        boolean BuiltInFictitiousFunctionClassFactory;
        @BindView(R.id.iv_bank_logo)
        ImageView ivBankLogo;
        @BindView(R.id.tv_bank_name)
        TextView tvBankName;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public /* synthetic */ void bindData(BankModel bankModel) {
            BankModel bankModel2 = bankModel;
            boolean myBillsEntityDataFactory = bankModel2.getMyBillsEntityDataFactory();
            this.BuiltInFictitiousFunctionClassFactory = myBillsEntityDataFactory;
            if (!myBillsEntityDataFactory) {
                this.tvBankName.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24012131099998));
            }
            this.tvBankName.setText(bankModel2.scheduleImpl);
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(bankModel2.PlaceComponentResult()).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).SubSequence().MyBillsEntityDataFactory(this.ivBankLogo);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(Context context, ViewGroup viewGroup) {
            super(context, R.layout.item_bank, viewGroup);
            AutoCompleteBankAdapter.this = r1;
        }

        @Override // id.dana.base.BaseRecyclerViewHolder
        public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                super.setOnItemClickListener(onItemClickListener);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(viewGroup.getContext(), viewGroup);
    }
}
