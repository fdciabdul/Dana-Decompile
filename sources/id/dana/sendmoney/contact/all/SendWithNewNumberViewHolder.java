package id.dana.sendmoney.contact.all;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.view.BaseRecipientListener;

/* loaded from: classes5.dex */
public class SendWithNewNumberViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {
    final BaseRecipientListener MyBillsEntityDataFactory;
    @BindView(R.id.tv_phone_number)
    TextView tvPhoneNumber;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        this.tvPhoneNumber.setText(recipientViewModel.getErrorConfigVersion);
    }

    public SendWithNewNumberViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener) {
        super(viewGroup.getContext(), R.layout.item_send_new_number, viewGroup);
        this.MyBillsEntityDataFactory = baseRecipientListener;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.contact.all.SendWithNewNumberViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendWithNewNumberViewHolder sendWithNewNumberViewHolder = SendWithNewNumberViewHolder.this;
                RecipientModel.Builder builder = new RecipientModel.Builder("contact");
                builder.PrepareContext = "phonenumber";
                builder.scheduleImpl = sendWithNewNumberViewHolder.tvPhoneNumber.getText().toString();
                builder.GetContactSyncConfig = sendWithNewNumberViewHolder.tvPhoneNumber.getText().toString();
                builder.newProxyInstance = "Manual Input";
                RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
                BaseRecipientListener baseRecipientListener = sendWithNewNumberViewHolder.MyBillsEntityDataFactory;
                if (baseRecipientListener != null) {
                    baseRecipientListener.onRecipientSelected(KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        });
    }
}
