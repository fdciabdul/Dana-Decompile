package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemSendNewAccountNumberBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ItemSendNewAccountNumberBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.PlaceComponentResult = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = textView2;
    }

    public static ItemSendNewAccountNumberBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.avatar;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.avatar);
        if (imageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_account_number);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_add_number_msg);
                if (textView2 != null) {
                    return new ItemSendNewAccountNumberBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
                i = R.id.tv_add_number_msg;
            } else {
                i = R.id.tv_account_number;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
