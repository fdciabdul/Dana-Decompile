package id.dana.nearbyme.summary;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes9.dex */
public class NearbyMeSummaryFragment_ViewBinding implements Unbinder {
    private NearbyMeSummaryFragment KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public NearbyMeSummaryFragment_ViewBinding(final NearbyMeSummaryFragment nearbyMeSummaryFragment, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = nearbyMeSummaryFragment;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3533JsonParseException_res_0x7f0a023e, "field 'btnTopUp' and method 'onTopUpClicked'");
        nearbyMeSummaryFragment.btnTopUp = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.f3533JsonParseException_res_0x7f0a023e, "field 'btnTopUp'", Button.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.summary.NearbyMeSummaryFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeSummaryFragment.onTopUpClicked();
            }
        });
        nearbyMeSummaryFragment.clNearbyMeEmpty = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_nearby_me_empty, "field 'clNearbyMeEmpty'", ConstraintLayout.class);
        nearbyMeSummaryFragment.clNearbyMeNormal = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_nearby_me_normal, "field 'clNearbyMeNormal'", ConstraintLayout.class);
        nearbyMeSummaryFragment.clRibbonContainer = (ViewGroup) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_ribbon_container, "field 'clRibbonContainer'", ViewGroup.class);
        nearbyMeSummaryFragment.dividerPromoRibbon = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3743divider_promo_ribbon, "field 'dividerPromoRibbon'");
        nearbyMeSummaryFragment.ivEmptyImage = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_empty_image, "field 'ivEmptyImage'", ImageView.class);
        nearbyMeSummaryFragment.ivStoreImage = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_store_image, "field 'ivStoreImage'", ImageView.class);
        nearbyMeSummaryFragment.ivViewNearbyMeSummaryInfoIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_view_nearby_me_summary_info_icon, "field 'ivViewNearbyMeSummaryInfoIcon'", ImageView.class);
        nearbyMeSummaryFragment.lottieNearbyRibbon = (LottieAnimationView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.lottie_nearby_ribbon, "field 'lottieNearbyRibbon'", LottieAnimationView.class);
        nearbyMeSummaryFragment.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        nearbyMeSummaryFragment.tvEmptyDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_empty_description, "field 'tvEmptyDescription'", TextView.class);
        nearbyMeSummaryFragment.tvEmptyTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_empty_title, "field 'tvEmptyTitle'", TextView.class);
        nearbyMeSummaryFragment.tvMerchantSubCategory = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_merchant_sub_category, "field 'tvMerchantSubCategory'", TextView.class);
        nearbyMeSummaryFragment.tvRibbonLineBottom = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_ribbon_line_bottom, "field 'tvRibbonLineBottom'", TextView.class);
        nearbyMeSummaryFragment.tvRibbonLineTop = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_ribbon_line_top, "field 'tvRibbonLineTop'", TextView.class);
        nearbyMeSummaryFragment.tvStoreDistance = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_store_distance, "field 'tvStoreDistance'", TextView.class);
        nearbyMeSummaryFragment.tvStoreName = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_store_name, "field 'tvStoreName'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3513xb184aa5d, "method 'onDirectionClicked'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.summary.NearbyMeSummaryFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeSummaryFragment.onDirectionClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NearbyMeSummaryFragment nearbyMeSummaryFragment = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (nearbyMeSummaryFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        nearbyMeSummaryFragment.btnTopUp = null;
        nearbyMeSummaryFragment.clNearbyMeEmpty = null;
        nearbyMeSummaryFragment.clNearbyMeNormal = null;
        nearbyMeSummaryFragment.clRibbonContainer = null;
        nearbyMeSummaryFragment.dividerPromoRibbon = null;
        nearbyMeSummaryFragment.ivEmptyImage = null;
        nearbyMeSummaryFragment.ivStoreImage = null;
        nearbyMeSummaryFragment.ivViewNearbyMeSummaryInfoIcon = null;
        nearbyMeSummaryFragment.lottieNearbyRibbon = null;
        nearbyMeSummaryFragment.tvDescription = null;
        nearbyMeSummaryFragment.tvEmptyDescription = null;
        nearbyMeSummaryFragment.tvEmptyTitle = null;
        nearbyMeSummaryFragment.tvMerchantSubCategory = null;
        nearbyMeSummaryFragment.tvRibbonLineBottom = null;
        nearbyMeSummaryFragment.tvRibbonLineTop = null;
        nearbyMeSummaryFragment.tvStoreDistance = null;
        nearbyMeSummaryFragment.tvStoreName = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
