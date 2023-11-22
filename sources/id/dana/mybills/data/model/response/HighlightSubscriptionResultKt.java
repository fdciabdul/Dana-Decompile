package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.MyBillIntervalInfo;
import id.dana.mybills.domain.model.MyBillPeriodInfo;
import id.dana.mybills.domain.model.MyBillScheduleView;
import id.dana.mybills.domain.model.MyBillsHighlight;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mybills/data/model/response/IntervalInfo;", "Lid/dana/mybills/domain/model/MyBillIntervalInfo;", "toMyBillIntervalInfo", "(Lid/dana/mybills/data/model/response/IntervalInfo;)Lid/dana/mybills/domain/model/MyBillIntervalInfo;", "Lid/dana/mybills/data/model/response/PeriodInfo;", "Lid/dana/mybills/domain/model/MyBillPeriodInfo;", "toMyBillPeriodInfo", "(Lid/dana/mybills/data/model/response/PeriodInfo;)Lid/dana/mybills/domain/model/MyBillPeriodInfo;", "Lid/dana/mybills/data/model/response/ScheduleView;", "Lid/dana/mybills/domain/model/MyBillScheduleView;", "toMyBillScheduleView", "(Lid/dana/mybills/data/model/response/ScheduleView;)Lid/dana/mybills/domain/model/MyBillScheduleView;", "Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "Lid/dana/mybills/domain/model/MyBillsHighlight;", "toMyBillsHighlight", "(Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;)Lid/dana/mybills/domain/model/MyBillsHighlight;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightSubscriptionResultKt {
    public static final MyBillsHighlight toMyBillsHighlight(HighlightSubscriptionResult highlightSubscriptionResult) {
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
                arrayList.add(SubscriptionHighlightViewResultKt.toMyBillsItemHighlightView((SubscriptionHighlightViewResult) it.next()));
            }
            emptyList = arrayList;
        }
        int totalCount = highlightSubscriptionResult.getTotalCount();
        return new MyBillsHighlight(emptyList, Integer.valueOf(totalCount), highlightSubscriptionResult.getHasMore());
    }

    public static final MyBillIntervalInfo toMyBillIntervalInfo(IntervalInfo intervalInfo) {
        Intrinsics.checkNotNullParameter(intervalInfo, "");
        return new MyBillIntervalInfo(intervalInfo.getType(), Integer.valueOf(intervalInfo.getValue()));
    }

    public static final MyBillPeriodInfo toMyBillPeriodInfo(PeriodInfo periodInfo) {
        Intrinsics.checkNotNullParameter(periodInfo, "");
        return new MyBillPeriodInfo(Integer.valueOf(periodInfo.getCurrentPeriod()), Long.valueOf(periodInfo.getEndPeriod()), Integer.valueOf(periodInfo.getPeriod()), Long.valueOf(periodInfo.getStartPeriod()));
    }

    public static final MyBillScheduleView toMyBillScheduleView(ScheduleView scheduleView) {
        Intrinsics.checkNotNullParameter(scheduleView, "");
        long nextScheduleTime = scheduleView.getNextScheduleTime();
        return new MyBillScheduleView(Long.valueOf(nextScheduleTime), scheduleView.getStatus());
    }
}
