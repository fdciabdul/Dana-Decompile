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
public final class ViewDanapolyColorPickerBinding implements ViewBinding {
    public final ShapeableImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ShapeableImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final ShapeableImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ShapeableImageView lookAheadTest;
    public final ShapeableImageView moveToNextValue;
    public final View scheduleImpl;

    private ViewDanapolyColorPickerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, ShapeableImageView shapeableImageView4, ShapeableImageView shapeableImageView5, View view) {
        this.getErrorConfigVersion = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = shapeableImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.getAuthRequestContext = shapeableImageView2;
        this.moveToNextValue = shapeableImageView3;
        this.lookAheadTest = shapeableImageView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = shapeableImageView5;
        this.scheduleImpl = view;
    }

    public static ViewDanapolyColorPickerBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d04fc_networkuserentitydata_externalsyntheticlambda5, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.FlowViewUtil$textChanges$2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.res_0x7f0a095c_access_throwillegalargumenttype;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (shapeableImageView != null) {
                i = R.id.res_0x7f0a0975_daggeruserbankcardcomponent_userbankcardcomponentimpl_postexecutionthreadprovider;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView2 != null) {
                    i = R.id.ivGreenCircle;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (shapeableImageView2 != null) {
                        i = R.id.ivOrangeCircle;
                        ShapeableImageView shapeableImageView3 = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (shapeableImageView3 != null) {
                            i = R.id.ivPinkCircle;
                            ShapeableImageView shapeableImageView4 = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (shapeableImageView4 != null) {
                                i = R.id.ivPurpleCircle;
                                ShapeableImageView shapeableImageView5 = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (shapeableImageView5 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.removeFloat))) != null) {
                                    return new ViewDanapolyColorPickerBinding(constraintLayout, constraintLayout, appCompatImageView, shapeableImageView, appCompatImageView2, shapeableImageView2, shapeableImageView3, shapeableImageView4, shapeableImageView5, BuiltInFictitiousFunctionClassFactory);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
