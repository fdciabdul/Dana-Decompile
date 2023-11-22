package id.dana.cashier.data.repository.source.network.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/ProcessingMilestoneResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Long;", "configId", "milestoneDetail", "milestoneEnd", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lid/dana/cashier/data/repository/source/network/result/ProcessingMilestoneResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getConfigId", "getMilestoneDetail", "Ljava/lang/Long;", "getMilestoneEnd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ProcessingMilestoneResult {
    private final String configId;
    private final String milestoneDetail;
    private final Long milestoneEnd;

    public ProcessingMilestoneResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ProcessingMilestoneResult copy$default(ProcessingMilestoneResult processingMilestoneResult, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = processingMilestoneResult.configId;
        }
        if ((i & 2) != 0) {
            str2 = processingMilestoneResult.milestoneDetail;
        }
        if ((i & 4) != 0) {
            l = processingMilestoneResult.milestoneEnd;
        }
        return processingMilestoneResult.copy(str, str2, l);
    }

    /* renamed from: component1  reason: from getter */
    public final String getConfigId() {
        return this.configId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMilestoneDetail() {
        return this.milestoneDetail;
    }

    /* renamed from: component3  reason: from getter */
    public final Long getMilestoneEnd() {
        return this.milestoneEnd;
    }

    public final ProcessingMilestoneResult copy(String configId, String milestoneDetail, Long milestoneEnd) {
        return new ProcessingMilestoneResult(configId, milestoneDetail, milestoneEnd);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProcessingMilestoneResult) {
            ProcessingMilestoneResult processingMilestoneResult = (ProcessingMilestoneResult) other;
            return Intrinsics.areEqual(this.configId, processingMilestoneResult.configId) && Intrinsics.areEqual(this.milestoneDetail, processingMilestoneResult.milestoneDetail) && Intrinsics.areEqual(this.milestoneEnd, processingMilestoneResult.milestoneEnd);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.configId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.milestoneDetail;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Long l = this.milestoneEnd;
        return (((hashCode * 31) + hashCode2) * 31) + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessingMilestoneResult(configId=");
        sb.append(this.configId);
        sb.append(", milestoneDetail=");
        sb.append(this.milestoneDetail);
        sb.append(", milestoneEnd=");
        sb.append(this.milestoneEnd);
        sb.append(')');
        return sb.toString();
    }

    public ProcessingMilestoneResult(String str, String str2, Long l) {
        this.configId = str;
        this.milestoneDetail = str2;
        this.milestoneEnd = l;
    }

    public /* synthetic */ ProcessingMilestoneResult(String str, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l);
    }

    @JvmName(name = "getConfigId")
    public final String getConfigId() {
        return this.configId;
    }

    @JvmName(name = "getMilestoneDetail")
    public final String getMilestoneDetail() {
        return this.milestoneDetail;
    }

    @JvmName(name = "getMilestoneEnd")
    public final Long getMilestoneEnd() {
        return this.milestoneEnd;
    }
}
