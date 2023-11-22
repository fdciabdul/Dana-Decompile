package id.dana.domain.danaprotection.model;

import id.dana.danah5.danaprotection.DanaProtectionKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "", "", "component1", "()I", "component2", "component3", DanaProtectionKey.DanaProtectionResultParamsKey.PROTECTED_ACTIVITY, "suspiciousActivity", "timeRange", "copy", "(III)Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getProtectedActivity", "getSuspiciousActivity", "getTimeRange", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DanaProtectionInfoModel {
    private final int protectedActivity;
    private final int suspiciousActivity;
    private final int timeRange;

    public DanaProtectionInfoModel() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ DanaProtectionInfoModel copy$default(DanaProtectionInfoModel danaProtectionInfoModel, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = danaProtectionInfoModel.protectedActivity;
        }
        if ((i4 & 2) != 0) {
            i2 = danaProtectionInfoModel.suspiciousActivity;
        }
        if ((i4 & 4) != 0) {
            i3 = danaProtectionInfoModel.timeRange;
        }
        return danaProtectionInfoModel.copy(i, i2, i3);
    }

    /* renamed from: component1  reason: from getter */
    public final int getProtectedActivity() {
        return this.protectedActivity;
    }

    /* renamed from: component2  reason: from getter */
    public final int getSuspiciousActivity() {
        return this.suspiciousActivity;
    }

    /* renamed from: component3  reason: from getter */
    public final int getTimeRange() {
        return this.timeRange;
    }

    public final DanaProtectionInfoModel copy(int protectedActivity, int suspiciousActivity, int timeRange) {
        return new DanaProtectionInfoModel(protectedActivity, suspiciousActivity, timeRange);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaProtectionInfoModel) {
            DanaProtectionInfoModel danaProtectionInfoModel = (DanaProtectionInfoModel) other;
            return this.protectedActivity == danaProtectionInfoModel.protectedActivity && this.suspiciousActivity == danaProtectionInfoModel.suspiciousActivity && this.timeRange == danaProtectionInfoModel.timeRange;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.protectedActivity * 31) + this.suspiciousActivity) * 31) + this.timeRange;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaProtectionInfoModel(protectedActivity=");
        sb.append(this.protectedActivity);
        sb.append(", suspiciousActivity=");
        sb.append(this.suspiciousActivity);
        sb.append(", timeRange=");
        sb.append(this.timeRange);
        sb.append(')');
        return sb.toString();
    }

    public DanaProtectionInfoModel(int i, int i2, int i3) {
        this.protectedActivity = i;
        this.suspiciousActivity = i2;
        this.timeRange = i3;
    }

    public /* synthetic */ DanaProtectionInfoModel(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    @JvmName(name = "getProtectedActivity")
    public final int getProtectedActivity() {
        return this.protectedActivity;
    }

    @JvmName(name = "getSuspiciousActivity")
    public final int getSuspiciousActivity() {
        return this.suspiciousActivity;
    }

    @JvmName(name = "getTimeRange")
    public final int getTimeRange() {
        return this.timeRange;
    }
}
