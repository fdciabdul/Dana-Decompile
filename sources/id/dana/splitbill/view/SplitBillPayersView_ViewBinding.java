package id.dana.splitbill.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SplitBillPayersView_ViewBinding implements Unbinder {
    private SplitBillPayersView BuiltInFictitiousFunctionClassFactory;

    public SplitBillPayersView_ViewBinding(SplitBillPayersView splitBillPayersView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = splitBillPayersView;
        splitBillPayersView.rvPayers = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_split_bill_participant, "field 'rvPayers'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillPayersView splitBillPayersView = this.BuiltInFictitiousFunctionClassFactory;
        if (splitBillPayersView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        splitBillPayersView.rvPayers = null;
    }
}
