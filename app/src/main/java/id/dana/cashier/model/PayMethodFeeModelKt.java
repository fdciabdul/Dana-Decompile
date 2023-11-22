package id.dana.cashier.model;

import id.dana.cashier.domain.model.PayMethodFeeInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/cashier/domain/model/PayMethodFeeInfo;", "Lid/dana/cashier/model/PayMethodFeeModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayMethodFeeModelKt {
    public static final List<PayMethodFeeModel> getAuthRequestContext(List<PayMethodFeeInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PayMethodFeeInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PayMethodFeeInfo payMethodFeeInfo : list2) {
            String payMethod = payMethodFeeInfo.getPayMethod();
            MoneyView fixedAmount = payMethodFeeInfo.getFixedAmount();
            MoneyViewModel authRequestContext = fixedAmount != null ? MoneyViewModelKt.getAuthRequestContext(fixedAmount) : null;
            String ratio = payMethodFeeInfo.getRatio();
            MoneyView chargeAmount = payMethodFeeInfo.getChargeAmount();
            arrayList.add(new PayMethodFeeModel(payMethod, authRequestContext, ratio, chargeAmount != null ? MoneyViewModelKt.getAuthRequestContext(chargeAmount) : null, payMethodFeeInfo.getChargeType()));
        }
        return arrayList;
    }
}
