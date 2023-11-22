package id.dana.domain.login.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/domain/login/model/VerifyPasswordResult;", "", "", "failedCount", "I", "getFailedCount", "()I", "", "lastFailedTime", "J", "getLastFailedTime", "()J", "lockedExpireSeconds", "getLockedExpireSeconds", "maxFailedCount", "getMaxFailedCount", "", "success", "Z", "getSuccess", "()Z", "<init>", "(ZJIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPasswordResult {
    private final int failedCount;
    private final long lastFailedTime;
    private final int lockedExpireSeconds;
    private final int maxFailedCount;
    private final boolean success;

    public VerifyPasswordResult(boolean z, long j, int i, int i2, int i3) {
        this.success = z;
        this.lastFailedTime = j;
        this.lockedExpireSeconds = i;
        this.failedCount = i2;
        this.maxFailedCount = i3;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getLastFailedTime")
    public final long getLastFailedTime() {
        return this.lastFailedTime;
    }

    @JvmName(name = "getLockedExpireSeconds")
    public final int getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    @JvmName(name = "getFailedCount")
    public final int getFailedCount() {
        return this.failedCount;
    }

    @JvmName(name = "getMaxFailedCount")
    public final int getMaxFailedCount() {
        return this.maxFailedCount;
    }
}
