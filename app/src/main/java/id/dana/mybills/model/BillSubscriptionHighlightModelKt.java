package id.dana.mybills.model;

import id.dana.domain.mybills.model.MyBillsItemHighlightView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import id.dana.utils.DateTimeUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0003\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007"}, d2 = {"", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(J)Z", "Lid/dana/domain/mybills/model/MyBillsItemHighlightView;", "Lid/dana/mybills/model/BillSubscriptionHighlightModel;", "(Lid/dana/domain/mybills/model/MyBillsItemHighlightView;)Lid/dana/mybills/model/BillSubscriptionHighlightModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillSubscriptionHighlightModelKt {
    public static final BillSubscriptionHighlightModel BuiltInFictitiousFunctionClassFactory(MyBillsItemHighlightView myBillsItemHighlightView) {
        Intrinsics.checkNotNullParameter(myBillsItemHighlightView, "");
        String subscriptionId = myBillsItemHighlightView.getSubscriptionId();
        String str = subscriptionId == null ? "" : subscriptionId;
        String actionRedirectUrl = myBillsItemHighlightView.getActionRedirectUrl();
        String billId = myBillsItemHighlightView.getBillView().getBillId();
        Boolean canBePaid = myBillsItemHighlightView.getPaymentCycleInfoViews().getCanBePaid();
        String goodsType = myBillsItemHighlightView.getGoodsType();
        String billerServiceIcon = myBillsItemHighlightView.getBillView().getBillerServiceIcon();
        Long nextScheduleTime = myBillsItemHighlightView.getScheduleView().getNextScheduleTime();
        Long nextScheduleTime2 = myBillsItemHighlightView.getScheduleView().getNextScheduleTime();
        long longValue = nextScheduleTime2 != null ? nextScheduleTime2.longValue() : -1L;
        long MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory(longValue) ? 0L : DateTimeUtil.MyBillsEntityDataFactory(new Date(), new Date(longValue));
        String subscriptionTitle = myBillsItemHighlightView.getBillView().getSubscriptionTitle();
        MoneyViewModel authRequestContext = MoneyViewModelKt.getAuthRequestContext(myBillsItemHighlightView.getBillView().getTotalAmount());
        MoneyViewModel authRequestContext2 = MoneyViewModelKt.getAuthRequestContext(myBillsItemHighlightView.getPaymentCycleInfoViews().getPaidAmount());
        String recurringType = myBillsItemHighlightView.getRecurringType();
        Intrinsics.checkNotNullParameter(myBillsItemHighlightView, "");
        String lastPayStatus = myBillsItemHighlightView.getPaymentCycleInfoViews().getLastPayStatus();
        if (lastPayStatus == null) {
            lastPayStatus = "";
        }
        Boolean canBePaid2 = myBillsItemHighlightView.getPaymentCycleInfoViews().getCanBePaid();
        boolean booleanValue = canBePaid2 != null ? canBePaid2.booleanValue() : false;
        String lastExtTrxId = myBillsItemHighlightView.getPaymentCycleInfoViews().getLastExtTrxId();
        String str2 = lastExtTrxId != null ? lastExtTrxId : "";
        if (!Intrinsics.areEqual(lastPayStatus, "UNPAID") || !booleanValue) {
            if (Intrinsics.areEqual(lastPayStatus, "PAID")) {
                if ((str2.length() > 0 ? 1 : 0) != 0) {
                    r17 = 1;
                }
            }
            r17 = 2;
        }
        return new BillSubscriptionHighlightModel(str, actionRedirectUrl, billId, canBePaid, goodsType, billerServiceIcon, nextScheduleTime, MyBillsEntityDataFactory, subscriptionTitle, authRequestContext, authRequestContext2, recurringType, r17, myBillsItemHighlightView.getBillView().getGoodsId(), myBillsItemHighlightView.getBillView().getCanInquiry(), myBillsItemHighlightView.getPaymentCycleInfoViews().getLastPayStatus());
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(long j) {
        return DateTimeUtil.MyBillsEntityDataFactory(new Date(), new Date(j)) == 0;
    }
}
