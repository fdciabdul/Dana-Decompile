package id.dana.mybills.data.model.response;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.mybills.domain.model.MyBillView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/data/model/response/BillViewResult;", "", "dueDate", "Lid/dana/mybills/domain/model/MyBillView;", "toMyBillView", "(Lid/dana/mybills/data/model/response/BillViewResult;Ljava/lang/Long;)Lid/dana/mybills/domain/model/MyBillView;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillViewResultKt {
    public static final MyBillView toMyBillView(BillViewResult billViewResult, Long l) {
        Intrinsics.checkNotNullParameter(billViewResult, "");
        return new MyBillView(billViewResult.getBillId(), MoneyViewEntityMapperKt.toMoneyView(billViewResult.getDenom()), billViewResult.getGoodsId(), billViewResult.getGoodsName(), billViewResult.getIconUrl(), billViewResult.getProvider(), billViewResult.getSubscriptionTitle(), MoneyViewEntityMapperKt.toMoneyView(billViewResult.getTotalAmount()), billViewResult.getType(), billViewResult.getCanInquiry(), billViewResult.getIconUrl(), billViewResult.getSection(), l, billViewResult.getExtInfo());
    }
}
