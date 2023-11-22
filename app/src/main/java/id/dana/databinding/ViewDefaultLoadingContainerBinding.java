package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewDefaultLoadingContainerBinding implements ViewBinding {
    public final View BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout getAuthRequestContext;

    private ViewDefaultLoadingContainerBinding(ConstraintLayout constraintLayout, View view) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    public static ViewDefaultLoadingContainerBinding MyBillsEntityDataFactory(View view) {
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4599view_shimmer);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new ViewDefaultLoadingContainerBinding((ConstraintLayout) view, BuiltInFictitiousFunctionClassFactory);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f4599view_shimmer)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
