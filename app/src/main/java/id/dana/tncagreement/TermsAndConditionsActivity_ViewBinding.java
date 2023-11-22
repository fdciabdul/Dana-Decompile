package id.dana.tncagreement;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseWebViewActivity_ViewBinding;
import id.dana.richview.WebProgressView;

/* loaded from: classes9.dex */
public class TermsAndConditionsActivity_ViewBinding extends BaseWebViewActivity_ViewBinding {
    private View BuiltInFictitiousFunctionClassFactory;
    private TermsAndConditionsActivity KClassImpl$Data$declaredNonStaticMembers$2;

    public TermsAndConditionsActivity_ViewBinding(final TermsAndConditionsActivity termsAndConditionsActivity, View view) {
        super(termsAndConditionsActivity, view);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = termsAndConditionsActivity;
        termsAndConditionsActivity.cbTncAgreement = (CheckBox) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cb_tnc_agreement, "field 'cbTncAgreement'", CheckBox.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_agree, "field 'btnAgree' and method 'onAgreeClicked'");
        termsAndConditionsActivity.btnAgree = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.btn_agree, "field 'btnAgree'", Button.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.tncagreement.TermsAndConditionsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                termsAndConditionsActivity.onAgreeClicked();
            }
        });
        termsAndConditionsActivity.viewWebProgress = (WebProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_web_progress, "field 'viewWebProgress'", WebProgressView.class);
    }

    @Override // id.dana.base.BaseWebViewActivity_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        TermsAndConditionsActivity termsAndConditionsActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (termsAndConditionsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        termsAndConditionsActivity.cbTncAgreement = null;
        termsAndConditionsActivity.btnAgree = null;
        termsAndConditionsActivity.viewWebProgress = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        super.getAuthRequestContext();
    }
}
