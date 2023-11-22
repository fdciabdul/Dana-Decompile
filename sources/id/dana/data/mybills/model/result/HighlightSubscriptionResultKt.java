package id.dana.data.mybills.model.result;

import id.dana.domain.mybills.model.MyBillIntervalInfo;
import id.dana.domain.mybills.model.MyBillPeriodInfo;
import id.dana.domain.mybills.model.MyBillScheduleView;
import id.dana.domain.mybills.model.MyBillsHighlight;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/mybills/model/result/IntervalInfo;", "Lid/dana/domain/mybills/model/MyBillIntervalInfo;", "MyBillsEntityDataFactory", "(Lid/dana/data/mybills/model/result/IntervalInfo;)Lid/dana/domain/mybills/model/MyBillIntervalInfo;", "Lid/dana/data/mybills/model/result/PeriodInfo;", "Lid/dana/domain/mybills/model/MyBillPeriodInfo;", "(Lid/dana/data/mybills/model/result/PeriodInfo;)Lid/dana/domain/mybills/model/MyBillPeriodInfo;", "Lid/dana/data/mybills/model/result/ScheduleView;", "Lid/dana/domain/mybills/model/MyBillScheduleView;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/mybills/model/result/ScheduleView;)Lid/dana/domain/mybills/model/MyBillScheduleView;", "Lid/dana/data/mybills/model/result/HighlightSubscriptionResult;", "Lid/dana/domain/mybills/model/MyBillsHighlight;", "PlaceComponentResult", "(Lid/dana/data/mybills/model/result/HighlightSubscriptionResult;)Lid/dana/domain/mybills/model/MyBillsHighlight;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HighlightSubscriptionResultKt {
    public static final MyBillsHighlight PlaceComponentResult(HighlightSubscriptionResult highlightSubscriptionResult) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(highlightSubscriptionResult, "");
        List<SubscriptionHighlightViewResult> subscriptionViews = highlightSubscriptionResult.getSubscriptionViews();
        if (subscriptionViews == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<SubscriptionHighlightViewResult> list = subscriptionViews;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(SubscriptionHighlightViewResultKt.KClassImpl$Data$declaredNonStaticMembers$2((SubscriptionHighlightViewResult) it.next()));
            }
            emptyList = arrayList;
        }
        return new MyBillsHighlight(emptyList, Integer.valueOf(highlightSubscriptionResult.getTotalCount()));
    }

    public static final MyBillIntervalInfo MyBillsEntityDataFactory(IntervalInfo intervalInfo) {
        Intrinsics.checkNotNullParameter(intervalInfo, "");
        return new MyBillIntervalInfo(intervalInfo.PlaceComponentResult, Integer.valueOf(intervalInfo.MyBillsEntityDataFactory));
    }

    public static final MyBillPeriodInfo MyBillsEntityDataFactory(PeriodInfo periodInfo) {
        Intrinsics.checkNotNullParameter(periodInfo, "");
        return new MyBillPeriodInfo(Integer.valueOf(periodInfo.KClassImpl$Data$declaredNonStaticMembers$2), Long.valueOf(periodInfo.BuiltInFictitiousFunctionClassFactory), Integer.valueOf(periodInfo.MyBillsEntityDataFactory), Long.valueOf(periodInfo.PlaceComponentResult));
    }

    public static final MyBillScheduleView KClassImpl$Data$declaredNonStaticMembers$2(ScheduleView scheduleView) {
        Intrinsics.checkNotNullParameter(scheduleView, "");
        long j = scheduleView.KClassImpl$Data$declaredNonStaticMembers$2;
        return new MyBillScheduleView(Long.valueOf(j), scheduleView.MyBillsEntityDataFactory);
    }
}
