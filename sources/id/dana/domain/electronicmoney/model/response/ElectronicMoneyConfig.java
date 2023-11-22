package id.dana.domain.electronicmoney.model.response;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyConfig;", "Ljava/io/Serializable;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "enable", "name", "copy", "(ZLjava/lang/String;)Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyConfig;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getEnable", "Ljava/lang/String;", "getName", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ElectronicMoneyConfig implements Serializable {
    private final boolean enable;
    private final String name;

    public static /* synthetic */ ElectronicMoneyConfig copy$default(ElectronicMoneyConfig electronicMoneyConfig, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = electronicMoneyConfig.enable;
        }
        if ((i & 2) != 0) {
            str = electronicMoneyConfig.name;
        }
        return electronicMoneyConfig.copy(z, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ElectronicMoneyConfig copy(boolean enable, String name) {
        return new ElectronicMoneyConfig(enable, name);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ElectronicMoneyConfig) {
            ElectronicMoneyConfig electronicMoneyConfig = (ElectronicMoneyConfig) other;
            return this.enable == electronicMoneyConfig.enable && Intrinsics.areEqual(this.name, electronicMoneyConfig.name);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.name;
        return (r0 * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ElectronicMoneyConfig(enable=");
        sb.append(this.enable);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(')');
        return sb.toString();
    }

    public ElectronicMoneyConfig(boolean z, String str) {
        this.enable = z;
        this.name = str;
    }

    public /* synthetic */ ElectronicMoneyConfig(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, str);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }
}
