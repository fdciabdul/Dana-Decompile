package id.dana.data.mybills.model.result;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;", "Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;)Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MonthlyAmountSubscriptionResultKt {
    public static final MyBillsMonthlyAmount KClassImpl$Data$declaredNonStaticMembers$2(MonthlyAmountSubscriptionResult monthlyAmountSubscriptionResult) {
        Intrinsics.checkNotNullParameter(monthlyAmountSubscriptionResult, "");
        return new MyBillsMonthlyAmount(monthlyAmountSubscriptionResult.errorMessage, monthlyAmountSubscriptionResult.getLocation(), MoneyViewEntityMapperKt.toMoneyView(monthlyAmountSubscriptionResult.getPaidTotalAmount()), monthlyAmountSubscriptionResult.getTotalCount(), MoneyViewEntityMapperKt.toMoneyView(monthlyAmountSubscriptionResult.getTotalEstimatedAmount()), MoneyViewEntityMapperKt.toMoneyView(monthlyAmountSubscriptionResult.getTotalMonthlyAmount()), monthlyAmountSubscriptionResult.getTotalMonthlyPaid(), monthlyAmountSubscriptionResult.getTotalMonthlyUnpaid(), MoneyViewEntityMapperKt.toMoneyView(monthlyAmountSubscriptionResult.getUnpaidTotalAmount()));
    }
}
