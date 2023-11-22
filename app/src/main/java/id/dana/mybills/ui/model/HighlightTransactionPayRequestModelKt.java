package id.dana.mybills.ui.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.domain.model.HighlightTransactionPayRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;", "toHighlightTransactionPayRequest", "(Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;)Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HighlightTransactionPayRequestModelKt {
    public static final HighlightTransactionPayRequest toHighlightTransactionPayRequest(HighlightTransactionPayRequestModel highlightTransactionPayRequestModel) {
        MoneyView moneyView;
        MoneyView moneyView2;
        Intrinsics.checkNotNullParameter(highlightTransactionPayRequestModel, "");
        String subscriptionId = highlightTransactionPayRequestModel.getSubscriptionId();
        MoneyViewModel transactionAmount = highlightTransactionPayRequestModel.getTransactionAmount();
        MoneyView moneyView3 = transactionAmount != null ? SaveSubscriptionRequestModelKt.toMoneyView(transactionAmount) : null;
        String payMode = highlightTransactionPayRequestModel.getPayMode();
        MoneyViewModel adminFee = highlightTransactionPayRequestModel.getAdminFee();
        MoneyView moneyView4 = (adminFee == null || (moneyView2 = SaveSubscriptionRequestModelKt.toMoneyView(adminFee)) == null) ? new MoneyView("0", "Rp", null, 4, null) : moneyView2;
        MoneyViewModel baseAmount = highlightTransactionPayRequestModel.getBaseAmount();
        return new HighlightTransactionPayRequest(subscriptionId, moneyView3, payMode, moneyView4, (baseAmount == null || (moneyView = SaveSubscriptionRequestModelKt.toMoneyView(baseAmount)) == null) ? new MoneyView("0", "Rp", null, 4, null) : moneyView);
    }
}
