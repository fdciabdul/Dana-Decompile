package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ItemAddNewBillsOnboardingBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayoutCompat MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;

    private ItemAddNewBillsOnboardingBinding(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = linearLayoutCompat;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView2;
    }

    public static ItemAddNewBillsOnboardingBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_add_new_bills_onboarding, viewGroup, false);
        int i = R.id.res_0x7f0a0bb1_otpregistrationpresenter_input_1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.tv_onboard_description;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.res_0x7f0a180b_getwalletv3recommendationconfig_lambda_193;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    return new ItemAddNewBillsOnboardingBinding((LinearLayoutCompat) inflate, appCompatImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
