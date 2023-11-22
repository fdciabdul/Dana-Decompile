package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewPayConfirmationAddOnBinding implements ViewBinding {
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;

    private ViewPayConfirmationAddOnBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, RecyclerView recyclerView) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
    }

    public static ViewPayConfirmationAddOnBinding getAuthRequestContext(View view) {
        int i = R.id.appCompatTextView4;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.appCompatTextView4);
        if (appCompatTextView != null) {
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rvAddOnCashier);
            if (recyclerView != null) {
                return new ViewPayConfirmationAddOnBinding((ConstraintLayout) view, appCompatTextView, recyclerView);
            }
            i = R.id.rvAddOnCashier;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
