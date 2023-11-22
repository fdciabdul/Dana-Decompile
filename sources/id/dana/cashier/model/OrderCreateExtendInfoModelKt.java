package id.dana.cashier.model;

import id.dana.cashier.domain.model.OrderCreateExtendInfo;
import id.dana.cashier.domain.model.TncUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/OrderCreateExtendInfo;", "Lid/dana/cashier/model/OrderCreateExtendInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/OrderCreateExtendInfo;)Lid/dana/cashier/model/OrderCreateExtendInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OrderCreateExtendInfoModelKt {
    public static final OrderCreateExtendInfoModel BuiltInFictitiousFunctionClassFactory(OrderCreateExtendInfo orderCreateExtendInfo) {
        Intrinsics.checkNotNullParameter(orderCreateExtendInfo, "");
        TncUrl tncUrl = orderCreateExtendInfo.getTncUrl();
        return new OrderCreateExtendInfoModel(tncUrl != null ? TncUrlModelKt.MyBillsEntityDataFactory(tncUrl) : null);
    }
}
