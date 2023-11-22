package id.dana.core.ui.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewDanaLogoProgressBinding implements ViewBinding {
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    private final RelativeLayout PlaceComponentResult;

    private ViewDanaLogoProgressBinding(RelativeLayout relativeLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.PlaceComponentResult = relativeLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
    }

    public static ViewDanaLogoProgressBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatImageView != null) {
            i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda2;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatImageView2 != null) {
                return new ViewDanaLogoProgressBinding((RelativeLayout) view, appCompatImageView, appCompatImageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
