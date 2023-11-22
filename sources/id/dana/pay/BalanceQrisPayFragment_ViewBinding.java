package id.dana.pay;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.pay.view.BasePayView;
import id.dana.richview.ToggleBalanceView;

/* loaded from: classes9.dex */
public class BalanceQrisPayFragment_ViewBinding extends BasePayFragment_ViewBinding {
    private BalanceQrisPayFragment MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public BalanceQrisPayFragment_ViewBinding(final BalanceQrisPayFragment balanceQrisPayFragment, View view) {
        super(balanceQrisPayFragment, view);
        this.MyBillsEntityDataFactory = balanceQrisPayFragment;
        balanceQrisPayFragment.payIdView = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_id, "field 'payIdView'", TextView.class);
        balanceQrisPayFragment.qrBarcodePayView = (BasePayView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pay_qr_barcode, "field 'qrBarcodePayView'", BasePayView.class);
        balanceQrisPayFragment.tbvPayContent = (ToggleBalanceView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tbv_pay_content, "field 'tbvPayContent'", ToggleBalanceView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.pay_topup_button, "method 'onClickTopup'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.pay.BalanceQrisPayFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                balanceQrisPayFragment.onClickTopup();
            }
        });
    }

    @Override // id.dana.pay.BasePayFragment_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        BalanceQrisPayFragment balanceQrisPayFragment = this.MyBillsEntityDataFactory;
        if (balanceQrisPayFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        balanceQrisPayFragment.payIdView = null;
        balanceQrisPayFragment.qrBarcodePayView = null;
        balanceQrisPayFragment.tbvPayContent = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
        super.getAuthRequestContext();
    }
}
