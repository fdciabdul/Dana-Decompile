package id.dana.lazada.tncagreement;

import android.view.View;
import android.widget.Button;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseWebViewActivity_ViewBinding;
import id.dana.richview.WebProgressView;

/* loaded from: classes8.dex */
public class LazadaTermsAndConditionActivity_ViewBinding extends BaseWebViewActivity_ViewBinding {
    private LazadaTermsAndConditionActivity MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public LazadaTermsAndConditionActivity_ViewBinding(final LazadaTermsAndConditionActivity lazadaTermsAndConditionActivity, View view) {
        super(lazadaTermsAndConditionActivity, view);
        this.MyBillsEntityDataFactory = lazadaTermsAndConditionActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_lazada_agree, "field 'btnAgree' and method 'onAgreeCliecked'");
        lazadaTermsAndConditionActivity.btnAgree = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.btn_lazada_agree, "field 'btnAgree'", Button.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.lazada.tncagreement.LazadaTermsAndConditionActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                lazadaTermsAndConditionActivity.onAgreeCliecked();
            }
        });
        lazadaTermsAndConditionActivity.viewWebProgress = (WebProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_web_progress, "field 'viewWebProgress'", WebProgressView.class);
    }

    @Override // id.dana.base.BaseWebViewActivity_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        LazadaTermsAndConditionActivity lazadaTermsAndConditionActivity = this.MyBillsEntityDataFactory;
        if (lazadaTermsAndConditionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        lazadaTermsAndConditionActivity.btnAgree = null;
        lazadaTermsAndConditionActivity.viewWebProgress = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
        super.getAuthRequestContext();
    }
}
