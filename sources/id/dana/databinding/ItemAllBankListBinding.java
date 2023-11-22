package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemAllBankListBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;

    private ItemAllBankListBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.getAuthRequestContext = imageView;
        this.PlaceComponentResult = linearLayout2;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ItemAllBankListBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_all_bank_list, viewGroup, false);
        int i = R.id.iv_bank_logo;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_bank_logo);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) inflate;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_bank_name);
            if (textView != null) {
                return new ItemAllBankListBinding(linearLayout, imageView, linearLayout, textView);
            }
            i = R.id.tv_bank_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
