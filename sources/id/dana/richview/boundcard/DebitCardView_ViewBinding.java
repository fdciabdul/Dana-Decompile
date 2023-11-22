package id.dana.richview.boundcard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class DebitCardView_ViewBinding implements Unbinder {
    private DebitCardView KClassImpl$Data$declaredNonStaticMembers$2;

    public DebitCardView_ViewBinding(DebitCardView debitCardView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = debitCardView;
        debitCardView.ivChannel = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_channel, "field 'ivChannel'", ImageView.class);
        debitCardView.llDebitCardBackground = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_debit_card_background, "field 'llDebitCardBackground'", LinearLayout.class);
        debitCardView.clDebitCard = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_debit_card, "field 'clDebitCard'", ConstraintLayout.class);
        debitCardView.ivCardLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_card_logo, "field 'ivCardLogo'", ImageView.class);
        debitCardView.ivExpressPay = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_expresspay, "field 'ivExpressPay'", ImageView.class);
        debitCardView.tvMaskNumber = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4429tv_mask_number, "field 'tvMaskNumber'", TextView.class);
        debitCardView.tvPreferred = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_preferred, "field 'tvPreferred'", TextView.class);
        debitCardView.tvUpdateCard = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_update_card, "field 'tvUpdateCard'", TextView.class);
        debitCardView.tvValidThru = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_valid_thru, "field 'tvValidThru'", TextView.class);
        debitCardView.tvDebit = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title_card, "field 'tvDebit'", TextView.class);
        debitCardView.tvValidThruLabel = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_valid_thru_label, "field 'tvValidThruLabel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DebitCardView debitCardView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (debitCardView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        debitCardView.ivChannel = null;
        debitCardView.llDebitCardBackground = null;
        debitCardView.clDebitCard = null;
        debitCardView.ivCardLogo = null;
        debitCardView.ivExpressPay = null;
        debitCardView.tvMaskNumber = null;
        debitCardView.tvPreferred = null;
        debitCardView.tvUpdateCard = null;
        debitCardView.tvValidThru = null;
        debitCardView.tvDebit = null;
        debitCardView.tvValidThruLabel = null;
    }
}
