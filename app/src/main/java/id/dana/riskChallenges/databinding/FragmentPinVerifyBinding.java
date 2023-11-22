package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentPinVerifyBinding implements ViewBinding {
    public final ViewToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutPinVerifyBinding MyBillsEntityDataFactory;
    public final LinearLayoutCompat PlaceComponentResult;
    private final LinearLayoutCompat getAuthRequestContext;

    private FragmentPinVerifyBinding(LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, ViewToolbarBinding viewToolbarBinding, LayoutPinVerifyBinding layoutPinVerifyBinding) {
        this.getAuthRequestContext = linearLayoutCompat;
        this.PlaceComponentResult = linearLayoutCompat2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewToolbarBinding;
        this.MyBillsEntityDataFactory = layoutPinVerifyBinding;
    }

    public static FragmentPinVerifyBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d01fa_networkuserentitydata_externalsyntheticlambda1, (ViewGroup) null, false);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) inflate;
        int i = R.id.E;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ViewToolbarBinding MyBillsEntityDataFactory = ViewToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            int i2 = R.id.res_0x7f0a1bb0_summaryvoucherview_externalsyntheticlambda1;
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i2);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                return new FragmentPinVerifyBinding(linearLayoutCompat, linearLayoutCompat, MyBillsEntityDataFactory, LayoutPinVerifyBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
