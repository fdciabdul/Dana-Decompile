package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.BankAccountNumberBoxView;

/* loaded from: classes4.dex */
public final class ItemBankAccountNumberBoxBinding implements ViewBinding {
    public final BankAccountNumberBoxView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    private final LinearLayout PlaceComponentResult;

    private ItemBankAccountNumberBoxBinding(LinearLayout linearLayout, BankAccountNumberBoxView bankAccountNumberBoxView, LinearLayout linearLayout2) {
        this.PlaceComponentResult = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = bankAccountNumberBoxView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout2;
    }

    public static ItemBankAccountNumberBoxBinding MyBillsEntityDataFactory(View view) {
        BankAccountNumberBoxView bankAccountNumberBoxView = (BankAccountNumberBoxView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.bankAccountNumberView);
        if (bankAccountNumberBoxView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new ItemBankAccountNumberBoxBinding(linearLayout, bankAccountNumberBoxView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.bankAccountNumberView)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
