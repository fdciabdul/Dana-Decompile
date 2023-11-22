package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.domain.model.PayMethodFeeInfo;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/PayMethodFeeResult;", "Lid/dana/cashier/domain/model/PayMethodFeeInfo;", "toPayMethodFeeInfo", "(Lid/dana/cashier/data/repository/source/network/result/PayMethodFeeResult;)Lid/dana/cashier/domain/model/PayMethodFeeInfo;", "", "toPayMethodFeeList", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayMethodFeeResultKt {
    public static final List<PayMethodFeeInfo> toPayMethodFeeList(List<PayMethodFeeResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PayMethodFeeResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPayMethodFeeInfo((PayMethodFeeResult) it.next()));
        }
        return arrayList;
    }

    private static final PayMethodFeeInfo toPayMethodFeeInfo(PayMethodFeeResult payMethodFeeResult) {
        String payMethod = payMethodFeeResult.getPayMethod();
        MoneyViewEntity fixedAmount = payMethodFeeResult.getFixedAmount();
        MoneyView moneyView = fixedAmount != null ? MoneyViewEntityMapperKt.toMoneyView(fixedAmount) : null;
        String ratio = payMethodFeeResult.getRatio();
        MoneyViewEntity chargeAmount = payMethodFeeResult.getChargeAmount();
        return new PayMethodFeeInfo(payMethod, moneyView, ratio, chargeAmount != null ? MoneyViewEntityMapperKt.toMoneyView(chargeAmount) : null, payMethodFeeResult.getChargeType());
    }
}
