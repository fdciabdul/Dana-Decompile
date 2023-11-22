package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.CashierAddOnModalTooltipEntityRequest;
import id.dana.cashier.domain.model.CashierAddOnModalTooltipRequest;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipRequestMapper;", "", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltipRequest;", "oldItem", "Lid/dana/cashier/data/repository/source/network/request/CashierAddOnModalTooltipEntityRequest;", "map", "(Lid/dana/cashier/domain/model/CashierAddOnModalTooltipRequest;)Lid/dana/cashier/data/repository/source/network/request/CashierAddOnModalTooltipEntityRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnModalTooltipRequestMapper {
    @Inject
    public CashierAddOnModalTooltipRequestMapper() {
    }

    public final CashierAddOnModalTooltipEntityRequest map(CashierAddOnModalTooltipRequest oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return new CashierAddOnModalTooltipEntityRequest(oldItem.getGoodsId(), oldItem.getGoodsType(), oldItem.getCategory(), oldItem.getStackInsurance());
    }
}
