package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.MyBillPaylater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/data/model/response/ListBillPaylaterResult;", "", "Lid/dana/mybills/domain/model/MyBillPaylater;", "toListMyBillPaylater", "(Lid/dana/mybills/data/model/response/ListBillPaylaterResult;)Ljava/util/List;", "Lid/dana/mybills/data/model/response/BillPaylater;", "toMyBillPaylater", "(Lid/dana/mybills/data/model/response/BillPaylater;)Lid/dana/mybills/domain/model/MyBillPaylater;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ListBillPaylaterResultKt {
    public static final List<MyBillPaylater> toListMyBillPaylater(ListBillPaylaterResult listBillPaylaterResult) {
        Intrinsics.checkNotNullParameter(listBillPaylaterResult, "");
        List<BillPaylater> bills = listBillPaylaterResult.getBills();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bills, 10));
        Iterator<T> it = bills.iterator();
        while (it.hasNext()) {
            arrayList.add(toMyBillPaylater((BillPaylater) it.next()));
        }
        return arrayList;
    }

    public static final MyBillPaylater toMyBillPaylater(BillPaylater billPaylater) {
        Intrinsics.checkNotNullParameter(billPaylater, "");
        return new MyBillPaylater(billPaylater.getBillDate(), billPaylater.getCurrentNeedRepayAmount(), billPaylater.getDebtAmount(), billPaylater.getId(), billPaylater.getIssueDate(), billPaylater.getLateFee(), billPaylater.getOverdueDay(), billPaylater.getRepaymentDate(), billPaylater.getRepaymentMonth(), billPaylater.getStatus(), billPaylater.getUnpaidAmount(), billPaylater.getRepaidAmount());
    }
}
