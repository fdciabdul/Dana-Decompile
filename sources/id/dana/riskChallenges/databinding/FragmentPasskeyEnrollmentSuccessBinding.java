package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentPasskeyEnrollmentSuccessBinding implements ViewBinding {
    private final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final ShapeableImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final ViewBaseToolbarBinding getAuthRequestContext;

    private FragmentPasskeyEnrollmentSuccessBinding(RelativeLayout relativeLayout, ShapeableImageView shapeableImageView, ViewBaseToolbarBinding viewBaseToolbarBinding, TextView textView, TextView textView2) {
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shapeableImageView;
        this.getAuthRequestContext = viewBaseToolbarBinding;
        this.PlaceComponentResult = textView;
        this.MyBillsEntityDataFactory = textView2;
    }

    public static FragmentPasskeyEnrollmentSuccessBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d01f0_networkuserentitydata_externalsyntheticlambda2, (ViewGroup) null, false);
        int i = R.id.iv_illustration_passkey_enrollment_success;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (shapeableImageView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.res_0x7f0a1368_verifypinstatemanager_executeriskchallenge_2_2))) != null) {
            ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            i = R.id.tv_desc_passkey_enrollment_success;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.res_0x7f0a1932_summaryvoucherview_externalsyntheticlambda0;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    return new FragmentPasskeyEnrollmentSuccessBinding((RelativeLayout) inflate, shapeableImageView, MyBillsEntityDataFactory, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
