package id.dana.cashier.model;

import id.dana.cashier.domain.model.paylater.RepaymentInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/cashier/domain/model/paylater/RepaymentInfo;", "Lid/dana/cashier/model/RepaymentInfoModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentInfoModelKt {
    public static final List<RepaymentInfoModel> getAuthRequestContext(List<RepaymentInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RepaymentInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (RepaymentInfo repaymentInfo : list2) {
            Intrinsics.checkNotNullParameter(repaymentInfo, "");
            String repaymentDueDate = repaymentInfo.getRepaymentDueDate();
            MoneyView repaymentAmount = repaymentInfo.getRepaymentAmount();
            MoneyViewModel authRequestContext = repaymentAmount != null ? MoneyViewModelKt.getAuthRequestContext(repaymentAmount) : null;
            MoneyView repaymentAmountWithFee = repaymentInfo.getRepaymentAmountWithFee();
            MoneyViewModel authRequestContext2 = repaymentAmountWithFee != null ? MoneyViewModelKt.getAuthRequestContext(repaymentAmountWithFee) : null;
            MoneyView principalAmount = repaymentInfo.getPrincipalAmount();
            MoneyViewModel authRequestContext3 = principalAmount != null ? MoneyViewModelKt.getAuthRequestContext(principalAmount) : null;
            MoneyView interestFeeAmount = repaymentInfo.getInterestFeeAmount();
            MoneyViewModel authRequestContext4 = interestFeeAmount != null ? MoneyViewModelKt.getAuthRequestContext(interestFeeAmount) : null;
            MoneyView lateFeeAmount = repaymentInfo.getLateFeeAmount();
            arrayList.add(new RepaymentInfoModel(repaymentDueDate, authRequestContext, authRequestContext2, authRequestContext3, authRequestContext4, lateFeeAmount != null ? MoneyViewModelKt.getAuthRequestContext(lateFeeAmount) : null));
        }
        return arrayList;
    }
}
