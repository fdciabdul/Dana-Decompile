package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewholderFeedViewAllBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;

    private ViewholderFeedViewAllBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
    }

    public static ViewholderFeedViewAllBinding BuiltInFictitiousFunctionClassFactory(View view) {
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnViewAll);
        if (danaButtonSecondaryView != null) {
            return new ViewholderFeedViewAllBinding((ConstraintLayout) view, danaButtonSecondaryView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.btnViewAll)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
