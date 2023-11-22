package id.dana.mybills.ui.model;

import id.dana.mybills.domain.model.MyBillsHighlight;
import id.dana.mybills.domain.model.MyBillsItemHighlightView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lid/dana/mybills/domain/model/MyBillsItemHighlightView;", "Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;", "toListBillSubscriptionHighlightModel", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/mybills/domain/model/MyBillsHighlight;", "Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "toMonthlyHighlightBillModel", "(Lid/dana/mybills/domain/model/MyBillsHighlight;)Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MonthlyHighlightBillModelKt {
    public static final MonthlyHighlightBillModel toMonthlyHighlightBillModel(MyBillsHighlight myBillsHighlight) {
        Intrinsics.checkNotNullParameter(myBillsHighlight, "");
        return new MonthlyHighlightBillModel(toListBillSubscriptionHighlightModel(myBillsHighlight.getSubscriptionHighlightViews()), myBillsHighlight.getTotalCount(), myBillsHighlight.getHasMore());
    }

    private static final List<BillSubscriptionHighlightModel> toListBillSubscriptionHighlightModel(List<MyBillsItemHighlightView> list) {
        List<MyBillsItemHighlightView> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(BillSubscriptionHighlightModelKt.toBillSubscriptionHighlightModel((MyBillsItemHighlightView) it.next()));
        }
        return arrayList;
    }
}
