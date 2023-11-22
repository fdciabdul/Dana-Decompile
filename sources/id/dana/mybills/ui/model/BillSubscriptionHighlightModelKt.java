package id.dana.mybills.ui.model;

import id.dana.data.util.DateTimeUtil;
import id.dana.mybills.data.model.response.ExtInfo;
import id.dana.mybills.domain.model.MyBillsItemHighlightView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "nextScheduleTime", "getDaysCount", "(J)J", "", "isSameDay", "(J)Z", "Lid/dana/mybills/domain/model/MyBillsItemHighlightView;", "Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;", "toBillSubscriptionHighlightModel", "(Lid/dana/mybills/domain/model/MyBillsItemHighlightView;)Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillSubscriptionHighlightModelKt {
    public static final BillSubscriptionHighlightModel toBillSubscriptionHighlightModel(MyBillsItemHighlightView myBillsItemHighlightView) {
        Intrinsics.checkNotNullParameter(myBillsItemHighlightView, "");
        String subscriptionId = myBillsItemHighlightView.getSubscriptionId();
        String str = subscriptionId == null ? "" : subscriptionId;
        String actionRedirectUrl = myBillsItemHighlightView.getActionRedirectUrl();
        String billId = myBillsItemHighlightView.getBillView().getBillId();
        Boolean canBePaid = myBillsItemHighlightView.getPaymentCycleInfoViews().getCanBePaid();
        String goodsType = myBillsItemHighlightView.getGoodsType();
        String billerServiceIcon = myBillsItemHighlightView.getBillView().getBillerServiceIcon();
        Long nextScheduleTime = myBillsItemHighlightView.getScheduleView().getNextScheduleTime();
        Long gmtDueDate = myBillsItemHighlightView.getBillView().getGmtDueDate();
        long daysCount = getDaysCount(gmtDueDate != null ? gmtDueDate.longValue() : -1L);
        String subscriptionTitle = myBillsItemHighlightView.getBillView().getSubscriptionTitle();
        MoneyViewModel moneyViewModel = BillPaymentStatusModelKt.toMoneyViewModel(myBillsItemHighlightView.getBillView().getTotalAmount());
        MoneyViewModel moneyViewModel2 = BillPaymentStatusModelKt.toMoneyViewModel(myBillsItemHighlightView.getPaymentCycleInfoViews().getPaidAmount());
        String recurringType = myBillsItemHighlightView.getRecurringType();
        String goodsId = myBillsItemHighlightView.getBillView().getGoodsId();
        boolean canInquiry = myBillsItemHighlightView.getBillView().getCanInquiry();
        String lastPayStatus = myBillsItemHighlightView.getPaymentCycleInfoViews().getLastPayStatus();
        String section = myBillsItemHighlightView.getBillView().getSection();
        Long gmtDueDate2 = myBillsItemHighlightView.getBillView().getGmtDueDate();
        String status = myBillsItemHighlightView.getScheduleView().getStatus();
        ExtInfo extInfo = myBillsItemHighlightView.getBillView().getExtInfo();
        String paymentMethod = myBillsItemHighlightView.getPaymentMethod();
        if (paymentMethod == null) {
            paymentMethod = "BALANCE";
        }
        return new BillSubscriptionHighlightModel(str, actionRedirectUrl, billId, canBePaid, goodsType, billerServiceIcon, nextScheduleTime, daysCount, subscriptionTitle, moneyViewModel, moneyViewModel2, recurringType, goodsId, canInquiry, lastPayStatus, section, null, gmtDueDate2, status, extInfo, paymentMethod, myBillsItemHighlightView.getPaymentCycleInfoViews().getLastPayStatus(), 65536, null);
    }

    public static final long getDaysCount(long j) {
        if (isSameDay(j)) {
            return 0L;
        }
        return DateTimeUtil.INSTANCE.countDaysFromTimestampByDay(j);
    }

    public static final boolean isSameDay(long j) {
        return DateTimeUtil.INSTANCE.countDaysFromTimestampByDay(j) == 0;
    }
}
