package id.dana.danapoly.data.dailycheck.model.mapper;

import id.dana.danapoly.data.dailycheck.model.response.CheckInInfoResponse;
import id.dana.danapoly.data.dailycheck.model.response.UserCheckInInfoResponse;
import id.dana.danapoly.domain.dailycheck.model.CheckInInfo;
import id.dana.danapoly.domain.dailycheck.model.UserCheckInInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\t"}, d2 = {"Lid/dana/danapoly/data/dailycheck/model/response/CheckInInfoResponse;", "Lid/dana/danapoly/domain/dailycheck/model/CheckInInfo;", "toCheckInInfo", "(Lid/dana/danapoly/data/dailycheck/model/response/CheckInInfoResponse;)Lid/dana/danapoly/domain/dailycheck/model/CheckInInfo;", "Lid/dana/danapoly/data/dailycheck/model/response/UserCheckInInfoResponse;", "Lid/dana/danapoly/domain/dailycheck/model/UserCheckInInfo;", "toUserCheckInInfo", "(Lid/dana/danapoly/data/dailycheck/model/response/UserCheckInInfoResponse;)Lid/dana/danapoly/domain/dailycheck/model/UserCheckInInfo;", "", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckInInfoMapperKt {
    public static final CheckInInfo toCheckInInfo(CheckInInfoResponse checkInInfoResponse) {
        Intrinsics.checkNotNullParameter(checkInInfoResponse, "");
        return new CheckInInfo(checkInInfoResponse.getTodayCheckInPosition(), toUserCheckInInfo(checkInInfoResponse.getUserCheckInInfo()), 0, 4, null);
    }

    public static final List<UserCheckInInfo> toUserCheckInInfo(List<UserCheckInInfoResponse> list) {
        if (list != null) {
            List<UserCheckInInfoResponse> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toUserCheckInInfo((UserCheckInInfoResponse) it.next()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public static final UserCheckInInfo toUserCheckInInfo(UserCheckInInfoResponse userCheckInInfoResponse) {
        Intrinsics.checkNotNullParameter(userCheckInInfoResponse, "");
        Integer position = userCheckInInfoResponse.getPosition();
        int intValue = position != null ? position.intValue() : 0;
        String status = userCheckInInfoResponse.getStatus();
        String str = status != null ? status : "";
        Long checkInDate = userCheckInInfoResponse.getCheckInDate();
        return new UserCheckInInfo(intValue, str, checkInDate != null ? checkInDate.longValue() : 0L);
    }
}
