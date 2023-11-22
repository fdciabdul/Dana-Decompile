package id.dana.data.mybills.model.result;

import id.dana.domain.mybills.model.MyBillPaylater;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/mybills/model/result/ListBillPaylaterResult;", "", "Lid/dana/domain/mybills/model/MyBillPaylater;", "MyBillsEntityDataFactory", "(Lid/dana/data/mybills/model/result/ListBillPaylaterResult;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ListBillPaylaterResultKt {
    public static final List<MyBillPaylater> MyBillsEntityDataFactory(ListBillPaylaterResult listBillPaylaterResult) {
        Intrinsics.checkNotNullParameter(listBillPaylaterResult, "");
        List<BillPaylater> bills = listBillPaylaterResult.getBills();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bills, 10));
        for (BillPaylater billPaylater : bills) {
            Intrinsics.checkNotNullParameter(billPaylater, "");
            arrayList.add(new MyBillPaylater(billPaylater.getAuthRequestContext, billPaylater.getErrorConfigVersion, billPaylater.NetworkUserEntityData$$ExternalSyntheticLambda0, billPaylater.lookAheadTest, billPaylater.DatabaseTableConfigUtil));
        }
        return arrayList;
    }
}
