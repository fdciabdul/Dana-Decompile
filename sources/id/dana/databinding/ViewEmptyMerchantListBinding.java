package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewEmptyMerchantListBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;

    private ViewEmptyMerchantListBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = imageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView2;
    }

    public static ViewEmptyMerchantListBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.iv_empty_merchant_list;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_empty_merchant_list);
        if (imageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_empty_merchant_list_desc);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_empty_merchant_list_title);
                if (textView2 != null) {
                    return new ViewEmptyMerchantListBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
                i = R.id.tv_empty_merchant_list_title;
            } else {
                i = R.id.tv_empty_merchant_list_desc;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
