package id.dana.analytics.executiontime;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\f"}, d2 = {"Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "", "", "calculateDuration", "()J", "getExecutionTime", "", "initiateEndTime", "()V", "initiateStartTime", "reset", "endTime", "J", "startTime", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class TrackerExecutionCounter {
    private long endTime;
    private long startTime;

    public final void initiateStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public final void initiateEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public final long getExecutionTime() {
        long calculateDuration = calculateDuration();
        reset();
        if (calculateDuration <= 0) {
            return 0L;
        }
        return calculateDuration;
    }

    private final long calculateDuration() {
        long j = this.startTime;
        if (j > 0) {
            long j2 = this.endTime;
            if (j2 > 0) {
                return j2 - j;
            }
            return 0L;
        }
        return 0L;
    }

    private final void reset() {
        this.startTime = 0L;
        this.endTime = 0L;
    }
}
