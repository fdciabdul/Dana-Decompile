package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class CarrierIdentificationToolbarBinding implements ViewBinding {
    public final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final Toolbar KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;

    private CarrierIdentificationToolbarBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RelativeLayout relativeLayout, Toolbar toolbar) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.getAuthRequestContext = imageView;
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = toolbar;
    }

    public static CarrierIdentificationToolbarBinding MyBillsEntityDataFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_title_image;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_title_image);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rl_toolbar);
            if (relativeLayout != null) {
                Toolbar toolbar = (Toolbar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.toolbar);
                if (toolbar != null) {
                    return new CarrierIdentificationToolbarBinding(constraintLayout, constraintLayout, imageView, relativeLayout, toolbar);
                }
                i = R.id.toolbar;
            } else {
                i = R.id.rl_toolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
