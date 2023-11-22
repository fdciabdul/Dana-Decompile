package id.dana.splitbill.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.richview.CircleImageSelectionView;

/* loaded from: classes9.dex */
public class PayerViewHolder_ViewBinding implements Unbinder {
    private PayerViewHolder MyBillsEntityDataFactory;

    public PayerViewHolder_ViewBinding(PayerViewHolder payerViewHolder, View view) {
        this.MyBillsEntityDataFactory = payerViewHolder;
        payerViewHolder.cisvAvatar = (CircleImageSelectionView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cisv_avatar, "field 'cisvAvatar'", CircleImageSelectionView.class);
        payerViewHolder.tvPayerName = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_payer_name, "field 'tvPayerName'", TextView.class);
        payerViewHolder.tvPhoneNumber = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_phone_number, "field 'tvPhoneNumber'", TextView.class);
        payerViewHolder.etAmount = (CurrencyEditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3751res_0x7f0a068e_abstractmapbasedmultimap_asmap, "field 'etAmount'", CurrencyEditText.class);
        payerViewHolder.tvRequesterExcludeAmount = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_requester_excluded_amount, "field 'tvRequesterExcludeAmount'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PayerViewHolder payerViewHolder = this.MyBillsEntityDataFactory;
        if (payerViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        payerViewHolder.cisvAvatar = null;
        payerViewHolder.tvPayerName = null;
        payerViewHolder.tvPhoneNumber = null;
        payerViewHolder.etAmount = null;
        payerViewHolder.tvRequesterExcludeAmount = null;
    }
}
