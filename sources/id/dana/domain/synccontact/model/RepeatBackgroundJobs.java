package id.dana.domain.synccontact.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/domain/synccontact/model/RepeatBackgroundJobs;", "", "", "component1", "()Z", "", "component2", "()J", "component3", "component4", "enable", "intervalTimeInMillis", "requiredCharging", "requiredDeviceIdle", "copy", "(ZJZZ)Lid/dana/domain/synccontact/model/RepeatBackgroundJobs;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getEnable", "J", "getIntervalTimeInMillis", "getRequiredCharging", "getRequiredDeviceIdle", "<init>", "(ZJZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RepeatBackgroundJobs {
    private final boolean enable;
    private final long intervalTimeInMillis;
    private final boolean requiredCharging;
    private final boolean requiredDeviceIdle;

    public static /* synthetic */ RepeatBackgroundJobs copy$default(RepeatBackgroundJobs repeatBackgroundJobs, boolean z, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = repeatBackgroundJobs.enable;
        }
        if ((i & 2) != 0) {
            j = repeatBackgroundJobs.intervalTimeInMillis;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z2 = repeatBackgroundJobs.requiredCharging;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            z3 = repeatBackgroundJobs.requiredDeviceIdle;
        }
        return repeatBackgroundJobs.copy(z, j2, z4, z3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final long getIntervalTimeInMillis() {
        return this.intervalTimeInMillis;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getRequiredCharging() {
        return this.requiredCharging;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getRequiredDeviceIdle() {
        return this.requiredDeviceIdle;
    }

    public final RepeatBackgroundJobs copy(boolean enable, long intervalTimeInMillis, boolean requiredCharging, boolean requiredDeviceIdle) {
        return new RepeatBackgroundJobs(enable, intervalTimeInMillis, requiredCharging, requiredDeviceIdle);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RepeatBackgroundJobs) {
            RepeatBackgroundJobs repeatBackgroundJobs = (RepeatBackgroundJobs) other;
            return this.enable == repeatBackgroundJobs.enable && this.intervalTimeInMillis == repeatBackgroundJobs.intervalTimeInMillis && this.requiredCharging == repeatBackgroundJobs.requiredCharging && this.requiredDeviceIdle == repeatBackgroundJobs.requiredDeviceIdle;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.intervalTimeInMillis);
        ?? r3 = this.requiredCharging;
        int i = r3;
        if (r3 != 0) {
            i = 1;
        }
        boolean z2 = this.requiredDeviceIdle;
        return (((((r0 * 31) + m) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RepeatBackgroundJobs(enable=");
        sb.append(this.enable);
        sb.append(", intervalTimeInMillis=");
        sb.append(this.intervalTimeInMillis);
        sb.append(", requiredCharging=");
        sb.append(this.requiredCharging);
        sb.append(", requiredDeviceIdle=");
        sb.append(this.requiredDeviceIdle);
        sb.append(')');
        return sb.toString();
    }

    public RepeatBackgroundJobs(boolean z, long j, boolean z2, boolean z3) {
        this.enable = z;
        this.intervalTimeInMillis = j;
        this.requiredCharging = z2;
        this.requiredDeviceIdle = z3;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getIntervalTimeInMillis")
    public final long getIntervalTimeInMillis() {
        return this.intervalTimeInMillis;
    }

    @JvmName(name = "getRequiredCharging")
    public final boolean getRequiredCharging() {
        return this.requiredCharging;
    }

    @JvmName(name = "getRequiredDeviceIdle")
    public final boolean getRequiredDeviceIdle() {
        return this.requiredDeviceIdle;
    }
}
