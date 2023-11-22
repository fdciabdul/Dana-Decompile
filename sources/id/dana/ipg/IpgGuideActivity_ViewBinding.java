package id.dana.ipg;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public final class IpgGuideActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View MyBillsEntityDataFactory;
    private IpgGuideActivity getAuthRequestContext;

    public IpgGuideActivity_ViewBinding(final IpgGuideActivity ipgGuideActivity, View view) {
        this.getAuthRequestContext = ipgGuideActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_refuse, "method 'refuseRegisterIpg'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.ipg.IpgGuideActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                ipgGuideActivity.refuseRegisterIpg();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_agree, "method 'agreeRegisterIpg'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.ipg.IpgGuideActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                ipgGuideActivity.agreeRegisterIpg();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.getAuthRequestContext == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
