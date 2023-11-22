package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/domain/featureconfig/model/DexguardIntegrityCheckConfig;", "", "", "component1", "()Z", "component2", "component3", "dexguardRootCheckConfig", "dexguardHookCheckConfig", "dexguardTamperCheckConfig", "copy", "(ZZZ)Lid/dana/domain/featureconfig/model/DexguardIntegrityCheckConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getDexguardHookCheckConfig", "getDexguardRootCheckConfig", "getDexguardTamperCheckConfig", "<init>", "(ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class DexguardIntegrityCheckConfig {
    private final boolean dexguardHookCheckConfig;
    private final boolean dexguardRootCheckConfig;
    private final boolean dexguardTamperCheckConfig;

    public DexguardIntegrityCheckConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ DexguardIntegrityCheckConfig copy$default(DexguardIntegrityCheckConfig dexguardIntegrityCheckConfig, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dexguardIntegrityCheckConfig.dexguardRootCheckConfig;
        }
        if ((i & 2) != 0) {
            z2 = dexguardIntegrityCheckConfig.dexguardHookCheckConfig;
        }
        if ((i & 4) != 0) {
            z3 = dexguardIntegrityCheckConfig.dexguardTamperCheckConfig;
        }
        return dexguardIntegrityCheckConfig.copy(z, z2, z3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getDexguardRootCheckConfig() {
        return this.dexguardRootCheckConfig;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getDexguardHookCheckConfig() {
        return this.dexguardHookCheckConfig;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getDexguardTamperCheckConfig() {
        return this.dexguardTamperCheckConfig;
    }

    public final DexguardIntegrityCheckConfig copy(boolean dexguardRootCheckConfig, boolean dexguardHookCheckConfig, boolean dexguardTamperCheckConfig) {
        return new DexguardIntegrityCheckConfig(dexguardRootCheckConfig, dexguardHookCheckConfig, dexguardTamperCheckConfig);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DexguardIntegrityCheckConfig) {
            DexguardIntegrityCheckConfig dexguardIntegrityCheckConfig = (DexguardIntegrityCheckConfig) other;
            return this.dexguardRootCheckConfig == dexguardIntegrityCheckConfig.dexguardRootCheckConfig && this.dexguardHookCheckConfig == dexguardIntegrityCheckConfig.dexguardHookCheckConfig && this.dexguardTamperCheckConfig == dexguardIntegrityCheckConfig.dexguardTamperCheckConfig;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.dexguardRootCheckConfig;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.dexguardHookCheckConfig;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        boolean z2 = this.dexguardTamperCheckConfig;
        return (((r0 * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DexguardIntegrityCheckConfig(dexguardRootCheckConfig=");
        sb.append(this.dexguardRootCheckConfig);
        sb.append(", dexguardHookCheckConfig=");
        sb.append(this.dexguardHookCheckConfig);
        sb.append(", dexguardTamperCheckConfig=");
        sb.append(this.dexguardTamperCheckConfig);
        sb.append(')');
        return sb.toString();
    }

    public DexguardIntegrityCheckConfig(boolean z, boolean z2, boolean z3) {
        this.dexguardRootCheckConfig = z;
        this.dexguardHookCheckConfig = z2;
        this.dexguardTamperCheckConfig = z3;
    }

    public /* synthetic */ DexguardIntegrityCheckConfig(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    @JvmName(name = "getDexguardRootCheckConfig")
    public final boolean getDexguardRootCheckConfig() {
        return this.dexguardRootCheckConfig;
    }

    @JvmName(name = "getDexguardHookCheckConfig")
    public final boolean getDexguardHookCheckConfig() {
        return this.dexguardHookCheckConfig;
    }

    @JvmName(name = "getDexguardTamperCheckConfig")
    public final boolean getDexguardTamperCheckConfig() {
        return this.dexguardTamperCheckConfig;
    }
}
