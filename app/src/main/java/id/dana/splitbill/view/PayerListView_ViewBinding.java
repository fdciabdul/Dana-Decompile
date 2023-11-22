package id.dana.splitbill.view;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class PayerListView_ViewBinding implements Unbinder {
    private PayerListView KClassImpl$Data$declaredNonStaticMembers$2;

    public PayerListView_ViewBinding(PayerListView payerListView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = payerListView;
        payerListView.tvClosePayer = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_close_payer, "field 'tvClosePayer'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PayerListView payerListView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (payerListView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        payerListView.tvClosePayer = null;
    }
}
