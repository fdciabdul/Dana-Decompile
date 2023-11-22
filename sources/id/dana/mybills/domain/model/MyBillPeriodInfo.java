package id.dana.mybills.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/mybills/domain/model/MyBillPeriodInfo;", "", "", "currentPeriod", "Ljava/lang/Integer;", "getCurrentPeriod", "()Ljava/lang/Integer;", "", "endPeriod", "Ljava/lang/Long;", "getEndPeriod", "()Ljava/lang/Long;", "period", "getPeriod", "startPeriod", "getStartPeriod", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillPeriodInfo {
    private final Integer currentPeriod;
    private final Long endPeriod;
    private final Integer period;
    private final Long startPeriod;

    public MyBillPeriodInfo() {
        this(null, null, null, null, 15, null);
    }

    public MyBillPeriodInfo(Integer num, Long l, Integer num2, Long l2) {
        this.currentPeriod = num;
        this.endPeriod = l;
        this.period = num2;
        this.startPeriod = l2;
    }

    public /* synthetic */ MyBillPeriodInfo(Integer num, Long l, Integer num2, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0L : l, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? 0L : l2);
    }

    @JvmName(name = "getCurrentPeriod")
    public final Integer getCurrentPeriod() {
        return this.currentPeriod;
    }

    @JvmName(name = "getEndPeriod")
    public final Long getEndPeriod() {
        return this.endPeriod;
    }

    @JvmName(name = "getPeriod")
    public final Integer getPeriod() {
        return this.period;
    }

    @JvmName(name = "getStartPeriod")
    public final Long getStartPeriod() {
        return this.startPeriod;
    }
}
