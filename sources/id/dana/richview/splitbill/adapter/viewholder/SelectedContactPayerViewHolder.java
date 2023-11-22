package id.dana.richview.splitbill.adapter.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.CircleImageSelectionView;
import id.dana.richview.splitbill.adapter.SelectedPayerAdapter;
import id.dana.sendmoney.RecentDetailView;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.utils.MaskedTextUtil;

/* loaded from: classes5.dex */
public class SelectedContactPayerViewHolder extends BaseRecyclerViewHolder<RecipientModel> {
    SelectedPayerAdapter.Listener PlaceComponentResult;
    @BindView(R.id.view_recent_detail)
    RecentDetailView recentDetailView;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(RecipientModel recipientModel) {
        final RecipientModel recipientModel2 = recipientModel;
        if (recipientModel2 != null) {
            RecentDetailView recentDetailView = this.recentDetailView;
            String PlaceComponentResult = recipientModel2.PlaceComponentResult();
            if (TextUtils.isEmpty(PlaceComponentResult) || "splitBillPayer".equals(PlaceComponentResult) || "-".equals(PlaceComponentResult)) {
                PlaceComponentResult = getContext().getString(R.string.payer);
            }
            recentDetailView.setView(PlaceComponentResult, MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(recipientModel2.getErrorConfigVersion), recipientModel2.BuiltInFictitiousFunctionClassFactory(), "contacts", true, true);
            this.recentDetailView.setOnClickCrossIconListener(new CircleImageSelectionView.Listener() { // from class: id.dana.richview.splitbill.adapter.viewholder.SelectedContactPayerViewHolder$$ExternalSyntheticLambda0
                @Override // id.dana.richview.CircleImageSelectionView.Listener
                public final void MyBillsEntityDataFactory() {
                    SelectedContactPayerViewHolder selectedContactPayerViewHolder = SelectedContactPayerViewHolder.this;
                    RecipientModel recipientModel3 = recipientModel2;
                    SelectedPayerAdapter.Listener listener = selectedContactPayerViewHolder.PlaceComponentResult;
                    if (listener != null) {
                        listener.BuiltInFictitiousFunctionClassFactory(recipientModel3);
                    }
                }
            });
        }
    }

    public SelectedContactPayerViewHolder(ViewGroup viewGroup, SelectedPayerAdapter.Listener listener) {
        super(viewGroup.getContext(), R.layout.item_recent_detail, viewGroup);
        this.PlaceComponentResult = listener;
    }
}
