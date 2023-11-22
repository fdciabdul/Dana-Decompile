package id.dana.domain.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "fundOrderId", "fundType", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getFundOrderId", "getFundType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RejectSendMoneyRequest {
    private final String fundOrderId;
    private final String fundType;

    public static /* synthetic */ RejectSendMoneyRequest copy$default(RejectSendMoneyRequest rejectSendMoneyRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rejectSendMoneyRequest.fundOrderId;
        }
        if ((i & 2) != 0) {
            str2 = rejectSendMoneyRequest.fundType;
        }
        return rejectSendMoneyRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getFundType() {
        return this.fundType;
    }

    public final RejectSendMoneyRequest copy(String fundOrderId, String fundType) {
        Intrinsics.checkNotNullParameter(fundOrderId, "");
        Intrinsics.checkNotNullParameter(fundType, "");
        return new RejectSendMoneyRequest(fundOrderId, fundType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RejectSendMoneyRequest) {
            RejectSendMoneyRequest rejectSendMoneyRequest = (RejectSendMoneyRequest) other;
            return Intrinsics.areEqual(this.fundOrderId, rejectSendMoneyRequest.fundOrderId) && Intrinsics.areEqual(this.fundType, rejectSendMoneyRequest.fundType);
        }
        return false;
    }

    public final int hashCode() {
        return (this.fundOrderId.hashCode() * 31) + this.fundType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RejectSendMoneyRequest(fundOrderId=");
        sb.append(this.fundOrderId);
        sb.append(", fundType=");
        sb.append(this.fundType);
        sb.append(')');
        return sb.toString();
    }

    public RejectSendMoneyRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.fundOrderId = str;
        this.fundType = str2;
    }

    @JvmName(name = "getFundOrderId")
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    @JvmName(name = "getFundType")
    public final String getFundType() {
        return this.fundType;
    }
}
