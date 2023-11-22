package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewDanapolyBoardCardBinding implements ViewBinding {
    public final ShapeableImageView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ViewDanapolyBoardCardBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = shapeableImageView;
    }

    public static ViewDanapolyBoardCardBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_danapoly_board_card, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a0a9f_otpregistrationpresenter_input_1;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (shapeableImageView != null) {
            return new ViewDanapolyBoardCardBinding((ConstraintLayout) inflate, shapeableImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
