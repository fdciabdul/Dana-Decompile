package id.dana.mybills.domain.model;

import id.dana.mybills.ui.model.HighlighTransactionPayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/domain/model/HighlightTransactionPay;", "Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "toHighlighTransactionPayModel", "(Lid/dana/mybills/domain/model/HighlightTransactionPay;)Lid/dana/mybills/ui/model/HighlighTransactionPayModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class HighlightTransactionPayKt {
    public static final HighlighTransactionPayModel toHighlighTransactionPayModel(HighlightTransactionPay highlightTransactionPay) {
        Intrinsics.checkNotNullParameter(highlightTransactionPay, "");
        return new HighlighTransactionPayModel(highlightTransactionPay.getSubscriptionId(), highlightTransactionPay.getTransactionId(), highlightTransactionPay.getCheckoutUrl(), highlightTransactionPay.getLocation(), highlightTransactionPay.getErrorMessage(), highlightTransactionPay.getSuccess());
    }
}
