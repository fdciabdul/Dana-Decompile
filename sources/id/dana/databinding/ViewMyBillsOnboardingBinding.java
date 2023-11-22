package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewMyBillsOnboardingBinding implements ViewBinding {
    public final TabLayout BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayoutCompat MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final LinearLayoutCompat getAuthRequestContext;
    public final ViewPager2 moveToNextValue;

    private ViewMyBillsOnboardingBinding(LinearLayoutCompat linearLayoutCompat, DanaButtonPrimaryView danaButtonPrimaryView, LinearLayoutCompat linearLayoutCompat2, LinearLayout linearLayout, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.MyBillsEntityDataFactory = linearLayoutCompat;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.getAuthRequestContext = linearLayoutCompat2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = tabLayout;
        this.moveToNextValue = viewPager2;
    }

    public static ViewMyBillsOnboardingBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.btn_next_on_boarding;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_next_on_boarding);
        if (danaButtonPrimaryView != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rl_btn_onboarding);
            if (linearLayout != null) {
                TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tlIndicator);
                if (tabLayout != null) {
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vp_onboarding);
                    if (viewPager2 != null) {
                        return new ViewMyBillsOnboardingBinding(linearLayoutCompat, danaButtonPrimaryView, linearLayoutCompat, linearLayout, tabLayout, viewPager2);
                    }
                    i = R.id.vp_onboarding;
                } else {
                    i = R.id.tlIndicator;
                }
            } else {
                i = R.id.rl_btn_onboarding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
