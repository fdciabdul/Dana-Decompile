package id.dana.sendmoney.contact.all;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecipientViewModel;

/* loaded from: classes5.dex */
public class SendWithPhoneNumberViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {
    @BindView(R.id.rl_add)
    RelativeLayout rlAdd;
    @BindView(R.id.tv_add_new)
    TextView tvAddNew;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* bridge */ /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
    }

    public SendWithPhoneNumberViewHolder(ViewGroup viewGroup, String str) {
        super(viewGroup.getContext(), R.layout.item_send_phone_to_number, viewGroup);
        if ("split_bill".equals(str)) {
            this.tvAddNew.setText(getContext().getString(R.string.split_bill_add_new_number));
            this.rlAdd.setContentDescription(getContext().getString(R.string.btnAddPhoneNumber));
        } else if ("send_money".equals(str)) {
            this.tvAddNew.setText(getContext().getString(R.string.send_to_phone_number));
        }
    }
}
