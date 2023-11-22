package id.dana.cashier.domain.model.paylater;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cashier/domain/model/paylater/PaylaterRegistrationCooldownCache;", "", "", "cacheCooldownCount", "I", "getCacheCooldownCount", "()I", "setCacheCooldownCount", "(I)V", "", "cacheCooldownDelayStartTime", "J", "getCacheCooldownDelayStartTime", "()J", "setCacheCooldownDelayStartTime", "(J)V", "<init>", "(IJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterRegistrationCooldownCache {
    private int cacheCooldownCount;
    private long cacheCooldownDelayStartTime;

    public PaylaterRegistrationCooldownCache() {
        this(0, 0L, 3, null);
    }

    public PaylaterRegistrationCooldownCache(int i, long j) {
        this.cacheCooldownCount = i;
        this.cacheCooldownDelayStartTime = j;
    }

    public /* synthetic */ PaylaterRegistrationCooldownCache(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j);
    }

    @JvmName(name = "getCacheCooldownCount")
    public final int getCacheCooldownCount() {
        return this.cacheCooldownCount;
    }

    @JvmName(name = "setCacheCooldownCount")
    public final void setCacheCooldownCount(int i) {
        this.cacheCooldownCount = i;
    }

    @JvmName(name = "getCacheCooldownDelayStartTime")
    public final long getCacheCooldownDelayStartTime() {
        return this.cacheCooldownDelayStartTime;
    }

    @JvmName(name = "setCacheCooldownDelayStartTime")
    public final void setCacheCooldownDelayStartTime(long j) {
        this.cacheCooldownDelayStartTime = j;
    }
}
