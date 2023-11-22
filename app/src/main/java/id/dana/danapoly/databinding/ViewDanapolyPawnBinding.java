package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewDanapolyPawnBinding implements ViewBinding {
    public final ShapeableImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ViewDanapolyPawnBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = shapeableImageView;
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
    }

    public static ViewDanapolyPawnBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_danapoly_pawn, (ViewGroup) null, false);
        int i = R.id.z;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (shapeableImageView != null) {
            i = R.id.retainOrRemoveAllInternal;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatImageView != null) {
                i = R.id.ReferralMapper_Factory_res_0x7f0a0bbe;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView2 != null) {
                    return new ViewDanapolyPawnBinding((ConstraintLayout) inflate, shapeableImageView, appCompatImageView, appCompatImageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
