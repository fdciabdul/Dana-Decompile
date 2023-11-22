package id.dana.pay;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.pay.view.BasePayView;

/* loaded from: classes9.dex */
public class BasePayFragment_ViewBinding implements Unbinder {
    private BasePayFragment BuiltInFictitiousFunctionClassFactory;

    public BasePayFragment_ViewBinding(BasePayFragment basePayFragment, View view) {
        this.BuiltInFictitiousFunctionClassFactory = basePayFragment;
        basePayFragment.root = (ConstraintLayout) Utils.PlaceComponentResult(view, R.id.layout_parent, "field 'root'", ConstraintLayout.class);
        basePayFragment.qrBarcodePayView = (BasePayView) Utils.PlaceComponentResult(view, R.id.pay_qr_barcode, "field 'qrBarcodePayView'", BasePayView.class);
        basePayFragment.cardBackground = (ImageView) Utils.PlaceComponentResult(view, R.id.card_background, "field 'cardBackground'", ImageView.class);
        basePayFragment.cardSchemeLogo = (ImageView) Utils.PlaceComponentResult(view, R.id.iv_card_scheme_logo, "field 'cardSchemeLogo'", ImageView.class);
        basePayFragment.ivExpressPay = (ImageView) Utils.PlaceComponentResult(view, R.id.iv_expresspay, "field 'ivExpressPay'", ImageView.class);
        basePayFragment.payContent = (TextView) Utils.PlaceComponentResult(view, R.id.pay_content, "field 'payContent'", TextView.class);
        basePayFragment.payContentIdentifier = (TextView) Utils.PlaceComponentResult(view, R.id.pay_content_identifier, "field 'payContentIdentifier'", TextView.class);
        basePayFragment.payId = (TextView) Utils.PlaceComponentResult(view, R.id.pay_id, "field 'payId'", TextView.class);
        basePayFragment.payLogo = (ImageView) Utils.PlaceComponentResult(view, R.id.pay_logo, "field 'payLogo'", ImageView.class);
        basePayFragment.payTitle = (TextView) Utils.PlaceComponentResult(view, R.id.pay_title, "field 'payTitle'", TextView.class);
        basePayFragment.preferredText = (TextView) Utils.PlaceComponentResult(view, R.id.tv_preferred, "field 'preferredText'", TextView.class);
        basePayFragment.scanInfoText = (TextView) Utils.PlaceComponentResult(view, R.id.tv_scan_info, "field 'scanInfoText'", TextView.class);
        basePayFragment.feeInfoText = (TextView) Utils.PlaceComponentResult(view, R.id.tv_fee_info, "field 'feeInfoText'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void getAuthRequestContext() {
        BasePayFragment basePayFragment = this.BuiltInFictitiousFunctionClassFactory;
        if (basePayFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        basePayFragment.root = null;
        basePayFragment.qrBarcodePayView = null;
        basePayFragment.cardBackground = null;
        basePayFragment.cardSchemeLogo = null;
        basePayFragment.ivExpressPay = null;
        basePayFragment.payContent = null;
        basePayFragment.payContentIdentifier = null;
        basePayFragment.payId = null;
        basePayFragment.payLogo = null;
        basePayFragment.payTitle = null;
        basePayFragment.preferredText = null;
        basePayFragment.scanInfoText = null;
        basePayFragment.feeInfoText = null;
    }
}
