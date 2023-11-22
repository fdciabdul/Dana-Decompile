package id.dana.data.sendmoney.model;

import id.dana.domain.sendmoney.model.WithdrawChannelInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/sendmoney/model/WithdrawChannelInfoEntity;", "Lid/dana/domain/sendmoney/model/WithdrawChannelInfoData;", "toWithdrawChannelInfoData", "(Lid/dana/data/sendmoney/model/WithdrawChannelInfoEntity;)Lid/dana/domain/sendmoney/model/WithdrawChannelInfoData;", "", "toWithdrawChannelInfoDatas", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WithdrawChannelInfoEntityKt {
    public static final WithdrawChannelInfoData toWithdrawChannelInfoData(WithdrawChannelInfoEntity withdrawChannelInfoEntity) {
        Intrinsics.checkNotNullParameter(withdrawChannelInfoEntity, "");
        String instId = withdrawChannelInfoEntity.getInstId();
        if (instId == null) {
            instId = "";
        }
        String label = withdrawChannelInfoEntity.getLabel();
        return new WithdrawChannelInfoData(instId, label != null ? label : "");
    }

    public static final List<WithdrawChannelInfoData> toWithdrawChannelInfoDatas(List<WithdrawChannelInfoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<WithdrawChannelInfoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toWithdrawChannelInfoData((WithdrawChannelInfoEntity) it.next()));
        }
        return arrayList;
    }
}
