package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemTopBankListBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final CardView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final CardView PlaceComponentResult;
    public final ImageView getAuthRequestContext;

    private ItemTopBankListBinding(CardView cardView, ConstraintLayout constraintLayout, CardView cardView2, ImageView imageView, TextView textView) {
        this.PlaceComponentResult = cardView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardView2;
        this.getAuthRequestContext = imageView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ItemTopBankListBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_top_bank_list, viewGroup, false);
        int i = R.id.cl_top_bank_item;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_top_bank_item);
        if (constraintLayout != null) {
            CardView cardView = (CardView) inflate;
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_bank_logo);
            if (imageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_bank_name);
                if (textView != null) {
                    return new ItemTopBankListBinding(cardView, constraintLayout, cardView, imageView, textView);
                }
                i = R.id.tv_bank_name;
            } else {
                i = R.id.iv_bank_logo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
