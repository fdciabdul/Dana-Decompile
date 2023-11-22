package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes8.dex */
public final class ItemPaylaterCicilOnboardingBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView getAuthRequestContext;

    private ItemPaylaterCicilOnboardingBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatTextView;
    }

    public static ItemPaylaterCicilOnboardingBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.iv_onboarding_benefit;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_onboarding_benefit);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_onboarding_benefit_desc);
            if (appCompatTextView != null) {
                return new ItemPaylaterCicilOnboardingBinding((ConstraintLayout) view, appCompatImageView, appCompatTextView);
            }
            i = R.id.tv_onboarding_benefit_desc;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
