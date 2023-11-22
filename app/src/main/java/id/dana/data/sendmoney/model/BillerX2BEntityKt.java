package id.dana.data.sendmoney.model;

import id.dana.domain.sendmoney.model.BillerX2B;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/sendmoney/model/BillerX2BEntity;", "Lid/dana/domain/sendmoney/model/BillerX2B;", "toBillerX2B", "(Lid/dana/data/sendmoney/model/BillerX2BEntity;)Lid/dana/domain/sendmoney/model/BillerX2B;", "", "toBillerX2BList", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BillerX2BEntityKt {
    public static final BillerX2B toBillerX2B(BillerX2BEntity billerX2BEntity) {
        Intrinsics.checkNotNullParameter(billerX2BEntity, "");
        return new BillerX2B(billerX2BEntity.getBillerName(), billerX2BEntity.getInstId(), billerX2BEntity.getPrefix(), billerX2BEntity.getClientId(), billerX2BEntity.getRedirectUrl(), billerX2BEntity.getScopes(), billerX2BEntity.getAgreed());
    }

    public static final List<BillerX2B> toBillerX2BList(List<BillerX2BEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<BillerX2BEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toBillerX2B((BillerX2BEntity) it.next()));
        }
        return arrayList;
    }
}
