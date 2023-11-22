package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ActivityReferralLocationErrorPageBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ActivityReferralLocationErrorPageBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ImageView imageView, TextView textView, TextView textView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = textView2;
    }

    public static ActivityReferralLocationErrorPageBinding PlaceComponentResult(View view) {
        int i = R.id.btn_try_again_general_error;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_try_again_general_error);
        if (danaButtonPrimaryView != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_general_error_image);
            if (imageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_general_error_detail);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_general_error_more_detail);
                    if (textView2 != null) {
                        return new ActivityReferralLocationErrorPageBinding((ConstraintLayout) view, danaButtonPrimaryView, imageView, textView, textView2);
                    }
                    i = R.id.tv_general_error_more_detail;
                } else {
                    i = R.id.tv_general_error_detail;
                }
            } else {
                i = R.id.iv_general_error_image;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
