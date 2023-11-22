package id.dana.mybills.ui.mapper;

import id.dana.mybills.domain.model.BizProductOrder;
import id.dana.mybills.ui.model.BizProductOrderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/domain/model/BizProductOrder;", "Lid/dana/mybills/ui/model/BizProductOrderModel;", "getAuthRequestContext", "(Lid/dana/mybills/domain/model/BizProductOrder;)Lid/dana/mybills/ui/model/BizProductOrderModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BizProductOrderModelMapperKt {
    public static final BizProductOrderModel getAuthRequestContext(BizProductOrder bizProductOrder) {
        Intrinsics.checkNotNullParameter(bizProductOrder, "");
        return new BizProductOrderModel(bizProductOrder.getCheckoutUrl(), bizProductOrder.getOrderId(), bizProductOrder.getAcquirementId());
    }
}
