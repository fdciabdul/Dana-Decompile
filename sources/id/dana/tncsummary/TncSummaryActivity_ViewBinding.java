package id.dana.tncsummary;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.richview.WebProgressView;

/* loaded from: classes9.dex */
public class TncSummaryActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private TncSummaryActivity getAuthRequestContext;

    public TncSummaryActivity_ViewBinding(final TncSummaryActivity tncSummaryActivity, View view) {
        this.getAuthRequestContext = tncSummaryActivity;
        tncSummaryActivity.wpvDialogTnc = (WebProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.wpv_dialog_tnc, "field 'wpvDialogTnc'", WebProgressView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.cb_dialog_tnc, "field 'cbDialogTnc' and method 'onCheckboxChanged'");
        tncSummaryActivity.cbDialogTnc = (CheckBox) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.cb_dialog_tnc, "field 'cbDialogTnc'", CheckBox.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        ((CompoundButton) BuiltInFictitiousFunctionClassFactory).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.tncsummary.TncSummaryActivity_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                tncSummaryActivity.onCheckboxChanged(z);
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_dialog_tnc_agree, "field 'btnDialogTncAgree' and method 'onDialogTncAgree'");
        tncSummaryActivity.btnDialogTncAgree = (DanaButtonPrimaryView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.btn_dialog_tnc_agree, "field 'btnDialogTncAgree'", DanaButtonPrimaryView.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.tncsummary.TncSummaryActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                tncSummaryActivity.onDialogTncAgree();
            }
        });
        tncSummaryActivity.tvDialogTncAgreement = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_dialog_tnc_agreement, "field 'tvDialogTncAgreement'", TextView.class);
        tncSummaryActivity.tvDialogTncError = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_dialog_tnc_error, "field 'tvDialogTncError'", TextView.class);
        tncSummaryActivity.pbDialogTnc = (ProgressBar) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pb_dialog_tnc, "field 'pbDialogTnc'", ProgressBar.class);
        tncSummaryActivity.clContainer = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_tnc_container, "field 'clContainer'", ConstraintLayout.class);
        tncSummaryActivity.tvDialogTncHeader = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_dialog_tnc_header, "field 'tvDialogTncHeader'", TextView.class);
        tncSummaryActivity.ivDialogTnc = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_dialog_tnc, "field 'ivDialogTnc'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        TncSummaryActivity tncSummaryActivity = this.getAuthRequestContext;
        if (tncSummaryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        tncSummaryActivity.wpvDialogTnc = null;
        tncSummaryActivity.cbDialogTnc = null;
        tncSummaryActivity.btnDialogTncAgree = null;
        tncSummaryActivity.tvDialogTncAgreement = null;
        tncSummaryActivity.tvDialogTncError = null;
        tncSummaryActivity.pbDialogTnc = null;
        tncSummaryActivity.clContainer = null;
        tncSummaryActivity.tvDialogTncHeader = null;
        tncSummaryActivity.ivDialogTnc = null;
        ((CompoundButton) this.KClassImpl$Data$declaredNonStaticMembers$2).setOnCheckedChangeListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
