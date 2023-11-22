package id.dana.danapoly.domain.dailycheck.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danapoly/domain/dailycheck/model/CheckInInfo;", "", "", "prizeValue", "I", "getPrizeValue", "()I", "todayCheckInPosition", "Ljava/lang/Integer;", "getTodayCheckInPosition", "()Ljava/lang/Integer;", "", "Lid/dana/danapoly/domain/dailycheck/model/UserCheckInInfo;", "userCheckInInfo", "Ljava/util/List;", "getUserCheckInInfo", "()Ljava/util/List;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckInInfo {
    private final int prizeValue;
    private final Integer todayCheckInPosition;
    private final List<UserCheckInInfo> userCheckInInfo;

    public CheckInInfo() {
        this(null, null, 0, 7, null);
    }

    public CheckInInfo(Integer num, List<UserCheckInInfo> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.todayCheckInPosition = num;
        this.userCheckInInfo = list;
        this.prizeValue = i;
    }

    @JvmName(name = "getTodayCheckInPosition")
    public final Integer getTodayCheckInPosition() {
        return this.todayCheckInPosition;
    }

    public /* synthetic */ CheckInInfo(Integer num, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? 1 : i);
    }

    @JvmName(name = "getUserCheckInInfo")
    public final List<UserCheckInInfo> getUserCheckInInfo() {
        return this.userCheckInInfo;
    }

    @JvmName(name = "getPrizeValue")
    public final int getPrizeValue() {
        return this.prizeValue;
    }
}
