package id.dana.danapoly.ui.model.mapper;

import id.dana.danapoly.domain.dailycheck.model.CheckInInfo;
import id.dana.danapoly.domain.dailycheck.model.UserCheckInInfo;
import id.dana.danapoly.ui.dailycheck.adapter.DailyCheckItemState;
import id.dana.danapoly.ui.model.DailyCheckItemModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u000b\u001a\u00020\n*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u000f\u001a3\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\r0\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0010"}, d2 = {"", "status", "", "position", "todayCheckInPosition", "Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckItemState;", "mapCheckInStatus", "(Ljava/lang/String;ILjava/lang/Integer;)Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckItemState;", "Lid/dana/danapoly/domain/dailycheck/model/CheckInInfo;", "", "Lid/dana/danapoly/ui/model/DailyCheckItemModel;", "toDailyCheckItemModel", "(Lid/dana/danapoly/domain/dailycheck/model/CheckInInfo;)Ljava/util/List;", "Lid/dana/danapoly/domain/dailycheck/model/UserCheckInInfo;", "prizeValue", "(Lid/dana/danapoly/domain/dailycheck/model/UserCheckInInfo;ILjava/lang/Integer;)Lid/dana/danapoly/ui/model/DailyCheckItemModel;", "(Ljava/util/List;ILjava/lang/Integer;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckInMapperKt {
    public static final List<DailyCheckItemModel> toDailyCheckItemModel(CheckInInfo checkInInfo) {
        Intrinsics.checkNotNullParameter(checkInInfo, "");
        return CollectionsKt.sortedWith(toDailyCheckItemModel(checkInInfo.getUserCheckInInfo(), checkInInfo.getPrizeValue(), checkInInfo.getTodayCheckInPosition()), new Comparator() { // from class: id.dana.danapoly.ui.model.mapper.CheckInMapperKt$toDailyCheckItemModel$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DailyCheckItemModel) t).getPosition()), Integer.valueOf(((DailyCheckItemModel) t2).getPosition()));
            }
        });
    }

    public static /* synthetic */ List toDailyCheckItemModel$default(List list, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        return toDailyCheckItemModel(list, i, num);
    }

    public static final List<DailyCheckItemModel> toDailyCheckItemModel(List<UserCheckInInfo> list, int i, Integer num) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserCheckInInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toDailyCheckItemModel((UserCheckInInfo) it.next(), i, num));
        }
        return arrayList;
    }

    public static /* synthetic */ DailyCheckItemModel toDailyCheckItemModel$default(UserCheckInInfo userCheckInInfo, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return toDailyCheckItemModel(userCheckInInfo, i, num);
    }

    public static final DailyCheckItemModel toDailyCheckItemModel(UserCheckInInfo userCheckInInfo, int i, Integer num) {
        Intrinsics.checkNotNullParameter(userCheckInInfo, "");
        return new DailyCheckItemModel(i, mapCheckInStatus(userCheckInInfo.getStatus(), userCheckInInfo.getPosition(), num), userCheckInInfo.getPosition());
    }

    static /* synthetic */ DailyCheckItemState mapCheckInStatus$default(String str, int i, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return mapCheckInStatus(str, i, num);
    }

    private static final DailyCheckItemState mapCheckInStatus(String str, int i, Integer num) {
        return Intrinsics.areEqual(str, "CHECKED_IN") ? DailyCheckItemState.COMPLETED : Intrinsics.areEqual(str, "MISSED") ? DailyCheckItemState.MISSED : (num == null || num.intValue() != i) ? DailyCheckItemState.UPCOMING : DailyCheckItemState.ACTIVE;
    }
}
