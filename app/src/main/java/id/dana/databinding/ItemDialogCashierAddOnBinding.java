package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemDialogCashierAddOnBinding implements ViewBinding {
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final CircleImageView getAuthRequestContext;

    private ItemDialogCashierAddOnBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = circleImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
    }

    public static ItemDialogCashierAddOnBinding getAuthRequestContext(View view) {
        int i = R.id.ivBenefit;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivBenefit);
        if (circleImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvBenefitInfo);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvBenefitTitle);
                if (appCompatTextView2 != null) {
                    return new ItemDialogCashierAddOnBinding((ConstraintLayout) view, circleImageView, appCompatTextView, appCompatTextView2);
                }
                i = R.id.tvBenefitTitle;
            } else {
                i = R.id.tvBenefitInfo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
