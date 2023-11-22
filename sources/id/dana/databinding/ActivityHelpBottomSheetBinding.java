package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityHelpBottomSheetBinding implements ViewBinding {
    public final ViewHelpBottomSheetBinding BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final View PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ActivityHelpBottomSheetBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ViewHelpBottomSheetBinding viewHelpBottomSheetBinding, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = viewHelpBottomSheetBinding;
        this.PlaceComponentResult = view;
    }

    public static ActivityHelpBottomSheetBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_help_bottom_sheet, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.rv_bottom_container;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rv_bottom_container);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ViewHelpBottomSheetBinding PlaceComponentResult = ViewHelpBottomSheetBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_transparent);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                return new ActivityHelpBottomSheetBinding(constraintLayout, constraintLayout, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory2);
            }
            i = R.id.view_transparent;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
