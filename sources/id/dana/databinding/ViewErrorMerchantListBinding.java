package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewErrorMerchantListBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final ImageView getAuthRequestContext;

    private ViewErrorMerchantListBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ImageView imageView, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.getAuthRequestContext = imageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ViewErrorMerchantListBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_error_merchant_list, (ViewGroup) null, false);
        int i = R.id.dbpvTryAgain;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.dbpvTryAgain);
        if (danaButtonPrimaryView != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_error_merchant_list);
            if (imageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_error_merchant_list_desc);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_error_merchant_list_title);
                    if (textView2 != null) {
                        return new ViewErrorMerchantListBinding((ConstraintLayout) inflate, danaButtonPrimaryView, imageView, textView, textView2);
                    }
                    i = R.id.tv_error_merchant_list_title;
                } else {
                    i = R.id.tv_error_merchant_list_desc;
                }
            } else {
                i = R.id.iv_error_merchant_list;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
