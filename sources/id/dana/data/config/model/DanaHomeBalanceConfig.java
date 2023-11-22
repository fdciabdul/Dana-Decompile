package id.dana.data.config.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0007R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\f"}, d2 = {"Lid/dana/data/config/model/DanaHomeBalanceConfig;", "", "", "component1", "()Z", "", "component2", "()J", "component3", "", "", "component4", "()Ljava/util/List;", "enable", "loopUntilInMillis", "delayInMillis", "services", "copy", "(ZJJLjava/util/List;)Lid/dana/data/config/model/DanaHomeBalanceConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "J", "getDelayInMillis", "Z", "getEnable", "getLoopUntilInMillis", "Ljava/util/List;", "getServices", "<init>", "(ZJJLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DanaHomeBalanceConfig {
    public long delayInMillis;
    public boolean enable;
    public long loopUntilInMillis;
    public List<String> services;

    public DanaHomeBalanceConfig() {
        this(false, 0L, 0L, null, 15, null);
    }

    public static /* synthetic */ DanaHomeBalanceConfig copy$default(DanaHomeBalanceConfig danaHomeBalanceConfig, boolean z, long j, long j2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = danaHomeBalanceConfig.enable;
        }
        if ((i & 2) != 0) {
            j = danaHomeBalanceConfig.loopUntilInMillis;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = danaHomeBalanceConfig.delayInMillis;
        }
        long j4 = j2;
        List<String> list2 = list;
        if ((i & 8) != 0) {
            list2 = danaHomeBalanceConfig.services;
        }
        return danaHomeBalanceConfig.copy(z, j3, j4, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final long getLoopUntilInMillis() {
        return this.loopUntilInMillis;
    }

    /* renamed from: component3  reason: from getter */
    public final long getDelayInMillis() {
        return this.delayInMillis;
    }

    public final List<String> component4() {
        return this.services;
    }

    public final DanaHomeBalanceConfig copy(boolean enable, long loopUntilInMillis, long delayInMillis, List<String> services) {
        Intrinsics.checkNotNullParameter(services, "");
        return new DanaHomeBalanceConfig(enable, loopUntilInMillis, delayInMillis, services);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaHomeBalanceConfig) {
            DanaHomeBalanceConfig danaHomeBalanceConfig = (DanaHomeBalanceConfig) other;
            return this.enable == danaHomeBalanceConfig.enable && this.loopUntilInMillis == danaHomeBalanceConfig.loopUntilInMillis && this.delayInMillis == danaHomeBalanceConfig.delayInMillis && Intrinsics.areEqual(this.services, danaHomeBalanceConfig.services);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.loopUntilInMillis)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.delayInMillis)) * 31) + this.services.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaHomeBalanceConfig(enable=");
        sb.append(this.enable);
        sb.append(", loopUntilInMillis=");
        sb.append(this.loopUntilInMillis);
        sb.append(", delayInMillis=");
        sb.append(this.delayInMillis);
        sb.append(", services=");
        sb.append(this.services);
        sb.append(')');
        return sb.toString();
    }

    public DanaHomeBalanceConfig(boolean z, long j, long j2, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.enable = z;
        this.loopUntilInMillis = j;
        this.delayInMillis = j2;
        this.services = list;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getLoopUntilInMillis")
    public final long getLoopUntilInMillis() {
        return this.loopUntilInMillis;
    }

    @JvmName(name = "getDelayInMillis")
    public final long getDelayInMillis() {
        return this.delayInMillis;
    }

    public /* synthetic */ DanaHomeBalanceConfig(boolean z, long j, long j2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 6000L : j, (i & 4) != 0 ? 3000L : j2, (i & 8) != 0 ? CollectionsKt.listOf((Object[]) new String[]{"service_balance", "service_investment"}) : list);
    }

    @JvmName(name = "getServices")
    public final List<String> getServices() {
        return this.services;
    }
}
