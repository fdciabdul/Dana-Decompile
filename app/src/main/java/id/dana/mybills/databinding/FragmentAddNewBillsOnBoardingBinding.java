package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class FragmentAddNewBillsOnBoardingBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final CoordinatorLayout PlaceComponentResult;
    public final TabLayout getAuthRequestContext;
    public final ViewPager2 getErrorConfigVersion;
    private final CoordinatorLayout lookAheadTest;

    private FragmentAddNewBillsOnBoardingBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, CoordinatorLayout coordinatorLayout2, FrameLayout frameLayout, TabLayout tabLayout, View view, ViewPager2 viewPager2) {
        this.lookAheadTest = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.PlaceComponentResult = coordinatorLayout2;
        this.MyBillsEntityDataFactory = frameLayout;
        this.getAuthRequestContext = tabLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.getErrorConfigVersion = viewPager2;
    }

    public static FragmentAddNewBillsOnBoardingBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.fragment_add_new_bills_on_boarding, viewGroup, false);
        int i = R.id.btn_next_on_boarding;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            i = R.id.res_0x7f0a075c_flowviewutil_textchanges_1;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (frameLayout != null) {
                i = R.id.applyTrimPathIfNeeded;
                TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (tabLayout != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.view_drag))) != null) {
                    i = R.id.onLayoutDirectionChanged;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (viewPager2 != null) {
                        return new FragmentAddNewBillsOnBoardingBinding(coordinatorLayout, danaButtonPrimaryView, coordinatorLayout, frameLayout, tabLayout, BuiltInFictitiousFunctionClassFactory, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
