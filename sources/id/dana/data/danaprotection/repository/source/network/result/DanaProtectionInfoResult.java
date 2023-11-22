package id.dana.data.danaprotection.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.danaprotection.DanaProtectionKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", DanaProtectionKey.DanaProtectionResultParamsKey.PROTECTED_ACTIVITY, "suspiciousActivity", "timeRange", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getProtectedActivity", "getSuspiciousActivity", "getTimeRange", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DanaProtectionInfoResult extends BaseRpcResult {
    public Integer protectedActivity;
    public Integer suspiciousActivity;
    public Integer timeRange;

    public DanaProtectionInfoResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DanaProtectionInfoResult copy$default(DanaProtectionInfoResult danaProtectionInfoResult, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = danaProtectionInfoResult.protectedActivity;
        }
        if ((i & 2) != 0) {
            num2 = danaProtectionInfoResult.suspiciousActivity;
        }
        if ((i & 4) != 0) {
            num3 = danaProtectionInfoResult.timeRange;
        }
        return danaProtectionInfoResult.copy(num, num2, num3);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getProtectedActivity() {
        return this.protectedActivity;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getSuspiciousActivity() {
        return this.suspiciousActivity;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getTimeRange() {
        return this.timeRange;
    }

    public final DanaProtectionInfoResult copy(Integer protectedActivity, Integer suspiciousActivity, Integer timeRange) {
        return new DanaProtectionInfoResult(protectedActivity, suspiciousActivity, timeRange);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaProtectionInfoResult) {
            DanaProtectionInfoResult danaProtectionInfoResult = (DanaProtectionInfoResult) other;
            return Intrinsics.areEqual(this.protectedActivity, danaProtectionInfoResult.protectedActivity) && Intrinsics.areEqual(this.suspiciousActivity, danaProtectionInfoResult.suspiciousActivity) && Intrinsics.areEqual(this.timeRange, danaProtectionInfoResult.timeRange);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.protectedActivity;
        int hashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.suspiciousActivity;
        int hashCode2 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.timeRange;
        return (((hashCode * 31) + hashCode2) * 31) + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaProtectionInfoResult(protectedActivity=");
        sb.append(this.protectedActivity);
        sb.append(", suspiciousActivity=");
        sb.append(this.suspiciousActivity);
        sb.append(", timeRange=");
        sb.append(this.timeRange);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ DanaProtectionInfoResult(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
    }

    @JvmName(name = "getProtectedActivity")
    public final Integer getProtectedActivity() {
        return this.protectedActivity;
    }

    @JvmName(name = "getSuspiciousActivity")
    public final Integer getSuspiciousActivity() {
        return this.suspiciousActivity;
    }

    @JvmName(name = "getTimeRange")
    public final Integer getTimeRange() {
        return this.timeRange;
    }

    public DanaProtectionInfoResult(Integer num, Integer num2, Integer num3) {
        this.protectedActivity = num;
        this.suspiciousActivity = num2;
        this.timeRange = num3;
    }
}
