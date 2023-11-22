package id.dana.data.saving.model;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.saving.model.SavingGoalView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/data/saving/model/SavingView;", "Lid/dana/domain/saving/model/SavingGoalView;", "toSavingGoalView", "(Lid/dana/data/saving/model/SavingView;)Lid/dana/domain/saving/model/SavingGoalView;", "", "toSavingGoalViews", "(Ljava/util/List;)Ljava/util/List;", "toSortedSavingViews"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavingViewKt {
    public static final SavingGoalView toSavingGoalView(SavingView savingView) {
        Intrinsics.checkNotNullParameter(savingView, "");
        String savingId = savingView.getSavingId();
        String title = savingView.getTitle();
        String categoryCode = savingView.getCategoryCode();
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(savingView.getCurrentAmount());
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(savingView.getTargetAmount());
        String orderStatus = savingView.getOrderStatus();
        String orderSubStatus = savingView.getOrderSubStatus();
        String createdTime = savingView.getCreatedTime();
        String achievedTime = savingView.getAchievedTime();
        String completedTime = savingView.getCompletedTime();
        Map<String, String> map = savingView.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        return new SavingGoalView(savingId, title, categoryCode, moneyView, moneyView2, orderStatus, orderSubStatus, createdTime, achievedTime, completedTime, null, map);
    }

    public static final List<SavingGoalView> toSavingGoalViews(List<SavingView> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SavingView> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toSavingGoalView((SavingView) it.next()));
        }
        return arrayList;
    }

    public static final List<SavingGoalView> toSortedSavingViews(List<SavingView> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List sortedWith = CollectionsKt.sortedWith(CollectionsKt.toMutableList((Collection) list), ComparisonsKt.compareBy(new Function1<SavingView, Comparable<?>>() { // from class: id.dana.data.saving.model.SavingViewKt$toSortedSavingViews$1$1
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(SavingView savingView) {
                Intrinsics.checkNotNullParameter(savingView, "");
                return Boolean.valueOf(!Intrinsics.areEqual(savingView.getTargetAmount().getAmount(), savingView.getCurrentAmount().getAmount()));
            }
        }, new Function1<SavingView, Comparable<?>>() { // from class: id.dana.data.saving.model.SavingViewKt$toSortedSavingViews$1$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(SavingView savingView) {
                Long longOrNull;
                Intrinsics.checkNotNullParameter(savingView, "");
                String createdTime = savingView.getCreatedTime();
                return Long.valueOf(-((createdTime == null || (longOrNull = StringsKt.toLongOrNull(createdTime)) == null) ? 0L : longOrNull.longValue()));
            }
        }));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add(toSavingGoalView((SavingView) it.next()));
        }
        return arrayList;
    }
}
