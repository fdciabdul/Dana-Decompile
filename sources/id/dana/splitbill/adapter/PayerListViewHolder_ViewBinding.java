package id.dana.splitbill.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.richview.CurrencyTextView;

/* loaded from: classes9.dex */
public class PayerListViewHolder_ViewBinding implements Unbinder {
    private PayerListViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public PayerListViewHolder_ViewBinding(PayerListViewHolder payerListViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = payerListViewHolder;
        payerListViewHolder.clPayerContainer = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_payer_container, "field 'clPayerContainer'", ConstraintLayout.class);
        payerListViewHolder.civPayerAvatar = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_payer_avatar, "field 'civPayerAvatar'", CircleImageView.class);
        payerListViewHolder.tvName = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_name, "field 'tvName'", TextView.class);
        payerListViewHolder.tvPhoneNumber = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_phone_number, "field 'tvPhoneNumber'", TextView.class);
        payerListViewHolder.ctvFundAmount = (CurrencyTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ctv_fund_amount, "field 'ctvFundAmount'", CurrencyTextView.class);
        payerListViewHolder.ivStatus = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3954iv_status, "field 'ivStatus'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PayerListViewHolder payerListViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (payerListViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        payerListViewHolder.clPayerContainer = null;
        payerListViewHolder.civPayerAvatar = null;
        payerListViewHolder.tvName = null;
        payerListViewHolder.tvPhoneNumber = null;
        payerListViewHolder.ctvFundAmount = null;
        payerListViewHolder.ivStatus = null;
    }
}
