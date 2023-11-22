package id.dana.domain.fullstory.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;", "", "", "lastSessionTime", "J", "getLastSessionTime", "()J", "setLastSessionTime", "(J)V", "", "sessionCount", "I", "getSessionCount", "()I", "setSessionCount", "(I)V", "<init>", "(JI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FullstoryPreferenceConfig {
    private long lastSessionTime;
    private int sessionCount;

    public FullstoryPreferenceConfig(long j, int i) {
        this.lastSessionTime = j;
        this.sessionCount = i;
    }

    @JvmName(name = "getLastSessionTime")
    public final long getLastSessionTime() {
        return this.lastSessionTime;
    }

    @JvmName(name = "setLastSessionTime")
    public final void setLastSessionTime(long j) {
        this.lastSessionTime = j;
    }

    @JvmName(name = "getSessionCount")
    public final int getSessionCount() {
        return this.sessionCount;
    }

    @JvmName(name = "setSessionCount")
    public final void setSessionCount(int i) {
        this.sessionCount = i;
    }
}
