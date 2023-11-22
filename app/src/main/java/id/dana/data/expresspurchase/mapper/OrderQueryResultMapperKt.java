package id.dana.data.expresspurchase.mapper;

import id.dana.data.expresspurchase.source.network.pojo.response.OrderQueryByConditionResponse;
import id.dana.domain.expresspurchase.interaction.model.OrderQueryResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/OrderQueryByConditionResponse;", "Lid/dana/domain/expresspurchase/interaction/model/OrderQueryResult;", "toOrderQueryResult", "(Lid/dana/data/expresspurchase/source/network/pojo/response/OrderQueryByConditionResponse;)Lid/dana/domain/expresspurchase/interaction/model/OrderQueryResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OrderQueryResultMapperKt {
    public static final OrderQueryResult toOrderQueryResult(OrderQueryByConditionResponse orderQueryByConditionResponse) {
        Intrinsics.checkNotNullParameter(orderQueryByConditionResponse, "");
        return new OrderQueryResult(orderQueryByConditionResponse.getClientId(), orderQueryByConditionResponse.getAcquirementId(), orderQueryByConditionResponse.getMerchantId(), orderQueryByConditionResponse.getMerchantTransId(), orderQueryByConditionResponse.getProductCode(), orderQueryByConditionResponse.getBizFinished());
    }
}
