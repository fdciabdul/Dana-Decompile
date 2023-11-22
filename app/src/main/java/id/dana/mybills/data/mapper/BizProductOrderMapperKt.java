package id.dana.mybills.data.mapper;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.mybills.data.model.request.CreateOrderRequest;
import id.dana.mybills.data.model.response.CreateOrderResult;
import id.dana.mybills.domain.model.BizProductOrder;
import id.dana.mybills.domain.model.BizProductOrderRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/data/model/response/CreateOrderResult;", "Lid/dana/mybills/domain/model/BizProductOrder;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/data/model/response/CreateOrderResult;)Lid/dana/mybills/domain/model/BizProductOrder;", "Lid/dana/mybills/domain/model/BizProductOrderRequest;", "Lid/dana/mybills/data/model/request/CreateOrderRequest;", "PlaceComponentResult", "(Lid/dana/mybills/domain/model/BizProductOrderRequest;)Lid/dana/mybills/data/model/request/CreateOrderRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizProductOrderMapperKt {
    public static final CreateOrderRequest PlaceComponentResult(BizProductOrderRequest bizProductOrderRequest) {
        Intrinsics.checkNotNullParameter(bizProductOrderRequest, "");
        return new CreateOrderRequest(bizProductOrderRequest.getProductCode(), bizProductOrderRequest.getGoodsId(), bizProductOrderRequest.getRequestId(), bizProductOrderRequest.getParam(), MoneyViewEntityMapperKt.toMoneyViewEntity(bizProductOrderRequest.getAmount()));
    }

    public static final BizProductOrder KClassImpl$Data$declaredNonStaticMembers$2(CreateOrderResult createOrderResult) {
        Intrinsics.checkNotNullParameter(createOrderResult, "");
        return new BizProductOrder(createOrderResult.getCheckoutUrl(), createOrderResult.getOrderId(), createOrderResult.getAcquirementId());
    }
}
