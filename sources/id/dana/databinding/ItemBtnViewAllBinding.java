package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ItemBtnViewAllBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout PlaceComponentResult;

    private ItemBtnViewAllBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView) {
        this.PlaceComponentResult = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
    }

    public static ItemBtnViewAllBinding BuiltInFictitiousFunctionClassFactory(View view) {
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnViewAll);
        if (danaButtonSecondaryView != null) {
            return new ItemBtnViewAllBinding((ConstraintLayout) view, danaButtonSecondaryView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.btnViewAll)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
