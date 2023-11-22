package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class NewViewNearbyMeEntryPointBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    private final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final RelativeLayout getAuthRequestContext;
    public final LayoutLocationPermissionStateNearbyBinding getErrorConfigVersion;
    public final NewLayoutEmptyStateNearbyBinding lookAheadTest;
    public final ViewHeaderWithActionBinding moveToNextValue;
    public final TextView scheduleImpl;

    private NewViewNearbyMeEntryPointBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TextView textView, TextView textView2, ViewHeaderWithActionBinding viewHeaderWithActionBinding, NewLayoutEmptyStateNearbyBinding newLayoutEmptyStateNearbyBinding, LayoutLocationPermissionStateNearbyBinding layoutLocationPermissionStateNearbyBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearLayout;
        this.getAuthRequestContext = relativeLayout;
        this.MyBillsEntityDataFactory = linearLayout2;
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.scheduleImpl = textView2;
        this.moveToNextValue = viewHeaderWithActionBinding;
        this.lookAheadTest = newLayoutEmptyStateNearbyBinding;
        this.getErrorConfigVersion = layoutLocationPermissionStateNearbyBinding;
    }

    public static NewViewNearbyMeEntryPointBinding PlaceComponentResult(View view) {
        int i = R.id.cl_map_section;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_map_section);
        if (relativeLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_widget_map);
            if (appCompatImageView != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_nearby_shop);
                if (recyclerView != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_current_location);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_current_location_title);
                        if (textView2 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.v_header_with_action);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                ViewHeaderWithActionBinding PlaceComponentResult = ViewHeaderWithActionBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_nearby_empty_state);
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    NewLayoutEmptyStateNearbyBinding BuiltInFictitiousFunctionClassFactory3 = NewLayoutEmptyStateNearbyBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
                                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_nearby_location_permission_state);
                                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                        return new NewViewNearbyMeEntryPointBinding(linearLayout, relativeLayout, linearLayout, appCompatImageView, recyclerView, textView, textView2, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory3, LayoutLocationPermissionStateNearbyBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory4));
                                    }
                                    i = R.id.view_nearby_location_permission_state;
                                } else {
                                    i = R.id.view_nearby_empty_state;
                                }
                            } else {
                                i = R.id.v_header_with_action;
                            }
                        } else {
                            i = R.id.tv_current_location_title;
                        }
                    } else {
                        i = R.id.tv_current_location;
                    }
                } else {
                    i = R.id.rv_nearby_shop;
                }
            } else {
                i = R.id.iv_widget_map;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
