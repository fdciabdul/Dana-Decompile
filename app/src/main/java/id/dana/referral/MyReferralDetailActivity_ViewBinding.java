package id.dana.referral;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MyReferralDetailActivity_ViewBinding implements Unbinder {
    private View MyBillsEntityDataFactory;
    private MyReferralDetailActivity getAuthRequestContext;

    public MyReferralDetailActivity_ViewBinding(final MyReferralDetailActivity myReferralDetailActivity, View view) {
        this.getAuthRequestContext = myReferralDetailActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.left_button, "method 'closeToHome'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.referral.MyReferralDetailActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                myReferralDetailActivity.closeToHome(view2);
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
    }
}
