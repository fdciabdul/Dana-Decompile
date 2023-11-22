package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class LayoutGeneralEmptyStateBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;

    private LayoutGeneralEmptyStateBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
    }

    public static LayoutGeneralEmptyStateBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.f3450PrepareContext_res_0x7f0a011e;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3450PrepareContext_res_0x7f0a011e);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivEmptyState);
            if (appCompatImageView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4265res_0x7f0a144d_multimapbuilder_hashsetsupplier);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4267tvEmptyStateTitle);
                    if (appCompatTextView2 != null) {
                        return new LayoutGeneralEmptyStateBinding(constraintLayout, danaButtonPrimaryView, constraintLayout, appCompatImageView, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.f4267tvEmptyStateTitle;
                } else {
                    i = R.id.f4265res_0x7f0a144d_multimapbuilder_hashsetsupplier;
                }
            } else {
                i = R.id.ivEmptyState;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
