package id.dana.mybills.mapper;

import id.dana.domain.mybills.model.BizProductOrder;
import id.dana.mybills.model.BizProductOrderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/mybills/model/BizProductOrder;", "Lid/dana/mybills/model/BizProductOrderModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/mybills/model/BizProductOrder;)Lid/dana/mybills/model/BizProductOrderModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizProductOrderModelMapperKt {
    public static final BizProductOrderModel KClassImpl$Data$declaredNonStaticMembers$2(BizProductOrder bizProductOrder) {
        Intrinsics.checkNotNullParameter(bizProductOrder, "");
        return new BizProductOrderModel(bizProductOrder.getCheckoutUrl(), bizProductOrder.getOrderId(), bizProductOrder.getAcquirementId());
    }
}
