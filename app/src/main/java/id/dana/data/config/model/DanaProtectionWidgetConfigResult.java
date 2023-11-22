package id.dana.data.config.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\t\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/data/config/model/DanaProtectionWidgetConfigResult;", "", "", "component1", "()Z", "component2", "", "component3", "()I", "isApiToggleEnabled", "isNewWidgetEnabled", "expiredCacheTimeInMinute", "copy", "(ZZI)Lid/dana/data/config/model/DanaProtectionWidgetConfigResult;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getExpiredCacheTimeInMinute", "Z", "<init>", "(ZZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DanaProtectionWidgetConfigResult {
    @SerializedName("expired_cache_time_in_minute")
    private final int expiredCacheTimeInMinute;
    @SerializedName("is_api_toggle_enabled")
    private final boolean isApiToggleEnabled;
    @SerializedName("is_new_widget_enabled")
    private final boolean isNewWidgetEnabled;

    public DanaProtectionWidgetConfigResult() {
        this(false, false, 0, 7, null);
    }

    public static /* synthetic */ DanaProtectionWidgetConfigResult copy$default(DanaProtectionWidgetConfigResult danaProtectionWidgetConfigResult, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = danaProtectionWidgetConfigResult.isApiToggleEnabled;
        }
        if ((i2 & 2) != 0) {
            z2 = danaProtectionWidgetConfigResult.isNewWidgetEnabled;
        }
        if ((i2 & 4) != 0) {
            i = danaProtectionWidgetConfigResult.expiredCacheTimeInMinute;
        }
        return danaProtectionWidgetConfigResult.copy(z, z2, i);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getIsApiToggleEnabled() {
        return this.isApiToggleEnabled;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getIsNewWidgetEnabled() {
        return this.isNewWidgetEnabled;
    }

    /* renamed from: component3  reason: from getter */
    public final int getExpiredCacheTimeInMinute() {
        return this.expiredCacheTimeInMinute;
    }

    public final DanaProtectionWidgetConfigResult copy(boolean isApiToggleEnabled, boolean isNewWidgetEnabled, int expiredCacheTimeInMinute) {
        return new DanaProtectionWidgetConfigResult(isApiToggleEnabled, isNewWidgetEnabled, expiredCacheTimeInMinute);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaProtectionWidgetConfigResult) {
            DanaProtectionWidgetConfigResult danaProtectionWidgetConfigResult = (DanaProtectionWidgetConfigResult) other;
            return this.isApiToggleEnabled == danaProtectionWidgetConfigResult.isApiToggleEnabled && this.isNewWidgetEnabled == danaProtectionWidgetConfigResult.isNewWidgetEnabled && this.expiredCacheTimeInMinute == danaProtectionWidgetConfigResult.expiredCacheTimeInMinute;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.isApiToggleEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        boolean z2 = this.isNewWidgetEnabled;
        return (((r0 * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.expiredCacheTimeInMinute;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaProtectionWidgetConfigResult(isApiToggleEnabled=");
        sb.append(this.isApiToggleEnabled);
        sb.append(", isNewWidgetEnabled=");
        sb.append(this.isNewWidgetEnabled);
        sb.append(", expiredCacheTimeInMinute=");
        sb.append(this.expiredCacheTimeInMinute);
        sb.append(')');
        return sb.toString();
    }

    public DanaProtectionWidgetConfigResult(boolean z, boolean z2, int i) {
        this.isApiToggleEnabled = z;
        this.isNewWidgetEnabled = z2;
        this.expiredCacheTimeInMinute = i;
    }

    public /* synthetic */ DanaProtectionWidgetConfigResult(boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "isApiToggleEnabled")
    public final boolean isApiToggleEnabled() {
        return this.isApiToggleEnabled;
    }

    @JvmName(name = "isNewWidgetEnabled")
    public final boolean isNewWidgetEnabled() {
        return this.isNewWidgetEnabled;
    }

    @JvmName(name = "getExpiredCacheTimeInMinute")
    public final int getExpiredCacheTimeInMinute() {
        return this.expiredCacheTimeInMinute;
    }
}
