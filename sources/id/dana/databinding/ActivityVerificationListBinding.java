package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityVerificationListBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final TabLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ViewPager2 MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final LayoutToolbarBinding getAuthRequestContext;

    private ActivityVerificationListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TabLayout tabLayout, LayoutToolbarBinding layoutToolbarBinding, ViewPager2 viewPager2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = tabLayout;
        this.getAuthRequestContext = layoutToolbarBinding;
        this.MyBillsEntityDataFactory = viewPager2;
    }

    public static ActivityVerificationListBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_verification_list, (ViewGroup) null, false);
        int i = R.id.cl_verification_list_tab;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_verification_list_tab);
        if (constraintLayout != null) {
            TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tl_verification_list_tab);
            if (tabLayout != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4218toolbar_layout);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vp_verification_list);
                    if (viewPager2 != null) {
                        return new ActivityVerificationListBinding((ConstraintLayout) inflate, constraintLayout, tabLayout, MyBillsEntityDataFactory, viewPager2);
                    }
                    i = R.id.vp_verification_list;
                } else {
                    i = R.id.f4218toolbar_layout;
                }
            } else {
                i = R.id.tl_verification_list_tab;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
