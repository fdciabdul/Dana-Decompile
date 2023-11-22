package id.dana.sendmoney.recipient;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecipientViewModel;

/* loaded from: classes5.dex */
public class SectionViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {
    @BindView(R.id.res_0x7f0a1720_nearbysearchpresenter_getnearbytrendingkeyword_1)
    TextView tvHeaderSection;
    @BindView(R.id.view_divider)
    View vDivider;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        RecipientViewModel recipientViewModel2 = recipientViewModel;
        int i = recipientViewModel2.PrepareContext;
        if (i == 1) {
            if (TextUtils.isEmpty(recipientViewModel2.getErrorConfigVersion)) {
                this.tvHeaderSection.setText(getContext().getString(R.string.MyBillsEntityDataFactory_res_0x7f1300e8));
                this.tvHeaderSection.setVisibility(0);
            } else {
                this.tvHeaderSection.setText(getContext().getString(R.string.getNameOrBuilderList));
                this.tvHeaderSection.setVisibility(0);
            }
            this.vDivider.setVisibility(8);
        } else if (i == 7) {
            this.tvHeaderSection.setText(getContext().getString(R.string.containsObjectForKey));
            this.tvHeaderSection.setVisibility(0);
        } else if (i == 23) {
            this.tvHeaderSection.setText(getContext().getString(R.string.recent_transfer));
            this.tvHeaderSection.setVisibility(0);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.tvHeaderSection, (int) R.style.f54072132017901);
        } else if (i == 26) {
            this.tvHeaderSection.setText(getContext().getString(R.string.group_send_section));
            this.tvHeaderSection.setVisibility(0);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.tvHeaderSection, (int) R.style.f54072132017901);
        } else if (i == 20) {
            this.tvHeaderSection.setText(getContext().getString(R.string.bank_accounts));
            this.tvHeaderSection.setVisibility(0);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.tvHeaderSection, (int) R.style.f54072132017901);
        } else if (i != 21) {
            this.vDivider.setVisibility(8);
            this.tvHeaderSection.setVisibility(8);
        } else {
            this.tvHeaderSection.setText(getContext().getString(R.string.getNameOrBuilderList));
            this.tvHeaderSection.setVisibility(0);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.tvHeaderSection, (int) R.style.f54072132017901);
        }
    }

    public SectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_recipient_state_section, viewGroup);
    }
}
