package id.dana.mybills.ui.model;

import id.dana.mybills.domain.model.BizProductDestination;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\b\u0012\u0004\u0012\u00020\u00000\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;", "", "viewType", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "toBillPaymentStatusModel", "(Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;I)Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "", "toListBillPaymentStatusModel", "(Ljava/util/List;I)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillPaymentAdapterModelKt {
    public static final List<BillPaymentStatusModel> toListBillPaymentStatusModel(List<BillSubscriptionHighlightModel> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        List<BillSubscriptionHighlightModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toBillPaymentStatusModel((BillSubscriptionHighlightModel) it.next(), i));
        }
        return arrayList;
    }

    public static final BillPaymentStatusModel toBillPaymentStatusModel(BillSubscriptionHighlightModel billSubscriptionHighlightModel, int i) {
        Intrinsics.checkNotNullParameter(billSubscriptionHighlightModel, "");
        String subscriptionId = billSubscriptionHighlightModel.getSubscriptionId();
        String actionRedirectUrl = billSubscriptionHighlightModel.getActionRedirectUrl();
        String billId = billSubscriptionHighlightModel.getBillId();
        Boolean canBePaid = billSubscriptionHighlightModel.getCanBePaid();
        String goodsType = billSubscriptionHighlightModel.getGoodsType();
        String iconUrl = billSubscriptionHighlightModel.getIconUrl();
        Long nextScheduleTime = billSubscriptionHighlightModel.getNextScheduleTime();
        long nextScheduleDaysCount = billSubscriptionHighlightModel.getNextScheduleDaysCount();
        BillPaymentStatusModel billPaymentStatusModel = new BillPaymentStatusModel(subscriptionId, actionRedirectUrl, billId, canBePaid, goodsType, iconUrl, nextScheduleTime, Long.valueOf(nextScheduleDaysCount), billSubscriptionHighlightModel.getSubscriptionTitle(), billSubscriptionHighlightModel.getTotalAmount(), billSubscriptionHighlightModel.getPaidAmount(), billSubscriptionHighlightModel.getRecurringType(), billSubscriptionHighlightModel.getGoodsId(), Boolean.valueOf(billSubscriptionHighlightModel.getCanInquiry()), billSubscriptionHighlightModel.getPayStatus(), billSubscriptionHighlightModel.getSection(), billSubscriptionHighlightModel.getBizProductDestination(), billSubscriptionHighlightModel.getGmtDueDate(), null, billSubscriptionHighlightModel.getStatus(), billSubscriptionHighlightModel.getExtInfo(), billSubscriptionHighlightModel.getPaymentMethod(), false, i, billSubscriptionHighlightModel.getLastPayStatus(), 4456448, null);
        boolean z = false;
        if (billPaymentStatusModel.isBillCanBePaid()) {
            BizProductDestination bizProductDestination = billPaymentStatusModel.getBizProductDestination();
            if (bizProductDestination != null && bizProductDestination.isInquirySuccess()) {
                z = true;
            }
        }
        billPaymentStatusModel.setSelected(z);
        return billPaymentStatusModel;
    }
}
