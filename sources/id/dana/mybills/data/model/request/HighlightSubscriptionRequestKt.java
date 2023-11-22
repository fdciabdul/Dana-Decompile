package id.dana.mybills.data.model.request;

import id.dana.mybills.domain.model.MyBillsHighlightRequestModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/domain/model/MyBillsHighlightRequestModel;", "Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;", "toHighlightSubscriptionRequest", "(Lid/dana/mybills/domain/model/MyBillsHighlightRequestModel;)Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightSubscriptionRequestKt {
    public static final HighlightSubscriptionRequest toHighlightSubscriptionRequest(MyBillsHighlightRequestModel myBillsHighlightRequestModel) {
        Intrinsics.checkNotNullParameter(myBillsHighlightRequestModel, "");
        return new HighlightSubscriptionRequest(myBillsHighlightRequestModel.getDivisionId(), myBillsHighlightRequestModel.getGoodsType(), myBillsHighlightRequestModel.getIpRoleId(), myBillsHighlightRequestModel.getMerchantId(), myBillsHighlightRequestModel.getNeedScheduleInfo(), myBillsHighlightRequestModel.getRecurringType(), myBillsHighlightRequestModel.getCountOnly(), myBillsHighlightRequestModel.getPageNum(), myBillsHighlightRequestModel.getPageSize(), myBillsHighlightRequestModel.getDueType());
    }
}
