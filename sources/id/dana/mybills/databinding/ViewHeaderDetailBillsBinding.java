package id.dana.mybills.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.mybills.R;

/* loaded from: classes2.dex */
public final class ViewHeaderDetailBillsBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;

    private ViewHeaderDetailBillsBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonPrimaryView danaButtonPrimaryView, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.getAuthRequestContext = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.getErrorConfigVersion = textView3;
    }

    public static ViewHeaderDetailBillsBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda6;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (danaButtonSecondaryView != null) {
            i = R.id.getCallingPid;
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (danaButtonPrimaryView != null) {
                i = R.id.res_0x7f0a095a_otpregistrationpresenter_input_2;
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (imageView != null) {
                    i = R.id.BannerEntityDataFactory_Factory_res_0x7f0a13dd;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (textView != null) {
                        i = R.id.res_0x7f0a13de_view_onclicklistener;
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (textView2 != null) {
                            i = R.id.checkParameterIsNotNull_res_0x7f0a145f;
                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (textView3 != null) {
                                return new ViewHeaderDetailBillsBinding((ConstraintLayout) view, danaButtonSecondaryView, danaButtonPrimaryView, imageView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
