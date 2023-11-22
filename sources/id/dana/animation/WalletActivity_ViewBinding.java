package id.dana.animation;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.PaymentCardsView;

/* loaded from: classes8.dex */
public class WalletActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private WalletActivity MyBillsEntityDataFactory;

    public WalletActivity_ViewBinding(final WalletActivity walletActivity, View view) {
        this.MyBillsEntityDataFactory = walletActivity;
        walletActivity.clListCard = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_list_card, "field 'clListCard'", ConstraintLayout.class);
        walletActivity.pcvCards = (PaymentCardsView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pcv_cards, "field 'pcvCards'", PaymentCardsView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_close_click_area, "method 'closeActivity'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.home.WalletActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                walletActivity.closeActivity();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        WalletActivity walletActivity = this.MyBillsEntityDataFactory;
        if (walletActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        walletActivity.clListCard = null;
        walletActivity.pcvCards = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
