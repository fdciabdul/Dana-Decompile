package id.dana.data.config.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\u0012\b\b\u0003\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/config/model/SyncPermissionConfig;", "", "", "component1", "()J", "", "component2", "()Z", "intervalTimeInMillis", "enable", "copy", "(JZ)Lid/dana/data/config/model/SyncPermissionConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getEnable", "J", "getIntervalTimeInMillis", "<init>", "(JZ)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SyncPermissionConfig {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @SerializedName("enable")
    private final boolean enable;
    @SerializedName("interval_time_in_millis")
    private final long intervalTimeInMillis;

    public SyncPermissionConfig() {
        this(0L, false, 3, null);
    }

    public static /* synthetic */ SyncPermissionConfig copy$default(SyncPermissionConfig syncPermissionConfig, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = syncPermissionConfig.intervalTimeInMillis;
        }
        if ((i & 2) != 0) {
            z = syncPermissionConfig.enable;
        }
        return syncPermissionConfig.copy(j, z);
    }

    /* renamed from: component1  reason: from getter */
    public final long getIntervalTimeInMillis() {
        return this.intervalTimeInMillis;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    public final SyncPermissionConfig copy(@JSONField(name = "interval_time_in_millis") long intervalTimeInMillis, @JSONField(name = "enable") boolean enable) {
        return new SyncPermissionConfig(intervalTimeInMillis, enable);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SyncPermissionConfig) {
            SyncPermissionConfig syncPermissionConfig = (SyncPermissionConfig) other;
            return this.intervalTimeInMillis == syncPermissionConfig.intervalTimeInMillis && this.enable == syncPermissionConfig.enable;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.intervalTimeInMillis);
        boolean z = this.enable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (m * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SyncPermissionConfig(intervalTimeInMillis=");
        sb.append(this.intervalTimeInMillis);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(')');
        return sb.toString();
    }

    public SyncPermissionConfig(@JSONField(name = "interval_time_in_millis") long j, @JSONField(name = "enable") boolean z) {
        this.intervalTimeInMillis = j;
        this.enable = z;
    }

    public /* synthetic */ SyncPermissionConfig(long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z);
    }

    @JvmName(name = "getIntervalTimeInMillis")
    public final long getIntervalTimeInMillis() {
        return this.intervalTimeInMillis;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/config/model/SyncPermissionConfig$Companion;", "", "Lid/dana/data/config/model/SyncPermissionConfig;", "default", "()Lid/dana/data/config/model/SyncPermissionConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: default  reason: not valid java name */
        public final SyncPermissionConfig m834default() {
            return new SyncPermissionConfig(0L, false);
        }
    }
}
