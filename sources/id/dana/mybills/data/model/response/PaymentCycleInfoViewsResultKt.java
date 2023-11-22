package id.dana.mybills.data.model.response;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.mybills.domain.model.MyBillPaymentCycleInfoViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/data/model/response/PaymentCycleInfoViewsResult;", "Lid/dana/mybills/domain/model/MyBillPaymentCycleInfoViews;", "toMyBillPaymentCycleInfoViews", "(Lid/dana/mybills/data/model/response/PaymentCycleInfoViewsResult;)Lid/dana/mybills/domain/model/MyBillPaymentCycleInfoViews;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentCycleInfoViewsResultKt {
    public static final MyBillPaymentCycleInfoViews toMyBillPaymentCycleInfoViews(PaymentCycleInfoViewsResult paymentCycleInfoViewsResult) {
        Intrinsics.checkNotNullParameter(paymentCycleInfoViewsResult, "");
        boolean canBePaid = paymentCycleInfoViewsResult.getCanBePaid();
        return new MyBillPaymentCycleInfoViews(Boolean.valueOf(canBePaid), paymentCycleInfoViewsResult.getLastExtTrxId(), paymentCycleInfoViewsResult.getLastPayStatus(), paymentCycleInfoViewsResult.getLastPaymentDate(), paymentCycleInfoViewsResult.getLastTrxId(), MoneyViewEntityMapperKt.toMoneyView(paymentCycleInfoViewsResult.getPaidAmount()));
    }
}
