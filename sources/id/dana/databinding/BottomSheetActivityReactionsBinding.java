package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetActivityReactionsBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TabLayout MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final ViewPager getAuthRequestContext;
    private final FrameLayout scheduleImpl;

    private BottomSheetActivityReactionsBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, FrameLayout frameLayout2, ImageView imageView, TabLayout tabLayout, ViewPager viewPager) {
        this.scheduleImpl = frameLayout;
        this.PlaceComponentResult = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.MyBillsEntityDataFactory = tabLayout;
        this.getAuthRequestContext = viewPager;
    }

    public static BottomSheetActivityReactionsBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.cl_activity_reactions;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_activity_reactions);
        if (constraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.secondaryHash_res_0x7f0a08d3);
            if (imageView != null) {
                TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tl_activity_reactions);
                if (tabLayout != null) {
                    ViewPager viewPager = (ViewPager) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vp_activity_reactions);
                    if (viewPager != null) {
                        return new BottomSheetActivityReactionsBinding(frameLayout, constraintLayout, frameLayout, imageView, tabLayout, viewPager);
                    }
                    i = R.id.vp_activity_reactions;
                } else {
                    i = R.id.tl_activity_reactions;
                }
            } else {
                i = R.id.secondaryHash_res_0x7f0a08d3;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
