package id.dana.sendmoney.premium;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class PremiumNoticeActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View MyBillsEntityDataFactory;
    private PremiumNoticeActivity getAuthRequestContext;

    public PremiumNoticeActivity_ViewBinding(final PremiumNoticeActivity premiumNoticeActivity, View view) {
        this.getAuthRequestContext = premiumNoticeActivity;
        premiumNoticeActivity.clContainer = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3647res_0x7f0a041b_fontscontractcompat_fontrequestcallback, "field 'clContainer'", ConstraintLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_upgrade, "method 'goToUpgradeProcess'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.premium.PremiumNoticeActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                premiumNoticeActivity.goToUpgradeProcess();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_use_card, "method 'applyUseCardPayMethod'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.premium.PremiumNoticeActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                premiumNoticeActivity.applyUseCardPayMethod();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PremiumNoticeActivity premiumNoticeActivity = this.getAuthRequestContext;
        if (premiumNoticeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        premiumNoticeActivity.clContainer = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
