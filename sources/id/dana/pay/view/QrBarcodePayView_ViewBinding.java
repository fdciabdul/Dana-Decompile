package id.dana.pay.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class QrBarcodePayView_ViewBinding extends BasePayView_ViewBinding {
    private QrBarcodePayView BuiltInFictitiousFunctionClassFactory;

    public QrBarcodePayView_ViewBinding(QrBarcodePayView qrBarcodePayView, View view) {
        super(qrBarcodePayView, view);
        this.BuiltInFictitiousFunctionClassFactory = qrBarcodePayView;
        qrBarcodePayView.barcodeView = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_barcode, "field 'barcodeView'", ImageView.class);
        qrBarcodePayView.paycodeView = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_code, "field 'paycodeView'", TextView.class);
    }

    @Override // id.dana.pay.view.BasePayView_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        QrBarcodePayView qrBarcodePayView = this.BuiltInFictitiousFunctionClassFactory;
        if (qrBarcodePayView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        qrBarcodePayView.barcodeView = null;
        qrBarcodePayView.paycodeView = null;
        super.getAuthRequestContext();
    }
}
