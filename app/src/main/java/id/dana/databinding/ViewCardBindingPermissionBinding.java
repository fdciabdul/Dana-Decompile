package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes8.dex */
public final class ViewCardBindingPermissionBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;

    private ViewCardBindingPermissionBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
    }

    public static ViewCardBindingPermissionBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.f3455res_0x7f0a0128_networkuserentitydata_externalsyntheticlambda4;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3455res_0x7f0a0128_networkuserentitydata_externalsyntheticlambda4);
        if (danaButtonPrimaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivCamera);
            if (appCompatImageView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPermissionDetail);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPermissionTitle);
                    if (appCompatTextView2 != null) {
                        return new ViewCardBindingPermissionBinding((ConstraintLayout) view, danaButtonPrimaryView, appCompatImageView, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.tvPermissionTitle;
                } else {
                    i = R.id.tvPermissionDetail;
                }
            } else {
                i = R.id.ivCamera;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
