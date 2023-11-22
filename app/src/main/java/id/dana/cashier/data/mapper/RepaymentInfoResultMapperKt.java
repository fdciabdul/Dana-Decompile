package id.dana.cashier.data.mapper;

import id.dana.cashier.domain.model.paylater.RepaymentInfo;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.paylater.repository.source.network.result.RepaymentInfoResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/RepaymentInfoResult;", "Lid/dana/cashier/domain/model/paylater/RepaymentInfo;", "toRepaymentInfo", "(Lid/dana/data/paylater/repository/source/network/result/RepaymentInfoResult;)Lid/dana/cashier/domain/model/paylater/RepaymentInfo;", "", "toRepaymentInfos", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentInfoResultMapperKt {
    public static final List<RepaymentInfo> toRepaymentInfos(List<RepaymentInfoResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RepaymentInfoResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRepaymentInfo((RepaymentInfoResult) it.next()));
        }
        return arrayList;
    }

    public static final RepaymentInfo toRepaymentInfo(RepaymentInfoResult repaymentInfoResult) {
        Intrinsics.checkNotNullParameter(repaymentInfoResult, "");
        String repaymentDueDate = repaymentInfoResult.getRepaymentDueDate();
        return new RepaymentInfo(repaymentDueDate == null ? "" : repaymentDueDate, MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getRepaymentAmount()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getRepaymentAmountWithFee()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getPrincipalAmount()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getInterestFeeAmount()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getLateFeeAmount()));
    }
}
