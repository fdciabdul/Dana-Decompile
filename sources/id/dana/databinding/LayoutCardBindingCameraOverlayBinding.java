package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes8.dex */
public final class LayoutCardBindingCameraOverlayBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ViewCardBindingPermissionBinding MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private LayoutCardBindingCameraOverlayBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ViewCardBindingPermissionBinding viewCardBindingPermissionBinding) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.PlaceComponentResult = appCompatImageView3;
        this.MyBillsEntityDataFactory = viewCardBindingPermissionBinding;
    }

    public static LayoutCardBindingCameraOverlayBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.ivCard;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivCard);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivScanEffect);
            if (appCompatImageView2 != null) {
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivStrokeBtm);
                if (appCompatImageView3 != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewCardBindingPermission);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        return new LayoutCardBindingCameraOverlayBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, ViewCardBindingPermissionBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                    }
                    i = R.id.viewCardBindingPermission;
                } else {
                    i = R.id.ivStrokeBtm;
                }
            } else {
                i = R.id.ivScanEffect;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
