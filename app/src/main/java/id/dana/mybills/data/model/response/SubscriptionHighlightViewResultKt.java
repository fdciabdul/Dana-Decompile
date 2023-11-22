package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.MyBillsItemHighlightView;
import id.dana.mybills.domain.model.MyBillsMerchantInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/data/model/response/SubscriptionHighlightViewResult;", "Lid/dana/mybills/domain/model/MyBillsItemHighlightView;", "toMyBillsItemHighlightView", "(Lid/dana/mybills/data/model/response/SubscriptionHighlightViewResult;)Lid/dana/mybills/domain/model/MyBillsItemHighlightView;", "Lid/dana/mybills/data/model/response/MerchantInfo;", "Lid/dana/mybills/domain/model/MyBillsMerchantInfo;", "toMyBillsMerchantInfo", "(Lid/dana/mybills/data/model/response/MerchantInfo;)Lid/dana/mybills/domain/model/MyBillsMerchantInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionHighlightViewResultKt {
    public static final MyBillsMerchantInfo toMyBillsMerchantInfo(MerchantInfo merchantInfo) {
        Intrinsics.checkNotNullParameter(merchantInfo, "");
        return new MyBillsMerchantInfo(String.valueOf(merchantInfo.getMerchantName()), String.valueOf(merchantInfo.getMerchantLogo()), String.valueOf(merchantInfo.getMerchantPCLogo()), String.valueOf(merchantInfo.getMerchantId()));
    }

    public static final MyBillsItemHighlightView toMyBillsItemHighlightView(SubscriptionHighlightViewResult subscriptionHighlightViewResult) {
        Intrinsics.checkNotNullParameter(subscriptionHighlightViewResult, "");
        return new MyBillsItemHighlightView(subscriptionHighlightViewResult.getActionRedirectUrl(), BillViewResultKt.toMyBillView(subscriptionHighlightViewResult.getBillView(), subscriptionHighlightViewResult.getGmtDueDate()), subscriptionHighlightViewResult.getGmtCreate(), subscriptionHighlightViewResult.getGmtDueDate(), subscriptionHighlightViewResult.getGmtModified(), subscriptionHighlightViewResult.getGoodsType(), HighlightSubscriptionResultKt.toMyBillIntervalInfo(subscriptionHighlightViewResult.getIntervalInfo()), toMyBillsMerchantInfo(subscriptionHighlightViewResult.getMerchantInfo()), PaymentCycleInfoViewsResultKt.toMyBillPaymentCycleInfoViews(subscriptionHighlightViewResult.getPaymentCycleInfoViews()), subscriptionHighlightViewResult.getPaymentMethod(), HighlightSubscriptionResultKt.toMyBillPeriodInfo(subscriptionHighlightViewResult.getPeriodInfo()), subscriptionHighlightViewResult.getRecurringType(), HighlightSubscriptionResultKt.toMyBillScheduleView(subscriptionHighlightViewResult.getScheduleView()), subscriptionHighlightViewResult.getStatus(), subscriptionHighlightViewResult.getSubscriptionId());
    }
}
