package id.dana.onlinemerchant.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.onlinemerchant.model.OnlineMerchantWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/onlinemerchant/adapter/viewholder/OnlineMerchantViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/onlinemerchant/model/OnlineMerchantWrapper;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineMerchantViewHolder extends BaseRecyclerViewHolder<OnlineMerchantWrapper> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(OnlineMerchantWrapper onlineMerchantWrapper) {
        OnlineMerchantWrapper onlineMerchantWrapper2 = onlineMerchantWrapper;
        if (onlineMerchantWrapper2 != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tvOnlineMerchantName);
            if (appCompatTextView != null) {
                appCompatTextView.setText(onlineMerchantWrapper2.MyBillsEntityDataFactory.GetContactSyncConfig);
            }
            String str = onlineMerchantWrapper2.MyBillsEntityDataFactory.moveToNextValue;
            if (str.length() == 0) {
                CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0311_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2);
                if (circleImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(circleImageView, R.drawable.ic_merchant_logo_circle_placeholder);
                } else {
                    circleImageView.setImageResource(R.drawable.ic_merchant_logo_circle_placeholder);
                }
            } else {
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.ic_merchant_logo_circle_placeholder).PlaceComponentResult((int) R.drawable.ic_merchant_logo_circle_placeholder).MyBillsEntityDataFactory((ImageView) ((CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0311_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2)));
            }
            boolean networkUserEntityData$$ExternalSyntheticLambda1 = onlineMerchantWrapper2.MyBillsEntityDataFactory.getNetworkUserEntityData$$ExternalSyntheticLambda1();
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.itemView.findViewById(R.id.res_0x7f0a14f3_electricitybillsbottomsheetfragment_validateform_1);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(networkUserEntityData$$ExternalSyntheticLambda1 ? 0 : 8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineMerchantViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_online_merchant, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
