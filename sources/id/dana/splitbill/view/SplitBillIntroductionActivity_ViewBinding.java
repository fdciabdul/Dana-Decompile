package id.dana.splitbill.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SplitBillIntroductionActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private SplitBillIntroductionActivity KClassImpl$Data$declaredNonStaticMembers$2;
    private View getAuthRequestContext;

    public SplitBillIntroductionActivity_ViewBinding(final SplitBillIntroductionActivity splitBillIntroductionActivity, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillIntroductionActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_split_bill_entry, "field 'btnSplitBillEntry' and method 'onSplitBillEntryButtonClick'");
        splitBillIntroductionActivity.btnSplitBillEntry = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.btn_split_bill_entry, "field 'btnSplitBillEntry'", Button.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.splitbill.view.SplitBillIntroductionActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                splitBillIntroductionActivity.onSplitBillEntryButtonClick();
            }
        });
        splitBillIntroductionActivity.sbhvBillHistories = (SplitBillHistoryView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.sbhv_bill_histories, "field 'sbhvBillHistories'", SplitBillHistoryView.class);
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.right_button, "field 'rightButton' and method 'onHelpClick'");
        splitBillIntroductionActivity.rightButton = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.right_button, "field 'rightButton'", TextView.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.splitbill.view.SplitBillIntroductionActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                splitBillIntroductionActivity.onHelpClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SplitBillIntroductionActivity splitBillIntroductionActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (splitBillIntroductionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        splitBillIntroductionActivity.btnSplitBillEntry = null;
        splitBillIntroductionActivity.sbhvBillHistories = null;
        splitBillIntroductionActivity.rightButton = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
