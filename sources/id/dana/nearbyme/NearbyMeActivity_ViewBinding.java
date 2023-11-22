package id.dana.nearbyme;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import id.dana.R;
import id.dana.nearbyme.summary.MerchantListView;
import id.dana.richview.PinMapLottieAnimationView;

/* loaded from: classes9.dex */
public class NearbyMeActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private NearbyMeActivity KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;
    private View NetworkUserEntityData$$ExternalSyntheticLambda0;
    private View NetworkUserEntityData$$ExternalSyntheticLambda1;
    private View getAuthRequestContext;
    private View getErrorConfigVersion;
    private View initRecordTimeStamp;
    private View lookAheadTest;
    private View moveToNextValue;
    private View scheduleImpl;

    public NearbyMeActivity_ViewBinding(final NearbyMeActivity nearbyMeActivity, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = nearbyMeActivity;
        nearbyMeActivity.appBarLayout = (AppBarLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.app_bar_layout, "field 'appBarLayout'", AppBarLayout.class);
        nearbyMeActivity.clLayoutMerchant = (CoordinatorLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_merchant, "field 'clLayoutMerchant'", CoordinatorLayout.class);
        nearbyMeActivity.clLocationContainer = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_Location_container, "field 'clLocationContainer'", ConstraintLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.cv_go_to_my_location, "field 'cvGoToMyLocation' and method 'onGoToMyLocationClicked'");
        nearbyMeActivity.cvGoToMyLocation = (CardView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.cv_go_to_my_location, "field 'cvGoToMyLocation'", CardView.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onGoToMyLocationClicked();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.cv_info_legendary, "field 'cvInfoLegendary' and method 'onInfoLegendaryClicked'");
        nearbyMeActivity.cvInfoLegendary = (CardView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.cv_info_legendary, "field 'cvInfoLegendary'", CardView.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onInfoLegendaryClicked();
            }
        });
        nearbyMeActivity.cvMerchant = (CardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.card_view_merchant, "field 'cvMerchant'", CardView.class);
        View BuiltInFictitiousFunctionClassFactory3 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.et_nearby_search, "field 'etNearbySearch' and method 'onTextSearchTouched'");
        nearbyMeActivity.etNearbySearch = (EditText) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3, R.id.et_nearby_search, "field 'etNearbySearch'", EditText.class);
        this.lookAheadTest = BuiltInFictitiousFunctionClassFactory3;
        BuiltInFictitiousFunctionClassFactory3.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return nearbyMeActivity.onTextSearchTouched(view2, motionEvent);
            }
        });
        View BuiltInFictitiousFunctionClassFactory4 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_clear, "field 'ivClear' and method 'onIvClearClicked'");
        nearbyMeActivity.ivClear = (ImageView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory4, R.id.iv_clear, "field 'ivClear'", ImageView.class);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory4;
        BuiltInFictitiousFunctionClassFactory4.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onIvClearClicked();
            }
        });
        nearbyMeActivity.ivClose = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.RecurringAnnouncementEntity, "field 'ivClose'", ImageView.class);
        nearbyMeActivity.ivInfo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.CircularRevealCoordinatorLayout, "field 'ivInfo'", ImageView.class);
        nearbyMeActivity.ivLoader = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_loader, "field 'ivLoader'", ImageView.class);
        nearbyMeActivity.lavMapCenterPinPoint = (PinMapLottieAnimationView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.lav_map_center_pin_point, "field 'lavMapCenterPinPoint'", PinMapLottieAnimationView.class);
        nearbyMeActivity.merchantListView = (MerchantListView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_merchant_list, "field 'merchantListView'", MerchantListView.class);
        nearbyMeActivity.nearbyMerchantLocationSearchView = (NearbyMerchantLocationSearchView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_nearby_merchant_location_search, "field 'nearbyMerchantLocationSearchView'", NearbyMerchantLocationSearchView.class);
        View BuiltInFictitiousFunctionClassFactory5 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_change_location, "field 'tvChangeLocation' and method 'onLocationSearchClicked'");
        nearbyMeActivity.tvChangeLocation = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory5, R.id.tv_change_location, "field 'tvChangeLocation'", TextView.class);
        this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory5;
        BuiltInFictitiousFunctionClassFactory5.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onLocationSearchClicked();
            }
        });
        nearbyMeActivity.tvDistrictLocation = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_district_location, "field 'tvDistrictLocation'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory6 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_location, "field 'tvLocation' and method 'onLocationSearchClicked'");
        nearbyMeActivity.tvLocation = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory6, R.id.tv_location, "field 'tvLocation'", TextView.class);
        this.scheduleImpl = BuiltInFictitiousFunctionClassFactory6;
        BuiltInFictitiousFunctionClassFactory6.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onLocationSearchClicked();
            }
        });
        nearbyMeActivity.tvRefreshing = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_refreshing, "field 'tvRefreshing'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory7 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_search_here, "field 'tvSearchHere' and method 'onRefreshMerchantClicked'");
        nearbyMeActivity.tvSearchHere = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory7, R.id.tv_search_here, "field 'tvSearchHere'", TextView.class);
        this.initRecordTimeStamp = BuiltInFictitiousFunctionClassFactory7;
        BuiltInFictitiousFunctionClassFactory7.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onRefreshMerchantClicked();
            }
        });
        nearbyMeActivity.viewTooltipSpotlightContainer = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_tooltip_spotlight_container, "field 'viewTooltipSpotlightContainer'");
        nearbyMeActivity.viewTooltipSpotlightPointer = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_tooltip_spotlight, "field 'viewTooltipSpotlightPointer'");
        View BuiltInFictitiousFunctionClassFactory8 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.button_back, "method 'onButtonBackClicked'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory8;
        BuiltInFictitiousFunctionClassFactory8.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onButtonBackClicked();
            }
        });
        View BuiltInFictitiousFunctionClassFactory9 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_change, "method 'onTvChangeClicked' and method 'onLocationSearchClicked'");
        this.moveToNextValue = BuiltInFictitiousFunctionClassFactory9;
        BuiltInFictitiousFunctionClassFactory9.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onTvChangeClicked();
                nearbyMeActivity.onLocationSearchClicked();
            }
        });
        View BuiltInFictitiousFunctionClassFactory10 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_nearby_location, "method 'onTextSwipeUpClicked'");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory10;
        BuiltInFictitiousFunctionClassFactory10.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                nearbyMeActivity.onTextSwipeUpClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NearbyMeActivity nearbyMeActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (nearbyMeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        nearbyMeActivity.appBarLayout = null;
        nearbyMeActivity.clLayoutMerchant = null;
        nearbyMeActivity.clLocationContainer = null;
        nearbyMeActivity.cvGoToMyLocation = null;
        nearbyMeActivity.cvInfoLegendary = null;
        nearbyMeActivity.cvMerchant = null;
        nearbyMeActivity.etNearbySearch = null;
        nearbyMeActivity.ivClear = null;
        nearbyMeActivity.ivClose = null;
        nearbyMeActivity.ivInfo = null;
        nearbyMeActivity.ivLoader = null;
        nearbyMeActivity.lavMapCenterPinPoint = null;
        nearbyMeActivity.merchantListView = null;
        nearbyMeActivity.nearbyMerchantLocationSearchView = null;
        nearbyMeActivity.tvChangeLocation = null;
        nearbyMeActivity.tvDistrictLocation = null;
        nearbyMeActivity.tvLocation = null;
        nearbyMeActivity.tvRefreshing = null;
        nearbyMeActivity.tvSearchHere = null;
        nearbyMeActivity.viewTooltipSpotlightContainer = null;
        nearbyMeActivity.viewTooltipSpotlightPointer = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
        this.lookAheadTest.setOnTouchListener(null);
        this.lookAheadTest = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.getErrorConfigVersion.setOnClickListener(null);
        this.getErrorConfigVersion = null;
        this.scheduleImpl.setOnClickListener(null);
        this.scheduleImpl = null;
        this.initRecordTimeStamp.setOnClickListener(null);
        this.initRecordTimeStamp = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.moveToNextValue.setOnClickListener(null);
        this.moveToNextValue = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setOnClickListener(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    }
}
