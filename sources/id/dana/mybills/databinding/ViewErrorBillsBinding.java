package id.dana.mybills.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.mybills.R;

/* loaded from: classes2.dex */
public final class ViewErrorBillsBinding implements ViewBinding {
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;

    private ViewErrorBillsBinding(LinearLayout linearLayout, DanaButtonPrimaryView danaButtonPrimaryView, LinearLayout linearLayout2) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.PlaceComponentResult = linearLayout2;
    }

    public static ViewErrorBillsBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.C;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (danaButtonPrimaryView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new ViewErrorBillsBinding(linearLayout, danaButtonPrimaryView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
