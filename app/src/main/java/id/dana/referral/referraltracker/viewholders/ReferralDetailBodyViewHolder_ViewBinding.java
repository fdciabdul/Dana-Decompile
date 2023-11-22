package id.dana.referral.referraltracker.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ReferralDetailBodyViewHolder_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;
    private ReferralDetailBodyViewHolder getAuthRequestContext;
    private View lookAheadTest;

    public ReferralDetailBodyViewHolder_ViewBinding(final ReferralDetailBodyViewHolder referralDetailBodyViewHolder, View view) {
        this.getAuthRequestContext = referralDetailBodyViewHolder;
        referralDetailBodyViewHolder.tvReferralCode = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4488tv_referral_code, "field 'tvReferralCode'", TextView.class);
        referralDetailBodyViewHolder.tvReferralShareCode = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_referral_share_code, "field 'tvReferralShareCode'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_share_referral_code, "method 'doShareReferralCode'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.referral.referraltracker.viewholders.ReferralDetailBodyViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                referralDetailBodyViewHolder.doShareReferralCode(view2);
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_how_it_works, "method 'doOpenHowItWorks'");
        this.lookAheadTest = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.referral.referraltracker.viewholders.ReferralDetailBodyViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                referralDetailBodyViewHolder.doOpenHowItWorks();
            }
        });
        View BuiltInFictitiousFunctionClassFactory3 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_copy_referral_code, "method 'doCopyReferral'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory3;
        BuiltInFictitiousFunctionClassFactory3.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.referral.referraltracker.viewholders.ReferralDetailBodyViewHolder_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                referralDetailBodyViewHolder.doCopyReferral();
            }
        });
        View BuiltInFictitiousFunctionClassFactory4 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_referral_box, "method 'doCopyReferralBox'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory4;
        BuiltInFictitiousFunctionClassFactory4.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.referral.referraltracker.viewholders.ReferralDetailBodyViewHolder_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                referralDetailBodyViewHolder.doCopyReferralBox();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ReferralDetailBodyViewHolder referralDetailBodyViewHolder = this.getAuthRequestContext;
        if (referralDetailBodyViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        referralDetailBodyViewHolder.tvReferralCode = null;
        referralDetailBodyViewHolder.tvReferralShareCode = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.lookAheadTest.setOnClickListener(null);
        this.lookAheadTest = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
