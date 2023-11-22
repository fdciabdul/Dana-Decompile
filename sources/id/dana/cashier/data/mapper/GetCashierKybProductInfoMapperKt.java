package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.GetCashierKybProductEntityRequest;
import id.dana.cashier.data.repository.source.network.result.CashierKybOrderDetailResult;
import id.dana.cashier.data.repository.source.network.result.CashierKybOrderDetailResultKt;
import id.dana.cashier.data.repository.source.network.result.CashierKybProductInfoResult;
import id.dana.cashier.domain.model.CashierKybProductInfo;
import id.dana.cashier.domain.model.GetCashierKybProductRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierKybProductInfoResult;", "Lid/dana/cashier/domain/model/CashierKybProductInfo;", "toCashierKybProductInfo", "(Lid/dana/cashier/data/repository/source/network/result/CashierKybProductInfoResult;)Lid/dana/cashier/domain/model/CashierKybProductInfo;", "Lid/dana/cashier/domain/model/GetCashierKybProductRequest;", "Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;", "toGetCashierKybProductEntityRequest", "(Lid/dana/cashier/domain/model/GetCashierKybProductRequest;)Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCashierKybProductInfoMapperKt {
    public static final GetCashierKybProductEntityRequest toGetCashierKybProductEntityRequest(GetCashierKybProductRequest getCashierKybProductRequest) {
        Intrinsics.checkNotNullParameter(getCashierKybProductRequest, "");
        return new GetCashierKybProductEntityRequest(getCashierKybProductRequest.getOrderId());
    }

    public static final CashierKybProductInfo toCashierKybProductInfo(CashierKybProductInfoResult cashierKybProductInfoResult) {
        Intrinsics.checkNotNullParameter(cashierKybProductInfoResult, "");
        String bizType = cashierKybProductInfoResult.getBizType();
        String logoUrl = cashierKybProductInfoResult.getLogoUrl();
        String merchantAddress = cashierKybProductInfoResult.getMerchantAddress();
        String merchantName = cashierKybProductInfoResult.getMerchantName();
        CashierKybOrderDetailResult orderDetail = cashierKybProductInfoResult.getOrderDetail();
        return new CashierKybProductInfo(bizType, logoUrl, merchantAddress, merchantName, orderDetail != null ? CashierKybOrderDetailResultKt.toCashierKybOrderDetail(orderDetail) : null);
    }
}
