package id.dana.cashier.data.repository.source.network.request;

import id.dana.cashier.domain.model.CashierUpdateOrderRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "Lid/dana/cashier/data/repository/source/network/request/CashierUpdateOrderEntityRequest;", "toCashierUpdateOrderEntityRequest", "(Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;)Lid/dana/cashier/data/repository/source/network/request/CashierUpdateOrderEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierUpdateOrderEntityRequestKt {
    public static final CashierUpdateOrderEntityRequest toCashierUpdateOrderEntityRequest(CashierUpdateOrderRequest cashierUpdateOrderRequest) {
        Intrinsics.checkNotNullParameter(cashierUpdateOrderRequest, "");
        return new CashierUpdateOrderEntityRequest(cashierUpdateOrderRequest.getCashierOrderId(), cashierUpdateOrderRequest.getSelectedAddons(), cashierUpdateOrderRequest.getTransType());
    }
}
