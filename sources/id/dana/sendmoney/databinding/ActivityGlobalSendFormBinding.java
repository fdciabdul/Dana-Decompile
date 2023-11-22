package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ActivityGlobalSendFormBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ViewToolbarBinding PlaceComponentResult;
    public final ViewPager2 getAuthRequestContext;

    private ActivityGlobalSendFormBinding(ConstraintLayout constraintLayout, ViewPager2 viewPager2, ViewToolbarBinding viewToolbarBinding) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.getAuthRequestContext = viewPager2;
        this.PlaceComponentResult = viewToolbarBinding;
    }

    public static ActivityGlobalSendFormBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.activity_global_send_form, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a1ac7_reduceops_8reducingsink;
        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (viewPager2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a1b9e))) != null) {
            return new ActivityGlobalSendFormBinding((ConstraintLayout) inflate, viewPager2, ViewToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
