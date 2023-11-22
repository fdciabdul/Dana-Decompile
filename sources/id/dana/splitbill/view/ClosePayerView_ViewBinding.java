package id.dana.splitbill.view;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ClosePayerView_ViewBinding implements Unbinder {
    private ClosePayerView KClassImpl$Data$declaredNonStaticMembers$2;

    public ClosePayerView_ViewBinding(ClosePayerView closePayerView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = closePayerView;
        closePayerView.tvRemainingBillValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_remaining_bill_value, "field 'tvRemainingBillValue'", TextView.class);
        closePayerView.tvUnpaidBillCount = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_unpaid_bill_count, "field 'tvUnpaidBillCount'", TextView.class);
        closePayerView.cbCloseAllPayer = (CheckBox) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cb_close_all_payer, "field 'cbCloseAllPayer'", CheckBox.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ClosePayerView closePayerView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (closePayerView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        closePayerView.tvRemainingBillValue = null;
        closePayerView.tvUnpaidBillCount = null;
        closePayerView.cbCloseAllPayer = null;
    }
}
