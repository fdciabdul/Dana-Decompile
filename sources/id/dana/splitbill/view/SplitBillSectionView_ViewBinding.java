package id.dana.splitbill.view;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SplitBillSectionView_ViewBinding implements Unbinder {
    private SplitBillSectionView KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public SplitBillSectionView_ViewBinding(final SplitBillSectionView splitBillSectionView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillSectionView;
        splitBillSectionView.sbhvBillHistories = (SplitBillHistoryView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.sbhv_bill_histories, "field 'sbhvBillHistories'", SplitBillHistoryView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_init_split_bill, "method 'onSplitBillButtonClick'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.splitbill.view.SplitBillSectionView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                splitBillSectionView.onSplitBillButtonClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillSectionView splitBillSectionView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (splitBillSectionView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        splitBillSectionView.sbhvBillHistories = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
