package id.dana.nearbyme.merchantdetail.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.promoquest.model.PrizeType;
import id.dana.nearbyme.merchantdetail.model.MerchantLabelModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewholder/MerchantLabelPromoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantLabelModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLabelPromoViewHolder extends BaseRecyclerViewHolder<MerchantLabelModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantLabelModel merchantLabelModel) {
        String str;
        MerchantLabelModel merchantLabelModel2 = merchantLabelModel;
        TextView textView = (TextView) this.itemView.findViewById(R.id.tv_promo_text);
        if (textView != null) {
            String str2 = merchantLabelModel2 != null ? merchantLabelModel2.getAuthRequestContext : null;
            if (str2 != null) {
                int hashCode = str2.hashCode();
                if (hashCode != -1894155097) {
                    if (hashCode != -1708077799) {
                        if (hashCode == 807116442 && str2.equals(PrizeType.CASHBACK)) {
                            str = getContext().getResources().getString(R.string.merchant_label_cashback, merchantLabelModel2.MyBillsEntityDataFactory);
                        }
                    } else if (str2.equals(PrizeType.CASHCOUPON)) {
                        str = getContext().getResources().getString(R.string.merchant_label_promo, merchantLabelModel2.MyBillsEntityDataFactory);
                    }
                } else if (str2.equals(PrizeType.DISCOUNTCOUPON)) {
                    str = getContext().getResources().getString(R.string.merchant_label_discount, merchantLabelModel2.MyBillsEntityDataFactory);
                }
                textView.setText(str);
            }
            textView.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantLabelPromoViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_merchant_label_promo, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
