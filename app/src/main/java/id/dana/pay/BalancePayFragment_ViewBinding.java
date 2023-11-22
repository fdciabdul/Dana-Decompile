package id.dana.pay;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.pay.view.QrBarcodePayView;
import id.dana.richview.ToggleBalanceView;

/* loaded from: classes9.dex */
public class BalancePayFragment_ViewBinding extends BasePayFragment_ViewBinding {
    private BalancePayFragment KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public BalancePayFragment_ViewBinding(final BalancePayFragment balancePayFragment, View view) {
        super(balancePayFragment, view);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = balancePayFragment;
        balancePayFragment.tbvPayContent = (ToggleBalanceView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tbv_pay_content, "field 'tbvPayContent'", ToggleBalanceView.class);
        balancePayFragment.payIdView = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_id, "field 'payIdView'", TextView.class);
        balancePayFragment.qrBarcodePayView = (QrBarcodePayView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_qr_barcode, "field 'qrBarcodePayView'", QrBarcodePayView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.pay_topup_button, "method 'onClickTopup'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.pay.BalancePayFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                balancePayFragment.onClickTopup();
            }
        });
    }

    @Override // id.dana.pay.BasePayFragment_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        BalancePayFragment balancePayFragment = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (balancePayFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        balancePayFragment.tbvPayContent = null;
        balancePayFragment.payIdView = null;
        balancePayFragment.qrBarcodePayView = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        super.getAuthRequestContext();
    }
}
