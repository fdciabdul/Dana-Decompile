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
public final class ViewMyBillsHeaderSectionErrorBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewMyBillsHeaderSectionErrorBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ImageView imageView, TextView textView, TextView textView2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = imageView;
        this.getAuthRequestContext = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ViewMyBillsHeaderSectionErrorBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_header_my_bills_retry;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_header_my_bills_retry);
        if (danaButtonPrimaryView != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_mybills_network_problem);
            if (imageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_my_bills_network_title);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_my_bills_network_title_description);
                    if (textView2 != null) {
                        return new ViewMyBillsHeaderSectionErrorBinding((ConstraintLayout) view, danaButtonPrimaryView, imageView, textView, textView2);
                    }
                    i = R.id.tv_my_bills_network_title_description;
                } else {
                    i = R.id.tv_my_bills_network_title;
                }
            } else {
                i = R.id.iv_mybills_network_problem;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
