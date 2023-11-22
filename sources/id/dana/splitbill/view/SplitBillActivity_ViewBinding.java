package id.dana.splitbill.view;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.LogoProgressView;
import id.dana.richview.splitbill.AmountDisplayView;
import id.dana.richview.splitbill.BillPayerView;
import id.dana.sendmoney.remarks.NoteView;

/* loaded from: classes9.dex */
public class SplitBillActivity_ViewBinding implements Unbinder {
    private View MyBillsEntityDataFactory;
    private SplitBillActivity getAuthRequestContext;

    public SplitBillActivity_ViewBinding(final SplitBillActivity splitBillActivity, View view) {
        this.getAuthRequestContext = splitBillActivity;
        splitBillActivity.advSplitBill = (AmountDisplayView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.adv_split_bill, "field 'advSplitBill'", AmountDisplayView.class);
        splitBillActivity.rvRemarks = (NoteView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_remarks, "field 'rvRemarks'", NoteView.class);
        splitBillActivity.touchBlockerView = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.v_touch_blocker, "field 'touchBlockerView'");
        splitBillActivity.logoProgressView = (LogoProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4081progress_view, "field 'logoProgressView'", LogoProgressView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_split_bill, "field 'btnSplitBill' and method 'onSplitBillClicked'");
        splitBillActivity.btnSplitBill = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.btn_split_bill, "field 'btnSplitBill'", Button.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.splitbill.view.SplitBillActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                splitBillActivity.onSplitBillClicked();
            }
        });
        splitBillActivity.bpvSelection = (BillPayerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.bpv_selection, "field 'bpvSelection'", BillPayerView.class);
        splitBillActivity.vDimHeader = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.v_dim_header, "field 'vDimHeader'");
        splitBillActivity.vDimBody = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.v_dim_body, "field 'vDimBody'");
        splitBillActivity.sbpvPayers = (SplitBillPayersView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.sbpv_payers, "field 'sbpvPayers'", SplitBillPayersView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillActivity splitBillActivity = this.getAuthRequestContext;
        if (splitBillActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        splitBillActivity.advSplitBill = null;
        splitBillActivity.rvRemarks = null;
        splitBillActivity.touchBlockerView = null;
        splitBillActivity.logoProgressView = null;
        splitBillActivity.btnSplitBill = null;
        splitBillActivity.bpvSelection = null;
        splitBillActivity.vDimHeader = null;
        splitBillActivity.vDimBody = null;
        splitBillActivity.sbpvPayers = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
