package id.dana.richview;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.boundcard.BoundCardView;
import id.dana.richview.boundcard.DanaBalanceCardView;
import id.dana.richview.boundcard.DebitCardView;

/* loaded from: classes9.dex */
public class PaymentCardsView_ViewBinding implements Unbinder {
    private PaymentCardsView KClassImpl$Data$declaredNonStaticMembers$2;

    public PaymentCardsView_ViewBinding(PaymentCardsView paymentCardsView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = paymentCardsView;
        paymentCardsView.bcvPaymentMethod = (BoundCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.bcv_cards, "field 'bcvPaymentMethod'", BoundCardView.class);
        paymentCardsView.dbvCard = (DanaBalanceCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dbv_card, "field 'dbvCard'", DanaBalanceCardView.class);
        paymentCardsView.dcvDebit = (DebitCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dcv_debit, "field 'dcvDebit'", DebitCardView.class);
        paymentCardsView.llSingleCard = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_single_card, "field 'llSingleCard'", LinearLayout.class);
        paymentCardsView.clMainParent = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_main_parent, "field 'clMainParent'", ConstraintLayout.class);
        paymentCardsView.clHighlightedCardSwapper = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_highlighted_card_swapper, "field 'clHighlightedCardSwapper'", ConstraintLayout.class);
        paymentCardsView.clChoosenCardSwapper = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_choosen_card_swapper, "field 'clChoosenCardSwapper'", ConstraintLayout.class);
        paymentCardsView.dbvHighlightedCardSwapper = (DanaBalanceCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dbv_highlighted_card_swapper, "field 'dbvHighlightedCardSwapper'", DanaBalanceCardView.class);
        paymentCardsView.dcvHighlightedCardSwapper = (DebitCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dcv_highlighted_card_swapper, "field 'dcvHighlightedCardSwapper'", DebitCardView.class);
        paymentCardsView.dbvChoosenCardSwapper = (DanaBalanceCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dbv_choosen_card_swapper, "field 'dbvChoosenCardSwapper'", DanaBalanceCardView.class);
        paymentCardsView.dcvChoosenCardSwapper = (DebitCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dcv_choosen_card_swapper, "field 'dcvChoosenCardSwapper'", DebitCardView.class);
        paymentCardsView.viewDummy = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_dummy, "field 'viewDummy'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PaymentCardsView paymentCardsView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (paymentCardsView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        paymentCardsView.bcvPaymentMethod = null;
        paymentCardsView.dbvCard = null;
        paymentCardsView.dcvDebit = null;
        paymentCardsView.llSingleCard = null;
        paymentCardsView.clMainParent = null;
        paymentCardsView.clHighlightedCardSwapper = null;
        paymentCardsView.clChoosenCardSwapper = null;
        paymentCardsView.dbvHighlightedCardSwapper = null;
        paymentCardsView.dcvHighlightedCardSwapper = null;
        paymentCardsView.dbvChoosenCardSwapper = null;
        paymentCardsView.dcvChoosenCardSwapper = null;
        paymentCardsView.viewDummy = null;
    }
}
