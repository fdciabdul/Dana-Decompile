package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.component.formcomponent.DanaCheckboxButtonView;

/* loaded from: classes4.dex */
public final class ItemListCheckHistoryTransactionBinding implements ViewBinding {
    private final DanaCheckboxButtonView BuiltInFictitiousFunctionClassFactory;
    public final DanaCheckboxButtonView KClassImpl$Data$declaredNonStaticMembers$2;

    private ItemListCheckHistoryTransactionBinding(DanaCheckboxButtonView danaCheckboxButtonView, DanaCheckboxButtonView danaCheckboxButtonView2) {
        this.BuiltInFictitiousFunctionClassFactory = danaCheckboxButtonView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaCheckboxButtonView2;
    }

    public static ItemListCheckHistoryTransactionBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_list_check_history_transaction, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        DanaCheckboxButtonView danaCheckboxButtonView = (DanaCheckboxButtonView) inflate;
        return new ItemListCheckHistoryTransactionBinding(danaCheckboxButtonView, danaCheckboxButtonView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
