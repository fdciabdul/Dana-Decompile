package id.dana.sendmoney.bank.all;

import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecipientViewModel;

/* loaded from: classes5.dex */
public class CollapsibleSavedBankViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {
    @BindView(R.id.tv_collapsible_bank)
    TextView tvCollapsibleBank;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        RecipientViewModel recipientViewModel2 = recipientViewModel;
        if (recipientViewModel2 != null) {
            this.tvCollapsibleBank.setText(13 == recipientViewModel2.PrepareContext ? R.string.saved_bank_see_more : R.string.saved_bank_see_less);
        }
    }

    public CollapsibleSavedBankViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_collpasible_bank, viewGroup);
    }
}
