package id.dana.splitbill.view;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SplitBillHistoryView_ViewBinding implements Unbinder {
    private SplitBillHistoryView MyBillsEntityDataFactory;

    public SplitBillHistoryView_ViewBinding(SplitBillHistoryView splitBillHistoryView, View view) {
        this.MyBillsEntityDataFactory = splitBillHistoryView;
        splitBillHistoryView.llSplitBillHistoryContainer = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_split_bill_history_container, "field 'llSplitBillHistoryContainer'", ConstraintLayout.class);
        splitBillHistoryView.rvSplitBillHistory = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_split_bill_history, "field 'rvSplitBillHistory'", RecyclerView.class);
        splitBillHistoryView.llBillHistoryEmptyState = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_history_empty_state, "field 'llBillHistoryEmptyState'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillHistoryView splitBillHistoryView = this.MyBillsEntityDataFactory;
        if (splitBillHistoryView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        splitBillHistoryView.llSplitBillHistoryContainer = null;
        splitBillHistoryView.rvSplitBillHistory = null;
        splitBillHistoryView.llBillHistoryEmptyState = null;
    }
}
