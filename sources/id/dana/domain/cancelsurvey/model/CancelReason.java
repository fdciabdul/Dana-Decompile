package id.dana.domain.cancelsurvey.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/cancelsurvey/model/CancelReason;", "", "", "component1", "()Ljava/lang/String;", "component2", "reasonCode", "reasonMsg", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/cancelsurvey/model/CancelReason;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getReasonCode", "getReasonMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CancelReason {
    private final String reasonCode;
    private final String reasonMsg;

    public static /* synthetic */ CancelReason copy$default(CancelReason cancelReason, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelReason.reasonCode;
        }
        if ((i & 2) != 0) {
            str2 = cancelReason.reasonMsg;
        }
        return cancelReason.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getReasonCode() {
        return this.reasonCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getReasonMsg() {
        return this.reasonMsg;
    }

    public final CancelReason copy(String reasonCode, String reasonMsg) {
        Intrinsics.checkNotNullParameter(reasonCode, "");
        Intrinsics.checkNotNullParameter(reasonMsg, "");
        return new CancelReason(reasonCode, reasonMsg);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CancelReason) {
            CancelReason cancelReason = (CancelReason) other;
            return Intrinsics.areEqual(this.reasonCode, cancelReason.reasonCode) && Intrinsics.areEqual(this.reasonMsg, cancelReason.reasonMsg);
        }
        return false;
    }

    public final int hashCode() {
        return (this.reasonCode.hashCode() * 31) + this.reasonMsg.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CancelReason(reasonCode=");
        sb.append(this.reasonCode);
        sb.append(", reasonMsg=");
        sb.append(this.reasonMsg);
        sb.append(')');
        return sb.toString();
    }

    public CancelReason(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.reasonCode = str;
        this.reasonMsg = str2;
    }

    @JvmName(name = "getReasonCode")
    public final String getReasonCode() {
        return this.reasonCode;
    }

    @JvmName(name = "getReasonMsg")
    public final String getReasonMsg() {
        return this.reasonMsg;
    }
}
