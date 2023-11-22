package id.dana.richview.homereferral;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class HomeReferralView_ViewBinding implements Unbinder {
    private HomeReferralView BuiltInFictitiousFunctionClassFactory;
    private View getAuthRequestContext;

    public HomeReferralView_ViewBinding(final HomeReferralView homeReferralView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = homeReferralView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_home_referral_banner, "field 'ivReferralBanner' and method 'onBannerClicked'");
        homeReferralView.ivReferralBanner = (ImageView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.iv_home_referral_banner, "field 'ivReferralBanner'", ImageView.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.homereferral.HomeReferralView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                homeReferralView.onBannerClicked();
            }
        });
        homeReferralView.clReferralContainer = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_home_referral_container, "field 'clReferralContainer'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        HomeReferralView homeReferralView = this.BuiltInFictitiousFunctionClassFactory;
        if (homeReferralView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        homeReferralView.ivReferralBanner = null;
        homeReferralView.clReferralContainer = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
