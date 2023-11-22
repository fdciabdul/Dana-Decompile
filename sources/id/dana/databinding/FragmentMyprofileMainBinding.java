package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class FragmentMyprofileMainBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ViewPager2 MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final TabLayout getAuthRequestContext;

    private FragmentMyprofileMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = appCompatImageView;
        this.getAuthRequestContext = tabLayout;
        this.MyBillsEntityDataFactory = viewPager2;
    }

    public static FragmentMyprofileMainBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.cl_profile_tab;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_profile_tab);
        if (constraintLayout != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_setting);
            if (appCompatImageView != null) {
                TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tl_profile_tab);
                if (tabLayout != null) {
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vp_profile);
                    if (viewPager2 != null) {
                        return new FragmentMyprofileMainBinding((ConstraintLayout) view, constraintLayout, appCompatImageView, tabLayout, viewPager2);
                    }
                    i = R.id.vp_profile;
                } else {
                    i = R.id.tl_profile_tab;
                }
            } else {
                i = R.id.iv_setting;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
