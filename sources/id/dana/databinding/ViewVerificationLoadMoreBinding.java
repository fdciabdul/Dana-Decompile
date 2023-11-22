package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewVerificationLoadMoreBinding implements ViewBinding {
    public final AppCompatImageView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ViewVerificationLoadMoreBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = appCompatImageView;
    }

    public static ViewVerificationLoadMoreBinding MyBillsEntityDataFactory(View view) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivLoading);
        if (appCompatImageView != null) {
            return new ViewVerificationLoadMoreBinding((ConstraintLayout) view, appCompatImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.ivLoading)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
