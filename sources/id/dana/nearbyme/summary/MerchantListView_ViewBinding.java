package id.dana.nearbyme.summary;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.nearbyme.NearbyMerchantLocationSearchView;

/* loaded from: classes9.dex */
public class MerchantListView_ViewBinding implements Unbinder {
    private MerchantListView KClassImpl$Data$declaredNonStaticMembers$2;

    public MerchantListView_ViewBinding(MerchantListView merchantListView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantListView;
        merchantListView.clMerchantList = (CoordinatorLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_merchant_list, "field 'clMerchantList'", CoordinatorLayout.class);
        merchantListView.clToolbarContent = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_toolbar_content, "field 'clToolbarContent'", ConstraintLayout.class);
        merchantListView.etNearbySearch = (EditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.et_nearby_search, "field 'etNearbySearch'", EditText.class);
        merchantListView.llMerchantListEmptyState = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_merchant_list_empty_state, "field 'llMerchantListEmptyState'", LinearLayout.class);
        merchantListView.nearbyMerchantLocationSearchView = (NearbyMerchantLocationSearchView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_nearby_merchant_location_search, "field 'nearbyMerchantLocationSearchView'", NearbyMerchantLocationSearchView.class);
        merchantListView.nestedScrollView = (NestedScrollView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4055nested_scroll_view, "field 'nestedScrollView'", NestedScrollView.class);
        merchantListView.rvMerchantCategory = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_merchant_category, "field 'rvMerchantCategory'", RecyclerView.class);
        merchantListView.rvMerchantList = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_merchants_list, "field 'rvMerchantList'", RecyclerView.class);
        merchantListView.viewDivider = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_divider, "field 'viewDivider'");
        merchantListView.viewSpacer = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_spacing, "field 'viewSpacer'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        MerchantListView merchantListView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantListView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        merchantListView.clMerchantList = null;
        merchantListView.clToolbarContent = null;
        merchantListView.etNearbySearch = null;
        merchantListView.llMerchantListEmptyState = null;
        merchantListView.nearbyMerchantLocationSearchView = null;
        merchantListView.nestedScrollView = null;
        merchantListView.rvMerchantCategory = null;
        merchantListView.rvMerchantList = null;
        merchantListView.viewDivider = null;
        merchantListView.viewSpacer = null;
    }
}
