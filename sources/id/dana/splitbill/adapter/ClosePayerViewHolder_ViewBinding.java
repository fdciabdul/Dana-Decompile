package id.dana.splitbill.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes9.dex */
public class ClosePayerViewHolder_ViewBinding implements Unbinder {
    private ClosePayerViewHolder getAuthRequestContext;

    public ClosePayerViewHolder_ViewBinding(ClosePayerViewHolder closePayerViewHolder, View view) {
        this.getAuthRequestContext = closePayerViewHolder;
        closePayerViewHolder.cbClosePayer = (CheckBox) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cb_close_payer, "field 'cbClosePayer'", CheckBox.class);
        closePayerViewHolder.civClosePayerAvatar = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_close_payer_avatar, "field 'civClosePayerAvatar'", CircleImageView.class);
        closePayerViewHolder.tvClosePayerName = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_close_payer_name, "field 'tvClosePayerName'", TextView.class);
        closePayerViewHolder.tvClosePayerAmount = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_close_payer_amount, "field 'tvClosePayerAmount'", TextView.class);
        closePayerViewHolder.tvClosePayerPhone = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_close_payer_phone, "field 'tvClosePayerPhone'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ClosePayerViewHolder closePayerViewHolder = this.getAuthRequestContext;
        if (closePayerViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        closePayerViewHolder.cbClosePayer = null;
        closePayerViewHolder.civClosePayerAvatar = null;
        closePayerViewHolder.tvClosePayerName = null;
        closePayerViewHolder.tvClosePayerAmount = null;
        closePayerViewHolder.tvClosePayerPhone = null;
    }
}
