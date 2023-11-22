package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemTopUpAndPayBankCardBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;

    private ItemTopUpAndPayBankCardBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.getAuthRequestContext = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.PlaceComponentResult = appCompatTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView2;
    }

    public static ItemTopUpAndPayBankCardBinding PlaceComponentResult(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivIconAsset;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIconAsset);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.NavGraphBuilder);
            if (appCompatImageView2 != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAccountNumber);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAccountSource);
                    if (appCompatTextView2 != null) {
                        return new ItemTopUpAndPayBankCardBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.tvAccountSource;
                } else {
                    i = R.id.tvAccountNumber;
                }
            } else {
                i = R.id.NavGraphBuilder;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
