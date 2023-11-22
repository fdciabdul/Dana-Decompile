package id.dana.cashier.model;

import id.dana.cashier.domain.model.paylater.RepaymentInfo;
import id.dana.cashier.domain.model.paylater.RepaymentPlan;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "Lid/dana/cashier/model/RepaymentPlanModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentPlanModelKt {
    public static final List<RepaymentPlanModel> getAuthRequestContext(List<RepaymentPlan> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RepaymentPlan> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (RepaymentPlan repaymentPlan : list2) {
            Intrinsics.checkNotNullParameter(repaymentPlan, "");
            Integer period = repaymentPlan.getPeriod();
            MoneyView amount = repaymentPlan.getAmount();
            MoneyViewModel authRequestContext = amount != null ? MoneyViewModelKt.getAuthRequestContext(amount) : null;
            List<RepaymentInfo> repaymentInfos = repaymentPlan.getRepaymentInfos();
            List<RepaymentInfoModel> authRequestContext2 = repaymentInfos != null ? RepaymentInfoModelKt.getAuthRequestContext(repaymentInfos) : null;
            arrayList.add(new RepaymentPlanModel(period, authRequestContext, authRequestContext2 == null ? CollectionsKt.emptyList() : authRequestContext2, repaymentPlan.getRecommended(), false, 16, null));
        }
        return arrayList;
    }
}
