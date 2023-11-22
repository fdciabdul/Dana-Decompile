package id.dana.biometric.data.source.local;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\f\u001a\u00020\u0002\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJJ\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\f\u001a\u00020\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\u001eR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\u001eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\u001eR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010*"}, d2 = {"Lid/dana/biometric/data/source/local/RiskTrackerConfigEntity;", "", "", "component1", "()Z", "component2", "()Ljava/lang/Boolean;", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "enable", "gyroscopeDataTracker", "accelerometerDataTracker", "keystrokeDataTracker", "maxRequestLimitInHour", "copy", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lid/dana/biometric/data/source/local/RiskTrackerConfigEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getAccelerometerDataTracker", "setAccelerometerDataTracker", "(Ljava/lang/Boolean;)V", "Z", "getEnable", "setEnable", "(Z)V", "getGyroscopeDataTracker", "setGyroscopeDataTracker", "getKeystrokeDataTracker", "setKeystrokeDataTracker", "Ljava/lang/Integer;", "getMaxRequestLimitInHour", "setMaxRequestLimitInHour", "(Ljava/lang/Integer;)V", "<init>", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RiskTrackerConfigEntity {
    public Boolean accelerometerDataTracker;
    public boolean enable;
    public Boolean gyroscopeDataTracker;
    public Boolean keystrokeDataTracker;
    public Integer maxRequestLimitInHour;

    public /* synthetic */ RiskTrackerConfigEntity() {
    }

    public static /* synthetic */ RiskTrackerConfigEntity copy$default(RiskTrackerConfigEntity riskTrackerConfigEntity, boolean z, Boolean bool, Boolean bool2, Boolean bool3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z = riskTrackerConfigEntity.enable;
        }
        if ((i & 2) != 0) {
            bool = riskTrackerConfigEntity.gyroscopeDataTracker;
        }
        Boolean bool4 = bool;
        if ((i & 4) != 0) {
            bool2 = riskTrackerConfigEntity.accelerometerDataTracker;
        }
        Boolean bool5 = bool2;
        if ((i & 8) != 0) {
            bool3 = riskTrackerConfigEntity.keystrokeDataTracker;
        }
        Boolean bool6 = bool3;
        if ((i & 16) != 0) {
            num = riskTrackerConfigEntity.maxRequestLimitInHour;
        }
        return riskTrackerConfigEntity.copy(z, bool4, bool5, bool6, num);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getGyroscopeDataTracker() {
        return this.gyroscopeDataTracker;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getAccelerometerDataTracker() {
        return this.accelerometerDataTracker;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getKeystrokeDataTracker() {
        return this.keystrokeDataTracker;
    }

    /* renamed from: component5  reason: from getter */
    public final Integer getMaxRequestLimitInHour() {
        return this.maxRequestLimitInHour;
    }

    public final RiskTrackerConfigEntity copy(@JSONField(name = "enable") boolean enable, @JSONField(name = "gyroscopeDataTracker") Boolean gyroscopeDataTracker, @JSONField(name = "accelerometerDataTracker") Boolean accelerometerDataTracker, @JSONField(name = "keystrokeDataTracker") Boolean keystrokeDataTracker, @JSONField(name = "request_limit_for_home_page") Integer maxRequestLimitInHour) {
        return new RiskTrackerConfigEntity(enable, gyroscopeDataTracker, accelerometerDataTracker, keystrokeDataTracker, maxRequestLimitInHour);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RiskTrackerConfigEntity) {
            RiskTrackerConfigEntity riskTrackerConfigEntity = (RiskTrackerConfigEntity) other;
            return this.enable == riskTrackerConfigEntity.enable && Intrinsics.areEqual(this.gyroscopeDataTracker, riskTrackerConfigEntity.gyroscopeDataTracker) && Intrinsics.areEqual(this.accelerometerDataTracker, riskTrackerConfigEntity.accelerometerDataTracker) && Intrinsics.areEqual(this.keystrokeDataTracker, riskTrackerConfigEntity.keystrokeDataTracker) && Intrinsics.areEqual(this.maxRequestLimitInHour, riskTrackerConfigEntity.maxRequestLimitInHour);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        Boolean bool = this.gyroscopeDataTracker;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.accelerometerDataTracker;
        int hashCode2 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.keystrokeDataTracker;
        int hashCode3 = bool3 == null ? 0 : bool3.hashCode();
        Integer num = this.maxRequestLimitInHour;
        return (((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskTrackerConfigEntity(enable=");
        sb.append(this.enable);
        sb.append(", gyroscopeDataTracker=");
        sb.append(this.gyroscopeDataTracker);
        sb.append(", accelerometerDataTracker=");
        sb.append(this.accelerometerDataTracker);
        sb.append(", keystrokeDataTracker=");
        sb.append(this.keystrokeDataTracker);
        sb.append(", maxRequestLimitInHour=");
        sb.append(this.maxRequestLimitInHour);
        sb.append(')');
        return sb.toString();
    }

    public RiskTrackerConfigEntity(@JSONField(name = "enable") boolean z, @JSONField(name = "gyroscopeDataTracker") Boolean bool, @JSONField(name = "accelerometerDataTracker") Boolean bool2, @JSONField(name = "keystrokeDataTracker") Boolean bool3, @JSONField(name = "request_limit_for_home_page") Integer num) {
        this.enable = z;
        this.gyroscopeDataTracker = bool;
        this.accelerometerDataTracker = bool2;
        this.keystrokeDataTracker = bool3;
        this.maxRequestLimitInHour = num;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.enable = z;
    }

    @JvmName(name = "getGyroscopeDataTracker")
    public final Boolean getGyroscopeDataTracker() {
        return this.gyroscopeDataTracker;
    }

    @JvmName(name = "setGyroscopeDataTracker")
    public final void setGyroscopeDataTracker(Boolean bool) {
        this.gyroscopeDataTracker = bool;
    }

    @JvmName(name = "getAccelerometerDataTracker")
    public final Boolean getAccelerometerDataTracker() {
        return this.accelerometerDataTracker;
    }

    @JvmName(name = "setAccelerometerDataTracker")
    public final void setAccelerometerDataTracker(Boolean bool) {
        this.accelerometerDataTracker = bool;
    }

    @JvmName(name = "getKeystrokeDataTracker")
    public final Boolean getKeystrokeDataTracker() {
        return this.keystrokeDataTracker;
    }

    @JvmName(name = "setKeystrokeDataTracker")
    public final void setKeystrokeDataTracker(Boolean bool) {
        this.keystrokeDataTracker = bool;
    }

    @JvmName(name = "getMaxRequestLimitInHour")
    public final Integer getMaxRequestLimitInHour() {
        return this.maxRequestLimitInHour;
    }

    @JvmName(name = "setMaxRequestLimitInHour")
    public final void setMaxRequestLimitInHour(Integer num) {
        this.maxRequestLimitInHour = num;
    }
}
