package id.dana.richview.splitbill;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.sendmoney.RecentDetailView;

/* loaded from: classes9.dex */
public class SelectedPayerView_ViewBinding implements Unbinder {
    private SelectedPayerView KClassImpl$Data$declaredNonStaticMembers$2;

    public SelectedPayerView_ViewBinding(SelectedPayerView selectedPayerView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = selectedPayerView;
        selectedPayerView.rdvScanner = (RecentDetailView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rdv_scanner, "field 'rdvScanner'", RecentDetailView.class);
        selectedPayerView.rvSelectedPayers = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_selected_payers, "field 'rvSelectedPayers'", RecyclerView.class);
        selectedPayerView.tvCountPayers = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_count_payers, "field 'tvCountPayers'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SelectedPayerView selectedPayerView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (selectedPayerView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        selectedPayerView.rdvScanner = null;
        selectedPayerView.rvSelectedPayers = null;
        selectedPayerView.tvCountPayers = null;
    }
}
