package id.dana.danapoly.databinding;

import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewCustomActionCardPopupBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final Button KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final Button PlaceComponentResult;

    private ViewCustomActionCardPopupBinding(ConstraintLayout constraintLayout, Button button, Button button2, ConstraintLayout constraintLayout2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = button;
        this.PlaceComponentResult = button2;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
    }

    public static ViewCustomActionCardPopupBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.getSupportButtonTintMode;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (button != null) {
            i = R.id.VerifyPinStateManager$executeRiskChallenge$2$1;
            Button button2 = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (button2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new ViewCustomActionCardPopupBinding(constraintLayout, button, button2, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
