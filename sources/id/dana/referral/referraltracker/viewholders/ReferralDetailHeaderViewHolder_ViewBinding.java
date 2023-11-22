package id.dana.referral.referraltracker.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ReferralDetailHeaderViewHolder_ViewBinding implements Unbinder {
    private ReferralDetailHeaderViewHolder MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public ReferralDetailHeaderViewHolder_ViewBinding(final ReferralDetailHeaderViewHolder referralDetailHeaderViewHolder, View view) {
        this.MyBillsEntityDataFactory = referralDetailHeaderViewHolder;
        referralDetailHeaderViewHolder.tvReferralTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_referral_title, "field 'tvReferralTitle'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_see_how_it_works_header, "field 'tvSeeHowItWorksHeader' and method 'doOpenHowItWorks'");
        referralDetailHeaderViewHolder.tvSeeHowItWorksHeader = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.tv_see_how_it_works_header, "field 'tvSeeHowItWorksHeader'", TextView.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.referral.referraltracker.viewholders.ReferralDetailHeaderViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                referralDetailHeaderViewHolder.doOpenHowItWorks();
            }
        });
        referralDetailHeaderViewHolder.btnReferralTracker = Utils.KClassImpl$Data$declaredNonStaticMembers$2((Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_referral_tracker_first, "field 'btnReferralTracker'", Button.class), (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_referral_tracker_second, "field 'btnReferralTracker'", Button.class));
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ReferralDetailHeaderViewHolder referralDetailHeaderViewHolder = this.MyBillsEntityDataFactory;
        if (referralDetailHeaderViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        referralDetailHeaderViewHolder.tvReferralTitle = null;
        referralDetailHeaderViewHolder.tvSeeHowItWorksHeader = null;
        referralDetailHeaderViewHolder.btnReferralTracker = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
