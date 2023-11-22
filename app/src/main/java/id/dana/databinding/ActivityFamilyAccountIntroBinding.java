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
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ActivityFamilyAccountIntroBinding implements ViewBinding {
    public final TabLayout BuiltInFictitiousFunctionClassFactory;
    public final ViewPager2 KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final LayoutToolbarBinding getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ActivityFamilyAccountIntroBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout2, LayoutToolbarBinding layoutToolbarBinding, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.scheduleImpl = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.PlaceComponentResult = constraintLayout2;
        this.getAuthRequestContext = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = tabLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewPager2;
    }

    public static ActivityFamilyAccountIntroBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_account_intro, (ViewGroup) null, false);
        int i = R.id.f3451isLayoutRequested_res_0x7f0a011f;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3451isLayoutRequested_res_0x7f0a011f);
        if (danaButtonSecondaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clContainerVpContent);
            if (constraintLayout != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tlIndicator);
                    if (tabLayout != null) {
                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vpContent);
                        if (viewPager2 != null) {
                            return new ActivityFamilyAccountIntroBinding((ConstraintLayout) inflate, danaButtonSecondaryView, constraintLayout, MyBillsEntityDataFactory, tabLayout, viewPager2);
                        }
                        i = R.id.vpContent;
                    } else {
                        i = R.id.tlIndicator;
                    }
                } else {
                    i = R.id.layoutToolbar;
                }
            } else {
                i = R.id.clContainerVpContent;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
