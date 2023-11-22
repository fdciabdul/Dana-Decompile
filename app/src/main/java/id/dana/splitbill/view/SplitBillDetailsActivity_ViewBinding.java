package id.dana.splitbill.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.CurrencyTextView;

/* loaded from: classes9.dex */
public class SplitBillDetailsActivity_ViewBinding implements Unbinder {
    private SplitBillDetailsActivity BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public SplitBillDetailsActivity_ViewBinding(final SplitBillDetailsActivity splitBillDetailsActivity, View view) {
        this.BuiltInFictitiousFunctionClassFactory = splitBillDetailsActivity;
        splitBillDetailsActivity.llSplitBillDetails = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_split_bill_details, "field 'llSplitBillDetails'", LinearLayout.class);
        splitBillDetailsActivity.viewSplitBillNotPayer = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_split_bill_not_payer, "field 'viewSplitBillNotPayer'");
        splitBillDetailsActivity.ctvTotalAmount = (CurrencyTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ctv_total_amount, "field 'ctvTotalAmount'", CurrencyTextView.class);
        splitBillDetailsActivity.ivBillStatus = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_split_bill_status, "field 'ivBillStatus'", ImageView.class);
        splitBillDetailsActivity.tvRemarks = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_remarks, "field 'tvRemarks'", TextView.class);
        splitBillDetailsActivity.payerListView = (PayerListView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_split_bill_payer, "field 'payerListView'", PayerListView.class);
        splitBillDetailsActivity.ctvPayAmount = (CurrencyTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ctv_pay_amount, "field 'ctvPayAmount'", CurrencyTextView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_pay_button, "field 'viewPayButton' and method 'onPayButtonClick'");
        splitBillDetailsActivity.viewPayButton = BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.splitbill.view.SplitBillDetailsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                splitBillDetailsActivity.onPayButtonClick();
            }
        });
        splitBillDetailsActivity.tvAmountTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_amount_title, "field 'tvAmountTitle'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_ok, "method 'onOkClick'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.splitbill.view.SplitBillDetailsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                splitBillDetailsActivity.onOkClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillDetailsActivity splitBillDetailsActivity = this.BuiltInFictitiousFunctionClassFactory;
        if (splitBillDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        splitBillDetailsActivity.llSplitBillDetails = null;
        splitBillDetailsActivity.viewSplitBillNotPayer = null;
        splitBillDetailsActivity.ctvTotalAmount = null;
        splitBillDetailsActivity.ivBillStatus = null;
        splitBillDetailsActivity.tvRemarks = null;
        splitBillDetailsActivity.payerListView = null;
        splitBillDetailsActivity.ctvPayAmount = null;
        splitBillDetailsActivity.viewPayButton = null;
        splitBillDetailsActivity.tvAmountTitle = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
