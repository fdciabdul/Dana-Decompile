package id.dana.data.here.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/data/here/model/HereBackoffData;", "", "", "backoffTime", "I", "getBackoffTime", "()I", "setBackoffTime", "(I)V", "", "lastFetch", "J", "getLastFetch", "()J", "setLastFetch", "(J)V", "", "status", "Z", "getStatus", "()Z", "setStatus", "(Z)V", "<init>", "(ZJI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HereBackoffData {
    private int backoffTime;
    private long lastFetch;
    private boolean status;

    public HereBackoffData() {
        this(false, 0L, 0, 7, null);
    }

    public HereBackoffData(boolean z, long j, int i) {
        this.status = z;
        this.lastFetch = j;
        this.backoffTime = i;
    }

    public /* synthetic */ HereBackoffData(boolean z, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getStatus")
    public final boolean getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(boolean z) {
        this.status = z;
    }

    @JvmName(name = "getLastFetch")
    public final long getLastFetch() {
        return this.lastFetch;
    }

    @JvmName(name = "setLastFetch")
    public final void setLastFetch(long j) {
        this.lastFetch = j;
    }

    @JvmName(name = "getBackoffTime")
    public final int getBackoffTime() {
        return this.backoffTime;
    }

    @JvmName(name = "setBackoffTime")
    public final void setBackoffTime(int i) {
        this.backoffTime = i;
    }
}
