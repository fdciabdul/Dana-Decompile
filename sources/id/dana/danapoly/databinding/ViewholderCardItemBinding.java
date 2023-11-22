package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;
import id.dana.danapoly.ui.cards.view.CardItemView;

/* loaded from: classes4.dex */
public final class ViewholderCardItemBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final CardItemView KClassImpl$Data$declaredNonStaticMembers$2;

    private ViewholderCardItemBinding(ConstraintLayout constraintLayout, CardItemView cardItemView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardItemView;
    }

    public static ViewholderCardItemBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.viewholder_card_item, viewGroup, false);
        int i = R.id.cardItemView;
        CardItemView cardItemView = (CardItemView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (cardItemView != null) {
            return new ViewholderCardItemBinding((ConstraintLayout) inflate, cardItemView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
