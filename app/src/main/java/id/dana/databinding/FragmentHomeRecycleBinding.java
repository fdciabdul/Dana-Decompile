package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import id.dana.R;
import id.dana.richview.MaintenanceBroadcastView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/* loaded from: classes4.dex */
public final class FragmentHomeRecycleBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final ViewHomeToolbarMenuBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final AppBarLayout PlaceComponentResult;
    public final PtrClassicFrameLayout getAuthRequestContext;
    public final MaintenanceBroadcastView getErrorConfigVersion;
    private final LinearLayout lookAheadTest;

    private FragmentHomeRecycleBinding(LinearLayout linearLayout, AppBarLayout appBarLayout, LinearLayout linearLayout2, ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding, PtrClassicFrameLayout ptrClassicFrameLayout, RecyclerView recyclerView, MaintenanceBroadcastView maintenanceBroadcastView) {
        this.lookAheadTest = linearLayout;
        this.PlaceComponentResult = appBarLayout;
        this.MyBillsEntityDataFactory = linearLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewHomeToolbarMenuBinding;
        this.getAuthRequestContext = ptrClassicFrameLayout;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.getErrorConfigVersion = maintenanceBroadcastView;
    }

    public static FragmentHomeRecycleBinding PlaceComponentResult(View view) {
        int i = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.appbar);
        if (appBarLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.include_view_home_toolbar_menu);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ViewHomeToolbarMenuBinding MyBillsEntityDataFactory = ViewHomeToolbarMenuBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ptr_home);
                if (ptrClassicFrameLayout != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_main_content);
                    if (recyclerView != null) {
                        MaintenanceBroadcastView maintenanceBroadcastView = (MaintenanceBroadcastView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_home_widget_ticker);
                        if (maintenanceBroadcastView != null) {
                            return new FragmentHomeRecycleBinding(linearLayout, appBarLayout, linearLayout, MyBillsEntityDataFactory, ptrClassicFrameLayout, recyclerView, maintenanceBroadcastView);
                        }
                        i = R.id.view_home_widget_ticker;
                    } else {
                        i = R.id.rv_main_content;
                    }
                } else {
                    i = R.id.ptr_home;
                }
            } else {
                i = R.id.include_view_home_toolbar_menu;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
