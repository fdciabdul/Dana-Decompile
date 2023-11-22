package id.dana.data.saving.mapper;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.saving.model.TopUpViewEntity;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.saving.model.TopUpView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/saving/model/TopUpViewEntity;", "Lid/dana/domain/saving/model/TopUpView;", "toTopUpView", "(Lid/dana/data/saving/model/TopUpViewEntity;)Lid/dana/domain/saving/model/TopUpView;", "", "toTopUpViews", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpViewMapperKt {
    public static final List<TopUpView> toTopUpViews(List<TopUpViewEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<TopUpViewEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toTopUpView((TopUpViewEntity) it.next()));
        }
        return arrayList;
    }

    private static final TopUpView toTopUpView(TopUpViewEntity topUpViewEntity) {
        String topUpId = topUpViewEntity.getTopUpId();
        String str = topUpId == null ? "" : topUpId;
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(topUpViewEntity.getFundAmount());
        String status = topUpViewEntity.getStatus();
        String str2 = status == null ? "" : status;
        String createdTime = topUpViewEntity.getCreatedTime();
        String str3 = createdTime == null ? "" : createdTime;
        String bizOrderId = topUpViewEntity.getBizOrderId();
        String str4 = bizOrderId == null ? "" : bizOrderId;
        HashMap extendInfo = topUpViewEntity.getExtendInfo();
        if (extendInfo == null) {
            extendInfo = new HashMap();
        }
        return new TopUpView(str, moneyView, str2, str3, str4, extendInfo);
    }
}
