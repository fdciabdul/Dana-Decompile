package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;

/* loaded from: classes2.dex */
public final class FragmentHomeTabBinding implements ViewBinding {
    public final FragmentContainerView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageButton MyBillsEntityDataFactory;
    public final CoordinatorLayout PlaceComponentResult;
    public final TabLayout getAuthRequestContext;
    public final View lookAheadTest;
    private final CoordinatorLayout scheduleImpl;

    private FragmentHomeTabBinding(CoordinatorLayout coordinatorLayout, TabLayout tabLayout, LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, CoordinatorLayout coordinatorLayout2, FragmentContainerView fragmentContainerView, View view) {
        this.scheduleImpl = coordinatorLayout;
        this.getAuthRequestContext = tabLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.MyBillsEntityDataFactory = appCompatImageButton;
        this.PlaceComponentResult = coordinatorLayout2;
        this.BuiltInFictitiousFunctionClassFactory = fragmentContainerView;
        this.lookAheadTest = view;
    }

    public static FragmentHomeTabBinding getAuthRequestContext(View view) {
        int i = R.id.f3443bottom_tab_menu;
        TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3443bottom_tab_menu);
        if (tabLayout != null) {
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a00fd);
            if (linearLayout != null) {
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_home_tab_pay);
                if (appCompatImageButton != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fragment_container_view);
                    if (fragmentContainerView != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.separator);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            return new FragmentHomeTabBinding(coordinatorLayout, tabLayout, linearLayout, appCompatImageButton, coordinatorLayout, fragmentContainerView, BuiltInFictitiousFunctionClassFactory);
                        }
                        i = R.id.separator;
                    } else {
                        i = R.id.fragment_container_view;
                    }
                } else {
                    i = R.id.btn_home_tab_pay;
                }
            } else {
                i = R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a00fd;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
