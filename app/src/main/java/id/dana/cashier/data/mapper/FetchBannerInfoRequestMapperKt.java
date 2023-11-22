package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.CashierBannerEntityRequest;
import id.dana.cashier.data.repository.source.network.request.FetchBannerEntityRequest;
import id.dana.cashier.domain.model.FetchBannerRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/FetchBannerRequest;", "Lid/dana/cashier/data/repository/source/network/request/CashierBannerEntityRequest;", "toCashierBannerEntityRequest", "(Lid/dana/cashier/domain/model/FetchBannerRequest;)Lid/dana/cashier/data/repository/source/network/request/CashierBannerEntityRequest;", "Lid/dana/cashier/data/repository/source/network/request/FetchBannerEntityRequest;", "toFetchBannerEntityRequest", "(Lid/dana/cashier/domain/model/FetchBannerRequest;)Lid/dana/cashier/data/repository/source/network/request/FetchBannerEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchBannerInfoRequestMapperKt {
    public static final FetchBannerEntityRequest toFetchBannerEntityRequest(FetchBannerRequest fetchBannerRequest) {
        Intrinsics.checkNotNullParameter(fetchBannerRequest, "");
        return new FetchBannerEntityRequest(fetchBannerRequest.getCashierOrderId());
    }

    public static final CashierBannerEntityRequest toCashierBannerEntityRequest(FetchBannerRequest fetchBannerRequest) {
        Intrinsics.checkNotNullParameter(fetchBannerRequest, "");
        return new CashierBannerEntityRequest(fetchBannerRequest.getBizType(), fetchBannerRequest.getPlatform(), fetchBannerRequest.getOrderAmount(), fetchBannerRequest.getMerchantId(), fetchBannerRequest.getPaymentMethod(), fetchBannerRequest.getTransType(), fetchBannerRequest.getCashierOrderId());
    }
}
