package id.dana.splitbill.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.CurrencyTextView;
import id.dana.richview.socialshare.SocialShareView;

/* loaded from: classes9.dex */
public class SplitBillSummaryActivity_ViewBinding implements Unbinder {
    private SplitBillSummaryActivity getAuthRequestContext;

    public SplitBillSummaryActivity_ViewBinding(SplitBillSummaryActivity splitBillSummaryActivity, View view) {
        this.getAuthRequestContext = splitBillSummaryActivity;
        splitBillSummaryActivity.llBillDetailEmptyState = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_split_bill_empty_state, "field 'llBillDetailEmptyState'", LinearLayout.class);
        splitBillSummaryActivity.llSplitBillDetails = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_split_bill_details, "field 'llSplitBillDetails'", LinearLayout.class);
        splitBillSummaryActivity.ivSplitBillStatus = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_split_bill_status, "field 'ivSplitBillStatus'", ImageView.class);
        splitBillSummaryActivity.ctvTotalAmount = (CurrencyTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ctv_total_amount, "field 'ctvTotalAmount'", CurrencyTextView.class);
        splitBillSummaryActivity.tvRemarks = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_remarks, "field 'tvRemarks'", TextView.class);
        splitBillSummaryActivity.payerListView = (PayerListView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_split_bill_payer, "field 'payerListView'", PayerListView.class);
        splitBillSummaryActivity.ssvSplitBill = (SocialShareView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ssv_split_bill_summary, "field 'ssvSplitBill'", SocialShareView.class);
        splitBillSummaryActivity.vDimBody = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.v_dim_body, "field 'vDimBody'");
        splitBillSummaryActivity.nsvSplitBillSummary = (NestedScrollView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.nsv_split_bill_summary, "field 'nsvSplitBillSummary'", NestedScrollView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillSummaryActivity splitBillSummaryActivity = this.getAuthRequestContext;
        if (splitBillSummaryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        splitBillSummaryActivity.llBillDetailEmptyState = null;
        splitBillSummaryActivity.llSplitBillDetails = null;
        splitBillSummaryActivity.ivSplitBillStatus = null;
        splitBillSummaryActivity.ctvTotalAmount = null;
        splitBillSummaryActivity.tvRemarks = null;
        splitBillSummaryActivity.payerListView = null;
        splitBillSummaryActivity.ssvSplitBill = null;
        splitBillSummaryActivity.vDimBody = null;
        splitBillSummaryActivity.nsvSplitBillSummary = null;
    }
}
