package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.wallet_v3.view.walletcardview.BankWalletV3CardView;

/* loaded from: classes4.dex */
public final class WalletBankCardViewHolderBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final BankWalletV3CardView PlaceComponentResult;
    private final FrameLayout getAuthRequestContext;

    private WalletBankCardViewHolderBinding(FrameLayout frameLayout, FrameLayout frameLayout2, BankWalletV3CardView bankWalletV3CardView) {
        this.getAuthRequestContext = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout2;
        this.PlaceComponentResult = bankWalletV3CardView;
    }

    public static WalletBankCardViewHolderBinding BuiltInFictitiousFunctionClassFactory(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        BankWalletV3CardView bankWalletV3CardView = (BankWalletV3CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.item_bank_card);
        if (bankWalletV3CardView != null) {
            return new WalletBankCardViewHolderBinding(frameLayout, frameLayout, bankWalletV3CardView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.item_bank_card)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
