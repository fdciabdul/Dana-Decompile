package id.dana.mybills.data.model.response;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/mybills/data/model/response/PeriodInfo;", "", "", "currentPeriod", "I", "getCurrentPeriod", "()I", "", "endPeriod", "J", "getEndPeriod", "()J", "period", "getPeriod", "startPeriod", "getStartPeriod", "<init>", "(IJIJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PeriodInfo {
    private final int currentPeriod;
    private final long endPeriod;
    private final int period;
    private final long startPeriod;

    public PeriodInfo(int i, long j, int i2, long j2) {
        this.currentPeriod = i;
        this.endPeriod = j;
        this.period = i2;
        this.startPeriod = j2;
    }

    @JvmName(name = "getCurrentPeriod")
    public final int getCurrentPeriod() {
        return this.currentPeriod;
    }

    @JvmName(name = "getEndPeriod")
    public final long getEndPeriod() {
        return this.endPeriod;
    }

    @JvmName(name = "getPeriod")
    public final int getPeriod() {
        return this.period;
    }

    @JvmName(name = "getStartPeriod")
    public final long getStartPeriod() {
        return this.startPeriod;
    }
}
