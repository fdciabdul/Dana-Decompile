package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewTooltipTwoButtonWithImageBinding implements ViewBinding {
    public final Button BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Button PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;

    private ViewTooltipTwoButtonWithImageBinding(ConstraintLayout constraintLayout, Button button, Button button2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = button;
        this.PlaceComponentResult = button2;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
    }

    public static ViewTooltipTwoButtonWithImageBinding getAuthRequestContext(View view) {
        int i = R.id.btn_tooltip_negative;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_tooltip_negative);
        if (button != null) {
            Button button2 = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_tooltip_positive);
            if (button2 != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_tooltip_image);
                if (appCompatImageView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_tooltip_description);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_tooltip_title);
                        if (appCompatTextView2 != null) {
                            return new ViewTooltipTwoButtonWithImageBinding((ConstraintLayout) view, button, button2, appCompatImageView, appCompatTextView, appCompatTextView2);
                        }
                        i = R.id.tv_tooltip_title;
                    } else {
                        i = R.id.tv_tooltip_description;
                    }
                } else {
                    i = R.id.iv_tooltip_image;
                }
            } else {
                i = R.id.btn_tooltip_positive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
