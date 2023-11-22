package id.dana.cashier.data.repository.source.network.request;

import id.dana.cashier.domain.model.TopUpVerifyRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/TopUpVerifyRequest;", "Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;", "toTopUpVerifyEntityRequest", "(Lid/dana/cashier/domain/model/TopUpVerifyRequest;)Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpVerifyEntityRequestKt {
    public static final TopUpVerifyEntityRequest toTopUpVerifyEntityRequest(TopUpVerifyRequest topUpVerifyRequest) {
        Intrinsics.checkNotNullParameter(topUpVerifyRequest, "");
        return new TopUpVerifyEntityRequest(topUpVerifyRequest.getMethod(), topUpVerifyRequest.getPayMethod(), topUpVerifyRequest.getPayOption(), topUpVerifyRequest.getCardCacheToken(), topUpVerifyRequest.getVerificationMethod(), topUpVerifyRequest.getValidateData(), topUpVerifyRequest.getRequestId(), topUpVerifyRequest.getCashierOrderId(), topUpVerifyRequest.getInnerCardIndexNo(), topUpVerifyRequest.getTopUpOrderId(), topUpVerifyRequest.getSecurityId());
    }
}
