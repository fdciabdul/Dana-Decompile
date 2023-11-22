package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemGroupRecipientSectionBinding implements ViewBinding {
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final View getAuthRequestContext;

    private ItemGroupRecipientSectionBinding(ConstraintLayout constraintLayout, TextView textView, View view) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.getAuthRequestContext = view;
    }

    public static ItemGroupRecipientSectionBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.item_group_recipient_section, viewGroup, false);
        int i = R.id.res_0x7f0a1720_nearbysearchpresenter_getnearbytrendingkeyword_1;
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.MatrixEvaluator))) != null) {
            return new ItemGroupRecipientSectionBinding((ConstraintLayout) inflate, textView, BuiltInFictitiousFunctionClassFactory);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
