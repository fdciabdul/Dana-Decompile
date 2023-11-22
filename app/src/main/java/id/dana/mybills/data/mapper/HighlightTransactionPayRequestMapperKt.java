package id.dana.mybills.data.mapper;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.data.model.request.HighlightTransactionPayRequestEntity;
import id.dana.mybills.domain.model.HighlightTransactionPayRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;", "Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;", "getAuthRequestContext", "(Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;)Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;", "Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "PlaceComponentResult", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/network/response/expresspurchase/MoneyViewEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightTransactionPayRequestMapperKt {
    public static final HighlightTransactionPayRequestEntity getAuthRequestContext(HighlightTransactionPayRequest highlightTransactionPayRequest) {
        Intrinsics.checkNotNullParameter(highlightTransactionPayRequest, "");
        return new HighlightTransactionPayRequestEntity(highlightTransactionPayRequest.getSubscriptionId(), PlaceComponentResult(highlightTransactionPayRequest.getTransactionAmount()), highlightTransactionPayRequest.getPayMode(), PlaceComponentResult(highlightTransactionPayRequest.getAdminFee()), PlaceComponentResult(highlightTransactionPayRequest.getBaseAmount()));
    }

    private static final MoneyViewEntity PlaceComponentResult(MoneyView moneyView) {
        if (moneyView == null) {
            return new MoneyViewEntity("0", "Rp", null, 4, null);
        }
        return new MoneyViewEntity(moneyView.getAmount(), moneyView.getCurrency(), moneyView.getCurrencyCode());
    }
}
