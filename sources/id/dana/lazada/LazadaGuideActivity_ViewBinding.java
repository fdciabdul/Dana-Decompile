package id.dana.lazada;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class LazadaGuideActivity_ViewBinding implements Unbinder {
    private LazadaGuideActivity BuiltInFictitiousFunctionClassFactory;
    private View MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public LazadaGuideActivity_ViewBinding(final LazadaGuideActivity lazadaGuideActivity, View view) {
        this.BuiltInFictitiousFunctionClassFactory = lazadaGuideActivity;
        lazadaGuideActivity.rootLayout = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4108res_0x7f0a10ca_groupdetailactivity_initdeletegroupdialog_1, "field 'rootLayout'");
        lazadaGuideActivity.tvTermsAndConditions = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.MissingMainCoroutineDispatcher, "field 'tvTermsAndConditions'", TextView.class);
        lazadaGuideActivity.tvLazadaTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_lazada_title, "field 'tvLazadaTitle'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_refuse, "method 'refuseRegisterLazada'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.lazada.LazadaGuideActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                lazadaGuideActivity.refuseRegisterLazada();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_agree, "method 'agreeRegisterLazada'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.lazada.LazadaGuideActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                lazadaGuideActivity.agreeRegisterLazada();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        LazadaGuideActivity lazadaGuideActivity = this.BuiltInFictitiousFunctionClassFactory;
        if (lazadaGuideActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        lazadaGuideActivity.rootLayout = null;
        lazadaGuideActivity.tvTermsAndConditions = null;
        lazadaGuideActivity.tvLazadaTitle = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
