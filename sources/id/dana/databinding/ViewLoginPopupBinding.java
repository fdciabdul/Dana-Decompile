package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewLoginPopupBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final Button KClassImpl$Data$declaredNonStaticMembers$2;
    public final Button MyBillsEntityDataFactory;
    public final ViewSimplePopupBinding PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;

    private ViewLoginPopupBinding(LinearLayout linearLayout, Button button, Button button2, LinearLayout linearLayout2, ViewSimplePopupBinding viewSimplePopupBinding) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.MyBillsEntityDataFactory = button;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = button2;
        this.getAuthRequestContext = linearLayout2;
        this.PlaceComponentResult = viewSimplePopupBinding;
    }

    public static ViewLoginPopupBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.btn_negative;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_negative);
        if (button != null) {
            Button button2 = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_positive);
            if (button2 != null) {
                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_action_dialog);
                if (linearLayout != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewSimplePopup);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        return new ViewLoginPopupBinding((LinearLayout) view, button, button2, linearLayout, ViewSimplePopupBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
                    }
                    i = R.id.viewSimplePopup;
                } else {
                    i = R.id.ll_action_dialog;
                }
            } else {
                i = R.id.btn_positive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
