package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class LayoutPushVerifyErrorBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;

    private LayoutPushVerifyErrorBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, View view, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = textView;
        this.MyBillsEntityDataFactory = textView2;
    }

    public static LayoutPushVerifyErrorBinding getAuthRequestContext(View view) {
        int i = R.id.btnPositive;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnPositive);
        if (danaButtonPrimaryView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.dividerLine);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivPushVerifyError);
                if (appCompatImageView != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPushVerifyErrorSubTitle);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPushVerifyErrorTitle);
                        if (textView2 != null) {
                            return new LayoutPushVerifyErrorBinding((ConstraintLayout) view, danaButtonPrimaryView, BuiltInFictitiousFunctionClassFactory, appCompatImageView, textView, textView2);
                        }
                        i = R.id.tvPushVerifyErrorTitle;
                    } else {
                        i = R.id.tvPushVerifyErrorSubTitle;
                    }
                } else {
                    i = R.id.ivPushVerifyError;
                }
            } else {
                i = R.id.dividerLine;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
