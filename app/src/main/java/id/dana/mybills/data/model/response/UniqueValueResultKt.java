package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.CheckUniqueValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/data/model/response/UniqueValueResult;", "Lid/dana/mybills/domain/model/CheckUniqueValue;", "toCheckUniqueValue", "(Lid/dana/mybills/data/model/response/UniqueValueResult;)Lid/dana/mybills/domain/model/CheckUniqueValue;", "Lid/dana/mybills/data/model/response/SubscriptionItem;", "Lid/dana/mybills/domain/model/CheckUniqueValue$SubscriptionItem;", "toSubscriptionItem", "(Lid/dana/mybills/data/model/response/SubscriptionItem;)Lid/dana/mybills/domain/model/CheckUniqueValue$SubscriptionItem;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniqueValueResultKt {
    public static final CheckUniqueValue toCheckUniqueValue(UniqueValueResult uniqueValueResult) {
        Intrinsics.checkNotNullParameter(uniqueValueResult, "");
        int autodeductionCount = uniqueValueResult.getAutodeductionCount();
        int reminderCount = uniqueValueResult.getReminderCount();
        List<SubscriptionItem> values = uniqueValueResult.getValues();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(toSubscriptionItem((SubscriptionItem) it.next()));
        }
        return new CheckUniqueValue(autodeductionCount, reminderCount, arrayList);
    }

    public static final CheckUniqueValue.SubscriptionItem toSubscriptionItem(SubscriptionItem subscriptionItem) {
        Intrinsics.checkNotNullParameter(subscriptionItem, "");
        return new CheckUniqueValue.SubscriptionItem(subscriptionItem.getGoodsType(), subscriptionItem.getRecurringType(), subscriptionItem.getSubscriptionId());
    }
}
