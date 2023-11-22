package id.dana.domain.citcall.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/domain/citcall/model/CitcallPermission;", "", "", "component1", "()Z", "component2", "enableReadCallLog", "enableCallPhone", "copy", "(ZZ)Lid/dana/domain/citcall/model/CitcallPermission;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getEnableCallPhone", "getEnableReadCallLog", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CitcallPermission {
    private final boolean enableCallPhone;
    private final boolean enableReadCallLog;

    public static /* synthetic */ CitcallPermission copy$default(CitcallPermission citcallPermission, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = citcallPermission.enableReadCallLog;
        }
        if ((i & 2) != 0) {
            z2 = citcallPermission.enableCallPhone;
        }
        return citcallPermission.copy(z, z2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnableReadCallLog() {
        return this.enableReadCallLog;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getEnableCallPhone() {
        return this.enableCallPhone;
    }

    public final CitcallPermission copy(boolean enableReadCallLog, boolean enableCallPhone) {
        return new CitcallPermission(enableReadCallLog, enableCallPhone);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CitcallPermission) {
            CitcallPermission citcallPermission = (CitcallPermission) other;
            return this.enableReadCallLog == citcallPermission.enableReadCallLog && this.enableCallPhone == citcallPermission.enableCallPhone;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enableReadCallLog;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        boolean z2 = this.enableCallPhone;
        return (r0 * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CitcallPermission(enableReadCallLog=");
        sb.append(this.enableReadCallLog);
        sb.append(", enableCallPhone=");
        sb.append(this.enableCallPhone);
        sb.append(')');
        return sb.toString();
    }

    public CitcallPermission(boolean z, boolean z2) {
        this.enableReadCallLog = z;
        this.enableCallPhone = z2;
    }

    @JvmName(name = "getEnableReadCallLog")
    public final boolean getEnableReadCallLog() {
        return this.enableReadCallLog;
    }

    @JvmName(name = "getEnableCallPhone")
    public final boolean getEnableCallPhone() {
        return this.enableCallPhone;
    }
}
