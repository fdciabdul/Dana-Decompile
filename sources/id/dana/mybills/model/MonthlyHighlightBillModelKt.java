package id.dana.mybills.model;

import id.dana.domain.mybills.model.MyBillsHighlight;
import id.dana.domain.mybills.model.MyBillsItemHighlightView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/mybills/model/MyBillsHighlight;", "Lid/dana/mybills/model/MonthlyHighlightBillModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/mybills/model/MyBillsHighlight;)Lid/dana/mybills/model/MonthlyHighlightBillModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MonthlyHighlightBillModelKt {
    public static final MonthlyHighlightBillModel KClassImpl$Data$declaredNonStaticMembers$2(MyBillsHighlight myBillsHighlight) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(myBillsHighlight, "");
        List<MyBillsItemHighlightView> subscriptionHighlightViews = myBillsHighlight.getSubscriptionHighlightViews();
        if (subscriptionHighlightViews != null) {
            List<MyBillsItemHighlightView> list = subscriptionHighlightViews;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(BillSubscriptionHighlightModelKt.BuiltInFictitiousFunctionClassFactory((MyBillsItemHighlightView) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new MonthlyHighlightBillModel(arrayList, myBillsHighlight.getTotalCount());
    }
}
