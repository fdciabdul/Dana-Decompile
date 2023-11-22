package id.dana.domain.saving.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/saving/model/SavingWithdrawInitRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "savingId", "withdrawMethod", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/saving/model/SavingWithdrawInitRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSavingId", "getWithdrawMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingWithdrawInitRequest {
    private final String savingId;
    private final String withdrawMethod;

    public static /* synthetic */ SavingWithdrawInitRequest copy$default(SavingWithdrawInitRequest savingWithdrawInitRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = savingWithdrawInitRequest.savingId;
        }
        if ((i & 2) != 0) {
            str2 = savingWithdrawInitRequest.withdrawMethod;
        }
        return savingWithdrawInitRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getWithdrawMethod() {
        return this.withdrawMethod;
    }

    public final SavingWithdrawInitRequest copy(String savingId, String withdrawMethod) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(withdrawMethod, "");
        return new SavingWithdrawInitRequest(savingId, withdrawMethod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingWithdrawInitRequest) {
            SavingWithdrawInitRequest savingWithdrawInitRequest = (SavingWithdrawInitRequest) other;
            return Intrinsics.areEqual(this.savingId, savingWithdrawInitRequest.savingId) && Intrinsics.areEqual(this.withdrawMethod, savingWithdrawInitRequest.withdrawMethod);
        }
        return false;
    }

    public final int hashCode() {
        return (this.savingId.hashCode() * 31) + this.withdrawMethod.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingWithdrawInitRequest(savingId=");
        sb.append(this.savingId);
        sb.append(", withdrawMethod=");
        sb.append(this.withdrawMethod);
        sb.append(')');
        return sb.toString();
    }

    public SavingWithdrawInitRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.savingId = str;
        this.withdrawMethod = str2;
    }

    @JvmName(name = "getSavingId")
    public final String getSavingId() {
        return this.savingId;
    }

    @JvmName(name = "getWithdrawMethod")
    public final String getWithdrawMethod() {
        return this.withdrawMethod;
    }
}
