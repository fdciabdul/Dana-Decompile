package id.dana.myprofile.viewholder;

import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationView;

/* loaded from: classes5.dex */
public class ProfileMenuPaymentAuthViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @BindView(R.id.TopUpAndPayModule_ProvideTopUpAndPayViewFactory)
    PaymentAuthenticationView paymentAuthenticationView;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 != null) {
            this.paymentAuthenticationView.setTitle(settingModel2.getTitle());
        }
    }

    public ProfileMenuPaymentAuthViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_authentication_payment, viewGroup);
    }
}
