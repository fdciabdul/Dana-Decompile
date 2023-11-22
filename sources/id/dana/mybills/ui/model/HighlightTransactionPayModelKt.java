package id.dana.mybills.ui.model;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.ui.model.PaidStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "current", "toBillPaymentStatusModel", "(Lid/dana/mybills/ui/model/HighlighTransactionPayModel;Lid/dana/mybills/ui/model/BillPaymentStatusModel;)Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "toPayRequestModel", "(Lid/dana/mybills/ui/model/BillPaymentStatusModel;)Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class HighlightTransactionPayModelKt {
    public static final HighlightTransactionPayRequestModel toPayRequestModel(BillPaymentStatusModel billPaymentStatusModel) {
        MoneyViewModel moneyViewModel;
        MoneyViewModel moneyViewModel2;
        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
        String subscriptionId = billPaymentStatusModel.getSubscriptionId();
        String str = subscriptionId == null ? "" : subscriptionId;
        MoneyViewModel totalAmount = billPaymentStatusModel.getTotalAmount();
        BizProductDestination bizProductDestination = billPaymentStatusModel.getBizProductDestination();
        if ((bizProductDestination != null ? bizProductDestination.getAdminFee() : null) != null) {
            moneyViewModel = MoneyViewModel.INSTANCE.fromMoneyView(billPaymentStatusModel.getBizProductDestination().getAdminFee());
        } else {
            moneyViewModel = new MoneyViewModel("0", "Rp", null, 4, null);
        }
        MoneyViewModel moneyViewModel3 = moneyViewModel;
        BizProductDestination bizProductDestination2 = billPaymentStatusModel.getBizProductDestination();
        if ((bizProductDestination2 != null ? bizProductDestination2.getBaseAmount() : null) != null) {
            moneyViewModel2 = MoneyViewModel.INSTANCE.fromMoneyView(billPaymentStatusModel.getBizProductDestination().getBaseAmount());
        } else {
            moneyViewModel2 = new MoneyViewModel("0", "Rp", null, 4, null);
        }
        return new HighlightTransactionPayRequestModel(str, totalAmount, "DIRECT", moneyViewModel3, moneyViewModel2);
    }

    public static final BillPaymentStatusModel toBillPaymentStatusModel(HighlighTransactionPayModel highlighTransactionPayModel, BillPaymentStatusModel billPaymentStatusModel) {
        BillPaymentStatusModel copy;
        Intrinsics.checkNotNullParameter(highlighTransactionPayModel, "");
        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
        copy = billPaymentStatusModel.copy((r43 & 1) != 0 ? billPaymentStatusModel.subscriptionId : null, (r43 & 2) != 0 ? billPaymentStatusModel.actionRedirectUrl : null, (r43 & 4) != 0 ? billPaymentStatusModel.billId : null, (r43 & 8) != 0 ? billPaymentStatusModel.canBePaid : null, (r43 & 16) != 0 ? billPaymentStatusModel.goodsType : null, (r43 & 32) != 0 ? billPaymentStatusModel.iconUrl : null, (r43 & 64) != 0 ? billPaymentStatusModel.nextScheduleTime : null, (r43 & 128) != 0 ? billPaymentStatusModel.nextScheduleDaysCount : null, (r43 & 256) != 0 ? billPaymentStatusModel.subscriptionTitle : null, (r43 & 512) != 0 ? billPaymentStatusModel.totalAmount : null, (r43 & 1024) != 0 ? billPaymentStatusModel.paidAmount : null, (r43 & 2048) != 0 ? billPaymentStatusModel.recurringType : null, (r43 & 4096) != 0 ? billPaymentStatusModel.goodsId : null, (r43 & 8192) != 0 ? billPaymentStatusModel.canInquiry : null, (r43 & 16384) != 0 ? billPaymentStatusModel.payStatus : null, (r43 & 32768) != 0 ? billPaymentStatusModel.section : null, (r43 & 65536) != 0 ? billPaymentStatusModel.bizProductDestination : null, (r43 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? billPaymentStatusModel.gmtDueDate : null, (r43 & 262144) != 0 ? billPaymentStatusModel.paidStatus : highlighTransactionPayModel.getSuccess() ? PaidStatus.Success.INSTANCE : PaidStatus.Failed.INSTANCE, (r43 & 524288) != 0 ? billPaymentStatusModel.status : null, (r43 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? billPaymentStatusModel.extInfo : null, (r43 & 2097152) != 0 ? billPaymentStatusModel.paymentMethod : null, (r43 & 4194304) != 0 ? billPaymentStatusModel.isSelected : false, (r43 & 8388608) != 0 ? billPaymentStatusModel.viewType : 0, (r43 & 16777216) != 0 ? billPaymentStatusModel.lastPayStatus : null);
        return copy;
    }
}
