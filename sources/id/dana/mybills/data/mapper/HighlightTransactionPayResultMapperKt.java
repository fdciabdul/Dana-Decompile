package id.dana.mybills.data.mapper;

import id.dana.mybills.data.model.response.HighlightTransactionPayResult;
import id.dana.mybills.domain.model.HighlightTransactionPay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;", "Lid/dana/mybills/domain/model/HighlightTransactionPay;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;)Lid/dana/mybills/domain/model/HighlightTransactionPay;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightTransactionPayResultMapperKt {
    public static final HighlightTransactionPay MyBillsEntityDataFactory(HighlightTransactionPayResult highlightTransactionPayResult) {
        Intrinsics.checkNotNullParameter(highlightTransactionPayResult, "");
        return new HighlightTransactionPay(highlightTransactionPayResult.getSubscriptionId(), highlightTransactionPayResult.getTransactionId(), highlightTransactionPayResult.getCheckoutUrl(), highlightTransactionPayResult.getLocation(), highlightTransactionPayResult.errorMessage, highlightTransactionPayResult.success);
    }
}
