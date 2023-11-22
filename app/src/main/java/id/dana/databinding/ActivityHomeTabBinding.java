package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import id.dana.R;

/* loaded from: classes2.dex */
public final class ActivityHomeTabBinding implements ViewBinding {
    public final CoordinatorLayout KClassImpl$Data$declaredNonStaticMembers$2;
    private final CoordinatorLayout MyBillsEntityDataFactory;
    public final ViewPager2 PlaceComponentResult;

    private ActivityHomeTabBinding(CoordinatorLayout coordinatorLayout, ViewPager2 viewPager2, CoordinatorLayout coordinatorLayout2) {
        this.MyBillsEntityDataFactory = coordinatorLayout;
        this.PlaceComponentResult = viewPager2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coordinatorLayout2;
    }

    public static ActivityHomeTabBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_home_tab, (ViewGroup) null, false);
        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.container);
        if (viewPager2 != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            return new ActivityHomeTabBinding(coordinatorLayout, viewPager2, coordinatorLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.container)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
