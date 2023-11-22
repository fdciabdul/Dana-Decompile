package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ItemNumpadBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ItemNumpadBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TextView textView) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ItemNumpadBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_numpad, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.res_0x7f0a099a_networkuserentitydata_externalsyntheticlambda7;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.tvNumber;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                return new ItemNumpadBinding(constraintLayout, constraintLayout, appCompatImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
