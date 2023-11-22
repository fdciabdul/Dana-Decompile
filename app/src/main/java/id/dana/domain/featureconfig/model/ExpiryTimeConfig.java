package id.dana.domain.featureconfig.model;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\"\u0010\u000b\u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000b\u0010\b\"\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001b"}, d2 = {"Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "value", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "isDefault", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "setDefault", "(Z)V", "Ljava/lang/String;", "getUnit", "setUnit", "(Ljava/lang/String;)V", "getValue", "setValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ExpiryTimeConfig {
    private boolean isDefault;
    private String unit;
    private String value;

    public ExpiryTimeConfig() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ ExpiryTimeConfig copy$default(ExpiryTimeConfig expiryTimeConfig, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expiryTimeConfig.value;
        }
        if ((i & 2) != 0) {
            str2 = expiryTimeConfig.unit;
        }
        if ((i & 4) != 0) {
            z = expiryTimeConfig.isDefault;
        }
        return expiryTimeConfig.copy(str, str2, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public final ExpiryTimeConfig copy(String value, String unit, boolean isDefault) {
        Intrinsics.checkNotNullParameter(value, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return new ExpiryTimeConfig(value, unit, isDefault);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExpiryTimeConfig) {
            ExpiryTimeConfig expiryTimeConfig = (ExpiryTimeConfig) other;
            return Intrinsics.areEqual(this.value, expiryTimeConfig.value) && Intrinsics.areEqual(this.unit, expiryTimeConfig.unit) && this.isDefault == expiryTimeConfig.isDefault;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.value.hashCode();
        int hashCode2 = this.unit.hashCode();
        boolean z = this.isDefault;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpiryTimeConfig(value=");
        sb.append(this.value);
        sb.append(", unit=");
        sb.append(this.unit);
        sb.append(", isDefault=");
        sb.append(this.isDefault);
        sb.append(')');
        return sb.toString();
    }

    public ExpiryTimeConfig(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.value = str;
        this.unit = str2;
        this.isDefault = z;
    }

    public /* synthetic */ ExpiryTimeConfig(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }

    @JvmName(name = "setValue")
    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.value = str;
    }

    @JvmName(name = "getUnit")
    public final String getUnit() {
        return this.unit;
    }

    @JvmName(name = "setUnit")
    public final void setUnit(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.unit = str;
    }

    @JvmName(name = "isDefault")
    public final boolean isDefault() {
        return this.isDefault;
    }

    @JvmName(name = "setDefault")
    public final void setDefault(boolean z) {
        this.isDefault = z;
    }
}
