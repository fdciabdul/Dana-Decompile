package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.BankAccountNumberView;

/* loaded from: classes4.dex */
public final class ItemBankAccountBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    private final LinearLayout MyBillsEntityDataFactory;
    public final BankAccountNumberView getAuthRequestContext;

    private ItemBankAccountBinding(LinearLayout linearLayout, BankAccountNumberView bankAccountNumberView, LinearLayout linearLayout2) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.getAuthRequestContext = bankAccountNumberView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout2;
    }

    public static ItemBankAccountBinding getAuthRequestContext(View view) {
        BankAccountNumberView bankAccountNumberView = (BankAccountNumberView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.bankAccountNumberView);
        if (bankAccountNumberView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new ItemBankAccountBinding(linearLayout, bankAccountNumberView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.bankAccountNumberView)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
