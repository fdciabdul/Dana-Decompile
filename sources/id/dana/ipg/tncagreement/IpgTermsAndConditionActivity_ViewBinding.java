package id.dana.ipg.tncagreement;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseWebViewActivity_ViewBinding;

/* loaded from: classes8.dex */
public final class IpgTermsAndConditionActivity_ViewBinding extends BaseWebViewActivity_ViewBinding {
    private IpgTermsAndConditionActivity KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public IpgTermsAndConditionActivity_ViewBinding(final IpgTermsAndConditionActivity ipgTermsAndConditionActivity, View view) {
        super(ipgTermsAndConditionActivity, view);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ipgTermsAndConditionActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_ipg_agree, "method 'onAgreeClicked'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.ipg.tncagreement.IpgTermsAndConditionActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                ipgTermsAndConditionActivity.onAgreeClicked();
            }
        });
    }

    @Override // id.dana.base.BaseWebViewActivity_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        super.getAuthRequestContext();
    }
}
