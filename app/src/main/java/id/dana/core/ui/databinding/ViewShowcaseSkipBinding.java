package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewShowcaseSkipBinding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout PlaceComponentResult;

    private ViewShowcaseSkipBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = linearLayout;
    }

    public static ViewShowcaseSkipBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0699_networkuserentitydata_externalsyntheticlambda7, (ViewGroup) null, false);
        int i = R.id.getSupportButtonTintMode;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (linearLayout != null) {
            return new ViewShowcaseSkipBinding((ConstraintLayout) inflate, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
