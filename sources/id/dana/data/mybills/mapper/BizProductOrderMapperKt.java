package id.dana.data.mybills.mapper;

import id.dana.data.mybills.model.request.CreateOrderRequest;
import id.dana.data.mybills.model.result.CreateOrderResult;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.mybills.model.BizProductOrder;
import id.dana.domain.mybills.model.BizProductOrderRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/mybills/model/result/CreateOrderResult;", "Lid/dana/domain/mybills/model/BizProductOrder;", "MyBillsEntityDataFactory", "(Lid/dana/data/mybills/model/result/CreateOrderResult;)Lid/dana/domain/mybills/model/BizProductOrder;", "Lid/dana/domain/mybills/model/BizProductOrderRequest;", "Lid/dana/data/mybills/model/request/CreateOrderRequest;", "PlaceComponentResult", "(Lid/dana/domain/mybills/model/BizProductOrderRequest;)Lid/dana/data/mybills/model/request/CreateOrderRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BizProductOrderMapperKt {
    public static final CreateOrderRequest PlaceComponentResult(BizProductOrderRequest bizProductOrderRequest) {
        Intrinsics.checkNotNullParameter(bizProductOrderRequest, "");
        return new CreateOrderRequest(bizProductOrderRequest.getProductCode(), bizProductOrderRequest.getGoodsId(), bizProductOrderRequest.getRequestId(), bizProductOrderRequest.getParam(), MoneyViewEntityMapperKt.toMoneyViewEntity(bizProductOrderRequest.getAmount()));
    }

    public static final BizProductOrder MyBillsEntityDataFactory(CreateOrderResult createOrderResult) {
        Intrinsics.checkNotNullParameter(createOrderResult, "");
        return new BizProductOrder(createOrderResult.getCheckoutUrl(), createOrderResult.getOrderId(), createOrderResult.getAcquirementId());
    }
}
