package id.dana.cashier.data.mapper;

import id.dana.cashier.domain.model.paylater.RepaymentPlan;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.paylater.repository.source.network.result.RepaymentInfoResult;
import id.dana.data.paylater.repository.source.network.result.RepaymentPlanResult;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/RepaymentPlanResult;", "Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "toRepaymentPlan", "(Lid/dana/data/paylater/repository/source/network/result/RepaymentPlanResult;)Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "", "toRepaymentPlans", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentPlanResultMapperKt {
    public static final List<RepaymentPlan> toRepaymentPlans(List<RepaymentPlanResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RepaymentPlanResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRepaymentPlan((RepaymentPlanResult) it.next()));
        }
        return arrayList;
    }

    public static final RepaymentPlan toRepaymentPlan(RepaymentPlanResult repaymentPlanResult) {
        Intrinsics.checkNotNullParameter(repaymentPlanResult, "");
        Integer period = repaymentPlanResult.getPeriod();
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(repaymentPlanResult.getAmount());
        List<RepaymentInfoResult> repaymentInfo = repaymentPlanResult.getRepaymentInfo();
        return new RepaymentPlan(period, moneyView, repaymentInfo != null ? RepaymentInfoResultMapperKt.toRepaymentInfos(repaymentInfo) : null, repaymentPlanResult.getRecommended());
    }
}
