package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemSendNewAccountNumberSmartFrictionBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ItemSendNewAccountNumberSmartFrictionBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = imageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.getAuthRequestContext = textView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView3;
    }

    public static ItemSendNewAccountNumberSmartFrictionBinding PlaceComponentResult(View view) {
        int i = R.id.avatar;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.avatar);
        if (imageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_account_number);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_add_number_msg);
                if (textView2 != null) {
                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNewBadge);
                    if (textView3 != null) {
                        return new ItemSendNewAccountNumberSmartFrictionBinding((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                    i = R.id.tvNewBadge;
                } else {
                    i = R.id.tv_add_number_msg;
                }
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
