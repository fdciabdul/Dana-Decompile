package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.domain.model.Risk3dsAdditionalData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0002\u0010\u0005"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/Risk3dsAdditionalDataResult;", "Lid/dana/cashier/domain/model/Risk3dsAdditionalData;", "toRisk3dsAdditionalData", "(Lid/dana/cashier/data/repository/source/network/result/Risk3dsAdditionalDataResult;)Lid/dana/cashier/domain/model/Risk3dsAdditionalData;", "", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Risk3dsAdditionalDataResultKt {
    public static final List<Risk3dsAdditionalData> toRisk3dsAdditionalData(List<Risk3dsAdditionalDataResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<Risk3dsAdditionalDataResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRisk3dsAdditionalData((Risk3dsAdditionalDataResult) it.next()));
        }
        return arrayList;
    }

    private static final Risk3dsAdditionalData toRisk3dsAdditionalData(Risk3dsAdditionalDataResult risk3dsAdditionalDataResult) {
        return new Risk3dsAdditionalData(risk3dsAdditionalDataResult.getParam(), risk3dsAdditionalDataResult.getHttpMethod(), risk3dsAdditionalDataResult.getTargetUrl(), risk3dsAdditionalDataResult.getContentType(), risk3dsAdditionalDataResult.getSeq());
    }
}
