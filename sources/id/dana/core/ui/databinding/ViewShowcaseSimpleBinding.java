package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewShowcaseSimpleBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final Button KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewShowcaseSimpleBinding(ConstraintLayout constraintLayout, Button button, TextView textView, TextView textView2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = button;
        this.PlaceComponentResult = textView;
        this.getAuthRequestContext = textView2;
    }

    public static ViewShowcaseSimpleBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_showcase_simple, (ViewGroup) null, false);
        int i = R.id.getAuthRequestContext_res_0x7f0a025a;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (button != null) {
            i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda0;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.M;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    return new ViewShowcaseSimpleBinding((ConstraintLayout) inflate, button, textView, textView2);
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
