package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.CreateOrderEntityRequest;
import id.dana.cashier.domain.model.CreateOrderRequest;
import id.dana.data.base.BaseMapper;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/mapper/CreateOrderInfoRequestMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/domain/model/CreateOrderRequest;", "Lid/dana/cashier/data/repository/source/network/request/CreateOrderEntityRequest;", "oldItem", "map", "(Lid/dana/cashier/domain/model/CreateOrderRequest;)Lid/dana/cashier/data/repository/source/network/request/CreateOrderEntityRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreateOrderInfoRequestMapper extends BaseMapper<CreateOrderRequest, CreateOrderEntityRequest> {
    @Inject
    public CreateOrderInfoRequestMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final CreateOrderEntityRequest map(CreateOrderRequest oldItem) {
        if (oldItem != null) {
            return new CreateOrderEntityRequest(oldItem.getQrCode(), oldItem.getAmount(), oldItem.getRequestId(), oldItem.getMerchantId(), oldItem.getTip(), oldItem.getBizType(), oldItem.getCacheKey(), oldItem.getCountryCode(), oldItem.getFirstTime(), oldItem.getUserName(), oldItem.getPrecreateOrder(), oldItem.getCrossBorder(), oldItem.getMerchantCity(), oldItem.getPostalCode());
        }
        return null;
    }
}
